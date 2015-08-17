package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author rpalacios
 */
@SuppressWarnings("serial")
@Embeddable

public class ProveedorAreaTrabajoID extends BaseID implements Serializable {

	/**
	 * Codigo de compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Secuencial de proveedor Area de trabajo
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCPROSECPROARETRA")
	@Column(name = "SECUENCIALPROARETRA", nullable = false)
	private Long secuencialProAreaTrabajo;

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
	 * @return the secuencialProAreaTrabajo
	 */
	public Long getSecuencialProAreaTrabajo() {
		return secuencialProAreaTrabajo;
	}

	/**
	 * @param secuencialProAreaTrabajo the secuencialProAreaTrabajo to set
	 */
	public void setSecuencialProAreaTrabajo(Long secuencialProAreaTrabajo) {
		this.secuencialProAreaTrabajo = secuencialProAreaTrabajo;
	}
}