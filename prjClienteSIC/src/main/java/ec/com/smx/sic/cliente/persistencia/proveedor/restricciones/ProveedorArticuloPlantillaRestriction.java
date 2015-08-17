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
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaArticulo;
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
public class ProveedorArticuloPlantillaRestriction extends BasePlantillaCriteriaRestriction<PlantillaBusquedaArticulo> {


	public ProveedorArticuloPlantillaRestriction(PlantillaBusquedaArticulo plantillaBusqueda) {
		super(plantillaBusqueda);
	}

	@Override
	protected Criterion construirCriteriaRestriction() {

		DetachedCriteria subSelectArticulo;
		DynamicCriteriaRestriction dynamicParametersFiltersArticulo = new DynamicCriteriaRestriction();

		subSelectArticulo = DetachedCriteria.forClass(ArticuloProveedorDTO.class, SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR);
		subSelectArticulo.setProjection(Projections.property(SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR + ".id.codigoProveedor"));

		// Parametros por default
		subSelectArticulo.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR + ".id.codigoCompania", super.getPlantillaBusqueda().getCodigoCompania()));
		subSelectArticulo.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR + ".estadoArticuloProveedor", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));

		// Filtros de Articulo
		subSelectArticulo.createAlias(SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR + ".articulo", SearchManagerConstants.getInstance().ALIAS_ARTICULO);

		if (super.getPlantillaBusqueda().getDescripcionArticulo() != null){
			dynamicParametersFiltersArticulo.add(super.getPlantillaBusqueda().getDescripcionArticulo().addExpression(), super.getPlantillaBusqueda().getDescripcionArticulo().getBooleanClauseEnum());
		}

		if (super.getPlantillaBusqueda().getEstadoArticulo() != null){
			dynamicParametersFiltersArticulo.add(super.getPlantillaBusqueda().getEstadoArticulo().addExpression(), 
					super.getPlantillaBusqueda().getEstadoArticulo().getBooleanClauseEnum());
		}
		
		// Codigo de barras
		if (super.getPlantillaBusqueda().getCodigoDeBarras() != null) {
			dynamicParametersFiltersArticulo.add(super.getPlantillaBusqueda().getCodigoDeBarras().addExpression(), 
					super.getPlantillaBusqueda().getCodigoDeBarras().getBooleanClauseEnum());
		}

		// Filtro Codigo referencia interna
		if (super.getPlantillaBusqueda().getCodigoReferenciaInterna() != null) {
			dynamicParametersFiltersArticulo.add(super.getPlantillaBusqueda().getCodigoReferenciaInterna().addExpression(), 
					super.getPlantillaBusqueda().getCodigoReferenciaInterna().getBooleanClauseEnum());
		}

		// Filtro Codigo referencia externa
		if (super.getPlantillaBusqueda().getCodigoReferenciaExterna() != null) {
			dynamicParametersFiltersArticulo.add(super.getPlantillaBusqueda().getCodigoReferenciaExterna().addExpression(), 
					super.getPlantillaBusqueda().getCodigoReferenciaExterna().getBooleanClauseEnum());
		}

		// Filtro Codigo clase articulo
		if (super.getPlantillaBusqueda().getCodigoClaseArticulo() != null){
			dynamicParametersFiltersArticulo.add(super.getPlantillaBusqueda().getCodigoClaseArticulo().getCriteriaRestriction(), 
					super.getPlantillaBusqueda().getCodigoClaseArticulo().getBooleanClauseEnum());
		}

		if(dynamicParametersFiltersArticulo.isNotEmptyCriteriaRestriction())
			subSelectArticulo.add(dynamicParametersFiltersArticulo.getCriteriaRestriction());

		return Subqueries.propertyIn("id.codigoProveedor", subSelectArticulo);

	}
}
