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
public class VistaGrupoAlcanceLocalID implements Serializable{

	/**
	 * Codigo de la companía
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Código del grupo
	 * 
	 */
	@Column(name = "CODIGOGRUPOTRABAJO", nullable = false)	
	private Long codigoGrupoTrabajo;

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
	 * @return the codigoGrupoTrabajo
	 */
	public Long getCodigoGrupoTrabajo() {
		return codigoGrupoTrabajo;
	}

	/**
	 * @param codigoGrupoTrabajo the codigoGrupoTrabajo to set
	 */
	public void setCodigoGrupoTrabajo(Long codigoGrupoTrabajo) {
		this.codigoGrupoTrabajo = codigoGrupoTrabajo;
	}
}
