/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
public class PedidoPlantillaDetalleID implements Serializable{
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOPLANTILLADETALLE")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCORCSECPEDPLADET")
	private Long codigoPlantillaDetalle;
	
	

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
	 * @return the codigoPlantillaDetalle
	 */
	public Long getCodigoPlantillaDetalle() {
		return codigoPlantillaDetalle;
	}

	/**
	 * @param codigoPlantillaDetalle the codigoPlantillaDetalle to set
	 */
	public void setCodigoPlantillaDetalle(Long codigoPlantillaDetalle) {
		this.codigoPlantillaDetalle = codigoPlantillaDetalle;
	}
	
}
