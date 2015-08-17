/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PalletJackPesoDTO;

/**
 * @author jdvasquez
 *
 */
public interface IAlmacenamientoPalletJackGestor {
	/**
	 * Crea el registro del pallet jack pesado
	 * @param palletJackPesoDTO
	 * @return 
	 * @throws SICException
	 */
	public PalletJackPesoDTO crearRegistroPalletJackPeso(PalletJackPesoDTO palletJackPesoDTO) throws SICException;

}
