package ec.com.smx.sic.articulo.persistence.dao;

import java.sql.Timestamp;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloMigracionArticuloPortalDAO;

/**
 * clase que llama al procedimiento que migra la informacion de articulo portal
 * @author corbe
 *
 */
public class ArticuloMigracionArticuloPortalDAO implements IArticuloMigracionArticuloPortalDAO{
	private SessionFactory sessionFactory;
	
	public void migrarArticulosInformacionPortal(Integer codigoCompania)throws SICException{
		Logeable.LOG_SICV2.info("Inicio procedimiento de migracion de articulo informacion portal");
		Logeable.LOG_SICV2.info("Fecha Inicio: "+ new Timestamp(System.currentTimeMillis()).toString());

		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createSQLQuery("CALL PROMIGARTINFPOR(?)").setInteger( 0 , codigoCompania);
		query.executeUpdate();

		Logeable.LOG_SICV2.info("Fin procedimiento de migracion de articulo informacion portal");
		Logeable.LOG_SICV2.info("Fecha Fin: "+ new Timestamp(System.currentTimeMillis()).toString());
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
