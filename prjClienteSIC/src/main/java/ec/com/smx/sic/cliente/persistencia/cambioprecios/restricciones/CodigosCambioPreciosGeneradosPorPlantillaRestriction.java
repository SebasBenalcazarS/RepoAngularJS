package ec.com.smx.sic.cliente.persistencia.cambioprecios.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioRelacionDTO;

/**
 * @author Marcelo Hidalgo
 *
 */
@SuppressWarnings("serial")
public class CodigosCambioPreciosGeneradosPorPlantillaRestriction implements CriteriaRestriction{
	
	private String propertyNotIn; 
	private Integer codigoCompania;
	
	public CodigosCambioPreciosGeneradosPorPlantillaRestriction(String propertyNotIn, Integer codigoCompania) {
		this.propertyNotIn = propertyNotIn;
		this.codigoCompania = codigoCompania;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		
		DetachedCriteria subSelectGesPreRel = DetachedCriteria.forClass(GestionPrecioRelacionDTO.class, "gestionPrecioRelacion");
		subSelectGesPreRel.setProjection(Projections.distinct(Projections.property("gestionPrecioRelacion.codigoGestionPrecio")));
		subSelectGesPreRel.add(Restrictions.eq("gestionPrecioRelacion.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		subSelectGesPreRel.add(Restrictions.eq("gestionPrecioRelacion.id.codigoCompania", codigoCompania));
		
		return Subqueries.propertyNotIn(this.propertyNotIn, subSelectGesPreRel);
	}

}
