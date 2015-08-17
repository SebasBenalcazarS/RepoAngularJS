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
public class ConvenioID implements Serializable {

	@Column(name = "SECUENCIALCONVENIO")
	@SequenceDataBaseValue(name = "SCSACSECCONVENIO", descriptorClass = DescriptorSecuenciasSIC.class)
	private Long secuencialConvenio;

	public Long getSecuencialConvenio() {
		return secuencialConvenio;
	}

	public void setSecuencialConvenio(Long secuencialConvenio) {
		this.secuencialConvenio = secuencialConvenio;
	}

}
