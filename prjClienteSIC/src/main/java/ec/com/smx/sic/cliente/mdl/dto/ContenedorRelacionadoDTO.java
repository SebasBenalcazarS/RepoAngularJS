package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

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

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.ContenedorRelacionadoID;

/**
 * 
 * @author amunoz
 * @author cherrera
 * 
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTCONREL")
public class ContenedorRelacionadoDTO extends SimpleAuditDTO {
	
	/**
	 * Clave primaria de la tabla Contenedor Relacionado
	 * 
	 */
	@EmbeddedId
	private ContenedorRelacionadoID id = new ContenedorRelacionadoID();
	
	/**
	 * Corresponde al estado en el que se ecuentra el contenedor
	 *
	 */
	@Column(name="ESTADO")
	private String estado;
	
	/**
	 * Fecha de registro del contenedor
	 *
	 */
	@RegisterDateField
	@Column(name = "FECHAREGISTRO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	/**
	 * Fecha de modificacion del contenedor
	 *
	 */
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="IDUSUARIOREGISTRO")
	private String idUsuarioRegistro;
	
	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="IDUSUARIOMODIFICACION")
	private String idUsuarioModificacion;
	
	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioModificacionDTO;
	
	/**
	 * Referencia con la tabla Contenedor Padre
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCONTENEDORPADRE", referencedColumnName = "CODIGOCONTENEDOR", insertable = false, updatable = false) })
	private ContenedorDTO contenedorPadreDTO;
	
	/**
	 * Referencia con la tabla Contenedor Relacionado
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCONTENEDORRELACIONADO", referencedColumnName = "CODIGOCONTENEDOR", insertable = false, updatable = false) })
	private ContenedorDTO contenedorRelacionadoDTO;

	/**
	 * @return the id
	 */
	public ContenedorRelacionadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ContenedorRelacionadoID id) {
		this.id = id;
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
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
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
	 * @return the usuarioRegistroDTO
	 */
	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	/**
	 * @param usuarioRegistroDTO the usuarioRegistroDTO to set
	 */
	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}

	/**
	 * @return the usuarioModificacionDTO
	 */
	public UserDto getUsuarioModificacionDTO() {
		return usuarioModificacionDTO;
	}

	/**
	 * @param usuarioModificacionDTO the usuarioModificacionDTO to set
	 */
	public void setUsuarioModificacionDTO(UserDto usuarioModificacionDTO) {
		this.usuarioModificacionDTO = usuarioModificacionDTO;
	}

	/**
	 * @return the contenedorPadreDTO
	 */
	public ContenedorDTO getContenedorPadreDTO() {
		return contenedorPadreDTO;
	}

	/**
	 * @param contenedorPadreDTO the contenedorPadreDTO to set
	 */
	public void setContenedorPadreDTO(ContenedorDTO contenedorPadreDTO) {
		this.contenedorPadreDTO = contenedorPadreDTO;
	}

	/**
	 * @return the contenedorRelacionadoDTO
	 */
	public ContenedorDTO getContenedorRelacionadoDTO() {
		return contenedorRelacionadoDTO;
	}

	/**
	 * @param contenedorRelacionadoDTO the contenedorRelacionadoDTO to set
	 */
	public void setContenedorRelacionadoDTO(ContenedorDTO contenedorRelacionadoDTO) {
		this.contenedorRelacionadoDTO = contenedorRelacionadoDTO;
	}

}
