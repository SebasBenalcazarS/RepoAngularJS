/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.administracion.almacenamiento;

import ec.com.smx.sic.cliente.common.IConfiguracionBean;
import ec.com.smx.sic.cliente.common.proveedor.TipoDatoProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author Luis Yacchirema
 *
 */
public interface IAlmacenamientoDatosProveedorGestor extends IConfiguracionBean {

	/**
	 * @param proveedorVO
	 * @throws SICException
	 */
	void registrarDatosProveedor(ProveedorVO proveedorVO) throws SICException;
	
	/**
	 * @param proveedorVO
	 * @param tiposDatosProveedor
	 * @throws SICException
	 */
	void registrarDatosProveedor(ProveedorVO proveedorVO, TipoDatoProveedor... tiposDatosProveedor) throws SICException;
}
