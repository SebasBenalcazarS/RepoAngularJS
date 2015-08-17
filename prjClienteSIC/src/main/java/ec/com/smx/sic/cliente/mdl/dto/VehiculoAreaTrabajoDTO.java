
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
import ec.com.smx.corpv2.dto.VehiculoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VehiculoAreaTrabajoID;

/**
 * Entidad que especifica la relacion entre vehiculo a area de trabajo
 *
 * @author egudino
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTVEHARETRA")
public class VehiculoAreaTrabajoDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla VehiculoAreaTrabajoDTO
	 *
	 */
	@EmbeddedId
	private VehiculoAreaTrabajoID id = new VehiculoAreaTrabajoID();
	
	/**
	 * Especifica el codigo de vehiculo cabezal
	 *
	 */
	@Column(name="CODIGOVEHICULO")
	private java.lang.Long codigoVehiculo ;
	
	/**
	 * Especifica el local asignado al cabezal
	 *
	 */
	@Column(name="CODIGOAREATRABAJOLOC")
	private Integer codigoAreaTrabajoLoc ;
	
	/**
	 * Especifica la bodega asignada al cabezal
	 *
	 */
	@Column(name="CODIGOAREATRABAJOBOD")
	private Integer codigoAreaTrabajoBod ;
	
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
	@JoinColumn(name="CODIGOVEHICULO", insertable=false, updatable=false, referencedColumnName="CODIGOVEHICULO")})
	private VehiculoDTO vehiculoDTO;
	
	/**
	 * Relacion con la tabla area trabajo 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOAREATRABAJOLOC", insertable=false, updatable=false, referencedColumnName="CODIGOAREATRABAJO")})
	private AreaTrabajoDTO areaTrabajoLocDTO;
	
	/**
	 * Relacion con la tabla area trabajo 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOAREATRABAJOBOD", insertable=false, updatable=false, referencedColumnName="CODIGOAREATRABAJO")})
	private AreaTrabajoDTO areaTrabajoBodDTO;
	
	
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
	
	
	
		
	public VehiculoAreaTrabajoDTO() {
		
	}

	/**
	 * @return the id
	 */
	public VehiculoAreaTrabajoID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(VehiculoAreaTrabajoID id) {
		this.id = id;
	}


	/**
	 * @return the codigoVehiculo
	 */
	public java.lang.Long getCodigoVehiculo() {
		return codigoVehiculo;
	}

	/**
	 * @param codigoVehiculo the codigoVehiculo to set
	 */
	public void setCodigoVehiculo(java.lang.Long codigoVehiculo) {
		this.codigoVehiculo = codigoVehiculo;
	}

	/**
	 * @return the codigoAreaTrabajoBod
	 */
	public Integer getCodigoAreaTrabajoBod() {
		return codigoAreaTrabajoBod;
	}

	/**
	 * @param codigoAreaTrabajoBod the codigoAreaTrabajoBod to set
	 */
	public void setCodigoAreaTrabajoBod(Integer codigoAreaTrabajoBod) {
		this.codigoAreaTrabajoBod = codigoAreaTrabajoBod;
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
	 * @return the vehiculoDTO
	 */
	public VehiculoDTO getVehiculoDTO() {
		return vehiculoDTO;
	}

	/**
	 * @param vehiculoDTO the vehiculoDTO to set
	 */
	public void setVehiculoDTO(VehiculoDTO vehiculoDTO) {
		this.vehiculoDTO = vehiculoDTO;
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

	/**
	 * @return the areaTrabajoBodDTO
	 */
	public AreaTrabajoDTO getAreaTrabajoBodDTO() {
		return areaTrabajoBodDTO;
	}

	/**
	 * @param areaTrabajoBodDTO the areaTrabajoBodDTO to set
	 */
	public void setAreaTrabajoBodDTO(AreaTrabajoDTO areaTrabajoBodDTO) {
		this.areaTrabajoBodDTO = areaTrabajoBodDTO;
	}
	
}