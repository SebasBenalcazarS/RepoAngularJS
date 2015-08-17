package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author hgudino
 * 
 */

@SuppressWarnings("serial")
@Embeddable
public class RutaParticipanteRegistroID implements Serializable{
	

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
	@Column(name = "SECUENCIAPARTICIPANTEREGISTRO", nullable = false)
    private java.lang.Long secuenciaParticipanteRegistro;

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

	public java.lang.Long getSecuenciaParticipanteRegistro() {
		return secuenciaParticipanteRegistro;
	}

	public void setSecuenciaParticipanteRegistro(java.lang.Long secuenciaParticipanteRegistro) {
		this.secuenciaParticipanteRegistro = secuenciaParticipanteRegistro;
	}
}
