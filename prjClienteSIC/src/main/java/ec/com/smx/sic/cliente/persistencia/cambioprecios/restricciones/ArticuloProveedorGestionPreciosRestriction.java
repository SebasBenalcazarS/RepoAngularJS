package ec.com.smx.sic.cliente.persistencia.cambioprecios.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaProveedor;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.persistencia.beans.BasePlantillaCriteriaRestriction;

@SuppressWarnings("serial")
public class ArticuloProveedorGestionPreciosRestriction extends BasePlantillaCriteriaRestriction<PlantillaBusquedaProveedor> {

	public ArticuloProveedorGestionPreciosRestriction(PlantillaBusquedaProveedor plantillaBusqueda) {
		super(plantillaBusqueda);
	}

	@Override
	protected Criterion construirCriteriaRestriction() {
		
		DetachedCriteria subSelProveedor;
		DynamicCriteriaRestriction dynamicParametersFiltersProveedor = new DynamicCriteriaRestriction();
		
		subSelProveedor = DetachedCriteria.forClass(ProveedorDTO.class, "proveedor");
		subSelProveedor.setProjection(Projections.property("proveedor.id.codigoProveedor"));
		
		// Parametros por default
		subSelProveedor.add(Restrictions.eq("proveedor.id.codigoCompania", super.getPlantillaBusqueda().getCodigoCompania()));
		subSelProveedor.add(Restrictions.eq("proveedor.estadoProveedor", SICConstantes.ESTADO_ACTIVO_NUMERICO));

		if (super.getPlantillaBusqueda().getCodigoProveedor() != null){
			dynamicParametersFiltersProveedor.add(super.getPlantillaBusqueda().getCodigoProveedor().addExpression(), super.getPlantillaBusqueda().getCodigoProveedor().getBooleanClauseEnum());
		}

		if (super.getPlantillaBusqueda().getNumeroDocumento() != null){
			dynamicParametersFiltersProveedor.add(super.getPlantillaBusqueda().getNumeroDocumento().addExpression(), super.getPlantillaBusqueda().getNumeroDocumento().getBooleanClauseEnum());
		}

		if (super.getPlantillaBusqueda().getNombreProveedor() != null) {
			dynamicParametersFiltersProveedor.add(super.getPlantillaBusqueda().getNombreProveedor().getCriteriaRestriction(), super.getPlantillaBusqueda().getNombreProveedor().getBooleanClauseEnum());
		}

		if(dynamicParametersFiltersProveedor.isNotEmptyCriteriaRestriction())
			subSelProveedor.add(dynamicParametersFiltersProveedor.getCriteriaRestriction());

		return Subqueries.propertyIn("articuloProveedorCol.id.codigoProveedor", subSelProveedor);
	}
}
