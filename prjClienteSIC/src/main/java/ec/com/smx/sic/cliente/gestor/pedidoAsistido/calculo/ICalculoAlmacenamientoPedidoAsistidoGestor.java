package ec.com.smx.sic.cliente.gestor.pedidoAsistido.calculo;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;

/**
 * @author finga
 *
 */
public interface ICalculoAlmacenamientoPedidoAsistidoGestor extends Serializable {

	/**
	 * Calculo de totales del pedido
	 * 
	 * @param pedidoPadre pedido padre
	 * @param detallePadre detalle padre
	 * @param pedidoHijo pedido hijo
	 * @param detalleHijo detalle hijo
	 * @throws SICException
	 */
	public void calcularTotalesPedido(PedidoAreaTrabajoDTO pedidoPadre, PedidoAreaTrabajoDetalleDTO detallePadre, PedidoAreaTrabajoDTO pedidoHijo, PedidoAreaTrabajoDetalleDTO detalleHijo,Boolean aplicaReserva) throws SICException;	
	
}
