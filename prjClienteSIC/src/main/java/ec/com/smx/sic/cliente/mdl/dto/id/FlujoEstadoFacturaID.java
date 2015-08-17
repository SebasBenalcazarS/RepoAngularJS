package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author fcollaguazo
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class FlujoEstadoFacturaID implements Serializable{
	
	/**
	 * C�digo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	@Column(name = "CODIGOFLUJOESTADOSFACTURA", nullable = false)	
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCFDISECAJUFACEST" , castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoFlujoEstadosFactura ;

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

	public Long getCodigoFlujoEstadosFactura() {
		return codigoFlujoEstadosFactura;
	}

	public void setCodigoFlujoEstadosFactura(Long codigoFlujoEstadosFactura) {
		this.codigoFlujoEstadosFactura = codigoFlujoEstadosFactura;
	}
}
