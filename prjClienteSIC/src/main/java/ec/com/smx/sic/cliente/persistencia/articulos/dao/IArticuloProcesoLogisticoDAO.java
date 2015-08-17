/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;

/**
 * @author jdvasquez
 *
 */
public interface IArticuloProcesoLogisticoDAO {
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public ArticuloProcesoLogisticoDTO obtenerInformacionDespachoArticulo(Integer codigoCompania, String codigoArticulo) throws SICException;

}
