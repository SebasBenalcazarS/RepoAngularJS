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
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.EntregaCalendarioBodegaProveedorID;



/**
 * Tabla que almacena las horas y la fecha en la que se realiza una entrega.
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCFDITENTCALBODPRO")
public class EntregaCalendarioBodegaProveedorDTO extends SimpleAuditDTO {
	
	/**
	 * Clave primaria de la tabla CalendarioBodegaEntregaProveedor
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.EntregaCalendarioBodegaProveedorID id = new ec.com.smx.sic.cliente.mdl.dto.id.EntregaCalendarioBodegaProveedorID();

	/**
	 * secuencial de base
	 *

	 */
	@Column
	private java.lang.Long codigoCalBodPro ;


	/**
	 * Codigo Entrega
	 */
	@Column
	private java.lang.Long codigoEntrega ;
	
	/**
	 * Fecha en la cual se realizó la entrega
	 *

	 */
	@Transient
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaEntrega ;


	/**
	 * Id del usuario que realiza el registro
	 *

	 */
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField	
	private String idUsuarioRegistro;

	

	/**
	 * Fecha en la que se realizó la última actualización
	 *

	 */
	@RegisterDateField
	//@Temporal(TemporalType.TIMESTAMP)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 *

	 */
	@LastModificationDateField
	//@Temporal(TemporalType.TIMESTAMP)
	private java.sql.Timestamp fechaModificacion ;

	/**
	 * Id del usuario que realizó la última actualización
	 *

	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioModificacion;
	

	/**
	 * Estado del objeto: valores permitidos [ACT], [INA]
	 *

	 */
	@Column
	private String estado ;

	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCALBODPRO", referencedColumnName = "CODIGOCALBODPRO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false)})
	private CalendarioBodegaProveedorDTO calendarioBodegaProveedorDTO;



	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOENTREGA", insertable = false, updatable = false, referencedColumnName = "CODIGOENTREGA") })
	private EntregaDTO entregaDTO;



	/**
	 * clave foranea a la tabla de usuario para usuario registro
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto registerUser;



	/**
	 * clave foranea a la tabla de usuario para usuario modificacion
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto lastModifierUser;
	
	

	/**
	 * @return the codigoEntrega
	 */
	public java.lang.Long getCodigoEntrega() {
		return codigoEntrega;
	}

	/**
	 * @param codigoEntrega the codigoEntrega to set
	 */
	public void setCodigoEntrega(java.lang.Long codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	/**
	 * Retorna valor de propiedad <code>codigoCalBodPro</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoCalBodPro</code>
	 */
	public java.lang.Long getCodigoCalBodPro(){
		return this.codigoCalBodPro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCalBodPro</code>.
	 * @param codigoCalBodPro1 
	 *		El valor a establecer para la propiedad <code>codigoCalBodPro</code>.
	 */
	public void setCodigoCalBodPro( java.lang.Long codigoCalBodPro1 ){
		this.codigoCalBodPro=codigoCalBodPro1;
		
	}




	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado(){
		return this.estado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * @param estado1 
	 *		El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado( String estado1 ){
		this.estado=estado1;
		
		if(estado!=null && estado.length()>3){
			estado = estado.substring(0,3);
		}
				
				
	}
	
	/**
	 * Retorna valor de propiedad <code>calendarioBodegaProveedorDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>calendarioBodegaProveedorDTO</code>
	 */
	public CalendarioBodegaProveedorDTO getCalendarioBodegaProveedorDTO(){
		return this.calendarioBodegaProveedorDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>calendarioBodegaProveedorDTO</code>.
	 * @param calendarioBodegaProveedorDTO1 
	 *		El valor a establecer para la propiedad <code>calendarioBodegaProveedorDTO</code>.
	 */
	public void setCalendarioBodegaProveedorDTO( CalendarioBodegaProveedorDTO calendarioBodegaProveedorDTO1 ){
		this.calendarioBodegaProveedorDTO=calendarioBodegaProveedorDTO1;
	}


	/**
	 * Retorna valor de propiedad <code>registerUser</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>registerUser</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getRegisterUser(){
		return this.registerUser;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>registerUser</code>.
	 * @param registerUser1 
	 *		El valor a establecer para la propiedad <code>registerUser</code>.
	 */
	public void setRegisterUser( ec.com.smx.framework.security.dto.UserDto registerUser1 ){
		this.registerUser=registerUser1;
	}


	/**
	 * Retorna valor de propiedad <code>lastModifierUser</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>lastModifierUser</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getLastModifierUser(){
		return this.lastModifierUser;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>lastModifierUser</code>.
	 * @param lastModifierUser1 
	 *		El valor a establecer para la propiedad <code>lastModifierUser</code>.
	 */
	public void setLastModifierUser( ec.com.smx.framework.security.dto.UserDto lastModifierUser1 ){
		this.lastModifierUser=lastModifierUser1;
	}


	/**
	 * @return the entregaDTO
	 */
	public EntregaDTO getEntregaDTO() {
		return entregaDTO;
	}

	/**
	 * @param entregaDTO the entregaDTO to set
	 */
	public void setEntregaDTO(EntregaDTO entregaDTO) {
		this.entregaDTO = entregaDTO;
	}

	/**
	 * @return the id
	 */
	public EntregaCalendarioBodegaProveedorID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(EntregaCalendarioBodegaProveedorID id) {
		this.id = id;
	}

	/**
	 * @return the fechaEntrega
	 */
	public java.util.Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(java.util.Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
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
	
}

