package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.hibernate.criterion.Criterion;

public class OrdenCompraContingenciaPedidoAsistidoVO {
	private Date fechaPedido;
	private Date fechaCaducidad;
	private Date fechaDespacho;
	private String imprimirOrdenes;
	private boolean enviarEmail;
	private Integer numeroPedido;
	private Integer codigoCompania;
	private String codigoFuncionario;
	private Set<String> proveedoresSeleccionados;
	private Integer codigoSubbodegaSeleccionada;
	private Integer codigoCentroDistribucionSeleccionado;
	private Map<String, Criterion> restricciones;
	private String userId;

	public OrdenCompraContingenciaPedidoAsistidoVO(Integer codigoCompania, String codigoFuncionario) {
		super();
		this.codigoCompania = codigoCompania;
		this.codigoFuncionario = codigoFuncionario;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Date getFechaDespacho() {
		return fechaDespacho;
	}

	public void setFechaDespacho(Date fechaDespacho) {
		this.fechaDespacho = fechaDespacho;
	}

	public String getImprimirOrdenes() {
		return imprimirOrdenes;
	}

	public void setImprimirOrdenes(String imprimirOrdenes) {
		this.imprimirOrdenes = imprimirOrdenes;
	}

	public boolean isEnviarEmail() {
		return enviarEmail;
	}

	public void setEnviarEmail(boolean enviarEmail) {
		this.enviarEmail = enviarEmail;
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public OrdenCompraContingenciaPedidoAsistidoVO() {
		super();
	}

	public Set<String> getProveedoresSeleccionados() {
		return proveedoresSeleccionados;
	}

	public void setProveedoresSeleccionados(Set<String> proveedoresSeleccionados) {
		this.proveedoresSeleccionados = proveedoresSeleccionados;
	}

	public Integer getCodigoSubbodegaSeleccionada() {
		return codigoSubbodegaSeleccionada;
	}

	public void setCodigoSubbodegaSeleccionada(Integer codigoSubbodegaSeleccionada) {
		this.codigoSubbodegaSeleccionada = codigoSubbodegaSeleccionada;
	}

	public Integer getCodigoCentroDistribucionSeleccionado() {
		return codigoCentroDistribucionSeleccionado;
	}

	public void setCodigoCentroDistribucionSeleccionado(Integer codigoCentroDistribucionSeleccionado) {
		this.codigoCentroDistribucionSeleccionado = codigoCentroDistribucionSeleccionado;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public Map<String, Criterion> getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(Map<String, Criterion> restricciones) {
		this.restricciones = restricciones;
	}
	
	public void agregarProveedor(String codigoProveedor){
		if (this.proveedoresSeleccionados.contains(codigoProveedor)) {
			this.proveedoresSeleccionados.remove(codigoProveedor);
		} else {
			this.getProveedoresSeleccionados().add(codigoProveedor);
		}
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
