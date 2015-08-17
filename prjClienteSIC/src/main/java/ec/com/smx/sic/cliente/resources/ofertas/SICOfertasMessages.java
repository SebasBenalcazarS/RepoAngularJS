/**
 * 
 */
package ec.com.smx.sic.cliente.resources.ofertas;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * @author gnolivos
 *
 */
public final class SICOfertasMessages extends AbstractMessages {

	private static final SICOfertasMessages INSTANCIA = new SICOfertasMessages();

	private SICOfertasMessages() {
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.ofertas.OfertasAplicacion"));
	}
	
	public static SICOfertasMessages getInstancia() {
		return INSTANCIA;
	}
}
