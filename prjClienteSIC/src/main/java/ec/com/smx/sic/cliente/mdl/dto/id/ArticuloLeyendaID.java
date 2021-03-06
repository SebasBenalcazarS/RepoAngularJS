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
@SuppressWarnings("serial")
@Embeddable
public class ArticuloLeyendaID implements Serializable {

	/**
	 * C�digo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencial &uacute;nico
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCARTSARTLEY")
	@Column(name = "SECUENCIAL", nullable = false)
	private Long secuencial;

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
