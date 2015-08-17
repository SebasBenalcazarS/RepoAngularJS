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
public class ArticuloConvenioID implements Serializable{
	
	@Column(name = "SECUENCIALARTICULOCONVENIO")
	@SequenceDataBaseValue(name = "SCSACSECARTCON", descriptorClass = DescriptorSecuenciasSIC.class)
	private Long secuencial;

	public Long getSecuencial() {
		return secuencial;
	}

	public void setSecuencial(Long secuencial) {
		this.secuencial = secuencial;
	}

}
