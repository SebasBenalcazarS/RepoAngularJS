package ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras;

import java.io.Serializable;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@SuppressWarnings("serial")
public class ContenidoID implements Serializable {
	
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCSACSECCONTENIDO")
	@Column(name = "SECUENCIALCONTENIDO")
	private Long secuencialContenido;

	public Long getSecuencialContenido() {
		return secuencialContenido;
	}

	public void setSecuencialContenido(Long secuencialContenido) {
		this.secuencialContenido = secuencialContenido;
	}

}
