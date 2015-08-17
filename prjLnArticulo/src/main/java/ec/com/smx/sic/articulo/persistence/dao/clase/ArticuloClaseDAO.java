package ec.com.smx.sic.articulo.persistence.dao.clase;

import java.text.MessageFormat;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloClaseDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.clase.IArticuloClaseDAO;

/**
 * 
 * @author mgranda
 *
 */
public class ArticuloClaseDAO implements IArticuloClaseDAO,Logeable{
	
	private IHibernateH<ArticuloClaseDTO> hibernateH;
	
	/**
	 * @author mgranda
	 * @param secuencialArtCla
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloClaseDTO> obtenerArticuloClase(Long... secuencialArtCla){
		LOG_SICV2.info("==> Busqueda ArticuloClase");
		try{
			final Session session = hibernateH.getHibernateSession();
			session.clear();
			
			final StringBuilder hql = new StringBuilder("from ").append(ArticuloClaseDTO.class.getName()).append(" ac");
			hql.append(" where secuencialArtCla = :pSecArtCla");
			
			/*Se prepara el query de actualizacion*/
			Query query = session.createQuery(hql.toString());
			
			/*Se asignan los parametros al query*/
			if(secuencialArtCla instanceof Object[]){
				query.setParameterList("pSecArtCla", secuencialArtCla);	
			}else{
				query.setParameter("pSecArtCla", secuencialArtCla);
			}
			
			return query.list();
			
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al consultar ArticuloClase.",e);
		}
	}
	
	/**
	 * @author mgranda
	 * @param secuencialArtCla
	 * @return
	 */
	@Override
	public ArticuloClaseDTO obtenerUnicoArticuloClase(Long secuencialArtCla){
		LOG_SICV2.info("==> Busqueda ArticuloClase");
		try{
			final Session session = hibernateH.getHibernateSession();
			session.clear();
			
			final StringBuilder hql = new StringBuilder("from ").append(ArticuloClaseDTO.class.getName()).append(" ac");
			hql.append(" where secuencialArtCla = :pSecArtCla");
			
			/*Se prepara el query de actualizacion*/
			Query query = session.createQuery(hql.toString());
			
			/*Se asignan los parametros al query*/
			query.setParameter("pSecArtCla", secuencialArtCla);
			return (ArticuloClaseDTO) query.uniqueResult();
			
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al consultar ArticuloClase.",e);
		}
	}
	
	/**
	 * @author mgranda
	 * @param articuloClaseDTO
	 * @throws SICException
	 */
	@Override
	public void crearArticuloClase(ArticuloClaseDTO articuloClaseDTO) throws SICException{
		LOG_SICV2.info("==> Registrando ArticuloClase");
		try{
			final Session session = hibernateH.getHibernateSession();
			session.clear();
			hibernateH.crearObjeto(articuloClaseDTO);
			LOG_SICV2.info(MessageFormat.format("Secuencial generado para ArticuloClase es {0}",articuloClaseDTO.getSecuencialArtCla()));
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al registrar ArticuloClase.",e);
		}
	}
	
	/**
	 * @author mgranda
	 * @param articuloClaseDTO
	 * @throws SICException
	 */
	@Override
	public void actualizarArticuloClase(ArticuloClaseDTO articuloClaseDTO) throws SICException{
		LOG_SICV2.info("==> Actualizando ArticuloClase");
		try{
			/*Se prepara el hql de actualizacion*/
			final StringBuilder hql = new StringBuilder("update ").append(ArticuloClaseDTO.class.getName()).append(" ac");
			hql.append(" set codigoTipoCausal = :pCodigoTipoCausal, valorTipoCausal = :pValorTipoCausal,");
			hql.append(" idUsuarioModificacion = :pIdUsuarioModificacion, fechaModificacion = :pCurrentTime");
			if(!StringUtils.equals(articuloClaseDTO.getClaseArticulo(), articuloClaseDTO.getClaseArticuloAnterior())){
				hql.append(", fechaCambioClase = :pCurrentTime, idUsuarioCambioClase = :pIdUsuarioCambioClase");
			}
			hql.append(" where secuencialArtCla = :pSecArtCla");
			
			/*Se obtiene la sesion de hibernate y se limpia*/
			final Session session = hibernateH.getHibernateSession();	
			session.clear();	
			
			/*Se prepara el query de actualizacion*/
			Query query = session.createQuery(hql.toString());
			
			/*Se asignan los parametros al query*/
			query.setParameter("pCodigoTipoCausal", articuloClaseDTO.getCodigoTipoCausal());
			query.setParameter("pValorTipoCausal", articuloClaseDTO.getValorTipoCausal());
			query.setParameter("pIdUsuarioModificacion", articuloClaseDTO.getUserId());
			query.setParameter("pCurrentTime", articuloClaseDTO.getFechaModificacion());
			if(!StringUtils.equals(articuloClaseDTO.getClaseArticulo(), articuloClaseDTO.getClaseArticuloAnterior())){
				query.setParameter("pIdUsuarioCambioClase", articuloClaseDTO.getUserId());
			}
			query.setParameter("pSecArtCla", articuloClaseDTO.getSecuencialArtCla());
			
			/*Ejecutamos y realizamos commit del registro*/
			Integer total = query.executeUpdate();
			LOG_SICV2.info(MessageFormat.format("==> Se actualizo {0} registro.", total));
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al actualizar ArticuloClase.",e);
		}
	}
	
	@Override
	public ArticuloClaseDTO obtenerArticuloClase(Integer codigoCompania, String codigoArticulo) throws SICException {
		ArticuloClaseDTO articuloClaseDTO = null;
		Session session = null;
		Criteria criteria = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(codigoArticulo)){
				session = hibernateH.getHibernateSession();
				session.clear();
				
				criteria = session.createCriteria(ArticuloClaseDTO.class, "ac");
				criteria.add(Restrictions.eq("ac.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("ac.id.codigoArticulo", codigoArticulo));
				
				articuloClaseDTO = (ArticuloClaseDTO) criteria.uniqueResult();
			}
		}catch(Exception e ){
			throw new SICException("No se ha podido obtener el articulo clase ", e);
		}finally{
			session = null;
			criteria = null;
		}
		return articuloClaseDTO;
	}
	
	@Override
	public Boolean existeArticuloClase(Integer codigoCompania, String codigoArticulo) throws SICException {
		Long total = null;
		Session session = null;
		Criteria criteria = null;
		Boolean existeArticuloClase = Boolean.FALSE;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(codigoArticulo)){
				session = hibernateH.getHibernateSession();
				session.clear();
				
				criteria = session.createCriteria(ArticuloClaseDTO.class, "ac");
				criteria.add(Restrictions.eq("ac.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("ac.id.codigoArticulo", codigoArticulo));
				
				criteria.setProjection(Projections.count("ac.id.codigoCompania"));
				
				total = (Long) criteria.uniqueResult();
				
				if(total > 0){
					existeArticuloClase = Boolean.TRUE;
				}
			}
		}catch(Exception e ){
			throw new SICException("No se ha podido contar el articulo clase ", e);
		}finally{
			session = null;
			criteria = null;
		}
		return existeArticuloClase;
	}

	public void setHibernateH(IHibernateH<ArticuloClaseDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
}
