/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.cambioprecios.CambioPreciosUtil;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.GestionPrecioConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RangoSecuenciaCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.SecuenciaInternaCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ValorSecuenciaActual;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloBitacoraCodigoBarrasDAO;

/**
 * @author fmunoz
 *
 */
public class ArticuloBitacoraCodigoBarrasDAO implements Logeable, IArticuloBitacoraCodigoBarrasDAO {

	private IHibernateH<ArticuloBitacoraCodigoBarrasDTO> hibernateH;
	private SessionFactory sessionFactory;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Long obtenerSecuenciaInternaDisponible(Integer codigoCompania, String valorTipoSecuencia, String userID) throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		Collection<ValorSecuenciaActual> valores = null;
		try {
			int intentos = 0;
			session = hibernateH.getHibernateSession();
			session.clear();

			//consulta de prueba bloquea de acceso multiple a secuencias
			query = new StringBuilder();
			query.append("select scb.secuencia as {sec.valorSecuenia}, '0' as {sec.valorMaximo}, '0' as {sec.identificador} from scarttsecintcodbar scb ")
				.append("where scb.secuencia = :pSecuencia for update with rs");
			hqlQuery = session.createSQLQuery(query.toString()).addEntity("sec", ValorSecuenciaActual.class);
			hqlQuery.setParameter("pSecuencia", 0);
			while(intentos < 5){
				try{
					valores = hqlQuery.list();
					intentos = 5;
				}catch(Exception e){
					intentos ++;
					if(intentos == 5){
						throw new SICException("No se pudo obtener una secuencia v\u00E1lida para el nuevo art\u00EDculo, por favor intente registrar nuevamente",e);
					}
				}
			}
			
			Long secuencia = null;
			String identificador = null;
			
			query = new StringBuilder();
			
			query.append("select scb.valoractual as {sec.valorSecuenia}, scb.valormaximo as {sec.valorMaximo}, scb.identificador as {sec.identificador} from scarttransecintcodbar scb ")
			.append("where identificador in (select h.identificador from SCARTTCODSECINT h ")
			.append("where h.codigoTipoSecuencia=:pTipoSecuencia and h.valorTipoSecuencia=:pValorSecuencia ) order by scb.valorMinimo for update with rs");
			
			hqlQuery = session.createSQLQuery(query.toString()).addEntity("sec", ValorSecuenciaActual.class);
			hqlQuery.setInteger("pTipoSecuencia", SICArticuloConstantes.TIPOCATALOGO_SECUENCIAINTERNA);
			hqlQuery.setString("pValorSecuencia", valorTipoSecuencia);
			Collection<ValorSecuenciaActual> rangos = hqlQuery.list();
			
			for (ValorSecuenciaActual rango : rangos) {
				if (rango.getValorSecuenia() < rango.getValorMaximo()) {
					secuencia = rango.getValorSecuenia() + 1;
					identificador = rango.getIdentificador();
					break;
				}
			}
			
			if (secuencia == null) {
				//se consulta la menor secuencia disponible si es que existe
				query = new StringBuilder();
				query.append("select min(scb.secuencia) as {sec.valorSecuenia}, '0' as {sec.valorMaximo}, '0' as {sec.identificador} from scarttsecintcodbar scb ")
					.append("where scb.codigotiposecuencia = :pTipoSecuencia and scb.valortiposecuencia in(")
						.append("select valortiposecuencia from SCARTTCODSECINT ")
						.append("where identificador in (select identificador from SCARTTCODSECINT where valortiposecuencia = :pValorSecuencia and codigoTipoSecuencia = :pTipoSecuencia)")
					.append(") and scb.estado=:pEstado");
				hqlQuery = session.createSQLQuery(query.toString()).addEntity("sec", ValorSecuenciaActual.class);
				hqlQuery.setInteger("pTipoSecuencia", SICArticuloConstantes.TIPOCATALOGO_SECUENCIAINTERNA);
				hqlQuery.setString("pValorSecuencia", valorTipoSecuencia);
				hqlQuery.setString("pEstado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				valores = hqlQuery.list();
				
				if(!CollectionUtils.isEmpty(valores)){
					ValorSecuenciaActual valor = valores.iterator().next();
					secuencia = valor != null ? valor.getValorSecuenia() : null;
					Logeable.LOG_SICV2.info("valor secuencia 1: "+secuencia);
				}
				
				// se actualiza el estado de la secuencia
				if(secuencia != null){
					query = new StringBuilder();
					query.append("update ").append(SecuenciaInternaCodigoBarrasDTO.class.getName()).append(" a set a.estado=:pEstado,a.idUsuarioModificacion=:pUserId,a.fechaModificacion=:pDate where a.id.secuencia=:pSecuencia");
					hqlQuery = session.createQuery(query.toString());
					hqlQuery.setParameter("pSecuencia", secuencia);
					hqlQuery.setParameter("pUserId", userID);
					Date fechaInactivacion = new Date();
					hqlQuery.setParameter("pDate", fechaInactivacion);
					hqlQuery.setParameter("pEstado", SICConstantes.ESTADO_INACTIVO_NUMERICO);
					hqlQuery.executeUpdate();			
					
					int total = this.desactivarBitacoraCodigoBarras(codigoCompania, secuencia, userID, fechaInactivacion);
					if(total > 0){
						this.desactivarBitacoraCodigoBarrasArticulo(codigoCompania, secuencia);
					}
				}else{
					throw new SICException("No se pudo obtener una secuencia v\u00E1lida para el nuevo art\u00EDculo, por favor intente registrar nuevamente");
				}
			} else {
				Logeable.LOG_SICV2.info("valor secuencia 2: "+secuencia);
				if (identificador != null) {
					query = new StringBuilder();
					query.append("update ").append(RangoSecuenciaCodigoBarrasDTO.class.getName()).append(" a set a.valorActual=a.valorActual + 1 where a.id.identificador=:pId");
					hqlQuery = session.createQuery(query.toString());
					hqlQuery.setParameter("pId", identificador);
					hqlQuery.executeUpdate();
				}
			}
			return secuencia;
		} catch (SICException e) {
			LOG_SICV2.error(MessageFormat.format("No se pudo obtener una secuencia {0} v\u00E1lida para el nuevo art\u00EDculo", valorTipoSecuencia), e);
			throw e;
		}catch (Exception e) {
			LOG_SICV2.error(MessageFormat.format("No se pudo obtener una secuencia {0} v\u00E1lida para el nuevo art\u00EDculo", valorTipoSecuencia), e);
			throw new SICException("No se pudo obtener una secuencia v\u00E1lida para el nuevo art\u00EDculo, por favor intente registrar nuevamente",e);
		} finally {
			session = null;
			query = null;
			hqlQuery = null;
		}
	}
	
	@Override
	public void registrarSecuenciaDisponible(Integer codigoCompania, String codigoArticulo, String userId) throws SICException {
		LOG_SICV2.info("==> Registrando Secuencia en tabla de disponibles.");
		try{
			SecuenciaInternaCodigoBarrasDTO secuenciaInternaCodigoBarrasDTO = new SecuenciaInternaCodigoBarrasDTO();
			ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO = this.obtenerArticuloBitacoraCodigoBarrasDTO(codigoCompania, codigoArticulo);
			if(articuloBitacoraCodigoBarrasDTO != null){
				secuenciaInternaCodigoBarrasDTO.getId().setSecuencia(Long.valueOf(articuloBitacoraCodigoBarrasDTO.getId().getCodigoBarras()));
				secuenciaInternaCodigoBarrasDTO.setCodigoTipoSecuencia(articuloBitacoraCodigoBarrasDTO.getCodigoTipoSecuencia());
				secuenciaInternaCodigoBarrasDTO.setValorTipoSecuencia(articuloBitacoraCodigoBarrasDTO.getValorTipoSecuencia());
				secuenciaInternaCodigoBarrasDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				secuenciaInternaCodigoBarrasDTO.setUserId(userId);
				
				final Session session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.saveOrUpdate(secuenciaInternaCodigoBarrasDTO);
				session.flush();
				LOG_SICV2.info(MessageFormat.format("Se registro la secuencia {0} como disponible.", secuenciaInternaCodigoBarrasDTO.getId().getSecuencia()));
			}
		}catch(Exception e){
			throw new SICException("Registrando Secuencia en tabla de disponibles.", e);
		}
	}
	
	@Override
	public int desactivarBitacoraCodigoBarras(Integer codigoCompania, Long secuencia, String userId, Date fecha) throws SICException{
		StringBuilder query = new StringBuilder();
		Query update;
		try{
				hibernateH.getHibernateSession().clear();
				query.append("update ").append(ArticuloBitacoraCodigoBarrasDTO.class.getName()).append(" a set a.estadoArticuloBitacora = :pEstadoArticuloInactivo, a.fechaFinalActivo=:pDate, a.idUsuarioModificacion = :pUserAuditId, a.fechaModificacion = :pDate ")
					.append("where a.id.codigoCompania = :pCompania and a.estadoArticuloBitacora = :pEstadoArticuloActivo")
					.append(" and a.id.codigoBarras in (")
							.append("select art.codigoBarras from ").append(ArticuloDTO.class.getName()).append(" art")
							.append(" where art.id.codigoCompania = :pCompania and art.estadoArticulo = :pEstadoArticuloInactivo and art.codigoBarras = :pSecuencia")
					.append(")");
				update = hibernateH.getHibernateSession().createQuery(query.toString());
				update.setInteger("pCompania", codigoCompania);
				update.setString("pEstadoArticuloInactivo", SICConstantes.ESTADO_INACTIVO_NUMERICO);
				update.setString("pEstadoArticuloActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				update.setTimestamp("pDate", fecha);
				update.setString("pUserAuditId", userId);
				update.setString("pSecuencia", String.valueOf(secuencia));
				return update.executeUpdate();
		}catch(Exception e){
			throw new SICException("Error al desactivar la bitacora del art\u00EDculo",e);
		}
	}
	
	@Override
	public int desactivarBitacoraCodigoBarrasArticulo(Integer codigoCompania, Long secuencia) throws SICException{
		StringBuilder query = new StringBuilder();
		Session session;
		Query update;
		try{
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				
				query.append("update ").append(ArticuloDTO.class.getName()).append(" a set a.codigoBarras = null, a.codigoBarrasPOS = null, a.codigoTipoCodigoArticulo = null ")
					.append("where a.id.codigoCompania = :pCompania and a.codigoBarras = :pSecuencia");
					
				update = session.createQuery(query.toString());
				update.setInteger("pCompania", codigoCompania);
				update.setString("pSecuencia", String.valueOf(secuencia));
				return update.executeUpdate();
		}catch(Exception e){
			throw new SICException("Error al desactivar la bitacora del art\u00EDculo",e);
		}
	}
	
	@Override
	public void desactivarBitacoraActual(Integer codigoCompania, String codigoarticulo, String userId, Date fecha) throws SICException{
		StringBuilder query = new StringBuilder();
		Query update;
		try{
				hibernateH.getHibernateSession().clear();
				query.append("update ").append(ArticuloBitacoraCodigoBarrasDTO.class.getName()).append(" a set a.estadoArticuloBitacora = :pEstadoArticuloInactivo, a.fechaFinalActivo=:pDate, a.idUsuarioModificacion = :pUserAuditId, a.fechaModificacion = :pDate ")
					.append("where a.id.codigoCompania = :pCompania and a.id.codigoArticulo=:pCodigoArticulo and a.estadoArticuloBitacora = :pEstadoArticuloActivo");
				update = hibernateH.getHibernateSession().createQuery(query.toString());
				update.setInteger("pCompania", codigoCompania);
				update.setString("pCodigoArticulo", codigoarticulo);
				update.setString("pEstadoArticuloInactivo", SICConstantes.ESTADO_INACTIVO_NUMERICO);
				update.setString("pEstadoArticuloActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				update.setTimestamp("pDate", fecha);
				update.setString("pUserAuditId", userId);
				update.executeUpdate();
		}catch(Exception e){
			throw new SICException("Error al desactivar la bitacora del art\u00EDculo",e);
		}finally{
			update = null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<String> obtenerUnidadesManejoEnOtrosArticulosPorCodBarras(ArticuloVO articuloVO, Collection<ArticuloUnidadManejoDTO> artUniMnjCol) throws SICException {
		Session session;
		StringBuilder squery;
		Query hquery;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			
			Collection<String> eans = new ArrayList<String>();
			for(ArticuloUnidadManejoDTO aum : artUniMnjCol){
				if(aum.getEstadoUnidadManejo().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO) && 
						StringUtils.isNotEmpty(aum.getCodigoBarrasUnidadManejo()) && !eans.contains(aum.getCodigoBarrasUnidadManejo())){
					eans.add(aum.getCodigoBarrasUnidadManejo());
				}
			}
			if(!eans.isEmpty()){
				squery = new StringBuilder();
				squery.append("select ab.id.codigoBarras from ").append(ArticuloBitacoraCodigoBarrasDTO.class.getName()).append(" ab ")
				.append("where ab.estadoArticuloBitacora = :pestado ")
				.append("and ab.id.codigoBarras in (:pcodigoEAN) ")
				.append("and ab.id.codigoCompania = :pcodigoCompania ");
				
				hquery = session.createQuery(squery.toString());
				hquery.setParameter("pestado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				hquery.setParameter("pcodigoCompania", articuloVO.getBaseDTO().getId().getCodigoCompania());
				hquery.setParameterList("pcodigoEAN", eans);
				return hquery.list();
				
			}
			return null;
		}catch (SICException e) {
			throw new SICException(e);
		}finally{
			session = null;
			squery = null;
			hquery = null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<ArticuloDTO> obtenerArticuloPorUnidadesManejoCodBarras(Integer compania, String codigoBarras) throws SICException{
		Collection<ArticuloDTO> articuloDTOList = null;
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloDTO.class,"root");
			criteria.createAlias("articuloUnidadManejoCol", "aum",CriteriaSpecification.INNER_JOIN);			
			criteria.add(Restrictions.eq("aum.id.codigoCompania", compania));
			criteria.add(Restrictions.eq("aum.codigoBarrasUnidadManejo", codigoBarras));
			criteria.add(Restrictions.eq("aum.estadoUnidadManejo", SICConstantes.ESTADO_ACTIVO_NUMERICO));			
			ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.property("root.id.codigoArticulo"),"id.codigoArticulo");
	    	projectionList.add(Projections.property("root.descripcionArticulo"),"descripcionArticulo");
	    	criteria.setProjection(Projections.distinct(projectionList));
	    	criteria.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
	    	articuloDTOList = criteria.list();
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al consultar ArticuloDTO por el codigo de barras de unidades de manejo",e);
			throw new  SICException("Error al consultar Articulos",e);
		}		
    	return articuloDTOList;
	}

	public String obtenerCodigoBarrasActivoPorArticulo(String codigoArticulo,Integer codigoCompania) throws SICException{
		StringBuilder query = new StringBuilder();
		Session session;
		Query select;
		String codigoBarras = null;
		try{
			if(codigoArticulo != null && codigoCompania != null){
				session = hibernateH.getHibernateSession();
				session.clear();
				
				query.append("select a.id.codigoBarras from ").append(ArticuloBitacoraCodigoBarrasDTO.class.getName())
					.append(" a where a.id.codigoCompania = :pCompania and a.id.codigoArticulo=:pCodigoArticulo and a.estadoArticuloBitacora = :pEstadoArticuloActivo");
				select = hibernateH.getHibernateSession().createQuery(query.toString());
				select.setInteger("pCompania",codigoCompania);
				select.setString("pCodigoArticulo",codigoArticulo);
				select.setString("pEstadoArticuloActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				codigoBarras = (String) select.uniqueResult();
			}
		}catch(Exception e){
			throw new SICException("Error al consultar la bitacora del art\u00EDculo",e);
		}
		return codigoBarras;
	}
	
	public ArticuloBitacoraCodigoBarrasDTO obtenerArticuloBitacoraCodigoBarrasDTO(Integer codigoCompania, String codigoArticulo) throws SICException{
		StringBuilder query = new StringBuilder();
		Session session;
		Query select;
		ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO = null;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			query.append("from ").append(ArticuloBitacoraCodigoBarrasDTO.class.getName())
				.append(" a where a.id.codigoCompania = :pCompania and a.id.codigoArticulo=:pCodigoArticulo and a.estadoArticuloBitacora = :pEstadoActivo");
			select = session.createQuery(query.toString());
			select.setInteger("pCompania",codigoCompania);
			select.setString("pCodigoArticulo",codigoArticulo);
			select.setString("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			select.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			articuloBitacoraCodigoBarrasDTO = (ArticuloBitacoraCodigoBarrasDTO) select.uniqueResult();
			return articuloBitacoraCodigoBarrasDTO;
		}catch(Exception e){
			throw new SICException("Error al registrar la secuencia disponible.", e);
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Collection<ArticuloDTO> obtenerCodigosArticulosPorCodigosBarras( Integer codigoCompania, Set<String> codigosBarras) throws SICException {
		Integer iteraciones;
		Set<String> codigosBarrasConsultar;
		Collection<ArticuloDTO> listArticulosBitacoraActivos;
		
		try {
			// Consultamos el numero de iteracion que se van a arealizar segun
			// la cantida de codigos de clasificacion recibida
			iteraciones = CambioPreciosUtil.getInstance().calcularIteracionesConsultasDinamicas(codigosBarras.size(), GestionPrecioConstantes.getInstancia().CANTIDAD_DATOS_CONSULTA_DINAMICA);
			listArticulosBitacoraActivos = new ArrayList<ArticuloDTO>();
			// Recorremos las iteraciones calculadas.
			for (int i = 0; i < iteraciones; i++) {

				// Obtenemos los codigos de clasificacion para consultar.
				codigosBarrasConsultar = CambioPreciosUtil.getInstance().obtenerItemsConsultaPorIteracionActual(codigosBarras, GestionPrecioConstantes.getInstancia().CANTIDAD_DATOS_CONSULTA_DINAMICA, i);

				// SELECT
				this.sessionFactory.getCurrentSession().clear();
				Criteria cr = this.sessionFactory.getCurrentSession().createCriteria(ArticuloDTO.class, "articulo");

				// WHERE
				cr.add(Restrictions.eq("articulo.id.codigoCompania", codigoCompania));
				cr.add(Restrictions.eq("articulo.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));

				cr.setProjection(Projections.projectionList()
						.add(Projections.property("articulo.id.codigoArticulo"), "id.codigoArticulo")
						.add(Projections.property("articulo.codigoBarras"), "codigoBarras"));
				
				cr.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
				cr.add(Restrictions.in("articulo.codigoBarras", codigosBarrasConsultar));
				listArticulosBitacoraActivos.addAll(cr.list());
			}

			return listArticulosBitacoraActivos;
		} catch (Exception e) {
			throw new SICException("No se pudo consultar los codigos de articulos " , e);
		}
		
	}

	/**
	 * @param hibernateH the hibernateH to set
	 */
	public void setHibernateH(IHibernateH<ArticuloBitacoraCodigoBarrasDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	/**
	 * @author rali
	 * Dados: Codigo de barras, codigoCompania 
	 * Retorna la cantidad de artículos con igual codigo de barras
	 * 
	 */
	public long cantidadArticulosRelacionados(String codigoBarras,Integer codigoCompania) throws SICException{
		StringBuilder query = new StringBuilder();
		Session session;
		Query select;
		long cantidad = 0;
		try{
			if(codigoBarras != null && codigoCompania != null){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				
				query.append("select count(distinct art.id.codigoArticulo) from ").append(ArticuloBitacoraCodigoBarrasDTO.class.getName())
				.append(" bt inner join bt.articulo art where " +
						" bt.id.codigoCompania = :pCompania and " +
						" bt.id.codigoBarras=:pCodigoBarras and " +
						" bt.id.codigoBarras not like 'C%' and " +
						" art.codigoEstado <> :pcodigoCodificado and" +
						" bt.id.codigoBarras in(select bt2.id.codigoBarras from "+ArticuloBitacoraCodigoBarrasDTO.class.getName()+" bt2 where bt2.estadoArticuloBitacora = '1' )");
				
				select = session.createQuery(query.toString());
				select.setInteger("pCompania",codigoCompania);
				select.setString("pCodigoBarras",codigoBarras);
				select.setString("pcodigoCodificado",SICArticuloConstantes.ESTADOARTICULO_PRECODIFICADO);
				cantidad = new Long(select.uniqueResult().toString());
			}
		}catch(Exception e){
			throw new SICException("Error al consultar la bitacora del art\u00EDculo",e);
		}
		return cantidad;
	}
	
	/**
	 * @author rali
	 * Dados: Codigo de barras, codigoCompania y Codigo de articulos. 
	 * Retorna la lista de artículos con igual codigo de barras
	 * 
	 */
	public Collection<ArticuloDTO> obtenerArticuloPorCodBarras(Integer compania, String codbar, String codart) throws SICException{
		
		Collection<ArticuloDTO> articuloDTOList = null;
		Session session;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			Criteria criteria = session.createCriteria(ArticuloDTO.class,"root");
			criteria.createAlias("artBitCodBarCol", "bitacora",CriteriaSpecification.INNER_JOIN);
			criteria.add(Restrictions.eq("bitacora.id.codigoCompania", compania));
			criteria.add(Restrictions.eq("bitacora.id.codigoBarras", codbar));
			criteria.add(Restrictions.ne("root.id.codigoArticulo", codart));
			criteria.add(Restrictions.ne("root.codigoEstado", SICArticuloConstantes.ESTADOARTICULO_PRECODIFICADO));//fix
			
			ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.property("root.id.codigoArticulo"),"id.codigoArticulo");
	    	projectionList.add(Projections.property("root.id.codigoCompania"),"id.codigoCompania");
	    	projectionList.add(Projections.property("root.descripcionArticulo"),"descripcionArticulo");
	    	projectionList.add(Projections.property("root.codigoClasificacion"),"codigoClasificacion");
	    	projectionList.add(Projections.property("root.estadoArticulo"),"estadoArticulo");
	    	criteria.setProjection(Projections.distinct(projectionList));
	    	criteria.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
	    	articuloDTOList = criteria.list();
	    	return articuloDTOList;
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al consultar Articulos por el c\u00F3digo de barras", e);
			throw new  SICException("Error al consultar Articulos por el c\u00F3digo de barras", e);
		}		
	}
	
	/**
	 * @author corbe
	 * metodo que inactiva el codigobarras existente
	 */
	public void reutilizarCodigoBarrasEan(String codigoArticulo , Integer codigoCompania , String codigoBarras , String usuarioModificacion)throws SICException{
		Session session;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			//consultamos el estado actual del articulo
			String estadoArticulo = null;
			Criteria criteria = hibernateH.getHibernateSession().createCriteria(ArticuloDTO.class);
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("estadoArticulo"),"estadoArticulo"));
			
			criteria.add(Restrictions.eq("id.codigoArticulo", codigoArticulo));
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			
			estadoArticulo = (String) criteria.uniqueResult();
			
			//si el estado del articulo se encuentra inactivo, inactivamos el codigo de barras
			if(StringUtils.equals(estadoArticulo, SICConstantes.ESTADO_INACTIVO_NUMERICO)){
				session.clear();
				Query query = null;
				StringBuilder sqlQuery = new StringBuilder();
				sqlQuery.append("update ").append(ArticuloBitacoraCodigoBarrasDTO .class.getName())
				.append(" set estadoArticuloBitacora = :pEstadoArticuloBitacora " )
				.append(" , fechaFinalActivo = :pfechaFinalActivo " )
				.append(" , idUsuarioModificacion = :pIdUsuarioModificacion " )
				.append(" , fechaModificacion = :pFechaModificacion " )
				.append(" where codigoArticulo = :pCodigoArticulo " )
				.append(" and codigoCompania = :pCodigoCompania " )
				.append(" and codigoBarras = :pCodigoBarras " );
				
				query = session.createQuery(sqlQuery.toString());
				
				//asignamos los valores de los parametros
				query.setParameter("pEstadoArticuloBitacora", SICConstantes.ESTADO_INACTIVO_NUMERICO);
				query.setParameter("pfechaFinalActivo", new Timestamp(System.currentTimeMillis()));
				query.setParameter("pIdUsuarioModificacion", usuarioModificacion);
				query.setParameter("pFechaModificacion", new Timestamp(System.currentTimeMillis()));
				query.setParameter("pCodigoArticulo", codigoArticulo);
				query.setParameter("pCodigoCompania", codigoCompania);
				query.setParameter("pCodigoBarras", codigoBarras);
				
				Integer registroActualizado = query.executeUpdate();
				Logeable.LOG_SICV2.info("registro actualizado: "+registroActualizado);
				
				//nulificamos el codigo de barras que se encuentra  a nivel de articulo
				session.clear();
				Query queryArticulo = null;
				StringBuilder sqlQueryArticulo = new StringBuilder();
				sqlQueryArticulo.append("update ").append(ArticuloDTO.class.getName())
				.append(" set codigoBarras = :pCodigoBarras " )
				.append(" , usuarioActualizacion = :pUsuarioActualizacion " )
				.append(" , fechaUltimaActualizacion = :pFechaUltimaActualizacion " )
				.append(" where codigoArticulo = :pCodigoArticulo " )
				.append(" and codigoCompania = :pCodigoCompania " );
				
				
				queryArticulo = session.createQuery(sqlQueryArticulo.toString());
				//asignamos los parametros
				queryArticulo.setParameter("pCodigoBarras", null);
				queryArticulo.setParameter("pCodigoArticulo", codigoArticulo);
				queryArticulo.setParameter("pCodigoCompania", codigoCompania);
				queryArticulo.setParameter("pUsuarioActualizacion", usuarioModificacion);
				queryArticulo.setParameter("pFechaUltimaActualizacion", new Timestamp(System.currentTimeMillis()));
				Integer articuloActualizado = queryArticulo.executeUpdate();
				Logeable.LOG_SICV2.info("articulo actualizado: "+articuloActualizado);
			}
			
			
		}catch(Exception e){
			Logeable.LOG_SICV2.error(MessageFormat.format("Error al inactivar el codigo de barras(reutilizacion de codigo): {0} asociado al articulo {1}", codigoBarras, codigoArticulo), e);
			throw new  SICException("Error al inactivar el codigo de barras", e);
		}	
	}
}
