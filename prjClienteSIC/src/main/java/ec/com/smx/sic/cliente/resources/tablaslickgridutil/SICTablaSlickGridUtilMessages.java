package ec.com.smx.sic.cliente.resources.tablaslickgridutil;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

public final class SICTablaSlickGridUtilMessages extends AbstractMessages {

	private static final SICTablaSlickGridUtilMessages INSTANCIA = new SICTablaSlickGridUtilMessages();

	private SICTablaSlickGridUtilMessages() {
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.tablaslickgridutil.TablaSlickGridUtilAplicacion"));
	}
	
	public static SICTablaSlickGridUtilMessages getInstancia() {
		return INSTANCIA;
	}
}
