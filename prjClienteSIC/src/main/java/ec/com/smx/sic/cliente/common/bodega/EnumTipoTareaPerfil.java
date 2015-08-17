package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores de los catalogos que intervienen en los procesos de bodega
 * 
 * @author acaiza
 *
 */
public enum EnumTipoTareaPerfil {

	//VALORES DE TIPOS DE TAREA DEL RECIBIDOR
	TIPO_TAREAS_RECIBIDOR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.catalogo.valorTipoTareaPerfil.recibidor")),
	TIPO_TAREAS_RECOLECTOR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.catalogo.valorTipoTareaPerfil.recolector")),
	;
	
	private String codigoCatalogoValor;
	
	private EnumTipoTareaPerfil(String codigoCatalogoValor){
		this.codigoCatalogoValor = codigoCatalogoValor;
	}

	/**
	 * @return the codigoCatalogoValor
	 */
	public String getCodigoCatalogoValor() {
		return codigoCatalogoValor;
	}

	/**
	 * @param codigoCatalogoValor the codigoCatalogoValor to set
	 */
	public void setCodigoCatalogoValor(String codigoCatalogoValor) {
		this.codigoCatalogoValor = codigoCatalogoValor;
	}
}
