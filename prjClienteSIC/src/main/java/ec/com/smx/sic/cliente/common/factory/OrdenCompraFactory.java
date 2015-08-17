/**
 * 
 */
package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.servicio.ordenCompra.IMigracionOrdenCompraServicio;
import ec.com.smx.sic.cliente.servicio.ordenCompra.IOrdenCompraServicio;

/**
 * @author jvillacis
 *
 */
public class OrdenCompraFactory extends SICSpringContextFactory {
	/**
	 * 
	 * @return
	 */
	public IOrdenCompraServicio getOrdenCompraServicio(){
		return (IOrdenCompraServicio) getBean(SICFactoryConstantes.ORDEN_COMPRA_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 */
	public IMigracionOrdenCompraServicio getMigrarOrdenCompraServicio(){
		return(IMigracionOrdenCompraServicio) getBean(SICFactoryConstantes.ORDEN_COMPRA_MIGRAR_SERVICIO);
	}
}
