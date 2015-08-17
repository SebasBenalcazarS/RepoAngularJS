/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.autorizaciones.almacenamiento;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoAutorizacionDTO;

/**
 * @author jdvasquez
 *
 */
public interface IAlmacenamientoAutorizacionesClaveGestor {
	
	
	/**
	 * Crea una relacion entre proceso logistico y autorizacion
	 * @param procesoLogisticoAutorizacionDTO
	 * @throws SICException
	 */
	public void crearRelacionProcesoLogisticoAutorizacion(ProcesoLogisticoAutorizacionDTO procesoLogisticoAutorizacionDTO) throws SICException;

}
