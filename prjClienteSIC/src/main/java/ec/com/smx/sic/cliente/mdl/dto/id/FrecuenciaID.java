/*
 * Creado el 13/06/2012
 *
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * @author fmunoz
 * 
 */
@SuppressWarnings("serial")
@Embeddable
public class FrecuenciaID implements Serializable {
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	@Column(name = "CODIGOFRECUENCIA", nullable = false)
	private String codigoFrecuencia;

	public FrecuenciaID() {}
	public FrecuenciaID(Boolean initID) {
		if(initID){
			codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			codigoFrecuencia = SICConstantes.getInstancia().VALOR_INICIAL_ID;
		}
	}
	/**
	 * @return Devuelve codigoCompania.
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania
	 *            El codigoCompania a establecer.
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return Devuelve codigoFrecuencia.
	 */
	public String getCodigoFrecuencia() {
		return codigoFrecuencia;
	}

	/**
	 * @param codigoFrecuencia
	 *            El codigoFrecuencia a establecer.
	 */
	public void setCodigoFrecuencia(String codigoFrecuencia) {
		this.codigoFrecuencia = codigoFrecuencia;
	}
}
