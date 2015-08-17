package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author aecaiza
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class NovedadArticuloJustificacionDetalleRecipienteID implements Serializable{
	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Secuencial de la tabla NovedadArticuloJustificacionDetalleRecipienteDTO
	 * 
	 */
	@Column(name = "CODIGONOVARTJUSDETREC", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECNOVARTJUSDETREC")
	private java.lang.Long codigoNovedadArticuloJustificacionDetalleRecipiente;

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
	 * @return the codigoNovedadArticuloJustificacionDetalleRecipiente
	 */
	public java.lang.Long getCodigoNovedadArticuloJustificacionDetalleRecipiente() {
		return codigoNovedadArticuloJustificacionDetalleRecipiente;
	}

	/**
	 * @param codigoNovedadArticuloJustificacionDetalleRecipiente the codigoNovedadArticuloJustificacionDetalleRecipiente to set
	 */
	public void setCodigoNovedadArticuloJustificacionDetalleRecipiente(java.lang.Long codigoNovedadArticuloJustificacionDetalleRecipiente) {
		this.codigoNovedadArticuloJustificacionDetalleRecipiente = codigoNovedadArticuloJustificacionDetalleRecipiente;
	}

	
	
}
