/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaJabasPalletRecepcionDTO;

/**
 * @author wcaiza
 *
 */
public interface IVistaJabasPalletRecepcionDAO {
	
	/**
	 * Obtiene una coleccion de jabas de recepcion de pallets
	 * @param codigoCompania
	 * @param colCodigoDatosTarea
	 * @return
	 * @throws SICException
	 */
	Collection<VistaJabasPalletRecepcionDTO> obtenerJabasRecepcionPallets(Integer codigoCompania, Collection<Long> colCodigoDatosTarea) throws SICException;

}
