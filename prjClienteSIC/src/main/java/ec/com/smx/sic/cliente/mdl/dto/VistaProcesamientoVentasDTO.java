package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * @author egudino 
 */
@Entity
@SuppressWarnings("serial")
public class VistaProcesamientoVentasDTO implements Serializable{
	@Id
	private java.lang.Long codigoPlanFechaRegistroCobro; 
	private java.lang.Long codigoDetalleNegociacion;
	private java.lang.Long codigoNegociacionGestionPrecioConvenioParticipante;
	private java.lang.Long codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	private java.util.Date fechaCobro;
	private java.lang.Integer cuotas;	
	private java.math.BigDecimal valorMonetarioCobro;
	private java.math.BigDecimal valorPorcentajeCobro;
	private java.lang.String codigoValorTipoFormaVenta;
	private java.lang.String codigoValorCondicionCobro;
	private java.lang.String codigoValorCobroCosto;
	private java.lang.Integer codigoTipoFormaVenta;
	private java.lang.String codigoProveedor;
	private java.lang.Long codigoCampania;
	private java.lang.Long codigoReferencia;
	private java.lang.Boolean esFinPromocion;
	
	
	/**
	 * @return the codigoPlanFechaRegistroCobro
	 */
	public java.lang.Long getCodigoPlanFechaRegistroCobro() {
		return codigoPlanFechaRegistroCobro;
	}
	/**
	 * @param codigoPlanFechaRegistroCobro the codigoPlanFechaRegistroCobro to set
	 */
	public void setCodigoPlanFechaRegistroCobro(java.lang.Long codigoPlanFechaRegistroCobro) {
		this.codigoPlanFechaRegistroCobro = codigoPlanFechaRegistroCobro;
	}
	/**
	 * @return the codigoDetalleNegociacion
	 */
	public java.lang.Long getCodigoDetalleNegociacion() {
		return codigoDetalleNegociacion;
	}
	/**
	 * @param codigoDetalleNegociacion the codigoDetalleNegociacion to set
	 */
	public void setCodigoDetalleNegociacion(java.lang.Long codigoDetalleNegociacion) {
		this.codigoDetalleNegociacion = codigoDetalleNegociacion;
	}
	/**
	 * @return the codigoNegociacionGestionPrecioConvenioParticipante
	 */
	public java.lang.Long getCodigoNegociacionGestionPrecioConvenioParticipante() {
		return codigoNegociacionGestionPrecioConvenioParticipante;
	}
	/**
	 * @param codigoNegociacionGestionPrecioConvenioParticipante the codigoNegociacionGestionPrecioConvenioParticipante to set
	 */
	public void setCodigoNegociacionGestionPrecioConvenioParticipante(java.lang.Long codigoNegociacionGestionPrecioConvenioParticipante) {
		this.codigoNegociacionGestionPrecioConvenioParticipante = codigoNegociacionGestionPrecioConvenioParticipante;
	}
	/**
	 * @return the codigoDetalleNegociacionGestionPrecioConvenioParticipante
	 */
	public java.lang.Long getCodigoDetalleNegociacionGestionPrecioConvenioParticipante() {
		return codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	}
	/**
	 * @param codigoDetalleNegociacionGestionPrecioConvenioParticipante the codigoDetalleNegociacionGestionPrecioConvenioParticipante to set
	 */
	public void setCodigoDetalleNegociacionGestionPrecioConvenioParticipante(java.lang.Long codigoDetalleNegociacionGestionPrecioConvenioParticipante) {
		this.codigoDetalleNegociacionGestionPrecioConvenioParticipante = codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	}
	/**
	 * @return the fechaCobro
	 */
	public java.util.Date getFechaCobro() {
		return fechaCobro;
	}
	/**
	 * @param fechaCobro the fechaCobro to set
	 */
	public void setFechaCobro(java.util.Date fechaCobro) {
		this.fechaCobro = fechaCobro;
	}
	/**
	 * @return the cuotas
	 */
	public java.lang.Integer getCuotas() {
		return cuotas;
	}
	/**
	 * @param cuotas the cuotas to set
	 */
	public void setCuotas(java.lang.Integer cuotas) {
		this.cuotas = cuotas;
	}
	/**
	 * @return the valorMonetarioCobro
	 */
	public java.math.BigDecimal getValorMonetarioCobro() {
		return valorMonetarioCobro;
	}
	/**
	 * @param valorMonetarioCobro the valorMonetarioCobro to set
	 */
	public void setValorMonetarioCobro(java.math.BigDecimal valorMonetarioCobro) {
		this.valorMonetarioCobro = valorMonetarioCobro;
	}
	/**
	 * @return the valorPorcentajeCobro
	 */
	public java.math.BigDecimal getValorPorcentajeCobro() {
		return valorPorcentajeCobro;
	}
	/**
	 * @param valorPorcentajeCobro the valorPorcentajeCobro to set
	 */
	public void setValorPorcentajeCobro(java.math.BigDecimal valorPorcentajeCobro) {
		this.valorPorcentajeCobro = valorPorcentajeCobro;
	}
	/**
	 * @return the codigoValorTipoFormaVenta
	 */
	public java.lang.String getCodigoValorTipoFormaVenta() {
		return codigoValorTipoFormaVenta;
	}
	/**
	 * @param codigoValorTipoFormaVenta the codigoValorTipoFormaVenta to set
	 */
	public void setCodigoValorTipoFormaVenta(java.lang.String codigoValorTipoFormaVenta) {
		this.codigoValorTipoFormaVenta = codigoValorTipoFormaVenta;
	}
	/**
	 * @return the codigoTipoFormaVenta
	 */
	public java.lang.Integer getCodigoTipoFormaVenta() {
		return codigoTipoFormaVenta;
	}
	/**
	 * @param codigoTipoFormaVenta the codigoTipoFormaVenta to set
	 */
	public void setCodigoTipoFormaVenta(java.lang.Integer codigoTipoFormaVenta) {
		this.codigoTipoFormaVenta = codigoTipoFormaVenta;
	}
	/**
	 * @return the codigoProveedor
	 */
	public java.lang.String getCodigoProveedor() {
		return codigoProveedor;
	}
	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(java.lang.String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	/**
	 * @return the codigoCampania
	 */
	public java.lang.Long getCodigoCampania() {
		return codigoCampania;
	}
	/**
	 * @param codigoCampania the codigoCampania to set
	 */
	public void setCodigoCampania(java.lang.Long codigoCampania) {
		this.codigoCampania = codigoCampania;
	}
	/**
	 * @return the esFinPromocion
	 */
	public java.lang.Boolean getEsFinPromocion() {
		return esFinPromocion;
	}
	/**
	 * @param esFinPromocion the esFinPromocion to set
	 */
	public void setEsFinPromocion(java.lang.Boolean esFinPromocion) {
		this.esFinPromocion = esFinPromocion;
	}
	public java.lang.String getCodigoValorCondicionCobro() {
		return codigoValorCondicionCobro;
	}
	public void setCodigoValorCondicionCobro(java.lang.String codigoValorCondicionCobro) {
		this.codigoValorCondicionCobro = codigoValorCondicionCobro;
	}
	public java.lang.Long getCodigoReferencia() {
		return codigoReferencia;
	}
	public void setCodigoReferencia(java.lang.Long codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}
	public java.lang.String getCodigoValorCobroCosto() {
		return codigoValorCobroCosto;
	}
	public void setCodigoValorCobroCosto(java.lang.String codigoValorCobroCosto) {
		this.codigoValorCobroCosto = codigoValorCobroCosto;
	}
}
