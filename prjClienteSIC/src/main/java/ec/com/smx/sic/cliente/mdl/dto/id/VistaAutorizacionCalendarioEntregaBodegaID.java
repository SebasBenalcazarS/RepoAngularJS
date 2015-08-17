package ec.com.smx.sic.cliente.mdl.dto.id;

public class VistaAutorizacionCalendarioEntregaBodegaID {
	private Integer codigoCompania;
	private Long codigoAutorizacion;
	private String codigoSistema;
	
	//private Long codigoCalendario;
	private Long codigoHoraCalendario;
	private Long codigoDetalleEntregaProveedor;
	//private Long codigoDetalleCalendario;
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoAutorizacion() {
		return codigoAutorizacion;
	}
	public void setCodigoAutorizacion(Long codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}
	public String getCodigoSistema() {
		return codigoSistema;
	}
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}
	public Long getCodigoHoraCalendario() {
		return codigoHoraCalendario;
	}
	public void setCodigoHoraCalendario(Long codigoHoraCalendario) {
		this.codigoHoraCalendario = codigoHoraCalendario;
	}
	public Long getCodigoDetalleEntregaProveedor() {
		return codigoDetalleEntregaProveedor;
	}
	public void setCodigoDetalleEntregaProveedor(Long codigoDetalleEntregaProveedor) {
		this.codigoDetalleEntregaProveedor = codigoDetalleEntregaProveedor;
	}
}
