/**
 * 
 */
package ec.com.smx.sic.cliente.resources.articulo;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * Gestor del archivo de propiedades interno del modulo de Proveedores
 * 
 * @author Mario Braganza
 */
public final class SICArticuloMessages extends AbstractMessages{
	
	private static final SICArticuloMessages INSTANCIA = new SICArticuloMessages();
	
	private SICArticuloMessages(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.articulo.ArticuloAplicacion"));   
	}
	
	public static SICArticuloMessages getInstancia(){
		return INSTANCIA;
	}
	
}
