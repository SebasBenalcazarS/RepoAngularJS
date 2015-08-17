/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPendienteIntegracionBodegaDTO;

/**
 * @author jdvasquez
 *
 */
public interface IArticuloPendienteIntegracionBodegaDAO {
	
	/**
	 * Inserta un articulo pendiente para integrar 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param valorUnidadManejo
	 * @param usuarioModificacion
	 * @param valorTipoProceso
	 * @throws SICException
	 */

	void registrarArticuloPendienteIntegracionBodega(Integer codigoCompania, String codigoArticulo, Integer valorUnidadManejo, String usuarioModificacion, String valorTipoProceso) throws SICException;

	/**
	 * Obtiene un articulo pendiente a integrar filtrado por el codigo de articulo y la unidad de manejo
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param valorUnidadManejo
	 * @return
	 * @throws SICException
	 */

	ArticuloPendienteIntegracionBodegaDTO obtenerArticuloPendienteIntegracion(Integer codigoCompania, String codigoArticulo, Integer valorUnidadManejo, String valorTipoProceso) throws SICException;

}
