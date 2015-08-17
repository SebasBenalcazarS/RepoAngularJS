package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.common.SICSecuencias;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;
@SuppressWarnings("serial")
@Embeddable
public class ValidacionDocumentoID implements Serializable{
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name= "CODIGOVALIDACIONDOCUMENTO", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = SICSecuencias.SEC_VALIDACION_DOCUMENTO)
	private Long codigoValidacionDocumento;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoValidacionDocumento() {
		return codigoValidacionDocumento;
	}

	public void setCodigoValidacionDocumento(Long codigoValidacionDocumento) {
		this.codigoValidacionDocumento = codigoValidacionDocumento;
	}
}
