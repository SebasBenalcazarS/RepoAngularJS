/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao.funcionario;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.funcionario.IFuncionarioAreaTrabajoDAO;



/**
 * @author jmontenegro
 *
 */
public class FuncionarioAreaTrabajoDAO implements IFuncionarioAreaTrabajoDAO {

	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<FuncionarioAreaTrabajoDTO> consultarFuncionarioAreaTrabajoPorAreaTrabajo(Integer codigoAreaTrabajo,String userId, Integer codigoCompania, String usuarioSesion)throws SICException{
		try {
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(FuncionarioAreaTrabajoDTO.class);
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("usuarioDTO.userId"),"funcionarioDTO.usuarioDTO.userId")
					.add(Projections.property("usuarioDTO.userCompleteName"),"funcionarioDTO.usuarioDTO.userCompleteName")
					.add(Projections.property("usuarioDTO.userName"),"funcionarioDTO.usuarioDTO.userName")
					.add(Projections.property("areaTrabajoDTO.nombreAreaTrabajo"),"areaTrabajoDTO.nombreAreaTrabajo")
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("id.codigoFuncionario"),"id.codigoFuncionario")
					.add(Projections.property("id.codigoAreaTrabajo"),"id.codigoAreaTrabajo")
					
					);
			
			criteria.createAlias("funcionarioDTO", "funcionarioDTO");
			criteria.createAlias("funcionarioDTO.usuarioDTO", "usuarioDTO");
			
			criteria.createAlias("areaTrabajoDTO", "areaTrabajoDTO");
			
			criteria.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_LITERAL));
			criteria.add(Restrictions.eq("funcionarioDTO.estadoFuncionario", SICConstantes.ESTADO_ACTIVO_LITERAL));
			criteria.add(Restrictions.eq("areaTrabajoDTO.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("areaTrabajoDTO.id.codigoAreaTrabajo", codigoAreaTrabajo));
			criteria.add(Restrictions.ne("usuarioDTO.userName", usuarioSesion));
			
			//si el usuario ingresa un nombre o usuario de un funcionario
			if(StringUtils.isNotEmpty(userId)){
				Disjunction disjunction = Restrictions.disjunction();
				disjunction.add(Restrictions.ilike("usuarioDTO.userName", userId, MatchMode.ANYWHERE));
				disjunction.add(Restrictions.ilike("usuarioDTO.userCompleteName", userId, MatchMode.ANYWHERE));
				criteria.add(disjunction);
			}
			criteria.setResultTransformer(new DtoResultTransformer(FuncionarioAreaTrabajoDTO.class));
			
			Collection<FuncionarioAreaTrabajoDTO> funcionarioAreaTrabajoDTOCol = criteria.list();
			
			return funcionarioAreaTrabajoDTOCol;
			
		} catch (HibernateException e) {
			throw new SICException("Error consultarFuncionarioAreaTrabajoPorAreaTrabajo: ",e);
		}catch (Exception e) {
			throw new SICException("Error consultarFuncionarioAreaTrabajoPorAreaTrabajo ",e);
		}
	}
	
	
}
