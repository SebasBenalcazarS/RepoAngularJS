/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Luis Yacchirema
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class PrecioDiferenciadoArticuloGestionID implements Serializable{

	@Column(name="CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	@Column(name = "CODIGOGESTIONPRECIO", nullable = false)
	private Long codigoGestionPrecio;

	@Column(name = "CODARTICULOPRECIODIFERENCIADO", nullable = false)
	private Long codigoArticuloPrecioDiferenciado;


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
	 * @return the codigoGestionPrecio
	 */
	public Long getCodigoGestionPrecio() {
		return codigoGestionPrecio;
	}

	/**
	 * @param codigoGestionPrecio the codigoGestionPrecio to set
	 */
	public void setCodigoGestionPrecio(Long codigoGestionPrecio) {
		this.codigoGestionPrecio = codigoGestionPrecio;
	}

	/**
	 * @return the codigoArticuloPrecioDiferenciado
	 */
	public Long getCodigoArticuloPrecioDiferenciado() {
		return codigoArticuloPrecioDiferenciado;
	}

	/**
	 * @param codigoArticuloPrecioDiferenciado the codigoArticuloPrecioDiferenciado to set
	 */
	public void setCodigoArticuloPrecioDiferenciado(Long codigoArticuloPrecioDiferenciado) {
		this.codigoArticuloPrecioDiferenciado = codigoArticuloPrecioDiferenciado;
	}

}
