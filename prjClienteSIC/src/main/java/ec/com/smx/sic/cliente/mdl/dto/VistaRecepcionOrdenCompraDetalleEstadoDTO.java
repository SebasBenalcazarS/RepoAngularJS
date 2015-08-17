package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaRecepcionOrdenCompraDetalleEstadoID;

@Entity
public class VistaRecepcionOrdenCompraDetalleEstadoDTO extends SimpleAuditDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.VistaRecepcionOrdenCompraDetalleEstadoID id = new ec.com.smx.sic.cliente.mdl.dto.id.VistaRecepcionOrdenCompraDetalleEstadoID();
	
	private Integer cantidadPedida;
	private Integer cantidadRecibida;
	/**
	 * @return the id
	 */
	public VistaRecepcionOrdenCompraDetalleEstadoID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(VistaRecepcionOrdenCompraDetalleEstadoID id) {
		this.id = id;
	}
		
	/**
	 * @return the cantidadPedida
	 */
	public Integer getCantidadPedida() {
		return cantidadPedida;
	}
	/**
	 * @param cantidadPedida the cantidadPedida to set
	 */
	public void setCantidadPedida(Integer cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}
	/**
	 * @return the cantidadRecibida
	 */
	public Integer getCantidadRecibida() {
		return cantidadRecibida;
	}
	/**
	 * @param cantidadRecibida the cantidadRecibida to set
	 */
	public void setCantidadRecibida(Integer cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		VistaRecepcionOrdenCompraDetalleEstadoDTO other = (VistaRecepcionOrdenCompraDetalleEstadoDTO) obj;
		
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}
		
}
