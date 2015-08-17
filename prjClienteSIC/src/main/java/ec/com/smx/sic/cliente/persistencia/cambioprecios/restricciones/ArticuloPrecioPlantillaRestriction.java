/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.cambioprecios.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.constants.BooleanClauseEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaArticuloPrecios;
import ec.com.smx.sic.cliente.persistencia.beans.BasePlantillaCriteriaRestriction;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones.ClasificacionesPorClasificacionFuncionarioCompradorRestriction;

/**
 * @author Luis Yacchirema
 *
 */
@SuppressWarnings("serial")
public class ArticuloPrecioPlantillaRestriction extends BasePlantillaCriteriaRestriction<PlantillaBusquedaArticuloPrecios> implements CriteriaRestriction {

	public ArticuloPrecioPlantillaRestriction(PlantillaBusquedaArticuloPrecios plantillaBusqueda) {
		super(plantillaBusqueda);
	}

	@Override
	protected Criterion construirCriteriaRestriction() {

		DynamicCriteriaRestriction restricionesArticulosPrecios = new DynamicCriteriaRestriction();

		// Codigo proveedor
		if (super.getPlantillaBusqueda().getCodigoProveedor() != null) {
			restricionesArticulosPrecios.add(super.getPlantillaBusqueda().getCodigoProveedor().getCriteriaSearchParameter());
		}
		
		// Fecha creacion articulos
		if (super.getPlantillaBusqueda().getFechaCreacionArticulos() != null) {
			restricionesArticulosPrecios.add(Restrictions.eq("fechaCreacion", super.getPlantillaBusqueda().getFechaCreacionArticulos()), BooleanClauseEnum.AND);
		}

		// Codigo clase articulo
		if (super.getPlantillaBusqueda().getCodigoClaseArticulo() != null) {
			restricionesArticulosPrecios.add(super.getPlantillaBusqueda().getCodigoClaseArticulo());
		}

		// Codigo estructura comercial (clasificacion)
		if (super.getPlantillaBusqueda().getCodigosEstructuraComercial() != null) {
			restricionesArticulosPrecios.add(super.getPlantillaBusqueda().getCodigosEstructuraComercial().getCriteriaRestriction(), super.getPlantillaBusqueda().getCodigosEstructuraComercial().getBooleanClauseEnum());
		}
		else {
			// Codigo estructura logistica (sub-bodega)
			if (super.getPlantillaBusqueda().getCodigoEstructuraLogistica() != null) {
					
				restricionesArticulosPrecios.add(new ClasificacionesPorClasificacionFuncionarioCompradorRestriction(super.getPlantillaBusqueda().getCodigoFuncionario(),
						super.getPlantillaBusqueda().getCodigoEstructuraLogistica().getParameterValue(), null, null, null, "codigoClasificacion").getCriteriaRestriction(),
						super.getPlantillaBusqueda().getCodigoProveedor().getBooleanClauseEnum());
			}
		}
		
		return restricionesArticulosPrecios.getCriteriaRestriction();

	}

}
