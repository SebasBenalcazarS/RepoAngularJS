/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.administracion.calculo;

import java.io.Serializable;

import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.IIdentificadorProveedorVO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author Mario Braganza
 *
 */
public interface IAdministracionProveedorGestor extends Serializable {
	
	/**
	 * 
	 * @param identificadorProveedor
	 * @return
	 * @throws SICException
	 */
	Duplex<ResultadoValidacionProveedor, ProveedorVO> obtenerDatosInicialesProveedor(IIdentificadorProveedorVO identificadorProveedor) throws SICException;

}
