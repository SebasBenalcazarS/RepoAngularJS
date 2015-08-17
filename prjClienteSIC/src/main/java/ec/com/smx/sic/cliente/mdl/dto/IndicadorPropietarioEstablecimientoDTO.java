/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.IndicadorPropietarioEstablecimientoID;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTINDPROEST")
public class IndicadorPropietarioEstablecimientoDTO extends SimpleAuditDTO{
	@EmbeddedId
	private IndicadorPropietarioEstablecimientoID id = new IndicadorPropietarioEstablecimientoID();
	private Integer codigoEstablecimiento;
	private Integer codigoAreaTrabajo;
	private Integer codigoIndicadorPropietario;
	@ComparatorTypeField
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
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOINDICADORPROPIETARIO", insertable=false, updatable=false, referencedColumnName="CODIGOINDICADORPROPIETARIO")
	})
	private IndicadorPropietarioDTO indicadorPropietarioDTO;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOESTABLECIMIENTO", insertable=false, updatable=false, referencedColumnName="CODIGOESTABLECIMIENTO")
	})
	private EstablecimientoDTO establecimientoDTO;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOAREATRABAJO", insertable=false, updatable=false, referencedColumnName="CODIGOAREATRABAJO")
	})
	private AreaTrabajoDTO areaTrabajoDTO;

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
	 * @return the codigoEstablecimiento
	 */
	public Integer getCodigoEstablecimiento() {
		return codigoEstablecimiento;
	}

	/**
	 * @param codigoEstablecimiento the codigoEstablecimiento to set
	 */
	public void setCodigoEstablecimiento(Integer codigoEstablecimiento) {
		this.codigoEstablecimiento = codigoEstablecimiento;
	}

	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	/**
	 * @return the codigoIndicadorPropietario
	 */
	public Integer getCodigoIndicadorPropietario() {
		return codigoIndicadorPropietario;
	}

	/**
	 * @param codigoIndicadorPropietario the codigoIndicadorPropietario to set
	 */
	public void setCodigoIndicadorPropietario(Integer codigoIndicadorPropietario) {
		this.codigoIndicadorPropietario = codigoIndicadorPropietario;
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
	 * @return the id
	 */
	public IndicadorPropietarioEstablecimientoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(IndicadorPropietarioEstablecimientoID id) {
		this.id = id;
	}

	/**
	 * @return the indicadorPropietarioDTO
	 */
	public IndicadorPropietarioDTO getIndicadorPropietarioDTO() {
		return indicadorPropietarioDTO;
	}

	/**
	 * @param indicadorPropietarioDTO the indicadorPropietarioDTO to set
	 */
	public void setIndicadorPropietarioDTO(
			IndicadorPropietarioDTO indicadorPropietarioDTO) {
		this.indicadorPropietarioDTO = indicadorPropietarioDTO;
	}

	/**
	 * @return the establecimientoDTO
	 */
	public EstablecimientoDTO getEstablecimientoDTO() {
		return establecimientoDTO;
	}

	/**
	 * @param establecimientoDTO the establecimientoDTO to set
	 */
	public void setEstablecimientoDTO(EstablecimientoDTO establecimientoDTO) {
		this.establecimientoDTO = establecimientoDTO;
	}

	/**
	 * @return the areaTrabajoDTO
	 */
	public AreaTrabajoDTO getAreaTrabajoDTO() {
		return areaTrabajoDTO;
	}

	/**
	 * @param areaTrabajoDTO the areaTrabajoDTO to set
	 */
	public void setAreaTrabajoDTO(AreaTrabajoDTO areaTrabajoDTO) {
		this.areaTrabajoDTO = areaTrabajoDTO;
	}

}
