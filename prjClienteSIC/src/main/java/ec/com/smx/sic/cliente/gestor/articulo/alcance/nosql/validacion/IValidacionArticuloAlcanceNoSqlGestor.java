/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.validacion;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.VistaArticuloLocalNoSqlDTO;


/**
 * @author wcaiza
 *
 */
public interface IValidacionArticuloAlcanceNoSqlGestor {
	
	/**
	 * Validar si todos los campos necesarios para registrar el ArticuloLocalDTO en orientDB
	 * @param vistaArticuloLocalDTO
	 * @throws SICException
	 */
	void validarArticuloLocalRegistrar (VistaArticuloLocalNoSqlDTO vistaArticuloLocalDTO) throws SICException;

}
