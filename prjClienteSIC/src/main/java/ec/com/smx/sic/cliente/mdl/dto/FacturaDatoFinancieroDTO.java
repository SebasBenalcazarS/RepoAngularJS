package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.FacturaDatoFinancieroID;

@SuppressWarnings("serial")
@Entity
@Table(name="SCFDITFACDATFIN")
public class FacturaDatoFinancieroDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	ec.com.smx.sic.cliente.mdl.dto.id.FacturaDatoFinancieroID id = new FacturaDatoFinancieroID();
	
	private Long codigoFactura;
	
	@ComparatorTypeField
	private String tipoDocumento;
	
	@ComparatorTypeField
	private String cuentaContable;
	
	@ComparatorTypeField
	private String observacionFinanciera;
	
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	@Column(name = "SECUENCIALLOTE")
	private Long secuencialLote;
	
	@Column(name = "NOMBRECORTOICA")
	private String nombreCortoIca;
	
	@Column(name = "DESGLOSE")
	private String desglose;

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
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOFACTURA", insertable = false, updatable = false, referencedColumnName = "CODIGOFACTURA") })
	private FacturaDTO facturaDTO;
	
	@OneToMany(mappedBy = "facturaDatoFinancieroDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<FacturaDetalleDatoFinancieroDTO> facturaDetalleDatoFinancieroCol;
	

	public ec.com.smx.sic.cliente.mdl.dto.id.FacturaDatoFinancieroID getId() {
		return id;
	}

	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.FacturaDatoFinancieroID id) {
		this.id = id;
	}

	public Long getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public String getObservacionFinanciera() {
		return observacionFinanciera;
	}

	public void setObservacionFinanciera(String observacionFinanciera) {
		this.observacionFinanciera = observacionFinanciera;
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

	public FacturaDTO getFacturaDTO() {
		return facturaDTO;
	}

	public void setFacturaDTO(FacturaDTO facturaDTO) {
		this.facturaDTO = facturaDTO;
	}

	public Collection<FacturaDetalleDatoFinancieroDTO> getFacturaDetalleDatoFinancieroCol() {
		return facturaDetalleDatoFinancieroCol;
	}

	public void setFacturaDetalleDatoFinancieroCol(Collection<FacturaDetalleDatoFinancieroDTO> facturaDetalleDatoFinancieroCol) {
		this.facturaDetalleDatoFinancieroCol = facturaDetalleDatoFinancieroCol;
	}

	public Long getSecuencialLote() {
		return secuencialLote;
	}

	public void setSecuencialLote(Long secuencialLote) {
		this.secuencialLote = secuencialLote;
	}

	public String getNombreCortoIca() {
		return nombreCortoIca;
	}

	public void setNombreCortoIca(String nombreCortoIca) {
		this.nombreCortoIca = nombreCortoIca;
	}

	public String getDesglose() {
		return desglose;
	}

	public void setDesglose(String desglose) {
		this.desglose = desglose;
	}
}
