package ec.com.smx.sic.cliente.resources.convenios;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;



public final class SICConvenioMessages extends AbstractMessages{
private static final SICConvenioMessages INSTANCIA = new SICConvenioMessages();
	
	private SICConvenioMessages(){
		this.setResource(new Resource("ec.com.smx.cem.cliente.resources.convenio.ConvenioAplicacion"));   
	}
	
	public static SICConvenioMessages getInstancia(){
		return INSTANCIA;
	}
}
