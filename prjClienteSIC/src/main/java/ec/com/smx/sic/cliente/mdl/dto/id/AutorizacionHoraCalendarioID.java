package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase CalendarioProveedorDTO
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.CalendarioDTO
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class AutorizacionHoraCalendarioID implements Serializable {

	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencial de la tabla CalendarioProveedor
	 * 
	 */
	@Column(name = "CODIGOAUTORIZACIONHORACALENDARIO", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCSADSECAUTHORCAL")
	private java.lang.Long codigoAutorizacionCalendario;

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * 
	 * @param codigoCompania1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}

	public java.lang.Long getCodigoAutorizacionCalendario() {
		return codigoAutorizacionCalendario;
	}

	public void setCodigoAutorizacionCalendario(java.lang.Long codigoAutorizacionCalendario) {
		this.codigoAutorizacionCalendario = codigoAutorizacionCalendario;
	}
}
