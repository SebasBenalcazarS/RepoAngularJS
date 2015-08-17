/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Victor Jaramillo
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class MigracionArticuloGeneralID implements Serializable {

	@Column(name = "CODIGOCOMPANIA" , nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "SECUENCIALCABECERA" , nullable = false)
	private Integer secuencialCabecera;
	
	@Column(name = "SECUENCIALDETALLE" , nullable = false)
	private Long secuencialDetalle;

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
	 * @return the secuencialCabecera
	 */
	public Integer getSecuencialCabecera() {
		return secuencialCabecera;
	}

	/**
	 * @param secuencialCabecera the secuencialCabecera to set
	 */
	public void setSecuencialCabecera(Integer secuencialCabecera) {
		this.secuencialCabecera = secuencialCabecera;
	}

	/**
	 * @return the secuencialDetalle
	 */
	public Long getSecuencialDetalle() {
		return secuencialDetalle;
	}

	/**
	 * @param secuencialDetalle the secuencialDetalle to set
	 */
	public void setSecuencialDetalle(Long secuencialDetalle) {
		this.secuencialDetalle = secuencialDetalle;
	}

	
}
