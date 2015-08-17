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
public class FacturaDetalleDatoFinancieroCentroCostoID implements Serializable {

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	@Column(name = "CODIGOFINANCIEROCENTROCOSTO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCFDISECCENTROCOSTO", castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoFinancieroCentroCosto;

	public Long getCodigoFinancieroCentroCosto() {
		return codigoFinancieroCentroCosto;
	}

	public void setCodigoFinancieroCentroCosto(Long codigoFinancieroCentroCosto) {
		this.codigoFinancieroCentroCosto = codigoFinancieroCentroCosto;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	
}
