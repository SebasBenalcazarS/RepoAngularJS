/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PalletJackDTO;

/**
 * @author jdvasquez
 *
 */
public interface IPalletJackDAO {
	/**
	 * Retorna un objeto tipo Pallet Jack filtrado por codigo de pallet
	 * @param codigoCompania
	 * @param codigoPalletJack
	 * @return
	 * @throws SICException
	 */
	public PalletJackDTO obtenerPalletJackPorCodigo(Integer codigoCompania, Integer codigoPalletJack) throws SICException;
	/**
	 * Retorna una coleccion de objetos tipo Pallet Jack filtrado por tipo de pallet
	 * @param codigoCompania
	 * @param valorTipoPallet
	 * @param codigoTipoPallet
	 * @return
	 * @throws SICException
	 */
	public Collection<PalletJackDTO> obtenerColeccionPalletJackPorTipo(Integer codigoCompania, String valorTipoPallet, Integer codigoTipoPallet, Long codigoPalletBuscar) throws SICException;

}
