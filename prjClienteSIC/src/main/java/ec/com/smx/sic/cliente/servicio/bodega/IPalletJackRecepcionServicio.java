/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.bodega;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PalletJackDTO;
import ec.com.smx.sic.cliente.mdl.dto.PalletJackPesoDTO;

/**
 * @author jdvasquez
 *
 */
public interface IPalletJackRecepcionServicio {
	/**
	 * Retorna una coleccion de objetos tipo Pallet Jack filtrado por tipo de pallet
	 * @param codigoCompania
	 * @param valorTipoPallet
	 * @param codigoTipoPallet
	 * @return
	 * @throws SICException
	 */
	public Collection<PalletJackDTO> obtenerColeccionPalletJackPorTipo(Integer codigoCompania, String valorTipoPallet, Integer codigoTipoPallet, Long codigoPalletBuscar) throws SICException;
	/**
	 * Crea el registro del pallet jack pesado
	 * @param palletJackPesoDTO
	 * @return 
	 * @throws SICException
	 */
	public PalletJackPesoDTO crearRegistroPalletJackPeso(PalletJackPesoDTO palletJackPesoDTO) throws SICException;
	/**
	 * Retorna el registro de peso del pallet filtrado por fecha 
	 * @param codigoCompania
	 * @param codigoPalletJack
	 * @param fechaIngreso
	 * @return
	 * @throws SICException
	 */
	public PalletJackPesoDTO obtenerRegistroPesoPalletJackFecha(Integer codigoCompania, Long codigoPalletJack, Date fechaIngreso) throws SICException;

}
