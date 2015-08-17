/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author fmunoz
 * 
 */
@SuppressWarnings("serial")
@Embeddable
public class MarcaArticuloID implements Serializable {

	/**
	 * Codigo de la compa��a
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * C�digo de la marca
	 */
//	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSMARART")
	@Column(name = "SECUENCIALMARCA", nullable = false)
	private java.lang.Long secuencialMarca;

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
	 * @return the secuencialMarca
	 */
	public java.lang.Long getSecuencialMarca() {
		return secuencialMarca;
	}

	/**
	 * @param secuencialMarca the secuencialMarca to set
	 */
	public void setSecuencialMarca(java.lang.Long secuencialMarca) {
		this.secuencialMarca = secuencialMarca;
	}

}
