package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase
 * TareaProceso
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.TareaProceso
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class TareaProcesoID implements Serializable {

	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencial de la tabla AsignacionProceso
	 * 
	 */
	@Column(name = "CODIGOASIGNACIONPROCESO", nullable = false)
	private java.lang.Long codigoAsignacionProceso;

	/**
	 * Especifica la secuencia de la tarea
	 * 
	 */
	@Column(name = "CODIGOTAREA", nullable = false)
	private java.lang.Long codigoTarea;

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
	 * Retorna valor de propiedad <code>codigoAsignacionProceso</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoAsignacionProceso</code>
	 */
	public java.lang.Long getCodigoAsignacionProceso() {
		return this.codigoAsignacionProceso;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>codigoAsignacionProceso</code>.
	 * 
	 * @param codigoAsignacionProceso1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoAsignacionProceso</code>.
	 */
	public void setCodigoAsignacionProceso(
			java.lang.Long codigoAsignacionProceso1) {
		this.codigoAsignacionProceso = codigoAsignacionProceso1;

	}

	/**
	 * Retorna valor de propiedad <code>codigoTarea</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoTarea</code>
	 */
	public java.lang.Long getCodigoTarea() {
		return this.codigoTarea;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTarea</code>.
	 * 
	 * @param codigoTarea1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoTarea</code>.
	 */
	public void setCodigoTarea(java.lang.Long codigoTarea1) {
		this.codigoTarea = codigoTarea1;

	}

}
