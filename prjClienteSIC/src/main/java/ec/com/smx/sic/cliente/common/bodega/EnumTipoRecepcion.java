package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores de los catalogos que intervienen en los procesos de bodega
 * 
 * @author acaiza
 *
 */
public enum EnumTipoRecepcion {

	//VALORES TIPO DE CONFIGURACION RECEPCION
	NORMAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.recepcion.normal")),
	INDUSTRIA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.recepcion.industria")),
	IMPORTADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.recepcion.importado")),
	;
	
	/**
	 * The tipoRecepcion
	 */
	private String tipoConfiguracionRecepcion;
	
	private EnumTipoRecepcion(String tipoConfiguracionRecepcion) {
		this.tipoConfiguracionRecepcion = tipoConfiguracionRecepcion;
	}

	/**
	 * @return the tipoConfiguracionRecepcion
	 */
	public String getTipoConfiguracionRecepcion() {
		return tipoConfiguracionRecepcion;
	}

	/**
	 * @param tipoConfiguracionRecepcion the tipoConfiguracionRecepcion to set
	 */
	public void setTipoConfiguracionRecepcion(String tipoConfiguracionRecepcion) {
		this.tipoConfiguracionRecepcion = tipoConfiguracionRecepcion;
	}
	
}
