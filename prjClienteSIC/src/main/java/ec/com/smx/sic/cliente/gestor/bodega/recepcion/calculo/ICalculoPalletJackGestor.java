/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PalletJackDTO;
import ec.com.smx.sic.cliente.mdl.dto.PalletJackPesoDTO;

/**
 * @author jdvasquez
 *
 */
public interface ICalculoPalletJackGestor {
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
	 * Retorna el consecutivo de un registro de peso de pallet jack
	 * @param codigoCompania
	 * @param codigoPalletJack
	 * @param fechaIngreso
	 * @return
	 * @throws SICException
	 */
	public 	PalletJackPesoDTO obtenerRegistroPesoPalletJackFecha(Integer codigoCompania, Long codigoPalletJack, Date fechaIngreso) throws SICException;

}
