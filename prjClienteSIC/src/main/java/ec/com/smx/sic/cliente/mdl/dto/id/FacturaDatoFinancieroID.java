package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@SuppressWarnings("serial")
@Embeddable
public class FacturaDatoFinancieroID implements Serializable{

	/**
	 * C�digo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	/**
	 * Especifica el codigo de la tarea
	 *
	 */
	@Column(name = "CODIGOFACTURADATOFINACIERO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCFDISECFACDATFIN", castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoFacturaDatoFinanciero;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoFacturaDatoFinanciero() {
		return codigoFacturaDatoFinanciero;
	}

	public void setCodigoFacturaDatoFinanciero(Long codigoFacturaDatoFinanciero) {
		this.codigoFacturaDatoFinanciero = codigoFacturaDatoFinanciero;
	}
}
