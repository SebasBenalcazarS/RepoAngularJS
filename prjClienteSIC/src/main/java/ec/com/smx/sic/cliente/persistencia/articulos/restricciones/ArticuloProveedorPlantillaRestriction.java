package ec.com.smx.sic.cliente.persistencia.articulos.restricciones;

import org.apache.commons.collections.MapUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaFiltrosBusquedaArticulos;
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaProveedor;
import ec.com.smx.sic.cliente.common.search.constant.SearchManagerConstants;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;

/**
 * 
 * @author fcollaguazo
 *
 */
@SuppressWarnings("serial")
public class ArticuloProveedorPlantillaRestriction implements CriteriaRestriction {

	private PlantillaBusquedaProveedor plantillaBusquedaProveedor;
	private IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaArticulos;
	
	public ArticuloProveedorPlantillaRestriction(PlantillaBusquedaProveedor plantillaBusquedaProveedor, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaArticulos, Integer codigoCompania){
		this.plantillaBusquedaProveedor = plantillaBusquedaProveedor == null ? new PlantillaBusquedaProveedor(codigoCompania) : plantillaBusquedaProveedor;
		this.plantillaFiltrosBusquedaArticulos = plantillaFiltrosBusquedaArticulos;
	}

	@Override
	public Criterion  getCriteriaRestriction(){
		DetachedCriteria subSelectArticuloProveedor;
		
		DynamicCriteriaRestriction dynamicParametersFiltersProveedor = new DynamicCriteriaRestriction();
		
		subSelectArticuloProveedor = DetachedCriteria.forClass(ArticuloProveedorDTO.class, SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR);
		subSelectArticuloProveedor.setProjection(Projections.property(SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR + ".id.codigoArticulo"));
		
		// Parametros por default
		subSelectArticuloProveedor.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR + ".id.codigoCompania", plantillaBusquedaProveedor.getCodigoCompania()));
		
		// Filtros de vista de proveedores
		subSelectArticuloProveedor.createAlias(SearchManagerConstants.getInstance().ALIAS_ARTICULO_PROVEEDOR + ".vistaProveedor", SearchManagerConstants.getInstance().ALIAS_VISTA_PROVEEDOR);
		
		//Filtro codigo proveedor
		if (this.plantillaBusquedaProveedor.getCodigoProveedor() != null){
			dynamicParametersFiltersProveedor.add(this.plantillaBusquedaProveedor.getCodigoProveedor().addExpression(), this.plantillaBusquedaProveedor.getCodigoProveedor().getBooleanClauseEnum());
		}
		
		//Filtro ruc/numero documento fiscal
		if (plantillaBusquedaProveedor.getNumeroDocumento() != null){
			dynamicParametersFiltersProveedor.add(plantillaBusquedaProveedor.getNumeroDocumento().addExpression(), plantillaBusquedaProveedor.getNumeroDocumento().getBooleanClauseEnum());
		}
		
		//Filtro nombre proveedor
		if (plantillaBusquedaProveedor.getNombreProveedor() != null){
			dynamicParametersFiltersProveedor.add(plantillaBusquedaProveedor.getNombreProveedor().getCriteriaRestriction(), plantillaBusquedaProveedor.getNombreProveedor().getBooleanClauseEnum());
		}
		
		//Filtro origen proveedor
		if (plantillaBusquedaProveedor.getOrigenProveedor() != null){
			dynamicParametersFiltersProveedor.add(plantillaBusquedaProveedor.getOrigenProveedor().getCriteriaRestriction(), plantillaBusquedaProveedor.getOrigenProveedor().getBooleanClauseEnum());
		}
		
		//Filtro indicador I
		if (plantillaBusquedaProveedor.getInterproveedor() != null){
			dynamicParametersFiltersProveedor.add(plantillaBusquedaProveedor.getInterproveedor().getCriteriaRestriction(), plantillaBusquedaProveedor.getInterproveedor().getBooleanClauseEnum());
		}
		
		//Filtro estado articulo proveedor
		if (plantillaBusquedaProveedor.getEstadoArticuloProveedor() != null){
			dynamicParametersFiltersProveedor.add(plantillaBusquedaProveedor.getEstadoArticuloProveedor().addExpression(), plantillaBusquedaProveedor.getEstadoArticuloProveedor().getBooleanClauseEnum());
		}
		
		//Filtro estado proveedor
		if (plantillaBusquedaProveedor.getEstadoProveedor() != null){
			dynamicParametersFiltersProveedor.add(plantillaBusquedaProveedor.getEstadoProveedor().addExpression(), plantillaBusquedaProveedor.getEstadoProveedor().getBooleanClauseEnum());
		}
		
		//Filtros de proveedor que estan en articulos 
		if(plantillaFiltrosBusquedaArticulos!=null
				&& plantillaFiltrosBusquedaArticulos.getMapaCriteriaSearch() != null
				&& MapUtils.isNotEmpty(plantillaFiltrosBusquedaArticulos.getMapaCriteriaSearch())){
			
			//REFERENCIA INTERNA
			if (MapUtils.isNotEmpty(plantillaFiltrosBusquedaArticulos.getMapaCriteriaSearch()) && plantillaFiltrosBusquedaArticulos.getMapaCriteriaSearch().get("codigoReferenciaIntProv") != null) {
				dynamicParametersFiltersProveedor.add(plantillaFiltrosBusquedaArticulos.getMapaCriteriaSearch().get("codigoReferenciaIntProv"));
			}
			//REFERENCIA PROVEEDOR
			if (MapUtils.isNotEmpty(plantillaFiltrosBusquedaArticulos.getMapaCriteriaSearch()) && plantillaFiltrosBusquedaArticulos.getMapaCriteriaSearch().get("codigoReferenciaExtProv") != null) {
				dynamicParametersFiltersProveedor.add(plantillaFiltrosBusquedaArticulos.getMapaCriteriaSearch().get("codigoReferenciaExtProv"));
			}		
		}
		
		if(dynamicParametersFiltersProveedor.isNotEmptyCriteriaRestriction())
			subSelectArticuloProveedor.add(dynamicParametersFiltersProveedor.getCriteriaRestriction());
		
		return Subqueries.propertyIn("id.codigoArticulo", subSelectArticuloProveedor);
	}
}
