/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.cambioprecios;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;

/**
 * @author gnolivos
 *
 */
public interface IAccionHistorialCambioPreciosServicio {

	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	Collection<ArticuloGestionPrecioDTO> consultarArticulosFinalizadosCambioPrecios(Integer codigoCompania) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	void generarHistorialCambioPrecios(Integer codigoCompania, ArticuloGestionPrecioDTO articuloFinalizado) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	void eliminarCambioPreciosValidandoArticulos(Integer codigoCompania) throws SICException;
}
