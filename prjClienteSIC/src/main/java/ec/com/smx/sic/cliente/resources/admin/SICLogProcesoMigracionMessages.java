/**
 * 
 */
package ec.com.smx.sic.cliente.resources.admin;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * @author aguato
 *
 */
public class SICLogProcesoMigracionMessages extends AbstractMessages{
	private static final SICLogProcesoMigracionMessages INSTANCIA = new SICLogProcesoMigracionMessages();
	
	public SICLogProcesoMigracionMessages(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.admin.LogProcesoMigracion"));
	}

	/**
	 * @return the instancia
	 */
	public static SICLogProcesoMigracionMessages getInstancia() {
		return INSTANCIA;
	}
	
}
