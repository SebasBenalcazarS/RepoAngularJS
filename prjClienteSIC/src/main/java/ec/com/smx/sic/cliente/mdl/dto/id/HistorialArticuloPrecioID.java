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

@SuppressWarnings("serial")
@Embeddable
public class HistorialArticuloPrecioID implements Serializable {

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOHISTORIALPRECIO", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = "CODIGOHISTORIALPRECIO", castTo=@Cast(sqlType=Types.BIGINT),
	sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.SHORT))
	private Long codigoHistorialPrecio;

	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	
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
	 * @return the codigoHistorialPrecio
	 */
	public Long getCodigoHistorialPrecio() {
		return codigoHistorialPrecio;
	}

	/**
	 * @param codigoHistorialPrecio the codigoHistorialPrecio to set
	 */
	public void setCodigoHistorialPrecio(Long codigoHistorialPrecio) {
		this.codigoHistorialPrecio = codigoHistorialPrecio;
	}

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

}
