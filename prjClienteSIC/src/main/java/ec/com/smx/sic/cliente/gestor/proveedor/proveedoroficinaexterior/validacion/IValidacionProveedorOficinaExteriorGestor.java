/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.proveedoroficinaexterior.validacion;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;
import ec.com.smx.sic.cliente.mdl.dto.OficinaExteriorDTO;

/**
 * @author mbraganza
 *
 */
public interface IValidacionProveedorOficinaExteriorGestor extends Serializable {
	/**
	 * 
	 * @param proveedor
	 * @return
	 * @throws SICException
	 */
	public Boolean validarExistenciaProveedorOficinaExterior(IProveedor proveedor, OficinaExteriorDTO oficinaExteriorDTO) throws SICException;
}
