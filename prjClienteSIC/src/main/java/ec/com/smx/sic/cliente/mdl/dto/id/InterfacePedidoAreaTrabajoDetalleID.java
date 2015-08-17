/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class InterfacePedidoAreaTrabajoDetalleID implements Serializable {
	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;

	@Column(name = "CODIGOINTPEDARETRA")
	private Long codigoInterfacePedidoAreaTrabajo;
	
	@Column(name = "CODIGOPEDARETRA")
	private Long codigoPedidoAreaTrabajo;

	
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
	 * @return the codigoInterfacePedidoAreaTrabajo
	 */
	public Long getCodigoInterfacePedidoAreaTrabajo() {
		return codigoInterfacePedidoAreaTrabajo;
	}

	/**
	 * @param codigoInterfacePedidoAreaTrabajo the codigoInterfacePedidoAreaTrabajo to set
	 */
	public void setCodigoInterfacePedidoAreaTrabajo(Long codigoInterfacePedidoAreaTrabajo) {
		this.codigoInterfacePedidoAreaTrabajo = codigoInterfacePedidoAreaTrabajo;
	}

	/**
	 * @return the codigoPedidoAreaTrabajo
	 */
	public Long getCodigoPedidoAreaTrabajo() {
		return codigoPedidoAreaTrabajo;
	}

	/**
	 * @param codigoPedidoAreaTrabajo the codigoPedidoAreaTrabajo to set
	 */
	public void setCodigoPedidoAreaTrabajo(Long codigoPedidoAreaTrabajo) {
		this.codigoPedidoAreaTrabajo = codigoPedidoAreaTrabajo;
	}
	
}
