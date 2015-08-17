/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;

/**
 * @author jdvasquez
 *
 */
public interface IArticuloUnidadManejoUsoDAO {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoUnidadManejo
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoUsoDTO> obtenerArticuloUnidadManejoUso(Integer codigoCompania, Long codigoArticuloUnidadManejo) throws SICException;

}
