package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@Embeddable
@SuppressWarnings("serial")
public class VistaRecepcionCantidadOrdenCompraDetalleEstadoID extends BaseID{
	
	private Integer codigoCompania;
	
	private Long codigoOrdenCompraDetalleEstado;
	
	private Long codigoDetalleDatosTarea;
	
	private Long codigoOrdenCompraEstado;
	
	private Long codigoRecepcionProveedor;
	
	private Long codigoProcesoLogistico;
	
	private Long codigoEntrega;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoOrdenCompraDetalleEstado
	 */
	public Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}

	/**
	 * @param codigoOrdenCompraDetalleEstado the codigoOrdenCompraDetalleEstado to set
	 */
	public void setCodigoOrdenCompraDetalleEstado(Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
	}

	/**
	 * @return the codigoDetalleDatosTarea
	 */
	public Long getCodigoDetalleDatosTarea() {
		return codigoDetalleDatosTarea;
	}

	/**
	 * @param codigoDetalleDatosTarea the codigoDetalleDatosTarea to set
	 */
	public void setCodigoDetalleDatosTarea(Long codigoDetalleDatosTarea) {
		this.codigoDetalleDatosTarea = codigoDetalleDatosTarea;
	}

	/**
	 * @return the codigoOrdenCompraEstado
	 */
	public Long getCodigoOrdenCompraEstado() {
		return codigoOrdenCompraEstado;
	}

	/**
	 * @param codigoOrdenCompraEstado the codigoOrdenCompraEstado to set
	 */
	public void setCodigoOrdenCompraEstado(Long codigoOrdenCompraEstado) {
		this.codigoOrdenCompraEstado = codigoOrdenCompraEstado;
	}

	/**
	 * @return the codigoRecepcionProveedor
	 */
	public Long getCodigoRecepcionProveedor() {
		return codigoRecepcionProveedor;
	}

	/**
	 * @param codigoRecepcionProveedor the codigoRecepcionProveedor to set
	 */
	public void setCodigoRecepcionProveedor(Long codigoRecepcionProveedor) {
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
	}

	/**
	 * @return the codigoProcesoLogistico
	 */
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	/**
	 * @param codigoProcesoLogistico the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}

	/**
	 * @return the codigoEntrega
	 */
	public Long getCodigoEntrega() {
		return codigoEntrega;
	}

	/**
	 * @param codigoEntrega the codigoEntrega to set
	 */
	public void setCodigoEntrega(Long codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

}
