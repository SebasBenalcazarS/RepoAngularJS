package ec.com.smx.sic.cliente.gestor.bodega.factura.digital.calculo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.CalendarioBodegaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaCalendarioBodegaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDetalleCalendarioProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaEntregaFacturaDigitalDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.FacturaDigitalEST;
import ec.com.smx.sic.cliente.mdl.vo.BodegaVO;
import ec.com.smx.sic.cliente.mdl.vo.EntregaVO;
import ec.com.smx.sic.cliente.mdl.vo.FacturaDigitalVO;

/**
 * 
 * @author acaiza
 * 
 */
public interface ICalculoFacturaDigitalProveedorGestor {

	/**
	 * Metodo para buscar el calendario de entrega del proveedor
	 * 
	 * @param proveedorDTO
	 * @param fechaEntrega
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<CalendarioBodegaProveedorDTO> obtenerCalendarioPorProveedor(ProveedorDTO proveedorDTO, BodegaDTO bodegaDTO, Date fechaEntrega) throws SICException;
	
	/**
	 * 
	 * @param proveedorDTO
	 * @param bodegaDTO
	 * @param fechaEntrega
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<EntregaCalendarioBodegaProveedorDTO> obtenerCalendarioEntregasProveedor(ProveedorDTO proveedorDTO, BodegaDTO bodegaDTO, Date fechaEntrega) throws SICException;
	
	/**
	 * Metodo para buscar el calendario de entrega del proveedor en base a un grupo de ordenes de compra
	 * 
	 * @param ordenCompraEstadoDTOs
	 * @param proveedorDTO
	 * @param fechaEntrega
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<EntregaCalendarioBodegaProveedorDTO> obtenerCalendarioEntregaProveedorPorDetallesOrdenCompraEstado(Collection<OrdenCompraDetalleEstadoDTO> detallesOrdenCompraEstado) throws SICException;
	
	/**
	 * 
	 * @param detalleOrdenCompraEstadoDTOs
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<BodegaVO> agruparOrdenCompraDetalleEstadoPorBodegaYTipo(Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraEstadoDTOs) throws SICException;
	
	/**
	 * 
	 * @param detalleOrdenCompraEstadoDTOs
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<FacturaDigitalVO> agruparDetallesOrdenCompraEstadoPorClasificacion(Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraEstadoDTOs) throws SICException;
	
	/**
	 * Agrupa los detalles de ordenes de compra en OrdenCompraEstadoDTO y un Collection de OrdenCompraDetalleEstadoDTO en la estructura FacturaDigitalVO
	 * 
	 * @param detalleOrdenCompraEstadoDTOs Coleccion de OrdenCompraEstadoDTO a agrupar
	 * @return Un Collection de FacturaDigitalVO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<FacturaDigitalVO> agruparDetallesOrdenCompraEstadoPorOrdenCompraEstado(Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraEstadoDTOs) throws SICException;
	
	/**
	 * @see ec.com.smx.sic.bodega.gestor.bodega.calculo.
	 *      ICalculoCalendarioBodegaGestor
	 *      .agruparDetallesOrdenCompraEstadoPorMarca
	 *      (Collection<OrdenCompraDetalleEstadoDTO>)
	 */
	public Collection<FacturaDigitalVO> agruparDetallesOrdenCompraEstadoPorMarca(Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraEstadoDTOs) throws SICException;
												  
	/**
	 * 
	 * @param detalleOrdenCompraEstadoDTOs
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<FacturaDigitalVO> agruparDetallesOrdenCompraEstadoPorFechaCaducidad(Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraEstadoDTOs) throws SICException;
	
	/**
	 * 
	 * @param detalleOrdenCompraEstadoDTOs
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<FacturaDigitalVO> agruparDetallesOrdenCompraEstadoPorClasificacionSubClasificacion(Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraEstadoDTOs) throws SICException;

	/**
	 * 
	 * @param entregaDTO
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<EntregaVO> obtenerEntregasProveedor(EntregaDTO entregaDTO) throws SICException;
	
	/**
	 * Busca los articulos de una entrega 
	 * Busca las facturas de una entrega
	 * 
	 * Valida los parametros vistaEntregaFacturaDigitalDTO: codigoEntrega, codigoProveedor
	 * 
	 * @param vistaEntregaFacturaDigitalDTO
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public VistaEntregaFacturaDigitalDTO obtenerDatosEntregaFacturaDigital(VistaEntregaFacturaDigitalDTO vistaEntregaFacturaDigitalDTO) throws SICException;
	
	/**
	 * Obtiene los datos de una factura estado
	 * @param codigoFactura Codigo de una factura
	 * @return Un FacturaEstadoDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public FacturaEstadoDTO obtenerDatosFacturaEstadoFacturaDigital(Long codigoFactura) throws SICException;
	
	/**
	 * Obtiene los datos de las entregas del proveedor en base a las datos de un EntregaDTO para realizar los filtros
	 * 
	 * @param entregaDTO Un EntregaDTO
	 * @return Una coleccion de EntregaVO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<EntregaVO> obtenerDatosEntregasProveedor(EntregaDTO entregaDTO) throws SICException;
	
	/**
	 * Validacion de totales de parciales de facturas contra las cantidades pedidas no se exceden
	 * 
	 * @param ordenCompraDetalleEstadoDTOCol
	 * @param detalleFacturaEstadoDTOs
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public void validarValoresParcialesFacturaPorCantidadPedida(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOCol, Collection<DetalleFacturaEstadoDTO> detalleFacturaEstadoDTOs) throws SICException;
	
	/**
	 * 
	 * @param detalleFacturaEstadoDTOs
	 * @return
	 */
	public Map<Long, Integer> armarCantidadesParcialesFactura(Collection<DetalleFacturaEstadoDTO> detalleFacturaEstadoDTOs);
	
	/**
	 * 
	 * @param entregaVO
	 * @return
	 */
	public Collection<DetalleFacturaEstadoDTO> consultarDetallesFacturaEntrega(Long codigoEntrega);
	
	/**
	 * Calcula las cantidades disponibles de los articulos de la entrega, sacando la diferencia con lo facturado 
	 * 
	 * @param ordenCompraDetalleEstadoDTOs Articulo de las ordenes de compra de la entrega
	 * @param detalleFacturaEstadoDTOs Articulos de las facturas de la entrega
	 */
	public void calcularCantidadesDisponiblesDetallesOrdenesCompraPorFactura(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs, Collection<DetalleFacturaEstadoDTO> detalleFacturaEstadoDTOs);
	
	/**
	 * 
	 * @param entregaDTOs
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<EntregaVO> armarEntregaVOs(Collection<EntregaDTO> entregaDTOs) throws SICException;
	
	/**
	 * 
	 * @param entregaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<EntregaDetalleCalendarioProveedorDTO> obtenerCalendarioAprobadoEntrega(EntregaDTO entregaDTO, Collection<String> estadosEntregaAutorizacion, Collection<String> estadosAutorizacion, boolean condicion) throws SICException;
	
	
	/**
	 * @param ordenCompraDetalleEstadoDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<FacturaDigitalEST> consolidarOrdenesCompraDetalleEstadoEnFacturaDigitalEST(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) throws SICException;
	
	/**
	 * Consulta los OrdenCompraEstadoDTO de una entrega
	 * 
	 * @param codigoEntrega Codigo de una entrega
	 * @return Un Collection de OrdenCompraEstadoDTO
	 */
	public Collection<OrdenCompraEstadoDTO> obtenerOrdenCompraEstadoEntrega(Long codigoEntrega) throws SICException;
	
	/**
	 * Consulta los OrdenCompraDetalleEstadoDTO de una entrega
	 * 
	 * @param codigoEntrega Codigo de una entrega
	 * @return Un Collection de OrdenCompraDetalleEstadoDTO
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> obtenerOrdenCompraDetalleEstadoEntrega(Long codigoEntrega) throws SICException;
	
	
	 /** Arma las cantidades totales facturadas de cada uno de los articulos de los detalles de las facturas, consultando todos los detalles 
	 * de las facturas para sumar los pesos de cada uno de los articulos de las facturas relacionadas a los detalles de la orden de 
	 * compra Map[codigoOrdenCompraDetalleEstado, cantidadesDetallesFacturas]
	 * 
	 * @param detalleFacturaEstadoDTOs
	 *            Una coleccion de detalles de factura estado
	 * @return Un Map[codigoOrdenCompraDetalleEstado,
	 *         cantidadesDetallesFacturas]
	 */
	public Map<Long, BigDecimal> armarPesosParcialesFactura(Collection<DetalleFacturaEstadoDTO> detalleFacturaEstadoDTOs);
	
}
