/*
 * Creado el 28/03/2007
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
public class FrecuenciaArticuloID implements Serializable {

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	@Column(name = "CODIGOFRECUENCIA", nullable = false)
	private String codigoFrecuencia;
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	public FrecuenciaArticuloID() {}
	public FrecuenciaArticuloID(Boolean initID) {
		if(initID){
			codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			codigoFrecuencia = SICConstantes.getInstancia().VALOR_INICIAL_ID;
			codigoArticulo = SICConstantes.getInstancia().VALOR_INICIAL_ID;
		}
	}
	/**
	 * @return Devuelve codigoArticulo.
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo
	 *            El codigoArticulo a establecer.
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
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
