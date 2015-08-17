/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.math.BigDecimal;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecepcionProveedorArticuloTransient;

/**
 * @author wcaiza
 *
 */
public interface IAlmacenamientoResumenRecepcionProveedorGestor extends Logeable {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @param codigoRecepcionProveedor
	 * @param codigoProveedor
	 * @param userId
	 * @param codigoAreaSubbodega
	 * @throws SICException
	 */
	void registrarRecepcionProveedorArticulo(Integer codigoCompania, Long codigoProcesoLogistico, Long codigoRecepcionProveedor, String codigoProveedor, String userId, Integer codigoAreaSubbodega) throws SICException;
	
	/**
	 * M&eacute;todo para actualizar los datos de la cantidad entregada o/y recibida,
	 * en el objeto {@link RecepcionProveedorArticuloTransient}, en los diferentes procesos de recepci&oacute;n.
	 * 
	 * @param recepcionProveedorArticulo
	 * @param realizarSuma <code>TRUE</code> indica que se debe sumar las cantidades <code>FALSE</code> se debe realizar una resta en la cantidades
	 * @throws SICException
	 */
	void actualizarRecepcionProveedorArticuloDesdeScaner(RecepcionProveedorArticuloTransient recepcionProveedorArticuloTransient, Boolean realizarSuma) throws SICException;
	
	void actualizarRecepcionProveedorArticuloDesdeMonitor(Integer codigoCompania, Long codigoProcesoLogistico, Long codigoRecepcionProveedor, String codigoProveedor, String userId) throws SICException;
	
	/**
	 * Eliminar todos los registros de la tabla {@link RecepcionProveedorArticuloDTO} asociados al c&oacute;digo de la recepci&oacute;n del proveedor
	 * @param codigoCompania
	 * @param codigoRecepcionProveedor
	 * @throws SICException
	 */
	void eliminarResumenRecepcionProveedorArticulo(Integer codigoCompania, Long codigoRecepcionProveedor) throws SICException;

	RecepcionProveedorArticuloTransient armarPlantillaActualizarResumen(Long codigoRecepcion, ArticuloUnidadManejoDTO articuloUnidadManejoDTO, Integer cantidadRecibir, BigDecimal pesoRecibir, String userId);
	/**
	 * Calcula y actualiza el tiempo estimado de la recepcion  
	 * @author jdvasquez
	 * @since 24/06/2015
	 * @param codigoCompania
	 * @param codigoRecepcionProveedor
	 * @param colRecepcionProveedorArticulo
	 * @throws SICException
	 */
	void actualizarTiempoEstimadoRecepcionProveedor(Integer codigoCompania, Long codigoRecepcionProveedor, Integer codigoAreaSubbodega, Collection<RecepcionProveedorArticuloDTO> colRecepcionProveedorArticulo) throws SICException;
	
}
