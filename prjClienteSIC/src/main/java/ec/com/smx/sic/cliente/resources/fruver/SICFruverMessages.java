/**
 * 
 */
package ec.com.smx.sic.cliente.resources.fruver;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * @author jcayo<josecayo4@gmail.com>
 *
 */
public class SICFruverMessages extends AbstractMessages{
	private static final SICFruverMessages INSTANCIA = new SICFruverMessages();
	
	public SICFruverMessages(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.fruver.FruverAplicacion"));
	}

	/**
	 * @return the instancia
	 */
	public static SICFruverMessages getInstancia() {
		return INSTANCIA;
	}
	
}
