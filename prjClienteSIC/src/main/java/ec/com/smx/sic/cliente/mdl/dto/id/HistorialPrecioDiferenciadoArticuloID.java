package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class HistorialPrecioDiferenciadoArticuloID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOHISTORIALPRECIO", nullable = false)
	private Long codigoHistorialPrecio;
	
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
	 * @return the codigoHistorialPrecio
	 */
	public Long getCodigoHistorialPrecio() {
		return codigoHistorialPrecio;
	}

	/**
	 * @param codigoHistorialPrecio the codigoHistorialPrecio to set
	 */
	public void setCodigoHistorialPrecio(Long codigoHistorialPrecio) {
		this.codigoHistorialPrecio = codigoHistorialPrecio;
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
