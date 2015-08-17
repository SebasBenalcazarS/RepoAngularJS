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
public class PedidoPlantillaAreaTrabajoDetalleID implements Serializable {
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOPEDPLAARETRADET")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBPEASECPEDPLAARETRADET")
	private Long codigoPedidoPlantillaAreaTrabajoDetalle;

	
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
	 * @return the codigoPedidoPlantillaAreaTrabajoDetalle
	 */
	public Long getCodigoPedidoPlantillaAreaTrabajoDetalle() {
		return codigoPedidoPlantillaAreaTrabajoDetalle;
	}

	/**
	 * @param codigoPedidoPlantillaAreaTrabajoDetalle the codigoPedidoPlantillaAreaTrabajoDetalle to set
	 */
	public void setCodigoPedidoPlantillaAreaTrabajoDetalle(Long codigoPedidoPlantillaAreaTrabajoDetalle) {
		this.codigoPedidoPlantillaAreaTrabajoDetalle = codigoPedidoPlantillaAreaTrabajoDetalle;
	}
	
}
