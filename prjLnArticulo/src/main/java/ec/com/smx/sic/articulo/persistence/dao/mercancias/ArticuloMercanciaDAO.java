/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao.mercancias;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.shard.ShardNamingStrategy;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.etiquetado.exception.EtiquetadoException;
import ec.com.smx.framework.gestor.ISequenceGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoCaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloCaracteristicasMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.ArticuloRangoExtensionGarantiaDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.mercancias.IArticuloMercanciaDAO;
import ec.com.smx.sic.cliente.persistencia.restricciones.comprador.ClasificacionPorFuncionario;

/**
 * @author eharo
 *
 */
public class ArticuloMercanciaDAO implements IArticuloMercanciaDAO, Logeable {

	private SessionFactory sessionFactory;
	private ISequenceGestor sequenceGestor;

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.mercancias.IArticuloMercanciaDAO#obtenerListaTipoCaracteristicas(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoCaracteristicaDTO> obtenerListaTipoCaracteristicas(final Integer codigoCompania) throws SICException {
		List<TipoCaracteristicaDTO> lstCaracteristicaDTO = null;
		Session session = null;
		Criteria criteria = null;
		try{
			if(codigoCompania != null){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
				
				criteria = session.createCriteria(TipoCaracteristicaDTO.class, "tipoCaracteristica");
				criteria.add(Restrictions.eq("tipoCaracteristica.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("tipoCaracteristica.status", SICConstantes.ESTADO_ACTIVO_LITERAL));
				
				lstCaracteristicaDTO = criteria.list();
				session.flush();
			}
		}catch(SICException e){
			LOG_SICV2.error("Ha ocurrido un error al obtener la lista de Tipo Caracteristica. {}", e.getMessage());
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al obtener la lista de Tipo Caracteristica. {}", e.getMessage());
		}finally{
			session = null;
			criteria = null;
		}
		return lstCaracteristicaDTO;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.mercancias.IArticuloMercanciaDAO#obtenerListaCaracteristicas(java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CaracteristicaDTO> obtenerListaCaracteristicas(Integer codigoCompania, Collection<Integer> tipoCaracteristicaId, String codigoArticulo) throws SICException {
		List<CaracteristicaDTO> lstCaracteristicas = null;
		Session session = null;
		Criteria criteria = null;
		try{
			if(codigoCompania != null && tipoCaracteristicaId != null && StringUtils.isNotEmpty(StringUtils.trim(codigoArticulo))){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
				
				criteria = session.createCriteria(CaracteristicaDTO.class, "caracteristica");
				criteria.add(Restrictions.eq("caracteristica.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("caracteristica.id.codigoArticulo", codigoArticulo));
				criteria.add(Restrictions.in("caracteristica.codigoTipoCaracterstica", tipoCaracteristicaId));
				criteria.add(Restrictions.eq("caracteristica.status", SICConstantes.ESTADO_ACTIVO_LITERAL));
				criteria.addOrder(Order.asc("caracteristica.orden"));
				
				lstCaracteristicas = criteria.list();
				session.flush();
			}
		}catch(SICException e){
			LOG_SICV2.error("Ha ocurrido un error al obtener la lista de caracter\u00EDsiticas disponibles. {}", e.getMessage());
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al obtener la lista de caracter\u00EDsiticas disponibles. {}", e.getMessage());
		}finally{
			session = null;
			criteria = null;
		}
		return lstCaracteristicas;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.mercancias.IArticuloMercanciaDAO#transGuardarCaracteristicas(java.lang.Integer, java.util.List)
	 */
	@Override
	public void transGuardarCaracteristicas(String usuario, List<CaracteristicaDTO> lstCaracteristicas) throws SICException {
		try{
			if(StringUtils.isNotEmpty(usuario) && CollectionUtils.isNotEmpty(lstCaracteristicas)){
				this.guardarActualizarCaracteristicas(usuario, lstCaracteristicas);
			}
		}catch(SICException e){
			LOG_SICV2.error("{}", e.getMessage());
			throw e;
		}catch (Exception e) {
			LOG_SICV2.error("{}", e.getMessage());
			throw new SICException(e.getMessage());
		}
	}
	
	
	/**
	 * Metodo que permite saber si una caracteristica ingresada existe
	 * @param caracteristicaDTO
	 * @return
	 * @throws SICException
	 */
	private CaracteristicaDTO verificarExisteCaracteristica(CaracteristicaDTO caracteristicaDTO) throws SICException{
		CaracteristicaDTO caracteristica = null;
		Session session = null;
		Criteria criteria = null;
		try{
			if(caracteristicaDTO != null){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
				
				criteria = session.createCriteria(CaracteristicaDTO.class, "caracteristica");
				criteria.add(Restrictions.eq("caracteristica.id.codigoCompania", caracteristicaDTO.getId().getCodigoCompania()));
				criteria.add(Restrictions.eq("caracteristica.id.codigoArticulo", caracteristicaDTO.getId().getCodigoArticulo()));
				criteria.add(Restrictions.eq("caracteristica.id.secuencialCaracteristica", caracteristicaDTO.getId().getSecuencialCaracteristica()));
				
				caracteristica = (CaracteristicaDTO) criteria.uniqueResult();
				
				session.flush();
			}
		}catch(SICException e){
			LOG_SICV2.error("Ha ocurrido un error al verificar si existe la caracter\u00EDstica. {}", e.getMessage());
			throw e;
		}catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error al verificar si existe la caracter\u00EDstica. {}", e.getMessage());
			throw new SICException("Ha ocurrido un error al verificar si existe la caracter\u00EDstica", e.getMessage());
		}finally{
			session = null;
			criteria = null;
		}
		return caracteristica;
	}
	
	/**
	 * Metodo que permite crear una nueva caracteristica para el articulo
	 * @param usuario
	 * @param tipoCaracteristicaId
	 * @param caracteristica
	 */
	private void crearNuevaCaracteristica(String usuario, CaracteristicaDTO caracteristica) {
		Session session = null;
		try{
			if(caracteristica != null){
				LOG_SICV2.info("se va a crear {}", caracteristica.getDescription());
				
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
				

				caracteristica.getId().setSecuencialCaracteristica(this.obtenerSecuenciaCaracteristicas(caracteristica.getId().getCodigoCompania(), "SECSICCARACTERISTICA"));
				caracteristica.setStatus(SICConstantes.ESTADO_ACTIVO_LITERAL);
				caracteristica.setRegisterUserId(usuario);
				caracteristica.setRegisterDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
				
				session.save(caracteristica);
				session.flush();
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al intentar guardar la caracter\u00EDstica. {}", e.getMessage());
		}
		finally{
			session = null;
		}
	}
	
	/**
	 * Metodo que permite actualizar una caracteristica
	 * @param usuario
	 * @param caracteristica
	 */
	private void actualizarCaracteristica(String usuario, CaracteristicaDTO caracteristica) {
		Session session = null;
		try{
			if(caracteristica != null){
				LOG_SICV2.info("se va a actualziar {}", caracteristica.getDescription());
				
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
				
				caracteristica.setLastModifierUserId(usuario);
				caracteristica.setLastModificationDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
				
				session.update(caracteristica);
				session.flush();
				
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al intentar actualizar la caracter\u00EDstica. {}", e.getMessage());
		}finally{
			session = null;
		}
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.mercancias.IArticuloMercanciaDAO#transEliminarCaracteristica(ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDTO)
	 */
	@Override
	public void transEliminarCaracteristica(String usuario, Set<CaracteristicaDTO> caracteristicasEliminar) throws SICException {
		try{
			if(caracteristicasEliminar != null){
				for(CaracteristicaDTO caracteristica : caracteristicasEliminar){
					LOG_SICV2.info("se va a eliminar {}", caracteristica.getDescription());
					caracteristica.setStatus(SICConstantes.ESTADO_INACTIVO_LITERAL);
					this.actualizarCaracteristica(usuario, caracteristica);
				}
				
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al eliminar la caracter\u00EDstica", e.getMessage());
		}finally{
//			session = null;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.mercancias.IArticuloMercanciaDAO#transGuardarCaracteristicas(java.lang.String, java.util.Collection)
	 */
	@Override
	public void transGuardarCaracteristicas(String usuario, Collection<CaracteristicaDTO> lstCaracteristicas) throws SICException {
		List<CaracteristicaDTO> lstCaracteristicaDTO = null;
		try{
			if(StringUtils.isNotEmpty(usuario) && CollectionUtils.isNotEmpty(lstCaracteristicas)){
				LOG_SICV2.info("Usuario: {}", usuario);
				LOG_SICV2.info("Actualizar: {} caracteristicas", lstCaracteristicas.size());
				for(CaracteristicaDTO dto : lstCaracteristicas){
					LOG_SICV2.info("Secuencial: {}", dto.getId().getSecuencialCaracteristica());
					LOG_SICV2.info("Descripcion: {}", dto.getDescription());
					LOG_SICV2.info("Orden: {}", dto.getOrden());
					LOG_SICV2.info("Estado: {}", dto.getStatus());
					LOG_SICV2.info("Tipo Caracteristica: {}", dto.getCodigoTipoCaracterstica());
				}
				lstCaracteristicaDTO = new ArrayList<CaracteristicaDTO>();
				lstCaracteristicaDTO.addAll(lstCaracteristicas);
				this.guardarActualizarCaracteristicas(usuario, lstCaracteristicaDTO);
			}
		}catch(SICException e){
			throw e;
		}catch (Exception e) {
			throw new SICException(e);
		}finally{
			lstCaracteristicaDTO = null;
		}
	}

	private void guardarActualizarCaracteristicas(String usuario, List<CaracteristicaDTO> lstCaracteristicas){
		CaracteristicaDTO caracteristicaTmp = null;
		try{
			if(StringUtils.isNotEmpty(usuario) && CollectionUtils.isNotEmpty(lstCaracteristicas)){
				for(CaracteristicaDTO caracteristica : lstCaracteristicas){
					 caracteristicaTmp = verificarExisteCaracteristica(caracteristica);
					 if(caracteristicaTmp != null){
						 caracteristicaTmp.setOrden(caracteristica.getOrden());
						 caracteristicaTmp.setDescription(caracteristica.getDescription());
						 caracteristicaTmp.setStatus(caracteristica.getStatus());
						 this.actualizarCaracteristica(usuario, caracteristicaTmp);
					 }else{
						 this.crearNuevaCaracteristica(usuario, caracteristica);
					 }
				}
			}
		}catch(SICException e){
			LOG_SICV2.error("Ha ocurrido un error al guardar las caracter\u00EDsticas. {}", e.getMessage());
			throw e;
		}catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error al guardar las caracter\u00EDsticas. {}", e.getMessage());
			throw new SICException("Ha ocurrido un error al guardar las caracter\u00EDsticas", e.getMessage());
		}
	}
	
	/**
	 * Metodo que permite obtener el secuencial de las caracteristicas
	 * @param codigoComapania
	 * @param nombreSecuencia
	 * @return
	 */
	private Long obtenerSecuenciaCaracteristicas(Integer codigoComapania, String nombreSecuencia){
		Long secuencia = null;
		try{
			secuencia = Long.valueOf(this.sequenceGestor.getSequenceValue(nombreSecuencia + "_" + codigoComapania));
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al obtener la secuencia de las caracter\u00EDsticas. {}", e.getMessage());
		}
		return secuencia;
	}
	
	/**
	 * Criteria articulos sin promocion
	 * @param codigoCompania
	 * @param areaTrabajo
	 * @param codigoClasificacion
	 * @return
	 */
	@SuppressWarnings("static-access")
	public Criteria criteriaArticuloSinPromocion(Integer codigoCompania,Integer areaTrabajo, String codigoClasificacion){
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
					
			LOG_SICV2.info("**** Crear sql para articulos sin promocion ****");
			
			DetachedCriteria subQuery = DetachedCriteria.forClass(ArticuloLocalPrecioDTO.class, "articuloLocalPrecio");
			subQuery.setProjection(Projections.property("articuloLocalPrecio.id.codigoArticulo"));
			subQuery.createCriteria("articuloLocalPrecio.articuloPrecio","articuloPrecioDTO", CriteriaSpecification.INNER_JOIN);
			subQuery.add(Restrictions.eq("articuloLocalPrecio.id.codigoLocal", areaTrabajo));
			subQuery.add(Restrictions.eq("articuloLocalPrecio.id.codigoTipoPrecio", SICArticuloConstantes.TIPO_PRECIO_BASE));
			subQuery.add(Restrictions.eq("articuloLocalPrecio.estadoPrecio", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			subQuery.add(Restrictions.ne("articuloPrecioDTO.valorActual", 0D));
			
			Criteria criteria = session.createCriteria(ArticuloDTO.class, "articuloDTO");
			
			//relacion con clasificacion 
			criteria.createCriteria("articuloDTO.artBitCodBarCol","articuloBitacora",CriteriaSpecification.INNER_JOIN, Restrictions.eq("articuloBitacora.estadoArticuloBitacora", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			criteria.createCriteria("articuloDTO.clasificacionDTO","clasificacionDTO",CriteriaSpecification.LEFT_JOIN); 
			
			//Restricciones
			criteria.add(Restrictions.eq("articuloDTO.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("articuloDTO.estadoArticulo", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("articuloDTO.codigoClasificacion", codigoClasificacion));
			criteria.add(Property.forName("articuloDTO.id.codigoArticulo").notIn(subQuery));	
			
			criteria.setProjection(Projections.property("articuloDTO.id.codigoArticulo"));
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		
			return criteria;
		} catch (Exception e) {
			LOG_SICV2.error(e+"");
			 throw new EtiquetadoException();
		}
	}
	
	/**
	 * @author dbravo
	 * Criteria para articulos con promocion
	 * @param codigoCompania
	 * @param areaTrabajo
	 * @param codigoClasificacion
	 * @return
	 */
	public Criteria criteriaArticuloPromocion(Integer codigoCompania,Integer areaTrabajo, String codigoClasificacion){
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
			articuloLocalDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL);
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloLocalDTO);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
			
			Criteria criteria = session.createCriteria(ArticuloDTO.class, "articuloDTO");
			
			//Relacion con scsadtartbitcodbar
			criteria.createCriteria("articuloDTO.artBitCodBarCol","articuloBitacora",CriteriaSpecification.INNER_JOIN, Restrictions.eq("articuloBitacora.estadoArticuloBitacora", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			//Relacion con scsadtartcom
			criteria.createCriteria("articuloDTO.articuloComercialDTO","articuloComercialDTO",CriteriaSpecification.LEFT_JOIN);
			//Relacion con scsadtmarca
			criteria.createCriteria("articuloComercialDTO.marcaComercialArticulo","marcaComercialArticulo",CriteriaSpecification.LEFT_JOIN);
			//Relacion con scsadtartgar
			criteria.createCriteria("articuloDTO.articuloGarantiaDTO","articuloGarantiaDTO",CriteriaSpecification.LEFT_JOIN);
			//relacion articuloLocal
			criteria.createCriteria("articuloDTO.articuloLocalCol","articuloLocalDTO",CriteriaSpecification.LEFT_JOIN);
			//Relacion con scspetclasificacion 
			criteria.createCriteria("articuloDTO.clasificacionDTO","clasificacionDTO",CriteriaSpecification.LEFT_JOIN);			
			
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("estadoArticulo", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("codigoClasificacion", codigoClasificacion));
			criteria.add(Restrictions.eq("articuloLocalDTO.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("articuloLocalDTO.id.codigoLocal", areaTrabajo));
			criteria.add(Restrictions.eq("articuloLocalDTO.estadoArticuloLocal", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("clasificacionDTO.valorTipoEstructura", CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL));
			criteria.add(Restrictions.eq("clasificacionDTO.codigoTipoEstructura", TiposCatalogoConstantes.TIPO_ESTRUCTURA));
			
			criteria.setProjection(Projections.property("articuloDTO.id.codigoArticulo"));
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			
			return criteria;
		} catch (Exception e) {
			LOG_SICV2.error(e+"");
			throw new EtiquetadoException();
		}
	}
	
	/**
	 * Metodo obtiene criteria de todos los articulos con/sin promocion
	 * @param codigoCompania
	 * @param areaTrabajo
	 * @param codigoClasificacion
	 * @return
	 */
	public Criteria crearCriteriaTodosArticulos(Integer codigoCompania,Integer areaTrabajo, String codigoClasificacion){
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			Criteria criteria = session.createCriteria(ArticuloDTO.class, "articuloDTO");
			
			//Relacion con scsadtartbitcodbar
			criteria.createCriteria("articuloDTO.artBitCodBarCol","articuloBitacora",CriteriaSpecification.INNER_JOIN, Restrictions.eq("articuloBitacora.estadoArticuloBitacora", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			//Relacion con scsadtartcom
			criteria.createCriteria("articuloDTO.articuloComercialDTO","articuloComercialDTO",CriteriaSpecification.LEFT_JOIN);
			//Relacion con scsadtmarca
			criteria.createCriteria("articuloComercialDTO.marcaComercialArticulo","marcaComercialArticulo",CriteriaSpecification.LEFT_JOIN);
			//Relacion con scsadtartgar
			criteria.createCriteria("articuloDTO.articuloGarantiaDTO","articuloGarantiaDTO",CriteriaSpecification.LEFT_JOIN);
			//Relacion con scspetclasificacion 
			criteria.createCriteria("articuloDTO.clasificacionDTO","clasificacionDTO",CriteriaSpecification.LEFT_JOIN);			
			
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("estadoArticulo", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("codigoClasificacion", codigoClasificacion));
			criteria.add(Restrictions.eq("clasificacionDTO.valorTipoEstructura", CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL));
			criteria.add(Restrictions.eq("clasificacionDTO.codigoTipoEstructura", TiposCatalogoConstantes.TIPO_ESTRUCTURA));
			
			criteria.setProjection(Projections.property("articuloDTO.id.codigoArticulo"));
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			
			return criteria;
		} catch (Exception e) {
			LOG_SICV2.error(e+"");
			 throw new EtiquetadoException();
		}
	}
	
	/**
	 * Metodo que obtiene registros de etiquetas masivas paginados
	 * first: numero pagina
	 * pageSize: numero registros por pagina
	 * promocion: T = todos, SI = articulos con promocion, NO = articulos sin promocion
	 * page
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<String> obtenerArticuloPaginado(Integer first, Integer pageSize, Integer codigoCompania,Integer areaTrabajo, String codigoClasificacion, String promocion) throws SICException{
		Collection<String> codigoArticulo = new ArrayList<String>();
		
		try {
			Criteria criteria = null;
			
			if (promocion.equals(SICConstantes.SELECCION_SI)) {
				//Articulos con promocion 
				criteria = criteriaArticuloPromocion(codigoCompania, areaTrabajo, codigoClasificacion);	
				criteria.setFirstResult(first);
				criteria.setMaxResults(pageSize);
				criteria.addOrder(Order.asc("id.codigoArticulo"));
				codigoArticulo = criteria.list();
				return codigoArticulo;
			} else if (promocion.equals(SICConstantes.SELECCION_NO)) {
				//Articulos sin promocion 
				criteria = criteriaArticuloSinPromocion(codigoCompania, areaTrabajo, codigoClasificacion);			
				criteria.setFirstResult(first);
				criteria.setMaxResults(pageSize);
				criteria.addOrder(Order.asc("id.codigoArticulo"));
				codigoArticulo = criteria.list();
				return codigoArticulo;
			  } else {
				//Todos los articulos
				criteria = crearCriteriaTodosArticulos(codigoCompania, areaTrabajo, codigoClasificacion);		
				criteria.setFirstResult(first);
				criteria.setMaxResults(pageSize);
				criteria.addOrder(Order.asc("id.codigoArticulo"));
				codigoArticulo = criteria.list();
				return codigoArticulo;
			  }
		} catch (Exception e) {
			LOG_SICV2.error(e+"");
    		throw new EtiquetadoException();
		}
		
	}
	
	/**
	 * Obtiene el total de registros de articulos 
	 */
	@Override
	public Integer totalRegistrosEtiquetaMercanciaMasiva(Integer codigoCompania, Integer areaTrabajo, String codigoClasificacion, String promocion) throws SICException {
		try {
			Criteria criteria = null;
			if (promocion.equals(SICConstantes.SELECCION_SI)) {
				criteria = criteriaArticuloPromocion(codigoCompania, areaTrabajo, codigoClasificacion);
				criteria.setProjection(Projections.rowCount());
				Long totalRegistros = (Long) criteria.uniqueResult();
				LOG_SICV2.info("Total registros : "+totalRegistros.intValue());
				return totalRegistros.intValue();
			}else if (promocion.equals(SICConstantes.SELECCION_NO)) {
				criteria = criteriaArticuloSinPromocion(codigoCompania, areaTrabajo, codigoClasificacion);
				criteria.setProjection(Projections.rowCount());
				Long totalRegistros = (Long) criteria.uniqueResult();
				LOG_SICV2.info("Total registros : "+totalRegistros.intValue());
				return totalRegistros.intValue();
			} else{
				criteria = crearCriteriaTodosArticulos(codigoCompania, areaTrabajo, codigoClasificacion);
				criteria.setProjection(Projections.rowCount());
				Long totalRegistros = (Long) criteria.uniqueResult();
				LOG_SICV2.info("Total registros : "+totalRegistros.intValue());
				return totalRegistros.intValue();
			}
			
		} catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Metodo que obtiene las caracteristicas de las etiquetas masivas
	 * codigoArtBarCol : coleccion de codigo de Barra o codigo Articulo
	 * esCodigoBarra: parametro Boolean TRUE = codigoArtBarCol es coleccion de codigo de Barras
	 */
	@SuppressWarnings({ "unchecked", "static-access", "deprecation"})
	@Override
	public Collection<ArticuloDTO> obtenerArticulosParaCaracteristicasMercancia(Integer codigoCompania,Collection<String> codigoArtBarCol, Boolean esCodigoBarra,Integer areaTrabajoFuncionario,String codigoClasificacion)throws SICException{
		try {
			if (codigoArtBarCol != null && CollectionUtils.isNotEmpty(codigoArtBarCol)) {
				Session session = null;
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				
				ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
				articuloLocalDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL);
				Collection<Object> entities = new ArrayList<Object>();
				entities.add(articuloLocalDTO);
				ShardNamingStrategy.SHARD_RESOLVER.set(entities);
				
				Date currentDate = new Date();
				
				Criteria criteria = session.createCriteria(ArticuloDTO.class, "articuloDTO");
				//relacion articuloBitacora
				criteria.createCriteria("articuloDTO.artBitCodBarCol","articuloBitacora",CriteriaSpecification.LEFT_JOIN, Restrictions.eq("articuloBitacora.estadoArticuloBitacora", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
				//relacion articuloComercial
				criteria.createCriteria("articuloDTO.articuloComercialDTO","articuloComercialDTO",CriteriaSpecification.LEFT_JOIN);
				//relacion con marcaComercialArticulo
				criteria.createCriteria("articuloComercialDTO.marcaComercialArticulo","marcaArticuloDTO",CriteriaSpecification.LEFT_JOIN);
				//relacion con scsadtartgar
				criteria.createCriteria("articuloDTO.articuloGarantiaDTO","articuloGarantiaDTO",CriteriaSpecification.LEFT_JOIN);
				//Relacion con scsadtartimp
				criteria.createCriteria("articuloDTO.articuloImpuestoCol","articuloImpuestoDTO",CriteriaSpecification.LEFT_JOIN, Restrictions.eq("articuloImpuestoDTO.estadoArticuloImpuesto", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
				//Relacion con scsadttipimp
				criteria.createCriteria("articuloImpuestoDTO.tipoImpuestoArticulo","articuloTipoImpuestoDTO",CriteriaSpecification.LEFT_JOIN);
				//Relacion con scsadtgruimp
				criteria.createCriteria("articuloTipoImpuestoDTO.grupoImpuesto","grupoImpuestoDTO",CriteriaSpecification.LEFT_JOIN, Restrictions.eq("grupoImpuestoDTO.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)); 
				//Relacion con SCSADTARTLOC
				Criterion conjuntion = Restrictions.conjunction().add(Restrictions.eq("articuloLocalDTO.estadoArticuloLocal", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)).add(Restrictions.le("articuloLocalDTO.fechaInicialAlcance", currentDate))
										.add(Restrictions.ge("articuloLocalDTO.fechaFinalAlcance", currentDate)).add(Restrictions.eq("articuloLocalDTO.id.codigoLocal", areaTrabajoFuncionario));
				criteria.createCriteria("articuloDTO.articuloLocalCol","articuloLocalDTO",CriteriaSpecification.LEFT_JOIN,conjuntion); // estado, fechaInicialAlcance, fechafinalalcance, codigolocal
				//Relacion con scsadtartmed 
				criteria.createCriteria("articuloDTO.articuloMedidaDTO","articuloMedidaDTO",CriteriaSpecification.LEFT_JOIN);
				//Relacion con scsadtartpre
				criteria.createCriteria("articuloDTO.articuloPrecioCol","articuloPrecioDTO",CriteriaSpecification.LEFT_JOIN, Restrictions.eq("articuloPrecioDTO.estadoPrecio", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)); 
				//Relacion con scsadtartlocpre
				criteria.createCriteria("articuloPrecioDTO.articuloLocalPrecioCol","articuloLocalPrecioDTO",CriteriaSpecification.LEFT_JOIN, Restrictions.and(Restrictions.eq("articuloLocalPrecioDTO.estadoPrecio", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO), Restrictions.eq("articuloLocalPrecioDTO.id.codigoLocal", areaTrabajoFuncionario)));//estado, codigoLocal
				//Relacion con scsadtartuniman
				criteria.createCriteria("articuloPrecioDTO.articuloUnidadManejo","articulUnidadManejoDTO",CriteriaSpecification.LEFT_JOIN);
				//Relacion con scsadtartunimanuso
				criteria.createCriteria("articulUnidadManejoDTO.articuloUnidadManejoUsoCol","articuloUnidadManejoUsoDTO",CriteriaSpecification.LEFT_JOIN);
				//Relacion con scsadttippreart
				criteria.createCriteria("articuloPrecioDTO.tipoPrecioArticulo","tipoPrecioArticuloDTO",CriteriaSpecification.LEFT_JOIN);
				//Relacion con scsadtartpro
				criteria.createCriteria("articuloDTO.articuloProveedorCol","articuloProveedorDTO",CriteriaSpecification.LEFT_JOIN);
				//relacion con caracteristicaArticulo
				criteria.createCriteria("articuloDTO.caracteristicaDTOSet","caracteristicaArticuloDTO",CriteriaSpecification.LEFT_JOIN, Restrictions.eq("caracteristicaArticuloDTO.status", SICConstantes.ESTADO_ACTIVO_LITERAL));
				//Relacion con scspetclasificacion 
				criteria.createCriteria("articuloDTO.clasificacionDTO","clasificacionDTO",CriteriaSpecification.LEFT_JOIN);
				//Relacion con scsadtdesvenart 
				criteria.createCriteria("articuloDTO.descuentoVentaArticuloCol","descuentoVentaArticuloDTO",CriteriaSpecification.LEFT_JOIN, Restrictions.eq("descuentoVentaArticuloDTO.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			
				criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("estadoArticulo", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
				//valida si debe realizar consula por codigo de barra o codigo articulo
				if(esCodigoBarra == Boolean.TRUE){
					criteria.add(Restrictions.in("articuloBitacora.id.codigoBarras", codigoArtBarCol));
				}else{
					criteria.add(Restrictions.in("id.codigoArticulo", codigoArtBarCol)); 
				}
				//valida si debe realizar consulta por codigo de clasificacion
				if (codigoClasificacion != null) {
					criteria.add(Restrictions.eq("codigoClasificacion", codigoClasificacion));
				}
				criteria.add(Restrictions.eq("clasificacionDTO.valorTipoEstructura", CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL));
				criteria.add(Restrictions.eq("clasificacionDTO.codigoTipoEstructura", TiposCatalogoConstantes.TIPO_ESTRUCTURA));
				criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
				return (Collection<ArticuloDTO>)criteria.list();
			}else{
				LOG_SICV2.error("La coleccion de codigo articulos es nula");
				throw new SICException();
			}
				
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error al obtener la lista de Tipo Caracteristica. {}", e.getMessage());
			throw new SICException(e);
		}
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<VistaArticuloCaracteristicasMercanciaDTO> obtenerCaracterisiticasMercancias(Integer codigoCompania,String codigoBarras,String areaTrabajoFuncionario)throws SICException{
		/**
		 * PARAMETROS
		 */
		/**String codigoBarras="7705855015560";
		Integer codigoCompania=1;
		String areaTrabajoFuncionario="0";*/
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			StringBuilder sql = new StringBuilder();
			Map<String, Object> parameterMap =new HashMap<String, Object>();
			sql.append("SELECT ROWNUMBER() OVER()  {vista.id.rowId}, "
					  +"       ART.CODIGOARTICULO {vista.codigoArticulo},"
					  +"       ART.CODIGOCOMPANIA {vista.codigoCompania}, "
					  +"       ARTBIT.CODIGOBARRAS {vista.codigoBarras}, "
					  +"       ART.DESCRIPCIONARTICULO {vista.descripcionArticulo}," 
					  +"       ARTCOMERCIAL.VALORTIPOCONTROLCOSTO {vista.comercialValorTipoCosto}, "
					  +"       ARTCOMERCIAL.PESOAPROXIMADOVENTA {vista.comercialPesoAproximadoVenta}, "
					  +"       ARTCOMERCIAL.PORCENTAJENOAFILIADO {vista.comercialPorcentajeNoAfiliado}, "
					  +"	   ARTCOMERCIAL.TIENEPRECIOFIJO {vista.comercialTienePrecioFijo}, "
				      +"       ARTCOMERCIAL.VENTAPRECIOAFILIADO {vista.comercialVentaPrecioAfiliado}, "
					  +"       ARTGARANTIA.ESTADOEXTENSIONGARANTIA {vista.garantiaEstadoExtensionGarantia}," 
					  +"       ARTMARCA.NOMBRE {vista.nombreMarca}, "
					  +"       ARTPROVEEDOR.CODIGOPROVEEDOR {vista.codigoProveedor}," 
					  +"       ARTPROVEEDOR.CODIGOREFERENCIAPROVEEDOR {vista.codigoReferenciaProveedor}," 
					  +"       ARTCARACTERISTICA.SECUENCIALCARACTERISTICA {vista.caracteristicaSecuancialCaracteristica}," 
					  +"       ARTCARACTERISTICA.CODIGOTIPOCARACTERSTICA {vista.caracteristicaCodigoTipoCaracteristica}, "
					  +"       ARTCARACTERISTICA.DESCRIPCION {vista.caracteristicaDescripcionCaracteristica}, "
					  +"       ARTCARACTERISTICA.ORDEN {vista.caracteristicaOrden}, "
					  +"       CLASIFICACION.CODIGOCLASIFICACION {vista.clasificacionCodigoClasificacion}," 
					  +"       ARTLOCAL.CODIGOLOCAL {vista.localCodigoLocal}, "
					  +"       ARTPRECIO.CODIGOTIPOPRECIO {vista.precioCodigoTipoPrecio}," 
					  +"       ARTPRECIO.CODIGOUNIDADMANEJO {vista.precioCodigoUnidadManejo}," 
					  +"       ARTPRECIO.VALORACTUAL {vista.precioValorActual}," 
					  +"       ARTPRECIO.VALORANTERIOR {vista.precioValorAnterior}," 
					  +"       ARTPRECIOLOCAL.CODIGOLOCAL {vista.precioLocalCodigoLocal}," 
					  +"       ARTPRECIOLOCAL.CODIGOTIPOPRECIO {vista.precioLocalcodigoTipoPrecio}," 
					  +"       ARTPRECIOLOCAL.VALORACTUAL {vista.precioLocalValorActual},"
					  +"       ARTPRECIOLOCAL.VALORANTERIOR {vista.precioLocalValorAnterior},"
					  +"       ARTUNIDADMANEJO.CODIGOUNIDADMANEJO {vista.unidadManejoCodigoUnidadManejo}," 
					  +"       ARTUNIDADMANEJO.VALORUNIDADMANEJO {vista.unidadManejoValorUnidadManejo}, "
					  +"       ARTUNIDADMANEJOUSO.VALORTIPOUSO {vista.unidadManejoUsoValorTipoUso}, "
					  +"       ARTUNIDADMANEJOUSO.CODIGOUNIDADMANEJO {vista.unidadManejoUsoCodigoUnidadManejo}," 
					  +"       ARTUNIDADMANEJOUSO.CODIGOTIPOUSO {vista.unidadManejoUsoCodigoTipoUso}, "
					  +"       ARTDESCUENTOVENTA.CODIGOTIPODESCUENTO {vista.descuentoVentaCodigoTipoDescuento}," 
					  +"       ARTDESCUENTOVENTA.PORCENTAJEDESCUENTO {vista.descuentoVentaPorcentajeDescuento}, "
					  +"       ARTDESCUENTOVENTA.VALORDESCUENTO {vista.valorDescuentoValorDestuento}, "
					  +"       ARTIIMPUESTO.CODIGOTIPOIMPUESTO {vista.impuestoCodigoTipoImpuesto}, "
					  +"       ARTIIMPUESTO.ESPARAVENTA {vista.impuestoEsParaVenta}, "
					  +"       TIPOIMPUESTO.CODIGOGRUPOIMPUESTO {vista.tipoImpuestoGrupoImpuesto}, "
					  +"       TIPOIMPUESTO.PORCENTAJEIMPUESTO {vista.tipoImpuestoPorcentajeImpuesto} "
					  +"FROM   SCSPETARTICULO ART "
					 // +"       --codigo de barras  "  
					  +"       INNER JOIN SCSADTARTBITCODBAR ARTBIT " 
					  +"               ON ART.CODIGOARTICULO = ARTBIT.CODIGOARTICULO "
					  +"                  AND ART.CODIGOCOMPANIA = ARTBIT.CODIGOCOMPANIA "
					  +"                  AND ARTBIT.ESTADOARTICULOBITACORA =:estado "
					 // +"       --articuloComercial    "
					  +"       LEFT JOIN SCSADTARTCOM ARTCOMERCIAL "
					  +"              ON ART.CODIGOARTICULO = ARTCOMERCIAL.CODIGOARTICULO " 
					  +"                 AND ART.CODIGOCOMPANIA = ARTCOMERCIAL.CODIGOCOMPANIA " 
					  +"       LEFT OUTER JOIN SCSADTMARCA ARTMARCA "
					  +"                    ON ARTCOMERCIAL.CODIGOCOMPANIA = ARTMARCA.CODIGOCOMPANIA "
					  +"                       AND ARTCOMERCIAL.CODIGOMARCACOMERCIAL = ARTMARCA.SECUENCIALMARCA "
					  +"       LEFT OUTER JOIN SCSADTARTGAR ARTGARANTIA "
					  +"                    ON ART.CODIGOARTICULO = ARTGARANTIA.CODIGOARTICULO "
					  +"                       AND ART.CODIGOCOMPANIA = ARTGARANTIA.CODIGOCOMPANIA "
					  +"       LEFT OUTER JOIN "
					  //+"       --RELACION con proveedor para  obtenerCodigoReferencia    "
					  +"       SCSADTARTPRO ARTPROVEEDOR "
					  +"                    ON ART.CODIGOARTICULO = ARTPROVEEDOR.CODIGOARTICULO " 
					  +"                       AND ART.CODIGOCOMPANIA = ARTPROVEEDOR.CODIGOCOMPANIA " 
					  +"       LEFT OUTER JOIN "
					  //+"       --RELACION con carqacterisicas "        
					  +"       SCSADTCARACTERISTICA ARTCARACTERISTICA " 
					  +"                    ON ART.CODIGOARTICULO = ARTCARACTERISTICA.CODIGOARTICULO " 
					  +"                       AND ART.CODIGOCOMPANIA = ARTCARACTERISTICA.CODIGOCOMPANIA " 
					  +"                       AND ARTCARACTERISTICA.ESTADO =:estadoLiteral "
					  //+"       --Relacion con clasificacion        "
					  +"       LEFT OUTER JOIN SCSPETCLASIFICACION CLASIFICACION " 
					  +"                    ON ART.CODIGOCLASIFICACION = CLASIFICACION.CODIGOCLASIFICACION " 
					  +"                       AND ART.CODIGOCOMPANIA = CLASIFICACION.CODIGOCOMPANIA  "
					  +"                       AND CLASIFICACION.VALORTIPOESTRUCTURA =:valorTipoEstruc "
					  +"                       AND CLASIFICACION.CODIGOTIPOESTRUCTURA =:codigoTipoEstruc "
					  //+"       --relacion con articuloLocal   "
					  +"       LEFT OUTER JOIN SCSADTARTLOC ARTLOCAL "
					  +"                    ON ART.CODIGOARTICULO = ARTLOCAL.CODIGOARTICULO "
					  +"                       AND ART.CODIGOCOMPANIA = ARTLOCAL.CODIGOCOMPANIA "
					  +"                       AND ARTLOCAL.ESTADOARTICULOLOCAL =:estado "
					  +"                       AND ARTLOCAL.FECHAINICIALALCANCE <=:currentDate "
					  +"                       AND ARTLOCAL.FECHAFINALALCANCE >=:currentDate"
					  +"                       AND ARTLOCAL.CODIGOLOCAL =:areaTrabajo "
					 // +"       --relacion con articuloPrecio      "
					  +"       LEFT OUTER JOIN SCSADTARTPRE ARTPRECIO "
					  +"                    ON ART.CODIGOARTICULO = ARTPRECIO.CODIGOARTICULO "
					  +"                       AND ART.CODIGOCOMPANIA = ARTPRECIO.CODIGOCOMPANIA "
					  +"                       AND ARTPRECIO.ESTADOPRECIO =:estado "
					  +"       LEFT OUTER JOIN SCSADTARTLOCPRE ARTPRECIOLOCAL "
					  +"                    ON ARTPRECIO.CODIGOARTICULO = ARTPRECIOLOCAL.CODIGOARTICULO " 
					  +"                       AND ARTPRECIO.CODIGOCOMPANIA = ARTPRECIOLOCAL.CODIGOCOMPANIA "
					  +"                       AND ARTPRECIO.CODIGOTIPOPRECIO = ARTPRECIOLOCAL.CODIGOTIPOPRECIO "
					  +"                       AND ARTPRECIOLOCAL.ESTADOPRECIO =:estado "
					  +"                       AND ARTPRECIOLOCAL.CODIGOLOCAL =:areaTrabajo "
					  //+"       --relacion con unidad manejo       "
					  +"       LEFT OUTER JOIN SCSADTARTUNIMAN ARTUNIDADMANEJO "
					  +"                    ON ARTPRECIO.CODIGOARTICULO = ARTUNIDADMANEJO.CODIGOARTICULO "
					  +"                       AND ARTPRECIO.CODIGOCOMPANIA = ARTUNIDADMANEJO.CODIGOCOMPANIA "
					  +"                       AND ARTPRECIO.CODIGOUNIDADMANEJO = ARTUNIDADMANEJO.CODIGOUNIDADMANEJO "
					  +"       LEFT OUTER JOIN SCSADTARTUNIMANUSO ARTUNIDADMANEJOUSO "
					  +"                    ON ARTUNIDADMANEJO.CODIGOARTICULO = ARTUNIDADMANEJOUSO.CODIGOARTICULO "
					  +"                       AND ARTUNIDADMANEJO.CODIGOCOMPANIA = ARTUNIDADMANEJOUSO.CODIGOCOMPANIA "
					  +"                       AND ARTUNIDADMANEJO.CODIGOUNIDADMANEJO = ARTUNIDADMANEJOUSO.CODIGOUNIDADMANEJO "
					  //+"       --LEFT OUTER JOIN  "
					  //+"       --tipo de precion    "
					 // +"       --SCSADTTIPPREART TIPOPRECIO  "
					 // +"       --             ON ARTPRECIO.CODIGOCOMPANIA = TIPOPRECIO.CODIGOCOMPANIA  "
					 // +"       --                AND ARTPRECIO.CODIGOTIPOPRECIO = TIPOPRECIO.CODIGOTIPOPRECIO "  
					 // +"       --relacion con descuentoVenta     "
					  +"       LEFT OUTER JOIN SCSADTDESVENART ARTDESCUENTOVENTA  " 
					  +"                    ON ART.CODIGOARTICULO = ARTDESCUENTOVENTA.CODIGOARTICULO  "
					  +"                       AND ART.CODIGOCOMPANIA = ARTDESCUENTOVENTA.CODIGOCOMPANIA " 
					  +"                       AND ARTDESCUENTOVENTA.ESTADO =:estado "
					  +"       LEFT OUTER JOIN SCSADTARTIMP ARTIIMPUESTO "
					  +"                    ON ART.CODIGOARTICULO = ARTIIMPUESTO.CODIGOARTICULO " 
					  +"                       AND ART.CODIGOCOMPANIA = ARTIIMPUESTO.CODIGOCOMPANIA " 
					  +"                       AND ARTIIMPUESTO.ESTADOARTICULOIMPUESTO =:estado "
					  +"       LEFT OUTER JOIN SCSADTTIPIMP TIPOIMPUESTO  "
					  +"                    ON ARTIIMPUESTO.CODIGOCOMPANIA = TIPOIMPUESTO.CODIGOCOMPANIA " 
					  +"                       AND ARTIIMPUESTO.CODIGOTIPOIMPUESTO = TIPOIMPUESTO.CODIGOTIPOIMPUESTO " 
					  //+"--LEFT OUTER JOIN SCSADTGRUIMP GRUPOIMPUESTO  "
					  //+"--             ON TIPOIMPUESTO.CODIGOCOMPANIA = GRUPOIMPUESTO.CODIGOCOMPANIA "  
					  //+"--                AND TIPOIMPUESTO.CODIGOGRUPOIMPUESTO = GRUPOIMPUESTO.CODIGOGRUPOIMPUESTO  "
					 // +"--                AND GRUPOIMPUESTO.ESTADO =:estado  "
					 // +"--LEFT OUTER JOIN SCSADTARTMED ARTICULOMEDIDA  "
					 // +"--             ON ART.CODIGOARTICULO = ARTICULOMEDIDA.CODIGOARTICULO "  
					 // +"--                AND ART.CODIGOCOMPANIA = ARTICULOMEDIDA.CODIGOCOMPANIA "  
					  +"WHERE  ARTBIT.CODIGOBARRAS =:codigoBarras "
					  +"       AND ART.CODIGOCOMPANIA =:codigoCompania "
					  +"       AND ART.ESTADOARTICULO =:estado ");
			Date currentDate = new Date();
			parameterMap.put("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			parameterMap.put("estadoLiteral", SICConstantes.ESTADO_ACTIVO_LITERAL);
			parameterMap.put("codigoBarras", codigoBarras);
			parameterMap.put("codigoCompania", codigoCompania);
			parameterMap.put("areaTrabajo", areaTrabajoFuncionario);
			parameterMap.put("valorTipoEstruc", CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL);
			parameterMap.put("codigoTipoEstruc", TiposCatalogoConstantes.TIPO_ESTRUCTURA);
			parameterMap.put("currentDate", currentDate);
			
			this.sessionFactory.getCurrentSession().clear();
			SQLQuery query = this.sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
			
			for(Entry<String, Object> parameterEntry : parameterMap.entrySet()){
				LOG_SICV2.info("key:*"+parameterEntry.getKey()+"* value:*"+ parameterEntry.getValue()+"*");
				query.setParameter(parameterEntry.getKey(), parameterEntry.getValue());
			}
			query.addEntity("vista", VistaArticuloCaracteristicasMercanciaDTO.class);
			return query.list();
			
		}catch(SICException e){
			LOG_SICV2.error("Ha ocurrido un error al obtener la lista de Tipo Caracteristica. {}", e.getMessage());
			throw new SICException(e);
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al obtener la lista de Tipo Caracteristica. {}", e.getMessage());
			throw new SICException(e);
		}finally{
			session = null;
		}
	}
	@SuppressWarnings("unchecked")
	public Collection<ArticuloRangoExtensionGarantiaDTO> obtenerRangosExtensionGarantia(Integer codigoCompania,Double precioBaseImp)throws SICException{
		Collection<ArticuloRangoExtensionGarantiaDTO> articuloRangoExtensionGarantiaDTOCol = null;
		Session session = null;
		Criteria criteria = null;
		try{
			if(codigoCompania != null ){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
				
				criteria = session.createCriteria(ArticuloRangoExtensionGarantiaDTO.class, "articuloRangoExtensionGarantiaDTO");
				criteria.add(Restrictions.le("articuloRangoExtensionGarantiaDTO.rangoInicial", precioBaseImp));
				criteria.add(Restrictions.ge("articuloRangoExtensionGarantiaDTO.rangoFinal", precioBaseImp));
				criteria.add(Restrictions.eq("articuloRangoExtensionGarantiaDTO.estado", SICConstantes.ESTADO_ACTIVO_LITERAL));
				criteria.add(Restrictions.eq("articuloRangoExtensionGarantiaDTO.id.codigoCompania", codigoCompania));
				articuloRangoExtensionGarantiaDTOCol = criteria.list();
				session.flush();
			}
		}catch(SICException e){
			LOG_SICV2.error("Ha ocurrido un error al obtener la lista de caracter\u00EDsiticas disponibles. {}", e.getMessage());
			throw new SICException(e);
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al obtener la lista de caracter\u00EDsiticas disponibles. {}", e.getMessage());
			throw new SICException(e);
		}finally{
			session = null;
			criteria = null;
		}
		return articuloRangoExtensionGarantiaDTOCol;
	}
	@SuppressWarnings("unchecked")
	public Collection<String> obtenerCodigosClasificacionFuncionario(FuncionarioDTO funcionario,Boolean tieneLineaComercial) throws SICException{
		Session session = null;
		Criteria criteria = null;
		Collection<String> codigos = null;
		//se agrega las opciones para las consultas de clasificaciones por usuario/funcionario
		ClasificacionPorFuncionario clasificacionPorFuncionario = new ClasificacionPorFuncionario(tieneLineaComercial,funcionario, "id.codigoClasificacion");
		clasificacionPorFuncionario.setOmitirRestriccionCliente(Boolean.TRUE);
		try{
			if(funcionario !=null && funcionario.getId().getCodigoCompania() != null ){
				session = this.sessionFactory.getCurrentSession();
				criteria = session.createCriteria(ClasificacionDTO.class, "clasificacionDTO");
				criteria.add(clasificacionPorFuncionario.getCriteriaRestriction().getCriteriaRestriction());
				criteria.setProjection(Projections.distinct(Projections.property("id.codigoClasificacion").as("id.codigoClasificacion")));
				codigos = criteria.list();
			}
		}catch(SICException e){
			LOG_SICV2.error("Ha ocurrido un error al obtener la lista de caracter\u00EDsiticas disponibles. {}", e.getMessage());
			throw new SICException(e);
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al obtener la lista de caracter\u00EDsiticas disponibles. {}", e.getMessage());
			throw new SICException(e);
		}finally{
			session = null;
			criteria = null;
		}
		return codigos;
	}
	/******************************************************************************************************************************************/
	/***************************************** METODOS SETTER *********************************************************************************/
	/******************************************************************************************************************************************/
	
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * @param sequenceGestor the sequenceGestor to set
	 */
	public void setSequenceGestor(ISequenceGestor sequenceGestor) {
		this.sequenceGestor = sequenceGestor;
	}
	
}
