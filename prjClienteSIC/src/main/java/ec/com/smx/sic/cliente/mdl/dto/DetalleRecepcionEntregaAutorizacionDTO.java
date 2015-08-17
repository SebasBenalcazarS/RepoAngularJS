package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

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
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.autorizaciones.dto.AutorizacionDTO;

/**
 * Almacena informacion de la autorizacion del furgon del proveedor para la recepcion
 * 
 * @author lguaman
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SBLOGTDETRECENTAUT")
public class DetalleRecepcionEntregaAutorizacionDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla DetalleRecepcionEntregaAutorizacion
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DetalleRecepcionEntregaAutorizacionID id = new ec.com.smx.sic.cliente.mdl.dto.id.DetalleRecepcionEntregaAutorizacionID();
	
	/**
	 * Fk de la tabla Detalle Recepcion Entrega
	 * 
	 */
	@Column(name = "CODIGODETALLERECEPCIONENTREGA", nullable = false)
	private java.lang.Long codigoDetalleRecepcionEntrega;
	
	
	/**
	 * codigo de la autorizacion
	 * 
	 */
	@Column(name = "CODIGOAUTORIZACION", nullable=false)
	private Long codigoAutorizacion;
	
	/**
	 * Representa el codigo del sistema de la autorizacion
	 */
	@Column(name="CODIGOSISTEMA", nullable=false)
	private String codigoSistema;
	
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
	//@RegisterUserIdField
	@Column(name = "USUARIOREGISTRO")
	private String idUsuarioRegistro;

	
	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	//@LastModifierUserIdField
	@Column(name = "USUARIOMODIFICACION")
	private String idUsuarioModificacion;
	
	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
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
	
	/**
	 * Referencia con la tabla RecepcionFurgon
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGODETALLERECEPCIONENTREGA", referencedColumnName = "CODIGODETALLERECEPCIONENTREGA", insertable = false, updatable = false) })
	private DetalleRecepcionEntregaDTO detalleRecepcionEntrega;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.DetalleRecepcionEntregaAutorizacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.DetalleRecepcionEntregaAutorizacionID id) {
		this.id = id;
	}

	/**
	 * @return the codigoAutorizacion
	 */
	public Long getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	/**
	 * @param codigoAutorizacion the codigoAutorizacion to set
	 */
	public void setCodigoAutorizacion(Long codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}

	/**
	 * @return the codigoSistema
	 */
	public String getCodigoSistema() {
		return codigoSistema;
	}

	/**
	 * @param codigoSistema the codigoSistema to set
	 */
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the usuarioCreacion
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * @param usuarioCreacion the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * @return the usuarioActualizacion
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioActualizacion() {
		return usuarioActualizacion;
	}

	/**
	 * @param usuarioActualizacion the usuarioActualizacion to set
	 */
	public void setUsuarioActualizacion(ec.com.smx.framework.security.dto.UserDto usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	/**
	 * @return the autorizacionDTO
	 */
	public AutorizacionDTO getAutorizacionDTO() {
		return autorizacionDTO;
	}

	/**
	 * @param autorizacionDTO the autorizacionDTO to set
	 */
	public void setAutorizacionDTO(AutorizacionDTO autorizacionDTO) {
		this.autorizacionDTO = autorizacionDTO;
	}

	/**
	 * @return the codigoDetalleRecepcionEntrega
	 */
	public java.lang.Long getCodigoDetalleRecepcionEntrega() {
		return codigoDetalleRecepcionEntrega;
	}

	/**
	 * @param codigoDetalleRecepcionEntrega the codigoDetalleRecepcionEntrega to set
	 */
	public void setCodigoDetalleRecepcionEntrega(java.lang.Long codigoDetalleRecepcionEntrega) {
		this.codigoDetalleRecepcionEntrega = codigoDetalleRecepcionEntrega;
	}

	/**
	 * @return the detalleRecepcionEntrega
	 */
	public DetalleRecepcionEntregaDTO getDetalleRecepcionEntrega() {
		return detalleRecepcionEntrega;
	}

	/**
	 * @param detalleRecepcionEntrega the detalleRecepcionEntrega to set
	 */
	public void setDetalleRecepcionEntrega(DetalleRecepcionEntregaDTO detalleRecepcionEntrega) {
		this.detalleRecepcionEntrega = detalleRecepcionEntrega;
	}

}