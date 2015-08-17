package ec.com.smx.sic.cliente.persistencia.bodega.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionAreaTrabajoDTO;

/**
 * Permite obtener la subconsulta de los andenes asignados
 * @author fcollaguazo
 *
 */
@SuppressWarnings("serial")
public class AndenesAreaTrabajoRestriccion implements CriteriaRestriction{

	@Override
	public Criterion getCriteriaRestriction() {
		DetachedCriteria subSelect = DetachedCriteria.forClass(DetalleSeccionAreaTrabajoDTO.class);
		subSelect.add(Restrictions.eq("estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		Projection projection = Projections.property("id.codigoDetalleSeccion");
		subSelect.setProjection(projection);
		return Subqueries.propertyNotIn("id.codigoDetalleSeccion", subSelect);
	}
}
