package ec.com.smx.sic.cliente.common.articulo;

public enum EnumAlertaImportacionArticulo {
	REFERENCIA_PROVEEDOR_DIFERENTE(TipoCatalogoArticulo.VALOR_NOVEDAD_REFERENCIAPROVEEDOR,
			"Se detect\u00F3 un conflicto entre este art\u00EDculo y otro existente con respecto a la referencia del proveedor"),
	CODIGOBARRAS_DIFERENTE(TipoCatalogoArticulo.VALOR_NOVEDAD_CODIGOBARRAS,
			"Se detect\u00F3 un conflicto entre este art\u00EDculo y otro existente con respecto al c\u00F3digo de barras"),
	DIFERENCIAS_CODIGOBARRAS_REFERENCIAPROVEEDOR(TipoCatalogoArticulo.VALOR_NOVEDAD_CODIGOBARRAS_REFERENCIAPROVEEDOR,
					"Se detect\u00F3 un conflicto en este art\u00EDculo y otros ya existentes con respecto al c\u00F3digo de barras y la referencia del proveedor"),
	EXISTENTE_DIFERENCIAS_PROFORMA(TipoCatalogoArticulo.VALOR_NOVEDAD_EXISTENTE_DIFERENCIAS_PROFORMA,
			"Se detect\u00F3 un conflicto en este art\u00EDculo con respecto a su descripci\u00F3n real y la de la proforma");
	
	private String tipoAlerta;
	private String mensaje;
	
	private EnumAlertaImportacionArticulo(String tipoAlerta, String mensaje) {
		this.tipoAlerta = tipoAlerta;
		this.mensaje = mensaje;
	}
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @return the tipoAlerta
	 */
	public String getTipoAlerta() {
		return tipoAlerta;
	}
}
