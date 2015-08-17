/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.articulo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;

/**
 * @author gaortiz
 *
 */
public interface IArticuloRelacionadoServicio {
	
	/**
	 * 
	 * @param articulosRelacionados
	 * @throws SICException
	 */
	void registrarArticulosRelacionados( Collection<ArticuloRelacionDTO> articulosRelacionados ) throws SICException;
	
	/**
	 * 
	 * @param articuloRelacionDTO
	 * @throws SICException
	 */
	void registrarArticuloRelacionado( ArticuloRelacionDTO articuloRelacionDTO ) throws SICException;

}
