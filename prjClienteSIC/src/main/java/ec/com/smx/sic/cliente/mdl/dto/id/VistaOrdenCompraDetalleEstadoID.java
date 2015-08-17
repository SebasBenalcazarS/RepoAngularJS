package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@SuppressWarnings("serial")
@Embeddable
public class VistaOrdenCompraDetalleEstadoID extends BaseID{
	
	private Integer codigoCompania;
    private Long codigoOrdenCompraDetalleEstado;
    private Long codigoOrdenCompraEstado;
    private Long codigoRecepcion;
    private Long codigoEntrega;
    
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}
	public void setCodigoOrdenCompraDetalleEstado(Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
	}
	public Long getCodigoOrdenCompraEstado() {
		return codigoOrdenCompraEstado;
	}
	public void setCodigoOrdenCompraEstado(Long codigoOrdenCompraEstado) {
		this.codigoOrdenCompraEstado = codigoOrdenCompraEstado;
	}
	public Long getCodigoRecepcion() {
		return codigoRecepcion;
	}
	public void setCodigoRecepcion(Long codigoRecepcion) {
		this.codigoRecepcion = codigoRecepcion;
	}
	public Long getCodigoEntrega() {
		return codigoEntrega;
	}
	public void setCodigoEntrega(Long codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}
	
}
