package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

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
import ec.com.smx.sic.cliente.mdl.dto.id.ClasificacionRelacionadaID;
import ec.com.smx.sic.cliente.mdl.nopersistente.ClasificacionTransient;

/**
 * 
 * @author fcollaguazo
 *
 */
@Entity
@Table(name="SCSPETCLAREL")
@SuppressWarnings("serial")
public class ClasificacionRelacionadaDTO extends ClasificacionTransient{
	
	/**
	 * identificador
	 */
	@EmbeddedId
	private ClasificacionRelacionadaID id;
	
	public ClasificacionRelacionadaDTO(){
		id = new ClasificacionRelacionadaID();
	}
	
	@ComparatorTypeField
	private String codigoClasificacion;
	
	@ComparatorTypeField
	private String codigoClasificacionRelacionada;
	
	@ComparatorTypeField
	private String codigoSubClasificacion;
	
	@ComparatorTypeField
	private String estadoClasificacionRelacionada;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@ComparatorTypeField
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@ComparatorTypeField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	/**
	 * Referencia con la clasificacion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false) })
	private ClasificacionDTO clasificacion;
	
	/**
	 * Referencia con la clasificacion relacion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOCLASIFICACIONRELACIONADA", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false) })
	private ClasificacionDTO clasificacionRelacionada;
	
	/**
	 * Relacion con la subclasificacion
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOSUBCLASIFICACION", referencedColumnName = "CODIGOSUBCLASIFICACION", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false) })
	private SubClasificacionDTO subClasificacion;

	/**
	 * @return the codigoSubClasificacion
	 */
	public String getCodigoSubClasificacion() {
		return codigoSubClasificacion;
	}

	/**
	 * @param codigoSubClasificacion the codigoSubClasificacion to set
	 */
	public void setCodigoSubClasificacion(String codigoSubClasificacion) {
		this.codigoSubClasificacion = codigoSubClasificacion;
	}

	/**
	 * @return the estadoClasificacionRelacionada
	 */
	public String getEstadoClasificacionRelacionada() {
		return estadoClasificacionRelacionada;
	}

	/**
	 * @param estadoClasificacionRelacionada the estadoClasificacionRelacionada to set
	 */
	public void setEstadoClasificacionRelacionada(String estadoClasificacionRelacionada) {
		this.estadoClasificacionRelacionada = estadoClasificacionRelacionada;
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
	 * @return the id
	 */
	public ClasificacionRelacionadaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ClasificacionRelacionadaID id) {
		this.id = id;
	}

	/**
	 * @return the clasificacion
	 */
	public ClasificacionDTO getClasificacion() {
		return clasificacion;
	}

	/**
	 * @param clasificacion the clasificacion to set
	 */
	public void setClasificacion(ClasificacionDTO clasificacion) {
		this.clasificacion = clasificacion;
	}

	/**
	 * @return the clasificacionRelacionada
	 */
	public ClasificacionDTO getClasificacionRelacionada() {
		return clasificacionRelacionada;
	}

	/**
	 * @param clasificacionRelacionada the clasificacionRelacionada to set
	 */
	public void setClasificacionRelacionada(ClasificacionDTO clasificacionRelacionada) {
		this.clasificacionRelacionada = clasificacionRelacionada;
	}

	/**
	 * @return the subClasificacion
	 */
	public SubClasificacionDTO getSubClasificacion() {
		return subClasificacion;
	}

	/**
	 * @param subClasificacion the subClasificacion to set
	 */
	public void setSubClasificacion(SubClasificacionDTO subClasificacion) {
		this.subClasificacion = subClasificacion;
	}

	/**
	 * @return the codigoClasificacion
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/**
	 * @param codigoClasificacion the codigoClasificacion to set
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	/**
	 * @return the codigoClasificacionRelacionada
	 */
	public String getCodigoClasificacionRelacionada() {
		return codigoClasificacionRelacionada;
	}

	/**
	 * @param codigoClasificacionRelacionada the codigoClasificacionRelacionada to set
	 */
	public void setCodigoClasificacionRelacionada(String codigoClasificacionRelacionada) {
		this.codigoClasificacionRelacionada = codigoClasificacionRelacionada;
	}
}
