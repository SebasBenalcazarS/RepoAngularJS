/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.ordenCompra.almacenamiento;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.b2b.PedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.b2b.PedidoDetalleRelacionadoDTO;

/**
 * @author jvillacis
 *
 */
public interface IMigracionOrdenCompraB2BGestor extends Serializable{
	
	/**
	 * 
	 * @param pedidoDTOB2B
	 * @throws SICException
	 */
	public void migrarOrdenCompraB2B(PedidoDTO pedidoDTOB2B) throws SICException;
	
	/**
	 * 
	 * @param pedidoDetalleRelacionadoDTOB2B
	 * @throws SICException
	 */
	public void migrarOrdenCompraRelacionadaB2B(PedidoDetalleRelacionadoDTO pedidoDetalleRelacionadoDTOB2B)throws SICException;
	
}
