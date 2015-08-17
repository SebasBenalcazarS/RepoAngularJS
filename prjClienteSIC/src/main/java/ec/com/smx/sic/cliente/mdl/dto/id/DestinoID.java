
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase DetalleSeccion
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO
 * 
 * @author egudino
 */
@SuppressWarnings("serial")
@Embeddable
public class DestinoID implements Serializable {

	/**
	 * C�digo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private java.lang.Integer codigoCompania;
		
	/**
	 * Especifica el codigo del detalle de la seccion
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

