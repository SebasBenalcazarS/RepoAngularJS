package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaRecepcionCantidadOrdenCompraDetalleEstadoID;

@Entity
@SuppressWarnings("serial")
public class VistaRecepcionCantidadOrdenCompraDetalleEstadoDTO extends SearchDTO {
	
	@EmbeddedId
	private VistaRecepcionCantidadOrdenCompraDetalleEstadoID id = new VistaRecepcionCantidadOrdenCompraDetalleEstadoID();
	
	private Integer cantidadPedida;
	
	private Integer cantidadPlanificada;
	
	private Integer cantidadEntregada;
	
	private Boolean articuloPedido;
	
	@Transient
	private Integer cantidadEntregadaAgrupada;

	/**
	 * @return the id
	 */
	public VistaRecepcionCantidadOrdenCompraDetalleEstadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaRecepcionCantidadOrdenCompraDetalleEstadoID id) {
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
	 * @return the cantidadEntregada
	 */
	public Integer getCantidadEntregada() {
		return cantidadEntregada;
	}

	/**
	 * @param cantidadEntregada the cantidadEntregada to set
	 */
	public void setCantidadEntregada(Integer cantidadEntregada) {
		this.cantidadEntregada = cantidadEntregada;
	}

	/**
	 * @return the articuloPedido
	 */
	public Boolean getArticuloPedido() {
		return articuloPedido;
	}

	/**
	 * @param articuloPedido the articuloPedido to set
	 */
	public void setArticuloPedido(Boolean articuloPedido) {
		this.articuloPedido = articuloPedido;
	}

	/**
	 * @return the cantidadEntregadaAgrupada
	 */
	public Integer getCantidadEntregadaAgrupada() {
		return cantidadEntregadaAgrupada;
	}

	/**
	 * @param cantidadEntregadaAgrupada the cantidadEntregadaAgrupada to set
	 */
	public void setCantidadEntregadaAgrupada(Integer cantidadEntregadaAgrupada) {
		this.cantidadEntregadaAgrupada = cantidadEntregadaAgrupada;
	}
	
}
