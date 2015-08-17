/**
 * 
 */
package ec.com.smx.sic.cliente.resources.recibidoNoContabilizado;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * @author vjaramillo
 *
 */
public final class SICRecibidoNoContabilizadoMessages extends AbstractMessages {

	public static final SICRecibidoNoContabilizadoMessages INSTANCIA = new SICRecibidoNoContabilizadoMessages();
	
	public SICRecibidoNoContabilizadoMessages(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.recibidoNoContabilizado.RecibidoNoContabilizadoAplicacion"));
	}

	/**
	 * @return the instancia
	 */
	public static SICRecibidoNoContabilizadoMessages getInstancia() {
		return INSTANCIA;
	}
}
