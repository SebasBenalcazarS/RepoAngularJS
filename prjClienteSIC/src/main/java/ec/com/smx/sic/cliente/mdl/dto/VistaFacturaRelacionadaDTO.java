package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaFacturaRelacionadaID;

@Entity
@SuppressWarnings("serial")
public class VistaFacturaRelacionadaDTO extends SearchDTO{
	@EmbeddedId
	private VistaFacturaRelacionadaID id = new VistaFacturaRelacionadaID();
	
	@Column(name = "NUMEROFACTURA")
	private String numeroFactura;
	
	@Column(name = "FECHAFACTURA")
	private Date fechaFactura;
	
	@Column(name = "VALORTIPODOCUMENTOCATVAL")
	private String valorTipoDocumentoCatVal;
	
	@Column(name = "NOMBRECATALOGOVALOR")
	private String nombreTipodocumentoCatVal;
	
	@Column(name = "NUMEROAUTORIZACION")
	private String numeroAutorizacion;
	
	@Column(name = "FECHACADUCIDADAUTORIZACION")
	private Date fechaCaducidadAutorizacion;
	
	@Column(name = "VALORTARIFACERO")
	private BigDecimal valorTarifaCero;
	
	@Column(name = "VALORTARIFADOCE")
	private BigDecimal valorTarifaDoce;
	
	@Column(name = "VALORTOTALIVE")
	private BigDecimal valorTotalIve;
	
	@Column(name = "VALORTOTAL")
	private BigDecimal valorTotal;
	
	@Column(name = "RETENER")
	private String retener;
	
	@Column(name = "OBSERVACION")
	private String observacion;
	
	@Column(name = "VALORTOTALNOTASCREDITO")
	private BigDecimal valorTotalNotasCredito;
	
	@Column(name = "VALORTOTALNOTASDEBITO")
	private BigDecimal valorTotalNotasDebito;
	
	@Column(name = "FACTURAENSITIO")
	private Boolean facturaEnSitio;
	
	@Column(name = "CODIGOACCESO")
	private String codigoAcceso;
	
	@Column(name = "VALORCAMBIOINFORMACION")
	private String valorCambioInformacion;
	
	@Column(name = "DESCUENTOTARIFACERO")
	private BigDecimal descuentoTarifaCero;
	
	@Column(name = "DESCUENTOTARIFADOCE")
	private BigDecimal descuentoTarifaDoce;
	
	//@Column(name = "NOMBREPLAZOPAGO")
	//private String nombrePlazoPago;
	
	//@Column(name = "VALORPLAZOPAGO")
	//private Long valorPlazoPago;
	
	@Column(name = "CODIGOTIPOPLAZOPAGO")
	private Integer codigoTipoPlazoPago;//Codigo del tipo plazo de pago de la factura del proveedor
	
	@Column(name = "VALORTIPOPLAZOPAGO")
	private String valorTipoPlazoPago;//Codigo del tipo plazo de pago de la factura del proveedor
	
	@Transient
	private Collection<VistaFacturaRelacionadaDTO> vistaFacturaRelacionadaCol;

	@Transient
	private Boolean expandir = Boolean.FALSE;
	
	@Transient
	private VistaFacturaRelacionadaDTO vistaFacturaRelacionadaPadre;
	
	@Transient
	private BigDecimal valorTotalFactura;
	
	@Transient
	private BigDecimal valorTotalNotasCreditoConImpuesto;
	
	@Transient
	private BigDecimal valorTotalNotasDebitoConImpuesto;
	
	public VistaFacturaRelacionadaID getId() {
		return id;
	}

	public void setId(VistaFacturaRelacionadaID id) {
		this.id = id;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public BigDecimal getValorTotalFactura() {
		return valorTotalFactura;
	}

	public void setValorTotalFactura(BigDecimal valorTotalFactura) {
		this.valorTotalFactura = valorTotalFactura;
	}

	public String getValorTipoDocumentoCatVal() {
		return valorTipoDocumentoCatVal;
	}

	public void setValorTipoDocumentoCatVal(String valorTipoDocumentoCatVal) {
		this.valorTipoDocumentoCatVal = valorTipoDocumentoCatVal;
	}

	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}

	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	public Date getFechaCaducidadAutorizacion() {
		return fechaCaducidadAutorizacion;
	}

	public void setFechaCaducidadAutorizacion(Date fechaCaducidadAutorizacion) {
		this.fechaCaducidadAutorizacion = fechaCaducidadAutorizacion;
	}

	public BigDecimal getValorTarifaCero() {
		return valorTarifaCero;
	}

	public void setValorTarifaCero(BigDecimal valorTarifaCero) {
		this.valorTarifaCero = valorTarifaCero;
	}

	public BigDecimal getValorTarifaDoce() {
		return valorTarifaDoce;
	}

	public void setValorTarifaDoce(BigDecimal valorTarifaDoce) {
		this.valorTarifaDoce = valorTarifaDoce;
	}

	public String getRetener() {
		return retener;
	}

	public void setRetener(String retener) {
		this.retener = retener;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Collection<VistaFacturaRelacionadaDTO> getVistaFacturaRelacionadaCol() {
		return vistaFacturaRelacionadaCol;
	}

	public void setVistaFacturaRelacionadaCol(Collection<VistaFacturaRelacionadaDTO> vistaFacturaRelacionadaCol) {
		this.vistaFacturaRelacionadaCol = vistaFacturaRelacionadaCol;
	}

	public Boolean getExpandir() {
		return expandir;
	}

	public void setExpandir(Boolean expandir) {
		this.expandir = expandir;
	}

	public VistaFacturaRelacionadaDTO getVistaFacturaRelacionadaPadre() {
		return vistaFacturaRelacionadaPadre;
	}

	public void setVistaFacturaRelacionadaPadre(VistaFacturaRelacionadaDTO vistaFacturaRelacionadaPadre) {
		this.vistaFacturaRelacionadaPadre = vistaFacturaRelacionadaPadre;
	}

	public BigDecimal getValorTotalNotasCredito() {
		return valorTotalNotasCredito;
	}

	public void setValorTotalNotasCredito(BigDecimal valorTotalNotasCredito) {
		this.valorTotalNotasCredito = valorTotalNotasCredito;
	}

	public BigDecimal getValorTotalNotasDebito() {
		return valorTotalNotasDebito;
	}

	public void setValorTotalNotasDebito(BigDecimal valorTotalNotasDebito) {
		this.valorTotalNotasDebito = valorTotalNotasDebito;
	}

	public Boolean getFacturaEnSitio() {
		return facturaEnSitio;
	}

	public void setFacturaEnSitio(Boolean facturaEnSitio) {
		this.facturaEnSitio = facturaEnSitio;
	}

	/**
	 * @return the nombreTipodocumentoCatVal
	 */
	public String getNombreTipodocumentoCatVal() {
		return nombreTipodocumentoCatVal;
	}

	/**
	 * @param nombreTipodocumentoCatVal the nombreTipodocumentoCatVal to set
	 */
	public void setNombreTipodocumentoCatVal(String nombreTipodocumentoCatVal) {
		this.nombreTipodocumentoCatVal = nombreTipodocumentoCatVal;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the codigoAcceso
	 */
	public String getCodigoAcceso() {
		return codigoAcceso;
	}

	/**
	 * @param codigoAcceso the codigoAcceso to set
	 */
	public void setCodigoAcceso(String codigoAcceso) {
		this.codigoAcceso = codigoAcceso;
	}

	/**
	 * @return the valorTotalNotasCreditoConImpuesto
	 */
	public BigDecimal getValorTotalNotasCreditoConImpuesto() {
		return valorTotalNotasCreditoConImpuesto;
	}

	/**
	 * @param valorTotalNotasCreditoConImpuesto the valorTotalNotasCreditoConImpuesto to set
	 */
	public void setValorTotalNotasCreditoConImpuesto(BigDecimal valorTotalNotasCreditoConImpuesto) {
		this.valorTotalNotasCreditoConImpuesto = valorTotalNotasCreditoConImpuesto;
	}

	/**
	 * @return the valorTotalNotasDebitoConImpuesto
	 */
	public BigDecimal getValorTotalNotasDebitoConImpuesto() {
		return valorTotalNotasDebitoConImpuesto;
	}

	/**
	 * @param valorTotalNotasDebitoConImpuesto the valorTotalNotasDebitoConImpuesto to set
	 */
	public void setValorTotalNotasDebitoConImpuesto(BigDecimal valorTotalNotasDebitoConImpuesto) {
		this.valorTotalNotasDebitoConImpuesto = valorTotalNotasDebitoConImpuesto;
	}

	public String getValorCambioInformacion() {
		return valorCambioInformacion;
	}

	public void setValorCambioInformacion(String valorCambioInformacion) {
		this.valorCambioInformacion = valorCambioInformacion;
	}

	public BigDecimal getValorTotalIve() {
		return valorTotalIve;
	}

	public void setValorTotalIve(BigDecimal valorTotalIve) {
		this.valorTotalIve = valorTotalIve;
	}

	public BigDecimal getDescuentoTarifaCero() {
		return descuentoTarifaCero;
	}

	public void setDescuentoTarifaCero(BigDecimal descuentoTarifaCero) {
		this.descuentoTarifaCero = descuentoTarifaCero;
	}

	public BigDecimal getDescuentoTarifaDoce() {
		return descuentoTarifaDoce;
	}

	public void setDescuentoTarifaDoce(BigDecimal descuentoTarifaDoce) {
		this.descuentoTarifaDoce = descuentoTarifaDoce;
	}

	/**
	 * @return the codigoTipoPlazoPago
	 */
	public Integer getCodigoTipoPlazoPago() {
		return codigoTipoPlazoPago;
	}

	/**
	 * @param codigoTipoPlazoPago the codigoTipoPlazoPago to set
	 */
	public void setCodigoTipoPlazoPago(Integer codigoTipoPlazoPago) {
		this.codigoTipoPlazoPago = codigoTipoPlazoPago;
	}

	/**
	 * @return the valorTipoPlazoPago
	 */
	public String getValorTipoPlazoPago() {
		return valorTipoPlazoPago;
	}

	/**
	 * @param valorTipoPlazoPago the valorTipoPlazoPago to set
	 */
	public void setValorTipoPlazoPago(String valorTipoPlazoPago) {
		this.valorTipoPlazoPago = valorTipoPlazoPago;
	}
}