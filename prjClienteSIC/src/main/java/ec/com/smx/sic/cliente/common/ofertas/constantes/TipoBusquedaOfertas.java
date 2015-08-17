package ec.com.smx.sic.cliente.common.ofertas.constantes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ec.com.smx.sic.cliente.common.SICConstantes;

public enum TipoBusquedaOfertas {

	BUSQUEDA_ARTICULO(SICConstantes.getInstancia().CODIGO_ROF_BUSQUEDA_ARTICULO, null);
	
	private final String value;
	private final String label;
	
	/**
	 * Constructor
	 * 
	 * @param value
	 * @param label
	 */
	private TipoBusquedaOfertas(String value, String label) {
		this.value = value;
		this.label = label;
	}

	/**
	 * Tipo de busquedas de ofertas
	 * 
	 * @return
	 */
	public static List<TipoBusquedaOfertas> getTipoBusquedaOfertas() {
		List<TipoBusquedaOfertas> tiposBusquedaOfertasReporte = new ArrayList<TipoBusquedaOfertas>();

		// Generar lista de tipos de busqueda de opciones tipo reporte
		for(TipoBusquedaOfertas tipoBusquedaOfertas :  Arrays.asList(TipoBusquedaOfertas.values()))
			tiposBusquedaOfertasReporte.add(tipoBusquedaOfertas);

		return tiposBusquedaOfertasReporte;
	}

	/*
	 * GETTERS AND SETTERS
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
	
}
