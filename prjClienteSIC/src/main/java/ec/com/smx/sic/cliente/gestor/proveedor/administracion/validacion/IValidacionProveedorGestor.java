/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.administracion.validacion;

import ec.com.smx.sic.cliente.common.IConfiguracionBean;
import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoValidacionProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.IIdentificadorProveedorVO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author Mario Braganza
 *
 */
public interface IValidacionProveedorGestor extends IConfiguracionBean {
	
	/**
	 * 
	 * @param resultadoValidacionJDE
	 * @return
	 * @throws SICRuleException
	 */
	public ResultadoValidacionProveedor validarProveedor(IIdentificadorProveedorVO identificadorProveedor) throws SICException;
	
	
	/**
	 * 
	 * @param proveedorVO
	 * @param tipoValidacionProveedor
	 * @return
	 * @throws SICException
	 */
	public Boolean validarProveedorImportado(ProveedorVO proveedorVO, TipoValidacionProveedor tipoValidacionProveedor) throws SICException;

}
