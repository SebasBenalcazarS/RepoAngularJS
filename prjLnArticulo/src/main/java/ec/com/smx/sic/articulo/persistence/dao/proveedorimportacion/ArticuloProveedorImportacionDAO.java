package ec.com.smx.sic.articulo.persistence.dao.proveedorimportacion;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.proveedorimportacion.IArticuloProveedorImportacionDAO;

/**
 * Clase que es encargada del registro y obtencion de informacion de informacion de importacion de un articulo por proveedor
 * @author mgranda
 *
 */
public class ArticuloProveedorImportacionDAO implements IArticuloProveedorImportacionDAO, Logeable{
	
	private SessionFactory sessionFactory;
	
	/**
	 * Metodo que permite actualizar la informacion (costoMonedaOrigen, PorcentajeComision) de Importacion de un articulo
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoProveedor
	 * @param costoMonedaOrigen
	 * @param porcentajeComision
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	@Override
	public Integer actualizarArticuloImportacion(Integer codigoCompania, String codigoArticulo, String codigoProveedor, BigDecimal costoMonedaOrigen, Double porcentajeComision, String userId) throws SICException{
		LOG_SICV2.info("========> Actualizar informacion de importaciones para el articulo.");
		Integer totalRegistros = 0;
		try {
			final Session session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			final StringBuilder hql = new StringBuilder("update ").append(ArticuloImportacionDTO.class.getName()).append(" api")
			.append(" set api.costoMonedaOrigen = :pCostoMonedaOrigen, api.porcentajeComision = :pPorcentajeComision, api.idUsuarioModificacion = :pUserId, api.fechaModificacion = current_timestamp()")
			.append(" where api.id.codigoCompania = :pCodigoCompania and api.id.codigoArticulo = :pCodigoArticulo and api.id.codigoProveedor = :pCodigoProveedor");
			
			/*Se prepara el query de actualizacion*/
			Query query = session.createQuery(hql.toString());				
			
			/*Se asignan los parametros al query*/
			query.setParameter("pCodigoCompania", codigoCompania);
			query.setParameter("pCodigoArticulo", codigoArticulo);
			query.setParameter("pCodigoProveedor", codigoProveedor);
			query.setParameter("pCostoMonedaOrigen", costoMonedaOrigen);
			query.setParameter("pPorcentajeComision", porcentajeComision);
			query.setParameter("pUserId", userId);
			
			/*Ejecutamos y realizamos commit del registro*/
			totalRegistros = query.executeUpdate();
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error al actualizar la informacion de importaciones para el articulo." , e);
			throw new SICException("Ha ocurrido un error al actualizar la informacion de importaciones para el articulo.", e);
		}
		return totalRegistros;
	}
	
	/**
	 * Metodo que obtiene el numero de registros ArticuloImportado
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	@Override
	public Long contarArticuloImportado(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException{
		LOG_SICV2.info("==> Conteo ArticuloImportado");
		Long count = 0L;
		Session session = null;
		Criteria criteria = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(codigoArticulo)){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				
				criteria = session.createCriteria(ArticuloImportacionDTO.class, "api");
				criteria.setProjection(Projections.rowCount());
				criteria.add(Restrictions.eq("api.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("api.id.codigoArticulo", codigoArticulo));
				if(codigoProveedor != null){
					criteria.add(Restrictions.eq("api.id.codigoProveedor", codigoProveedor));
				}
				count = (Long) criteria.uniqueResult();
			}
		}catch(Exception e ){
			LOG_SICV2.error("Ha ocurrido un error al contar ArticuloImportado.", e);
			throw new SICException("Ha ocurrido un error al contar ArticuloImportado.", e);
		}finally{
			session = null;
			criteria = null;
		}
		return count;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
