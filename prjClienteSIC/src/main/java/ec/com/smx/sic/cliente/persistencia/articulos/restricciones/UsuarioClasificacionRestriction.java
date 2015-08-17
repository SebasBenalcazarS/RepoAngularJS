package ec.com.smx.sic.cliente.persistencia.articulos.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionUsuarioDTO;

@SuppressWarnings("serial")
public class UsuarioClasificacionRestriction implements CriteriaRestriction{

	private UserDto userDto;	
	private String patternIn;	
	

	public UsuarioClasificacionRestriction(UserDto userDto, String patternIn) {
		this.userDto = userDto;
		this.patternIn = patternIn;
	}


	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		try{
			DetachedCriteria subSelectClaUsu = DetachedCriteria.forClass(ClasificacionUsuarioDTO.class, "clasificacionUsuario");
			subSelectClaUsu.setProjection(Projections.property("id.codigoClasificacion"));
			subSelectClaUsu.createAlias("clasificacionUsuario.clasificacion", "clasificacion");
			subSelectClaUsu.add(Restrictions.eq("clasificacionUsuario.id.userId", this.userDto.getUserId()));
//			subSelectClaUsu.add(Restrictions.eq("clasificacionUsuario.id.userId", this.userDto.));//codigodecompania
			subSelectClaUsu.add(Restrictions.eq("clasificacionUsuario.estadoClasificacionUsuario", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			subSelectClaUsu.add(Restrictions.eq("clasificacion.estadoClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			criterion = Subqueries.propertyIn(this.patternIn, subSelectClaUsu);
		}catch (Exception e) {
			throw new SICException("Se produjo un error al momento de armar la restriccion por usuario-clasificacion");
		}
		return criterion;
	}

}
