package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloPrecio
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecio
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloLocalPrecioID implements Serializable {

	/**
	 * Codigo de la companía
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	/**
	 * Código del local donde se aplica el precio
	 */
	@Column(name = "CODIGOLOCAL", nullable = false)
	private Integer codigoLocal;
	/**
	 * Código de artículo, almacena el código secuencial de un artículo
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;
	/**
	 * Código del tipo de precio. Los valores pueden ser: Por ejemplo: [PVP] Precio de venta al público [BAS] Precio base [CAJ] Precio de caja [MAY]
	 * Precio de mayoreo
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
	 * Retorna valor de propiedad <code>codigoArticulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoArticulo</code>
	 */
	public String getCodigoArticulo() {
		return this.codigoArticulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoArticulo</code>.
	 * 
	 * @param codigoArticulo1
	 *            El valor a establecer para la propiedad <code>codigoArticulo</code>.
	 */
	public void setCodigoArticulo(String codigoArticulo1) {
		this.codigoArticulo = codigoArticulo1;

		if (codigoArticulo != null && codigoArticulo.length() > 20) {
			codigoArticulo = codigoArticulo.substring(0, 20);
		}
	}

	/**
	 * @return the codigoLocal
	 */
	public Integer getCodigoLocal() {
		return codigoLocal;
	}

	/**
	 * @param codigoLocal the codigoLocal to set
	 */
	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	/**
	 * @return the codigoTipoPrecio
	 */
	public String getCodigoTipoPrecio() {
		return codigoTipoPrecio;
	}

	/**
	 * @param codigoTipoPrecio the codigoTipoPrecio to set
	 */
	public void setCodigoTipoPrecio(String codigoTipoPrecio) {
		this.codigoTipoPrecio = codigoTipoPrecio;
	}

}
