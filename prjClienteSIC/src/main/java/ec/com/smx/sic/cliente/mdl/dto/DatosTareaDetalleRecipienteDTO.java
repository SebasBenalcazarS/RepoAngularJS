/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
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
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.DatosTareaDetalleRecipienteID;

/**
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTDATTARDETRCI")
public class DatosTareaDetalleRecipienteDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	DatosTareaDetalleRecipienteID id = new DatosTareaDetalleRecipienteID();
	
	@Column(name = "CODIGODATOSTAREA", nullable = false)
	private java.lang.Long codigoDatosTarea;
	
	@Column(name = "CODIGODETCONRECTAR", nullable = false)
	private Long codigoControlRecipienteDetalleTara;
	
	/**
	 * ESTADO
	 */
	@Column(name="ESTADO")
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	@Column(insertable=false)
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	@Column(insertable=false)
	private java.sql.Timestamp fechaModificacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGODATOSTAREA", referencedColumnName="CODIGODATOSTAREA", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO datosTareaDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGODETCONRECTAR", referencedColumnName="CODIGODETCONRECTAR", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO controlRecipienteTaraDetalleDTO;
	
	/****************************************************************************
	 * SETTERS & GETTERS
	 ****************************************************************************/
	/**
	 * @return the id
	 */
	public DatosTareaDetalleRecipienteID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(DatosTareaDetalleRecipienteID id) {
		this.id = id;
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

	/**
	 * @return the codigoControlRecipienteDetalleTara
	 */
	public Long getCodigoControlRecipienteDetalleTara() {
		return codigoControlRecipienteDetalleTara;
	}

	/**
	 * @param codigoControlRecipienteDetalleTara the codigoControlRecipienteDetalleTara to set
	 */
	public void setCodigoControlRecipienteDetalleTara(Long codigoControlRecipienteDetalleTara) {
		this.codigoControlRecipienteDetalleTara = codigoControlRecipienteDetalleTara;
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
	 * @return the controlRecipienteTaraDetalleDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO getControlRecipienteTaraDetalleDTO() {
		return controlRecipienteTaraDetalleDTO;
	}

	/**
	 * @param controlRecipienteTaraDetalleDTO the controlRecipienteTaraDetalleDTO to set
	 */
	public void setControlRecipienteTaraDetalleDTO(ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO controlRecipienteTaraDetalleDTO) {
		this.controlRecipienteTaraDetalleDTO = controlRecipienteTaraDetalleDTO;
	}
	
}
