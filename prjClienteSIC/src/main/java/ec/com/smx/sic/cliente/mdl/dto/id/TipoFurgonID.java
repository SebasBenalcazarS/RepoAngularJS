
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase TipoFurgonDTO
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.TipoFurgonDTO
 * 
 * @author egudino
 */
@SuppressWarnings("serial")
@Embeddable
public class TipoFurgonID implements Serializable {

	/**
	 * Codigo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
		
		
	/**
	 * Valor del tipo de furgon 
	 *
	 */
	@Column(name="CODIGOTIPOFURGON")
	private java.lang.Long codigoTipoFurgon ;

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
	 * @return the codigoTipoFurgon
	 */
	public java.lang.Long getCodigoTipoFurgon() {
		return codigoTipoFurgon;
	}

	/**
	 * @param codigoTipoFurgon the codigoTipoFurgon to set
	 */
	public void setCodigoTipoFurgon(java.lang.Long codigoTipoFurgon) {
		this.codigoTipoFurgon = codigoTipoFurgon;
	}

	
	
}

