/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo.constantes;

import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;

/**
 * @author Luis Yacchirema
 *
 */
public enum EnumTipoAsignacionDescuento {

	PROVEEDOR("PRO"),
	ARTICULO("ART");

	private String valorTipoAsignacionDescuento;

	public static final Integer CODIGO_TIPO_ASIGNACION_DESCUENTO = TipoCatalogoArticulo.TIPO_ASIGNACION_DESCUENTO;

	private EnumTipoAsignacionDescuento(String valorTipoAsignacionDescuento) {
		this.valorTipoAsignacionDescuento = valorTipoAsignacionDescuento;
	}


	/**
	 * @return the valorTipoAsignacionDescuento
	 */
	public String getValorTipoAsignacionDescuento() {
		return valorTipoAsignacionDescuento;
	}

}
