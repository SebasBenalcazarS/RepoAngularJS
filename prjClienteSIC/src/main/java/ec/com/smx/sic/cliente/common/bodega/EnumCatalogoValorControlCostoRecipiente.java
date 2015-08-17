package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.recipientes.SICRecipientesMessages;
public enum EnumCatalogoValorControlCostoRecipiente {
	//VALORES DE BODEGA
	VALOR_TIPO_ARTICULO(SICRecipientesMessages.getInstancia().getString ("ec.com.smx.sic.recipientes.catalogo.tipoArticulo")),
	VALOR_TIPO_ARTICULO_TARA(SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.catalogo.tipoArticuloTara"));
	
	
	private String codigoCatalogoValor;
	
	private EnumCatalogoValorControlCostoRecipiente(String codigoCatalogoValor){
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
