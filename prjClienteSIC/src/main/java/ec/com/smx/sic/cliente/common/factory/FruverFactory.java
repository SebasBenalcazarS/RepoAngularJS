/**
 * 
 */
package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.servicio.fruver.IFruverServicio;

/**
 * @author jcayo<josecayo4@gmail.com>
 *
 */
public class FruverFactory extends SICSpringContextFactory {
	/**
	 * 
	 * @return
	 */
	public IFruverServicio getFruverServicio(){
		return (IFruverServicio) getBean(SICFactoryConstantes.FRUVER_SERVICIO);
	}
}
