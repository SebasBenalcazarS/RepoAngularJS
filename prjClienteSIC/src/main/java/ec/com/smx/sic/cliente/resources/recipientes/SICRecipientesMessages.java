package ec.com.smx.sic.cliente.resources.recipientes;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * 
 * @author amunoz
 *
 */
public class SICRecipientesMessages extends AbstractMessages {
private static final SICRecipientesMessages INSTANCIA = new SICRecipientesMessages();
	
	public SICRecipientesMessages(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.recipientes.RecipientesAplicacion"));
	}

	/**
	 * @return the instancia
	 */
	public static SICRecipientesMessages getInstancia() {
		return INSTANCIA;
	}
}
