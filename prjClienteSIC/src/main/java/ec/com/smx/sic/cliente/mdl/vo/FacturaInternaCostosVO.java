/*
 * Kruger 2015 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * <b> Representa Los costos que posee la factura Interna. </b>
 *
 * @author mchiliquinga, Date: 14/1/2015
 *
 */
@SuppressWarnings("serial")
public class FacturaInternaCostosVO implements Serializable {
	
	private BigDecimal valorTotal = BigDecimal.ZERO;
	
	private BigDecimal valorTotalIva12 = BigDecimal.ZERO;
	
	private BigDecimal valorTarifaIva12 = BigDecimal.ZERO;
	
	private BigDecimal valorTarifaIva0 = BigDecimal.ZERO;
	
	private BigDecimal valorImpVerde = BigDecimal.ZERO;
	
	private BigDecimal valorFacturado = BigDecimal.ZERO;
	
	private BigDecimal valorTotalDetalleFactura = BigDecimal.ZERO;
	
	private BigDecimal valorTotalIvaDetalleFactura = BigDecimal.ZERO;
	
	private BigDecimal valorTotalMercancia = BigDecimal.ZERO;
	
	private BigDecimal valorTotalDescuento = BigDecimal.ZERO;
	
	private BigDecimal valorDiferencia = BigDecimal.ZERO;
	
	private BigDecimal valorTotalOC = BigDecimal.ZERO;
	
	private Map<String, BigDecimal> valorAdicional;

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorTotalIva12() {
		return valorTotalIva12;
	}

	public void setValorTotalIva12(BigDecimal valorTotalIva12) {
		this.valorTotalIva12 = valorTotalIva12;
	}

	public BigDecimal getValorTarifaIva12() {
		return valorTarifaIva12;
	}

	public void setValorTarifaIva12(BigDecimal valorTarifaIva12) {
		this.valorTarifaIva12 = valorTarifaIva12;
	}

	public BigDecimal getValorTarifaIva0() {
		return valorTarifaIva0;
	}

	public void setValorTarifaIva0(BigDecimal valorTarifaIva0) {
		this.valorTarifaIva0 = valorTarifaIva0;
	}

	public BigDecimal getValorImpVerde() {
		return valorImpVerde;
	}

	public void setValorImpVerde(BigDecimal valorImpVerde) {
		this.valorImpVerde = valorImpVerde;
	}

	public BigDecimal getValorFacturado() {
		return valorFacturado;
	}

	public void setValorFacturado(BigDecimal valorFacturado) {
		this.valorFacturado = valorFacturado;
	}

	public BigDecimal getValorTotalDetalleFactura() {
		return valorTotalDetalleFactura;
	}

	public void setValorTotalDetalleFactura(BigDecimal valorTotalDetalleFactura) {
		this.valorTotalDetalleFactura = valorTotalDetalleFactura;
	}

	public BigDecimal getValorTotalIvaDetalleFactura() {
		return valorTotalIvaDetalleFactura;
	}

	public void setValorTotalIvaDetalleFactura(BigDecimal valorTotalIvaDetalleFactura) {
		this.valorTotalIvaDetalleFactura = valorTotalIvaDetalleFactura;
	}

	public BigDecimal getValorTotalMercancia() {
		return valorTotalMercancia;
	}

	public void setValorTotalMercancia(BigDecimal valorTotalMercancia) {
		this.valorTotalMercancia = valorTotalMercancia;
	}

	public BigDecimal getValorTotalDescuento() {
		return valorTotalDescuento;
	}

	public void setValorTotalDescuento(BigDecimal valorTotalDescuento) {
		this.valorTotalDescuento = valorTotalDescuento;
	}

	public BigDecimal getValorDiferencia() {
		return valorDiferencia;
	}

	public void setValorDiferencia(BigDecimal valorDiferencia) {
		this.valorDiferencia = valorDiferencia;
	}

	public BigDecimal getValorTotalOC() {
		return valorTotalOC;
	}

	public void setValorTotalOC(BigDecimal valorTotalOC) {
		this.valorTotalOC = valorTotalOC;
	}

	public Map<String, BigDecimal> getValorAdicional() {
		if (valorAdicional == null) {
			valorAdicional = new HashMap<String, BigDecimal>();
		}
		return valorAdicional;
	}
	
	public BigDecimal getValorAdicional(String nombreValorAdicional) {
		return valorAdicional.get(nombreValorAdicional);
	}
	
}
