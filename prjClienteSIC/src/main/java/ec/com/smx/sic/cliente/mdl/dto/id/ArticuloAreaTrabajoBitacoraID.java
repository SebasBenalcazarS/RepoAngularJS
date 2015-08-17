/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author jmontenegro
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloAreaTrabajoBitacoraID implements Serializable {

	/**
	 * Codigo de la companía
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Codigo de la Area Trabajo Bitacora
	 * 
	 */
	@Column(name = "CODARTARETRABIT", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSECARTARETRABIT")
	private Long codigoArticuloAreaTrabajoBitacora;

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
	 * @return the codigoArticuloAreaTrabajoBitacora
	 */
	public Long getCodigoArticuloAreaTrabajoBitacora() {
		return codigoArticuloAreaTrabajoBitacora;
	}
	
	/**
	 * @param codigoCompania the codigoArticuloAreaTrabajoBitacora to set
	 */
	public void setCodigoArticuloAreaTrabajoBitacora(Long codigoArticuloAreaTrabajoBitacora) {
		this.codigoArticuloAreaTrabajoBitacora = codigoArticuloAreaTrabajoBitacora;
	}

	
}
