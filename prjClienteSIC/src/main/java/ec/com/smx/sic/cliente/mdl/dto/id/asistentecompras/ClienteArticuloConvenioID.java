package ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author jcedeno
 *
 */
@SuppressWarnings("Serial")
@Embeddable
public class ClienteArticuloConvenioID implements Serializable{
	@Column(name = "SECUENCIALCLIARTCON")
	@SequenceDataBaseValue(name = "SCSACSECCLIARTCON", descriptorClass = DescriptorSecuenciasSIC.class)
	private Long secuencialClienteArticuloConvenio;

	public Long getSecuencialClienteArticuloConvenio() {
		return secuencialClienteArticuloConvenio;
	}

	public void setSecuencialClienteArticuloConvenio(long secuencialClienteArticuloConvenio) {
		this.secuencialClienteArticuloConvenio = secuencialClienteArticuloConvenio;
	}
	
}
