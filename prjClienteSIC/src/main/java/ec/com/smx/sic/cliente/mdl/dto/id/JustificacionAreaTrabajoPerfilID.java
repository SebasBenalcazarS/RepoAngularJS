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
public class JustificacionAreaTrabajoPerfilID implements Serializable{
	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Secuencial de la tabla JustificacionaAreaTrabajoPerfil
	 * 
	 */
	@Column(name = "CODIGOJUSTIFICACIONARETRA", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECJUSARETRAPER")
	private java.lang.Long codigoJustificacionAreaTrabajoPerfil;

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
	 * @return the codigoJustificacionAreaTrabajoPerfil
	 */
	public java.lang.Long getCodigoJustificacionAreaTrabajoPerfil() {
		return codigoJustificacionAreaTrabajoPerfil;
	}

	/**
	 * @param codigoJustificacionAreaTrabajoPerfil the codigoJustificacionAreaTrabajoPerfil to set
	 */
	public void setCodigoJustificacionAreaTrabajoPerfil(java.lang.Long codigoJustificacionAreaTrabajoPerfil) {
		this.codigoJustificacionAreaTrabajoPerfil = codigoJustificacionAreaTrabajoPerfil;
	}
	
}
