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
public class FacturaDetalleDatoFinancieroID implements Serializable {
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	@Column(name = "CODIGODETALLEFINANCIERO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCFDISECDETFIN", castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoDetalleFinanciero;
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoDetalleFinanciero() {
		return codigoDetalleFinanciero;
	}

	public void setCodigoDetalleFinanciero(Long codigoDetalleFinanciero) {
		this.codigoDetalleFinanciero = codigoDetalleFinanciero;
	}

}
