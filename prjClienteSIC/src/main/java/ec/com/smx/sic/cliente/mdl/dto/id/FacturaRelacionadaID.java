package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class FacturaRelacionadaID implements Serializable{

	/**
	 * Código de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	/**
	 * Especifica el codigo de la factura padre
	 *
	 */
	@Column(name = "CODIGOFACTURA", nullable = false)
	private Long codigoFactura ;
	
	/**
	 * Especifica el codigo de la factura padre
	 *
	 */
	@Column(name = "CODIGOFACTURARELACIONADA", nullable = false)
	private Long codigoFacturaRelacionada ;

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
	 * @return the codigoFacturaRelacionada
	 */
	public Long getCodigoFacturaRelacionada() {
		return codigoFacturaRelacionada;
	}

	/**
	 * @param codigoFacturaRelacionada the codigoFacturaRelacionada to set
	 */
	public void setCodigoFacturaRelacionada(Long codigoFacturaRelacionada) {
		this.codigoFacturaRelacionada = codigoFacturaRelacionada;
	}
}
