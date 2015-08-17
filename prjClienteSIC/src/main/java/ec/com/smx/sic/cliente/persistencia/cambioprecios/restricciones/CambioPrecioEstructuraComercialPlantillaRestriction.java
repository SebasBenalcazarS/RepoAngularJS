/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.cambioprecios.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaEstructuraComercial;
import ec.com.smx.sic.cliente.common.search.constant.SearchManagerConstants;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.persistencia.beans.BasePlantillaCriteriaRestriction;

/**
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class CambioPrecioEstructuraComercialPlantillaRestriction extends BasePlantillaCriteriaRestriction<PlantillaBusquedaEstructuraComercial>{

	String alias;
	
	public CambioPrecioEstructuraComercialPlantillaRestriction(PlantillaBusquedaEstructuraComercial plantillaBusqueda, String alias) {
		super(plantillaBusqueda);
		this.alias = alias;
	}

	@Override
	protected Criterion construirCriteriaRestriction() {
		
		DetachedCriteria subSelectCambioPrecioClasificacion;
		DynamicCriteriaRestriction dynamicParametersFiltersEstructuraComercial = new DynamicCriteriaRestriction();
		
		subSelectCambioPrecioClasificacion = DetachedCriteria.forClass(ClasificacionDTO.class, SearchManagerConstants.getInstance().ALIAS_CLASIFICACION);
		subSelectCambioPrecioClasificacion.setProjection(Projections.property(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".id.codigoClasificacion"));

		//Parametros por defecto
		subSelectCambioPrecioClasificacion.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".id.codigoCompania", super.getPlantillaBusqueda().getCodigoCompania()));
		subSelectCambioPrecioClasificacion.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".estadoClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));

		// Join Clasificacion - Clasificacion Departamento
		subSelectCambioPrecioClasificacion.createAlias(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".clasificacionPadre", SearchManagerConstants.getInstance().ALIAS_CLASIFICACION_DEPARTAMENTO);
		
		// Join Clasificacion - Clasificacion Division
		subSelectCambioPrecioClasificacion.createAlias(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION_DEPARTAMENTO + ".clasificacionPadre", SearchManagerConstants.getInstance().ALIAS_CLASIFICACION_DIVISION);
	
		// Filtros por codigos de los Niveles de la Estructura Comercial
		if (super.getPlantillaBusqueda().getCodigoClasificacion() != null) {
			dynamicParametersFiltersEstructuraComercial.add(super.getPlantillaBusqueda().getCodigoClasificacion().getCriteriaRestriction(), 
					super.getPlantillaBusqueda().getCodigoClasificacion().getBooleanClauseEnum());
		}

		// Filtros por descripcion de los Niveles de la Estructura Comercial
		if (super.getPlantillaBusqueda().getDescripcionClasificacion() != null) {
			dynamicParametersFiltersEstructuraComercial.add(super.getPlantillaBusqueda().getDescripcionClasificacion().getCriteriaRestriction(), 
					super.getPlantillaBusqueda().getDescripcionClasificacion().getBooleanClauseEnum());
		}

		if(dynamicParametersFiltersEstructuraComercial.isNotEmptyCriteriaRestriction())	
			subSelectCambioPrecioClasificacion.add(dynamicParametersFiltersEstructuraComercial.getCriteriaRestriction());

		return Subqueries.propertyIn(this.alias, subSelectCambioPrecioClasificacion);
	}
}
