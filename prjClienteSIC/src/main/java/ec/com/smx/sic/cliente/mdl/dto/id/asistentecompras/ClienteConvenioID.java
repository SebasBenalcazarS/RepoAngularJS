/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author fvallejo
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ClienteConvenioID implements Serializable{
	
	@Column(name = "SECUENCIALCLIENTECONVENIO")
	@SequenceDataBaseValue(name = "SCSACSECCLICON", descriptorClass = DescriptorSecuenciasSIC.class)
	private Long secuencialClienteConvenio;

	public Long getSecuencialClienteConvenio() {
		return secuencialClienteConvenio;
	}

	public void setSecuencialClienteConvenio(Long secuencialClienteConvenio) {
		this.secuencialClienteConvenio = secuencialClienteConvenio;
	}

}
