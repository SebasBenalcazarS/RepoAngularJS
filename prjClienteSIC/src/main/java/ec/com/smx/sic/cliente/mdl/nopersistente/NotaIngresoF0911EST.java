package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.math.BigDecimal;
import java.util.Date;

public class NotaIngresoF0911EST {

	//AreaTrabajo
	private Integer codigoReferencia;
	
	//Factura
	private Integer codigoCompania;
	private Long codigoFactura;
	private String codigoProveedor;
	private Integer codigoAreaSublugarTrabajo;
	private Integer tipoTransaccion;

	//FacturaEstado
	private Long codigoFacturaEstado;
	private String numeroFactura;
	private BigDecimal valorTarifaCero;
	private BigDecimal valorTarifaDoce;
	private BigDecimal valorTotalIve;
	private Date fechaFactura;
	private BigDecimal valorTotalCalculado;
	
	//OrdenCompraDetalleEstado
	private BigDecimal costoNeto;
	private BigDecimal costoBruto;
	private BigDecimal pesoPedido;
	private Integer cantidadPedida;
	
	//ArticuloComercial
	private String valorTipoControlCosto;
	
	//Articulo
	private String codigoArticulo;
	private String descripcionArticulo;
	private String codigoSubClasificacion;
	private String codigoClasificacion;
	
	//Clasificacion
	private String codigoDepartamento;
	private String codigoDivision;
	
	//ArticuloUnidadManejo
	private Integer valorUnidadManejo;
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public Long getCodigoFacturaEstado() {
		return codigoFacturaEstado;
	}
	public void setCodigoFacturaEstado(Long codigoFacturaEstado) {
		this.codigoFacturaEstado = codigoFacturaEstado;
	}
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public BigDecimal getValorTarifaCero() {
		return valorTarifaCero;
	}
	public void setValorTarifaCero(BigDecimal valorTarifaCero) {
		this.valorTarifaCero = valorTarifaCero;
	}
	public BigDecimal getValorTarifaDoce() {
		return valorTarifaDoce;
	}
	public void setValorTarifaDoce(BigDecimal valorTarifaDoce) {
		this.valorTarifaDoce = valorTarifaDoce;
	}
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	public BigDecimal getCostoNeto() {
		return costoNeto;
	}
	public void setCostoNeto(BigDecimal costoNeto) {
		this.costoNeto = costoNeto;
	}
	public BigDecimal getCostoBruto() {
		return costoBruto;
	}
	public void setCostoBruto(BigDecimal costoBruto) {
		this.costoBruto = costoBruto;
	}
	public BigDecimal getPesoPedido() {
		return pesoPedido;
	}
	public void setPesoPedido(BigDecimal pesoPedido) {
		this.pesoPedido = pesoPedido;
	}
	public Integer getCantidadPedida() {
		return cantidadPedida;
	}
	public void setCantidadPedida(Integer cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}	
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	public String getCodigoSubClasificacion() {
		return codigoSubClasificacion;
	}
	public void setCodigoSubClasificacion(String codigoSubClasificacion) {
		this.codigoSubClasificacion = codigoSubClasificacion;
	}
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}
	public String getCodigoDivision() {
		return codigoDivision;
	}
	public void setCodigoDivision(String codigoDivision) {
		this.codigoDivision = codigoDivision;
	}
	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}
	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}
	public Integer getCodigoAreaSublugarTrabajo() {
		return codigoAreaSublugarTrabajo;
	}
	public void setCodigoAreaSublugarTrabajo(Integer codigoAreaSublugarTrabajo) {
		this.codigoAreaSublugarTrabajo = codigoAreaSublugarTrabajo;
	}
	public Integer getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(Integer tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public String getValorTipoControlCosto() {
		return valorTipoControlCosto;
	}
	public void setValorTipoControlCosto(String valorTipoControlCosto) {
		this.valorTipoControlCosto = valorTipoControlCosto;
	}
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public Integer getCodigoReferencia() {
		return codigoReferencia;
	}
	public void setCodigoReferencia(Integer codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}
	public BigDecimal getValorTotalIve() {
		return valorTotalIve;
	}
	public void setValorTotalIve(BigDecimal valorTotalIve) {
		this.valorTotalIve = valorTotalIve;
	}
	public BigDecimal getValorTotalCalculado() {
		return valorTotalCalculado;
	}
	public void setValorTotalCalculado(BigDecimal valorTotalCalculado) {
		this.valorTotalCalculado = valorTotalCalculado;
	}
}
