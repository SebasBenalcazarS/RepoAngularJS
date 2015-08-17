package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public enum EnumEan {

	EAN13(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.ean13.tipo"),
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.ean13.identificador.codigo"),
			SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.ean13.max.length")),
    EAN14(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.ean14.tipo"), 
    		SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.ean14.identificador.codigo"),
    		SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.ean14.max.length")), 
    EAN128(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.ean128.tipo"), 
    		SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.ean128.identificador.codigo"),
    		SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.ean128.max.length"));
	
	private int tipo;
	private String identificadorCodigo;
	private int maxLength;
	
	
	
	private EnumEan(int tipo, String identificadorCodigo, int maxLength) {
		this.tipo = tipo;
		this.identificadorCodigo = identificadorCodigo;
		this.maxLength = maxLength;
	}
	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}
	/**
	 * @return the identificadorCodigo
	 */
	public String getIdentificadorCodigo() {
		return identificadorCodigo;
	}
	/**
	 * @return the maxLength
	 */
	public int getMaxLength() {
		return maxLength;
	}

		
}
