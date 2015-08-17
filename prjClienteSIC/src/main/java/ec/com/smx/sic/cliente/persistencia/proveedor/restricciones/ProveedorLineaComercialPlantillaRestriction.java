/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.proveedor.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaLineaComercial;
import ec.com.smx.sic.cliente.common.search.constant.SearchManagerConstants;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClasificacionDTO;
import ec.com.smx.sic.cliente.persistencia.beans.BasePlantillaCriteriaRestriction;

/**
 * @author Luis Yacchirema
 */
@SuppressWarnings("serial")
public class ProveedorLineaComercialPlantillaRestriction extends BasePlantillaCriteriaRestriction<PlantillaBusquedaLineaComercial> {

	public ProveedorLineaComercialPlantillaRestriction(PlantillaBusquedaLineaComercial plantillaBusqueda) {
		super(plantillaBusqueda);
	}

	/**
	 * Busqueda de un proveedor dado el codigo y/o el nombre de la linea comercial
	 */
	@Override
	protected Criterion construirCriteriaRestriction() {

		DetachedCriteria subSelectLinComCla = null;
		
		DynamicCriteriaRestriction dynamicParametersFiltersLineaComercial = new DynamicCriteriaRestriction();
		
		try {
			// Subselect linea comercial clasificacion
			subSelectLinComCla = DetachedCriteria.forClass(LineaComercialClasificacionDTO.class, SearchManagerConstants.getInstance().ALIAS_LINEA_COMERCIAL_CLASIFICACION);
			subSelectLinComCla.setProjection(Projections.property(SearchManagerConstants.getInstance().ALIAS_LINEA_COMERCIAL_CLASIFICACION + ".id.codigoClasificacion"));
			subSelectLinComCla.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_LINEA_COMERCIAL_CLASIFICACION + ".id.codigoCompania", 
					super.getPlantillaBusqueda().getCodigoCompania()));
			subSelectLinComCla.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_LINEA_COMERCIAL_CLASIFICACION + ".estado",
					SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			
			if(super.getPlantillaBusqueda().getCodigoClasificacionLineaComercial() != null) 
				dynamicParametersFiltersLineaComercial.add(super.getPlantillaBusqueda().getCodigoClasificacionLineaComercial().addExpression(), 
						super.getPlantillaBusqueda().getCodigoClasificacionLineaComercial().getBooleanClauseEnum());
			
			if(super.getPlantillaBusqueda().getNombreClasificacionLineaComercial() != null) {
				subSelectLinComCla.createAlias(SearchManagerConstants.getInstance().ALIAS_LINEA_COMERCIAL_CLASIFICACION + ".clasificacion", 
						SearchManagerConstants.getInstance().ALIAS_CLASIFICACION);
				subSelectLinComCla.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".id.codigoCompania", 
						super.getPlantillaBusqueda().getCodigoCompania()));
				subSelectLinComCla.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".estadoClasificacion", 
						SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
				
				dynamicParametersFiltersLineaComercial.add(super.getPlantillaBusqueda().getNombreClasificacionLineaComercial().addExpression(), 
						super.getPlantillaBusqueda().getNombreClasificacionLineaComercial().getBooleanClauseEnum());
			}
			
			if(dynamicParametersFiltersLineaComercial.isNotEmptyCriteriaRestriction()) 
				subSelectLinComCla.add(dynamicParametersFiltersLineaComercial.getCriteriaRestriction());
			
			return Subqueries.propertyIn("id.codigoClasificacion", subSelectLinComCla);
		} catch (Exception e) {
			throw new SICException("Se produjo un error al momento de armar la restriccion.");
		}
	}
}
