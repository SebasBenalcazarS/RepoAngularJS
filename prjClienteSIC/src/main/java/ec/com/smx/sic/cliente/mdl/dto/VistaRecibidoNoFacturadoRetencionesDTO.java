package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

public class VistaRecibidoNoFacturadoRetencionesDTO extends SearchDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numeroRetencion;
	private Date fechaRetencion;
	private String numeroFactura;
	private String codigoProveedor;
	private String xml;
	
	public String getNumeroRetencion() {
		return numeroRetencion;
	}
	public void setNumeroRetencion(String numeroRetencion) {
		this.numeroRetencion = numeroRetencion;
	}
	public Date getFechaRetencion() {
		return fechaRetencion;
	}
	public void setFechaRetencion(Date fechaRetencion) {
		this.fechaRetencion = fechaRetencion;
	}
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	
	
}
