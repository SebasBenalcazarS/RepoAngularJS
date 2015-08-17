/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloProcesoLogisticoDAO;

/**
 * @author jdvasquez
 *
 */
public class ArticuloProcesoLogisticoDAO implements IArticuloProcesoLogisticoDAO , Logeable {
	
	 private SessionFactory sessionFactory;
	 
	 
	 /**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public ArticuloProcesoLogisticoDTO obtenerInformacionDespachoArticulo(Integer codigoCompania, String codigoArticulo) throws SICException{
		 try{
			 Session session = sessionFactory.getCurrentSession();
			 session.clear();
			 StringBuilder sql = null;
			 Query hqlQuery = null;
	  
			 sql = new StringBuilder();
			 sql.append("from ArticuloProcesoLogisticoDTO as a"); 
			 sql.append(" where a.id.codigoArticulo = :pCodigoArticulo");
			 sql.append(" and a.id.codigoCompania = :pCodigoCompania");
			 hqlQuery = session.createQuery(sql.toString());
			 hqlQuery.setParameter("pCodigoArticulo", codigoArticulo);
			 hqlQuery.setParameter("pCodigoCompania", codigoCompania);
			 return (ArticuloProcesoLogisticoDTO) hqlQuery.uniqueResult();
			 
		 }catch(Exception e){
			 LOG_SICV2.error("Ocurrio un error al obtener la informacion de despacho del articulo");
			 throw new SICException("Ocurrio un error al obtener la informacion de despacho del articulo", e);
		 }
		 
	 }
}
