package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Time;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaAutorizacionMasivaID;

@Entity
@SuppressWarnings("serial")
public class VistaAutorizacionMasivaDTO extends SearchDTO {
	@EmbeddedId
	private VistaAutorizacionMasivaID id = new VistaAutorizacionMasivaID();
//	@Transient
	private String fechaCaducidadPedido;
	
	private String codigoJDE;
	private String nombreProveedor;
	private String codigoProveedor;
	private Date fechacalendario;
	private Time horaInicio;
	private Integer codigoAreaTrabajo;
	private String descripcionAreaTrabajo;
	private String codigoCompania;
	
	public String getCodigoJDE() {
		return codigoJDE;
	}

	public void setCodigoJDE(String codigoJDE) {
		this.codigoJDE = codigoJDE;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}


	public Date getFechacalendario() {
		return fechacalendario;
	}

	public void setFechacalendario(Date fechacalendario) {
		this.fechacalendario = fechacalendario;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	public String getDescripcionAreaTrabajo() {
		return descripcionAreaTrabajo;
	}

	public void setDescripcionAreaTrabajo(String descripcionAreaTrabajo) {
		this.descripcionAreaTrabajo = descripcionAreaTrabajo;
	}

	public VistaAutorizacionMasivaID getId() {
		return id;
	}

	public void setId(VistaAutorizacionMasivaID id) {
		this.id = id;
	}

	public String getFechaCaducidadPedido() {
		return fechaCaducidadPedido;
	}

	public void setFechaCaducidadPedido(String fechaCaducidadPedido) {
		this.fechaCaducidadPedido = fechaCaducidadPedido;
	}

	public String getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
}
