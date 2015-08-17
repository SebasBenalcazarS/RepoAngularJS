package ec.com.smx.sic.cliente.persistencia.bodega.recepcion.dao;

import java.math.BigDecimal;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoDisponibilidadDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoRecepcionDTO;

public interface IVistaArticuloUnidadManejoRecepcionDAO {
	/**
	 * Este metodo devuelve una coleccion de vistas que contienen las cantidades pedidas originalmente  en las diferentes ordenes de compra de toda la recepcion que recibe como 
	 * parametro y de la unidad de manejo que recibe como parametro, estos datos son solo de articulos que no estan en la configuracion de la entrega es decir NO pertenecen a la
	 * entrega configurada y por lo tanto no tienen cantidadPedidaPorEntregar ni cantidadEntregadaPorEntregar. 
	 * @param codigoCompania
	 * @param codigoRecepcion
	 * @param codigoUnidadManejo
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaArticuloUnidadManejoRecepcionDTO> obtenerArticulosPedidosNoPedidosEntrega(Integer codigoCompania, Long codigoRecepcion, Long codigoUnidadManejo, String codigoArticulo)throws SICException;
	/**
	 * Este metodo actualiza la cantidad entregada de una orden compra detalle estado.
	 * @param codigoCompania
	 * @param codigoOrdenCompraDetalleEstado
	 * @param nuevaCantidadEntregada
	 * @throws SICException
	 */
	public void actualizarCantidadesOrdenCompraDetalleEstado (Integer codigoCompania, Long codigoOrdenCompraDetalleEstado, Integer nuevaCantidadEntregada) throws SICException;
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoRecepcion
	 * @param codigoUnidadManejo
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public VistaArticuloUnidadManejoDisponibilidadDTO obtenerCantidadDisponibleEntregar(Integer codigoCompania, Long codigoRecepcion, Long codigoUnidadManejo, String codigoArticulo)throws SICException;
	
	/**
	 * Devuelve una coleccion de vistas que contiene las ordenes de compra recibidas en el pallet que recibe como parametro
	 * @param codigoCompania
	 * @param codigoBarrasPalet
	 * @param codigoTarea
	 * @return
	 * @throws SICException
	 */
	//public Collection<VistaArticuloUnidadManejoRecepcionDTO> obtenerArticulosRecibidosEditarPallet(Integer codigoCompania, Long codigoRecepcionProveedor, String codigoBarrasPalet, Long codigoTarea)throws SICException;
	
	/**
	 * Este m�todo actualiza la cantidadEntregada de OrdenCompraDetalleEstado, es como si se hiciera una reversa de lo recibido
	 * @param codigoCompania
	 * @param codigoOrdenCompraDetalleEstado
	 * @param nuevaCantidadEntregada
	 * @throws SICException
	 */
	public void actualizarCantidadesPalletModificado(Integer codigoCompania, Long codigoOrdenCompraDetalleEstado, Integer nuevaCantidadEntregada, BigDecimal nuevoPesoEntregado) throws SICException;
	
	/**
	 * Este metodo borra los registros de detalledatostarea dado el codigo de la tarea y el codigo del palet que recibe como parametro
	 * @param codigoCompania
	 * @param codigoBarras
	 * @param codigoTarea
	 * @param usuarioModificacion
	 * @throws SICException
	 */
	public void desactivarDetallesDatosTarea(Integer codigoCompania, String codigoBarrasPalet, Long codigoTarea, String usuarioModificacion) throws SICException;
	
	/**
	 * Este metodo borra los registros de detalledatostarea dado el codigo de la tarea y el codigo del palet que recibe como parametro
	 * @param codigoCompania
	 * @param codigoBarras
	 * @param codigoTarea
	 * @param usuarioModificacion
	 * @throws SICException
	 */
	public void eliminarDetallesDatosTarea(Integer codigoCompania, String codigoBarrasPalet, Long codigoTarea, String usuarioModificacion) throws SICException;
	
	/**
	 * Este m�todo elimina los registros de datos tarea en base a los parametros
	 * @param codigoCompania
	 * @param codigoBarrasPalet
	 * @param codigoDatosTarea
	 * @param usuarioModificacion
	 * @throws SICException
	 */
	public void eliminarDatosTarea(Integer codigoCompania, String codigoBarrasPalet, Long codigoDatosTarea, String usuarioModificacion) throws SICException;
	
	/**
	 * Este metodo elimina los registros de TareaDatosTarea
	 * @param codigoCompania
	 * @param codigoTarea
	 * @param usuarioModificacion
	 * @throws SICException
	 */
	public Long eliminarTareaDatosTarea(Integer codigoCompania, Long codigoTarea, String usuarioModificacion) throws SICException;
	
	/**
	 * Este metodo elimina los registros de la tarea en base a los parametros
	 * @param codigoCompania
	 * @param codigoTarea
	 * @param usuarioModificacion
	 * @throws SICException
	 */
	public void eliminarTarea(Integer codigoCompania, Long codigoTarea, String usuarioModificacion) throws SICException;
}
