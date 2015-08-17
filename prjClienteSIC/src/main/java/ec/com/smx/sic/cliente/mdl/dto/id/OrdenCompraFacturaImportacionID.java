/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class OrdenCompraFacturaImportacionID implements Serializable {
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania;
   
    @Column(name = "CODIGOORDENCOMPRA", nullable = false)
    private Long codigoOrdenCompra;
    
    @Column(name = "CODIGOFACTURA", nullable = false)
    private Long codigoFactura;

    
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
    
}
