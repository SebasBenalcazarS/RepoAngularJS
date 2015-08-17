package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.common.util.CorporativoDescriptorSecuencias;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Detalle
 * Tarea
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.AsignacionAreaTrabajoDTO
 * 
 * @author acaiza
 */
@SuppressWarnings("serial")
@Embeddable
public class AsignacionAreaTrabajoID implements Serializable {

	/**
	 * Código de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Especifica el codigo de la tarea
	 * 
	 */
	@Column(name = "CODIGOASIGNACIONAREATRABAJO", nullable = false)
	@SequenceDataBaseValue(descriptorClass = CorporativoDescriptorSecuencias.class, name = "SCTARSECASIARETRA")
	private Long codigoAsignacionAreaTrabajo;

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
	 * @return the codigoAsignacionAreaTrabajo
	 */
	public Long getCodigoAsignacionAreaTrabajo() {
		return codigoAsignacionAreaTrabajo;
	}

	/**
	 * @param codigoAsignacionAreaTrabajo the codigoAsignacionAreaTrabajo to set
	 */
	public void setCodigoAsignacionAreaTrabajo(Long codigoAsignacionAreaTrabajo) {
		this.codigoAsignacionAreaTrabajo = codigoAsignacionAreaTrabajo;
	}



}
