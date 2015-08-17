package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;

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
import ec.com.smx.sic.cliente.mdl.dto.id.ValoresResumenDocumentoID;

@SuppressWarnings("serial")
@Entity
@Table(name = "SCFDITVALRESDOC")
public class ValoresResumenDocumentoDTO extends SimpleAuditDTO{

	@EmbeddedId
	ValoresResumenDocumentoID id = new ValoresResumenDocumentoID();
	
	private Integer codigoResumenTotal;
	
	private Integer codigoTipoImpuesto;
	
	private BigDecimal sujetoImpuesto;
	
	private BigDecimal totalImpuesto;
	
	@ComparatorTypeField
	private String estado;
	
	@RegisterUserIdField
	private java.lang.String idUsuarioRegistro;

	@RegisterDateField
	private java.util.Date fechaRegistro;

	@LastModifierUserIdField
	private java.lang.String idUsuarioModificacion;

	@LastModificationDateField
	private java.util.Date fechaModificacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGORESUMENTOTAL", insertable = false, updatable = false, referencedColumnName = "CODIGORESUMENTOTAL") })
	private ResumenTotalDocumentoDTO resumenTotalDocumentoDTO;

	public ValoresResumenDocumentoID getId() {
		return id;
	}

	public void setId(ValoresResumenDocumentoID id) {
		this.id = id;
	}

	public Integer getCodigoResumenTotal() {
		return codigoResumenTotal;
	}

	public void setCodigoResumenTotal(Integer codigoResumenTotal) {
		this.codigoResumenTotal = codigoResumenTotal;
	}

	public Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}

	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
	}

	public BigDecimal getSujetoImpuesto() {
		return sujetoImpuesto;
	}

	public void setSujetoImpuesto(BigDecimal sujetoImpuesto) {
		this.sujetoImpuesto = sujetoImpuesto;
	}

	public BigDecimal getTotalImpuesto() {
		return totalImpuesto;
	}

	public void setTotalImpuesto(BigDecimal totalImpuesto) {
		this.totalImpuesto = totalImpuesto;
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

	public ResumenTotalDocumentoDTO getResumenTotalDocumentoDTO() {
		return resumenTotalDocumentoDTO;
	}

	public void setResumenTotalDocumentoDTO(ResumenTotalDocumentoDTO resumenTotalDocumentoDTO) {
		this.resumenTotalDocumentoDTO = resumenTotalDocumentoDTO;
	}
}