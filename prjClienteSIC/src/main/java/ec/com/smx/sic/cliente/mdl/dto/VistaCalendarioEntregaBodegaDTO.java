package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Time;
import java.util.Collection;

import javax.persistence.EmbeddedId;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaCalendarioEntregaBodegaID;

@SuppressWarnings("serial")
public class VistaCalendarioEntregaBodegaDTO extends SearchDTO{
	@EmbeddedId
	private VistaCalendarioEntregaBodegaID id = new VistaCalendarioEntregaBodegaID();
	private String codigoJDE;
	private String nombreProveedor;
	private String descripcionAreaTrabajo;
	private Integer codigoAreaTrabajo;	
	private Integer diaSemana;
	private Integer diaMes;
	private Integer mes;
	private Integer anio;
	private String fechaCalendario;
	private Time horaInicio;
	private Integer codigoTipoSeccion;
	private String valorTipoSeccion;
	private Integer cantidadUtilizada;
	private Integer cantidadPlanificada;
	private Integer cantidadDisponible;
	private Integer cantidadFurgones;
	private Integer cantidadAutorizada;
	private Integer cantidadBultos;
	private String codigoSistema;
	private Long codigoAutorizacion;
	private Boolean tieneAutorizacion; 
	private Collection<VistaDatosSolicitudDTO> datosSolicitud;
	
	public VistaCalendarioEntregaBodegaID getId() {
		return id;
	}
	public void setId(VistaCalendarioEntregaBodegaID id) {
		this.id = id;
	}
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
	public Integer getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}
	public Integer getDiaMes() {
		return diaMes;
	}
	public void setDiaMes(Integer diaMes) {
		this.diaMes = diaMes;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public String getFechaCalendario() {
		return fechaCalendario;
	}
	public void setFechaCalendario(String fechaCalendario) {
		this.fechaCalendario = fechaCalendario;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Integer getCodigoTipoSeccion() {
		return codigoTipoSeccion;
	}
	public void setCodigoTipoSeccion(Integer codigoTipoSeccion) {
		this.codigoTipoSeccion = codigoTipoSeccion;
	}
	public String getValorTipoSeccion() {
		return valorTipoSeccion;
	}
	public void setValorTipoSeccion(String valorTipoSeccion) {
		this.valorTipoSeccion = valorTipoSeccion;
	}
	public Integer getCantidadUtilizada() {
		return cantidadUtilizada;
	}
	public void setCantidadUtilizada(Integer cantidadUtilizada) {
		this.cantidadUtilizada = cantidadUtilizada;
	}
	public Integer getCantidadPlanificada() {
		return cantidadPlanificada;
	}
	public void setCantidadPlanificada(Integer cantidadPlanificada) {
		this.cantidadPlanificada = cantidadPlanificada;
	}
	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}
	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
	public Integer getCantidadFurgones() {
		return cantidadFurgones;
	}
	public void setCantidadFurgones(Integer cantidadFurgones) {
		this.cantidadFurgones = cantidadFurgones;
	}
	public Integer getCantidadAutorizada() {
		return cantidadAutorizada;
	}
	public void setCantidadAutorizada(Integer cantidadAutorizada) {
		this.cantidadAutorizada = cantidadAutorizada;
	}
	public Integer getCantidadBultos() {
		return cantidadBultos;
	}
	public void setCantidadBultos(Integer cantidadBultos) {
		this.cantidadBultos = cantidadBultos;
	}
	public Collection<VistaDatosSolicitudDTO> getDatosSolicitud() {
		return datosSolicitud;
	}
	public void setDatosSolicitud(Collection<VistaDatosSolicitudDTO> datosSolicitud) {
		this.datosSolicitud = datosSolicitud;
	}
	public String getCodigoSistema() {
		return codigoSistema;
	}
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}
	public Long getCodigoAutorizacion() {
		return codigoAutorizacion;
	}
	public void setCodigoAutorizacion(Long codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}
	public String getDescripcionAreaTrabajo() {
		return descripcionAreaTrabajo;
	}
	public void setDescripcionAreaTrabajo(String descripcionAreaTrabajo) {
		this.descripcionAreaTrabajo = descripcionAreaTrabajo;
	}
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}
	public Boolean getTieneAutorizacion() {
		return tieneAutorizacion;
	}
	public void setTieneAutorizacion(Boolean tieneAutorizacion) {
		this.tieneAutorizacion = tieneAutorizacion;
	}
	
}
