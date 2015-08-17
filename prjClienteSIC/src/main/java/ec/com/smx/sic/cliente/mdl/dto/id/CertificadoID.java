package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author Marcelo Hidalgo
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class CertificadoID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "SECUENCIALCERTIFICADO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCPROSECCERTIFICADO")
	private String secuencialCertificado;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getSecuencialCertificado() {
		return secuencialCertificado;
	}

	public void setSecuencialCertificado(String secuencialCertificado) {
		this.secuencialCertificado = secuencialCertificado;
	}

}
