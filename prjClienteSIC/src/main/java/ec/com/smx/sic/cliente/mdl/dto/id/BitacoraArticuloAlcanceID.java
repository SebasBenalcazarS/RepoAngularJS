package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
 * encapsula las propiedades Identificadoras de la clase ArticulBitacoraAlcanceDTO
 * @author corbe
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class BitacoraArticuloAlcanceID implements Serializable{
	/**
	 * Codigo de la companía
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Identificador único del registro
	 * 
	 */
	@Column(name = "SECUENCIALBITACORA", nullable = false)
	private String secuencialBitacora;
	
	/**
	 * 
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * 
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * 
	 * @return the secuencialBitacora
	 */
	public String getSecuencialBitacora() {
		return secuencialBitacora;
	}

	/**
	 * 
	 * @param secuencialBitacora the secuencialBitacora to set
	 */
	public void setSecuencialBitacora(String secuencialBitacora) {
		this.secuencialBitacora = secuencialBitacora;
	}

}
