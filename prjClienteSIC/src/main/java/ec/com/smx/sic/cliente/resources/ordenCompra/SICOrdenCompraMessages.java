/**
 * 
 */
package ec.com.smx.sic.cliente.resources.ordenCompra;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * @author jvillacis
 *
 */
public class SICOrdenCompraMessages extends AbstractMessages{
	private static final SICOrdenCompraMessages INSTANCIA = new SICOrdenCompraMessages();
	
	public SICOrdenCompraMessages(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.ordenCompra.OrdenCompraAplicacion"));
	}

	/**
	 * @return the instancia
	 */
	public static SICOrdenCompraMessages getInstancia() {
		return INSTANCIA;
	}
	
}
