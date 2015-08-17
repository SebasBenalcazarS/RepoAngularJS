package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@Embeddable
@SuppressWarnings("serial")
public class VistaAutorizacionMasivaID extends BaseID{
	private Integer numerofila;
	private String numeroCaso;
	private Long codigoAutorizacion;
	private Long codigoDetalleEntregaProveedor;
	private Integer cantidadSolicitada;
	private String codigoSistema;
	private Long codigoHoraCalendario;
	
	public String getNumeroCaso() {
		return numeroCaso;
	}
	public void setNumeroCaso(String numeroCaso) {
		this.numeroCaso = numeroCaso;
	}
	public Long getCodigoAutorizacion() {
		return codigoAutorizacion;
	}
	public void setCodigoAutorizacion(Long codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}
	public Long getCodigoDetalleEntregaProveedor() {
		return codigoDetalleEntregaProveedor;
	}
	public void setCodigoDetalleEntregaProveedor(Long codigoDetalleEntregaProveedor) {
		this.codigoDetalleEntregaProveedor = codigoDetalleEntregaProveedor;
	}
	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(Integer cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
	public String getCodigoSistema() {
		return codigoSistema;
	}
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}
	public void setCodigoHoraCalendario(Long codigoHoraCalendario) {
		this.codigoHoraCalendario = codigoHoraCalendario;
	}
	public Long getCodigoHoraCalendario() {
		return codigoHoraCalendario;
	}
	public Integer getNumerofila() {
		return numerofila;
	}
	public void setNumerofila(Integer numerofila) {
		this.numerofila = numerofila;
	}
	
	
}
