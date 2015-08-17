/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.proveedor;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author mbraganza
 *
 */
public interface IAuditoriaProveedorServicio extends Serializable {
	

	/**
	 * @param codigoCompania
	 * @param codigoIdProveedor
	 * @return
	 * @throws SICException
	 */
	String obtenerIdLogAuditoriaProveedor(Integer codigoCompania, String codigoIdProveedor) throws SICException; 

}
