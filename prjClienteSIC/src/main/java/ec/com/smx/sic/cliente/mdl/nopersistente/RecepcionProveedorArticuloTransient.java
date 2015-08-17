/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.math.BigDecimal;

import scala.collection.mutable.StringBuilder;

/**
 * 
 * @author wcaiza
 *
 */
public class RecepcionProveedorArticuloTransient {
	
	private Integer codigoCompania;
	private Long codigoOrdenCompra;
	private Long codigoRecepcionProveedorArticulo;
	private Long codigoRecepcionProveedor;
	private String codigoArticulo;
	private Long codigoUnidadManejo;
	private Integer cantidadAnterior;
	private BigDecimal pesoAnterior;
	private Integer cantidadPedida;
	private BigDecimal pesoPedido;
	private Integer cantidadPlanificada;
	private BigDecimal pesoPlanificado;
	private Integer cantidadEntregada;
	private BigDecimal pesoEntregado;
	private String estado;
	
	/**
	 * Catalogo valor para el estado de la orden de compra (PEN o ENV)
	 */
	private String codigoEstadoCatVal;
	
	private Integer codigoEstadoCatTip;
	
	/**
	 * Campo para realizar las actualizaciones a la BD
	 */
	private Long secuencialRecepcionProveedorArticulo;
	
	/**
	 * Campo para almacenar el usuario que esta realizando un cambio
	 */
	private String userId;
	
	/**
	 * Identificar si el articulo pertenece a una orden de compra enviada o pendiente
	 */
	private Long codigoOrdenCompraEstado;
	private Long codigoOrdenCompraEstadoPadre;

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
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
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
	 * @return the pesoPedido
	 */
	public BigDecimal getPesoPedido() {
		return pesoPedido;
	}

	/**
	 * @param pesoPedido the pesoPedido to set
	 */
	public void setPesoPedido(BigDecimal pesoPedido) {
		this.pesoPedido = pesoPedido;
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
	 * @return the pesoPlanificado
	 */
	public BigDecimal getPesoPlanificado() {
		return pesoPlanificado;
	}

	/**
	 * @param pesoPlanificado the pesoPlanificado to set
	 */
	public void setPesoPlanificado(BigDecimal pesoPlanificado) {
		this.pesoPlanificado = pesoPlanificado;
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
	 * @return the pesoEntregado
	 */
	public BigDecimal getPesoEntregado() {
		return pesoEntregado;
	}

	/**
	 * @param pesoEntregado the pesoEntregado to set
	 */
	public void setPesoEntregado(BigDecimal pesoEntregado) {
		this.pesoEntregado = pesoEntregado;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the codigoEstadoCatVal
	 */
	public String getCodigoEstadoCatVal() {
		return codigoEstadoCatVal;
	}

	/**
	 * @param codigoEstadoCatVal the codigoEstadoCatVal to set
	 */
	public void setCodigoEstadoCatVal(String codigoEstadoCatVal) {
		this.codigoEstadoCatVal = codigoEstadoCatVal;
	}
	
	/**
	 * @return the secuencialRecepcionProveedorArticulo
	 */
	public Long getSecuencialRecepcionProveedorArticulo() {
		return secuencialRecepcionProveedorArticulo;
	}

	/**
	 * @param secuencialRecepcionProveedorArticulo the secuencialRecepcionProveedorArticulo to set
	 */
	public void setSecuencialRecepcionProveedorArticulo(Long secuencialRecepcionProveedorArticulo) {
		this.secuencialRecepcionProveedorArticulo = secuencialRecepcionProveedorArticulo;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getClaveArticuloUnidadManejoProveedor () {
		
		final char sepadador = '-';
		return new StringBuilder().append(this.codigoArticulo).append(sepadador).
				append(this.codigoUnidadManejo).append(sepadador).append(this.codigoRecepcionProveedor).toString();
		
	}

	/**
	 * @return the codigoEstadoCatTip
	 */
	public Integer getCodigoEstadoCatTip() {
		return codigoEstadoCatTip;
	}

	/**
	 * @param codigoEstadoCatTip the codigoEstadoCatTip to set
	 */
	public void setCodigoEstadoCatTip(Integer codigoEstadoCatTip) {
		this.codigoEstadoCatTip = codigoEstadoCatTip;
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
	 * @return the codigoOrdenCompra
	 */
	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}

	/**
	 * @param codigoOrdenCompra the codigoOrdenCompra to set
	 */
	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}

	/**
	 * @return the codigoOrdenCompraEstadoPadre
	 */
	public Long getCodigoOrdenCompraEstadoPadre() {
		return codigoOrdenCompraEstadoPadre;
	}

	/**
	 * @param codigoOrdenCompraEstadoPadre the codigoOrdenCompraEstadoPadre to set
	 */
	public void setCodigoOrdenCompraEstadoPadre(Long codigoOrdenCompraEstadoPadre) {
		this.codigoOrdenCompraEstadoPadre = codigoOrdenCompraEstadoPadre;
	}

	/**
	 * @return the cantidadAnterior
	 */
	public Integer getCantidadAnterior() {
		return cantidadAnterior;
	}

	/**
	 * @param cantidadAnterior the cantidadAnterior to set
	 */
	public void setCantidadAnterior(Integer cantidadAnterior) {
		this.cantidadAnterior = cantidadAnterior;
	}

	/**
	 * @return the pesoAnterior
	 */
	public BigDecimal getPesoAnterior() {
		return pesoAnterior;
	}

	/**
	 * @param pesoAnterior the pesoAnterior to set
	 */
	public void setPesoAnterior(BigDecimal pesoAnterior) {
		this.pesoAnterior = pesoAnterior;
	}

}
