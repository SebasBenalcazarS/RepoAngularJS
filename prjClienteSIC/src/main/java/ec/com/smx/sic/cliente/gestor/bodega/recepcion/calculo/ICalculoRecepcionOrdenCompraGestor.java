package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaOrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoAutorizacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaOrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecepcionOrdenCompraDetalleEstadoAuditEST;

/**
 * 
 * @author acaiza
 * 
 */
public interface ICalculoRecepcionOrdenCompraGestor {

	/**
	 * Obtener las ordenes de compra estado por fecha y costo cuando corresponden a la misma unidad de manejo
	 * 
	 * @param vistaArticuloUnidadManejoRecepcionDTOs
	 */
	Collection<VistaArticuloUnidadManejoRecepcionDTO> ordenarOrdenCompraEstadoPorReglas(Collection<VistaArticuloUnidadManejoRecepcionDTO> vistaArticuloUnidadManejoRecepcionDTOs) throws SICException;
	
	/**
	 * Metodo que obtiene la orden de compra mas conviente para la recepcion validando la fecha y costo neto de las ordenes de compra
	 * Si los costos son iguales se devuelve la orden de compra mas antigua
	 * Si los costos son diferencte se devuelve la orden de compra con el menor costo neto y fecha mas antigua
	 *  
	 * @param vistaArticuloUnidadManejoRecepcionDTOs Ordenes de compra configuradas en las entregas de la recepcion
	 * @return Un VistaArticuloUnidadManejoRecepcionDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	VistaArticuloUnidadManejoRecepcionDTO seleccionarOrdenCompraEstadoReglaPrecioFecha(Collection<VistaArticuloUnidadManejoRecepcionDTO> vistaArticuloUnidadManejoRecepcionDTOs) throws SICException;
		
	/**
	 * 
	 * @param tareaDTO
	 * @param estadoOrdenCompraEstado
	 * @param listaArticuloUnidadManejoConsultado
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraEstadoDTO> obtenerOrdenCompraEstadoPorTareaParaRecepcion(TareaDTO tareaDTO, CatalogoValorDTO estadoOrdenCompraEstado, Collection<ArticuloUnidadManejoDTO> listaArticuloUnidadManejoConsultado, BodegaDTO subBodega) throws SICException;
	
	/**
	 * 
	 * @param entregasDTO
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraDTO> obtenerOrdenesCompraRecepcion(Collection<EntregaDTO> entregasDTO, Integer codigoAreaTrabajoPedido, String codigoSubbodega, Integer codigoAreaTrabajoDestino, String tipoRecepcion) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraEstadoDTOs
	 * @param articuloUnidadManejoDTO
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraDetalleEstadoDTO> ordenarOrdenesCompraPorPrioridades(Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs, ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraDetalleEstadoDTOs
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloUnidadManejoDTO> obtenerArticulosOrdenCompraDetalleEstado(Collection<OrdenCompraDetalleEstadoDTO>  listOrdenCompraDetalleEstadoDTO) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraEstadoDTO
	 * @param areaTrabajoDTO
	 * @param bodegaDTO
	 * @param proveedorDTO
	 * @param catalogoValorDTO
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraEstadoDTO> obtenerListaOrdenesProveedor(OrdenCompraEstadoDTO ordenCompraEstadoDTO,AreaTrabajoDTO areaTrabajoDTO, BodegaDTO bodegaDTO, ProveedorDTO proveedorDTO,  CatalogoValorDTO catalogoValorDTO, Date fechaInicio, Date fechaFin) throws SICException;
	
	/**
	 * 
	 * @param tareaDTO
	 * @param estadoOrdenCompraEstado
	 * @param articuloUnidadManejoDTO
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraEstadoDTO> obtenerOrdenCompraEstadoPorTarea(TareaDTO tareaDTO, CatalogoValorDTO estadoOrdenCompraEstado, ArticuloUnidadManejoDTO articuloUnidadManejoDTO, BodegaDTO subBodega) throws SICException;
		
	/**
	 * Obtiene una colecci�n de OrdeneCompraEstado en base a los parametros que recibe
	 * @param vistaProcesoLogisticoDTO
	 * @param estadoOrdenCompra
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraEstadoDTO> obtenerOrdenCompraEstadoPorRecepcion(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO, Collection<String> estadosOrdenCompra) throws SICException;
	

	/**
	 * @param vistaProcesoLogisticoDTO
	 * @param estadosOrdenCompra
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraDTO> obtenerOrdenCompraPorRecepcion(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO, Collection<String> estadosOrdenCompra) throws SICException;

	
	/**
	 * 
	 * @param codigoAreaTrabajoPedido codigo centro distribucion (CD)
	 * @param codigoAreaTrabajoDestino codigo bodega
	 * @param codigoSubbodega 
	 * @param tipoRecepcion tipo de pedido
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraDTO> obtenerOrdenCompraDia(Collection<EntregaDTO> entregaCol, Integer codigoAreaTrabajoPedido, Integer codigoAreaTrabajoDestino, String codigoSubbodega, String tipoRecepcion) throws SICException;
	/**
	 * Este m&eacute;todo devuelve una colecci&oacute;n de ordenesCompraDetalleEstado de las recepciones que recibe como parametro, tomando en cuenta tanto las que fueron planificadas(PEN)
	 * como las que no fueron planificadas (ENV)
	 * @param codigosRecpecion
	 * @return
	 * @throws SICException
	 */
	Collection<VistaOrdenCompraDetalleEstadoDTO> obtenerOrdenesCompraDetalleEstadoPorRecepcion(Integer codigoCompania, Collection<Long> codigosRecpecion, Long codigoOrdenCompraEstado) throws SICException;
	
	
	
	Collection<EntregaOrdenCompraEstadoDTO> obtenerOrdenCompraRecepcionDia(Collection<EntregaDTO> entregaCol, Integer codigoAreaTrabajoPedido, Integer codigoAreaTrabajoDestino, String codigoSubbodega, String tipoRecepcion) throws SICException;
	
	/**
	 * Retorna ordenesCompraDetalleEstado de recepciones con ordenes de compra Enviadas y Planificadas, se utiliza en popUp de Articulos y de Ordenes de compra
	 * @param codigoCompania
	 * @param codigosProcesoLogisticos
	 * @param ordenCompraEstadoMap: Si tiene datos es una consulta especifica de ordenes de compra, si viene null es para consultar articulos de la recepcion
	 * @return
	 * @throws SICException
	 */
	Collection<VistaOrdenCompraDetalleEstadoDTO> obtenerOrdenesCompraDetalleEstadoPorRecepcion(Integer codigoCompania, Collection<Long> codigosProcesoLogisticos, Map<Long,String> ordenCompraEstadoMap, String estadoProcesoLogistico) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoRecepcion
	 * @param codigoUnidadManejo
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<VistaArticuloUnidadManejoRecepcionDTO> obtenerArticulosPedidosNoPedidosEntrega(Integer codigoCompania, Long codigoRecepcion, Long codigoUnidadManejo, String codigoArticulo) throws SICException;
	
	/**
	 * @param costoBrutoActualizado
	 * @param codigoOrdenCompraDetalleEstado
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	void actualizarCostosRecepcion(RecepcionOrdenCompraDetalleEstadoAuditEST auditESTactual, RecepcionOrdenCompraDetalleEstadoAuditEST auditESTanterior, BigDecimal costoBrutoActualizado, Long codigoOrdenCompraDetalleEstado, Integer codigoCompania, String userId, ProcesoLogisticoAutorizacionDTO procesoLogisticoAutorizacionDTO) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoOrdenCompraEstado
	 * @return
	 */
	BigDecimal consultarCostoNetoOrdenCompraDetalleEstado (Integer codigoCompania, Long codigoOrdenCompraEstado, Long codigoUnidadManejo) throws SICException;

	/**
	 * Consulta un estado de orden de compra en estado enviado en base a un numero de orden de compra
	 * 
	 * @param codigoCompania
	 * @param numeroOrdenCompra
	 * @return
	 * @throws SICException
	 */
	OrdenCompraEstadoDTO obtenerOrdenCompraEstadoPorNumero(Integer codigoCompania, String numeroOrdenCompra) throws SICException;
	
	/**
	 * Consulta los detalles de un estado de orden de compra en base a un orden compra estado
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraEstado
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraDetalleEstadoDTO> obtenerDetallesOrdenCompraEstado(Integer codigoCompania, Long codigoOrdenCompraEstado) throws SICException;
}
