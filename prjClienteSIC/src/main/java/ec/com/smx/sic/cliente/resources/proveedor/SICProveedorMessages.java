/**
 * 
 */
package ec.com.smx.sic.cliente.resources.proveedor;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * Gestor del archivo de propiedades interno del modulo de Proveedores
 * 
 * @author Mario Braganza
 */
public final class SICProveedorMessages extends AbstractMessages{
	
	private static final SICProveedorMessages INSTANCIA = new SICProveedorMessages();
	
	private SICProveedorMessages(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.proveedor.ProveedorAplicacion"));   
	}
	
	public static SICProveedorMessages getInstancia(){
		return INSTANCIA;
	}
	
}
