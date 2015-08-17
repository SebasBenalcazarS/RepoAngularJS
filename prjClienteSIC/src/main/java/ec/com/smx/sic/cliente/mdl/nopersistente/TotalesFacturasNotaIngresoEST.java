package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.math.BigDecimal;

/**
 * Estructura que contiene los totales de las facturas del proveedor de la nota de ingreso
 * @author fcollaguazo
 *
 */
public class TotalesFacturasNotaIngresoEST {

	private Long codigoNotaIngreso;
	
	private Long codigoFacturaProveedor;
	
	private String valorTipoDocumento;
	
	private Integer codigoTipoDocumento;
	
	private Integer codigoTipoImpuesto;
	
	private BigDecimal totalImpuesto;
	
	private BigDecimal totalSujetoImpuesto;

	public Long getCodigoNotaIngreso() {
		return codigoNotaIngreso;
	}

	public void setCodigoNotaIngreso(Long codigoNotaIngreso) {
		this.codigoNotaIngreso = codigoNotaIngreso;
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

	public BigDecimal getTotalImpuesto() {
		return totalImpuesto;
	}

	public void setTotalImpuesto(BigDecimal totalImpuesto) {
		this.totalImpuesto = totalImpuesto;
	}

	public BigDecimal getTotalSujetoImpuesto() {
		return totalSujetoImpuesto;
	}

	public void setTotalSujetoImpuesto(BigDecimal totalSujetoImpuesto) {
		this.totalSujetoImpuesto = totalSujetoImpuesto;
	}

	public Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}

	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
	}

	/**
	 * @return the codigoFacturaProveedor
	 */
	public Long getCodigoFacturaProveedor() {
		return codigoFacturaProveedor;
	}

	/**
	 * @param codigoFacturaProveedor the codigoFacturaProveedor to set
	 */
	public void setCodigoFacturaProveedor(Long codigoFacturaProveedor) {
		this.codigoFacturaProveedor = codigoFacturaProveedor;
	}
}