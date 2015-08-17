/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author srivera
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class TipoEquivalenciaID implements Serializable{

	/**
	 * Codigo de la compañía
	 *

	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	

	/**
	 * Codigo del tipo de equivalencia
	 *

	 */
	@Column(name = "CODTIPEQU", nullable = false)
	private Integer codigoTipoEquivalencia ;
		
	

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
	 * Retorna valor de propiedad <code>codigoTipoEquivalencia</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoTipoEquivalencia</code>
	 */
	public Integer getCodigoTipoEquivalencia(){
		return this.codigoTipoEquivalencia;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoEquivalencia</code>.
	 * @param codigoTipoEquivalencia1 
	 *		El valor a establecer para la propiedad <code>codigoTipoEquivalencia</code>.
	 */
	public void setCodigoTipoEquivalencia( Integer codigoTipoEquivalencia1 ){
		this.codigoTipoEquivalencia=codigoTipoEquivalencia1;
		
	}

}
