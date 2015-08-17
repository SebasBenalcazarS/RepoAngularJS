/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.IndicadorPropietarioID;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTINDPRO")
public class IndicadorPropietarioDTO extends SimpleAuditDTO{
	@EmbeddedId
	private IndicadorPropietarioID id = new IndicadorPropietarioID();
	private String descripcion;
	@ComparatorTypeField
	private String estado;
	
	@Column(name = "CODIGOEXTERNO")
	private Integer codigoExterno;

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
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="indicadorPropietarioDTO")
	private Collection<IndicadorPropietarioEstablecimientoDTO> indicadorPropietarioEstablecimientoCol;


	/**
	 * @return the id
	 */
	public IndicadorPropietarioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(IndicadorPropietarioID id) {
		this.id = id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return the codigoExterno
	 */
	public Integer getCodigoExterno() {
		return codigoExterno;
	}

	/**
	 * @param codigoExterno the codigoExterno set
	 */
	public void setCodigoExterno(Integer codigoExterno) {
		this.codigoExterno = codigoExterno;
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
	 * @return the indicadorPropietarioEstablecimientoCol
	 */
	public Collection<IndicadorPropietarioEstablecimientoDTO> getIndicadorPropietarioEstablecimientoCol() {
		return indicadorPropietarioEstablecimientoCol;
	}

	/**
	 * @param indicadorPropietarioEstablecimientoCol the indicadorPropietarioEstablecimientoCol to set
	 */
	public void setIndicadorPropietarioEstablecimientoCol(
			Collection<IndicadorPropietarioEstablecimientoDTO> indicadorPropietarioEstablecimientoCol) {
		this.indicadorPropietarioEstablecimientoCol = indicadorPropietarioEstablecimientoCol;
	}
}
