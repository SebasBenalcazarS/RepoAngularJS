/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.dto.OrderBy;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearch;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.smx.corpv2.dto.CatalogoTipoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorRelacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloAgrupadorDAO;

/**
 * @author gaortiz
 *
 */
@SuppressWarnings("serial")
public class ArticuloAgrupadorDAO implements IArticuloAgrupadorDAO {
	private IHibernateH<ArticuloAgrupadorDTO> hibernateH;
	private DataGestor dataGestor;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param tipoCatalogo
	 * @param valorCatalogo
	 * @return
	 * @throws SICException
	 */
	public Boolean existeCaracteristicaArticulo(ArticuloDTO articuloDTO, Integer tipoCatalogo, String valorCatalogo)throws SICException{
		StringBuilder query = new StringBuilder();
		Session session;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			query.append("select count(ag.id.codigoArticulo) from ").append(ArticuloAgrupadorDTO.class.getName()).append(" ag where ag.id.codigoCompania=:pCodigoCompania and ag.id.codigoArticulo=:pCodigoArticulo")
			.append(" and ag.id.codigoTipoAgrupador=:pCodigoTipoAgrupador and ag.id.valorTipoAgrupador=:pValorTipoAgrupador and ag.estado=:pEstado");
			Query select =session.createQuery(query.toString());
			select.setInteger("pCodigoCompania", articuloDTO.getId().getCodigoCompania());
			select.setString("pCodigoArticulo", articuloDTO.getId().getCodigoArticulo());
			select.setString("pValorTipoAgrupador", valorCatalogo);
			select.setInteger("pCodigoTipoAgrupador", tipoCatalogo);
			select.setString("pEstado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			return ((Long)select.uniqueResult()) > 0 ? Boolean.TRUE : Boolean.FALSE;
		}catch(Exception e){
			throw new SICException(e.getMessage(),e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloAgrupadorDTO> obtenerArticuloAgrupadorPorCodigoTipoAgrupador(Integer codigoCompania, String codigoArticulo, Integer codigoTipoAgrupador) throws SICException {
		Session session = null;
		Criteria criteria;
		Collection<ArticuloAgrupadorDTO> articuloAgrupadorCol = null;
		
		try {
			
			session = this.hibernateH.getHibernateSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloAgrupadorDTO.class, "artagrp");
			criteria.createAlias("artagrp.tipoAgrupador", "btipagr", Criteria.LEFT_JOIN, Restrictions.eq("btipagr.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("id.codigoArticulo", codigoArticulo));
			criteria.add(Restrictions.eq("id.codigoTipoAgrupador", codigoTipoAgrupador));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			articuloAgrupadorCol = (Collection<ArticuloAgrupadorDTO>) criteria.list();
			
		} catch(Exception e) {
			LOG_SICV2.error("Error al consultar los ArticulosAgrupador", e);
			throw new SICException("Error al consultar los ArticulosAgrupador", e);
		}
		
		return articuloAgrupadorCol;
	}
	
	public void actualizarEstadoRelacion(Integer codigoCompania, String codigoArticulo, String campoArticulo, String nuevoEstado, String campoEstado, Class<? extends SearchDTO> clase, String userId ,List<Integer> codigoTipoAgrupadorList, List<String> tipoValorAgrupadorList) throws SICException {
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try {
			String filtroEstado = SICConstantes.ESTADO_ACTIVO_NUMERICO;
			if (nuevoEstado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)) {
				filtroEstado = SICConstantes.ESTADO_INACTIVO_NUMERICO;
			} else if (nuevoEstado.equals(SICConstantes.ESTADO_ACTIVO_LITERAL)) {
				filtroEstado = SICConstantes.ESTADO_INACTIVO_LITERAL;
			} else if (nuevoEstado.equals(SICConstantes.ESTADO_INACTIVO_LITERAL)) {
				filtroEstado = SICConstantes.ESTADO_ACTIVO_LITERAL;
			}

			session = hibernateH.getHibernateSession();
			session.clear();
			query = new StringBuilder();
			query.append("update ").append(clase.getName()).append(" rel set rel.").append(campoEstado).append("= :pEstado")
			.append(", rel.idUsuarioModificacion = :pUserId")
			.append(", rel.fechaModificacion = :pFechaModificacion where rel.id.codigoCompania = :pCodigoCompania and rel.").append(campoArticulo).append("= :pCodigoArticulo and rel.").append(campoEstado).append("=:pFiltroEstado");
			
			if(clase.equals(ArticuloAgrupadorRelacionDTO.class)) {
				query.append(" AND rel.codigoTipoAgrupador in (:pCodigoTipoAgrupador)");
			} else {
				query.append(" AND rel.id.codigoTipoAgrupador in (:pCodigoTipoAgrupador)");
			}
			
			if(!CollectionUtils.isEmpty(tipoValorAgrupadorList)) {
				if(clase.equals(ArticuloAgrupadorRelacionDTO.class)) {
					query.append(" AND rel.codigoTipoAgrupador ||'.'|| rel.valorTipoAgrupador NOT IN (:pTipoValorAgrupadorList)");
				} else {
					query.append(" AND rel.id.codigoTipoAgrupador ||'.'|| rel.id.valorTipoAgrupador NOT IN (:pTipoValorAgrupadorList)");
				}
			}
			
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setString("pEstado", nuevoEstado);
			hqlQuery.setInteger("pCodigoCompania", codigoCompania);
			hqlQuery.setString("pCodigoArticulo", codigoArticulo);
			hqlQuery.setString("pFiltroEstado", filtroEstado);
			hqlQuery.setString("pUserId", userId);
			hqlQuery.setTimestamp("pFechaModificacion", new Timestamp(System.currentTimeMillis()));
			hqlQuery.setParameterList("pCodigoTipoAgrupador", codigoTipoAgrupadorList);
			
			if(!CollectionUtils.isEmpty(tipoValorAgrupadorList)) {
				hqlQuery.setParameterList("pTipoValorAgrupadorList", tipoValorAgrupadorList);
			}
			
			hqlQuery.executeUpdate();
		} catch (Exception e) {
			LOG_SICV2.error("", e);
			throw new SICException("Error al actualizar el estado de la entidad " + clase.getSimpleName(), e);
		} finally {
			session = null;
			query = null;
			hqlQuery = null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<CatalogoValorDTO> obtenerAgrupadoresPadres(Integer... codigoCatalogoTipo){
		Session session;
		try{
			session = hibernateH.getHibernateSession();
			Criteria sql =  session.createCriteria(CatalogoValorDTO.class);
			sql.add(Restrictions.in("id.codigoCatalogoTipo", codigoCatalogoTipo));
			sql.add(Restrictions.eq("estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			sql.createAlias("catalogoTipoDTO","catalogoTipoDTO", CriteriaSpecification.LEFT_JOIN);
			
			DetachedCriteria subselect = DetachedCriteria.forClass(CatalogoValorRelacionadoDTO.class);
			subselect.setProjection(Projections.property("id.codigoCatalogoValorRelacionado"));		
			subselect.add(Restrictions.in("id.codigoCatalogoValorTipoRelacionado", codigoCatalogoTipo));
			
			Criterion notIn = null;
			notIn = Subqueries.propertyNotIn("id.codigoCatalogoValor", subselect);
			sql.add(notIn);
			
			return sql.list();
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}finally{
			session = null;
		}
	}
	
	public Collection<CatalogoValorDTO> obtenerAgrupadoresHijos(CatalogoValorDTO catalogoValorDTO){
		Collection<CatalogoValorDTO> catValChildren = new ArrayList<CatalogoValorDTO>();
		
		CatalogoValorRelacionadoDTO catalogoValorRelacionadoDTO = new CatalogoValorRelacionadoDTO();
		
		CatalogoTipoDTO catalogoTipoDTO = catalogoValorDTO.getCatalogoTipoDTO();
		catalogoTipoDTO.setCatalogoValores(new ArrayList<CatalogoValorDTO>());
		catalogoTipoDTO.getCatalogoValores().add(new CatalogoValorDTO());
		catalogoValorDTO.setCatalogoTipoDTO(catalogoTipoDTO);
		CatalogoValorDTO catalogoValorRelacion = new CatalogoValorDTO();
		catalogoValorRelacion.setCriteriaSearch(new CriteriaSearch());
		
		catalogoValorRelacion.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoExterno", ComparatorTypeEnum.IS_NOT_NULL));
		catalogoValorRelacionadoDTO.setCatalogoValorRelacionadoDTO(catalogoValorRelacion);
		catalogoValorRelacionadoDTO.getId().setCodigoCatalogoValorPadre(catalogoValorDTO.getId().getCodigoCatalogoValor());
		catalogoValorRelacionadoDTO.getId().setCodigoCatalogoValorTipoPadre(catalogoValorDTO.getId().getCodigoCatalogoTipo());
		catalogoValorRelacionadoDTO.setOrderByField(OrderBy.orderAsc("catalogoValorRelacionadoDTO.nombreCatalogoValor"));
		
		Collection<CatalogoValorRelacionadoDTO> catValRelCol = this.dataGestor.findObjects(catalogoValorRelacionadoDTO);
		if(CollectionUtils.isNotEmpty(catValRelCol)){
			for(CatalogoValorRelacionadoDTO catalogoValorRelacionado : catValRelCol){
				catValChildren.add(catalogoValorRelacionado.getCatalogoValorRelacionadoDTO());
			}
		}
		return catValChildren;
	}

	/**
	 * @param dataGestor the dataGestor to set
	 */
	public final void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	public void setHibernateH(IHibernateH<ArticuloAgrupadorDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
}
