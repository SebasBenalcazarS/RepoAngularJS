/**
 * 
 */
package ec.com.smx.sic.cliente.common.cambioprecios.constantes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;

import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * @author gnolivos
 *
 */
public enum TipoBusquedaCambioPrecios {

	ARTICULO_PRECIOS(SICConstantes.getInstancia().CODIGO_RCP_ARTICULO_PRECIOS, null, Boolean.FALSE),
	BUSQUEDA_ARTICULO_PRECIOS(SICConstantes.getInstancia().CODIGO_RCP_BUSQUEDA_ARTICULO_PRECIOS, null, Boolean.FALSE),
	BUSQUEDA_ARTICULO_PLANTILLAS(null, null, Boolean.FALSE),
	BUSQUEDA_ARTICULO_PROVEEDORES(null, null, Boolean.FALSE),
	DATOS_GENERALES_CAMBIO_PRECIO(SICConstantes.getInstancia().CODIGO_RCP_DATOS_GENERALES_CAMBIO_PRECIO, SICConstantes.getInstancia().LABEL_RCP_DATOS_GENERALES_CAMBIO_PRECIO, Boolean.TRUE),
	HISTORIAL_CAMBIO_PRECIO(SICConstantes.getInstancia().CODIGO_RCP_HISTORIAL_CAMBIO_PRECIO, SICConstantes.getInstancia().LABEL_RCP_HISTORIAL_CAMBIO_PRECIO, Boolean.TRUE);
	
	private final String value;
	private final String label;
	private final Boolean generaReporte;
	
	/**
	 * Contructor
	 * 
	 * @param value
	 * @param label
	 * @param generaReporte
	 */
	private TipoBusquedaCambioPrecios(String value, String label, Boolean generaReporte){
		this.value = value;
		this.label = label;
		this.generaReporte = generaReporte;
	}

	/**
	 * Tipo de busquedas de cambios de precios
	 * 
	 * @return
	 */
	public static List<TipoBusquedaCambioPrecios> getTipoBusquedasCambioPrecio() {
		List<TipoBusquedaCambioPrecios> tiposBusquedaCambioPrecioReporte = new ArrayList<TipoBusquedaCambioPrecios>();

		// Generar lista de tipos de busqueda de opciones tipo reporte
		for(TipoBusquedaCambioPrecios tipoBusquedaCambioPrecios :  Arrays.asList(TipoBusquedaCambioPrecios.values())) {
			if (BooleanUtils.isTrue(tipoBusquedaCambioPrecios.getGeneraReporte()))
				tiposBusquedaCambioPrecioReporte.add(tipoBusquedaCambioPrecios);
		}

		return tiposBusquedaCambioPrecioReporte;
	}
	
	
	/*
	 * GETTERS
	 */
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
