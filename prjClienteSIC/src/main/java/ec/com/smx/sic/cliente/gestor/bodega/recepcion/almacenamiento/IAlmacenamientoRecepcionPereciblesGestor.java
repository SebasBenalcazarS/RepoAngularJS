/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;

/**
 * @author wcaiza
 *
 */
public interface IAlmacenamientoRecepcionPereciblesGestor {
	
	/**
	 * Registrar las recepciones para los proveedores con entregas planificadas desde el B2B 
	 * y ordenes de compra en estado enviadas para la fecha actual para la bodega de perecibles.
	 * @param recepcionProveedorDTO
	 * @param incluirOrdenesSinFDI
	 * @throws SICException
	 */
	void registrarRecepcionPerecibles (RecepcionProveedorDTO recepcionProveedorDTO, Collection<String> colCodigoProveedor, Boolean incluirOrdenesSinFDI) throws SICException;
	

	/**
	 * Ejecutar el proceso spring batch que registra las recepciones de proveedores para la bodega de perecibles
	 * @param recepcionProveedorDTO
	 * @param incluirOrdenesSinFDI
	 * @throws SICException
	 */
	void ejecutarRecepcionPereciblesBatch(RecepcionProveedorDTO recepcionProveedorDTO, Boolean incluirOrdenesSinFDI);
	
}