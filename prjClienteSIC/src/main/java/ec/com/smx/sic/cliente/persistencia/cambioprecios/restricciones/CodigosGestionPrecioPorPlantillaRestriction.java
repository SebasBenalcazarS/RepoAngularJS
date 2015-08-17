package ec.com.smx.sic.cliente.persistencia.cambioprecios.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioRelacionDTO;

@SuppressWarnings("serial")
public class CodigosGestionPrecioPorPlantillaRestriction implements CriteriaRestriction {

	private Integer codigoCompania;
	private Long codigoGestionPrecioPlantilla;
	private String propertyIn;
	
	public CodigosGestionPrecioPorPlantillaRestriction(String propertyIn, Integer codigoCompania, Long codigoGestionPrecioPlantilla) {
		this.codigoCompania = codigoCompania;
		this.codigoGestionPrecioPlantilla = codigoGestionPrecioPlantilla;
		this.propertyIn = propertyIn;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		DetachedCriteria subSelectCodGestionPrecio = DetachedCriteria.forClass(GestionPrecioRelacionDTO.class, "gpr");
		
		ProjectionList projections = Projections.projectionList();
		//SELECTS				
		projections.add(Projections.distinct(Projections.property(("gpr.codigoGestionPrecio"))));	
		subSelectCodGestionPrecio.setProjection(projections);	

		//RESTRICCION
		subSelectCodGestionPrecio.add(Restrictions.eq("gpr.id.codigoCompania",codigoCompania));	
		subSelectCodGestionPrecio.add(Restrictions.eq("gpr.codigoGestionPrecioRelacionado",codigoGestionPrecioPlantilla));

		return Subqueries.propertyIn(this.propertyIn, subSelectCodGestionPrecio);
	}

}
