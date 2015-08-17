package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenSalidaControlRecipienteDetalleID;

@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTDETCONRCIORDSAL")
public class OrdenSalidaControlRecipienteDetalleDTO implements Serializable {
	/**
	 * Clave primaria
	 */
	@EmbeddedId
	private OrdenSalidaControlRecipienteDetalleID id = new OrdenSalidaControlRecipienteDetalleID();
	
	/**
	 * Relacion Codigo del recipiente
	 */
	@Column(name = "CANTIDAD")
	private Integer cantidad;
	/**
	 * Estado
	 */
	@Column(name = "ESTADO")
	private String estado;
	
	/**
	 * Datos de auditoria
	 */
	@Column(name = "USUARIOREGISTRO")
	private String idUsuarioRegistro;
	@Column(name = "FECHAREGISTRO")
	private Date fechaRegistro;
	@Column(name = "USUARIOMODIFICACION")
	private String idUsuarioModificacion;
	@Column(name = "FECHAMODIFICACION")
	private Date fechaModificacion;
	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioModificacionDTO;
	/**
	 * Referencia controlRecipienteDetalleDTO
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
					@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
					@JoinColumn(name = "CODDETCONRCI", referencedColumnName = "CODDETCONRCI", insertable = false, updatable = false)
	})
	private ControlRecipienteDetalleDTO controlRecipienteDetalleDTO;
	/**
	 * Referencia ordenSalidaRecipienteDetalleDTO
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
					@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
					@JoinColumn(name = "CODIGODETALLEORDEN", referencedColumnName = "CODIGODETALLEORDEN", insertable = false, updatable = false)
	})
	private OrdenSalidaRecipienteDetalleDTO ordenSalidaRecipienteDetalleDTO;
	
	public OrdenSalidaControlRecipienteDetalleID getId() {
		return id;
	}
	public void setId(OrdenSalidaControlRecipienteDetalleID id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}
	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}
	public UserDto getUsuarioModificacionDTO() {
		return usuarioModificacionDTO;
	}
	public void setUsuarioModificacionDTO(UserDto usuarioModificacionDTO) {
		this.usuarioModificacionDTO = usuarioModificacionDTO;
	}
	public ControlRecipienteDetalleDTO getControlRecipienteDetalleDTO() {
		return controlRecipienteDetalleDTO;
	}
	public void setControlRecipienteDetalleDTO(ControlRecipienteDetalleDTO controlRecipienteDetalleDTO) {
		this.controlRecipienteDetalleDTO = controlRecipienteDetalleDTO;
	}
	public OrdenSalidaRecipienteDetalleDTO getOrdenSalidaRecipienteDetalleDTO() {
		return ordenSalidaRecipienteDetalleDTO;
	}
	public void setOrdenSalidaRecipienteDetalleDTO(OrdenSalidaRecipienteDetalleDTO ordenSalidaRecipienteDetalleDTO) {
		this.ordenSalidaRecipienteDetalleDTO = ordenSalidaRecipienteDetalleDTO;
	}
}
