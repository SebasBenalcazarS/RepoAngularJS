/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.tipoproveedor.almacenamiento;

import ec.com.smx.sic.cliente.common.IConfiguracionBean;
import ec.com.smx.sic.cliente.common.proveedor.CodigoResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author mbraganza
 *
 */
public interface IAlmacenamientoTipoProveedorGestor extends IConfiguracionBean {

	/**
	 * 
	 * @param proveedorVO
	 * @param resultadoValidacionProveedor
	 * @throws SICException
	 */
	void registrarTipoProveedor(ProveedorVO proveedorVO, 
			CodigoResultadoValidacionProveedor resultadoValidacionProveedor) throws SICException;
}
