/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorArticuloDTO;

/**
 * @author wcaiza
 *
 */
public interface ICalculoResumenRecepcionProveedorGestor extends Logeable {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @param codigoRecepcionProveedor
	 * @param codigoProveedor
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorArticuloDTO> obtenerRecepcionProveedorArticuloRegistrar(Integer codigoCompania, Long codigoProcesoLogistico, Long codigoRecepcionProveedor, String codigoProveedor, String userId) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @param codigoRecepcionProveedor
	 * @param codigoProveedor
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	Map<String, Collection<RecepcionProveedorArticuloDTO>> obtenerRecepcionProveedorArticuloActualizar(Integer codigoCompania, Long codigoProcesoLogistico, Long codigoRecepcionProveedor, String codigoProveedor, String userId) throws SICException;
	
	/**
	 * Consultar los registros de las recepcion proveedor articulo justificacion
	 * @param codigoCompania
	 * @param codigoRecepcionProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<Long> obtenerCodigosJusticacionesArticulo(Integer codigoCompania, Long codigoRecepcionProveedor) throws SICException;

}
