/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.articulo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author eharo
 *
 */

@Embeddable
@SuppressWarnings("serial")
public class GarantiaArticuloID implements Serializable {

	/**
	 * Secuencial generado 
	 */
	@Column(name = "SECUENCIALGARANTIA", nullable = false)
	private Long secuencialGarantia ;
		
	/**
	 * Codigo de la compañía
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;

	/**
	 * Retorna valor de propiedad <code>secuencialGarantia</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>secuencialGarantia</code>
	 */
	public Long getSecuencialGarantia(){
		return this.secuencialGarantia;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>secuencialGarantia</code>.
	 * @param secuencialGarantia1 
	 *		El valor a establecer para la propiedad <code>secuencialGarantia</code>.
	 */
	public void setSecuencialGarantia( java.lang.Long secuencialGarantia1 ){
		this.secuencialGarantia=secuencialGarantia1;
		
	}

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
}
