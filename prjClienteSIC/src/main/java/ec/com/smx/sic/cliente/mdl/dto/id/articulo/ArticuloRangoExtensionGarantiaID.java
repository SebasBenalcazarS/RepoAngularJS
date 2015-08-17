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
public class ArticuloRangoExtensionGarantiaID implements Serializable {

	/**
	 * Codigo de la compañía
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;

	/**
	 * Secuencial de la tabala rango
	 */
	@Column(name = "SECUENCIALRANGO", nullable = false)
	private Integer secuencialRango ;

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * @param codigoCompania1 
	 *		El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * Secuencial de la tabla rango <code>secuencialRango</code>.
	 * @return  secuencialRango 
	 *		Retorna el valor a establecer para la propiedad <code>secuencialRango</code>.
	 */
	public Integer getSecuencialRango() {
		return secuencialRango;
	}

	/**
	 * Secuencial de la tabla rango <code>secuencialRango</code>.
	 * @param secuencialRango 
	 *		El valor a establecer para la propiedad <code>secuencialRango</code>.
	 */
	public void setSecuencialRango(Integer secuencialRango) {
		this.secuencialRango = secuencialRango;
	}
}
