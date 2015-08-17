/**
 * 
 */
package ec.com.smx.sic.cliente.resources.oficinaexterior;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * Gestor del archivo de propiedades interno del modulo de Oficinas en el exterior
 * 
 * @author Victor Jaramillo
 */
public final class SICOficinaExteriorMessages extends AbstractMessages{
	
	private static final SICOficinaExteriorMessages INSTANCIA = new SICOficinaExteriorMessages();
	
	private SICOficinaExteriorMessages(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.oficinaexterior.OficinaExteriorAplicacion"));   
	}
	
	public static SICOficinaExteriorMessages getInstancia(){
		return INSTANCIA;
	}
	
}
