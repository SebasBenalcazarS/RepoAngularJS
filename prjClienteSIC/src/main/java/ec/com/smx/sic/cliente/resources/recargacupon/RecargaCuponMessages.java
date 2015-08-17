/*
 * Creado el 2013-03-14
 */
package ec.com.smx.sic.cliente.resources.recargacupon;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * Gestor del archivo de propiedades interno de la Aplicacion
 * @author kruger
 */

public final class RecargaCuponMessages extends AbstractMessages{
	
	private static final RecargaCuponMessages INSTANCIA = new RecargaCuponMessages();
	
	private RecargaCuponMessages(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.recargacupon.RecargaCuponAplicacion"));   
	}
	
	public static RecargaCuponMessages getInstancia(){
		return INSTANCIA;
	}
	
}

