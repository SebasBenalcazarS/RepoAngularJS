package ec.com.smx.sic.cliente.gestor.ordenCompra.almacenamiento;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;

/**
 * @author aguato
 *
 */
public interface IMigracionOrdenCompraMAXGestor extends Serializable{
	
	/**
	 * @param pedidoGenerado
	 * @throws SICException
	 */
	public void migrarOrdenCompraMAXtoWRT(OrdenCompraEstadoDTO ordenCompraEstadoDTO, boolean actualizar) throws SICException;
	
	/**
	 * Migra las ordenes de compra
	 * que fueron creadas/editadas/
	 * anuladas
	 * 
	 * @param pedidoDTO
	 * @param mensajesErroOmitirOrdenCompra
	 * @throws SICException
	 */
	public void migrarOrdenesCompraPedidoMAXtoSIC(PedidoDTO pedidoDTO, String mensajesErroOmitirOrdenCompra) throws SICException;
	
}
