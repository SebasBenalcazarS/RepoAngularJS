
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
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.FurgonAreaTrabajoID;

/**
 * Entidad que especifica la relacion entre furgon a area de trabajo
 *
 * @author egudino
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTFURARETRA")
public class FurgonAreaTrabajoDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla FurgonAreaTrabajoDTO
	 *
	 */
	@EmbeddedId
	private FurgonAreaTrabajoID id = new FurgonAreaTrabajoID();
	
	/**
	 * Especifica el codigo de furgon
	 *
	 */
	@Column(name="CODIGOFURGON")
	private Integer codigoFurgon ;
	
	/**
	 * Especifica el local asignado al furgon
	 *
	 */
	@Column(name="CODIGOAREATRABAJOLOC")
	private Integer codigoAreaTrabajoLoc ;
	
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
	 * Relacion con la tabla furgon 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOFURGON", insertable=false, updatable=false, referencedColumnName="CODIGOFURGON")})
	private FurgonDTO furgonDTO;
	
	/**
	 * Relacion con la tabla area trabajo 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOAREATRABAJOLOC", insertable=false, updatable=false, referencedColumnName="CODIGOAREATRABAJO")})
	private AreaTrabajoDTO areaTrabajoLocDTO;
	
	
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
	
	
	
		
	public FurgonAreaTrabajoDTO() {
		
	}

	/**
	 * @return the id
	 */
	public FurgonAreaTrabajoID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(FurgonAreaTrabajoID id) {
		this.id = id;
	}


	/**
	 * @return the codigoFurgon
	 */
	public Integer getCodigoFurgon() {
		return codigoFurgon;
	}

	/**
	 * @param codigoFurgon the codigoFurgon to set
	 */
	public void setCodigoFurgon(Integer codigoFurgon) {
		this.codigoFurgon = codigoFurgon;
	}

	/**
	 * @return the codigoAreaTrabajoLoc
	 */
	public Integer getCodigoAreaTrabajoLoc() {
		return codigoAreaTrabajoLoc;
	}

	/**
	 * @param codigoAreaTrabajoLoc the codigoAreaTrabajoLoc to set
	 */
	public void setCodigoAreaTrabajoLoc(Integer codigoAreaTrabajoLoc) {
		this.codigoAreaTrabajoLoc = codigoAreaTrabajoLoc;
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
		this.observacion = observacion;
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
	 * @return the furgonDTO
	 */
	public FurgonDTO getFurgonDTO() {
		return furgonDTO;
	}

	/**
	 * @param furgonDTO the furgonDTO to set
	 */
	public void setFurgonDTO(FurgonDTO furgonDTO) {
		this.furgonDTO = furgonDTO;
	}

	/**
	 * @return the areaTrabajoLocDTO
	 */
	public AreaTrabajoDTO getAreaTrabajoLocDTO() {
		return areaTrabajoLocDTO;
	}

	/**
	 * @param areaTrabajoLocDTO the areaTrabajoLocDTO to set
	 */
	public void setAreaTrabajoLocDTO(AreaTrabajoDTO areaTrabajoLocDTO) {
		this.areaTrabajoLocDTO = areaTrabajoLocDTO;
	}

}