/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PalletJackPesoDTO;

/**
 * @author jdvasquez
 *
 */
public interface IPalletJackPesoDAO {
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoPalletJack
	 * @param fechaIngreso
	 * @return
	 * @throws SICException
	 */
	public PalletJackPesoDTO obtenerRegistroPesoPalletJackFecha(Integer codigoCompania, Long codigoPalletJack, Date fechaIngreso) throws SICException;

}
