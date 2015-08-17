package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaRecepcionOrdenCompraDetalleEstadoFacturaID;

@Entity
public class VistaRecepcionOrdenCompraDetalleEstadoFacturaDTO extends SimpleAuditDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.VistaRecepcionOrdenCompraDetalleEstadoFacturaID id = new ec.com.smx.sic.cliente.mdl.dto.id.VistaRecepcionOrdenCompraDetalleEstadoFacturaID();
	
	private Integer cantidadPedida;
	private Integer cantidadPlanificada;
	private Integer cantidadFacturada;
	/**
	 * @return the id
	 */
	public VistaRecepcionOrdenCompraDetalleEstadoFacturaID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(VistaRecepcionOrdenCompraDetalleEstadoFacturaID id) {
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
	 * @return the cantidadPlanificada
	 */
	public Integer getCantidadPlanificada() {
		return cantidadPlanificada;
	}
	/**
	 * @param cantidadPlanificada the cantidadPlanificada to set
	 */
	public void setCantidadPlanificada(Integer cantidadPlanificada) {
		this.cantidadPlanificada = cantidadPlanificada;
	}
	/**
	 * @return the cantidadFacturada
	 */
	public Integer getCantidadFacturada() {
		return cantidadFacturada;
	}
	/**
	 * @param cantidadFacturada the cantidadFacturada to set
	 */
	public void setCantidadFacturada(Integer cantidadFacturada) {
		this.cantidadFacturada = cantidadFacturada;
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
		
		VistaRecepcionOrdenCompraDetalleEstadoFacturaDTO other = (VistaRecepcionOrdenCompraDetalleEstadoFacturaDTO) obj;
		
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}
		
}
