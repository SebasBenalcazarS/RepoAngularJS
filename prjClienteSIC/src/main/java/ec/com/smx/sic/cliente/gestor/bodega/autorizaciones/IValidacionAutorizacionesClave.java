/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.autorizaciones;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoAutorizacionDTO;

/**
 * @author jdvasquez
 *
 */
public interface IValidacionAutorizacionesClave {
	
	/**
	 * Valida los campos necesarios previo a la creacion de la relacion de proceso logistico con autorizacion
	 * @param procesoLogisticoAutorizacionDTO
	 * @throws SICException
	 */
	public void crearRelacionProcesoLogisticoAutorizacion(ProcesoLogisticoAutorizacionDTO procesoLogisticoAutorizacionDTO) throws SICException;

}
