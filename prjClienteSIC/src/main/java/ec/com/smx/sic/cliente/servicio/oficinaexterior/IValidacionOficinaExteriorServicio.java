/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.oficinaexterior;

import java.io.Serializable;

import ec.com.smx.sic.cliente.common.oficinaexterior.ResultadoValidacionOficinaExterior;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.IIdentificadorProveedorVO;

/**
 * @author Mario Braganza
 *
 */
public interface IValidacionOficinaExteriorServicio extends Serializable {

	/**
	 * 
	 * @param identificadorProveedor
	 * @return
	 * @throws SICException
	 */
	ResultadoValidacionOficinaExterior validarOficinaExterior(IIdentificadorProveedorVO identificadorProveedor) throws SICException;
}
