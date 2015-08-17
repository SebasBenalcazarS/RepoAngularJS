package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.autorizaciones.dto.AutorizacionDTO;

/**
 * Almacena informacion calendario del proveedor
 * 
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCSADTAUTHORCAL")
public class AutorizacionHoraCalendarioDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla CalendarioProveedor
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.AutorizacionHoraCalendarioID id = new ec.com.smx.sic.cliente.mdl.dto.id.AutorizacionHoraCalendarioID();
	
	
	/**
	 * codigo de la autorizacion
	 * 
	 */
	@Column(name = "CODIGOAUTORIZACION", nullable=false)
	private Long codigoAutorizacion;
	
	/**
	 * Representa el codigo del sistema de la autorizacion
	 */
	@Column(name="CODIGOSISTEMA")
	private String codigoSistema;
	
	/**
	 * Secuencial de la tabla HoraCalendarioProveedor
	 * 
	 */
	@Column(name = "CODIGOHORACALENDARIO")
	private java.lang.Long codigoHoraCalendario;
	
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
	 * Referencia con la tabla CalendarioProveedor 
	 *
	 */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOHORACALENDARIO", referencedColumnName = "CODIGOHORACALENDARIO", insertable = false, updatable = false)
        })
	private HoraCalendarioDTO horaCalendarioDTO;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioActualizacion;
	
	/**
	 * Referencia con la tabla KSSEGTAUTORIZACION
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOAUTORIZACION", referencedColumnName = "CODIGOAUTORIZACION", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false)
        })
	private AutorizacionDTO autorizacionDTO;

	public ec.com.smx.sic.cliente.mdl.dto.id.AutorizacionHoraCalendarioID getId() {
		return id;
	}

	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.AutorizacionHoraCalendarioID id) {
		this.id = id;
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

	public java.lang.Long getCodigoHoraCalendario() {
		return codigoHoraCalendario;
	}

	public void setCodigoHoraCalendario(java.lang.Long codigoHoraCalendario) {
		this.codigoHoraCalendario = codigoHoraCalendario;
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

	public HoraCalendarioDTO getHoraCalendarioDTO() {
		return horaCalendarioDTO;
	}

	public void setHoraCalendarioDTO(HoraCalendarioDTO horaCalendarioDTO) {
		this.horaCalendarioDTO = horaCalendarioDTO;
	}

	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public ec.com.smx.framework.security.dto.UserDto getUsuarioActualizacion() {
		return usuarioActualizacion;
	}

	public void setUsuarioActualizacion(ec.com.smx.framework.security.dto.UserDto usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public AutorizacionDTO getAutorizacionDTO() {
		return autorizacionDTO;
	}

	public void setAutorizacionDTO(AutorizacionDTO autorizacionDTO) {
		this.autorizacionDTO = autorizacionDTO;
	}
}