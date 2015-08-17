/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecepcionProveedorArticuloTransient;

/**
 * @author wcaiza
 *
 */
public interface IValidacionResumenRecepcionProveedorGestor {
	
	/**
	 * Validar que el objeto <code>RecepcionProveedorArticuloTransient</code> tenga los atributos necesarios 
	 * para realizar el update en el proceso de recepci&oacute;n
	 * @param recepcionProveedorArticuloTransient
	 * @throws SICException
	 */
	void validarActualizarRecepcionProveedorArticuloDesdeScaner (RecepcionProveedorArticuloTransient recepcionProveedorArticuloTransient) throws SICException;
	
	/**
	 * Validar que se envian todos los par&aacute;metros para realizar un delete en la tabla {@link RecepcionProveedorArticuloDTO}
	 * @param codigoCompania
	 * @param codigoRecepcionProveedor
	 * @throws SICException
	 */
	void validarEliminarRecepcionProveedorArticulo (Integer codigoCompania, Long codigoRecepcionProveedor) throws SICException;
	
}
