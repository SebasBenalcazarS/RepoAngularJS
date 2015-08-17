/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.b2b;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author mbraganza
 *
 */
@SuppressWarnings("serial")
@Embeddable
@Deprecated
public class EstadoPedidoID implements Serializable {
	
	private String estadoPedido;

	/**
	 * @return el estadoPedido
	 */
	public String getEstadoPedido() {
		return estadoPedido;
	}

	/**
	 * @param estadoPedido el estadoPedido a establecer
	 */
	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	
	
}
