package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DatosPreciosArticuloProveedorIntegracion implements Serializable {

	/*
	 * Datos para integracion
	 */
	
	private Long secuencial;
	
	private String codigoArticulo;
	private String codigoBarras;
	private String codigoProveedor;
	private String codigoTipoPrecio;
	
	private Double costoBruto;
	private Double precioPvp;
	private Double precioSmx;
	private Double valorActual;
	
	
	/*
	 * GETTERS AND SETTERS
	 */
	
	public Long getSecuencial() {
		return secuencial;
	}
	
	public void setSecuencial(Long secuencial) {
		this.secuencial = secuencial;
	}
	
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	
	public Double getCostoBruto() {
		return costoBruto;
	}
	
	public void setCostoBruto(Double costoBruto) {
		this.costoBruto = costoBruto;
	}
	
	public Double getPrecioPvp() {
		return precioPvp;
	}
	
	public void setPrecioPvp(Double precioPvp) {
		this.precioPvp = precioPvp;
	}
	
	public Double getPrecioSmx() {
		return precioSmx;
	}
	
	public void setPrecioSmx(Double precioSmx) {
		this.precioSmx = precioSmx;
	}
	
	public String getCodigoTipoPrecio() {
		return codigoTipoPrecio;
	}
	
	public void setCodigoTipoPrecio(String codigoTipoPrecio) {
		this.codigoTipoPrecio = codigoTipoPrecio;
	}

	public Double getValorActual() {
		return valorActual;
	}

	public void setValorActual(Double valorActual) {
		this.valorActual = valorActual;
	}
}
