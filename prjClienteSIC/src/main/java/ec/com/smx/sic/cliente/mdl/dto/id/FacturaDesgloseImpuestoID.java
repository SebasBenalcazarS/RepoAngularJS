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
public class FacturaDesgloseImpuestoID implements Serializable{
	/**
	 * codigoCompania
	 * */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Secuencial de la tabla
	 * Especifica el código de la tarea
	 * 
	 * */ 
	@Column(name = "CODIGODESGLOCEIMPUESTOS", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class, name = "SCFDISECDESGIMP", castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoDesgloseImpuesto;

	//Getters and Setters
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoDesgloseImpuesto() {
		return codigoDesgloseImpuesto;
	}

	public void setCodigoDesgloseImpuesto(Long codigoDesgloseImpuesto) {
		this.codigoDesgloseImpuesto = codigoDesgloseImpuesto;
	}
	
}
