/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.b2b;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author fnaranjo
 *
 */
@SuppressWarnings("serial")
@Embeddable
@Deprecated
public class CaracteristicaPedidoID implements Serializable {

	private String codigoCaracteristicaPedido;

	/**
	 * @return el codigoCaracteristicaPedido
	 */
	public String getCodigoCaracteristicaPedido() {
		return codigoCaracteristicaPedido;
	}

	/**
	 * @param codigoCaracteristicaPedido el codigoCaracteristicaPedido a establecer
	 */
	public void setCodigoCaracteristicaPedido(String codigoCaracteristicaPedido) {
		this.codigoCaracteristicaPedido = codigoCaracteristicaPedido;
	}
}
