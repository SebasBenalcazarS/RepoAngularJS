package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@SuppressWarnings("serial")
@Embeddable
public class ComponenteNutricionalID implements Serializable{
	
	@Column(name="SECUENCIAL", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCARTSCOMNUT")
	private Integer codigoComponenteNutricional;

	/**
	 * @return the codigoComponenteNutricional
	 */
	public Integer getCodigoComponenteNutricional() {
		return codigoComponenteNutricional;
	}

	/**
	 * @param codigoComponenteNutricional the codigoComponenteNutricional to set
	 */
	public void setCodigoComponenteNutricional(Integer codigoComponenteNutricional) {
		this.codigoComponenteNutricional = codigoComponenteNutricional;
	}
}
