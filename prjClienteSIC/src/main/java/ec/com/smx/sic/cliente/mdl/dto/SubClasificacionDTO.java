/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.SubClasificacionID;
import ec.com.smx.sic.cliente.mdl.dto.sispe.DetalleRespaldoArticuloDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.SubClasificacionTransient;

/**
 * @author mbraganza
 * 
 */
@Entity
@Table(name="SCSPETSUBCLA")
@SuppressWarnings("serial")
public class SubClasificacionDTO extends SubClasificacionTransient {
	/**
	 * identificador
	 */
	@EmbeddedId
	private SubClasificacionID id;

	private String descripcionSubClasificacion;
	
	@ComparatorTypeField
	private String estadoSubClasificacion;
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
	 * Id del usuario que realizo la ultima actualizacion
	 * 
	 */
	@LastModifierUserIdField
	@ComparatorTypeField
	private String idUsuarioModificacion;
	/**
	 * selected permite la seleccion del dto
	 */
	@Transient
	private Boolean selected = Boolean.FALSE;
	
	//Variable usada en Historial de cambios
	@Transient
	private String varSubclasificacion;
	
	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	@OneToMany(mappedBy = "subClasificacionDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloDTO> articuloCol;
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false)})
	private ClasificacionDTO clasificacionDTO;
	
	@OneToMany(mappedBy = "subClasificacionDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleRespaldoArticuloDTO> detallesRespaldosArticulos;
	
	@OneToMany(mappedBy = "subClasificacion")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ClasificacionRelacionadaDTO> clasificacionesRelacionadas;

	public ClasificacionDTO getClasificacionDTO() {
		return clasificacionDTO;
	}

	public void setClasificacionDTO(ClasificacionDTO clasificacionDTO) {
		this.clasificacionDTO = clasificacionDTO;
	}

	public SubClasificacionDTO() {
		this.id = new SubClasificacionID();
	}
	public SubClasificacionDTO(Boolean initID) {
		this.id = new SubClasificacionID(initID);
	}
	
	/**
	 * @return el descripcionSubClasificacion
	 */
	public String getDescripcionSubClasificacion() {
		return descripcionSubClasificacion;
	}

	/**
	 * @param descripcionSubClasificacion
	 *            el descripcionSubClasificacion a establecer
	 */
	public void setDescripcionSubClasificacion(String descripcionSubClasificacion) {
		this.descripcionSubClasificacion = descripcionSubClasificacion != null ? descripcionSubClasificacion.toUpperCase() : null;
	}

	/**
	 * @return el estadoSubClasificacion
	 */
	public String getEstadoSubClasificacion() {
		return estadoSubClasificacion;
	}

	/**
	 * @param estadoSubClasificacion
	 *            el estadoSubClasificacion a establecer
	 */
	public void setEstadoSubClasificacion(String estadoSubClasificacion) {
		this.estadoSubClasificacion = estadoSubClasificacion;
	}

	/**
	 * @return el id
	 */
	public SubClasificacionID getId() {
		return id;
	}

	/**
	 * @param id
	 *            el id a establecer
	 */
	public void setId(SubClasificacionID id) {
		this.id = id;
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

	public Collection<ArticuloDTO> getArticuloCol() {
		return articuloCol;
	}

	public void setArticuloCol(Collection<ArticuloDTO> articuloCol) {
		this.articuloCol = articuloCol;
	}

	public Collection<DetalleRespaldoArticuloDTO> getDetallesRespaldosArticulos() {
		return detallesRespaldosArticulos;
	}

	public void setDetallesRespaldosArticulos(
			Collection<DetalleRespaldoArticuloDTO> detallesRespaldosArticulos) {
		this.detallesRespaldosArticulos = detallesRespaldosArticulos;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public String getVarSubclasificacion() {
		this.varSubclasificacion = this.getId().getCodigoSubClasificacion().concat(" - ").concat(this.getDescripcionSubClasificacion());
		return varSubclasificacion;
	}

	public void setVarSubclasificacion(String varSubclasificacion) {
		this.varSubclasificacion = this.getId().getCodigoSubClasificacion().concat(" - ").concat(this.getDescripcionSubClasificacion());
	}

	/**
	 * @return the clasificacionesRelacionadas
	 */
	public Collection<ClasificacionRelacionadaDTO> getClasificacionesRelacionadas() {
		return clasificacionesRelacionadas;
	}

	/**
	 * @param clasificacionesRelacionadas the clasificacionesRelacionadas to set
	 */
	public void setClasificacionesRelacionadas(Collection<ClasificacionRelacionadaDTO> clasificacionesRelacionadas) {
		this.clasificacionesRelacionadas = clasificacionesRelacionadas;
	}
}
