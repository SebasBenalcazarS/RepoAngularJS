/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao.garantia;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.ArticuloRangoExtensionGarantiaDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.garantia.IArticuloGarantiaDAO;

/**
 * @author eharo
 *
 */
public class ArticuloGarantiaDAO implements IArticuloGarantiaDAO, Logeable {
	
	private SessionFactory sessionFactory;
	
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.garantia.IArticuloGarantiaDAO#obtenerRangosGE(ec.com.smx.sic.cliente.mdl.dto.ArticuloRangoExtensionGarantiaDTO)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloRangoExtensionGarantiaDTO> obtenerRangosGE(ArticuloRangoExtensionGarantiaDTO rangoExtensionGarantiaDTO, Double precioBaseImp) throws SICException {
		Collection<ArticuloRangoExtensionGarantiaDTO> lstArticuloRangoExtensionGarantiaDTO = null;
		Session session = null;
		Criteria criteria = null;
		try{
			if(rangoExtensionGarantiaDTO != null && precioBaseImp != null){
				LOG_SICV2.info("Buscando rangos EXTENSION garant\u00EDa");
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				session.beginTransaction();
				
				criteria = session.createCriteria(ArticuloRangoExtensionGarantiaDTO.class, "rangoGE");
				if(rangoExtensionGarantiaDTO.getId().getCodigoCompania() != null){
					criteria.add(Restrictions.eq("rangoGE.id.codigoCompania", rangoExtensionGarantiaDTO.getId().getCodigoCompania()));
				}
				if(rangoExtensionGarantiaDTO.getId().getSecuencialRango() != null){
					criteria.add(Restrictions.eq("rangoGE.id.secuencialRango", rangoExtensionGarantiaDTO.getId().getSecuencialRango()));
				}
				criteria.add(Restrictions.eq("rangoGE.estado", SICConstantes.ESTADO_ACTIVO_LITERAL));
				criteria.add(Restrictions.le("rangoGE.rangoInicial", precioBaseImp));
				criteria.add(Restrictions.ge("rangoGE.rangoFinal", precioBaseImp));
				
				lstArticuloRangoExtensionGarantiaDTO = criteria.list();
				session.flush();
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al intentar obtener los rangos de la garantia extendida. {}", e.getMessage());
		}finally{
			session = null;
			criteria = null;
		}
		return lstArticuloRangoExtensionGarantiaDTO;
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
}
