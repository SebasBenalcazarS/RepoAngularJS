package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author amunoz
 * @author cherrera
 * @author hgudino
 * 
 */

@SuppressWarnings("serial")
@Embeddable
public class RutaID implements Serializable{
	

	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA")
    private java.lang.Integer codigoCompania;
	
	/**
	 * Secuencial de la tabla Contenedor
	 * 
	 */
	@Column(name = "SECUENCIARUTA", nullable = false)
    private java.lang.Long secuenciaRuta;

	/**
	 * @return the codigoCompania
	 */
	public java.lang.Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(java.lang.Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the secuenciaRuta
	 */
	public java.lang.Long getSecuenciaRuta() {
		return secuenciaRuta;
	}

	/**
	 * @param secuenciaRuta the secuenciaRuta to set
	 */
	public void setSecuenciaRuta(java.lang.Long secuenciaRuta) {
		this.secuenciaRuta = secuenciaRuta;
	}
}
