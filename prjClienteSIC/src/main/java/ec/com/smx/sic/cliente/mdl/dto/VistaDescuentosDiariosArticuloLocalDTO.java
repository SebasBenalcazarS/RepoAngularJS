package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * @author egudino 
 */
@Entity
@SuppressWarnings("serial")
public class VistaDescuentosDiariosArticuloLocalDTO implements Serializable{
	@Id
	private java.lang.Long codigoDatosAcumulados; 
	private java.util.Date fecha;
	private java.lang.String codigoArticulo;
	private java.lang.String codigoLocal;
	private java.math.BigDecimal valor;
	private java.math.BigDecimal valorAcumulado;
	private java.lang.Integer codigoTipoImpuesto;
	private java.lang.Double porcentajeImpuesto;
	private java.math.BigDecimal cantidad;
	private java.math.BigDecimal precio;
	
	public java.lang.Long getCodigoDatosAcumulados() {
		return codigoDatosAcumulados;
	}
	public void setCodigoDatosAcumulados(java.lang.Long codigoDatosAcumulados) {
		this.codigoDatosAcumulados = codigoDatosAcumulados;
	}
	public java.lang.String getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(java.lang.String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	public java.lang.String getCodigoLocal() {
		return codigoLocal;
	}
	public void setCodigoLocal(java.lang.String codigoLocal) {
		this.codigoLocal = codigoLocal;
	}
	public java.math.BigDecimal getValorAcumulado() {
		return valorAcumulado;
	}
	public void setValorAcumulado(java.math.BigDecimal valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
	}
	public java.lang.Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}
	public void setCodigoTipoImpuesto(java.lang.Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
	}
	public java.lang.Double getPorcentajeImpuesto() {
		return porcentajeImpuesto;
	}
	public void setPorcentajeImpuesto(java.lang.Double porcentajeImpuesto) {
		this.porcentajeImpuesto = porcentajeImpuesto;
	}
	public java.math.BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(java.math.BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public java.math.BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(java.math.BigDecimal precio) {
		this.precio = precio;
	}
	public java.util.Date getFecha() {
		return fecha;
	}
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	public java.math.BigDecimal getValor() {
		return valor;
	}
	public void setValor(java.math.BigDecimal valor) {
		this.valor = valor;
	}
}
