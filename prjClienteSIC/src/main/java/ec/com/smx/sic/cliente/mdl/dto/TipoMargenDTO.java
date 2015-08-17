package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * Contiene los porcentajes configurados para modificar un precio por local
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTTIPMAR")
public class TipoMargenDTO extends SimpleAuditDTO {

	/**
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.TipoMargenID id = new ec.com.smx.sic.cliente.mdl.dto.id.TipoMargenID();

	/**
	 * Descripcion corta del registro
	 * 
	 */
	private String nombre;

	/**
	 * La descripcion del registro
	 * 
	 */
	private String descripcion;

	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 * 
	 */
	@ComparatorTypeField
	private String estado;

	/**
	 * Indica si el porcentaje es para aumentar o disminuir un valor, sus valores pueden ser: [+] aumenta [-] disminuye
	 * 
	 * 
	 * 
	 * <b>Valid Values for Field</b>
	 * 
	 * <table border="1" >
	 * <tr>
	 * <td><b>Key</b></td>
	 * <td><b>Value</b></td>
	 * <td><b>Observations</b></td>
	 * </tr>
	 * 
	 * <tr>
	 * <td>MAS</td>
	 * <td>+</td>
	 * <td>mas.</td>
	 * </tr>
	 * 
	 * <tr>
	 * <td>MENOS</td>
	 * <td>-</td>
	 * <td>menos.</td>
	 * </tr>
	 * 
	 * </table>
	 */
	@ComparatorTypeField
	private String signo;

	/**
	 * Porcentaje aplicado
	 * 
	 */
	private Double porcentaje;

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
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;


	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.TipoMargenID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.TipoMargenID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>nombre</code>
	 * 
	 * @return Retorna valor de propiedad <code>nombre</code>
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>nombre</code>.
	 * 
	 * @param nombre1
	 *            El valor a establecer para la propiedad <code>nombre</code>.
	 */
	public void setNombre(String nombre1) {
		this.nombre = nombre1 != null ? nombre1.toUpperCase() : null;

		if (nombre != null && nombre.length() > 50) {
			nombre = nombre.substring(0, 50);
		}

	}

	/**
	 * Retorna valor de propiedad <code>descripcion</code>
	 * 
	 * @return Retorna valor de propiedad <code>descripcion</code>
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descripcion</code>.
	 * 
	 * @param descripcion1
	 *            El valor a establecer para la propiedad <code>descripcion</code>.
	 */
	public void setDescripcion(String descripcion1) {
		this.descripcion = descripcion1 != null ? descripcion1.toUpperCase() : null;

		if (descripcion != null && descripcion.length() > 200) {
			descripcion = descripcion.substring(0, 200);
		}

	}

	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * 
	 * @return Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * 
	 * @param estado1
	 *            El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado(String estado1) {
		this.estado = estado1;

		if (estado != null && estado.length() > 1) {
			estado = estado.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>signo</code>
	 * 
	 * @return Retorna valor de propiedad <code>signo</code>
	 */
	public String getSigno() {
		return this.signo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>signo</code>.
	 * 
	 * @param signo1
	 *            El valor a establecer para la propiedad <code>signo</code>.
	 */
	public void setSigno(String signo1) {
		this.signo = signo1;

		if (signo != null && signo.length() > 1) {
			signo = signo.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>porcentaje</code>
	 * 
	 * @return Retorna valor de propiedad <code>porcentaje</code>
	 */
	public Double getPorcentaje() {
		return this.porcentaje;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>porcentaje</code>.
	 * 
	 * @param porcentaje1
	 *            El valor a establecer para la propiedad <code>porcentaje</code>.
	 */
	public void setPorcentaje(Double porcentaje1) {
		this.porcentaje = porcentaje1;

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
}
