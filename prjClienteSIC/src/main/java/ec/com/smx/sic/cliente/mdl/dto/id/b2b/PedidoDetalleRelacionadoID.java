
package ec.com.smx.sic.cliente.mdl.dto.id.b2b;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase PedidoDetalleRelacionado
 * @see ec.com.smx.b2b.dto.PedidoDetalleRelacionado
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
@Deprecated
public class PedidoDetalleRelacionadoID implements Serializable {




	/**
	 * Codigo de la compania
	 *

	 */
	private Integer codigoCompania ;
		
	

	/**
	 * Codigo del Pedido
	 *

	 */
	private java.lang.Long pedidoOriginal ;
		
	

	/**
	 * Codigo del pedido que esta relacionad0
	 *

	 */
	private java.lang.Long pedidoRelacionado ;
		
	

	/**
	 * Codigo o numero de orden de compra en original
	 *

	 */
	private String ordenCompraOriginal ;
		
	

	/**
	 * Codigo de la orden de compra que esta relacionada
	 *

	 */
	private String ordenCompraRelacionada ;
		
	

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
	 * Retorna valor de propiedad <code>pedidoOriginal</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>pedidoOriginal</code>
	 */
	public java.lang.Long getPedidoOriginal(){
		return this.pedidoOriginal;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>pedidoOriginal</code>.
	 * @param pedidoOriginal1 
	 *		El valor a establecer para la propiedad <code>pedidoOriginal</code>.
	 */
	public void setPedidoOriginal( java.lang.Long pedidoOriginal1 ){
		this.pedidoOriginal=pedidoOriginal1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>pedidoRelacionado</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>pedidoRelacionado</code>
	 */
	public java.lang.Long getPedidoRelacionado(){
		return this.pedidoRelacionado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>pedidoRelacionado</code>.
	 * @param pedidoRelacionado1 
	 *		El valor a establecer para la propiedad <code>pedidoRelacionado</code>.
	 */
	public void setPedidoRelacionado( java.lang.Long pedidoRelacionado1 ){
		this.pedidoRelacionado=pedidoRelacionado1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>ordenCompraOriginal</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>ordenCompraOriginal</code>
	 */
	public String getOrdenCompraOriginal(){
		return this.ordenCompraOriginal;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>ordenCompraOriginal</code>.
	 * @param ordenCompraOriginal1 
	 *		El valor a establecer para la propiedad <code>ordenCompraOriginal</code>.
	 */
	public void setOrdenCompraOriginal( String ordenCompraOriginal1 ){
		this.ordenCompraOriginal=ordenCompraOriginal1;
		
		if(ordenCompraOriginal!=null && ordenCompraOriginal.length()>12){
			ordenCompraOriginal = ordenCompraOriginal.substring(0,12);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>ordenCompraRelacionada</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>ordenCompraRelacionada</code>
	 */
	public String getOrdenCompraRelacionada(){
		return this.ordenCompraRelacionada;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>ordenCompraRelacionada</code>.
	 * @param ordenCompraRelacionada1 
	 *		El valor a establecer para la propiedad <code>ordenCompraRelacionada</code>.
	 */
	public void setOrdenCompraRelacionada( String ordenCompraRelacionada1 ){
		this.ordenCompraRelacionada=ordenCompraRelacionada1;
		
		if(ordenCompraRelacionada!=null && ordenCompraRelacionada.length()>12){
			ordenCompraRelacionada = ordenCompraRelacionada.substring(0,12);
		}
				
				
	}

}

