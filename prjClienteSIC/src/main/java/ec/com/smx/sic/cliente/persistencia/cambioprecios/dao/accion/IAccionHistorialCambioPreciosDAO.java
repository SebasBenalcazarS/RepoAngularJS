/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.cambioprecios.dao.accion;

import java.util.Collection;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;

/**
 * @author gnolivos
 *
 */
public interface IAccionHistorialCambioPreciosDAO {
	
	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	Collection<String> consultarCodigosArticulosFinalizadosCambioPrecios(Integer codigoCompania) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	Collection<ArticuloGestionPrecioDTO> consultarArticulosFinalizados(Integer codigoCompania, Set<String> codigosArticulosConsultar) throws SICException;
	
	 /**
	  * 
	  * @throws SICException
	  */
	 void eliminarCostoArticuloCambioPrecioInactivos() throws SICException;
}
