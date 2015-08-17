/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras;

import java.io.Serializable;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author dvillafuerte
 *
 */
@SuppressWarnings("serial")
public class HistorialAhorroID implements Serializable {

	/**
	 * C�digo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSACSHISAHO")
	@Column(name = "CODIGOHISTORIALAHORRO", nullable = false)
	private Long codigoHistorialAhorro;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoHistorialAhorro() {
		return codigoHistorialAhorro;
	}

	public void setCodigoHistorialAhorro(Long codigoHistorialAhorro) {
		this.codigoHistorialAhorro = codigoHistorialAhorro;
	}
	
}
