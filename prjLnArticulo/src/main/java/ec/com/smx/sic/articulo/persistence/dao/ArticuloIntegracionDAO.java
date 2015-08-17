/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.MultiLevelResultTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAsignacionDescuento;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPendienteIntegracionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.validacion.ArticuloValidacionSIC;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloIntegracionDAO;
import ec.com.smx.sic.integracion.dto.articulo.validar.ValidarArticuloIDTO;

/**
 * @author fmunoz
 *
 */
public class ArticuloIntegracionDAO implements IArticuloIntegracionDAO {

	private SessionFactory sessionFactory;
	private IHibernateH<ArticuloPendienteIntegracionDTO> hibernateH;

	@Override
	public void eliminarArticulosIntegrados(Integer codigoCompania, String codigoArticulo, String valorTipoProceso, Date fechaFinal)throws SICException{
		StringBuilder query = new StringBuilder();
		Session session;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			query.append("delete from ").append(ArticuloPendienteIntegracionDTO.class.getName()).append(" a where a.id.codigoCompania = :pCompania and ")
			.append("a.codigoArticulo = :pCodigoArticulo and a.valorTipoProceso = :pValorTipoProceso and a.fechaRegistro <= :pFechaRegistro");
			Query delete = session.createQuery(query.toString());
			delete.setInteger("pCompania", codigoCompania);
			delete.setString("pCodigoArticulo", codigoArticulo);
			delete.setString("pValorTipoProceso", valorTipoProceso);
			delete.setString("pFechaRegistro", fechaFinal.toString());
			delete.executeUpdate();
		} catch (Exception e) {
			throw new SICException("Error al borrar la bitacora de articulos no integrados", e);
		}
	}
	
	public void eliminarArticulosIntegrados(Integer codigoCompania, Long secuencial)throws SICException{
		StringBuilder query = new StringBuilder();
		Session session;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			query.append("delete from ").append(ArticuloPendienteIntegracionDTO.class.getName()).append(" a where a.id.codigoCompania=:pCompania and a.id.secuencial=:pSecuencial");
			Query delete = session.createQuery(query.toString());
			delete.setInteger("pCompania", codigoCompania);
			delete.setLong("pSecuencial", secuencial);
			delete.executeUpdate();
		} catch (Exception e) {
			throw new SICException("Error al borrar la bitacora de articulos no integrados", e);
		}
	}
	
	@Override
	public void actualizarArticuloIntegracion(Integer codigoCompania, Long secuencial, String observacion)throws SICException{
		StringBuilder query = new StringBuilder();
		Session session;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			query.append("update ").append(ArticuloPendienteIntegracionDTO.class.getName()).append(" a set a.observacion=:pObservacion where a.id.codigoCompania=:pCompania and a.id.secuencial=:pSecuencial");
			Query update = session.createQuery(query.toString());
			update.setInteger("pCompania", codigoCompania);
			update.setLong("pSecuencial", secuencial);
			update.setString("pObservacion", observacion);
			update.executeUpdate();
		} catch (Exception e) {
			throw new SICException("Error al actualizar la observacion de un articulo no integrado", e);
		}
	}
	
	@Override
	public Boolean consultarExistenciaArticulosIntegrados(Integer codigoCompania, String[] codigosArticulos) throws SICException {
		Session session;
		StringBuilder query;
		Query hqlQuery = null;
		try {
			query = new StringBuilder();
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			//Armamos el query
			query.append(" Select count(apint.codigoArticulo) from ").append(ArticuloPendienteIntegracionDTO.class.getName()).append(" apint ");
			query.append(" where apint.codigoArticulo in (:pCodigosArticulo)");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setParameterList("pCodigosArticulo", codigosArticulos);
			if (hqlQuery.uniqueResult() instanceof Integer) {
				return ((Integer)hqlQuery.uniqueResult()) > 0 ? Boolean.TRUE : Boolean.FALSE;
			} else {
				return ((Long)hqlQuery.uniqueResult()) > 0 ? Boolean.TRUE : Boolean.FALSE;
			}
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al consultar articulo en articulos no integrados",e);
			throw new  SICException("Error al consultar articulo en articulos no integrados",e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloPendienteIntegracionDTO> obtenerArticulosPendientesIntegracionPorProceso(Integer codigoCompania, String valorTipoProceso) throws SICException {
		Collection<ArticuloPendienteIntegracionDTO> articulosPenInt = null;
		Session session = null;
		Criteria criteria = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(valorTipoProceso)){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				
				criteria = session.createCriteria(ArticuloPendienteIntegracionDTO.class, "api");
				criteria.add(Restrictions.eq("api.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("api.codigoTipoProceso", TipoCatalogoArticulo.TIPO_PROCESO_INTEGRACION));
				criteria.add(Restrictions.eq("api.valorTipoProceso", valorTipoProceso));
				criteria.add(Restrictions.eq("api.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				criteria.addOrder(Order.asc("api.valorTipoProceso"));
				criteria.addOrder(Order.asc("api.fechaRegistro"));
				
				articulosPenInt = criteria.list();
			}
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al consultar articulos pendientes de integracion",e);
			throw new  SICException("Error al consultar articulos pendientes de integracion",e);
		}finally{
			session = null; criteria = null;
		}
		return articulosPenInt;
	}
	
	/**
	 * Realiza la consulta para obtener los art\u00EDculos que fallar\u00F3n en la integraci\u00F3n al SIC
	 * @param eventoDTO EventoDTO
	 */
	@Override
	public Collection<ArticuloPendienteIntegracionDTO> obtenerArticulosErrorIntegracionSic(Integer codigoCompania)throws SICException{
		Collection<ArticuloPendienteIntegracionDTO> articuloPendienteIntegracionList = null;
		Session session = null;
		Criteria criteria = null;
		try{
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloPendienteIntegracionDTO.class, "api");
			criteria.createAlias("articulo", "articulo", CriteriaSpecification.INNER_JOIN);
			criteria.createAlias("articulo.artBitCodBarCol", "artBitCodBarCol", CriteriaSpecification.INNER_JOIN);
			
			criteria.add(Restrictions.eq("api.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.isNotNull("api.observacion"));
			criteria.add(Restrictions.eq("api.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("artBitCodBarCol.estadoArticuloBitacora", SICConstantes.ESTADO_ACTIVO_NUMERICO));	
			
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("artBitCodBarCol.id.codigoBarras"),"articulo.codigoBarrasActivo.id.codigoBarras");
			projectionList.add(Projections.property("api.codigoArticulo"),"codigoArticulo");
	    	projectionList.add(Projections.property("api.observacion"),"observacion");
			
			criteria.setProjection(Projections.distinct(projectionList));
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloPendienteIntegracionDTO.class));
			articuloPendienteIntegracionList = criteria.list();
		}
		catch(Exception e){
			Logeable.LOG_SICV2.error("Error al consultar ArticuloPendienteIntegracionDTO",e);
			throw new  SICException("Error al consultar Articulos Pendientes Integracion",e);
		}
		return articuloPendienteIntegracionList;
	}

	@Override
	public ArticuloDTO obtenerArticuloResultadoIntegracionCondicionesComerciales(ArticuloDTO articuloDTO) throws SICException {
		ArticuloDTO articuloResultado = null;
		Session session = null;
		Criteria criteria = null;
		try{
			if(articuloDTO != null){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				
				criteria = session.createCriteria(ArticuloDTO.class, "art");
				criteria.add(Restrictions.eq("art.id.codigoCompania", articuloDTO.getId().getCodigoCompania()));
				criteria.add(Restrictions.eq("art.id.codigoArticulo", articuloDTO.getId().getCodigoArticulo()));
				
				
				
				criteria.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
				articuloResultado = (ArticuloDTO) criteria.uniqueResult();
				
				
				session.flush();
			}
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al consultar el articulo resultado condiciones comerciales pendiente de integracion",e);
			throw new  SICException("Error al consultar el articulo resultado condiciones comerciales pendiente de integracion",e);
		}finally{
			criteria = null; session = null;
		}
		return articuloResultado;
	}

	@Override
	public Collection<ArticuloProveedorDTO> obtenerArticulosProveedor(Integer codigoCompania, Set<String> codigosArticulos, Set<String> codigosProveedores) throws SICException {
		Session session = null;
		Criteria criteria = null;
		try{
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloProveedorDTO.class, "articuloProveedor");
			
			//alias
			criteria.createAlias("articuloProveedor.descuentoProveedorArticuloCol", "descuentoProveedorArticuloCol", CriteriaSpecification.LEFT_JOIN, Restrictions.eq("descuentoProveedorArticuloCol.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.createAlias("descuentoProveedorArticuloCol.equivalenciaPorcentajeDescuento", "equivalenciaPorcentajeDescuento", CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("descuentoProveedorArticuloCol.asignacionTipoDescuento", "asignacionTipoDescuento", CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("articuloProveedor.unidadesManejo", "unidadesManejo", CriteriaSpecification.LEFT_JOIN, Restrictions.eq("unidadesManejo.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			criteria.createAlias("unidadesManejo.articuloUnidadManejoDTO", "articuloUnidadManejo", CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("articuloUnidadManejo.tipoUnidadEmpaque", "tipoUnidadEmpaque", CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("articuloUnidadManejo.articuloUnidadManejoContenedoraCol", "articuloUnidadManejoContenedoraCol", CriteriaSpecification.LEFT_JOIN);
			
			criteria.createAlias("unidadesManejo.equivalenciaPorcentajeDescuentoCol", "equivalenciaPorcentajeDescuentoDTO", CriteriaSpecification.LEFT_JOIN);
			
			criteria.createAlias("articuloProveedor.articuloImportacion", "articuloImportacion", CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("articuloProveedor.articulo", "articulo", CriteriaSpecification.INNER_JOIN);
			criteria.createAlias("articulo.artBitCodBarCol", "artBitCodBarCol", CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("articuloProveedor.vistaProveedor", "vistaProveedor", CriteriaSpecification.INNER_JOIN);
			
			// Articulo proveedor
			criteria.add(Restrictions.eq("articuloProveedor.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("articuloProveedor.estadoArticuloProveedor", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("artBitCodBarCol.estadoArticuloBitacora", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.in("articulo.id.codigoArticulo", codigosArticulos));
			criteria.add(Restrictions.in("articuloProveedor.id.codigoProveedor", codigosProveedores));
			criteria.add(Restrictions.eq("asignacionTipoDescuento.codigoAsignacionTipoDescuento", EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO));
			criteria.add(Restrictions.eq("asignacionTipoDescuento.valorAsignacionTipoDescuento", EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento()));
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			
			return criteria.list();
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al consultar los articulos proveedores",e);
		}
		return null;
	}
	
	@Override
	public void registrarArticuloPendienteIntegracion(Integer codigoCompania, String codigoArticulo, String valorTipoProceso, String userId) throws SICException{
		try{
			ArticuloPendienteIntegracionDTO articuloPendienteIntegracionDTO = new ArticuloPendienteIntegracionDTO();
			articuloPendienteIntegracionDTO.getId().setCodigoCompania(codigoCompania);
			articuloPendienteIntegracionDTO.setCodigoArticulo(codigoArticulo);
			articuloPendienteIntegracionDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			articuloPendienteIntegracionDTO.setValorTipoProceso(valorTipoProceso);
			articuloPendienteIntegracionDTO.setCodigoTipoProceso(TipoCatalogoArticulo.TIPO_PROCESO_INTEGRACION);
			articuloPendienteIntegracionDTO.setIdUsuarioRegistro(userId);
			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			articuloPendienteIntegracionDTO.setFechaRegistro(currentTime);
			this.hibernateH.crearObjeto(articuloPendienteIntegracionDTO);
			
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al registrar articulos pendientes de integracion", e);
			throw new  SICException("Error al registrar articulos pendientes de integracion", e);
		}
	}
	
	/**
	 * Metodo que permite obtener los datos de los art\u00EDculos a validar
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigosArticulo 
	 * @return
	 * @throws SICException
	 */
	@Override
	public Collection<ValidarArticuloIDTO> obtenerDatosArticulosPorValidar(Integer codigoCompania, List<String> codigosArticulo) throws SICException{
		Session session = null;
		Criteria criteria = null;
		try{
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloValidacionSIC.class, "av")
			.add(Restrictions.eq("av.id.codigoCompania", codigoCompania))
			.add(Restrictions.eq("av.estadoIntegracion", SICConstantes.ESTADO_INACTIVO_NUMERICO))
			.add(Restrictions.isNull("av.observacion"));	
			
			ProjectionList projections = Projections.projectionList()
			.add(Projections.property("av.codigoArticulo"),"codigoBarras")
			.add(Projections.property("av.codigoClasificacion"),"codigoClasificacion")
			.add(Projections.property("av.codigoSubclasificacion"),"codigoSubClasificacion")
			.add(Projections.property("av.claseArticulo"),"claseArticulo")
			.add(Projections.property("av.pvp"),"pvp")
			.add(Projections.property("av.precioBase"),"precioBase")
			.add(Projections.property("av.estadoArticulo"),"estadoArticulo")
			.add(Projections.property("av.ean14UM1"),"unidadManejo1_codigoBarrasEAN14")
			.add(Projections.property("av.cantidadUM1"),"unidadManejo1_cantidad")
			.add(Projections.property("av.uniEmpUM1"),"unidadManejo1_unidadEmpaque")
		    .add(Projections.property("av.descDocUM1"),"unidadManejo1_descuentoDocenas")
			.add(Projections.property("av.ean14UM2"),"unidadManejo2_codigoBarrasEAN14")
			.add(Projections.property("av.cantidadUM2"),"unidadManejo2_cantidad")
			.add(Projections.property("av.uniEmpUM2"),"unidadManejo2_unidadEmpaque")
		    .add(Projections.property("av.descDocUM2"),"unidadManejo2_descuentoDocenas")
			.add(Projections.property("av.ean14UM3"),"unidadManejo3_codigoBarrasEAN14")
			.add(Projections.property("av.cantidadUM3"),"unidadManejo3_cantidad")
			.add(Projections.property("av.uniEmpUM3"),"unidadManejo3_unidadEmpaque")
		    .add(Projections.property("av.descDocUM3"),"unidadManejo3_descuentoDocenas")
			.add(Projections.property("av.ean14UM4"),"unidadManejo4_codigoBarrasEAN14")
			.add(Projections.property("av.cantidadUM4"),"unidadManejo4_cantidad")
			.add(Projections.property("av.uniEmpUM4"),"unidadManejo4_unidadEmpaque")
		    .add(Projections.property("av.descDocUM4"),"unidadManejo4_descuentoDocenas")
		    ;
			
			criteria.setProjection(projections);
			
			if(codigosArticulo != null && codigosArticulo.size() > 0){
				if( codigosArticulo.size() > 1){
					criteria.add(Restrictions.in("av.codigoArticulo", codigosArticulo));	
				}else{
					criteria.add(Restrictions.eq("av.codigoArticulo", codigosArticulo.get(0)));
				}
			}
			
			criteria.setResultTransformer(new MultiLevelResultTransformer(ValidarArticuloIDTO.class));
			
			return criteria.list();
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al consultar los datos de art\u00EDculos a validar.", e.getMessage());
			throw new SICException("Error al consultar los datos de art\u00EDculos a validar.", e);
		}
	}
	
	/**
	 * Metodo que permite consultar los art\u00EDculos a validar
	 * @author jgranda
	 * @param codigoCompania
	 * @param maxPageSize cantidad de paginacion de los articulos a obtener
	 * @return
	 * @throws SICException
	 */
	@Override
	public List<String> obtenerArticulosPorValidar(Integer codigoCompania, Integer maxPageSize) throws SICException{
		Session session = null;
		Criteria criteria = null;
		try{
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloValidacionSIC.class, "av")		
			.add(Restrictions.eq("av.id.codigoCompania", codigoCompania))
			.add(Restrictions.eq("estadoIntegracion", SICConstantes.ESTADO_INACTIVO_NUMERICO))
			.add(Restrictions.isNull("observacion"));	
			
			ProjectionList projections = Projections.projectionList()
			.add(Projections.property("av.id.codigoCompania"),"id.codigoCompania")
		    .add(Projections.property("av.codigoArticulo"),"codigoArticulo");
			
			criteria.setProjection(Projections.distinct(projections));		
			
			criteria.setFirstResult(0);
			
			criteria.setMaxResults(maxPageSize);					
			
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			
			return criteria.list();
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al consultar los art\u00EDculos a validar.", e.getMessage());
			throw new SICException("Error al consultar los art\u00EDculos a validar.", e);
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setHibernateH(IHibernateH<ArticuloPendienteIntegracionDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
}
