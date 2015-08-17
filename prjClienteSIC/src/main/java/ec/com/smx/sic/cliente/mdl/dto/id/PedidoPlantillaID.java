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
 * @author jvillacis
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class PedidoPlantillaID implements Serializable{
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOPLANTILLA", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCORCSECPEDPLA")
	private Long codigoPlantilla;
	
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
	 * @return the codigoPlantilla
	 */
	public Long getCodigoPlantilla() {
		return codigoPlantilla;
	}

	/**
	 * @param codigoPlantilla the codigoPlantilla to set
	 */
	public void setCodigoPlantilla(Long codigoPlantilla) {
		this.codigoPlantilla = codigoPlantilla;
	}
	
}
