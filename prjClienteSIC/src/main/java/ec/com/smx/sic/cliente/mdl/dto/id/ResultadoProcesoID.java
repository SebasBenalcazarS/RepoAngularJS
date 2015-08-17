package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author jcayo
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ResultadoProcesoID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania;
	
	@Column(name = "CODIGORESULTADOPROCESO", nullable = false)
	private String codigoResultadoProceso;

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
	 * @return the codigoResultadoProceso
	 */
	public String getCodigoResultadoProceso() {
		return codigoResultadoProceso;
	}

	/**
	 * @param codigoResultadoProceso the codigoResultadoProceso to set
	 */
	public void setCodigoResultadoProceso(String codigoResultadoProceso) {
		this.codigoResultadoProceso = codigoResultadoProceso;
	}

	
}
