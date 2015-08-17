/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ofertas.dao;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;

/**
 * @author gnolivos
 *
 */
public interface IValidacionDatosOfertasDAO extends Serializable{
	
	/**
	 * Obtener articulos de prueba
	 * @param
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloGestionPrecioDTO> obtenerArticulos(Integer codigoCompania) throws SICException;
	
	

}
