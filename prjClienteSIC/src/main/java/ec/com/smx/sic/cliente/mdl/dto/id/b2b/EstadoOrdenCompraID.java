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
public class EstadoOrdenCompraID implements Serializable {

	private String estadoOrdenCompra;

	/**
	 * @return el estadoOrdenCompra
	 */
	public String getEstadoOrdenCompra() {
		return estadoOrdenCompra;
	}

	/**
	 * @param estadoOrdenCompra el estadoOrdenCompra a establecer
	 */
	public void setEstadoOrdenCompra(String estadoOrdenCompra) {
		this.estadoOrdenCompra = estadoOrdenCompra;
	}
	
	
}
