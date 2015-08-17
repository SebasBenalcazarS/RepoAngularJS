package ec.com.smx.sic.cliente.resources.inventario;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * @author osaransig
 * Jun 20, 2014
 */
public class SICInventarioMessages extends AbstractMessages {
	
	private static final SICInventarioMessages INSTANCIA = new SICInventarioMessages();
	
	public SICInventarioMessages() {
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.inventario.InventarioAplicacion"));
	}

	/**
	 * @return the instancia
	 */
	public static SICInventarioMessages getInstancia() {
		return INSTANCIA;
	}
}
