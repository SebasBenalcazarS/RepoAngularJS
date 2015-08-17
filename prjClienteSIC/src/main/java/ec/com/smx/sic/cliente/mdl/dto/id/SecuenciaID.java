/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class SecuenciaID implements Serializable{

	/**
	 * Código de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	/**
	 * Código de la secuencia
	 */
	@Column(name = "CODIGOSECUENCIA", nullable = false)
	private String codigoSecuencia;
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
	 * @return the codigoSecuencia
	 */
	public String getCodigoSecuencia() {
		return codigoSecuencia;
	}
	/**
	 * @param codigoSecuencia the codigoSecuencia to set
	 */
	public void setCodigoSecuencia(String codigoSecuencia) {
		this.codigoSecuencia = codigoSecuencia;
	}
}
