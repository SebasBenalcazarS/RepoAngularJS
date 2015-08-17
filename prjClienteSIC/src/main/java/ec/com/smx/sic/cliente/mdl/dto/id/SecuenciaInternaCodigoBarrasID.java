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
public class SecuenciaInternaCodigoBarrasID implements Serializable{

	@Column(name="SECUENCIA", nullable = false)
	private Long secuencia;

	/**
	 * @return the secuencia
	 */
	public Long getSecuencia() {
		return secuencia;
	}

	/**
	 * @param secuencia the secuencia to set
	 */
	public void setSecuencia(Long secuencia) {
		this.secuencia = secuencia;
	}
	
}
