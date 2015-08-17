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
import ec.com.smx.sic.cliente.mdl.dto.id.FacturaDetalleDatoFinancieroID;

@SuppressWarnings("serial")
@Entity
@Table(name="SCFDITDETFIN")
public class FacturaDetalleDatoFinancieroDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	ec.com.smx.sic.cliente.mdl.dto.id.FacturaDetalleDatoFinancieroID id = new FacturaDetalleDatoFinancieroID();
	
	@ComparatorTypeField
	private String cuentaContable;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOFACTURADATOFINACIERO", insertable = false, updatable = false, referencedColumnName = "CODIGOFACTURADATOFINACIERO") })
	private FacturaDatoFinancieroDTO facturaDatoFinancieroDTO;

	/**Relacion entre las la tablas detalleFinanciero y centroCosto  */
	@OneToMany(mappedBy = "facturaDetalleDatoFinancieroDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<FacturaDetalleDatoFinancieroCentroCostoDTO> facturaCentroCostoCol;
	
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
	
	@Column(name = "CODIGOFACTURADATOFINACIERO")
	private Long codigoDatoFinanciero;

	public ec.com.smx.sic.cliente.mdl.dto.id.FacturaDetalleDatoFinancieroID getId() {
		return id;
	}

	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.FacturaDetalleDatoFinancieroID id) {
		this.id = id;
	}

	public String getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public FacturaDatoFinancieroDTO getFacturaDatoFinancieroDTO() {
		return facturaDatoFinancieroDTO;
	}

	public void setFacturaDatoFinancieroDTO(FacturaDatoFinancieroDTO facturaDatoFinancieroDTO) {
		this.facturaDatoFinancieroDTO = facturaDatoFinancieroDTO;
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

	public Collection<FacturaDetalleDatoFinancieroCentroCostoDTO> getFacturaCentroCostoCol() {
		return facturaCentroCostoCol;
	}

	public void setFacturaCentroCostoCol(Collection<FacturaDetalleDatoFinancieroCentroCostoDTO> facturaCentroCostoCol) {
		this.facturaCentroCostoCol = facturaCentroCostoCol;
	}

	public Long getCodigoDatoFinanciero() {
		return codigoDatoFinanciero;
	}

	public void setCodigoDatoFinanciero(Long codigoDatoFinanciero) {
		this.codigoDatoFinanciero = codigoDatoFinanciero;
	}

}
