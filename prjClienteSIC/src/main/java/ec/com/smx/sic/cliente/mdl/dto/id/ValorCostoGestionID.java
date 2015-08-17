/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceValueAddition;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionPositionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionSizeEnum;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author Victor Jaramillo
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class ValorCostoGestionID implements Serializable {

	@Column(name = "CODIGOCOMPANIA" , nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOVALORCOSTOGESTION" , nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = "SCPRESECVALCOSGES", castTo=@Cast(sqlType=Types.BIGINT),
	sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.SHORT))
	private Long codigoValorCostoGestion;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoValorCostoGestion
	 */
	public Long getCodigoValorCostoGestion() {
		return codigoValorCostoGestion;
	}

	/**
	 * @param codigoValorCostoGestion the codigoValorCostoGestion to set
	 */
	public void setCodigoValorCostoGestion(Long codigoValorCostoGestion) {
		this.codigoValorCostoGestion = codigoValorCostoGestion;
	}
}
