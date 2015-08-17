package ec.com.smx.sic.cliente.persistencia.articulos.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionUsuarioDTO;

/**
 * Permite obtener subselect con usuario clasificacion para opbtener las subbodegas del usuario
 * @author fcollaguazo
 *
 */
@SuppressWarnings("serial")
public class UsuarioClasificacionBodegaRestriction implements CriteriaRestriction{

	private String userId;
	
	public UsuarioClasificacionBodegaRestriction(String userId) {
		this.userId = userId;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		try{
			DetachedCriteria subSelectClaUsu = DetachedCriteria.forClass(ClasificacionUsuarioDTO.class, "clasificacionUsuario");
			subSelectClaUsu.setProjection(Projections.distinct(Projections.property("clasificacion.codigoBodega")));
			subSelectClaUsu.createAlias("clasificacionUsuario.clasificacion", "clasificacion");
			subSelectClaUsu.add(Restrictions.eq("clasificacionUsuario.id.userId", this.userId));
			subSelectClaUsu.add(Restrictions.eq("clasificacionUsuario.estadoClasificacionUsuario", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			subSelectClaUsu.add(Restrictions.eq("clasificacion.estadoClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			criterion = Subqueries.propertyIn("id.codigoBodega", subSelectClaUsu);
		}catch (Exception e) {
			throw new SICException("Se produjo un error al momento de armar la restricción por usuario-clasificación-bodega");
		}
		return criterion;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
