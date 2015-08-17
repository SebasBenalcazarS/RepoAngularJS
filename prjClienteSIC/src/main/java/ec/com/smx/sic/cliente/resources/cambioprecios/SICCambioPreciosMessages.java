package ec.com.smx.sic.cliente.resources.cambioprecios;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

public final class SICCambioPreciosMessages extends AbstractMessages {
	
	private static final SICCambioPreciosMessages INSTANCIA = new SICCambioPreciosMessages();

	private SICCambioPreciosMessages() {
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.cambioprecios.CambioPreciosAplicacion"));
	}
	
	public static SICCambioPreciosMessages getInstancia() {
		return INSTANCIA;
	}
}
