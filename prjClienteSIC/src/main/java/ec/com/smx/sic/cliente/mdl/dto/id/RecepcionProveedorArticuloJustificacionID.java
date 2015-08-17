package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author aecaiza
 *
 */
@SuppressWarnings("serial")
public class RecepcionProveedorArticuloJustificacionID implements Serializable {
	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Secuencial de la tabla JustificacionaAreaTrabajo
	 * 
	 */
	@Column(name = "CODIGORECPROARTJUS", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECRECPROARTJUS")
	private java.lang.Long codigoRecepcionProveedorArticuloJustificacion;
	
	public static final String NOMBRE_SECUENCIA = "SBLOGSECRECPROARTJUS";

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
	 * @return the codigoRecepcionProveedorArticuloJustificacion
	 */
	public java.lang.Long getCodigoRecepcionProveedorArticuloJustificacion() {
		return codigoRecepcionProveedorArticuloJustificacion;
	}

	/**
	 * @param codigoRecepcionProveedorArticuloJustificacion the codigoRecepcionProveedorArticuloJustificacion to set
	 */
	public void setCodigoRecepcionProveedorArticuloJustificacion(java.lang.Long codigoRecepcionProveedorArticuloJustificacion) {
		this.codigoRecepcionProveedorArticuloJustificacion = codigoRecepcionProveedorArticuloJustificacion;
	}

}
