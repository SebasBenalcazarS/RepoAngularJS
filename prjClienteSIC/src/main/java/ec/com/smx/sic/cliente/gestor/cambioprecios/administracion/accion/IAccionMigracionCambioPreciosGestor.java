/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.accion;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;

/**
 * @author gnolivos
 *
 */
public interface IAccionMigracionCambioPreciosGestor extends Serializable{

	/**
	 * @param codigoCompania
	 * @param fechaCierre
	 * @param codigosArticulos
	 * @throws SICException
	 */
	Collection<ArticuloGestionPrecioDTO> consultarArticulosGestionPrecioParaCambioDePrecio(Integer codigoCompania, Date fechaCierre) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	void actualizarPreciosArticulosFechasVigentes(Integer codigoCompania, ArticuloGestionPrecioDTO articuloGestionPrecio, Date fechaCierre) throws SICException;

	/**
	 * Ejecuta la Planificación de Cambio de Precios incluyendo Cambio de Precios de Articulos y Generación del Historial
	 * 
	 * @param codigoCompania
	 * @param fechaCierre
	 * @throws SICException
	 */
	void ejecutarPlanificacionCambioPrecios(Integer codigoCompania, Date fechaCierre) throws SICException;
	
}
