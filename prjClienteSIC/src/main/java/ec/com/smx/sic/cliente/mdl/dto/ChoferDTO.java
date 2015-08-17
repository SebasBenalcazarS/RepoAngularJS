
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
import ec.com.smx.corpv2.dto.PersonaDTO;
import ec.com.smx.corpv2.dto.TransportistaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ChoferID;

/**
 * Entidad que especifica la entidad chofer
 *
 * @author egudino
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTCHOFER")
public class ChoferDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla ChoferDTO
	 *
	 */
	@EmbeddedId
	private ChoferID id = new ChoferID();
	
	/**
	 * Especifica el codigo de transportista
	 *
	 */
	@Column(name="CODIGOTRANSPORTISTA")	
	private java.lang.Long codigoTranspotista ;
	
	/**
	 * Especifica el codigo de persona
	 *
	 */
	@Column(name="CODIGOPERSONA")
	private java.lang.Long codigoPersona ;
	
		
	/**
	 * Especifica la observacion
	 *
	 */
	@Column(name="OBSERVACION")
	private String observacion ;

			
	/**
	 * Indica el estado del registro:[ACT] activo [INA] inactivo
	 *
	 */
	@Column(name="ESTADO")
	private String estado ;
	
	/**
	 * Relacion con la tabla transportista 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOTRANSPORTISTA", insertable=false, updatable=false, referencedColumnName="CODIGOTRANSPORTISTA")})
	private TransportistaDTO transportistaDTO;
	
	/**
	 * Relacion con la tabla persona
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOPERSONA", referencedColumnName="CODIGOPERSONA", insertable=false, updatable=false)})
	private PersonaDTO personaDTO;
		
	
	/**
	 * Fecha en la que se realiza el registro
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
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaActualizacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro;

	
	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioActualizacion;
	
	
	
		
	public ChoferDTO() {
		
	}

	/**
	 * @return the id
	 */
	public ChoferID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(ChoferID id) {
		this.id = id;
	}

	/**
	 * @return the codigoTranspotista
	 */
	public java.lang.Long getCodigoTranspotista() {
		return codigoTranspotista;
	}

	/**
	 * @param codigoTranspotista the codigoTranspotista to set
	 */
	public void setCodigoTranspotista(java.lang.Long codigoTranspotista) {
		this.codigoTranspotista = codigoTranspotista;
	}

	/**
	 * @return the codigoPersona
	 */
	public java.lang.Long getCodigoPersona() {
		return codigoPersona;
	}

	/**
	 * @param codigoPersona the codigoPersona to set
	 */
	public void setCodigoPersona(java.lang.Long codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion != null ? observacion.toUpperCase() : null;
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
	 * @return the fechaActualizacion
	 */
	public java.util.Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(java.util.Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
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
	 * @return the idUsuarioActualizacion
	 */
	public String getIdUsuarioActualizacion() {
		return idUsuarioActualizacion;
	}

	/**
	 * @param idUsuarioActualizacion the idUsuarioActualizacion to set
	 */
	public void setIdUsuarioActualizacion(String idUsuarioActualizacion) {
		this.idUsuarioActualizacion = idUsuarioActualizacion;
	}

	/**
	 * @return the transportistaDTO
	 */
	public TransportistaDTO getTransportistaDTO() {
		return transportistaDTO;
	}

	/**
	 * @param transportistaDTO the transportistaDTO to set
	 */
	public void setTransportistaDTO(TransportistaDTO transportistaDTO) {
		this.transportistaDTO = transportistaDTO;
	}

	/**
	 * @return the personaDTO
	 */
	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	/**
	 * @param personaDTO the personaDTO to set
	 */
	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

}