package ec.com.smx.sic.articulo.persistence.dao.novedad;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloNovedadCuponDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.novedad.IArticuloNovedadDAO;

public class ArticuloNovedadDAO implements IArticuloNovedadDAO, Logeable {
	
	private SessionFactory sessionFactory;

	@Override
	public void ejecutarResolverInconsistenciasArticuloRelacionadoCupon(Integer codigoCompania, Integer numeroIteraccion) throws SICException {
		Session session;
		Query query;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			Logeable.LOG_SICV2.info("Iniciando ejecutarResolverInconsistenciasArticuloRelacionadoCupon");
			Logeable.LOG_SICV2.info("Parametros");
			Logeable.LOG_SICV2.info("1.- codigoCompania:{}", codigoCompania);
			Logeable.LOG_SICV2.info("2.- numeroEjecucion:{}", numeroIteraccion);
			
			query = session.createSQLQuery("CALL PROARTNOVCUP(?,?)").setInteger(0, codigoCompania).setInteger(1, numeroIteraccion);
			query.executeUpdate();
			
			Logeable.LOG_SICV2.info("Finalizo ejecutarResolverInconsistenciasArticuloRelacionadoCupon");
			
		} catch(Exception e) {
			throw new SICException("Se produjo un error al momento de ejecutar el procedimiento almacenado ", e);
		}
	}

	@Override
	public Collection<ArticuloNovedadCuponDTO> obtenerRegistrosProcesados(Integer codigoCompania) throws SICException {
		Collection<ArticuloNovedadCuponDTO> articuloNovedadCuponCol = null;
		Session session;
		Criteria criteria;
		
		try {
			
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloNovedadCuponDTO.class, "anp");
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("estado", SICArticuloConstantes.getInstancia().ESTADO_PROCESADO_NOVEDAD_CUPON));
			
			articuloNovedadCuponCol = criteria.list();
			
		} catch(Exception e) {
			throw new SICException("Error al obtener los registros procesados de las inconsistencias", e);
		}
		
		return articuloNovedadCuponCol;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
