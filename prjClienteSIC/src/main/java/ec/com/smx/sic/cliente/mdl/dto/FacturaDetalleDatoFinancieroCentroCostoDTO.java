package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
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
import ec.com.smx.sic.cliente.mdl.dto.id.FacturaDetalleDatoFinancieroCentroCostoID;

@SuppressWarnings("serial")
@Entity
@Table(name="SCFDITFINCENCOS")
public class FacturaDetalleDatoFinancieroCentroCostoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.FacturaDetalleDatoFinancieroCentroCostoID id = new FacturaDetalleDatoFinancieroCentroCostoID();
	
	@ComparatorTypeField
	@Column(name = "CENTROCOSTO")
	private String centroCosto;
	
	@Column(name = "VALOR")
	private BigDecimal valor;
	
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
	@Column(name="FECHAREGISTRO")
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realiza la  ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;
	
	/**
	 * Fecha en la que se realiza la  ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	@Column(name="FECHAMODIFICACION")
	private java.util.Date fechaModificacion;

	
	@Column(name = "CODIGODETALLEFINANCIERO")
	private Long codigoDetalleFinanciero;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGODETALLEFINANCIERO", referencedColumnName = "CODIGODETALLEFINANCIERO", insertable = false, updatable = false)
    })
    private FacturaDetalleDatoFinancieroDTO facturaDetalleDatoFinancieroDTO;
	
	
	public ec.com.smx.sic.cliente.mdl.dto.id.FacturaDetalleDatoFinancieroCentroCostoID getId() {
		return id;
	}

	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.FacturaDetalleDatoFinancieroCentroCostoID id) {
		this.id = id;
	}

	public String getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(String centroCosto) {
		this.centroCosto = centroCosto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
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

	public FacturaDetalleDatoFinancieroDTO getFacturaDetalleDatoFinancieroDTO() {
		return facturaDetalleDatoFinancieroDTO;
	}

	public void setFacturaDetalleDatoFinancieroDTO(FacturaDetalleDatoFinancieroDTO facturaDetalleDatoFinancieroDTO) {
		this.facturaDetalleDatoFinancieroDTO = facturaDetalleDatoFinancieroDTO;
	}

	public Long getCodigoDetalleFinanciero() {
		return codigoDetalleFinanciero;
	}

	public void setCodigoDetalleFinanciero(Long codigoDetalleFinanciero) {
		this.codigoDetalleFinanciero = codigoDetalleFinanciero;
	}

	
}
