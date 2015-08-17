
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase GuiaTransporte
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.GuiaTransporteDestinoDTO
 * 
 * @author egudino
 */
@SuppressWarnings("serial")
@Embeddable
public class GuiaTransporteDestinoID implements Serializable {
	
	/**
	 * C�digo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private java.lang.Integer codigoCompania;
		
	/**
	 * Especifica el codigo de la guia padre
	 *
	 */
	@Column(name = "SECUENCIAGUIA", nullable = false)
	private java.lang.Long secuenciaGuia;
	
	/**
	 * Especifica el codigo del secuencia del destino
	 *
	 */
	@Column(name = "SECUENCIADESTINO", nullable = false)
	private java.lang.Long secuenciaDestino;

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania(){
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * @param codigoCompania1 
	 *		El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania( Integer codigoCompania1 ){
		this.codigoCompania=codigoCompania1;
		
	}

	/**
	 * @return the secuenciaGuia
	 */
	public java.lang.Long getSecuenciaGuia() {
		return secuenciaGuia;
	}

	/**
	 * @param secuenciaGuia the secuenciaGuia to set
	 */
	public void setSecuenciaGuia(java.lang.Long secuenciaGuia) {
		this.secuenciaGuia = secuenciaGuia;
	}

	/**
	 * @return the secuenciaDestino
	 */
	public java.lang.Long getSecuenciaDestino() {
		return secuenciaDestino;
	}

	/**
	 * @param secuenciaDestino the secuenciaDestino to set
	 */
	public void setSecuenciaDestino(java.lang.Long secuenciaDestino) {
		this.secuenciaDestino = secuenciaDestino;
	}	
}

