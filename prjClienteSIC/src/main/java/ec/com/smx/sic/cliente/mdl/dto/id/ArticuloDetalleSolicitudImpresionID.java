package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceValueAddition;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionPositionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionSizeEnum;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;
/**
 * 
 * @author aquingaluisa
 *
 */
@SuppressWarnings("serial")
public class ArticuloDetalleSolicitudImpresionID implements Serializable {
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOARTDETSOLIMP", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSSECARTDETSOLIMP", castTo=@Cast(sqlType=Types.BIGINT),
	sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.SHORT))
	private Long codigoArticuloDetalleSolicitudEnvio;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoArticuloDetalleSolicitudEnvio() {
		return codigoArticuloDetalleSolicitudEnvio;
	}

	public void setCodigoArticuloDetalleSolicitudEnvio(Long codigoArticuloDetalleSolicitudEnvio) {
		this.codigoArticuloDetalleSolicitudEnvio = codigoArticuloDetalleSolicitudEnvio;
	}


}
