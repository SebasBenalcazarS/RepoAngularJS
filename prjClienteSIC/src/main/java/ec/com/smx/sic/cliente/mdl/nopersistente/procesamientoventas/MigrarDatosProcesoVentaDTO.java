/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente.procesamientoventas;

import java.math.BigDecimal;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.generadorexportacion.anotaciones.Format;

/**
 * @author vjaramillo
 *
 */
@SuppressWarnings("serial")
public class MigrarDatosProcesoVentaDTO extends SearchDTO {

	@Column(length = 1)
	private String tipoRegistro;
	
	@Column(length = 3)
	private Integer transaccion;
	
	@Column(length = 13)
	private String codigoBarras;
	
	@Column(length = 8)
	@Format(numberDecimals = 3)
	private BigDecimal cantidad;
	
	@Column(length = 11)
	@Format(numberDecimals = 2)
	private BigDecimal valorTotal;
	
	@Column(length = 1)
	private Integer cobraIva;
	
	@Column(length = 4)
	@Format(numberDecimals = 2)
	private Double porcentajeIva;

	/**
	 * @return the tipoRegistro
	 */
	public String getTipoRegistro() {
		return tipoRegistro;
	}

	/**
	 * @param tipoRegistro the tipoRegistro to set
	 */
	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	/**
	 * @return the transaccion
	 */
	public Integer getTransaccion() {
		return transaccion;
	}

	/**
	 * @param transaccion the transaccion to set
	 */
	public void setTransaccion(Integer transaccion) {
		this.transaccion = transaccion;
	}

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
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the cobraIva
	 */
	public Integer getCobraIva() {
		return cobraIva;
	}

	/**
	 * @param cobraIva the cobraIva to set
	 */
	public void setCobraIva(Integer cobraIva) {
		this.cobraIva = cobraIva;
	}

	/**
	 * @return the cantidad
	 */
	public BigDecimal getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the porcentajeIva
	 */
	public Double getPorcentajeIva() {
		return porcentajeIva;
	}

	/**
	 * @param porcentajeIva the porcentajeIva to set
	 */
	public void setPorcentajeIva(Double porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}
}
