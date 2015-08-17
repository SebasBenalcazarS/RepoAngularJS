package ec.com.smx.sic.cliente.mdl.dto.id;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceValueAddition;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionPositionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionSizeEnum;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Types;


@Embeddable
@SuppressWarnings("serial")
public class GestionPrecioRelacionID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	@Column(name = "CODIGOSECUENCIALGESTION", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = NOMBRE_SECUENCIA, castTo=@Cast(sqlType=Types.BIGINT),
	sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.SHORT))
	private Long codigoSecuencialGestion;

    public static final String NOMBRE_SECUENCIA = "SCPRESECGESPREREL";
	
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
	 * @return the codigoSecuencialGestion
	 */
	public Long getCodigoSecuencialGestion() {
		return codigoSecuencialGestion;
	}

	/**
	 * @param codigoSecuencialGestion the codigoSecuencialGestion to set
	 */
	public void setCodigoSecuencialGestion(Long codigoSecuencialGestion) {
		this.codigoSecuencialGestion = codigoSecuencialGestion;
	}

}
