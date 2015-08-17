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
public class AjusteFacturaEstadoID implements Serializable{
	/**
	 * Codigo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania; 
	
	/**
	 * Secuencial de la tabla AjusteFacturaEstado
	 */
	@Column(name = "CODIGOAJUSTEFACTURAESTADO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSECAJUFACEST" , castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoAjusteFacturaEstado;
	
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoAjusteFacturaEstado() {
		return codigoAjusteFacturaEstado;
	}
	public void setCodigoAjusteFacturaEstado(Long codigoAjusteFacturaEstado) {
		this.codigoAjusteFacturaEstado = codigoAjusteFacturaEstado;
	}
}
