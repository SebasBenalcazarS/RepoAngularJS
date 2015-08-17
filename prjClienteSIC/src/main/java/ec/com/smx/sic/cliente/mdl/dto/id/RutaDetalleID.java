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
public class RutaDetalleID implements Serializable{
	
	
	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA")
	private java.lang.Integer codigoCompania;
	
	/**
	 * Secuencial de la tabla ruta detalle 
	 * 
	 */
	@Column(name = "SECUENCIADETALLE", nullable = false)
	private java.lang.Long secuenciaDetalle;
	
	
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
	 * @return the secuenciaDetalle
	 */
	public java.lang.Long getSecuenciaDetalle() {
		return secuenciaDetalle;
	}

	/**
	 * @param secuenciaDetalle the secuenciaDetalle to set
	 */
	public void setSecuenciaDetalle(java.lang.Long secuenciaDetalle) {
		this.secuenciaDetalle = secuenciaDetalle;
	}	
}
