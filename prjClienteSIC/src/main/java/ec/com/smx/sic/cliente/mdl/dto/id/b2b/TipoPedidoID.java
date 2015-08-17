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
public class TipoPedidoID implements Serializable {

	private String tipoPedido;

	/**
	 * @return el tipoPedido
	 */
	public String getTipoPedido() {
		return tipoPedido;
	}

	/**
	 * @param tipoPedido el tipoPedido a establecer
	 */
	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}
	
	
}
