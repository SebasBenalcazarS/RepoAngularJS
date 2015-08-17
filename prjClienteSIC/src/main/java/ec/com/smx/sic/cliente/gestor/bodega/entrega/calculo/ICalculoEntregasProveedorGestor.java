package ec.com.smx.sic.cliente.gestor.bodega.entrega.calculo;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.dto.RangeValue;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaEntregaFacturaDigitalDTO;


/**
 * @author acaiza
 *
 */
public interface ICalculoEntregasProveedorGestor {
	
	/**
	 * Obtiene las recepciones de un proveedor
	 * 
	 * @param EntregaEstadoDTO
	 * @return Collection<RecepcionProveedorDTO>
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<RecepcionProveedorDTO> obtenerRecepcionesProveedor(EntregaEstadoDTO entregaEstado) throws SICException;
	
	/**
	 * Obtiene los andenes de una entrega
	 * 
	 * @param entregasDTO
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<DetalleSeccionDTO> obtenerAndenesEntrega(Collection<EntregaDTO> entregasDTO) throws SICException;
	
	/**
	 * Obtiene las entregas de un proveedor
	 * 
	 * @param EntregaEstadoDTO
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<EntregaDTO> obtenerEntregasProveedor(EntregaEstadoDTO entregaEstadoDTO) throws SICException;
	
	/**
	 * Obtiene las entregas de un proveedor
	 * 
	 * @param EntregaEstadoDTO
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<EntregaDTO> obtenerEntregasProveedorByRecepcionProveedor(Collection<Long> codigosRecepcionProveedor) throws SICException;
	
	/**
	 * Obtiene las entregas de un proveedor en base a los datos de la factura digital
	 * 
	 * @param entregaDTO
	 * @param estadosEntrega
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaEntregaFacturaDigitalDTO> obtenerEntregasProveedor(EntregaDTO entregaDTO, Collection<String> estadosEntrega) throws SICException;
	
	/**
	 * Obtiene los tipos de pedido de una entrega
	 * @param codigoEntrega
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<CatalogoValorDTO> obtenerTiposPedidoEntrega(Long codigoEntrega) throws SICException;
	
	/**
	 * Obtiene los tipos de pedido de una entrega por bodega, subbodega, tipo pedido: [codigoAreaTrabajoBodega, codigoSubBodega, codigoTipoRecepcion, valorTipoRecepcion]
	 * 
	 * @param codigoEntrega
	 * @return
	 * @throws SICException
	 */
	public Collection<Object[]> obtenerTiposPedidoSubbodegaEntrega(Long codigoEntrega) throws SICException;
	
	/**
	 * Obtiene los tipos de pedido de varias entrega por bodega, subbodega, tipo pedido, entrega: [codigoAreaTrabajoBodega, codigoSubBodega, codigoTipoRecepcion, valorTipoRecepcion, codigoEntrega]
	 * 
	 * @param codigoEntrega
	 * @return
	 * @throws SICException
	 */
	public Collection<Object[]> obtenerTiposPedidoSubbodegaEntrega(Collection<Long> codigoEntrega) throws SICException;
	
	/**
	 * Obtiene los tipos de pedido de varias entregas
	 * @param codigoEntrega
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<CatalogoValorDTO> obtenerTiposPedidoEntrega(Collection<Long> codigosEntrega) throws SICException;
	
	/**
	 * Obtiene las subbodegas relacionadas a la entrega
	 * @param codigoEntrega
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<BodegaDTO> obtenerSubBodegasEntrega(Long codigoEntrega) throws SICException;

	
	/**
	 * Obtiene la cantidad de detalles de tarea por Entrega
	 * 
	 * @param codigosEntrega Lista de codigos de entrega
	 * @throws SICException Excepcion en caso de prodicirse un error
	 */
	public Collection<Object[]> obtenerCantidadAndenesPorEntrega(Collection<Long> codigosEntrega) throws SICException;
	
	/**
	 * Obtiene las horas de inicio de las entregas de los proveedores de una fecha determinada
	 * @param fechaEntrega Fecha de la entrega
	 * @return Una coleccion con las horas de entrega
	 * @throws SICException Excepcion en caso de prodicirse un error
	 */
	public Collection<Date> obtenerHorasEntregasPorFecha(Date fechaEntrega) throws SICException;
	
	/**
	 * 
	 * @param codigoProveedor
	 * @param fechaEntrega
	 * @param codigoAreaTrabajoEntrega
	 * @param codigoCompania
	 * @param codigosEntrega
	 * @return
	 * @throws SICException
	 */
	Collection<EntregaDTO> obtenerEntregasPorDia(String codigoProveedor, Date fechaEntrega, Integer codigoAreaTrabajoEntrega, Integer codigoCompania, Collection<Long> codigosEntrega) throws SICException;
	
	/**
	 * Obtiene las entregas dentro de un rango de fechaEntrega y su estado.
	 * @param rangoFechas, Collection<String> estadosEntrega
	 * @return
	 * @throws SICException Excepcion
	 */
	public Collection<EntregaDTO> obtenerEntregasProveedorPlanificadas(RangeValue<Date> rangoFechas, Collection<String> estadosEntrega, Boolean condicionIntegrado) throws SICException;
	
	/**
	 * Obtiene especificamente datos de una entrega que son necesarios para generar el archivo de planificacion de entregas.
	 * @param codigoEntrega
	 * @return
	 * @throws SICException Excepcion
	 */
	public Collection<Object[]> obtenerDatosParaGenerarArchivoEntregaPlanificada(Long codigoEntrega) throws SICException;
	
	/**
	 * Metodo para buscar articulos con diferencias en el proceso logistico de validacion 
	 * para saber la cantidad y peso que se recibio y mostrar en la entrega B2B en facturas ya recibidas
	 * como parametro el datalle de la factura.
	 * @param detalleFacturaEstadoDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleFacturaEstadoDTO>  mostrarCantidadArticulosRecibidosPorFactura(Collection<DetalleFacturaEstadoDTO> detalleFacturaEstadoDTOs)throws SICException;
	
	/**
	 * Obtiene las entregas posteriores a la fecha actual
	 * @param codigoProveedor
	 * @param fechaActual
	 * @param codigoAreaTrabajoEntrega
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<EntregaDTO> obtenerEntregasPosteriores(String codigoProveedor, Date fechaActual, Integer codigoAreaTrabajoEntrega, Integer codigoCompania) throws SICException;

	/**
	 * Obtiene el numero de andenes asignados desde el B2B
	 * @param codigoCompania
	 * @param codigoEntrega
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerAndenesEntregaB2B(Integer codigoCompania, Long codigoEntrega) throws SICException;
	
	/**
	 * Consulta las las horas de la configuracion de las entregas en base a los datos de un vistaEntregaFacturaDigitalDTO
	 * @param vistaEntregaFacturaDigitalDTO entrega a consultar
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 * @author derazo
	 */
	public Collection<Time> obtenerHorasFechaEntrega(VistaEntregaFacturaDigitalDTO vistaEntregaFacturaDigitalDTO)  throws SICException;
}
