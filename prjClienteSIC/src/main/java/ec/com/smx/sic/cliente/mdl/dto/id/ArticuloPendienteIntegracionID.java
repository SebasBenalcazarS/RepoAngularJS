package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author fmunoz
 */
@Embeddable
@SuppressWarnings("serial")
public class ArticuloPendienteIntegracionID implements Serializable {
	/**
	 * Codigo de la compan&iacute;a
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	/**
	 * Secuencial &uacute;nico
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = ArticuloPendienteIntegracionID.NOMBRE_SECUENCIA)
	@Column(name = "SECUENCIAL", nullable = false)
	private Long secuencial;
	
	public static final String NOMBRE_SECUENCIA = "SCSADSARTPENINT";
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getSecuencial() {
		return secuencial;
	}
	public void setSecuencial(Long secuencial) {
		this.secuencial = secuencial;
	}
}
