/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.b2b;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.IdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.TipoPedidoID;

/**
 * @author mbraganza
 *
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.b2b.TipoPedidoDTO")
@Table(name = "SSB2BTTIPOPEDIDO")
@Deprecated
public class TipoPedidoDTO extends SimpleAuditDTO {
	//id
	@IdField
	@EmbeddedId
	private TipoPedidoID id;
	
	//atributos
	private String descripcionTipoPedido;
	private String estadoTipoPedido;
	
	/**
	 * 
	 *
	 */
	public TipoPedidoDTO(){
		this.id = new TipoPedidoID();
	}
	
	
	/**
	 * @return el descripcionTipoPedido
	 */
	public String getDescripcionTipoPedido() {
		return descripcionTipoPedido;
	}
	/**
	 * @param descripcionTipoPedido el descripcionTipoPedido a establecer
	 */
	public void setDescripcionTipoPedido(String descripcionTipoPedido) {
		this.descripcionTipoPedido = descripcionTipoPedido;
	}
	/**
	 * @return el estadoTipoPedido
	 */
	public String getEstadoTipoPedido() {
		return estadoTipoPedido;
	}
	/**
	 * @param estadoTipoPedido el estadoTipoPedido a establecer
	 */
	public void setEstadoTipoPedido(String estadoTipoPedido) {
		this.estadoTipoPedido = estadoTipoPedido;
	}
	/**
	 * @return el id
	 */
	public TipoPedidoID getId() {
		return id;
	}
	/**
	 * @param id el id a establecer
	 */
	public void setId(TipoPedidoID id) {
		this.id = id;
	}
	
	
}
