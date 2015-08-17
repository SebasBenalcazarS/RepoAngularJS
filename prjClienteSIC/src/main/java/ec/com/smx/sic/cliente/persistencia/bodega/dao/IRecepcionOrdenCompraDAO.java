package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaOrdenCompraDetalleEstadoDTO;

public interface IRecepcionOrdenCompraDAO extends Logeable {
	/**
	 * Este m&eacute;todo devuelve una colecci&oacute;n de ordenesCompraDetalleEstado de las recepciones que recibe como par&aacute;metro, 
	 * tomando en cuenta tanto las que fueron planificadas(PEN) como las que no fueron planificadas (ENV)
	 * @param codigosRecpecion
	 * @return
	 * @throws SICException
	 */
	Collection<VistaOrdenCompraDetalleEstadoDTO> obtenerOrdenesCompraDetalleEstadoPorRecepcion(Integer codigoCompania, Collection<Long> codigosRecpecion, Long codigoOrdenCompraEstado) throws SICException;
	
	/**
	 * Retorna ordenesCompraDetalleEstado de recepciones con ordenes de compra Enviadas y Planificadas
	 * @param codigoCompania
	 * @param codigosProcesosLogisticos
	 * @param ordenCompraEstadoMap: Si tiene datos es una consulta especifica de ordenes de compra, si viene null es para consultar articulos de la recepcion
	 * @return
	 * @throws SICException
	 */
	Collection<VistaOrdenCompraDetalleEstadoDTO> obtenerOrdenesCompraDetalleEstadoPorRecepcion(Integer codigoCompania, Collection<Long> codigosProcesosLogisticos, Map<Long,String> ordenCompraEstadoMap) throws SICException;
	
	/**
	 * Obtiene el costoBruto de la orden de compra detalle estado
	 * @param codigoCompania
	 * @param codigoOrdenCompraEstado
	 * @return
	 */
	BigDecimal consultarCostoNetoOrdenCompraDetalleEstado (Integer codigoCompania, Long codigoOrdenCompraEstado, Long codigoUnidadManejo) throws SICException;
	
	/**
	 * <b> Obtener el total de items en la recepcion<b>
	 * <p>
	 * [Author: lguaman, Date: 10/11/2014]
	 * @param codigosEntrega
	 * @param codigoCompania
	 * @return
	 */
	Integer obtenerTotalItemsRecepcion(Collection<Long> codigosOrdenCompraEstado, Integer codigoCompania) throws SICException;
	
	/**
	 * Actualiza la cantidad y el peso en el detalle de orden compra estado
	 * 
	 * @param codigoOrdenCompraDetalleEstado
	 * @param cantidadEntregada
	 * @param pesoEntregado
	 * @throws SICException
	 */
	void actualizarCantidadEntregadaOCDE(Long secuencialOrdenCompraDetalleEstado, Integer cantidadEntregada, BigDecimal pesoEntregado) throws SICException;
	

	/**
	 * Verifica si  la orden de compra se encuentra en las recepciones que esten pendientes
	 * @param codigoCompania
	 * @param codigosOrdenCompraEstado
	 * @param recepcionesPendientes
	 * @return
	 * @throws SICException
	 */
	Boolean verificarOrdenCompraEnRecepcionesPendientes(Integer codigoCompania, Collection<Long> codigosOrdenCompraEstado, Collection<Long> recepcionesPendientes) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoProveedor
	 * @return
	 */
	Double calcularValorPorcentajeExcesoRecepcionProveedor(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException;
	
	/**
	 * 
	 * @param codigoOrdenCompraDetalleEstado
	 * @return
	 * @throws SICException
	 */
	OrdenCompraDetalleEstadoDTO consultarOrdenCompraDetalleEstadoDTO(Long codigoOrdenCompraDetalleEstado) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param numeroOrdenCompra
	 * @return
	 * @throws SICException
	 */
	OrdenCompraEstadoDTO obtenerOrdenCompraEstadoPorNumero(Integer codigoCompania, String numeroOrdenCompra) throws SICException;
	
	/**
	 * Consulta los detalles de un estado de orden de compra en base a un codigo de orden compra estado
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraEstado
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraDetalleEstadoDTO> obtenerDetallesOrdenCompraEstado(Integer codigoCompania, Long codigoOrdenCompraEstado) throws SICException;
}
