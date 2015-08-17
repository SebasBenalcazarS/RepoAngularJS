package ec.com.smx.sic.cliente.resources.produccionEmpacado;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;


public final class SICProduccionMessajes extends AbstractMessages{
private static final SICProduccionMessajes INSTANCIA = new SICProduccionMessajes();
	
	private SICProduccionMessajes(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.produccion.ProduccionAplicacion"));   
	}
	
	public static SICProduccionMessajes getInstancia(){
		return INSTANCIA;
	}
}
