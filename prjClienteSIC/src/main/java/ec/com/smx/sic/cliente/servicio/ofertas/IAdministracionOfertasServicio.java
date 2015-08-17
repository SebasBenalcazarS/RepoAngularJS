/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.ofertas;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;

/**
 * @author gnolivos
 *
 */
public interface IAdministracionOfertasServicio extends Serializable {

	/**
	 * Valida la fecha de inicio de ofertas
	 * @param value
	 * @return
	 * @throws SICException
	 */
	Boolean validarFechaInicioOferta(Date fechaSeleccionada) throws SICException;
	
	/**
	 * Valida la fecha de fin de ofertas
	 * @param value
	 * @return
	 * @throws SICException
	 */
	Boolean validarFechaFinOferta(Date fechaInicio, Date fechaSeleccionada) throws SICException;
	
	/**
	 * Obtener articulos de prueba
	 * @param
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloGestionPrecioDTO> obtenerArticulosOfertasDePrueba(Integer codigoCompania) throws SICException;
	
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
