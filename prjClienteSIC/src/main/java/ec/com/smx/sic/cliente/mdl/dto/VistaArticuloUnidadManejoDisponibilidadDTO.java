package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloUnidadManejoRecepcionID;

@Entity
public class VistaArticuloUnidadManejoDisponibilidadDTO {
	@EmbeddedId
	VistaArticuloUnidadManejoRecepcionID id = new VistaArticuloUnidadManejoRecepcionID();
	private Integer cantidadTotalPedida;
	private Integer cantidadTotalEntregada;
	private Integer cantidadItemsPedidos;
	private Integer cantidadItemsEntregados;
	public VistaArticuloUnidadManejoRecepcionID getId() {
		return id;
	}
	public void setId(VistaArticuloUnidadManejoRecepcionID id) {
		this.id = id;
	}
	public Integer getCantidadTotalPedida() {
		return cantidadTotalPedida;
	}
	public void setCantidadTotalPedida(Integer cantidadTotalPedida) {
		this.cantidadTotalPedida = cantidadTotalPedida;
	}
	public Integer getCantidadTotalEntregada() {
		return cantidadTotalEntregada;
	}
	public void setCantidadTotalEntregada(Integer cantidadTotalEntregada) {
		this.cantidadTotalEntregada = cantidadTotalEntregada;
	}
	public Integer getCantidadItemsPedidos() {
		return cantidadItemsPedidos;
	}
	public void setCantidadItemsPedidos(Integer cantidadItemsPedidos) {
		this.cantidadItemsPedidos = cantidadItemsPedidos;
	}
	public Integer getCantidadItemsEntregados() {
		return cantidadItemsEntregados;
	}
	public void setCantidadItemsEntregados(Integer cantidadItemsEntregados) {
		this.cantidadItemsEntregados = cantidadItemsEntregados;
	}
}

