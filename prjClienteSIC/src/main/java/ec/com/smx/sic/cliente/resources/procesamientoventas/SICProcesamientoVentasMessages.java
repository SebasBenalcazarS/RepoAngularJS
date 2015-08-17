/**
 * 
 */
package ec.com.smx.sic.cliente.resources.procesamientoventas;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * @author vjaramillo
 *
 */
public class SICProcesamientoVentasMessages extends AbstractMessages {

public static final SICProcesamientoVentasMessages INSTANCIA = new SICProcesamientoVentasMessages();
	
	public SICProcesamientoVentasMessages(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.procesamientoventa.ProcesamientoVentasAplicacion"));
	}

	/**
	 * @return the instancia
	 */
	public static SICProcesamientoVentasMessages getInstancia() {
		return INSTANCIA;
	}
	
}
