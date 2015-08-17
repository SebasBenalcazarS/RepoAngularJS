package ec.com.smx.sic.articulo.persistence.dao.usuarioautorizacion;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioClasificacionProcesoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.usuarioautorizacion.IUsuarioClasificacionProcesoDAO;

/**
 * 
 * @author cortiz
 *
 */
public class UsuarioClasificacionProcesoDAO implements IUsuarioClasificacionProcesoDAO{

	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/************************************************************************************************************************************************
	 * METODOS DE autorizacion usuario
	 * ***********************************************************************************************************************************************
	 */
	@Override
	public ArrayList<String> obtenerClasificacionesContarUsuario(Integer codigoCompania, String parametro)throws SICException{
		Logeable.LOG_SICV2.info("Metodo : obtenerClasificaciones");
		Logeable.LOG_SICV2.info("Parametros : ");
		Logeable.LOG_SICV2.info("codigo compania: "+ codigoCompania);
		try {
			this.sessionFactory.getCurrentSession().clear();
			
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UsuarioClasificacionProcesoDTO.class);
			criteria.add(Restrictions.eq("id.codigoCompania",codigoCompania));
			criteria.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			String having = "codigoClasificacion" + " having " + "count(codigoUsuario) >= " + parametro;

			String[] alias = new String[1]; 
			alias[0] = "codigoClasificacion"; 
			Type[] types = new Type[1]; 
			types[0] = StandardBasicTypes.STRING;

			criteria.setProjection(Projections.projectionList()
					.add(Projections.alias(Projections.sqlGroupProjection("codigoClasificacion", having, alias , types), "usuCLa")));
			criteria.addOrder(Order.asc("id.codigoClasificacion"));
			
			ArrayList<String> usuProCol = (ArrayList<String>)criteria.list();
			return usuProCol;
			
		} catch (HibernateException e) {
			Logeable.LOG_SICV2.info("Error al buscar obtenerClasificacionesContarUsuario ");
			throw new SICException("Error al buscar obtenerClasificacionesContarUsuario ",e);
		}
	}
	
	@Override
	public Collection<UsuarioClasificacionProcesoDTO> reportesUsuarios(Integer codigoCompania, String codigoclasificacion, String user)throws SICException{
		try {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UsuarioClasificacionProcesoDTO.class);
			
			criteria.createAlias("clasificacionDTO", "cla");
			criteria.createAlias("userDTO", "user");
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("codigoUsuarioClasificacion"),"codigoUsuarioClasificacion")
					.add(Projections.property("codigoProceso"),"codigoProceso")
					.add(Projections.property("id.codigoClasificacion"),"id.codigoClasificacion")
					.add(Projections.property("id.codigoUsuario"),"id.codigoUsuario")
					.add(Projections.property("cla.descripcionClasificacion"),"clasificacionDTO.descripcionClasificacion")
					.add(Projections.property("cla.id.codigoCompania"),"clasificacionDTO.id.codigoCompania")
					.add(Projections.property("cla.id.codigoClasificacion"),"clasificacionDTO.id.codigoClasificacion")
					.add(Projections.property("user.userId"),"userDTO.userId")
					.add(Projections.property("user.userCompleteName"),"userDTO.userCompleteName"));
			
			criteria.add(Restrictions.eq("id.codigoCompania",codigoCompania));
			criteria.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			if(StringUtils.isNotBlank(codigoclasificacion)){
				criteria.add(Restrictions.eq("id.codigoClasificacion",codigoclasificacion));
			}
			
			 if(StringUtils.isNotBlank(user)){
				 Disjunction disjunction = Restrictions.disjunction();
				 disjunction.add(Restrictions.ilike("user.userCompleteName",user, MatchMode.ANYWHERE));
				 disjunction.add(Restrictions.ilike("user.userId",user, MatchMode.ANYWHERE));
				 criteria.add(disjunction);
			}
			 
			
			criteria.setResultTransformer(new DtoResultTransformer(UsuarioClasificacionProcesoDTO.class));
			Collection<UsuarioClasificacionProcesoDTO> usuClaCol = criteria.list();
			return usuClaCol;
			
		} catch (HibernateException e) {
			Logeable.LOG_SICV2.info("Error al buscar reportesUsuarios ");
			throw new SICException("Error al buscar reportesUsuarios ",e);
		}
		
	}
	
	@Override
	public UsuarioClasificacionProcesoDTO buscarUsuarioCLasificacion(UsuarioClasificacionProcesoDTO usuClaDTO)throws SICException{
		try {
			this.sessionFactory.getCurrentSession().clear();
			
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UsuarioClasificacionProcesoDTO.class);
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("codigoUsuarioClasificacion"),"codigoUsuarioClasificacion")
					.add(Projections.property("codigoProceso"),"codigoProceso")
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("id.codigoClasificacion"),"id.codigoClasificacion")
					.add(Projections.property("id.codigoUsuario"),"id.codigoUsuario"));
					
			criteria.add(Restrictions.eq("id.codigoCompania",usuClaDTO.getId().getCodigoCompania()));
			criteria.add(Restrictions.eq("id.codigoClasificacion",usuClaDTO.getId().getCodigoClasificacion()));
			criteria.add(Restrictions.eq("id.codigoUsuario",usuClaDTO.getId().getCodigoUsuario()));
			
			criteria.setResultTransformer(new DtoResultTransformer(UsuarioClasificacionProcesoDTO.class));
			UsuarioClasificacionProcesoDTO usuCla= (UsuarioClasificacionProcesoDTO) criteria.uniqueResult();
			
			return usuCla;
		} catch (HibernateException e) {
			Logeable.LOG_SICV2.info("Error al buscarUsuarioCLasificacion ");
			throw new SICException("Error al buscarUsuarioCLasificacion ",e);
		}
	}
	
	@Override
	public void actualizarUsuarioClasificacion(UsuarioClasificacionProcesoDTO usuClaDTO)throws SICException{
		StringBuilder query = new StringBuilder();
		Query update;
		try {
			if(usuClaDTO.getEstado() == null){
				throw new SICException("El estado de la relacion usuario clasificacion no puede ser nulo");
			}else{
				this.sessionFactory.getCurrentSession().clear();
				query.append("update ").append(UsuarioClasificacionProcesoDTO.class.getName())
					.append(" a  set ")
					.append("a.estado = :pEstado ,")
					.append("a.fechaModificacion = CURRENT_TIMESTAMP , " )
					.append("a.usuarioModificacion = :pUsuarioModificacion ")
					.append("where  " )
					.append("a.id.codigoClasificacion = :pCodigoClasificacion " )
					.append("and a.id.codigoCompania = :pCodigoCompania " )
					.append("and a.id.codigoUsuario = :pCodigoUsuario " )
					.append("and a.estado != :pEstado " );
				
				update = this.sessionFactory.getCurrentSession().createQuery(query.toString());
				
				update.setString("pUsuarioModificacion",usuClaDTO.getUserId());			
				update.setString("pCodigoClasificacion",usuClaDTO.getId().getCodigoClasificacion());
				update.setInteger("pCodigoCompania", usuClaDTO.getId().getCodigoCompania());
				update.setString("pCodigoUsuario", usuClaDTO.getId().getCodigoUsuario());
				update.setString("pEstado", usuClaDTO.getEstado());
				
				update.executeUpdate();

			}
		} catch (HibernateException e) {
			Logeable.LOG_SICV2.info("Error al actualizarUsuarioClasificacion ");
			throw new SICException("Error al actualizarUsuarioClasificacion ",e);
		}
	}
	
	@Override
	public Collection<UsuarioClasificacionProcesoDTO> obtenerClasificacionesUsuario(Integer codigoCompania, String usuario)throws SICException{
		try {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UsuarioClasificacionProcesoDTO.class);
			
			criteria.createAlias("clasificacionDTO", "cla");
			criteria.createAlias("userDTO", "user");
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("id.codigoClasificacion"),"id.codigoClasificacion")
					.add(Projections.property("id.codigoUsuario"),"id.codigoUsuario"));
			
			criteria.add(Restrictions.eq("id.codigoCompania",codigoCompania));
			criteria.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("user.userId", usuario));
			
			criteria.setResultTransformer(new DtoResultTransformer(UsuarioClasificacionProcesoDTO.class));
			Collection<UsuarioClasificacionProcesoDTO> usuClaCol = criteria.list();
			return usuClaCol;
			
		} catch (HibernateException e) {
			Logeable.LOG_SICV2.info("Error al buscar reportesUsuarios ");
			throw new SICException("Error al buscar reportesUsuarios ",e);
		}
		
	}
	/*************************************************************************************************************************************************
	* FIN metodos de autorizacion usuario
	* ***********************************************************************************************************************************************
	*/
}
