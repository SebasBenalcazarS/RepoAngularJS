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
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaMarca;
import ec.com.smx.sic.cliente.common.search.constant.SearchManagerConstants;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorMarcaDTO;
import ec.com.smx.sic.cliente.persistencia.beans.BasePlantillaCriteriaRestriction;

/**
 * @author Mario Braganza
 * 
 * @author Luis Yacchirema
 * 
 * @author Gabriel Nolivos
 */
@SuppressWarnings("serial")
public class ProveedorMarcaPlantillaRestriction extends BasePlantillaCriteriaRestriction<PlantillaBusquedaMarca> {

	public ProveedorMarcaPlantillaRestriction(PlantillaBusquedaMarca plantillaBusqueda) {
		super(plantillaBusqueda);
	}

	@Override
	protected Criterion construirCriteriaRestriction() {

		DetachedCriteria subSelectProveedorMarca;
		DynamicCriteriaRestriction dynamicParametersFiltersMarca = new DynamicCriteriaRestriction();

		try {
			subSelectProveedorMarca = DetachedCriteria.forClass(ProveedorMarcaDTO.class, SearchManagerConstants.getInstance().ALIAS_PROVEEDOR_MARCA);
			subSelectProveedorMarca.setProjection(Projections.property(SearchManagerConstants.getInstance().ALIAS_PROVEEDOR_MARCA + ".id.codigoProveedor"));

			// Parametros por default
			subSelectProveedorMarca.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_PROVEEDOR_MARCA + ".id.codigoCompania", super.getPlantillaBusqueda().getCodigoCompania()));
			subSelectProveedorMarca.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_PROVEEDOR_MARCA + ".estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));

			// Filtros de Proveedor Marca
			if (super.getPlantillaBusqueda().getCodigoMarca() != null){
				dynamicParametersFiltersMarca.add(super.getPlantillaBusqueda().getCodigoMarca().addExpression(), super.getPlantillaBusqueda().getCodigoMarca().getBooleanClauseEnum());
			}

			// Filtros de Marca
			if (super.getPlantillaBusqueda().getNombreMarca() != null
					|| super.getPlantillaBusqueda().getValorTipoMarca() != null) {
				subSelectProveedorMarca.createAlias(SearchManagerConstants.getInstance().ALIAS_PROVEEDOR_MARCA + ".marcaArticuloDTO", SearchManagerConstants.getInstance().ALIAS_MARCA_ARTICULO);			
			}

			if (super.getPlantillaBusqueda().getNombreMarca() != null){
				
				dynamicParametersFiltersMarca.add(super.getPlantillaBusqueda().getNombreMarca().addExpression(), super.getPlantillaBusqueda().getNombreMarca().getBooleanClauseEnum());
			}

			if (super.getPlantillaBusqueda().getValorTipoMarca() != null) {
				dynamicParametersFiltersMarca.add(super.getPlantillaBusqueda().getValorTipoMarca().getCriteriaRestriction(), super.getPlantillaBusqueda().getValorTipoMarca().getBooleanClauseEnum());
			}
			
			if(dynamicParametersFiltersMarca.isNotEmptyCriteriaRestriction())
				subSelectProveedorMarca.add(dynamicParametersFiltersMarca.getCriteriaRestriction());

			return Subqueries.propertyIn("id.codigoProveedor", subSelectProveedorMarca);

		} catch (Exception e) {
			return null;
		}
	}

}