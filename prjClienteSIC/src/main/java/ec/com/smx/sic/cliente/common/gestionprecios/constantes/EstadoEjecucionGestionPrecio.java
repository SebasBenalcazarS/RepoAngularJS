package ec.com.smx.sic.cliente.common.gestionprecios.constantes;

import ec.com.smx.sic.cliente.resources.cambioprecios.SICCambioPreciosMessages;



/**
 * 
 * @author Luis Yacchirema
 *
 */
public enum EstadoEjecucionGestionPrecio {

	NO_APLICA(GestionPrecioConstantes.getInstancia().VALOR_ESTADO_GESTION_PRECIO_NO_APLICA, null),
	PENDIENTE(GestionPrecioConstantes.getInstancia().VALOR_ESTADO_EJECUCION_GESTION_PRECIO_PENDIENTE, SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.etiqueta.estado.ejecucion.pendiente")),	
	PROCESADO(GestionPrecioConstantes.getInstancia().VALOR_ESTADO_EJECUCION_GESTION_PRECIO_PROCESADO, SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.etiqueta.estado.ejecucion.procesado")),
	FINALIZADO(GestionPrecioConstantes.getInstancia().VALOR_ESTADO_EJECUCION_GESTION_PRECIO_FINALIZADO, SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.etiqueta.estado.ejecucion.finalizado"));

	private String valorEstadoEjecucionGestionPrecio;
	private String labelEstadoEjecucionGestionPrecio;
	public final static Integer CODIGO_ESTADO_EJECUCION_GESTION_PRECIO = TipoCatalogosGestionPrecios.ESTADO_EJECUCION_GESTION_PRECIO;

	private EstadoEjecucionGestionPrecio(String valorEstadoEjecucionGestionPrecio, String labelEstadoEjecucionGestionPrecio) {
		this.valorEstadoEjecucionGestionPrecio = valorEstadoEjecucionGestionPrecio;
		this.labelEstadoEjecucionGestionPrecio = labelEstadoEjecucionGestionPrecio;
	}

	/**
	 * @return the valorEstadoEjecucionGestionPrecio
	 */
	public String getValorEstadoEjecucionGestionPrecio() {
		return valorEstadoEjecucionGestionPrecio;
	}

	/**
	 * @return the labelEstadoEjecucionGestionPrecio
	 */
	public String getLabelEstadoEjecucionGestionPrecio() {
		return labelEstadoEjecucionGestionPrecio;
	}

}
