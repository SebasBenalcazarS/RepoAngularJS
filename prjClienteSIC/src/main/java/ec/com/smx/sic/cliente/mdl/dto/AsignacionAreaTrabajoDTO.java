package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.AsignacionAreaTrabajoID;

/**
 * Almacena los detalles de las tareas de la estructura logistica
 * 
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SBLOGTASIARETRA")
public class AsignacionAreaTrabajoDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla AsignacionArticulo
	 * 
	 */
	@EmbeddedId
	private AsignacionAreaTrabajoID id;

	@Column
	private Long codigoDetalleSeccion;

	@Column
	private String codigoAreaTrabajo;

	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 * 
	 */
	@Column
	private String estado;

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
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizó la última actualización.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	/**
	 * Especifica la relacion con DetalleSeccion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGODETALLESECCION", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false) })
	private DetalleSeccionDTO detalleSeccionDTO;

	/**
	 * Especifica la relacion con DetalleSeccion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOAREATRABAJO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false) })
	private AreaTrabajoDTO areaTrabajoDTO;

	/**
	 * @return the id
	 */
	public AsignacionAreaTrabajoID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(AsignacionAreaTrabajoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoDetalleSeccion
	 */
	public Long getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}

	/**
	 * @param codigoDetalleSeccion
	 *            the codigoDetalleSeccion to set
	 */
	public void setCodigoDetalleSeccion(Long codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro
	 *            the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro
	 *            the fechaRegistro to set
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion
	 *            the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion
	 *            the fechaModificacion to set
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the detalleSeccionDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionDTO() {
		return detalleSeccionDTO;
	}

	/**
	 * @param detalleSeccionDTO
	 *            the detalleSeccionDTO to set
	 */
	public void setDetalleSeccionDTO(DetalleSeccionDTO detalleSeccionDTO) {
		this.detalleSeccionDTO = detalleSeccionDTO;
	}

	/**
	 * @return the codigoAreaTrabajo
	 */
	public String getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo
	 *            the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(String codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	/**
	 * @return the areaTrabajoDTO
	 */
	public AreaTrabajoDTO getAreaTrabajoDTO() {
		return areaTrabajoDTO;
	}

	/**
	 * @param areaTrabajoDTO
	 *            the areaTrabajoDTO to set
	 */
	public void setAreaTrabajoDTO(AreaTrabajoDTO areaTrabajoDTO) {
		this.areaTrabajoDTO = areaTrabajoDTO;
	}

}