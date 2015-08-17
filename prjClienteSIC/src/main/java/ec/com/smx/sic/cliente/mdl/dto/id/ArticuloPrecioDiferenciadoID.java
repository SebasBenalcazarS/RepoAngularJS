package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @see ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO
 * 
 * @author guvidia
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloPrecioDiferenciadoID implements Serializable {

	/**
	 * Codigo de la compan&iacute;a
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencia &uacute;nica del registro
	 * Precio de mayoreo
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCARTSECARTPREDIF")
	@Column(name = "SECUENCIAL", nullable = false)
	private Long secuencial;

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
	 * @return the secuencialArticuloPrecioDif
	 */
	public Long getSecuencial() {
		return secuencial;
	}

	/**
	 * @param secuencialArticuloPrecioDif the secuencialArticuloPrecioDif to set
	 */
	public void setSecuencial(Long secuencial) {
		this.secuencial = secuencial;
	}

}
