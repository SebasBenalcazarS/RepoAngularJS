package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@Embeddable
@SuppressWarnings("serial")
public class VistaCalendarioEntregaBodegaID extends BaseID{
	private Long codigoCalendario;
	private Long codigoHoraCalendario;
	private Long codigoDetalleCalendario;
	
	private Integer codigoCompania;
	private String codigoProveedor;
	private Integer codigoAreaTrabajoPadre;
	private Integer codigoAreaTrabajoSeleccion;

	private Integer numeroRegistro;
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	public Integer getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(Integer numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	public Long getCodigoCalendario() {
		return codigoCalendario;
	}
	public void setCodigoCalendario(Long codigoCalendario) {
		this.codigoCalendario = codigoCalendario;
	}
	public Long getCodigoHoraCalendario() {
		return codigoHoraCalendario;
	}
	public void setCodigoHoraCalendario(Long codigoHoraCalendario) {
		this.codigoHoraCalendario = codigoHoraCalendario;
	}
	public Long getCodigoDetalleCalendario() {
		return codigoDetalleCalendario;
	}
	public void setCodigoDetalleCalendario(Long codigoDetalleCalendario) {
		this.codigoDetalleCalendario = codigoDetalleCalendario;
	}
	public Integer getCodigoAreaTrabajoPadre() {
		return codigoAreaTrabajoPadre;
	}
	public void setCodigoAreaTrabajoPadre(Integer codigoAreaTrabajoPadre) {
		this.codigoAreaTrabajoPadre = codigoAreaTrabajoPadre;
	}
	public Integer getCodigoAreaTrabajoSeleccion() {
		return codigoAreaTrabajoSeleccion;
	}
	public void setCodigoAreaTrabajoSeleccion(Integer codigoAreaTrabajoSeleccion) {
		this.codigoAreaTrabajoSeleccion = codigoAreaTrabajoSeleccion;
	}
}
