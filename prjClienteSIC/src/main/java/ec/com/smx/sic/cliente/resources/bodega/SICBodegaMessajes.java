package ec.com.smx.sic.cliente.resources.bodega;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;


public final class SICBodegaMessajes extends AbstractMessages{
private static final SICBodegaMessajes INSTANCIA = new SICBodegaMessajes();
	
	private SICBodegaMessajes(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.bodega.BodegaAplicacion"));   
	}
	
	public static SICBodegaMessajes getInstancia(){
		return INSTANCIA;
	}
}
