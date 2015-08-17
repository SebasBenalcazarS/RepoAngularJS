/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.auditoria.almacenamiento;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author mbraganza
 *
 */
public interface IAlmacenamientoAuditoriaProveedorGestor {
	
	
	/**
	 * 
	 * @param proveedorVO
	 * @throws SICException
	 */
	void registrarLogAuditoria(ProveedorVO proveedorVO) throws SICException;

}
