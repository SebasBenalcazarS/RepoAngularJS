package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author guvidia
 */
@SuppressWarnings("serial")
@Embeddable
public class BitacoraArticuloLocalPrecioID implements Serializable {

	/**
	 * Codigo de la compan&iacute;a
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencia &uacute;nica del registro
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = NOMBRE_SECUENCIA)
	@Column(name = "SECBITARTLOCPRE", nullable = false)
	private Long secuencialBitacora;
	
	public static final String NOMBRE_SECUENCIA = "SCARTSECBITARTLOCPRE";

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

	public Long getSecuencialBitacora() {
		return secuencialBitacora;
	}

	public void setSecuencialBitacora(Long secuencialBitacora) {
		this.secuencialBitacora = secuencialBitacora;
	}




}
