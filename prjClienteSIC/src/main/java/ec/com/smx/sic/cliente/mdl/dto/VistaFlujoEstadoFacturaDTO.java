package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

@SuppressWarnings("serial")
public class VistaFlujoEstadoFacturaDTO extends SearchDTO{
	private Integer codigoCompania;
	private Long codigoFactura;
	private String estadoInicialAbreviado;
	private String estadoInicialCompleto;
	private String estadoFinalAbreviado;
	private String estadoFinalCompleto;
	private Date fechaInicio;
	private Date fechaFin;
	private String nombreUsuarioEstado;
	private String nombreCompletoUsuarioEstado;
	
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
	public String getEstadoInicialAbreviado() {
		return estadoInicialAbreviado;
	}
	public void setEstadoInicialAbreviado(String estadoInicialAbreviado) {
		this.estadoInicialAbreviado = estadoInicialAbreviado;
	}
	public String getEstadoInicialCompleto() {
		return estadoInicialCompleto;
	}
	public void setEstadoInicialCompleto(String estadoInicialCompleto) {
		this.estadoInicialCompleto = estadoInicialCompleto;
	}
	public String getEstadoFinalAbreviado() {
		return estadoFinalAbreviado;
	}
	public void setEstadoFinalAbreviado(String estadoFinalAbreviado) {
		this.estadoFinalAbreviado = estadoFinalAbreviado;
	}
	public String getEstadoFinalCompleto() {
		return estadoFinalCompleto;
	}
	public void setEstadoFinalCompleto(String estadoFinalCompleto) {
		this.estadoFinalCompleto = estadoFinalCompleto;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getNombreUsuarioEstado() {
		return nombreUsuarioEstado;
	}
	public void setNombreUsuarioEstado(String nombreUsuarioEstado) {
		this.nombreUsuarioEstado = nombreUsuarioEstado;
	}
	public String getNombreCompletoUsuarioEstado() {
		return nombreCompletoUsuarioEstado;
	}
	public void setNombreCompletoUsuarioEstado(String nombreCompletoUsuarioEstado) {
		this.nombreCompletoUsuarioEstado = nombreCompletoUsuarioEstado;
	}
}
