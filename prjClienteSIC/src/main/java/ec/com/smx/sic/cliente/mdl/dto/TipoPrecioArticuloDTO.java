package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;

/**
 * Entidad que almacena los tipos de precios que puede tener un artículo. Por ejemplo: [PVP] Precio de venta al público [BAS] Precio base [CAJ] Precio
 * de caja [MAY] Precio de mayoreo
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTTIPPREART")
public class TipoPrecioArticuloDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.TipoPrecioArticuloID id = new ec.com.smx.sic.cliente.mdl.dto.id.TipoPrecioArticuloID();

	/**
	 * Descripción del tipo de precio
	 * 
	 */
	private String descripcionTipoPrecio;

	/**
	 * Estado que indica si un tipo de precio está activo o no. Los valores permitidos son: [0] Inactivo [1] Activo
	 * 
	 */
	@ComparatorTypeField
	private String estadoTipoPrecio;

	private String nombre;
	private Integer orden;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	private String idUsuarioRegistro;

	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Fecha en la que se realizó la última actualización.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioCreacion;
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioModificacion;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.TipoPrecioArticuloID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.TipoPrecioArticuloID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>descripcionTipoPrecio</code>
	 * 
	 * @return Retorna valor de propiedad <code>descripcionTipoPrecio</code>
	 */
	public String getDescripcionTipoPrecio() {
		return this.descripcionTipoPrecio;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descripcionTipoPrecio</code>.
	 * 
	 * @param descripcionTipoPrecio1
	 *            El valor a establecer para la propiedad <code>descripcionTipoPrecio</code>.
	 */
	public void setDescripcionTipoPrecio(String descripcionTipoPrecio1) {
		this.descripcionTipoPrecio = descripcionTipoPrecio1 != null ? descripcionTipoPrecio1.toUpperCase() : null;

		if (descripcionTipoPrecio != null && descripcionTipoPrecio.length() > 100) {
			descripcionTipoPrecio = descripcionTipoPrecio.substring(0, 100);
		}

	}

	/**
	 * Retorna valor de propiedad <code>estadoTipoPrecio</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoTipoPrecio</code>
	 */
	public String getEstadoTipoPrecio() {
		return this.estadoTipoPrecio;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoTipoPrecio</code>.
	 * 
	 * @param estadoTipoPrecio1
	 *            El valor a establecer para la propiedad <code>estadoTipoPrecio</code>.
	 */
	public void setEstadoTipoPrecio(String estadoTipoPrecio1) {
		this.estadoTipoPrecio = estadoTipoPrecio1;

		if (estadoTipoPrecio != null && estadoTipoPrecio.length() > 1) {
			estadoTipoPrecio = estadoTipoPrecio.substring(0, 1);
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
	 * @return the usuarioCreacion
	 */
	public UserDto getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * @param usuarioCreacion the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(UserDto usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * @return the usuarioModificacion
	 */
	public UserDto getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(UserDto usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
