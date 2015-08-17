/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.usuariosproveedor.validacion;

import java.io.Serializable;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Mario Braganza
 *
 */
public interface IValidacionDatosFuncionarioProveedorGestor extends
		Serializable {
	
	
	/**
	 * 
	 * @param funcionarioDTO
	 * @return
	 * @throws SICException
	 */
	Boolean validarAsignacionEstablecimientosPorDefectoAFuncionario(FuncionarioDTO funcionarioDTO) throws SICException;

}
