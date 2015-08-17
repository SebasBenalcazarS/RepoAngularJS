/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.recepcion.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaOrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecepcionProveedorArticuloTransient;

/**
 * @author wcaiza
 *
 */
public interface IRecepcionProveedorArticuloDAO extends Logeable {
	
	/**
	 * Obtiene los datos del objeto <code>RecepcionProveedorArticuloDTO</code> que se encuentran para una recepcion
	 * @param codigoCompania
	 * @param codigoRecepcionProveedor
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorArticuloDTO> obtenerRecepcionProveedorArticuloRegistrado (Integer codigoCompania, Long codigoRecepcionProveedor) throws SICException;
	
	/**
	 * Obtener la cantidad o/y el peso total pedido en una orden de compra planificada desde el B2B
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @param codigoRecepcionProveedor
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorArticuloTransient> obtenerTotalCantidaPesoPlanificado (Integer codigoCompania, Long codigoProcesoLogistico, Long codigoRecepcionProveedor, String codigoProveedor) throws SICException;
	
	/**
	 * Obtener la cantidad o/y el peso total pedido en una orden de compra original que se registra desde el MAX
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @param codigoRecepcionProveedor
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorArticuloTransient> obtenerTotalCantidaPesoPedido (Integer codigoCompania, Long codigoProcesoLogistico, Long codigoRecepcionProveedor, String codigoProveedor) throws SICException;
	
	/**
	 * Obtener la cantidad y/o la cantidad o peso recibido hasta ese momento en la recepcion del proveedor
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @param codigoRecepcionProveedor
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorArticuloTransient> obtenerTotalCantidadPesoRecibido (Integer codigoCompania, Long codigoProcesoLogistico, Long codigoRecepcionProveedor, String codigoProveedor) throws SICException;
	
	/**
	 * Actualizar la cantidad y/o peso entregado en el proceso de recepci&oacute;n en la tabla<code>RecepcionProveedorArticuloDTO</code> 
	 * utilizando el secuencial, la cantidad o el peso pueden aumentar o disminuir
	 * @param recepcionProveedorArticulo
	 * @param realizarSuma TRUE indica que se debe sumar las cantidades, FALSE se debe realizar una resta.
	 * @throws SICException
	 */
	void actualizarCantidadPesoEntregado (RecepcionProveedorArticuloTransient recepcionProveedorArticulo, Boolean realizarSuma) throws SICException;
	
	/**
	 * Actualizar cantidadPedida y pesoPedido en la tabla <code>RecepcionProveedorArticuloDTO</code> cuando se realizaron 
	 * cambios en la recepci&oacute;n desde el monitor del proceso log&iacute;stico.
	 * @param recepcionProveedorArticulo
	 * @throws SICException
	 */
	void actualizarCantidadPesoPedido (RecepcionProveedorArticuloDTO recepcionProveedorArticulo) throws SICException;
	
	/**
	 * Eliminar (delete en la BD) en la tabla {@link RecepcionProveedorArticuloDTO}, utilizando el atributo secuencialRecepcionProveedorArticulo
	 * @param codigoCompania
	 * @param colSecuencialRecepcionProveedorArticulo
	 * @throws SICException
	 */
	void eliminarRecepcionProveedorArticulo (Integer codigoCompania, Collection<Long> colSecuencialRecepcionProveedorArticulo) throws SICException;
	
	/**
	 * Eliminar todos los registros de la tabla {@link RecepcionProveedorArticuloDTO} asociados al c&oacute;digo de la recepci&oacute;n del proveedor
	 * @param codigoCompania
	 * @param codigoRecepcionProveedor
	 * @throws SICException
	 */
	void eliminarRecepcionProveedorArticulo (Integer codigoCompania, Long codigoRecepcionProveedor) throws SICException;
	
	/**
	 * Consultar los registros de las recepcion proveedor articulo justificacion
	 * @param codigoCompania
	 * @param codigoRecepcionProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<Long> obtenerCodigosJusticacionesArticulo(Integer codigoCompania, Long codigoRecepcionProveedor) throws SICException;
	
	/**
	 * Eliminar todos los registros de {@linkRecepcionProveedorArticuloDTOJustificacion} relacionados al codigo recepcion proveedor articulo justificacion
	 * @param codigoCompania
	 * @param codigorecepcionProveedorArticulo
	 * @throws SICException
	 */
	void eliminarRecepcionProveedorArticuloJustificacion(Integer codigoCompania, Collection<Long> listaCodigosRecepcionProveedorArticulo) throws SICException;

	/**
	 * Actualiza el tiempo estimado de la recepcion proveedor
	 * @param codigoCompania
	 * @param codigoRecepcionProveedor
	 * @param tiempoEstimado
	 * @throws SICException
	 */
	void actualizarTiempoEstimadoRecepcionProveedor(Integer codigoCompania, Long codigoRecepcionProveedor, Long tiempoEstimado) throws SICException;

	/**
	 * Activar o Desactivar Ingreso Caja
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param activarIngresoCaja
	 * @param vistaProcesoLogisticoDTO
	 * @param vistaOrdenCompraDetalleEstadoDTO
	 * @throws SICException
	 */
	void administrarIngresoCaja(Integer codigoCompania, Boolean activarIngresoCaja, VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO, VistaOrdenCompraDetalleEstadoDTO vistaOrdenCompraDetalleEstadoDTO) throws SICException;
	
	/**
	 * Conocer el estado de Ingreso Caja
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param vistaProcesoLogisticoDTO
	 * @param vistaOrdenCompraDetalleEstadoDTO
	 * @return Boolean
	 * @throws SICException
	 */
	Boolean consultarEstadoIngresoCaja(Integer codigoCompania, VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO, VistaOrdenCompraDetalleEstadoDTO vistaOrdenCompraDetalleEstadoDTO) throws SICException;
	/**
	 * Obtener los datos resumidos de la orden de compra de la tabla(RecepionProveedorArticuloDTO)
	 * @param tareaRecepcion
	 * @return
	 */
	Collection<RecepcionProveedorArticuloDTO> obtenerDatosRecepionProveedorArticulo(TareaDTO tareaRecepcion);
}
