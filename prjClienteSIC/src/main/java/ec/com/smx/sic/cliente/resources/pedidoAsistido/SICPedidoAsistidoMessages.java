package ec.com.smx.sic.cliente.resources.pedidoAsistido;

import ec.com.smx.sic.cliente.resources.AbstractMessages;
import ec.com.smx.sic.cliente.resources.Resource;

/**
 * 
 * @author amunoz
 *
 */
public class SICPedidoAsistidoMessages extends AbstractMessages {
private static final SICPedidoAsistidoMessages INSTANCIA = new SICPedidoAsistidoMessages();
	
	public SICPedidoAsistidoMessages(){
		this.setResource(new Resource("ec.com.smx.sic.cliente.resources.pedidoAsistido.PedidoAsistidoAplicacion"));
	}

	/**
	 * @return the instancia
	 */
	public static SICPedidoAsistidoMessages getInstancia() {
		return INSTANCIA;
	}
}
