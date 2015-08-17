package ec.com.smx.sic.articulo.persistence.dao.pendienteintegracion;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPendienteIntegracionDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.pendienteintegracion.IArticuloPendienteIntegracionDAO;

public class ArticuloPendienteIntegracionDAO implements IArticuloPendienteIntegracionDAO, Logeable{
	
	private SessionFactory sessionFactory;
	
	@Override
	public Long contarArticuloNovedad(Integer codigoCompania, String codigoArticulo, String valorTipoProceso){
		
		LOG_SICV2.info("==> Conteo articulo con novedad");
		Long count = 0L;
		Session session = null;
		Criteria criteria = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(codigoArticulo) && StringUtils.isNotEmpty(valorTipoProceso)){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				
				criteria = session.createCriteria(ArticuloPendienteIntegracionDTO.class, "api");
				criteria.setProjection(Projections.rowCount());
				criteria.add(Restrictions.eq("api.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("api.codigoArticulo", codigoArticulo));
				criteria.add(Restrictions.eq("api.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				criteria.add(Restrictions.eq("api.valorTipoProceso", valorTipoProceso));
				criteria.add(Restrictions.eq("api.notificar", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				count = (Long) criteria.uniqueResult();
			}else{
				throw new SICException("No se ha podido contar los articulos con novedad ");
			}
		}catch(Exception e ){
			throw new SICException("No se ha podido contar los articulos con novedad ", e);
		}
		return count;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}