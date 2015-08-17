/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.b2b;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.EstadoPedidoID;

/**
 * @author mbraganza
 *
 */


@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.b2b.EstadoPedidoDTO")
@Table(name = "SSB2BTESTADOPEDIDO")
@Deprecated
public class EstadoPedidoDTO extends SimpleAuditDTO {

	//id
	@EmbeddedId
	private EstadoPedidoID id;
	
	//atributos
	private String descripcionEstadoPedido;
	private String estado;
	
	public EstadoPedidoDTO(){
		this.id = new EstadoPedidoID();
	}

	/**
	 * @return el descripcionEstadoPedido
	 */
	public String getDescripcionEstadoPedido() {
		return descripcionEstadoPedido;
	}

	/**
	 * @param descripcionEstadoPedido el descripcionEstadoPedido a establecer
	 */
	public void setDescripcionEstadoPedido(String descripcionEstadoPedido) {
		this.descripcionEstadoPedido = descripcionEstadoPedido;
	}

	/**
	 * @return el estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado el estado a establecer
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return el id
	 */
	public EstadoPedidoID getId() {
		return id;
	}

	/**
	 * @param id el id a establecer
	 */
	public void setId(EstadoPedidoID id) {
		this.id = id;
	}
	
	
}
