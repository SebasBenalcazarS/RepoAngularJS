package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@Embeddable
@SuppressWarnings("serial")
public class VistaDiferenciaFacturasRecepcionID extends BaseID {
	
//	private Integer codigoCompania;
//	
//	private String codigoArticulo;
//	
//	private Long codigoUnidadManejo;
//	
//	private Long codigoEntrega;
//	
//    private Long codigoOrdenCompraDetalleEstado;
//    
//    private Long codigoOrdenCompraEstado;
//    
//    private Long codigoRecepcion;
//    
//
//	/**
//	 * @return the codigoCompania
//	 */
//	public Integer getCodigoCompania() {
//		return codigoCompania;
//	}
//
//	/**
//	 * @param codigoCompania the codigoCompania to set
//	 */
//	public void setCodigoCompania(Integer codigoCompania) {
//		this.codigoCompania = codigoCompania;
//	}
//
//	/**
//	 * @return the codigoArticulo
//	 */
//	public String getCodigoArticulo() {
//		return codigoArticulo;
//	}
//
//	/**
//	 * @param codigoArticulo the codigoArticulo to set
//	 */
//	public void setCodigoArticulo(String codigoArticulo) {
//		this.codigoArticulo = codigoArticulo;
//	}
//
//	/**
//	 * @return the codigoUnidadManejo
//	 */
//	public Long getCodigoUnidadManejo() {
//		return codigoUnidadManejo;
//	}
//
//	/**
//	 * @param codigoUnidadManejo the codigoUnidadManejo to set
//	 */
//	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
//		this.codigoUnidadManejo = codigoUnidadManejo;
//	}
//
//	/**
//	 * @return the codigoEntrega
//	 */
//	public Long getCodigoEntrega() {
//		return codigoEntrega;
//	}
//
//	/**
//	 * @param codigoEntrega the codigoEntrega to set
//	 */
//	public void setCodigoEntrega(Long codigoEntrega) {
//		this.codigoEntrega = codigoEntrega;
//	}
//
//	/**
//	 * @return the codigoOrdenCompraDetalleEstado
//	 */
//	public Long getCodigoOrdenCompraDetalleEstado() {
//		return codigoOrdenCompraDetalleEstado;
//	}
//
//	/**
//	 * @param codigoOrdenCompraDetalleEstado the codigoOrdenCompraDetalleEstado to set
//	 */
//	public void setCodigoOrdenCompraDetalleEstado(Long codigoOrdenCompraDetalleEstado) {
//		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
//	}
//
//	/**
//	 * @return the codigoOrdenCompraEstado
//	 */
//	public Long getCodigoOrdenCompraEstado() {
//		return codigoOrdenCompraEstado;
//	}
//
//	/**
//	 * @param codigoOrdenCompraEstado the codigoOrdenCompraEstado to set
//	 */
//	public void setCodigoOrdenCompraEstado(Long codigoOrdenCompraEstado) {
//		this.codigoOrdenCompraEstado = codigoOrdenCompraEstado;
//	}
//
//	/**
//	 * @return the codigoRecepcion
//	 */
//	public Long getCodigoRecepcion() {
//		return codigoRecepcion;
//	}
//
//	/**
//	 * @param codigoRecepcion the codigoRecepcion to set
//	 */
//	public void setCodigoRecepcion(Long codigoRecepcion) {
//		this.codigoRecepcion = codigoRecepcion;
//	}
	
	private Integer codigoCompania;
	
	private Long codigoRecepcionProveedorArticulo;
    
	/**
	 * @return the codigoRecepcionProveedorArticulo
	 */
	public Long getCodigoRecepcionProveedorArticulo() {
		return codigoRecepcionProveedorArticulo;
	}

	/**
	 * @param codigoRecepcionProveedorArticulo the codigoRecepcionProveedorArticulo to set
	 */
	public void setCodigoRecepcionProveedorArticulo(Long codigoRecepcionProveedorArticulo) {
		this.codigoRecepcionProveedorArticulo = codigoRecepcionProveedorArticulo;
	}

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

}
