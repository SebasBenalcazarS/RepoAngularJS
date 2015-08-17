
package ec.com.smx.sic.cliente.mdl.dto.id.b2b;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Pedido
 * @see ec.com.smx.b2b.dto.Pedido
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
@Deprecated
public class PedidoID implements Serializable
{

	/**
	 * codigo de la compania
	 */
	private Integer codigoCompania ;

	/**
	 * codigo asignado al pedido
	 */
	private java.lang.Long codigoPedido ;
	
	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania()
	{
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * @param codigoCompania1 
	 *		El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania( Integer codigoCompania1 )
	{
		this.codigoCompania=codigoCompania1;
	}

	/**
	 * Retorna valor de propiedad <code>codigoPedido</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoPedido</code>
	 */
	public java.lang.Long getCodigoPedido()
	{
		return this.codigoPedido;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoPedido</code>.
	 * @param codigoPedido1 
	 *		El valor a establecer para la propiedad <code>codigoPedido</code>.
	 */
	public void setCodigoPedido( java.lang.Long codigoPedido1 )
	{
		this.codigoPedido=codigoPedido1;
	}

	/* (sin Javadoc)
	 * @see ec.com.smx.b2b.commons.dto.id.AbstractaID#configureColIds()
	 */
	/*public void configureColIds()
	{
		super.resetCollection();
	    
		super.addElement(this.codigoCompania);	    	
		    
		super.addElement(this.codigoPedido);	    	
		    
		super.collectionToArray();
	}*/

}
