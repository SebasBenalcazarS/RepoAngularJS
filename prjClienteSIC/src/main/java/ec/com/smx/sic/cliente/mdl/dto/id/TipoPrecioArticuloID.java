package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase TipoPrecioArticulo
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.TipoPrecioArticulo
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class TipoPrecioArticuloID implements Serializable {

	/**
	 * Código de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Código del tipo de impuesto. Los valores pueden ser: Por ejemplo: [PVP] Precio de venta al público [BAS] Precio base [CAJ] Precio de caja [MAY]
	 * Precio de mayoreo
	 * 
	 */
	@Column(name = "CODIGOTIPOPRECIO", nullable = false)
	private String codigoTipoPrecio;

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * 
	 * @param codigoCompania1
	 *            El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}

	/**
	 * Retorna valor de propiedad <code>codigoTipoPrecio</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoTipoPrecio</code>
	 */
	public String getCodigoTipoPrecio() {
		return this.codigoTipoPrecio;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoPrecio</code>.
	 * 
	 * @param codigoTipoPrecio1
	 *            El valor a establecer para la propiedad <code>codigoTipoPrecio</code>.
	 */
	public void setCodigoTipoPrecio(String codigoTipoPrecio1) {
		this.codigoTipoPrecio = codigoTipoPrecio1;

		if (codigoTipoPrecio != null && codigoTipoPrecio.length() > 3) {
			codigoTipoPrecio = codigoTipoPrecio.substring(0, 3);
		}
	}
}
