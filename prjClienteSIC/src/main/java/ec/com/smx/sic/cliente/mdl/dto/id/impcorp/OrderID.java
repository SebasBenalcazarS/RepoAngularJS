
package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;
import javax.persistence.Embeddable;

import ec.com.smx.corpv2.dto.id.BaseID;
/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Order
 * @see ec.com.smx.sic.cliente.mdl.dto.impcorp.Order
 *
 * @author kruger
 * @author walvarez
 */
@SuppressWarnings("serial")
@Embeddable

public class OrderID extends BaseID {

	/**
	 * numero
	 */
	private String number ;
	
	/**
	 * Retorna valor de propiedad <code>number</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>number</code>
	 */
	public String getNumber(){
		return this.number;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>number</code>.
	 * @param number1 
	 *		El valor a establecer para la propiedad <code>number</code>.
	 */
	public void setNumber( String number1 ){
		this.number=number1;
	}
}

