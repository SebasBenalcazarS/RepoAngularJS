package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Time;
import java.util.Date;

import javax.persistence.EmbeddedId;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaEntregaDetalleCalendarioID;

@SuppressWarnings("serial")
public class VistaEntregaDetalleCalendarioDTO extends SearchDTO {
	
	@EmbeddedId
	private VistaEntregaDetalleCalendarioID id = new VistaEntregaDetalleCalendarioID();
	
	private Integer codigoAreaTrabajo;
//	private Integer codigoTipoSeccion;
//	private String valorTipoSeccion;
	private Date fechaEntrega;
	private Time horaInicio;
	private Time horaCalendario;
	private Integer cantidadUtilizada;
	private String codigoProveedor;
//	private Long codigoEntrega;
	
	/**
	 * @return the id
	 */
	public VistaEntregaDetalleCalendarioID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(VistaEntregaDetalleCalendarioID id) {
		this.id = id;
	}
	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}
	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}
//	/**
//	 * @return the valorTipoSeccion
//	 */
//	public String getValorTipoSeccion() {
//		return valorTipoSeccion;
//	}
//	/**
//	 * @param valorTipoSeccion the valorTipoSeccion to set
//	 */
//	public void setValorTipoSeccion(String valorTipoSeccion) {
//		this.valorTipoSeccion = valorTipoSeccion;
//	}
	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	/**
	 * @return the horaInicio
	 */
	public Time getHoraInicio() {
		return horaInicio;
	}
	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	/**
	 * @return the cantidadUtilizada
	 */
	public Integer getCantidadUtilizada() {
		return cantidadUtilizada;
	}
	/**
	 * @param cantidadUtilizada the cantidadUtilizada to set
	 */
	public void setCantidadUtilizada(Integer cantidadUtilizada) {
		this.cantidadUtilizada = cantidadUtilizada;
	}
	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
//	/**
//	 * @return the codigoEntrega
//	 */
//	public Long getCodigoEntrega() {
//		return codigoEntrega;
//	}
//	/**
//	 * @param codigoEntrega the codigoEntrega to set
//	 */
//	public void setCodigoEntrega(Long codigoEntrega) {
//		this.codigoEntrega = codigoEntrega;
//	}
//	/**
//	 * @return the codigoTipoSeccion
//	 */
//	public Integer getCodigoTipoSeccion() {
//		return codigoTipoSeccion;
//	}
//	/**
//	 * @param codigoTipoSeccion the codigoTipoSeccion to set
//	 */
//	public void setCodigoTipoSeccion(Integer codigoTipoSeccion) {
//		this.codigoTipoSeccion = codigoTipoSeccion;
//	}
	public Time getHoraCalendario() {
		return horaCalendario;
	}
	public void setHoraCalendario(Time horaCalendario) {
		this.horaCalendario = horaCalendario;
	}
	
}
