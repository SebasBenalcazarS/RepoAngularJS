package ec.com.smx.sic.cliente.mdl.dto;

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
import ec.com.smx.sic.cliente.mdl.dto.id.FacturaDesgloseImpuestoID;
import static javax.persistence.FetchType.LAZY;

@SuppressWarnings("serial")
@Entity
@Table(name = "SCFDITFACTDESGIMP")
public class FacturaDesgloseImpuestoDTO extends SimpleAuditDTO{

	@EmbeddedId
	ec.com.smx.sic.cliente.mdl.dto.id.FacturaDesgloseImpuestoID id = new FacturaDesgloseImpuestoID();
	
	@Column
	private Long valor;

	@Column(name = "CODIGOCATALOGOVALORAREFIS", nullable = false)
	private String codigoCatalogoValorAreaFiscal;

	@Column(name = "CODIGOCATALOGOTIPOAREFIS", nullable = false)
	private Integer codigoCatalogoTipoAreaFiscal;

	@Column(name = "CODIGOFACTURAESTADO", nullable = false)
	private Long codigoFacturaEstado;

	@Column(name = "CODIGOTIPOIMPUESTO", nullable = false)
	private Integer codigoTipoImpuesto;
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
	@Column(name = "FECHAREGISTRO")
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
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURAESTADO" ,referencedColumnName = "CODIGOFACTURAESTADO", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGOTIPOIMPUESTO", referencedColumnName = "CODIGOTIPOIMPUESTO", insertable = false, updatable = false)
	})
	private FacturaEstadoImpuestoDTO facturaEstadoImpuestoDTO;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCATALOGOVALORAREFIS", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCATALOGOTIPOAREFIS", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false) })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoFactura;

	public ec.com.smx.sic.cliente.mdl.dto.id.FacturaDesgloseImpuestoID getId() {
		return id;
	}

	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.FacturaDesgloseImpuestoID id) {
		this.id = id;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
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

	public Long getCodigoFacturaEstado() {
		return codigoFacturaEstado;
	}

	public void setCodigoFacturaEstado(Long codigoFacturaEstado) {
		this.codigoFacturaEstado = codigoFacturaEstado;
	}

	public Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}

	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
	}

	public FacturaEstadoImpuestoDTO getFacturaEstadoImpuestoDTO() {
		return facturaEstadoImpuestoDTO;
	}

	public void setFacturaEstadoImpuestoDTO(FacturaEstadoImpuestoDTO facturaEstadoImpuestoDTO) {
		this.facturaEstadoImpuestoDTO = facturaEstadoImpuestoDTO;
	}

	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoFactura() {
		return tipoFactura;
	}

	public void setTipoFactura(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoFactura) {
		this.tipoFactura = tipoFactura;
	}

	public Integer getCodigoCatalogoTipoAreaFiscal() {
		return codigoCatalogoTipoAreaFiscal;
	}

	public void setCodigoCatalogoTipoAreaFiscal(Integer codigoCatalogoTipoAreaFiscal) {
		this.codigoCatalogoTipoAreaFiscal = codigoCatalogoTipoAreaFiscal;
	}

	public String getCodigoCatalogoValorAreaFiscal() {
		return codigoCatalogoValorAreaFiscal;
	}

	public void setCodigoCatalogoValorAreaFiscal(String codigoCatalogoValorAreaFiscal) {
		this.codigoCatalogoValorAreaFiscal = codigoCatalogoValorAreaFiscal;
	}
	
}
