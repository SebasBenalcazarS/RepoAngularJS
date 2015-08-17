package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


/**
 * @author egudino 
 */
@Entity
@SuppressWarnings("serial")
public class VistaCobroProveedoresDTO implements Serializable{
	@Id
	private java.lang.Long codigoRegistroCobro; 
	
	private java.lang.Long codigoCampania;
	private java.lang.String codigoPromicionLoyalty;
	private java.lang.String nombrePromicion;
	private java.lang.Long codigoPromocion;
	private java.lang.String codigoProveedor;
	private java.lang.String participante;
	private java.lang.String tipoNegociacion;
	private java.lang.String formaCobroNegociacion;
	private java.math.BigDecimal montoNegociacion;
	private java.math.BigDecimal porcentajeNegociacion;
	private java.util.Date fechaCobro;
	private java.math.BigDecimal valorACobrar;
	private java.lang.Integer numeroCuota;
	private java.lang.Integer totalCuotas;
	private java.math.BigDecimal saldoPorCobrar;
	private java.math.BigDecimal valorAcumulado;
	private java.lang.String documento;
	private java.lang.String error;
	@Transient
	private java.lang.Integer colorRegistro;
	@Transient
	private java.lang.String npParticipante;;
	/**
	 * @return the codigoRegistroCobro
	 */
	public java.lang.Long getCodigoRegistroCobro() {
		return codigoRegistroCobro;
	}
	/**
	 * @param codigoRegistroCobro the codigoRegistroCobro to set
	 */
	public void setCodigoRegistroCobro(java.lang.Long codigoRegistroCobro) {
		this.codigoRegistroCobro = codigoRegistroCobro;
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
	 * @return the codigoPromocion
	 */
	public java.lang.Long getCodigoPromocion() {
		return codigoPromocion;
	}
	/**
	 * @param codigoPromocion the codigoPromocion to set
	 */
	public void setCodigoPromocion(java.lang.Long codigoPromocion) {
		this.codigoPromocion = codigoPromocion;
	}
	/**
	 * @return the tipoNegociacion
	 */
	public java.lang.String getTipoNegociacion() {
		return tipoNegociacion;
	}
	/**
	 * @param tipoNegociacion the tipoNegociacion to set
	 */
	public void setTipoNegociacion(java.lang.String tipoNegociacion) {
		this.tipoNegociacion = tipoNegociacion;
	}
	/**
	 * @return the formaCobroNegociacion
	 */
	public java.lang.String getFormaCobroNegociacion() {
		return formaCobroNegociacion;
	}
	/**
	 * @param formaCobroNegociacion the formaCobroNegociacion to set
	 */
	public void setFormaCobroNegociacion(java.lang.String formaCobroNegociacion) {
		this.formaCobroNegociacion = formaCobroNegociacion;
	}
	/**
	 * @return the montoNegociacion
	 */
	public java.math.BigDecimal getMontoNegociacion() {
		return montoNegociacion;
	}
	/**
	 * @param montoNegociacion the montoNegociacion to set
	 */
	public void setMontoNegociacion(java.math.BigDecimal montoNegociacion) {
		this.montoNegociacion = montoNegociacion;
	}
	/**
	 * @return the porcentajeNegociacion
	 */
	public java.math.BigDecimal getPorcentajeNegociacion() {
		return porcentajeNegociacion;
	}
	/**
	 * @param porcentajeNegociacion the porcentajeNegociacion to set
	 */
	public void setPorcentajeNegociacion(java.math.BigDecimal porcentajeNegociacion) {
		this.porcentajeNegociacion = porcentajeNegociacion;
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
	 * @return the valorACobrar
	 */
	public java.math.BigDecimal getValorACobrar() {
		return valorACobrar;
	}
	/**
	 * @param valorACobrar the valorACobrar to set
	 */
	public void setValorACobrar(java.math.BigDecimal valorACobrar) {
		this.valorACobrar = valorACobrar;
	}
	/**
	 * @return the numeroCuota
	 */
	public java.lang.Integer getNumeroCuota() {
		return numeroCuota;
	}
	/**
	 * @param numeroCuota the numeroCuota to set
	 */
	public void setNumeroCuota(java.lang.Integer numeroCuota) {
		this.numeroCuota = numeroCuota;
	}
	/**
	 * @return the totalCuotas
	 */
	public java.lang.Integer getTotalCuotas() {
		return totalCuotas;
	}
	/**
	 * @param totalCuotas the totalCuotas to set
	 */
	public void setTotalCuotas(java.lang.Integer totalCuotas) {
		this.totalCuotas = totalCuotas;
	}
	/**
	 * @return the saldoPorCobrar
	 */
	public java.math.BigDecimal getSaldoPorCobrar() {
		return saldoPorCobrar;
	}
	/**
	 * @param saldoPorCobrar the saldoPorCobrar to set
	 */
	public void setSaldoPorCobrar(java.math.BigDecimal saldoPorCobrar) {
		this.saldoPorCobrar = saldoPorCobrar;
	}
	/**
	 * @return the valorAcumulado
	 */
	public java.math.BigDecimal getValorAcumulado() {
		return valorAcumulado;
	}
	/**
	 * @param valorAcumulado the valorAcumulado to set
	 */
	public void setValorAcumulado(java.math.BigDecimal valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
	}
	/**
	 * @return the participante
	 */
	public java.lang.String getParticipante() {
		return participante;
	}
	/**
	 * @param participante the participante to set
	 */
	public void setParticipante(java.lang.String participante) {
		this.participante = participante;
	}
	/**
	 * @return the codigoPromicionLoyalty
	 */
	public java.lang.String getCodigoPromicionLoyalty() {
		return codigoPromicionLoyalty;
	}
	/**
	 * @param codigoPromicionLoyalty the codigoPromicionLoyalty to set
	 */
	public void setCodigoPromicionLoyalty(java.lang.String codigoPromicionLoyalty) {
		this.codigoPromicionLoyalty = codigoPromicionLoyalty;
	}
	/**
	 * @return the nombrePromicion
	 */
	public java.lang.String getNombrePromicion() {
		return nombrePromicion;
	}
	/**
	 * @param nombrePromicion the nombrePromicion to set
	 */
	public void setNombrePromicion(java.lang.String nombrePromicion) {
		this.nombrePromicion = nombrePromicion;
	}
	/**
	 * @return the colorRegistro
	 */
	public java.lang.Integer getColorRegistro() {
		return colorRegistro;
	}
	/**
	 * @param colorRegistro the colorRegistro to set
	 */
	public void setColorRegistro(java.lang.Integer colorRegistro) {
		this.colorRegistro = colorRegistro;
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
	 * @return the npParticipante
	 */
	public java.lang.String getNpParticipante() {
		return npParticipante;
	}
	/**
	 * @param npParticipante the npParticipante to set
	 */
	public void setNpParticipante(java.lang.String npParticipante) {
		this.npParticipante = npParticipante;
	}
	/**
	 * @return the documento
	 */
	public java.lang.String getDocumento() {
		return documento;
	}
	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(java.lang.String documento) {
		this.documento = documento;
	}
	/**
	 * @return the error
	 */
	public java.lang.String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(java.lang.String error) {
		this.error = error;
	}
	
}
