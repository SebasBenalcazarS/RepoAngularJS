package ec.com.smx.sic.articulo.persistence.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.transform.Transformers;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.corpv2.etiquetado.commons.constantes.EtiquetadoConstantes;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.solicitudImpresion.bean.EstructuraArticuloProveedorSolImpresion;
import ec.com.smx.sic.cliente.common.articulo.solicitudImpresion.bean.EstructuraArticuloSolImpresion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
/**
 * 
 * @author aquingaluisa
 *
 */
public class ArticuloSolicitudImpresionDAO implements Logeable {
	private IHibernateH<ArticuloDTO> hibernateH;
	private IHibernateH<ArticuloProveedorDTO> hibernateHArtProv;
	private IHibernateH<ArticuloEtiquetaDTO> hibernateHArtEti;
	private final Boolean activar_like = Boolean.TRUE;
	private final Boolean borrar_cache = Boolean.TRUE;
	
	
	
	/**
	 * **********************************************DAO PARA LA PANTALLA DE BUSQUEDA*******************************
	 */
	
	
	/**
	 * **********************************************DAO PARA LA PANTALLA DE DETALLE********************
	 */
	
	/**
	 * Metodo para obtener  una coleccion de articulos por la busqueda
	 * @param articuloPlantilla
	 * @param maximoArticulos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public SearchResultDTO<ArticuloDTO> obtenerArticulosAgrupadosBusqueda(ArticuloDTO articuloPlantilla,Integer maximoArticulos) throws SICException{
		SearchResultDTO<ArticuloDTO> resultDTO = new SearchResultDTO<ArticuloDTO>();
		Criteria select;
		Session session;
		Boolean enableLike = Boolean.TRUE;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			select = hibernateH.getCriteriaQuery(articuloPlantilla, borrar_cache, activar_like);
			
			Criteria criteriaRowcount = select;
			hibernateH.addRelations(articuloPlantilla, select, enableLike);
			if (articuloPlantilla.getIsPaginable()) {
				if (articuloPlantilla.getCountAgain()) {
					CriteriaImpl criteriaImpl = (CriteriaImpl) criteriaRowcount;
					List<Object> orderClauses = new ArrayList<Object>();
					// almacenar temporalmente los criterios de ordenacion
					Iterator<?> orderings = criteriaImpl.iterateOrderings();
					while (orderings.hasNext()) {
						Order ordering = ((CriteriaImpl.OrderEntry) orderings.next()).getOrder();
						orderings.remove();
						orderClauses.add(ordering);
					}
					criteriaRowcount.setProjection(Projections.countDistinct("id.codigoArticulo"));
					resultDTO.setCountResults((Long) hibernateH.uniqueResult(articuloPlantilla,criteriaRowcount));
					// establecer los criterios de ordenacion originales
					orderings = orderClauses.iterator();
					while (orderings.hasNext()) {
						criteriaRowcount.addOrder((Order) orderings.next());
					}
					if (resultDTO.getCountResults() > (maximoArticulos == null ? SICArticuloConstantes.getInstancia().MAXIMO_ARTICULOS_BUSQUEDA : maximoArticulos)) {
						throw new SICException("01", "El n\u00FAmero de resultados es demasiado extenso. Por favor incluya m\u00E1s filtros en la b\u00FAsqueda");
					}
				}
				if (articuloPlantilla.getFirstResult() != null) {
					select.setFirstResult(articuloPlantilla.getFirstResult());
				}
				if (articuloPlantilla.getMaxResults() != null) {
					select.setMaxResults(articuloPlantilla.getMaxResults());
				}
				//Creo y agrego las proyeccionaes para traer solo los datos necesarios
				ProjectionList projections = Projections.projectionList()
						.add(Projections.property("id.codigoCompania"), "id.codigoCompania")
						.add(Projections.property("id.codigoArticulo"), "id.codigoArticulo");
				select.setProjection(Projections.distinct(projections));
				hibernateH.paginarDatos(select, articuloPlantilla);
			}
			select.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
			resultDTO.setResults(hibernateH.list(articuloPlantilla,select));
			if (resultDTO.getCountResults() == null || resultDTO.getCountResults() == 0L) {
				resultDTO.setCountResults(Long.valueOf(resultDTO.getResults().size()));
			}
			return resultDTO;
		} catch (SICException e) {
			LOG_SICV2.error("Error al obtener los articulos por  filtros de busqueda para solicitud de impresion");
			throw new SICException(e.getCodigoError(), e.getDescripcionError());
		} catch (Exception e) {
			LOG_SICV2.error("Error al obtener los articulos por  filtros de busqueda para solicitud de impresion");
			throw new SICException(e);
		}
	}
	
	/**.
	 * Metodo que devuelve el  articulo solo con los campos necesarios para mostrar en la pantalla de solicitud
	 * codigobarras, referencia,proveedor, tamanio
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public SearchResultDTO<EstructuraArticuloSolImpresion> obtenerArticulosPorCodigo(Collection<String> codigoArticuloCol, Integer codigoCompania) throws SICException{
		SearchResultDTO<EstructuraArticuloSolImpresion> resultadoBusqueda = new SearchResultDTO<EstructuraArticuloSolImpresion>();
		//creo la plantilla para realizar la busqueda
		ArticuloDTO articuloPlantilla = new ArticuloDTO();
		Criteria select;
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			select = hibernateH.getCriteriaQuery(articuloPlantilla, borrar_cache, activar_like);
			select.add(Restrictions.in("id.codigoArticulo", codigoArticuloCol.toArray(new String[0])));
			select.add(Restrictions.eq("id.codigoCompania",codigoCompania));
//			select.add(Restrictions.eq("articuloEtiquetaCol.tagDTO.id.tagCode",11L));
			
			
			//Creo y agrego las proyeccionaes para traer solo los datos necesarios
			ProjectionList projections = Projections.projectionList()
					.add(Projections.property("id.codigoCompania"), "codigoCompania")
					.add(Projections.property("id.codigoArticulo"), "codigoArticulo")
					.add(Projections.property("descripcionArticulo"), "descripcionArticulo")
					.add(Projections.property("articuloMedidaDTO.referenciaMedida"), "referenciaMedida")
					;
			select.setProjection(Projections.distinct(projections));
			//creo los alias para poder traer las relaciones 
			select.createAlias("articuloMedidaDTO", "articuloMedidaDTO",Criteria.LEFT_JOIN);
			
			select.setResultTransformer(Transformers.aliasToBean(EstructuraArticuloSolImpresion.class));
			resultadoBusqueda.setResults(hibernateH.list(articuloPlantilla,select));
			return resultadoBusqueda;
		} catch (SICException e) {
			LOG_SICV2.error("Error al obtener los articulos por  filtros de busqueda para solicitud de impresion");
			throw new SICException(e.getCodigoError(), e.getDescripcionError());
		} 
		catch (Exception e) {
			LOG_SICV2.error("Error al obtener los articulos por  filtros de busqueda para solicitud de impresion"+e.getMessage());
			throw new SICException(e);
		} 
	}
	
	/**
	 * Metodo que permite buscar todos los articulos con etiquetasSemaforo
	 */
	@SuppressWarnings("unchecked")
	public SearchResultDTO<ArticuloEtiquetaDTO> buscarArticuloEtiquetaSemaforo(Collection<String> codigoArticuloCol, Integer codigoCompania){
		SearchResultDTO<ArticuloEtiquetaDTO> resultadoBusqueda = new SearchResultDTO<ArticuloEtiquetaDTO>();
		//creo la plantilla para realizar la busqueda
		ArticuloEtiquetaDTO articuloEtiquetaPlantilla = new ArticuloEtiquetaDTO();
		Criteria select;
		Session session;
		try {
			session = hibernateHArtEti.getHibernateSession();
			session.clear();
			select = hibernateHArtEti.getCriteriaQuery(articuloEtiquetaPlantilla, borrar_cache, activar_like);
			select.add(Restrictions.in("id.codigoArticulo", codigoArticuloCol.toArray(new String[0])));
			select.add(Restrictions.eq("id.codigoCompania",codigoCompania));
			select.add(Restrictions.eq("tagDTO.id.tagCode",Long.valueOf(EtiquetadoConstantes.getInstancia().ETIQUETA_SEMAFORO_ID)));
			
			//Creo y agrego las proyeccionaes para traer solo los datos necesarios
			ProjectionList projections = Projections.projectionList()
					.add(Projections.property("id.codigoCompania"), "id.codigoCompania")
					.add(Projections.property("id.codigoArticulo"), "id.codigoArticulo")
					;
			select.setProjection(Projections.distinct(projections));
			//creo los alias para poder traer las relaciones 
			select.createAlias("tagDTO", "tagDTO",Criteria.INNER_JOIN);
			
			select.setResultTransformer(new DtoResultTransformer(ArticuloEtiquetaDTO.class));
			resultadoBusqueda.setResults(hibernateH.list(articuloEtiquetaPlantilla,select));
			return resultadoBusqueda;
		} catch (SICException e) {
			LOG_SICV2.error("Error al obtener los articulos por  filtros de busqueda para solicitud de impresion");
			throw new SICException(e.getCodigoError(), e.getDescripcionError());
		} 
		catch (Exception e) {
			LOG_SICV2.error("Error al obtener los articulos por  filtros de busqueda para solicitud de impresion"+e.getMessage());
			throw new SICException(e);
		} 
	}
	@SuppressWarnings("unchecked")
	public Collection<EstructuraArticuloProveedorSolImpresion> buscarArticuloProveedorPorIdArticulo(ArticuloID articulioID)throws SICException{
		SearchResultDTO<EstructuraArticuloProveedorSolImpresion> resultadoBusqueda = new SearchResultDTO<EstructuraArticuloProveedorSolImpresion>();
		//creo la plantilla para realizar la busqueda
		ArticuloProveedorDTO articuloPlantilla = new ArticuloProveedorDTO();
		Criteria select;
		Session session;
		try {
			session = hibernateHArtProv.getHibernateSession();
			session.clear();
			select = hibernateHArtProv.getCriteriaQuery(articuloPlantilla, borrar_cache, activar_like);
			select.add(Restrictions.eq("id.codigoArticulo", articulioID.getCodigoArticulo()));
			select.add(Restrictions.eq("id.codigoCompania",articulioID.getCodigoCompania()));
			select.add(Restrictions.eq("estadoArticuloProveedor",SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			//Creo y agrego las proyeccionaes para traer solo los datos necesarios
			ProjectionList projections = Projections.projectionList()
					.add(Projections.property("id.codigoCompania"), "codigoCompania")
					.add(Projections.property("id.codigoArticulo"), "codigoArticulo")
					.add(Projections.property("codigoReferenciaProveedor"), "codigoReferenciaProveedor")
					.add(Projections.property("proveedor.nombreProveedor"), "nombreProveedor")
					;
			select.setProjection(Projections.distinct(projections));
			//creo los alias para poder traer las relaciones
			select.createAlias("proveedor", "proveedor");
			
			select.setResultTransformer(Transformers.aliasToBean(EstructuraArticuloProveedorSolImpresion.class));
			resultadoBusqueda.setResults(hibernateHArtProv.list(articuloPlantilla,select));
			return resultadoBusqueda.getResults();
		}  catch (SICException e) {
			LOG_SICV2.error("Error al obtener los objetos ArticuloProveedor por  filtros de busqueda para solicitud de impresion");
			throw new SICException(e.getCodigoError(), e.getDescripcionError());
		} 
		catch (Exception e) {
			LOG_SICV2.error("Error al obtener los objetos ArticuloProveedor por  filtros de busqueda para solicitud de impresion"+e.getMessage());
			throw new SICException(e);
		} 
	}

	public IHibernateH<ArticuloDTO> getHibernateH() {
		return hibernateH;
	}

	public void setHibernateH(IHibernateH<ArticuloDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}

	public IHibernateH<ArticuloProveedorDTO> getHibernateHArtProv() {
		return hibernateHArtProv;
	}

	public void setHibernateHArtProv(IHibernateH<ArticuloProveedorDTO> hibernateHArtProv) {
		this.hibernateHArtProv = hibernateHArtProv;
	}

	public IHibernateH<ArticuloEtiquetaDTO> getHibernateHArtEti() {
		return hibernateHArtEti;
	}

	public void setHibernateHArtEti(IHibernateH<ArticuloEtiquetaDTO> hibernateHArtEti) {
		this.hibernateHArtEti = hibernateHArtEti;
	}
	
}
