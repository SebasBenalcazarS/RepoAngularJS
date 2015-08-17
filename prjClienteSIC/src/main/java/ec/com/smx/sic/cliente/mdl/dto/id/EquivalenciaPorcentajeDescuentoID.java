
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase EquivalenciaPorcentajeDescuento
 * @see ec.com.smx.sic.cliente.mdl.dto.EquivalenciaPorcentajeDescuento
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class EquivalenciaPorcentajeDescuentoID implements Serializable {

	/**
	 * C�digo de la compania
	 *

	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	/**
	 * Secuencial de la equivalencia
	 *
	 */
	@Column(name = "CODIGOEQUIVALENCIA", nullable = false)
	private Integer codigoEquivalencia ;
	
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
	 * Retorna valor de propiedad <code>codigoEquivalencia</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoEquivalencia</code>
	 */
	public Integer getCodigoEquivalencia(){
		return this.codigoEquivalencia;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoEquivalencia</code>.
	 * @param codigoEquivalencia1 
	 *		El valor a establecer para la propiedad <code>codigoEquivalencia</code>.
	 */
	public void setCodigoEquivalencia( Integer codigoEquivalencia1 ){
		this.codigoEquivalencia=codigoEquivalencia1;
		
	}
	
}

