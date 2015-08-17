/**
 * 
 */
package ec.com.smx.sic.cliente.resources.controlRutas;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * @author egudino
 *
 */
public class SICControlRutasMessages extends AbstractMessages{
	private static final SICControlRutasMessages INSTANCIA = new SICControlRutasMessages();
	
	public SICControlRutasMessages(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.controlRutas.ControlRutasAplicacion"));
	}

	/**
	 * @return the instancia
	 */
	public static SICControlRutasMessages getInstancia() {
		return INSTANCIA;
	}
	
}
