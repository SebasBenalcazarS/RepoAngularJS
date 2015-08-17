/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao.masivo;

import java.util.Collection;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDinamicaDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.masivo.IArticuloMasivoDAO;

/**
 * @author eharo
 *
 */
public class ArticuloMasivoDAO implements IArticuloMasivoDAO, Logeable {
	
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.masivo.IArticuloMasivoDAO#obtenerMapaClasificacionCarDin(java.lang.Integer, java.util.Set)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Collection<CaracteristicaDinamicaDTO> obtenerCaracteristiacasDinamicas(Integer codigoCompania, Set<String> codigosClasificaciones, Collection<Integer> codigosCaracteristicasDinamicas) throws SICException {
		Collection<CaracteristicaDinamicaDTO> lstCaracteristicaDinamicaDTO = null;
		Session session = null;
		Criteria criteria = null;
		try{
			if(codigoCompania != null && CollectionUtils.isNotEmpty(codigosClasificaciones)){
				
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
				
				criteria = session.createCriteria(CaracteristicaDinamicaDTO.class, "carDin");
				
				criteria.add(Restrictions.eq("carDin.codigoCompania", codigoCompania));
				criteria.add(Restrictions.in("carDin.codigoClasificacion", codigosClasificaciones));
				criteria.add(Restrictions.eq("carDin.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				if(CollectionUtils.isNotEmpty(codigosCaracteristicasDinamicas)){
					criteria.add(Restrictions.in("carDin.codigoTipoCaracteristica", codigosCaracteristicasDinamicas));
				}
				
				lstCaracteristicaDinamicaDTO = criteria.list();
				
				session.flush();
			}
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al obtener la lista de caracter\u00EDsticas din\u00E1micas",e.getMessage());
		}finally{
			session = null;
			criteria = null;
		}
		return lstCaracteristicaDinamicaDTO;
	}

	/*********************************************************************************************/
	/****************************METODOS**SETTER**************************************************/
	/*********************************************************************************************/
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
}
