package ec.com.smx.sic.cliente.servicio.bodega;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaOrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;


/**
 * 
 * @author acaiza
 *
 */
public interface IRecepcionOrdenCompraServicio {
	
	/**
	 * Obtener las ordenes de compra estado por fecha y costo cuando corresponden a la misma unidad de manejo
	 * 
	 * @param vistaArticuloUnidadManejoRecepcionDTOs
	 */
	public Collection<VistaArticuloUnidadManejoRecepcionDTO> transOrdenarOrdenCompraEstadoPorReglas(Collection<VistaArticuloUnidadManejoRecepcionDTO> vistaArticuloUnidadManejoRecepcionDTOs) throws SICException;
	
	/**
	 * Obtiene la orden de compra con la mas alta prioridad (por fecha, costo)
	 * r
	 * @param vistaArticuloUnidadManejoRecepcionDTOs
	 */
	public VistaArticuloUnidadManejoRecepcionDTO transSeleccionarOrdenCompraEstadoReglaPrecioFecha(Collection<VistaArticuloUnidadManejoRecepcionDTO> vistaArticuloUnidadManejoRecepcionDTOs) throws SICException;
	
	/**
	 * Obtiene los ordenes de compra de una tarea de recepcion
	 * 
	 * @param tareaDTO
	 * @param estadoOrdenCompraEstado
	 * @param listaArticuloUnidadManejoConsultado
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<OrdenCompraEstadoDTO> transObtenerOrdenCompraEstadoPorTareaParaRecepcion(TareaDTO tareaDTO, CatalogoValorDTO estadoOrdenCompraEstado, Collection<ArticuloUnidadManejoDTO> listaArticuloUnidadManejoConsultado, BodegaDTO subBodega) throws SICException;
	
	/**
	 * Crea la orden de compra estado para recepcion en base a los datos de una orden de compra
	 * @param ordenCompraEstadoDTO Orden de compra estado
	 * @return Una orden de compra estado
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public OrdenCompraEstadoDTO transCrearOrdenCompraEstadoParaRecepcion(OrdenCompraEstadoDTO ordenCompraEstadoDTO) throws SICException;
	
	/**
	 * Modifica la orden de compra estado para recepcion en base a los datos de un orden de compra detalle estado
	 * 
	 * @param ordenCompraDetalleEstado Un detalle de la orden de compra
	 * @param datosTarea Datos de la tarea
	 * @param cantidadRecibida Cantidad de items recibidos
	 * @return Una orden de compra estado en ENT
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public OrdenCompraEstadoDTO transModificarOrdenCompraEstadoParaRecepcion(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstado, DatosTareaDTO datosTareaDTO, Integer cantidadRecibida) throws SICException;
	
	/**
	 * Obtiene los ordenes de compra de una tarea de recepcion
	 * 
	 * @param tareaDTO
	 * @param estadoOrdenCompraEstado
	 * @param articuloUnidadManejoDTO
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<OrdenCompraEstadoDTO> transObtenerOrdenCompraEstadoPorTarea(TareaDTO tareaDTO, CatalogoValorDTO estadoOrdenCompraEstado, ArticuloUnidadManejoDTO articuloUnidadManejoDTO, BodegaDTO subBodega) throws SICException;
	
	/**
	 * Obtiene una colecci�n de OrdeneCompraEstado en base a los parametros que recibe
	 * @param vistaProcesoLogisticoDTO
	 * @param estadoOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraEstadoDTO> transObtenerOrdenCompraEstadoPorRecepcion(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO, Collection<String> estadosOrdenCompra) throws SICException;
	
	/**
	 * 
	 * @param codigoAreaTrabajoPedido codigo centro distribucion (CD)
	 * @param codigoAreaTrabajoDestino codigo bodega
	 * @param codigoSubbodega 
	 * @param tipoRecepcion tipo de pedido
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraDTO> transObtenerOrdenCompraDia(Collection<EntregaDTO> entregaCol, Integer codigoAreaTrabajoPedido, Integer codigoAreaTrabajoDestino, String codigoSubbodega, String tipoRecepcion) throws SICException;
	
	/**
	 * 
	 * @param entregaCol
	 * @param codigoAreaTrabajoPedido
	 * @param codigoAreaTrabajoDestino
	 * @param codigoSubbodega
	 * @param tipoRecepcion
	 * @return
	 * @throws SICException
	 */
	Collection<EntregaOrdenCompraEstadoDTO> transObtenerOrdenCompraRecepcionDia(Collection<EntregaDTO> entregaCol, Integer codigoAreaTrabajoPedido, Integer codigoAreaTrabajoDestino, String codigoSubbodega, String tipoRecepcion) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoRecepcion
	 * @param codigoUnidadManejo
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaArticuloUnidadManejoRecepcionDTO> obtenerArticulosPedidosNoPedidosEntrega(Integer codigoCompania, Long codigoRecepcion, Long codigoUnidadManejo, String codigoArticulo) throws SICException;
	
	/**
	 * @param vistaProcesoLogisticoDTO
	 * @param estadosOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDTO> transObtenerOrdenCompraPorRecepcion(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO, Collection<String> estadosOrdenCompra) throws SICException;
	
}
