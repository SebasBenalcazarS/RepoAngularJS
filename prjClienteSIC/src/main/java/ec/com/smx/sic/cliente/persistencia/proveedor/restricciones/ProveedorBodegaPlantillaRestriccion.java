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
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaBodega;
import ec.com.smx.sic.cliente.common.search.constant.SearchManagerConstants;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.persistencia.beans.BasePlantillaCriteriaRestriction;

/**
 * @author Victor Jaramillo
 *
 */
@SuppressWarnings("serial")
public class ProveedorBodegaPlantillaRestriccion extends BasePlantillaCriteriaRestriction<PlantillaBusquedaBodega> {

	public ProveedorBodegaPlantillaRestriccion(PlantillaBusquedaBodega plantillaBusqueda) {
		super(plantillaBusqueda);
	}
	
	@Override
	protected Criterion construirCriteriaRestriction() {
		DetachedCriteria subSelectBodega;
		DynamicCriteriaRestriction dynamicParametersFiltersBodega = new DynamicCriteriaRestriction();
		
		subSelectBodega = DetachedCriteria.forClass(ProveedorClasificacionDTO.class, SearchManagerConstants.getInstance().ALIAS_PROVEEDOR_CLASIFICACION);
		subSelectBodega.setProjection(Projections.property(SearchManagerConstants.getInstance().ALIAS_PROVEEDOR_CLASIFICACION + ".id.codigoProveedor"));
		
		// Filtro Codigo compania
		subSelectBodega.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_PROVEEDOR_CLASIFICACION + ".id.codigoCompania", super.getPlantillaBusqueda().getCodigoCompania()));
		
		// Join ProveedorDTO - ClasificacionDTO 
		subSelectBodega.createAlias(SearchManagerConstants.getInstance().ALIAS_PROVEEDOR_CLASIFICACION + ".clasificacion", SearchManagerConstants.getInstance().ALIAS_CLASIFICACION);
		// Join ClasificacionDTO - BodegaDTO
		subSelectBodega.createAlias(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".bodegaDTO", SearchManagerConstants.getInstance().ALIAS_SUBBODEGA);
		
		// Asignacion de criterion en codigoBodega
		if (super.getPlantillaBusqueda().getCodigoBodega() != null){
			dynamicParametersFiltersBodega.add(super.getPlantillaBusqueda().getCodigoBodega().getCriteriaRestriction(), 
					super.getPlantillaBusqueda().getCodigoBodega().getBooleanClauseEnum());
		}
		
		// Asignacion de criterion con descripcionBodega
		if(super.getPlantillaBusqueda().getDescripcionBodega() != null){
			dynamicParametersFiltersBodega.add(super.getPlantillaBusqueda().getDescripcionBodega().getCriteriaRestriction(),
					super.getPlantillaBusqueda().getDescripcionBodega().getBooleanClauseEnum());
		}
		
		if(dynamicParametersFiltersBodega.isNotEmptyCriteriaRestriction())
			subSelectBodega.add(dynamicParametersFiltersBodega.getCriteriaRestriction());

		return Subqueries.propertyIn("id.codigoProveedor", subSelectBodega);
	}
}
