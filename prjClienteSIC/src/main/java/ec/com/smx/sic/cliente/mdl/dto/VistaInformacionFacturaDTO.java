package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VistaInformacionFacturaDTO {

	@Id
	private Long codigoFactura;
	private Integer codigoCompania;
	private String numeroFactura;
	private java.util.Date fechaFactura;
	private String ruc;
	private String codigoProveedor;
	
	public Long getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public java.util.Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(java.util.Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	
	
}
