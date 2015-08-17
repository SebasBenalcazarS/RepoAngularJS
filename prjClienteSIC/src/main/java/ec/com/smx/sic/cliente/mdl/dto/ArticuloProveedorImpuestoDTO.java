package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProveedorImpuestoID;

@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTARTPROIMT")
public class ArticuloProveedorImpuestoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ArticuloProveedorImpuestoID id = new ArticuloProveedorImpuestoID();
	
	@ComparatorTypeField
	@Column(nullable=false,insertable=true,updatable=true)
	private String estado;

	/**
	 * Indica si el impuesto es para venta (true)
	 */
	@Column(nullable=false,insertable=true,updatable=true)
	private Boolean esParaVenta;
	
	/**
	 * Indica si el impuesto es para compra (true)
	 */
	@Column(nullable=false,insertable=true,updatable=true)
	private Boolean esParaCompra;
	
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(nullable=false,insertable=true,updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false,insertable=true,updatable=false)
	private Date fechaRegistro;

	/**
	 * Id del usuario que realiza la ultima actualizacion.
	 */
	@LastModifierUserIdField
	@Column(nullable=true,insertable=false,updatable=true)
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiza la ultima actualizacion.
	 */
	@LastModificationDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true,insertable=false,updatable=true)
	private Date fechaModificacion;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ArticuloProveedorDTO articuloProveedorDTO;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ArticuloImportacionDTO articuloImportacionDTO;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOTIPOIMPUESTO", referencedColumnName="CODIGOTIPOIMPUESTO", insertable=false, updatable=false)})
	private TipoImpuestoDTO tipoImpuestoDTO;

	/**
	 * @return the id
	 */
	public ArticuloProveedorImpuestoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloProveedorImpuestoID id) {
		this.id = id;
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
	 * @return the esParaVenta
	 */
	public Boolean getEsParaVenta() {
		return esParaVenta;
	}

	/**
	 * @param esParaVenta the esParaVenta to set
	 */
	public void setEsParaVenta(Boolean esParaVenta) {
		this.esParaVenta = esParaVenta;
	}

	/**
	 * @return the esParaCompra
	 */
	public Boolean getEsParaCompra() {
		return esParaCompra;
	}

	/**
	 * @param esParaCompra the esParaCompra to set
	 */
	public void setEsParaCompra(Boolean esParaCompra) {
		this.esParaCompra = esParaCompra;
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
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
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
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the articuloProveedorDTO
	 */
	public ArticuloProveedorDTO getArticuloProveedorDTO() {
		return articuloProveedorDTO;
	}

	/**
	 * @param articuloProveedorDTO the articuloProveedorDTO to set
	 */
	public void setArticuloProveedorDTO(ArticuloProveedorDTO articuloProveedorDTO) {
		this.articuloProveedorDTO = articuloProveedorDTO;
	}

	/**
	 * @return the tipoImpuestoDTO
	 */
	public TipoImpuestoDTO getTipoImpuestoDTO() {
		return tipoImpuestoDTO;
	}

	/**
	 * @param tipoImpuestoDTO the tipoImpuestoDTO to set
	 */
	public void setTipoImpuestoDTO(TipoImpuestoDTO tipoImpuestoDTO) {
		this.tipoImpuestoDTO = tipoImpuestoDTO;
	}

	/**
	 * @return the articuloImportacionDTO
	 */
	public ArticuloImportacionDTO getArticuloImportacionDTO() {
		return articuloImportacionDTO;
	}

	/**
	 * @param articuloImportacionDTO the articuloImportacionDTO to set
	 */
	public void setArticuloImportacionDTO(ArticuloImportacionDTO articuloImportacionDTO) {
		this.articuloImportacionDTO = articuloImportacionDTO;
	}
}
