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
public class OrdenCompraHistoricoEstadoID implements Serializable {
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOORDENCOMPRA", nullable = false)
	private Long codigoOrdenCompra;
	
	@Column(name = "CODIGOESTADOCATVAL", nullable = false)
	private String codigoEstadoCatVal;
	
	@Column(name = "CODIGOESTADOCATTIP", nullable = false)
	private Integer codigoEstadoCatTip;

	
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
	 * @return the codigoEstadoCatVal
	 */
	public String getCodigoEstadoCatVal() {
		return codigoEstadoCatVal;
	}

	/**
	 * @param codigoEstadoCatVal the codigoEstadoCatVal to set
	 */
	public void setCodigoEstadoCatVal(String codigoEstadoCatVal) {
		this.codigoEstadoCatVal = codigoEstadoCatVal;
	}

	/**
	 * @return the codigoEstadoCatTip
	 */
	public Integer getCodigoEstadoCatTip() {
		return codigoEstadoCatTip;
	}

	/**
	 * @param codigoEstadoCatTip the codigoEstadoCatTip to set
	 */
	public void setCodigoEstadoCatTip(Integer codigoEstadoCatTip) {
		this.codigoEstadoCatTip = codigoEstadoCatTip;
	}
	
}
