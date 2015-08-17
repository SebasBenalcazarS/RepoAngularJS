/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.TipoArticuloID;

/**
 * @author fmunoz
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSPETTIPART")
public class TipoArticuloDTO extends SimpleAuditDTO {

	@EmbeddedId
	private TipoArticuloID id;
	/**
	 * Descripción del tipo de artículo
	 * 
	 */
	private String descripcionTipoArticulo;

	/**
	 * Estado del tipo de artículo, los valores pueden ser: [1] Activo, [0] Inactivo
	 * 
	 */
	private String estadoTipoArticulo;

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
	
	
	@OneToMany(mappedBy = "tipoArticuloDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<EstadoTipoArticuloDTO> estadoTipoArticuloDTOCol;

	public TipoArticuloDTO() {
		this.id = new TipoArticuloID();
	}
	public TipoArticuloDTO(Boolean initID) {
		this.id = new TipoArticuloID(initID);
	}

	/**
	 * @return the id
	 */
	public TipoArticuloID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(TipoArticuloID id) {
		this.id = id;
	}

	/**
	 * @return the descripcionTipoArticulo
	 */
	public String getDescripcionTipoArticulo() {
		return descripcionTipoArticulo;
	}

	/**
	 * @param descripcionTipoArticulo the descripcionTipoArticulo to set
	 */
	public void setDescripcionTipoArticulo(String descripcionTipoArticulo) {
		this.descripcionTipoArticulo = descripcionTipoArticulo != null ? descripcionTipoArticulo.toUpperCase() : null;
	}

	/**
	 * @return the estadoTipoArticulo
	 */
	public String getEstadoTipoArticulo() {
		return estadoTipoArticulo;
	}

	/**
	 * @param estadoTipoArticulo the estadoTipoArticulo to set
	 */
	public void setEstadoTipoArticulo(String estadoTipoArticulo) {
		this.estadoTipoArticulo = estadoTipoArticulo;
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
	
	public Collection<EstadoTipoArticuloDTO> getEstadoTipoArticuloDTOCol() {
		return estadoTipoArticuloDTOCol;	
	}
	
	public void setEstadoTipoArticuloDTOCol(Collection<EstadoTipoArticuloDTO> estadoTipoArticuloDTOCol) {
		this.estadoTipoArticuloDTOCol = estadoTipoArticuloDTOCol;
	}	
}
