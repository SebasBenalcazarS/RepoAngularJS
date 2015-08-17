/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo.constantes;

import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;

/**
 * @author Luis Yacchirema
 *
 */
public enum EnumTipoAplicacionDescuento {

	COSTO_COMPRA("COM"),
	COSTO_CONVENIO("CNV"),
	VENTA("VEN"),
	PROMOCION_COSTO("PCO");

	private String valorTipoAplicacionDescuento;

	public static final Integer CODIGO_TIPO_APLICACION_DESCUENTO = TipoCatalogoArticulo.TIPO_APLICACION_DESCUENTO;

	private EnumTipoAplicacionDescuento(String valorTipoAplicacionDescuento) {
		this.valorTipoAplicacionDescuento = valorTipoAplicacionDescuento;
	}


	/**
	 * @return the valorTipoAplicacionDescuento
	 */
	public String getValorTipoAplicacionDescuento() {
		return valorTipoAplicacionDescuento;
	}

}
