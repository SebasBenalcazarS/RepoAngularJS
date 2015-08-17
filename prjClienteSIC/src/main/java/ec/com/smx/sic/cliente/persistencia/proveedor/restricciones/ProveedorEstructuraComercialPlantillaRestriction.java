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
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaEstructuraComercial;
import ec.com.smx.sic.cliente.common.search.constant.SearchManagerConstants;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.persistencia.beans.BasePlantillaCriteriaRestriction;

/**
 * 
 * @author Luis Yacchirema
 * 
 * @author Gabriel Nolivos
 *
 */
@SuppressWarnings("serial")
public class ProveedorEstructuraComercialPlantillaRestriction extends BasePlantillaCriteriaRestriction<PlantillaBusquedaEstructuraComercial> {

	public ProveedorEstructuraComercialPlantillaRestriction(PlantillaBusquedaEstructuraComercial plantillaBusqueda) {
		super(plantillaBusqueda);
	}
	
	@Override
	protected Criterion construirCriteriaRestriction() {

		DetachedCriteria subSelectProveedorClasificacion;
		DynamicCriteriaRestriction dynamicParametersFiltersEstructuraComercial = new DynamicCriteriaRestriction();

		subSelectProveedorClasificacion = DetachedCriteria.forClass(ArticuloProveedorDTO.class, SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR);
		subSelectProveedorClasificacion.setProjection(Projections.property(SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR + ".id.codigoProveedor"));

		// Parametros por default
		subSelectProveedorClasificacion.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR + ".id.codigoCompania", super.getPlantillaBusqueda().getCodigoCompania()));
		subSelectProveedorClasificacion.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR + ".estadoArticuloProveedor", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));

		// Join Proveedor - Articulo 
		subSelectProveedorClasificacion.createAlias(SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR + ".articulo", SearchManagerConstants.getInstance().ALIAS_ARTICULO);

		// Join Articulo - Clasificacion
		subSelectProveedorClasificacion.createAlias(SearchManagerConstants.getInstance().ALIAS_ARTICULO + ".clasificacionDTO", SearchManagerConstants.getInstance().ALIAS_CLASIFICACION);

		// Join Clasificacion - Clasificacion Departamento
		subSelectProveedorClasificacion.createAlias(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".clasificacionPadre", SearchManagerConstants.getInstance().ALIAS_CLASIFICACION_DEPARTAMENTO);
		
		// Join Clasificacion - Clasificacion Division
		subSelectProveedorClasificacion.createAlias(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION_DEPARTAMENTO + ".clasificacionPadre", SearchManagerConstants.getInstance().ALIAS_CLASIFICACION_DIVISION);
		
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
			subSelectProveedorClasificacion.add(dynamicParametersFiltersEstructuraComercial.getCriteriaRestriction());

		return Subqueries.propertyIn("id.codigoProveedor", subSelectProveedorClasificacion);
		
	}
}
