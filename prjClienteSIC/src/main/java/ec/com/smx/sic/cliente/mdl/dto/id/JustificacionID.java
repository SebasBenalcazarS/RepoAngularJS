package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Justificacion
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.JustificacionDTO
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class JustificacionID implements Serializable {

	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencial de la tabla Justificacion
	 * 
	 */
	@Column(name = "CODIGOJUSTIFICACION", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECJUSTIFICACION")
	private java.lang.Long codigoJustificacion;

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

	/**
	 * @return the codigoJustificacion
	 */
	public java.lang.Long getCodigoJustificacion() {
		return codigoJustificacion;
	}

	/**
	 * @param codigoJustificacion the codigoJustificacion to set
	 */
	public void setCodigoJustificacion(java.lang.Long codigoJustificacion) {
		this.codigoJustificacion = codigoJustificacion;
	}


}
