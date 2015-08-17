package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Timestamp;

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
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloEstablecimientoID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author corbe
 *
 */
@Entity
@Table(name="SCARTTARTEST")
@SuppressWarnings("serial")
public class ArticuloEstablecimientoDTO extends SimpleAuditDTO{
	
	/**
	 * encapsula las propiedades Identificadoras de la clase ArticuloEstablecimientoDTO
	 */
	@EmbeddedId
	private ArticuloEstablecimientoID id = new ArticuloEstablecimientoID();
	
	/**
	 * Estado del ArticuloEstablecimiento, los valores permitidos son:[1] Activo [0] Inactivo
	 */
	@ComparatorTypeField
	private String estadoArticuloEstablecimiento;
	
	/**
	 * C�digo identificador del art�culo cup�n para el POS
	 */
	@ComparatorTypeField
	private String codigoArticuloExterno;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;
	
	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Column(updatable=false)
	private Timestamp fechaRegistro;
	
	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;
	
	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 */
	@LastModificationDateField
	private Timestamp fechaModificacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloDTO articuloDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOESTABLECIMIENTO", referencedColumnName="CODIGOESTABLECIMIENTO", insertable=false, updatable=false)})
	private EstablecimientoDTO establecimientoDTO;
	

	@Column(name = "CODIGOARTICULOESTABLECIMIENTO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCARTSECARTEST")
	private Long codigoArticuloEstablecimiento;
	
	public ArticuloEstablecimientoID getId() {
		return id;
	}

	public void setId(ArticuloEstablecimientoID id) {
		this.id = id;
	}

	public String getEstadoArticuloEstablecimiento() {
		return estadoArticuloEstablecimiento;
	}

	public void setEstadoArticuloEstablecimiento(
			String estadoArticuloEstablecimiento) {
		this.estadoArticuloEstablecimiento = estadoArticuloEstablecimiento;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}

	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}

	public EstablecimientoDTO getEstablecimientoDTO() {
		return establecimientoDTO;
	}

	public void setEstablecimientoDTO(EstablecimientoDTO establecimientoDTO) {
		this.establecimientoDTO = establecimientoDTO;
	}

	/**
	 * @return the codigoArticuloExterno
	 */
	public String getCodigoArticuloExterno() {
		return codigoArticuloExterno;
	}

	/**
	 * @param codigoArticuloExterno the codigoArticuloExterno to set
	 */
	public void setCodigoArticuloExterno(String codigoArticuloExterno) {
		this.codigoArticuloExterno = codigoArticuloExterno;
	}

	/**
	 * @return the codigoArticuloEstablecimiento
	 */
	public Long getCodigoArticuloEstablecimiento() {
		return codigoArticuloEstablecimiento;
	}

	/**
	 * @param codigoArticuloEstablecimiento the codigoArticuloEstablecimiento to set
	 */
	public void setCodigoArticuloEstablecimiento(Long codigoArticuloEstablecimiento) {
		this.codigoArticuloEstablecimiento = codigoArticuloEstablecimiento;
	}
	
	
}
