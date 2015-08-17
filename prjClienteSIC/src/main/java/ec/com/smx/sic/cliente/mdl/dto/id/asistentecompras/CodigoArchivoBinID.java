package ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras;

import java.io.Serializable;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@SuppressWarnings("serial")
public class CodigoArchivoBinID implements Serializable {
	
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCSACSECBINTARDEFARC")
	@Column(name = "CODIGOARCHIVO")
	private Long codigoArchivo;

	public Long getCodigoArchivo() {
		return codigoArchivo;
	}

	public void setCodigoArchivo(Long codigoArchivo) {
		this.codigoArchivo = codigoArchivo;
	}

}
