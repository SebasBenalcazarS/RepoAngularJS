package ec.com.smx.sic.articulo.persistence.dao.ley.podermercado;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.articulo.EnumEstadoLeyMercado;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado.ArticuloBitacoraLeyMercadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado.ArticuloLeyMercadoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.ley.podermercado.IArticuloLeyMercadoDAO;

/**
 * Clase que es encargada del registro y obtencion de informacion del estado de un articulo segun la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
 * @author mgranda
 *
 */
public class ArticuloLeyMercadoDAO implements IArticuloLeyMercadoDAO, Logeable {

	private IHibernateH<ArticuloLeyMercadoDTO> hibernateH;	
	
	/**
	 * Metodo que permite obtener la informacion de los estados de un conjunto de articulos a traves de sus secuenciales unicos
	 * @author mgranda
	 * @param secuencialArtLeyMer
	 * @return
	 */
	@Override
	public Collection<ArticuloLeyMercadoDTO> obtenerArticuloLeyMercado(Long... secuencialArtLeyMer){
		LOG_SICV2.info("==> Busqueda ArticuloLeyMercado");
		try{
			final Session session = hibernateH.getHibernateSession();
			session.clear();
			
			final StringBuilder hql = new StringBuilder("from ").append(ArticuloLeyMercadoDTO.class.getName()).append(" alm");
			hql.append(" where secuencialArtLeyMer = :pSecuencialArtLeyMer");
			
			/*Se prepara el query de actualizacion*/
			Query query = session.createQuery(hql.toString());
			
			/*Se asignan los parametros al query*/
			if(secuencialArtLeyMer instanceof Object[]){
				query.setParameterList("pSecuencialArtLeyMer", secuencialArtLeyMer);	
			}else{
				query.setParameter("pSecuencialArtLeyMer", secuencialArtLeyMer);
			}
			
			return query.list();
			
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al consultar ArticuloClase.", e);
		}
	}
	
	/**
	 * Metodo que permite obtener la informacion del estado de un articulo a traves de su secuencial unico
	 * @author mgranda
	 * @param secuencialArtLeyMer
	 * @return
	 */
	@Override
	public ArticuloLeyMercadoDTO obtenerUnicoArticuloLeyMercado(Long secuencialArtLeyMer){
		LOG_SICV2.info("==> Busqueda ArticuloLeyMercado");
		try{
			final Session session = hibernateH.getHibernateSession();
			session.clear();
			
			final StringBuilder hql = new StringBuilder("from ").append(ArticuloLeyMercadoDTO.class.getName()).append(" alm");
			hql.append(" where secuencialArtLeyMer = :pSecuencialArtLeyMer");
			
			/*Se prepara el query de actualizacion*/
			Query query = session.createQuery(hql.toString());
			
			/*Se asignan los parametros al query*/
			query.setParameter("pSecuencialArtLeyMer", secuencialArtLeyMer);
			return (ArticuloLeyMercadoDTO) query.uniqueResult();
			
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al consultar ArticuloClase.",e);
		}
	}
	
	/**
	 * Metodo que crea un registro de informacion de estado de un articulo
	 * @author mgranda
	 * @param articuloLeyMercadoDTO
	 * @throws SICException
	 */
	@Override
	public void crearArticuloLeyMercado(ArticuloLeyMercadoDTO articuloLeyMercadoDTO) throws SICException{
		LOG_SICV2.info("==> Registrando ArticuloLeyMercado");
		try{
			final Session session = hibernateH.getHibernateSession();
			session.clear();
			hibernateH.crearObjeto(articuloLeyMercadoDTO);
			LOG_SICV2.info(MessageFormat.format("Secuencial generado para ArticuloClase es {0}",articuloLeyMercadoDTO.getSecuencialArtLeyMer()));
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al registrar ArticuloClase.", e);
		}
	}
	
	/**
	 * Metodo que permite actualizar la informacion de estados de un articulo
	 * @author mgranda
	 * @param articuloLeyMercadoDTO
	 * @throws SICException
	 */
	@Override
	public void actualizarArticuloLeyMercado(ArticuloLeyMercadoDTO articuloLeyMercadoDTO) throws SICException{
		LOG_SICV2.info("==> Actualizando ArticuloLeyMercado");
		try{
			/*Se prepara el hql de actualizacion*/
			final StringBuilder hql = new StringBuilder("update ").append(ArticuloLeyMercadoDTO.class.getName()).append(" alm");
			hql.append(" set codigoTipoEstado = :pCodigoTipoEstado, valorTipoEstado = :pValorTipoEstado,");
			hql.append(" idUsuarioCambioEstado = :pIdUsuarioCambioEstado, fechaCambioEstado = :pCurrentTime,");
			hql.append(" codigoTipoCausal = :pCodigoTipoCausal, valorTipoCausal = :pValorTipoCausal");
			hql.append(" where secuencialArtLeyMer = :pSecuencialArtLeyMer");
			
			/*Se obtiene la sesion de hibernate y se limpia*/
			final Session session = hibernateH.getHibernateSession();	
			session.clear();	
			
			/*Se prepara el query de actualizacion*/
			Query query = session.createQuery(hql.toString());
			
			/*Se asignan los parametros al query*/
			query.setParameter("pCodigoTipoEstado", articuloLeyMercadoDTO.getCodigoTipoEstado());
			query.setParameter("pValorTipoEstado", articuloLeyMercadoDTO.getValorTipoEstado());
			query.setParameter("pIdUsuarioCambioEstado", articuloLeyMercadoDTO.getUserId());
			query.setParameter("pCurrentTime", articuloLeyMercadoDTO.getFechaCambioEstado());
			query.setParameter("pCodigoTipoCausal", articuloLeyMercadoDTO.getCodigoTipoCausal());
			query.setParameter("pValorTipoCausal", articuloLeyMercadoDTO.getValorTipoCausal());
			query.setParameter("pSecuencialArtLeyMer", articuloLeyMercadoDTO.getSecuencialArtLeyMer());
			
			/*Ejecutamos y realizamos commit del registro*/
			Integer total = query.executeUpdate();
			LOG_SICV2.info(MessageFormat.format("==> Se actualizo {0} registro.", total));
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al actualizar ArticuloLeyMercado.", e);
		}
	}
	
	/**
	 * Metodo que permite obtener la informacion del estado de un articulo a traves del codigo de compania y codigo de articulo
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	@Override
	public ArticuloLeyMercadoDTO obtenerArticuloLeyMercado(Integer codigoCompania, String codigoArticulo) throws SICException {
		LOG_SICV2.info("==> Busqueda ArticuloLeyMercado");
		ArticuloLeyMercadoDTO articuloLeyMercadoDTO = null;
		Session session = null;
		Criteria criteria = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(codigoArticulo)){
				session = hibernateH.getHibernateSession();
				session.clear();
				
				criteria = session.createCriteria(ArticuloLeyMercadoDTO.class, "alm");
				criteria.add(Restrictions.eq("alm.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("alm.id.codigoArticulo", codigoArticulo));
				
				articuloLeyMercadoDTO = (ArticuloLeyMercadoDTO) criteria.uniqueResult();
			}
		}catch(Exception e ){
			throw new SICException("No se ha podido obtener el articulo clase ", e);
		}finally{
			session = null;
			criteria = null;
		}
		return articuloLeyMercadoDTO;
	}
	
	/**
	 * Metodo que cuenta el numero de registros en los estados de los articulos segun el estado especificado
	 * @author oviana
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param enumEstadoLeyMercado
	 * @return
	 * @throws SICException
	 */
	@Override
	public Long contarArticuloLeyMercado(Integer codigoCompania, String codigoArticulo, EnumEstadoLeyMercado enumEstadoLeyMercado) throws SICException {
		LOG_SICV2.info("==> Conteo ArticuloLeyMercado");
		Long count = 0L;
		Session session = null;
		Criteria criteria = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(codigoArticulo) && enumEstadoLeyMercado != null){
				session = hibernateH.getHibernateSession();
				session.clear();
				
				criteria = session.createCriteria(ArticuloLeyMercadoDTO.class, "alm");
				criteria.setProjection(Projections.rowCount());
				criteria.add(Restrictions.eq("alm.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("alm.id.codigoArticulo", codigoArticulo));
				criteria.add(Restrictions.eq("alm.codigoTipoEstado", enumEstadoLeyMercado.getCodigoTipo()));
				criteria.add(Restrictions.eq("alm.valorTipoEstado", enumEstadoLeyMercado.getCodigoValor()));
				count = (Long) criteria.uniqueResult();
			}
		}catch(Exception e ){
			throw new SICException("No se ha podido obtener el articulo clase ", e);
		}finally{
			session = null;
			criteria = null;
		}
		return count;
	}
	
	/**
	 * Metodo que obtiene informacion del estado del articulo de forma personalizada
	 * @author oviana	
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	@Override
	public ArticuloLeyMercadoDTO obtenerArticuloLeydeMercado(Integer codigoCompania, String codigoArticulo) throws SICException {
		LOG_SICV2.info("==> Busqueda ArticuloLeyMercado");
		ArticuloLeyMercadoDTO articuloLeyMercadoDTO = null;
		Session session = null;
		Criteria criteria = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(codigoArticulo)){
				session = hibernateH.getHibernateSession();
				session.clear();
				
				criteria = session.createCriteria(ArticuloLeyMercadoDTO.class, "alm");
				criteria.createAlias("tipoEstado", "tipoEstado", CriteriaSpecification.LEFT_JOIN);
				criteria.createAlias("usuarioCambioEstado", "usuarioCambioEstado", CriteriaSpecification.LEFT_JOIN);
				
				criteria.add(Restrictions.eq("alm.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("alm.id.codigoArticulo", codigoArticulo));
				
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.property("alm.fechaCambioEstado"), "fechaCambioEstado");
				projectionList.add(Projections.property("tipoEstado.nombreCatalogoValor"), "tipoEstado.nombreCatalogoValor");
				projectionList.add(Projections.property("usuarioCambioEstado.userCompleteName"), "usuarioCambioEstado.userCompleteName");
				
				criteria.setProjection(projectionList);
				criteria.setResultTransformer(new DtoResultTransformer(ArticuloLeyMercadoDTO.class));
				articuloLeyMercadoDTO = (ArticuloLeyMercadoDTO) criteria.uniqueResult();
			}
		}catch(Exception e ){
			throw new SICException("No se ha podido obtener el articulo ley de mercado ", e);
		}finally{
			session = null;
			criteria = null;
		}
		return articuloLeyMercadoDTO;
	
	}
	
	/**
	 * Metodo que permite obtener la informacion historica paginada de estados de un articulo 
	 * @author oviana
	 * @param first
	 * @param pageSize
	 * @param sortField
	 * @param filters
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ArticuloBitacoraLeyMercadoDTO> obtenerHistoricoLeyMercado(int first, int pageSize, String sortField, Map<String, String> filters) throws SICException{
		Session session;
		Criteria criteria;
		List<ArticuloBitacoraLeyMercadoDTO> artBitLeyMercList =  null;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloBitacoraLeyMercadoDTO.class, "artBit");
			criteria.createAlias("tipoCausal", "tipoCausal", CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("tipoEstado", "tipoEstado", CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("usuarioCambioEstado", "usuarioCambioEstado", CriteriaSpecification.LEFT_JOIN);
			
			criteria.add(Restrictions.eq("artBit.id.codigoCompania", Integer.valueOf(filters.get("codigoCompania"))));
			criteria.add(Restrictions.eq("artBit.codigoArticulo", filters.get("codigoArticulo")));
			
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("artBit.id.secuencial"), "id.secuencial");
			projectionList.add(Projections.property("tipoEstado.nombreCatalogoValor"), "tipoEstado.nombreCatalogoValor");
			projectionList.add(Projections.property("usuarioCambioEstado.userCompleteName"), "usuarioCambioEstado.userCompleteName");
			projectionList.add(Projections.property("artBit.fechaCambioEstado"), "fechaCambioEstado");
			projectionList.add(Projections.property("tipoCausal.nombreCatalogoValor"), "tipoCausal.nombreCatalogoValor");
			criteria.setProjection(projectionList);
			
			criteria.setFirstResult(first);
			criteria.setMaxResults(pageSize);
			
			if(StringUtils.isEmpty(sortField)){
				criteria.addOrder(Order.asc("artBit.fechaCambioEstado"));
			}else{
				criteria.addOrder(Order.asc("artBit." + sortField));				
			}
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloBitacoraLeyMercadoDTO.class));			
			artBitLeyMercList = criteria.list();	
		}catch(SICException e) {
			LOG_SICV2.error("Error al consulta el hist\u00F3rico de ley de mercado del art\u00EDculo", e);
			throw new SICException(e);
		} catch(Exception ex) {
			LOG_SICV2.error("Error al consulta el hist\u00F3rico de ley de mercado del art\u00EDculo", ex);
			throw new SICException(ex);
		}
		return artBitLeyMercList;
	}

	/**
	 * Metodo que permite obtener el total de registros historicos de estados de un articulo
	 * @author oviana
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("deprecation")
	@Override
	public Long obtenerTotalHistoricoLeyMercado(Integer codigoCompania, String codigoArticulo) throws SICException {
		Session session = null;
		Long totalRegistros = null;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			StringBuilder squery = new StringBuilder();
			squery.append(" select count(*) from ArticuloBitacoraLeyMercadoDTO ablm ");
			squery.append(" where ablm.id.codigoCompania = :codigoCompania ");
			squery.append(" and ablm.codigoArticulo = :codigoArticulo ");
			
			Query hquery = session.createQuery(squery.toString());
			hquery.setParameter("codigoCompania", codigoCompania);
			hquery.setParameter("codigoArticulo", codigoArticulo);
			
			totalRegistros = (Long)hquery.uniqueResult();
			if(totalRegistros == null)
				totalRegistros = Long.valueOf(0);
			
		}catch(Exception e){
			LOG_SICV2.error("Error al obtener el total de registros de hist\u00F3rico ley de mercado del art\u00EDculo {}", e);
			throw new SICException(e);
		}
		return totalRegistros;
	}
	
	public void setHibernateH(IHibernateH<ArticuloLeyMercadoDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
}
