/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;

/**
 * @author wcaiza
 *
 */
public interface ICalculoRecepcionPereciblesGestor {
	
	Collection<Long> obtenerCodigoOrdenCompraDetalleEstado (Collection<OrdenCompraDetalleEstadoDTO> colOrdenCompraDetalleEstado);
	
	EntregaDTO obtenerEntregaPlantilla (RecepcionProveedorDTO recepcionProveedorDTO, Date fechaActual);
	
	PedidoDTO obtenerPedidoPlantilla (RecepcionProveedorDTO recepcionProveedorDTO, Date fechaActual);
	
	/**
	 * 
	 * @param recepcionProveedorDTO
	 * @param colCodigoProveedor
	 * @param incluirOrdenesSinFDI
	 * @return
	 * @throws SICException
	 */
	Map<String, Collection<EntregaDTO>> obtenerMapRecepcionProveedorPerecibles(RecepcionProveedorDTO recepcionProveedorDTO, Collection<String> colCodigoProveedor, Boolean incluirOrdenesSinFDI) throws SICException;

}
