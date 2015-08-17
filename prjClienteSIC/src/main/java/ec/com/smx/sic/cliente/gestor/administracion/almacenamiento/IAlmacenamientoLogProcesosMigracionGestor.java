/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.administracion.almacenamiento;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.LogProcesosMigracionDTO;

/**
 * @author jlcayo
 *
 */
public interface IAlmacenamientoLogProcesosMigracionGestor extends Serializable {

	/**
	 * 
	 * @param logProcesosMigracionDTO
	 * @throws SICException
	 */
	public void crearLogProcesoMigracionTransaccional(LogProcesosMigracionDTO logProcesosMigracionDTO) throws SICException;

	
}
