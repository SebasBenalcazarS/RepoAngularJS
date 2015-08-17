package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.util.Collection;

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
import ec.com.smx.sic.cliente.mdl.dto.id.ResumenTotalDocumentoID;

/**
 * Especifica el resumen de los documentos que se relacionan al documento principal, 
 * resumen de totales de de las facturas del proveedor, notas credito, notas debito que posee la nota de ingreso
 * @author fcollaguazo
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "SCFDITRESTOTDOC")
public class ResumenTotalDocumentoDTO extends SimpleAuditDTO{

	@EmbeddedId
	ResumenTotalDocumentoID id = new ResumenTotalDocumentoID();
	
	private Long codigoDocumento;
	
	@ComparatorTypeField
	private String valorTipoDocumento;
	
	private Integer codigoTipoDocumento;
	
	private BigDecimal valorAjusteAutomatico;
	
	private BigDecimal valorAjusteManual;
	
	private BigDecimal valorDevolucion;
	
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
	
	private Integer numeroRegistros;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODOCUMENTO", insertable = false, updatable = false, referencedColumnName = "CODIGOFACTURA") })
	private FacturaDTO facturaDTO;
	
	@OneToMany(mappedBy = "resumenTotalDocumentoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<ValoresResumenDocumentoDTO> valoresResumenDocumentoCol;

	public Long getCodigoDocumento() {
		return codigoDocumento;
	}

	public void setCodigoDocumento(Long codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}

	public String getValorTipoDocumento() {
		return valorTipoDocumento;
	}

	public void setValorTipoDocumento(String valorTipoDocumento) {
		this.valorTipoDocumento = valorTipoDocumento;
	}

	public Integer getCodigoTipoDocumento() {
		return codigoTipoDocumento;
	}

	public void setCodigoTipoDocumento(Integer codigoTipoDocumento) {
		this.codigoTipoDocumento = codigoTipoDocumento;
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

	public ResumenTotalDocumentoID getId() {
		return id;
	}

	public void setId(ResumenTotalDocumentoID id) {
		this.id = id;
	}

	public Collection<ValoresResumenDocumentoDTO> getValoresResumenDocumentoCol() {
		return valoresResumenDocumentoCol;
	}

	public void setValoresResumenDocumentoCol(Collection<ValoresResumenDocumentoDTO> valoresResumenDocumentoCol) {
		this.valoresResumenDocumentoCol = valoresResumenDocumentoCol;
	}

	/**
	 * @return the valorAjusteAutomatico
	 */
	public BigDecimal getValorAjusteAutomatico() {
		return valorAjusteAutomatico;
	}

	/**
	 * @param valorAjusteAutomatico the valorAjusteAutomatico to set
	 */
	public void setValorAjusteAutomatico(BigDecimal valorAjusteAutomatico) {
		this.valorAjusteAutomatico = valorAjusteAutomatico;
	}

	/**
	 * @return the valorAjusteManual
	 */
	public BigDecimal getValorAjusteManual() {
		return valorAjusteManual;
	}

	/**
	 * @param valorAjusteManual the valorAjusteManual to set
	 */
	public void setValorAjusteManual(BigDecimal valorAjusteManual) {
		this.valorAjusteManual = valorAjusteManual;
	}

	/**
	 * @return the valorDevolucion
	 */
	public BigDecimal getValorDevolucion() {
		return valorDevolucion;
	}

	/**
	 * @param valorDevolucion the valorDevolucion to set
	 */
	public void setValorDevolucion(BigDecimal valorDevolucion) {
		this.valorDevolucion = valorDevolucion;
	}

	/**
	 * @return the numeroRegistros
	 */
	public Integer getNumeroRegistros() {
		return numeroRegistros;
	}

	/**
	 * @param numeroRegistros the numeroRegistros to set
	 */
	public void setNumeroRegistros(Integer numeroRegistros) {
		this.numeroRegistros = numeroRegistros;
	}
}