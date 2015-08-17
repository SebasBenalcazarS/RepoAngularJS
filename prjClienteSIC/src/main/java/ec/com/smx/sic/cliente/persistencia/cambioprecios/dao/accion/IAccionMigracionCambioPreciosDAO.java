/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.cambioprecios.dao.accion;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorGestionPrecioDTO;

/**
 * @author gnolivos
 *
 */
public interface IAccionMigracionCambioPreciosDAO extends Serializable {
	
	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	Collection<String> consultarCodigosArticulosParaCambioDePrecio(Integer codigoCompania, Date fechaFinal) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	Collection<ArticuloGestionPrecioDTO> consultarArticulosGestionPrecioParaCambioDePrecio(Integer codigoCompania, Date fechaFinal, Set<String> codigosArticulos) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	void cambiarPreciosArticulo(Integer codigoCompania, ArticuloGestionPrecioDTO articuloGestionPrecio, String usuarioModificacion, Date fechaModificacion, Boolean esRetorno) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	void cambiarPreciosProveedor(Integer codigoCompania, ArticuloProveedorGestionPrecioDTO articuloProveedorGestionPrecio, String usuarioModificacion, Date fechaModificacion, Boolean esRetorno) throws SICException;
	
	/**
	 * Registrar los datos de los articulos que estaran pendientes para realizar la integracion
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoProveedor
	 * @param userId
	 * @throws SICException
	 */
	void registrarDatosArticuloProveedorPendientesIntegracion(Integer codigoCompania, String codigoArticulo, String codigoProveedor, String userId) throws SICException;
}
