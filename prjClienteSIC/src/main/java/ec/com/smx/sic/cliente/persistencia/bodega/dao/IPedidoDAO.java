/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;

/**
 * @author wcaiza
 *
 */
public interface IPedidoDAO {
	
	/**
	 * 
	 * @param pedidoPlantilla
	 * @param colCodigoProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<PedidoDTO> obtenerPedidosParaRecepcionBodega(PedidoDTO pedidoPlantilla, Collection<String> colCodigoProveedor) throws SICException;
	
	
	Collection<String> obtenerCodigoProveedorParaRecepcionBodega(PedidoDTO pedidoPlantilla, Collection<String> colCodigoProveedorIncluir, Collection<String> colCodigoProveedorExcluir) throws SICException;
	

}
