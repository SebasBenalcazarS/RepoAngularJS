package ec.com.smx.sic.cliente.mdl.nopersistente.procesamientoventas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import com.orientechnologies.orient.core.id.ORID;

/**
 * @author Luis Yacchirema
 *
 */
@SuppressWarnings("serial")
public class DatoTransaccionProcesamientoVenta implements Serializable {

	private ORID recordId;
	private Integer codigoCompania;
	private String codigoArticulo;
	private Integer codigoTransaccion;
	private BigDecimal totalVentaArticulo;
	private Integer codigoLocal;	
	private BigDecimal cantidadVentaAcumuladaArticuloLocal;
	private BigDecimal valorVentaAcumuladaArticuloLocal;
	private Map<Integer, BigDecimal> valorTotalAcumuladoDias;
	private Map<String, Object> valorTotalAcumuladoDiasObject;
	private BigDecimal precioConDescuento;
	private BigDecimal precioConRecuperacion;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return the codigoTransaccion
	 */
	public Integer getCodigoTransaccion() {
		return codigoTransaccion;
	}

	/**
	 * @param codigoTransaccion the codigoTransaccion to set
	 */
	public void setCodigoTransaccion(Integer codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}

	/**
	 * @return the totalVentaArticulo
	 */
	public BigDecimal getTotalVentaArticulo() {
		return totalVentaArticulo;
	}

	/**
	 * @param totalVentaArticulo the totalVentaArticulo to set
	 */
	public void setTotalVentaArticulo(BigDecimal totalVentaArticulo) {
		this.totalVentaArticulo = totalVentaArticulo;
	}

	/**
	 * @return the codigoLocal
	 */
	public Integer getCodigoLocal() {
		return codigoLocal;
	}

	/**
	 * @param codigoLocal the codigoLocal to set
	 */
	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	/**
	 * @return the cantidadVentaAcumuladaArticuloLocal
	 */
	public BigDecimal getCantidadVentaAcumuladaArticuloLocal() {
		return cantidadVentaAcumuladaArticuloLocal;
	}

	/**
	 * @param cantidadVentaAcumuladaArticuloLocal the cantidadVentaAcumuladaArticuloLocal to set
	 */
	public void setCantidadVentaAcumuladaArticuloLocal(BigDecimal cantidadVentaAcumuladaArticuloLocal) {

		this.cantidadVentaAcumuladaArticuloLocal = cantidadVentaAcumuladaArticuloLocal;
	}
	/**
	 * @return the valorVentaAcumuladaArticuloLocal
	 */
	public BigDecimal getValorVentaAcumuladaArticuloLocal() {
		return valorVentaAcumuladaArticuloLocal;
	}

	/**
	 * @param valorVentaAcumuladaArticuloLocal the valorVentaAcumuladaArticuloLocal to set
	 */
	public void setValorVentaAcumuladaArticuloLocal(BigDecimal valorVentaAcumuladaArticuloLocal) {
		this.valorVentaAcumuladaArticuloLocal = valorVentaAcumuladaArticuloLocal;
	}

	/**
	 * @return the recordId
	 */
	public ORID getRecordId() {
		return recordId;
	}

	/**
	 * @param recordId the recordId to set
	 */
	public void setRecordId(ORID recordId) {
		this.recordId = recordId;
	}

	/**
	 * @return the valorTotalAcumuladoDias
	 */
	public Map<Integer, BigDecimal> getValorTotalAcumuladoDias() {
		return valorTotalAcumuladoDias;
	}

	/**
	 * @param valorTotalAcumuladoDias the valorTotalAcumuladoDias to set
	 */
	public void setValorTotalAcumuladoDias(Map<Integer, BigDecimal> valorTotalAcumuladoDias) {
		this.valorTotalAcumuladoDias = valorTotalAcumuladoDias;
	}

	/**
	 * @return the valorTotalAcumuladoDiasObject
	 */
	public Map<String, Object> getValorTotalAcumuladoDiasObject() {
		return valorTotalAcumuladoDiasObject;
	}

	/**
	 * @param valorTotalAcumuladoDiasObject the valorTotalAcumuladoDiasObject to set
	 */
	public void setValorTotalAcumuladoDiasObject(Map<String, Object> valorTotalAcumuladoDiasObject) {
		this.valorTotalAcumuladoDiasObject = valorTotalAcumuladoDiasObject;
	}

	/**
	 * @return the precioConDescuento
	 */
	public BigDecimal getPrecioConDescuento() {
		return precioConDescuento;
	}

	/**
	 * @param precioConDescuento the precioConDescuento to set
	 */
	public void setPrecioConDescuento(BigDecimal precioConDescuento) {
		this.precioConDescuento = precioConDescuento;
	}

	/**
	 * @return the precioConRecuperacion
	 */
	public BigDecimal getPrecioConRecuperacion() {
		return precioConRecuperacion;
	}

	/**
	 * @param precioConRecuperacion the precioConRecuperacion to set
	 */
	public void setPrecioConRecuperacion(BigDecimal precioConRecuperacion) {
		this.precioConRecuperacion = precioConRecuperacion;
	}



}
