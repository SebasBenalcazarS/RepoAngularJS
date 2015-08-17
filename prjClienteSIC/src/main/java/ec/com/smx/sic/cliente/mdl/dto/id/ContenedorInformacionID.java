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
public class ContenedorInformacionID implements Serializable {
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name= "CODIGOCONTENEDOR", nullable = false)
	private Long codigoContenedor;

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
	 * @return the codigoContenedor
	 */
	public Long getCodigoContenedor() {
		return codigoContenedor;
	}

	/**
	 * @param codigoContenedor the codigoContenedor to set
	 */
	public void setCodigoContenedor(Long codigoContenedor) {
		this.codigoContenedor = codigoContenedor;
	}
	
}
