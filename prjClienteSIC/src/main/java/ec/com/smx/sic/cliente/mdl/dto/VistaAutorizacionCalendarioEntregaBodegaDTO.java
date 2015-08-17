package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.EmbeddedId;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaAutorizacionCalendarioEntregaBodegaID;

public class VistaAutorizacionCalendarioEntregaBodegaDTO {
	@EmbeddedId
	private VistaAutorizacionCalendarioEntregaBodegaID id = new VistaAutorizacionCalendarioEntregaBodegaID();
	private String idUsuarioAutorizador;
	private String nombreUsuarioAutorizador;
	private String nombreUsuarioAutorizado;
	private String estadoAutorizacion;
	private String fechaSolicitud;
	private String nombreProveedor;
	private String descripcion;
	private String observacionAprobacion;
	private String observacionRechazo;
	private Integer cantidadAndenesAprobados;
	private Integer cantidadAndenesRechazados;
	private Integer codigoBodegaART;
	private Collection<VistaCalendarioEntregaBodegaDTO> horariosDisponibles;
	private Collection<VistaCalendarioEntregaBodegaDTO> andenesDisponibles;
	public VistaAutorizacionCalendarioEntregaBodegaID getId() {
		return id;
	}
	public void setId(VistaAutorizacionCalendarioEntregaBodegaID id) {
		this.id = id;
	}
	public String getIdUsuarioAutorizador() {
		return idUsuarioAutorizador;
	}
	public void setIdUsuarioAutorizador(String idUsuarioAutorizador) {
		this.idUsuarioAutorizador = idUsuarioAutorizador;
	}
	public String getNombreUsuarioAutorizador() {
		return nombreUsuarioAutorizador;
	}
	public void setNombreUsuarioAutorizador(String nombreUsuarioAutorizador) {
		this.nombreUsuarioAutorizador = nombreUsuarioAutorizador;
	}
	public String getEstadoAutorizacion() {
		return estadoAutorizacion;
	}
	public Integer getCodigoBodegaART() {
		return codigoBodegaART;
	}
	public void setCodigoBodegaART(Integer codigoBodegaART) {
		this.codigoBodegaART = codigoBodegaART;
	}
	public void setEstadoAutorizacion(String estadoAutorizacion) {
		this.estadoAutorizacion = estadoAutorizacion;
	}
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getObservacionAprobacion() {
		return observacionAprobacion;
	}
	public void setObservacionAprobacion(String observacionAprobacion) {
		this.observacionAprobacion = observacionAprobacion;
	}
	public String getObservacionRechazo() {
		return observacionRechazo;
	}
	public void setObservacionRechazo(String observacionRechazo) {
		this.observacionRechazo = observacionRechazo;
	}
	public Collection<VistaCalendarioEntregaBodegaDTO> getHorariosDisponibles() {
		return horariosDisponibles;
	}
	public void setHorariosDisponibles(Collection<VistaCalendarioEntregaBodegaDTO> horariosDisponibles) {
		this.horariosDisponibles = horariosDisponibles;
	}
	public Collection<VistaCalendarioEntregaBodegaDTO> getAndenesDisponibles() {
		return andenesDisponibles;
	}
	public void setAndenesDisponibles(Collection<VistaCalendarioEntregaBodegaDTO> andenesDisponibles) {
		this.andenesDisponibles = andenesDisponibles;
	}
	public Integer getCantidadAndenesAprobados() {
		return cantidadAndenesAprobados;
	}
	public void setCantidadAndenesAprobados(Integer cantidadAndenesAprobados) {
		this.cantidadAndenesAprobados = cantidadAndenesAprobados;
	}
	public Integer getCantidadAndenesRechazados() {
		return cantidadAndenesRechazados;
	}
	public void setCantidadAndenesRechazados(Integer cantidadAndenesRechazados) {
		this.cantidadAndenesRechazados = cantidadAndenesRechazados;
	}
	public String getNombreUsuarioAutorizado() {
		return nombreUsuarioAutorizado;
	}
	public void setNombreUsuarioAutorizado(String nombreUsuarioAutorizado) {
		this.nombreUsuarioAutorizado = nombreUsuarioAutorizado;
	}
}
