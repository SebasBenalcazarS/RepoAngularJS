package ec.com.smx.sic.cliente.common.articulo;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author mgranda
 *
 */
public enum EnumTipoPrecio {

	NINGUNO(null),
	PRECIO_BASE(SICArticuloConstantes.TIPO_PRECIO_BASE),
	PRECIO_PVP(SICArticuloConstantes.TIPO_PRECIO_PVP),
	PRECIO_CAJA(SICArticuloConstantes.TIPO_PRECIO_CAJA),
	PRECIO_MAYORISTA(SICArticuloConstantes.TIPO_PRECIO_MAYORISTA),
	PRECIO_BASE_DESCUENTO_DIARIO(SICArticuloConstantes.TIPO_PRECIO_BASE_DESCUENTO_DIARIO),
	PRECIO_BASE_COBRO_RECUPERACION_DESCUENTO_DIARIO(SICArticuloConstantes.TIPO_PRECIO_BASE_COBRO_RECUPERACION_DESCUENTO_DIARIO),
	PRECIO_BASE_DESCUENTO_ACUMULADO(SICArticuloConstantes.TIPO_PRECIO_BASE_DESCUENTO_ACUMULADO),
	PRECIO_BASE_COBRO_RECUPERACION_DESCUENTO_ACUMULADO(SICArticuloConstantes.TIPO_PRECIO_BASE_COBRO_RECUPERACION_DESCUENTO_ACUMULADO);	

	private String codigoTipoPrecio;

	private EnumTipoPrecio(String codigoTipoPrecio) {
		this.codigoTipoPrecio = codigoTipoPrecio;
	}

	/**
	 * @author mgranda
	 * @param codigoTipoPrecio
	 * @return
	 */
	public static EnumTipoPrecio getEnumPorTipoPrecio(String codigoTipoPrecio) {
		if (codigoTipoPrecio != null) {
			for (EnumTipoPrecio tipoPrecio : EnumTipoPrecio.values()) {
				if (StringUtils.equals(tipoPrecio.getCodigoTipoPrecio(), codigoTipoPrecio)) {
					return tipoPrecio;
				}
			}
		}
		return null;
	}

	public String getCodigoTipoPrecio() {
		return codigoTipoPrecio;
	}

	public void setCodigoTipoPrecio(String codigoTipoPrecio) {
		this.codigoTipoPrecio = codigoTipoPrecio;
	}

}
