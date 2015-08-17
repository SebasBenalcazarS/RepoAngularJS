package ec.com.smx.sic.cliente.mdl.dto.id.articulo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceValueAddition;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionPositionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionSizeEnum;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author mgranda
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloBitacoraClaseID implements Serializable {
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = "SCARTSECBITARTCLA",	sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.LARGE))
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