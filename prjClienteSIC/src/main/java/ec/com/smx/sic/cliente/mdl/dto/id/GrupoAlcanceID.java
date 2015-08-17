package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula las claves primarias para la tabla catalogo Grupo Alcance
 * @author amunoz
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class GrupoAlcanceID implements Serializable{

	/**
	 * Código de la compania
	 * 
	 */
	@Column(name="CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	/**
	 * Código del grupo alcance
	 */
	@Column(name = "CODIGOGRUPOALCANCE", nullable = false)
	private String codigoGrupoAlcance;
	
	
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
		this.codigoGrupoAlcance = codigoGrupoAlcance != null ? codigoGrupoAlcance.toUpperCase() : null;
	}
	
	
	
}
