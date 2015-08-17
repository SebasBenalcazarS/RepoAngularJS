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
@SuppressWarnings("serial")
@Embeddable
public class PedidoAreaTrabajoDetalleID implements Serializable {

	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	@Column(name = "CODIGOPEDARETRADET")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBPEASECPEDARETRADET")
	private Long codigoPedidoAreaTrabajoDetalle;

	
	
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
	 * @return the codigoPedidoAreaTrabajoDetalle
	 */
	public Long getCodigoPedidoAreaTrabajoDetalle() {
		return codigoPedidoAreaTrabajoDetalle;
	}

	/**
	 * @param codigoPedidoAreaTrabajoDetalle the codigoPedidoAreaTrabajoDetalle to set
	 */
	public void setCodigoPedidoAreaTrabajoDetalle(Long codigoPedidoAreaTrabajoDetalle) {
		this.codigoPedidoAreaTrabajoDetalle = codigoPedidoAreaTrabajoDetalle;
	}
	
}
