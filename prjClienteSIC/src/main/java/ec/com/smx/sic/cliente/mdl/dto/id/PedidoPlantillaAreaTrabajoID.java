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
public class PedidoPlantillaAreaTrabajoID implements Serializable {
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOPEDPLAARETRA")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBPEASECPEDPLAARETRA")
	private Long codigoPedidoPlantillaAreaTrabajo;

	
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
	 * @return the codigoPedidoPlantillaAreaTrabajo
	 */
	public Long getCodigoPedidoPlantillaAreaTrabajo() {
		return codigoPedidoPlantillaAreaTrabajo;
	}

	/**
	 * @param codigoPedidoPlantillaAreaTrabajo the codigoPedidoPlantillaAreaTrabajo to set
	 */
	public void setCodigoPedidoPlantillaAreaTrabajo(Long codigoPedidoPlantillaAreaTrabajo) {
		this.codigoPedidoPlantillaAreaTrabajo = codigoPedidoPlantillaAreaTrabajo;
	}
	
}
