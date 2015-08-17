package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores de los catalogos que intervienen en el proceso logistico
 * 
 * @author acaiza
 *
 */
public enum EnumTipoProcesoLogistico {
	
	//VALORES DE TIPOS DE PROCESO PARA LA BODEGA
	VALOR_TIPO_PROCESO_RECEPCION( SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.catalogo.valorTipoProceso.recepcion")),
	VALOR_TIPO_PROCESO_DESPACHO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.catalogo.valorTipoProceso.despacho"));
	
	private String codigoCatalogoValor;
	
	private EnumTipoProcesoLogistico(String codigoCatalogoValor){
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
