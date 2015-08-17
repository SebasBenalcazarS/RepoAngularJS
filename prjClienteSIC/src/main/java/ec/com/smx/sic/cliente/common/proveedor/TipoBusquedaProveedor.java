package ec.com.smx.sic.cliente.common.proveedor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;

import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * @author gnolivos
 *
 */

public enum TipoBusquedaProveedor {

	DATOS_GENERALES(SICConstantes.getInstancia().CODIGO_RPT_DATOS_GENERALES_PROVEEDOR, SICConstantes.getInstancia().LABEL_RPT_DATOS_GENERALES_PROVEEDOR,Boolean.TRUE),
	CONDICIONES_COMERCIALES(SICConstantes.getInstancia().CODIGO_RPT_CONDICIONES_COMERCIALES_PROVEEDOR, SICConstantes.getInstancia().LABEL_RPT_CONDICIONES_COMERCIALES_PROVEEDOR,Boolean.TRUE),
	DATOS_PRINCIPALES(SICConstantes.getInstancia().CODIGO_RPT_DATOS_PRINCIPALES_PROVEEDOR, SICConstantes.getInstancia().LABEL_RPT_DATOS_PRINCIPALES_PROVEEDOR,Boolean.FALSE);

	private final String value;
	private final String label;
	private final Boolean generaReporte;

	private TipoBusquedaProveedor(String value, String label, Boolean generaReporte) {
		this.value = value;
		this.label = label;
		this.generaReporte = generaReporte;
	}

	public static List<TipoBusquedaProveedor> getTipoBusquedasProveedor() {

		List<TipoBusquedaProveedor> tiposBusquedaProveedorReporte = new ArrayList<TipoBusquedaProveedor>();

		// Generar lista de tipos de busqueda de opciones tipo reporte
		for (TipoBusquedaProveedor tipoBusquedaProveedor :  Arrays.asList(TipoBusquedaProveedor.values())) {
			if (BooleanUtils.isTrue(tipoBusquedaProveedor.getGeneraReporte()))
				tiposBusquedaProveedorReporte.add(tipoBusquedaProveedor);
		}

		return tiposBusquedaProveedorReporte;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return the generaReporte
	 */
	public Boolean getGeneraReporte() {
		return generaReporte;
	}

}
