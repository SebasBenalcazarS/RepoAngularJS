package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase DescuentoVentaArticulo
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.DescuentoVentaArticulo
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class DescuentoVentaArticuloID implements Serializable{

	/**
	 * C�digo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * C�digo de art�culo, almacena el c�digo secuencial de un art�culo
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	@Column(name = "SECUENCIALASITIPDES", nullable = false)
	private Integer secuencialAsignacionTipoDescuento;

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
	 * @return the secuencialAsignacionTipoDescuento
	 */
	public Integer getSecuencialAsignacionTipoDescuento() {
		return secuencialAsignacionTipoDescuento;
	}

	/**
	 * @param secuencialAsignacionTipoDescuento the secuencialAsignacionTipoDescuento to set
	 */
	public void setSecuencialAsignacionTipoDescuento(Integer secuencialAsignacionTipoDescuento) {
		this.secuencialAsignacionTipoDescuento = secuencialAsignacionTipoDescuento;
	}
}
