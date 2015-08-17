/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
public class GrupoAlcanceLocalID implements Serializable{

	/**
	 * Codigo de la companía
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Código del grupo de alcance
	 */
	@Column(name = "CODIGOGRUPOALCANCE", nullable = false)
	private String codigoGrupoAlcance;

	/**
	 * Código del local
	 */
	@Column(name = "CODIGOLOCAL", nullable = false)
	private Integer codigoLocal;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoGrupoAlcance() {
		return codigoGrupoAlcance;
	}

	public void setCodigoGrupoAlcance(String codigoGrupoAlcance) {
		this.codigoGrupoAlcance = codigoGrupoAlcance;
	}

	public Integer getCodigoLocal() {
		return codigoLocal;
	}

	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}
}
