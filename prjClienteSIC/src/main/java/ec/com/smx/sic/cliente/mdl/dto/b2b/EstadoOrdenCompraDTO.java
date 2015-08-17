/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.b2b;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.EstadoOrdenCompraID;

/**
 * @author mbraganza
 *
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.b2b.EstadoOrdenCompraDTO")
@Table(name = "SSB2BTESTADOORDENCOMPRA")
@Deprecated
public class EstadoOrdenCompraDTO extends SimpleAuditDTO {

	//id
	@EmbeddedId
	private EstadoOrdenCompraID id;
	
	//atributos
	private String descripcionEstado;
	private String estado;
	
	/**
	 * 
	 *
	 */
	public EstadoOrdenCompraDTO(){
		this.id = new EstadoOrdenCompraID();
	}

	/**
	 * @return el descripcionEstado
	 */
	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	/**
	 * @param descripcionEstado el descripcionEstado a establecer
	 */
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
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
	public EstadoOrdenCompraID getId() {
		return id;
	}

	/**
	 * @param id el id a establecer
	 */
	public void setId(EstadoOrdenCompraID id) {
		this.id = id;
	}
	
}
