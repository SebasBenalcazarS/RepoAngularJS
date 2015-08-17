package ec.com.smx.sic.articulo.persistence.dao.accion;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.accion.IAccionArticuloDAO;

/**
 * clase que se encarga de las llamadas a procedimientos o funciones desde una tarea programada
 * @author corbe
 *
 */
public class AccionArticuloDAO implements IAccionArticuloDAO{
	
	private SessionFactory sessionFactory;
	
	public void sincronizarInformacionArticuloLeyMercado(Integer codigoCompania)throws SICException{
		try{
			Session session = sessionFactory.getCurrentSession();
			session.clear();
			Query query = session.createSQLQuery("CALL PROARTLEYMER(?)").setInteger( 0 , codigoCompania);
			query.executeUpdate();
		}catch(Exception e){
			Logeable.LOG_SICV2.error("ha ocurrido un error al llamar al procedimiento PROARTLEYMER "+e.getMessage());
			throw new SICException("ha ocurrido un error al llamar al procedimiento que sincroniza la ley de mercado del articulo");
		}
		
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
