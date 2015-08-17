package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.corpv2.dto.id.BaseID;

/**
 * @author rgonzalez
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class OrdenCompraFacturaImpID extends BaseID{
	@Column(name = "CODIGOORDENCOMPRA")
	private Long codigoOrdenCompra;
	@Column(name = "CODIGOFACTURA")
	private Long codigoFactura;
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	/**
	 * @return the codigoOrdenCompra
	 */
	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}
	/**
	 * @param codigoOrdenCompra the codigoOrdenCompra to set
	 */
	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}
	/**
	 * @return the codigoFactura
	 */
	public Long getCodigoFactura() {
		return codigoFactura;
	}
	/**
	 * @param codigoFactura the codigoFactura to set
	 */
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
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

	
	
	
}
