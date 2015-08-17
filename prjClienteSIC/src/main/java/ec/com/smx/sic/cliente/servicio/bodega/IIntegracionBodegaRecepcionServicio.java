/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.bodega;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jdvasquez
 *
 */
public interface IIntegracionBodegaRecepcionServicio {

	/**
	 * Realiza la integracion de la recepcion de un pallet de bodega al SIC
	 * @param codigoCompania
	 * @param userId
	 * @param codigoDatosTarea
	 * @throws SICException
	 */
	void integrarPalletsRecibidos(Integer codigoCompania, String userId, Long codigoDatosTarea) throws SICException;

}
