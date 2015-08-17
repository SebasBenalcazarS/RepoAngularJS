package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.Logeable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Caracteristica
 * 
 * @see ec.com.smx.sic.adm.dto.Caracteristica
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Embeddable
public class CaracteristicaID implements Serializable, Cloneable {

	/**
	 * Codigo de la compa��a
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencial generado para identificar la caracteristica
	 */
	@Column(name = "SECUENCIALCARACTERISTICA", nullable = false)
	private java.lang.Long secuencialCaracteristica;

	/**
	 * C�digo del art�culo
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

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
	 * Retorna valor de propiedad <code>secuencialCaracteristica</code>
	 * 
	 * @return Retorna valor de propiedad <code>secuencialCaracteristica</code>
	 */
	public java.lang.Long getSecuencialCaracteristica() {
		return this.secuencialCaracteristica;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>secuencialCaracteristica</code>.
	 * 
	 * @param secuencialCaracteristica1
	 *            El valor a establecer para la propiedad <code>secuencialCaracteristica</code>.
	 */
	public void setSecuencialCaracteristica(java.lang.Long secuencialCaracteristica1) {
		this.secuencialCaracteristica = secuencialCaracteristica1;

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
	 * Clase cloneable
	 */
	public CaracteristicaID clone() {
		CaracteristicaID clon = null;
		try {
			clon = (CaracteristicaID) super.clone();
		} catch (CloneNotSupportedException ex) {
			Logeable.LOG_SICV2.error(ex.getMessage());
		}
		return clon;
	}

}
