
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
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * Almacena informacion referente a los datos de la tabla tarea datos tarea 
 *
 * @author guvidia
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTTARDATTAR")
public class TareaDatosTareaDTO extends SimpleAuditDTO {
	
	/**
	 * Clave primaria de la tabla DatosTarea
	 *
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.TareaDatosTareaID id = new ec.com.smx.sic.cliente.mdl.dto.id.TareaDatosTareaID();
	
	/**
	 * Codigo de la tabla DatosTarea
	 * 
	 */
	@Column(name = "CODIGOTAREA", nullable = false)
	private java.lang.Long codigoTarea;

	/**
	 * Codigo de la tabla DatosTarea
	 * 
	 */
	@Column(name = "CODIGODATOSTAREA", nullable = false)
	private java.lang.Long codigoDatosTarea;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column(name="FECHAREGISTRO")
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="FECHAMODIFICACION")
	@LastModificationDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaModificacion;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioModificacion;
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 *
	 */
	@Column
	@ComparatorTypeField
	private String estado ;

	/**
	 * Referencia con la tabla tarea
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOTAREA", referencedColumnName = "CODIGOTAREA", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.TareaDTO tareaDTO;
	
	/**
	 * Referencia con la tabla datos tarea
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGODATOSTAREA", referencedColumnName = "CODIGODATOSTAREA", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO datosTareaDTO;

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
	private ec.com.smx.framework.security.dto.UserDto usuarioModificacion;

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.TareaDatosTareaID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ec.com.smx.sic.cliente.mdl.dto.id.TareaDatosTareaID id1 ){
		this.id=id1;
	}

	/**
	 * @return the datosTareaDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO getDatosTareaDTO() {
		return datosTareaDTO;
	}

	/**
	 * @param datosTareaDTO the datosTareaDTO to set
	 */
	public void setDatosTareaDTO(ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO datosTareaDTO) {
		this.datosTareaDTO = datosTareaDTO;
	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.util.Date getFechaRegistro(){
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * @param fechaRegistro1 
	 *		El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro( java.util.Date fechaRegistro1 ){
		this.fechaRegistro=fechaRegistro1;
		
	}	

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro(){
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * @param idUsuarioRegistro1 
	 *		El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro( String idUsuarioRegistro1 ){
		this.idUsuarioRegistro=idUsuarioRegistro1;
		
		if(idUsuarioRegistro!=null && idUsuarioRegistro.length()>32){
			idUsuarioRegistro = idUsuarioRegistro.substring(0,32);
		}		
	}


	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.util.Date getFechaModificacion(){
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * @param fechaModificacion1 
	 *		El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion( java.util.Date fechaModificacion1 ){
		this.fechaModificacion=fechaModificacion1;
		
	}


	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion(){
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * @param idUsuarioModificacion1 
	 *		El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion( String idUsuarioModificacion1 ){
		this.idUsuarioModificacion=idUsuarioModificacion1;
		
		if(idUsuarioModificacion!=null && idUsuarioModificacion.length()>32){
			idUsuarioModificacion = idUsuarioModificacion.substring(0,32);
		}
					
	}

	/**
	 * @return the tareaDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.TareaDTO getTareaDTO() {
		return tareaDTO;
	}

	/**
	 * @param tareaDTO the tareaDTO to set
	 */
	public void setTareaDTO(ec.com.smx.sic.cliente.mdl.dto.TareaDTO tareaDTO) {
		this.tareaDTO = tareaDTO;
	}

	/**
	 * Retorna valor de propiedad <code>usuarioCreacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioCreacion</code>
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion(){
		return this.usuarioCreacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioCreacion</code>.
	 * @param usuarioCreacion1 
	 *		El valor a establecer para la propiedad <code>usuarioCreacion</code>.
	 */
	public void setUsuarioCreacion( ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion1 ){
		this.usuarioCreacion=usuarioCreacion1;
	}


	/**
	 * Retorna valor de propiedad <code>usuarioModificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioModificacion</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioModificacion(){
		return this.usuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioModificacion</code>.
	 * @param usuarioModificacion1 
	 *		El valor a establecer para la propiedad <code>usuarioModificacion</code>.
	 */
	public void setUsuarioModificacion( ec.com.smx.framework.security.dto.UserDto usuarioModificacion1 ){
		this.usuarioModificacion=usuarioModificacion1;
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
	 * @return the codigoTarea
	 */
	public java.lang.Long getCodigoTarea() {
		return codigoTarea;
	}

	/**
	 * @param codigoTarea the codigoTarea to set
	 */
	public void setCodigoTarea(java.lang.Long codigoTarea) {
		this.codigoTarea = codigoTarea;
	}

	/**
	 * @return the codigoDatosTarea
	 */
	public java.lang.Long getCodigoDatosTarea() {
		return codigoDatosTarea;
	}

	/**
	 * @param codigoDatosTarea the codigoDatosTarea to set
	 */
	public void setCodigoDatosTarea(java.lang.Long codigoDatosTarea) {
		this.codigoDatosTarea = codigoDatosTarea;
	}

}