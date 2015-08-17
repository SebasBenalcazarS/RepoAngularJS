/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.ofertas.administracion.calculo;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;

/**
 * @author gnolivos
 *
 */
public interface ICalculoDatosOfertasGestor extends Serializable {

	/**
	 * Calcular los precios de los articulos en la oferta
	 * 
	 * @param codigoCompania
	 * @param articulosPrecios
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloGestionPrecioDTO> generarDatosArticulosPreciosOfertasActuales(Integer codigoCompania, Collection<ArticuloDTO> articulosPrecios) throws SICException;

}
