package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Time;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * Almacena informacion del detalle del calendario del proveedor
 * 
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCSADTHORCAL")
public class HoraCalendarioDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla DetalleCalendarioProveedor
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.HoraCalendarioID id = new ec.com.smx.sic.cliente.mdl.dto.id.HoraCalendarioID();
	
	/**
	 * Codigo del calendario del proveedor
	 * 
	 */
	@Column(name = "CODIGOCALENDARIO", nullable = false)
	private java.lang.Long codigoCalendario;

	/**
	 * codigo asignado a un area de trabajo
	 *

	 */
	@Column(name="CODIGOAREATRABAJO", nullable=false)
	private Integer codigoAreaTrabajo ;

	/**
	 * hora inicio
	 *
	 */
	@Column
	private Time horaInicio ;

	/**
	 * hora fin
	 *
	 */
	@Column
	private Time horaFin ;
	
	/**
	 * Representa el estado.
	 * 
	 */
	@Column
	@ComparatorTypeField
	private String estado;

	/**
	 * Fecha en la que se realiza la creacion del registro
	 * 
	 */
	@Column
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;
	
	/**
	 * Fecha en la que se realiza la actualizacion del registro
	 * 
	 */
	@LastModificationDateField
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaModificacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column
	@RegisterUserIdField
	private String idUsuarioRegistro;

	
	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@Column
	@LastModifierUserIdField
	private String idUsuarioModificacion;
	
	/**
	 * Relacion con la tabla CalendarioProveedor 
	 *
	 */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOCALENDARIO", referencedColumnName = "CODIGOCALENDARIO", insertable = false, updatable = false)
        })
	private CalendarioDTO calendarioDTO;
	
	/**
	 * Referencia con la tabla AreaTrabajo
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOAREATRABAJO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false) })
	private AreaTrabajoDTO areaTrabajoDTO;
	
	/**
	 * Referencia con la tabla AutorizacionCalendarioProveedor 
	 */
	@OneToMany(mappedBy = "horaCalendarioDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<AutorizacionHoraCalendarioDTO> autorizacionHoraCalendarioDTOCol;
	
	/**
	 * Referencia con la tabla DetalleCalendarioProveedor 
	 */
	@OneToMany(mappedBy = "horaCalendarioDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleCalendarioDTO> detalleCalendarioDTOCol;

	public ec.com.smx.sic.cliente.mdl.dto.id.HoraCalendarioID getId() {
		return id;
	}

	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.HoraCalendarioID id) {
		this.id = id;
	}

	public java.lang.Long getCodigoCalendario() {
		return codigoCalendario;
	}

	public void setCodigoCalendario(java.lang.Long codigoCalendario) {
		this.codigoCalendario = codigoCalendario;
	}

	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public CalendarioDTO getCalendarioDTO() {
		return calendarioDTO;
	}

	public void setCalendarioDTO(CalendarioDTO calendarioDTO) {
		this.calendarioDTO = calendarioDTO;
	}

	public AreaTrabajoDTO getAreaTrabajoDTO() {
		return areaTrabajoDTO;
	}

	public void setAreaTrabajoDTO(AreaTrabajoDTO areaTrabajoDTO) {
		this.areaTrabajoDTO = areaTrabajoDTO;
	}

	public Collection<AutorizacionHoraCalendarioDTO> getAutorizacionHoraCalendarioDTOCol() {
		return autorizacionHoraCalendarioDTOCol;
	}

	public void setAutorizacionHoraCalendarioDTOCol(Collection<AutorizacionHoraCalendarioDTO> autorizacionHoraCalendarioDTOCol) {
		this.autorizacionHoraCalendarioDTOCol = autorizacionHoraCalendarioDTOCol;
	}

	public Collection<DetalleCalendarioDTO> getDetalleCalendarioDTOCol() {
		return detalleCalendarioDTOCol;
	}

	public void setDetalleCalendarioDTOCol(Collection<DetalleCalendarioDTO> detalleCalendarioDTOCol) {
		this.detalleCalendarioDTOCol = detalleCalendarioDTOCol;
	}
}