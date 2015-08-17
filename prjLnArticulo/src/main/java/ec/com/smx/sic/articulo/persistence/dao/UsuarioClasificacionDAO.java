package ec.com.smx.sic.articulo.persistence.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionUsuarioDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IUsuarioClasificacionDAO;


public class UsuarioClasificacionDAO implements Logeable, IUsuarioClasificacionDAO{


	private IHibernateH<ClasificacionUsuarioDTO> hibernateH;

	/**
	 * Funcion para desactivar las clasificaciones de un grupo de usuarios
	 * @param funcionarios
	 * @param clasificaciones
	 * @throws SICException
	 */
	@Override
	public void desactivarEstadoPorClasificacionUsuario(Collection<String> usuarios, Collection<String> clasificaciones, int compania ) throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			query = new StringBuilder();
			query.append("update ").append(ClasificacionUsuarioDTO.class.getName()).append(" uC set uC.estadoClasificacionUsuario = '0' where uC.id.codigoCompania = :pCodigoCompania and uC.id.userId in (:pCodigosUsuarios) and uC.id.codigoClasificacion in (:pCodigosClasificaciones)");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setParameter("pCodigoCompania", compania );
			hqlQuery.setParameterList("pCodigosUsuarios", usuarios );
			hqlQuery.setParameterList("pCodigosClasificaciones", clasificaciones);
			hqlQuery.executeUpdate();
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}
	}

	public void setHibernateH(IHibernateH<ClasificacionUsuarioDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
}
