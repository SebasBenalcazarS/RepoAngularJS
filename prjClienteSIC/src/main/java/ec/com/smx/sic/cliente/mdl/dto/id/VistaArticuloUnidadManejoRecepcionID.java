package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;
@SuppressWarnings("serial")
@Embeddable
public class VistaArticuloUnidadManejoRecepcionID extends BaseID{
	private Integer codigoCompania;
	private Long codigoRecepcion;
	private Long codigoEntrega;
	private String codigoArticulo;
	private Long codigoUnidadManejo;
	//Este campo es el pk de la ordencompradetallestado del pedido original (Orden en estado ENV)
	private Long codigoOrdenCompraDetalleEstadoOriginal;
	private Integer codigoAreaTrabajoSubBodega;
	//Este campo es la hora en la que se configur� la entrega
	private Long horaInicio;
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
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
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}
	public Long getCodigoOrdenCompraDetalleEstadoOriginal() {
		return codigoOrdenCompraDetalleEstadoOriginal;
	}
	public void setCodigoOrdenCompraDetalleEstadoOriginal(Long codigoOrdenCompraDetalleEstadoOriginal) {
		this.codigoOrdenCompraDetalleEstadoOriginal = codigoOrdenCompraDetalleEstadoOriginal;
	}
	public Integer getCodigoAreaTrabajoSubBodega() {
		return codigoAreaTrabajoSubBodega;
	}
	public void setCodigoAreaTrabajoSubBodega(Integer codigoAreaTrabajoSubBodega) {
		this.codigoAreaTrabajoSubBodega = codigoAreaTrabajoSubBodega;
	}
	public Long getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Long horaInicio) {
		this.horaInicio = horaInicio;
	}
}
