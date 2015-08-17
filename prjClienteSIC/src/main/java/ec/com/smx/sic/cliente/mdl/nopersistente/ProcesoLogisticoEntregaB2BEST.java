/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.math.BigDecimal;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * @author jtoapanta
 *
 */
@SuppressWarnings("serial")
public class ProcesoLogisticoEntregaB2BEST extends SimpleAuditDTO {
	
	private String codigoArticulo;
	private Long codigoUnidadManejo;
	private Long codigoEntrega;
	private Long codigoRecepcionProveedor;
	private Integer cantidadPlanificada; 
	private BigDecimal pesoPlanificado;
	private Integer cantidadEntregada;
	private BigDecimal pesoEntregado;
	private Integer cantidadPedida;
	private BigDecimal pesoPedido;
	private Integer cantidadPedidaRecepcion;
	private BigDecimal pesoPedidoRecepcion;
	private Long codigoOrdenCompraDetalleEstado;
	private Long codigoOrdenCompraEstado;
	private Long codigoOrdenCompraEstadoPadre;
	private Double pesoAproximadoRecepcion;
	private Integer valorUnidadManejo;
	private String descripcionArticulo;
	private String codigoBarras;
	private String valorTipoEstadoOrdenCompra;
	private String valorTipoControlCosto;

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
	 * @return the cantidadPedidaReccepcion
	 */
	public Integer getCantidadPedidaRecepcion() {
		return cantidadPedidaRecepcion;
	}
	/**
	 * @param cantidadPedidaReccepcion the cantidadPedidaReccepcion to set
	 */
	public void setCantidadPedidaRecepcion(Integer cantidadPedidaRecepcion) {
		this.cantidadPedidaRecepcion = cantidadPedidaRecepcion;
	}
	/**
	 * @return the pesoPedidoRecepcion
	 */
	public BigDecimal getPesoPedidoRecepcion() {
		return pesoPedidoRecepcion;
	}
	/**
	 * @param pesoPedidoRecepcion the pesoPedidoRecepcion to set
	 */
	public void setPesoPedidoRecepcion(BigDecimal pesoPedidoRecepcion) {
		this.pesoPedidoRecepcion = pesoPedidoRecepcion;
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
	 * @return the pesoAproximadoRecepcion
	 */
	public Double getPesoAproximadoRecepcion() {
		return pesoAproximadoRecepcion;
	}
	/**
	 * @param pesoAproximadoRecepcion the pesoAproximadoRecepcion to set
	 */
	public void setPesoAproximadoRecepcion(Double pesoAproximadoRecepcion) {
		this.pesoAproximadoRecepcion = pesoAproximadoRecepcion;
	}
	/**
	 * @return the valorUnidadManejo
	 */
	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}
	/**
	 * @param valorUnidadManejo the valorUnidadManejo to set
	 */
	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}
	/**
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}
	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}
	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	/**
	 * @return the valorTipoEstadoOrdenCompra
	 */
	public String getValorTipoEstadoOrdenCompra() {
		return valorTipoEstadoOrdenCompra;
	}
	/**
	 * @param valorTipoEstadoOrdenCompra the valorTipoEstadoOrdenCompra to set
	 */
	public void setValorTipoEstadoOrdenCompra(String valorTipoEstadoOrdenCompra) {
		this.valorTipoEstadoOrdenCompra = valorTipoEstadoOrdenCompra;
	}
	/**
	 * @return the valorTipoControlCosto
	 */
	public String getValorTipoControlCosto() {
		return valorTipoControlCosto;
	}
	/**
	 * @param valorTipoControlCosto the valorTipoControlCosto to set
	 */
	public void setValorTipoControlCosto(String valorTipoControlCosto) {
		this.valorTipoControlCosto = valorTipoControlCosto;
	}

}
