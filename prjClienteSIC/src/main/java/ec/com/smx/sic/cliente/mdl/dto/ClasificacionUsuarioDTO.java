package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.smx.sic.cliente.mdl.dto.id.ClasificacionUsuarioID;
import ec.com.smx.sic.cliente.mdl.nopersistente.ClasificacionUsuarioTransient;

/**
 * Entidad que almacena las clasificaciones que los usuarios tienen acceso para ciertos procesos
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSPETCLAUSU")
public class ClasificacionUsuarioDTO extends ClasificacionUsuarioTransient {
	/**
	 * id
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ClasificacionUsuarioID id;

	/**
	 * Estado de la clasificacion configurada, los valores pueden ser: - [0] INACTIVO - [1] ACTIVO
	 * 
	 */
	@ComparatorTypeField
	@Column (name = "ESTADOCLAUSU")
	private String estadoClasificacionUsuario;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realiza la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO clasificacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto user;

	public ClasificacionUsuarioDTO() {
		id = new ClasificacionUsuarioID();
	}
	public ClasificacionUsuarioDTO(Boolean initID) {
		id = new ClasificacionUsuarioID(initID);
	}
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ClasificacionUsuarioID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ClasificacionUsuarioID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>estadoClasificacionUsuario</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoClasificacionUsuario</code>
	 */
	public String getEstadoClasificacionUsuario() {
		return this.estadoClasificacionUsuario;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoClasificacionUsuario</code>.
	 * 
	 * @param estadoClasificacionUsuario1
	 *            El valor a establecer para la propiedad <code>estadoClasificacionUsuario</code>.
	 */
	public void setEstadoClasificacionUsuario(String estadoClasificacionUsuario1) {
		this.estadoClasificacionUsuario = estadoClasificacionUsuario1;

		if (estadoClasificacionUsuario != null && estadoClasificacionUsuario.length() > 1) {
			estadoClasificacionUsuario = estadoClasificacionUsuario.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion() {
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

	}

	/**
	 * Retorna valor de propiedad <code>user</code>
	 * 
	 * @return Retorna valor de propiedad <code>user</code>
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUser() {
		return this.user;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>user</code>.
	 * 
	 * @param user1
	 *            El valor a establecer para la propiedad <code>user</code>.
	 */
	public void setUser(ec.com.smx.frameworkv2.security.dto.UserDto user1) {
		this.user = user1;
	}

	/**
	 * Retorna valor de propiedad <code>clasificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>clasificacion</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO getClasificacion() {
		return this.clasificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>clasificacion</code>.
	 * 
	 * @param clasificacion1
	 *            El valor a establecer para la propiedad <code>clasificacion</code>.
	 */
	public void setClasificacion(ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO clasificacion1) {
		this.clasificacion = clasificacion1;
	}


}
