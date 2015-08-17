/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class AlcanceBitacoraDetalleID implements Serializable{
	
	/**
	 * Codigo compania
	 *  
	 */
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	/**
	 * Codigo de Area Trabajo Bitacora
	 * 
	 */
	@Column(name = "CODARTARETRABIT", nullable = false)
	private Long codigoArticuloAreaTrabajoBitacora;
	

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	
	public Long getCodigoArticuloAreaTrabajoBitacora() {
		return codigoArticuloAreaTrabajoBitacora;
	}
	
	public void setCodigoArticuloAreaTrabajoBitacora(Long codigoArticuloAreaTrabajoBitacora) {
		this.codigoArticuloAreaTrabajoBitacora = codigoArticuloAreaTrabajoBitacora;
	}
}
