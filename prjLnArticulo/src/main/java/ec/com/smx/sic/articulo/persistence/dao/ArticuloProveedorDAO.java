package ec.com.smx.sic.articulo.persistence.dao;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAplicacionDescuento;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAsignacionDescuento;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloProveedorDAO;
import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;

public class ArticuloProveedorDAO implements Logeable, IArticuloProveedorDAO {
	
	private IHibernateH<ArticuloProveedorDTO> hibernateH;
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloUnidadManejoProveedorDTO> obtenerDescuentosUnidadManejo(Collection<String> codArticuloProveedorCol,Integer codigoCompania){
		StringBuilder query = new StringBuilder();
		Session session;
		session = hibernateH.getHibernateSession(); //<>TIPODESCUENTO
		session.clear();
		// FILTRAR LOS DE TIPO NORMAL		
		query.append("from ").append(ArticuloUnidadManejoProveedorDTO.class.getName())
		.append(" aump ")
		.append(" inner join fetch aump.equivalenciaPorcentajeDescuentoCol epd")
//		.append(" inner join fetch aump.equivalenciaPorcentajeDescuentoDTO epd ")
		.append(" left join fetch epd.asignacionTipoDescuento atd ")
		.append(" left join fetch atd.tipoDescuento td ")
		.append(" where aump.estado = :pEstadoUniMan and aump.id.codigoCompania = :pCodigoCompania and aump.codigoArticulo||aump.id.codigoProveedor in (:pcodArticuloProveedorCol)")
		.append(" and atd.codigoAplicacionTipoDescuento = :pCodigoAplicacionTipoDescuento and atd.valorAplicacionTipoDescuento = :pValorAplicacionTipoDescuento ")
		.append(" and atd.codigoAsignacionTipoDescuento = :pCodigoAsignacionTipoDescuento and atd.valorAsignacionTipoDescuento = :pValorAsignacionTipoDescuento ");
		Query select =session.createQuery(query.toString());
		select.setParameterList("pcodArticuloProveedorCol", codArticuloProveedorCol);
		select.setParameter("pEstadoUniMan", SICConstantes.ESTADO_ACTIVO_NUMERICO);
		select.setParameter("pCodigoCompania", codigoCompania);
		select.setParameter("pCodigoAplicacionTipoDescuento", EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO);
		select.setParameter("pValorAplicacionTipoDescuento", EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento());
		select.setParameter("pCodigoAsignacionTipoDescuento", EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO);
		select.setParameter("pValorAsignacionTipoDescuento", EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento());
	
		select.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return select.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<DescuentoProveedorArticuloDTO> obtenerDescuentosArticuloProv(Collection<String> codArticuloProveedorCol,Integer codigoCompania){
		StringBuilder query = new StringBuilder();
		Session session;
		session = hibernateH.getHibernateSession();
		session.clear();	
		query.append("from ").append(DescuentoProveedorArticuloDTO.class.getName()).append(" dpa ")
		.append(" left join fetch dpa.asignacionTipoDescuento atd ")
		.append(" left join fetch atd.tipoDescuento td ")
		.append(" left join fetch dpa.equivalenciaPorcentajeDescuento epd ")
		.append(" where dpa.estado = :pEstadoDesArtPro and dpa.id.codigoCompania = :pCodigoCompania and dpa.codigoArticulo||dpa.codigoProveedor in (:pcodArticuloProveedorCol)")
		.append(" and atd.codigoAplicacionTipoDescuento = :pCodigoAplicacionTipoDescuento and atd.valorAplicacionTipoDescuento in (:pValorAplicacionTipoDescuento) ")
		.append(" and atd.codigoAsignacionTipoDescuento = :pCodigoAsignacionTipoDescuento and atd.valorAsignacionTipoDescuento = :pValorAsignacionTipoDescuento ")
		.append(" order by dpa.codigoProveedor asc, atd.prioridad asc");		
		Query select =session.createQuery(query.toString());
		select.setParameterList("pcodArticuloProveedorCol", codArticuloProveedorCol);	
		select.setParameter("pEstadoDesArtPro", SICConstantes.ESTADO_ACTIVO_NUMERICO);
		select.setParameter("pCodigoCompania", codigoCompania);
		select.setParameter("pCodigoAplicacionTipoDescuento", EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO);
		select.setParameterList("pValorAplicacionTipoDescuento", new String[]{EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento(), EnumTipoAplicacionDescuento.COSTO_CONVENIO.getValorTipoAplicacionDescuento()});
		select.setParameter("pCodigoAsignacionTipoDescuento", EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO);
		select.setParameter("pValorAsignacionTipoDescuento", EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento());
		select.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return select.list();
	}
	
	/**
	 * @param articuloProveedorID	- identificador del art&iacute;culo proveedor
	 * @param estado				- valor del campe estado
	 * @param campoEstado			- Nombre del campo que hace referencia al estado
	 * @param clase					- Clase de la entidad que se desea actualizar
	 */
	@Override
	public void actualizarEstado(ArticuloProveedorDTO ap, String valorEstado, String campoEstado, String campoArticulo, Class<? extends SearchDTO> clase)throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try{
			if(StringUtils.isEmpty(campoArticulo)){
				campoArticulo = "id.codigoArticulo";
			}
			String filtroEstado = SICConstantes.ESTADO_ACTIVO_NUMERICO;
			if(valorEstado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
				filtroEstado = SICConstantes.ESTADO_INACTIVO_NUMERICO;
			}
			
			session = hibernateH.getHibernateSession();
			session.clear();
			query = new StringBuilder();
			query.append("update ").append(clase.getName()).append(" rel set rel.").append(campoEstado)
				.append("= :pEstado, rel.idUsuarioModificacion = :pUserId, rel.fechaModificacion=:pFechaActual ")
				.append("where rel.id.codigoCompania=:pCodigoCompania and rel.").append(campoArticulo).append("=:pCodigoArticulo and rel.id.codigoProveedor=:pCodigoProveedor and rel.")
				.append(campoEstado).append("= :pFiltroEstado");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setString("pEstado", valorEstado);
			hqlQuery.setString("pFiltroEstado", filtroEstado);
			hqlQuery.setInteger("pCodigoCompania", ap.getId().getCodigoCompania());
			hqlQuery.setString("pCodigoArticulo", ap.getId().getCodigoArticulo());
			hqlQuery.setString("pCodigoProveedor", ap.getId().getCodigoProveedor());
			hqlQuery.setTimestamp("pFechaActual", new Timestamp(System.currentTimeMillis()));
			hqlQuery.setString("pUserId",ap.getUserId());
			hqlQuery.executeUpdate();
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException("Error al actualizar el estado de la entidad "+clase.getSimpleName(),e);
		}finally{
			session = null;
			query = null;
			hqlQuery = null;
		}
	}
	
	/**
	 * 
	 * @param apActual
	 * @param nombreCampoProveedor
	 * @param codigoProveedorAnterior
	 * @param clase
	 * @throws SICException
	 */
	@Override
	public void actualizarCodigoProveedorEnRelaciones(ArticuloProveedorDTO apActual, String nombreCampoProveedor, String codigoProveedorAnterior, Class<? extends SearchDTO> clase) throws SICException{
		StringBuilder query = new StringBuilder();
		Session session;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("update ").append(clase.getName()).append(" rel set rel.").append(nombreCampoProveedor).append("=:pCodigoProveedor, rel.idUsuarioModificacion=:pUserAuditId, rel.fechaModificacion=:pDate ")
				.append("where rel.id.codigoCompania=:pCompania and rel.id.codigoArticulo = :pArticulo and rel.codigoProveedor=:pProveedorAnterior");
			Query update =session.createQuery(query.toString());
			update.setInteger("pCompania",apActual.getId().getCodigoCompania());
			update.setString("pCodigoProveedor", apActual.getId().getCodigoProveedor());
			update.setString("pArticulo",apActual.getId().getCodigoArticulo());
			update.setTimestamp("pDate", new Timestamp(System.currentTimeMillis()));
			update.setString("pUserAuditId",apActual.getUserId());
			update.setString("pProveedorAnterior", codigoProveedorAnterior);
			update.executeUpdate();
			
		}catch(Exception e){
			throw new SICException("Error al cambiar el c�digo del proveedor en "+clase.getName(),e);
		}
	}
	
//	@Override
//	public void actualizarEstadoRelacion(Integer codigoCompania, String codigoArticulo, String codigoProveedor, String nuevoEstado, String campoArticulo, String campoProveedor, String campoEstado, Class<? extends SearchDTO> clase) throws SICException {
//		Session session;
//		StringBuilder query;
//		Query hqlQuery;
//		try {
//			String filtroEstado = SICConstantes.ESTADO_ACTIVO_NUMERICO;
//			if (nuevoEstado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)) {
//				filtroEstado = SICConstantes.ESTADO_INACTIVO_NUMERICO;
//			}
//
//			session = hibernateH.getHibernateSession();
//			session.clear();
//			query = new StringBuilder();
//			query.append("update ").append(clase.getName()).append(" rel set rel.").append(campoEstado).append("= :pEstado where rel.id.codigoCompania = :pCodigoCompania and rel.").append(campoArticulo).append("= :pCodigoArticulo and rel.")
//			.append(campoProveedor).append("= :pCodigoProveedor and rel.").append(campoEstado).append("=:pFiltroEstado");
//			hqlQuery = session.createQuery(query.toString());
//			hqlQuery.setString("pEstado", nuevoEstado);
//			hqlQuery.setInteger("pCodigoCompania", codigoCompania);
//			hqlQuery.setString("pCodigoArticulo", codigoArticulo);
//			hqlQuery.setString("pCodigoProveedor", codigoProveedor);
//			hqlQuery.setString("pFiltroEstado", filtroEstado);
//			hqlQuery.executeUpdate();
//		} catch (Exception e) {
//			LOG_SICV2.error("", e);
//			throw new SICException("Error al actualizar el estado de la entidad " + clase.getSimpleName(), e);
//		} finally {
//			session = null;
//			query = null;
//			hqlQuery = null;
//		}
//	}

	/**
	 * @param hibernateH the hibernateH to set
	 */
	public void setHibernateH(IHibernateH<ArticuloProveedorDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
	
	/**
	 * @author bcueva
	 * Permite obtener los c\u00F3digos de los Proveedores a partir de el c\u00F3digo de Barras de un Articulo
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @param codigoBarras C\u00F3digo de barras del Art\u00EDculo a buscar
	 * @return
	 * @throws SICException
	 */
	public List<Integer> obtenerCodigosProveedorPorCodigoBarrasArticulo(Integer codigoCompania, String codigoBarras) throws SICException {
		Session session;
		Criteria criteria;
		List<Integer> listaCodigosProveedor = null;
		ProjectionList projection = null;
		
		try {
			session = this.hibernateH.getHibernateSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloProveedorDTO.class, "artpro");
			//Selecionando el campo que necesito
			projection = Projections.projectionList();
			projection.add(Projections.property("proveedor.codigoJDEProveedor"), "codigoProveedor");
			criteria.setProjection(projection);
			criteria.createAlias("artpro.articulo","articulo", Criteria.INNER_JOIN);
			criteria.createAlias("artpro.vistaProveedor","proveedor", Criteria.INNER_JOIN);
			criteria.createAlias("articulo.artBitCodBarCol", "artbitcodbar", Criteria.INNER_JOIN);
			criteria.add(Restrictions.eq("artpro.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("artbitcodbar.id.codigoBarras", codigoBarras));
			criteria.add(Restrictions.eq("artpro.estadoArticuloProveedor", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("articulo.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("proveedor.estadoProveedor", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("artbitcodbar.estadoArticuloBitacora", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			listaCodigosProveedor = criteria.list();
		} catch(Exception ex) {
			LOG_SICV2.error("Error al obtener los c\u00F3digo de los Proveedores", ex);
			throw new SICException("Error al obtener los c\u00F3digo de los Proveedores", ex);
		}
		
		return listaCodigosProveedor;
	} 
	
	public Boolean verificarArticuloImportado(String codigoArticulo , Integer codigoCompania) throws SICException{
		try {
			Collection<String> codigosProveedores = null;
			//buscamos los codigos de los proveedores del articulo
			Session session;
			session = hibernateH.getHibernateSession();
			session.clear();
			StringBuilder querySelect = new StringBuilder();
			querySelect.append("SELECT AP.CODIGOPROVEEDOR FROM SCSADTARTPRO AP ");
			querySelect.append(" LEFT JOIN SCSADTARTPROIMP API ON API.CODIGOCOMPANIA = AP.CODIGOCOMPANIA AND API.CODIGOPROVEEDOR = AP.CODIGOPROVEEDOR AND API.CODIGOARTICULO = AP.CODIGOARTICULO");
			querySelect.append(" LEFT JOIN SCSPETPROVEEDOR PR ON AP.CODIGOCOMPANIA = PR.CODIGOCOMPANIA AND AP.CODIGOPROVEEDOR = PR.CODIGOPROVEEDOR");
			querySelect.append(" LEFT JOIN SCSADTPROIMP PI ON PR.CODIGOCOMPANIA = PI.CODIGOCOMPANIA AND PR.CODIGOPROVEEDOR = PI.CODIGOPROVEEDOR");
			querySelect.append(" WHERE AP.CODIGOARTICULO = '"+codigoArticulo+"'");
			querySelect.append(" AND AP.CODIGOCOMPANIA = "+codigoCompania);
			querySelect.append(" AND AP.ESTADOARTICULOPROVEEDOR = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"'");
			querySelect.append(" AND (PR.ORIGENPROVEEDOR = '"+SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.importado")+"' OR PI.ESIMPORTADOR = '"+SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO+"')");
			Query sqlQuery = session.createSQLQuery(querySelect.toString());
			codigosProveedores = sqlQuery.list();
			
			if(CollectionUtils.isNotEmpty(codigosProveedores)){
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}catch(Exception ex) {
			LOG_SICV2.error("Ocurrio un error al verificar el articulo importado", ex);
			throw new SICException("Ocurrio un error al verificar el articulo importado");
		}
	}
	
	public ArticuloImportacionDTO obtenerArticuloImportacion(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException {
		List<ArticuloImportacionDTO> articuloImportacion = null;
		Session session;
		Criteria criteria;
		
		try {
			session = this.hibernateH.getHibernateSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloImportacionDTO.class, "artimp");
			criteria.add(Restrictions.eq("artimp.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("artimp.id.codigoArticulo", codigoArticulo));
			criteria.add(Restrictions.eq("artimp.id.codigoProveedor", codigoProveedor));
			articuloImportacion = criteria.list();
			
			if(articuloImportacion != null && articuloImportacion.size() > 0) {
				return articuloImportacion.get(0);
			}
		} catch(Exception ex) {
			LOG_SICV2.error("Error al consultar el articulo importacion", ex);
			throw new SICException("Error al consultar el articulo importacion", ex);
		}
		return null;
	}
	
	public Boolean tieneImpuestoDisney(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException{
		Session session;
		Criteria criteria;
		Boolean tieneImpuesto = Boolean.FALSE;
		try {
			session = this.hibernateH.getHibernateSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloProveedorImpuestoDTO.class, "artproimp");
			criteria.add(Restrictions.eq("artproimp.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("artproimp.id.codigoArticulo", codigoArticulo));
			criteria.add(Restrictions.eq("artproimp.id.codigoProveedor", codigoProveedor));
			criteria.add(Restrictions.eq("artproimp.id.codigoTipoImpuesto", SICArticuloConstantes.TIPOIMPUESTO_OMISION_IDN));
			criteria.add(Restrictions.eq("artproimp.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			List<ArticuloProveedorImpuestoDTO> articuloProveedorImpuestoList = criteria.list();
			if(articuloProveedorImpuestoList.size() > 0) {
				tieneImpuesto = Boolean.TRUE;
			}
			
		} catch(Exception ex) {
			LOG_SICV2.error("Error al consultar los impuestos del Proveedor", ex);
			throw new SICException("Error al consultar los impuestos del Proveedor", ex);
		}
		return tieneImpuesto;
	}
	
	/**
	 * Metodo que retorna la relacion entre articulo proveedor con los codigos de articulo(El dto de articulo viene cargado)
	 * @author aquingaluisa
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Collection<ArticuloProveedorDTO> obtenerArticuloProveedorPorCodigoArticulo(Integer codigoCompania,Collection<String> codigoArticuloCol){
		Session session;
		Criteria criteria;
		try {
			session = this.hibernateH.getHibernateSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloProveedorDTO.class, "artpro");
			criteria.createAlias("artpro.proveedor","proveedor", Criteria.INNER_JOIN);
			criteria.add(Restrictions.eq("artpro.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("artpro.estadoArticuloProveedor", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.in("artpro.id.codigoArticulo", codigoArticuloCol));
			//criteria.setResultTransformer(arg0)
			return criteria.list();
		} catch(Exception ex) {
			LOG_SICV2.error("Error al consultar los impuestos del Proveedor", ex);
			throw new SICException("Error al consultar los impuestos del Proveedor", ex);
		}
	}
	
	@Override
	public ArticuloProveedorDTO obtenerArticuloProveedor(Integer codigoCompania, String codigoBarras, String codigoReferencia, String codigoProveedor, String codigoEstado){
		Criteria criteria = null;
		Session session = null;
		ArticuloProveedorDTO articuloProveedorDTO = null;
		List<ArticuloProveedorDTO> articuloProveedorDTOs = null;
		try{
			/* Se obtiene la sesion de hibernate y se limpia */
			session = hibernateH.getHibernateSession();
			session.clear();
			
			/* Se crea el criteria del objeto base */
			criteria = session.createCriteria(ArticuloProveedorDTO.class, "artpro");
			
			/* Se crean las relaciones */
			criteria.createAlias("artpro.articulo","art", Criteria.LEFT_JOIN);
			criteria.createAlias("art.artBitCodBarCol","codbar", Criteria.LEFT_JOIN, Restrictions.eq("codbar.estadoArticuloBitacora", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			/* Se crean las restricciones de busqueda */
			criteria.add(Restrictions.eq("artpro.id.codigoCompania", codigoCompania));
			if(StringUtils.isNotEmpty(codigoProveedor)){
				criteria.add(Restrictions.eq("artpro.id.codigoProveedor", codigoProveedor));
			}			
			criteria.add(Restrictions.eq("artpro.estadoArticuloProveedor", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("artpro.codigoReferenciaProveedor", codigoReferencia));
			criteria.add(Restrictions.eq("art.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.in("art.codigoEstado", new String[]{SICArticuloConstantes.ESTADOARTICULO_PRECODIFICADO, SICArticuloConstantes.ESTADOARTICULO_CODIFICADO}));
			if(StringUtils.isNotEmpty(codigoBarras)){
				criteria.add(Restrictions.eq("codbar.id.codigoBarras", codigoBarras));
			}else{//Se pone esta restriccion ya que cuando envian solamente el codigo de referencia ya que es totalmente diferenente al codificado ya que este si posee codigo de barras.
				criteria.add(Restrictions.like("codbar.id.codigoBarras", "C", MatchMode.START));
			}
			
			/* Se crean las proyecciones */
			ProjectionList projections = Projections.projectionList();
			projections.add(Projections.property("artpro.id.codigoArticulo") , "id.codigoArticulo");
			projections.add(Projections.property("artpro.id.codigoProveedor") , "id.codigoProveedor");
			projections.add(Projections.property("artpro.fechaRegistro") , "fechaRegistro");
			projections.add(Projections.property("art.codigoEstado") , "articulo.codigoEstado");			
			criteria.setProjection(projections);
			
			/* Se crea el ordenamiento */
			if(codigoEstado != null){
				if(StringUtils.equals(codigoEstado, SICArticuloConstantes.ESTADOARTICULO_CODIFICADO)){
					criteria.addOrder(Order.asc("art.codigoEstado"));	
				}else{
					criteria.addOrder(Order.desc("art.codigoEstado"));
				}
			}
			criteria.addOrder(Order.desc("artpro.fechaRegistro"));
			
			/* Se crean la paginacion de resultados */
			criteria.setFirstResult(0);
			criteria.setMaxResults(1);
			
			/* Se asigna el transformador */
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloProveedorDTO.class));
			
			/* Se ejecuta la consulta */
			articuloProveedorDTOs = criteria.list();
			
			/* Se asigna el elemento encontrado */
			if(CollectionUtils.isNotEmpty(articuloProveedorDTOs)){				
				articuloProveedorDTO = articuloProveedorDTOs.iterator().next();
			}
					
			return articuloProveedorDTO;
		} catch (Exception e) {
			throw new SICException("Ha ocurrido un error al consultar la informacion de articulo-proveedor.");
		}
	}
	
	/**
	 * @author rali
	 * Retorna la cantidad de proveedores de un articulo
	 * 
	 */
	public long cantidadProveedores(String codigoArticulo,Integer codigoCompania) throws SICException{
		StringBuilder query = new StringBuilder();
		Session session;
		Query select;
		long cantidad = 0;
		try{
			if(codigoArticulo != null && codigoCompania != null){
				session = hibernateH.getHibernateSession();
				session.clear();
				
				query.append("select count(*) from ").append(ArticuloProveedorDTO.class.getName())
				.append(" ap where ap.id.codigoCompania=:pCompania and ap.id.codigoArticulo=:pCodigoArticulo");
				
				select = session.createQuery(query.toString());
				select.setInteger("pCompania",codigoCompania);
				select.setString("pCodigoArticulo",codigoArticulo);
				cantidad =  new Long(select.uniqueResult().toString());
			}
		}catch(Exception e){
			throw new SICException("Error al consultar la cantidad de proveedores del art\u00EDculo",e);
		}
		return cantidad;
	}
	
	@Override
	public DescuentoProveedorArticuloDTO obtenerDescuentoArticuloProveedor(DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO){
		StringBuilder query = new StringBuilder();
		Session session;
		session = hibernateH.getHibernateSession();
		session.clear();	
		query.append("from ").append(DescuentoProveedorArticuloDTO.class.getName()).append(" dpa ")
		.append(" where dpa.id.codigoCompania = :pCodigoCompania ")
		.append(" and  dpa.codigoArticulo = :pCodigoArticulo and dpa.codigoProveedor = :pCodigoProveedor ")
		.append(" and dpa.secuencialAsignacionTipoDescuento = :pSecAsiTipDes");
		
		// parametros
		Query select =session.createQuery(query.toString());
		select.setParameter("pCodigoCompania", descuentoProveedorArticuloDTO.getId().getCodigoCompania());		
		select.setString("pCodigoProveedor", descuentoProveedorArticuloDTO.getCodigoProveedor());
		select.setString("pCodigoArticulo", descuentoProveedorArticuloDTO.getCodigoArticulo());
		//select.setString("pCodigoTipoDescuento", descuentoProveedorArticuloDTO.getCodigoTipoDescuento());
		select.setLong("pSecAsiTipDes", descuentoProveedorArticuloDTO.getSecuencialAsignacionTipoDescuento());
		
		return (DescuentoProveedorArticuloDTO)select.uniqueResult();
	}
	
	@Override
	public void actualizarEstadoDesArtPro(ArticuloProveedorDTO ap, String valorEstado)throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try{

			String filtroEstado = SICConstantes.ESTADO_ACTIVO_NUMERICO;
			if(valorEstado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
				filtroEstado = SICConstantes.ESTADO_INACTIVO_NUMERICO;
			}
			
			session = hibernateH.getHibernateSession();
			session.clear();
			query = new StringBuilder();
			query.append("update ").append(DescuentoProveedorArticuloDTO.class.getName()).append(" rel set rel.estado ")
				.append("= :pEstado, rel.idUsuarioModificacion = :pUserId, rel.fechaModificacion=:pFechaActual ")
				.append("where rel.id.codigoCompania=:pCodigoCompania and rel.codigoArticulo ").append("=:pCodigoArticulo and rel.codigoProveedor=:pCodigoProveedor and rel.")
				.append("estado = :pFiltroEstado");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setString("pEstado", valorEstado);
			hqlQuery.setString("pFiltroEstado", filtroEstado);
			hqlQuery.setInteger("pCodigoCompania", ap.getId().getCodigoCompania());
			hqlQuery.setString("pCodigoArticulo", ap.getId().getCodigoArticulo());
			hqlQuery.setString("pCodigoProveedor", ap.getId().getCodigoProveedor());
			hqlQuery.setTimestamp("pFechaActual", new Timestamp(System.currentTimeMillis()));
			hqlQuery.setString("pUserId",ap.getUserId());
			hqlQuery.executeUpdate();
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException("Error al actualizar el estado de la entidad "+DescuentoProveedorArticuloDTO.class.getSimpleName(),e);
		}finally{
			session = null;
			query = null;
			hqlQuery = null;
		}
	}
	
}
