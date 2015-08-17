/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.oficinaexterior.validacion;

import java.io.Serializable;

import ec.com.smx.sic.cliente.common.oficinaexterior.ResultadoValidacionOficinaExterior;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.IIdentificadorProveedorVO;

/**
 * @author Mario Braganza
 *
 */
public interface IValidacionOficinaExteriorGestor extends Serializable {

	/**
	 * 
	 * @param identificadorProveedor
	 * @return
	 * @throws SICException
	 */
	public ResultadoValidacionOficinaExterior validarOficinaExterior(IIdentificadorProveedorVO identificadorProveedor) throws SICException;
	
}
