
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloLocalID;


/**
 * Permite gestionar la información correspondiente a ClienteArticulo
 *
 * @author mrivera
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADVARTLOC")
public class VistaArticuloLocalDTO extends BaseDto<VistaArticuloLocalID> {
		
	/**
	 * Código de barras del cupón
	 */
	@ComparatorTypeField
	private String codigoBarras;
	/**
	 * Código de barras del artículo relacionado al cupón
	 */
	@ComparatorTypeField
	private String codigoBarrasArticuloRelacionado;
	/**
	 * Código de referencia al POS (código de enlace)
	 */
	@ComparatorTypeField
	private String codigoReferencia;
	/**
	 * Especifica el porcentaje de descuento que aplica el cupón
	 */
	private Double porcentajeDescuento;
	/**
	 * Especifica el valor de descuento que aplica el cupón
	 */
	private Double valorDescuento;
	/**
	 * Valor que tiene el cupón, cuando aplica como precio final del artículo relacionado.
	 */
	private Double valorActual;
	/**
	 * Indica si el impuesto es para venta (true)
	 */
	private Boolean esParaVenta;
	/**
	 * Porcentaje del tipo de impuesto
	 */
	private Double porcentajeImpuesto;
	/**
	 * Tipo deducible cupón: Alimentación, Vestimenta, Educación, Salud
	 */
	@ComparatorTypeField
	private String deducible;
	
	/**
	 * Si el cupón debe anadirse enviar 01, si debe eliminarse se envia 02
	 */
	@ComparatorTypeField
	private String codigoEstado;
	/**
	 * Fecha en que se registró el estado actual del cupón
	 */
	private Date fechaRegistroEstado;
	
	/**
	 * Tipo de cupón
	 * posibles valores:
	 * 1: virtual
	 * 2: papel 
	 */
	@ComparatorTypeField
	private String tipoCupon;
		
	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}
	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	/**
	 * @return the codigoBarrasArticuloRelacionado
	 */
	public String getCodigoBarrasArticuloRelacionado() {
		return codigoBarrasArticuloRelacionado;
	}
	/**
	 * @param codigoBarrasArticuloRelacionado the codigoBarrasArticuloRelacionado to set
	 */
	public void setCodigoBarrasArticuloRelacionado(String codigoBarrasArticuloRelacionado) {
		this.codigoBarrasArticuloRelacionado = codigoBarrasArticuloRelacionado;
	}
	/**
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}
	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}
	/**
	 * @return the porcentajeDescuento
	 */
	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	/**
	 * @param porcentajeDescuento the porcentajeDescuento to set
	 */
	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	/**
	 * @return the valorDescuento
	 */
	public Double getValorDescuento() {
		return valorDescuento;
	}
	/**
	 * @param valorDescuento the valorDescuento to set
	 */
	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}
	/**
	 * @return the valorActual
	 */
	public Double getValorActual() {
		//Si existe un valor actual y el porcentaje impuesto (IVA) es mayor a cero, se calcula el valorActualConImpuesto
		if(valorActual != null && valorActual > 0D 
				&& this.porcentajeImpuesto != null && this.porcentajeImpuesto > 0D)
		{
			//Dado el valor actual, el impuesto
			Map<String, Double> valoresImpuesto = new HashMap<String, Double>();
			valoresImpuesto.put(SICArticuloCalculo.CLAVE_PORCENTAJEIMPUESTO, this.porcentajeImpuesto);
			valoresImpuesto.put(SICArticuloCalculo.CLAVE_VALORIMPUESTO, 0D);
			return SICArticuloCalculo.getInstancia().calcularValorConImpuestos(valorActual, valoresImpuesto, this.esParaVenta);
		}
		return valorActual;
	}
	/**
	 * @param valorActual the valorActual to set
	 */
	public void setValorActual(Double valorActual) {
		this.valorActual = valorActual;
	}	
	/**
	 * @return the esParaVenta
	 */
	public Boolean getEsParaVenta() {
		return esParaVenta;
	}
	/**
	 * @param esParaVenta the esParaVenta to set
	 */
	public void setEsParaVenta(Boolean esParaVenta) {
		this.esParaVenta = esParaVenta;
	}
	/**
	 * @return the porcentajeImpuesto
	 */
	public Double getPorcentajeImpuesto() {
		return porcentajeImpuesto;
	}
	/**
	 * @param porcentajeImpuesto the porcentajeImpuesto to set
	 */
	public void setPorcentajeImpuesto(Double porcentajeImpuesto) {
		this.porcentajeImpuesto = porcentajeImpuesto;
	}
	/**
	 * @return the deducible
	 */
	public String getDeducible() {
		return deducible;
	}
	/**
	 * @param deducible the deducible to set
	 */
	public void setDeducible(String deducible) {
		this.deducible = deducible;
	}
	/**
	 * @return the codigoEstado
	 */
	public String getCodigoEstado() {
		return codigoEstado;
	}
	/**
	 * @param codigoEstado the codigoEstado to set
	 */
	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	/**
	 * @return the fechaRegistroEstado
	 */
	public Date getFechaRegistroEstado() {
		return fechaRegistroEstado;
	}
	/**
	 * @param fechaRegistroEstado the fechaRegistroEstado to set
	 */
	public void setFechaRegistroEstado(Date fechaRegistroEstado) {
		this.fechaRegistroEstado = fechaRegistroEstado;
	}
	/**
	 * @return the tipoCupon
	 */
	public String getTipoCupon() {
		return tipoCupon;
	}
	/**
	 * @param tipoCupon the tipoCupon to set
	 */
	public void setTipoCupon(String tipoCupon) {
		this.tipoCupon = tipoCupon;
	}
}