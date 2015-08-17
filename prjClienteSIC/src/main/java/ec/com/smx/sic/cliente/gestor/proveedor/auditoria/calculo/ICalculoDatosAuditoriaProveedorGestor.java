/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.auditoria.calculo;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.auditoria.IAuditoriaBase;

/**
 * @author mbraganza
 *
 */
public interface ICalculoDatosAuditoriaProveedorGestor {
	
	/**
	 * @param codigoCompania
	 * @param codigoIdProveedor
	 * @return
	 * @throws SICException
	 */
	String obtenerIdLogAuditoriaProveedor(Integer codigoCompania, String codigoIdProveedor) throws SICException;
	
	/**
	 * 
	 * @param auditoriaBase
	 * @throws SICException
	 */
	void establecerDatosAuditoria(IAuditoriaBase auditoriaBase) throws SICException;

}
