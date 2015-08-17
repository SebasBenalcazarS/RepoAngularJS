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
import ec.com.smx.sic.cliente.mdl.dto.id.ValidacionDocumentoID;
/**
 * Almacena las validaciones que tiene una factura
 * @author fnaranjo
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCFDITVALDOC")
public class ValidacionDocumentoDTO extends SimpleAuditDTO{
	@EmbeddedId
	ValidacionDocumentoID id = new ValidacionDocumentoID();
	
	private Long codigoFactura;
	
	/**
	 * Catalogo valor para los tipos de validacion de documento CT:1340 CV:VND.
	 * 
	 */
	@Column(name="CODIGOTIPOVALIDACION")
	@ComparatorTypeField
	private Integer codigoTipoValidacion;
	/**
	 * 
	 */
	@Column(name="VALORTIPOVALIDACION")
	@ComparatorTypeField
	private String valorTipoValidacion;
	
	@Column(nullable = false)
	@ComparatorTypeField
	private String estado ;
	
	@Column(name="CODIGOTIPORESULTADO")
	private Integer codigoTipoResultado;
	
	@Column(name="VALORTIPORESULTADO")
	@ComparatorTypeField
	private String valorTipoResultado;
	
	@Column(name="RESULTADOVALIDACION")
	@ComparatorTypeField
	private String resultadoValidacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	@Column(name="FECHAMODIFICACION")
	private java.util.Date fechaModificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "VALORTIPOVALIDACION", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPOVALIDACION", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO") })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoValidacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "VALORTIPORESULTADO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPORESULTADO", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO") })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoResultado;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOFACTURA", insertable = false, updatable = false, referencedColumnName = "CODIGOFACTURA") })
	private FacturaDTO facturaDTO;
	
	public ValidacionDocumentoID getId() {
		return id;
	}

	public void setId(ValidacionDocumentoID id) {
		this.id = id;
	}

	public Long getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	public Integer getCodigoTipoValidacion() {
		return codigoTipoValidacion;
	}

	public void setCodigoTipoValidacion(Integer codigoTipoValidacion) {
		this.codigoTipoValidacion = codigoTipoValidacion;
	}

	public String getValorTipoValidacion() {
		return valorTipoValidacion;
	}

	public void setValorTipoValidacion(String valorTipoValidacion) {
		this.valorTipoValidacion = valorTipoValidacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Integer getCodigoTipoResultado() {
		return codigoTipoResultado;
	}

	public void setCodigoTipoResultado(Integer codigoTipoResultado) {
		this.codigoTipoResultado = codigoTipoResultado;
	}

	public String getValorTipoResultado() {
		return valorTipoResultado;
	}

	public void setValorTipoResultado(String valorTipoResultado) {
		this.valorTipoResultado = valorTipoResultado;
	}

	public String getResultadoValidacion() {
		return resultadoValidacion;
	}

	public void setResultadoValidacion(String resultadoValidacion) {
		this.resultadoValidacion = resultadoValidacion;
	}

	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoValidacion() {
		return tipoValidacion;
	}

	public void setTipoValidacion(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoValidacion) {
		this.tipoValidacion = tipoValidacion;
	}

	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoResultado() {
		return tipoResultado;
	}

	public void setTipoResultado(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoResultado) {
		this.tipoResultado = tipoResultado;
	}

	/**
	 * @return the facturaDTO
	 */
	public FacturaDTO getFacturaDTO() {
		return facturaDTO;
	}

	/**
	 * @param facturaDTO the facturaDTO to set
	 */
	public void setFacturaDTO(FacturaDTO facturaDTO) {
		this.facturaDTO = facturaDTO;
	}
}