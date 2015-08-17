package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Time;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaCalendarioPlanificacionBodegaID;

@Entity
@SuppressWarnings("serial")
public class VistaCalendarioPlanificacionBodegaDTO extends SearchDTO{
	@EmbeddedId
	private VistaCalendarioPlanificacionBodegaID id = new VistaCalendarioPlanificacionBodegaID();
	private Long codigoCalendario;
	private Long codigoHoraCalendario;
	private Long codigoDetalleCalendario;
	private String codigoJDE;
	private String nombreProveedor;
	private String descripcionAreaTrabajo;
	private Integer codigoAreaTrabajo;
	private Integer diaSemana;
	private Integer diaMes;
	private Integer mes;
	private Integer anio;
	private Time horaInicio ;
	private Integer codigoTipoSeccion;
	private String valorTipoSeccion;
	private Integer cantidadDisponible;
	private Boolean tieneEntregasConfiguradas;
	private Integer codigoAutorizacionHoraCalendario;
	private String codigoReferencia;
	private String estadoDetalleCalendario;
	
	@Transient
	private String userId;
	@Transient
	private Event event;
	
	public enum Event {
		ADD, DELETE, EDIT
	}

	public VistaCalendarioPlanificacionBodegaID getId() {
		return id;
	}

	public void setId(VistaCalendarioPlanificacionBodegaID id) {
		this.id = id;
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

	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Integer getCodigoAutorizacionHoraCalendario() {
		return codigoAutorizacionHoraCalendario;
	}

	public void setCodigoAutorizacionHoraCalendario(Integer codigoAutorizacionHoraCalendario) {
		this.codigoAutorizacionHoraCalendario = codigoAutorizacionHoraCalendario;
	}

	public Boolean getTieneEntregasConfiguradas() {
		return tieneEntregasConfiguradas;
	}

	public void setTieneEntregasConfiguradas(Boolean tieneEntregasConfiguradas) {
		this.tieneEntregasConfiguradas = tieneEntregasConfiguradas;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * @return the estadoDetalleCalendario
	 */
	public String getEstadoDetalleCalendario() {
		return estadoDetalleCalendario;
	}

	/**
	 * @param estadoDetalleCalendario the estadoDetalleCalendario to set
	 */
	public void setEstadoDetalleCalendario(String estadoDetalleCalendario) {
		this.estadoDetalleCalendario = estadoDetalleCalendario;
	}
}
