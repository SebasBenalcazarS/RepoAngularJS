/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

/**
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
@Entity
public class VistaArticuloClasificacionDTO extends SearchDTO{
	@Id
	private String codigoArticulo;
	/**
	 * SETTERS & GETTERS
	 */

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	
}
