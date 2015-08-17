package ec.com.smx.sic.cliente.servicio.bodega;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.dto.RangeValue;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCalendarioEntregaBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaEntregaFacturaDigitalDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.FacturaDigitalEST;
import ec.com.smx.sic.cliente.mdl.vo.EntregaVO;


/**
 * 
 * @author acaiza
 *
 */
public interface IEntregasProveedorServicio {

	/**
	 * Obtiene los tipos de pedido de varias entregas
	 * @param codigoEntrega
	 * @return
	 * @throws SICException
	 */
	public Collection<CatalogoValorDTO> transObtenerTiposPedidoEntrega(Collection<Long> codigosEntrega) throws SICException;
	/**
	 * 
	 * @param EntregaEstadoDTO
	 * @return Collection<RecepcionProveedorDTO>
	 * @throws SICException
	 */
	public Collection<RecepcionProveedorDTO> transObtenerRecepcionesProveedor(EntregaEstadoDTO entregaEstadoDTO) throws SICException;
	
	/**
	 * @param articuloUnidadManejoDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public void transActualizarCantidadArticuloUM(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;
	
	/**
	 * Crea una entrega de un proveedor con las fechas del calendario de entrega
	 * @param entregaDTO
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public EntregaVO transCrearEntregaProveedor(EntregaVO entregaVO) throws SICException;
	
	/**
	 * 
	 * @param entregaVO
	 * @param mapEntregaVO
	 * @return
	 * @throws SICException
	 */
	public Collection<EntregaVO> transReConfigurarEntregaProveedor(EntregaDTO entregaPrincipal, Collection<EntregaVO> entregaVOs) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraEstadoDTOs
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<EntregaVO> transCrearEntregaProveedorPorOrdenCompraEstado(Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs, EntregaDTO entregaDTO) throws SICException;
	
	/**
	 * 
	 * @param entregaVO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public void transEliminarEntregaProveedor(EntregaDTO entregaDTO) throws SICException;
	
	/**
	 * 
	 * @param entregaVO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public VistaEntregaFacturaDigitalDTO transActualizarEntregaProveedor(EntregaDTO entregaDTO, Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) throws SICException;
	
	/**
	 * 
	 * @param entregaVO
	 * @param ordenCompraDetalleEstadoDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public void transEliminarItemEntregaProveedor(EntregaDTO entregaDTO, OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO) throws SICException;
	
	/**
	 * 
	 * @param entregaVO
	 * @param ordenCompraDetalleEstadoDTOs
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public void transEliminarItemsEntregaProveedor(EntregaDTO entregaDTO, Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) throws SICException;
	
	/**
	 * Cambia el estado de una entrega en base al estado actual de una entrega y la accion para buscar el siguiente estado de la entrega
	 * 
	 * @param entregaVO
	 * @param estadoEntregaCatVal
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public void transCambiarEstadoEntregaProveedor(EntregaDTO entregaDTO, CatalogoValorDTO estadoEntregaCatVal) throws SICException;
	
	/**
	 * Obtiene los andenes de una entrega en base a los datos de una entrega
	 * 
	 * @param entregasDTO coleccion de entregas
	 * @return Coleccion de andenes
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<DetalleSeccionDTO> transObtenerAndenesEntrega(Collection<EntregaDTO> entregasDTO) throws SICException;
	
	/**
	 * Consulta las entrega de un proveedor en base a los datos de un EntregaEstadoDTO
	 * 
	 * @param EntregaEstadoDTO
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<EntregaDTO> transObtenerEntregasProveedor(EntregaEstadoDTO entregaEstadoDTO) throws SICException;
	
	/**
	 * Obtiene las entregas de un proveedor con datos de la factura digital en base a los datos de un EntregaDTO y los estado de la entrega
	 * 
	 * @param entregaDTO Un EntregaDTO
	 * @param estadosEntrega Un Collection de String con los estados de una entrega
	 * @return Un Collection de VistaEntregaFacturaDigitalDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<VistaEntregaFacturaDigitalDTO> transObtenerEntregasProveedor(EntregaDTO entregaDTO, Collection<String> estadosEntrega) throws SICException;
	
	/**
	 * Obtiene los tipos de pedido de una entrega en base a los datos de una entrega
	 * @param codigoEntrega
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<CatalogoValorDTO> transObtenerTiposPedidoEntrega(Long codigoEntrega) throws SICException;
	
	/**
	 * Obtiene las subbodegas de una entrega en base a los datos de una entrega
	 * @param codigoEntrega
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<BodegaDTO> transObtenerSubBodegasEntrega(Long codigoEntrega) throws SICException;
	
	/**
	 * Cambia el estado de la entrega del proveedor para la recepcion
	 */
	public void transCambiarEstadoEntregaProveedorParaRecepcion(Collection<EntregaDTO> entregasDTO, RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;  
	
	/**
	 * Obtiene la cantidad de detalles de Tarea por Entrega
	 * 
	 * @param codigosEntrega
	 * @return Un Collection de object[] c E.id.codigoEntrega, COUNT(T.id.codigoTarea)
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<Object[]> transObtenerCantidadAndenesPorEntrega(Collection<Long> codigosEntrega) throws SICException;
	
	/**
	 * Obtiene las horas de inicio de las entregas de los proveedores de una fecha determinada
	 * 
	 * @param fechaEntrega Fecha de la entrega
	 * @return Una coleccion con las horas de entrega
	 * @throws SICException Excepcion en caso de prodicirse un error
	 */
	public Collection<Date> transObtenerHorasEntregasPorFecha(Date fechaEntrega) throws SICException;
	
	/**
	 * Migrar ordenes de compra B2B - SIC
	 * @throws SICException
	 * @author osaransig
	 */
	public void migrarOrdenesCompra(VistaEntregaFacturaDigitalDTO vistaEntregaFacturaDigitalDTO) throws SICException;
	
	/**
	 * 
	 * @param entregaDTO
	 * @param vistaCalendarioEntregaBodegaDTO
	 * @param autorizacionDTO
	 * @throws SICException
	 */
	public void transGuardarAutorizacionesAndenesEntrega(EntregaDTO entregaDTO, VistaCalendarioEntregaBodegaDTO vistaCalendarioEntregaBodegaDTO) throws SICException;
	
	/**
 	 * Rechaza los articulos de la entrega cuando el proveedor no acepta los costos del articulo con los de la corporacion
 	 * 
 	 * @param entregaDTO Un EntregaDTO
 	 * @param facturaDigitalESTs Un Collection FacturaDigitalEST con los articulos agrupados que se va rechazar 
 	 * @return Un Collection de DetalleFacturaEstadoDTO con los articulos que faltan por rechazar
 	 * @throws SICException Excepcion en caso de producirse un error
 	 */
	public Collection<DetalleFacturaEstadoDTO> transRecharzarArticulosEntrega(EntregaDTO entregaDTO, Collection<FacturaDigitalEST> facturaDigitalESTs) throws SICException;
	
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
	 * Actualiza la fecha Calendario de una Entrega Normal Configurada.
	 * 
	 * @param entregaVO
	 */
	public void transActualizarEntregaNormalConfigurada(EntregaVO entregaVO) throws SICException;
	
	/**
	 * 
	 * @param codigoEntrega
	 * @return Collection<Object>
	 */
	public Collection<Object> transConsultarFechaCaducidadByEntrega(Long codigoEntrega)throws SICException;
	
	
	/**
	 * Obtiene las entregas dentro de un rango de fechaEntrega y su estado.
	 * @param rangoFechas, Collection<String> estadosEntrega
	 * @return
	 * @throws SICException Excepcion
	 * */
	public Collection<EntregaDTO> transObtenerEntregasProveedorPlanificadas(RangeValue<Date> rangoFechas, Collection<String> estadosEntrega, Boolean condicionIntegrado) throws SICException;
	
	/**
	 * Obtiene especificamente datos de una entrega que son necesarios para generar el archivo de planificacion de entregas.
	 * @param codigoEntrega
	 * @return
	 * @throws SICException Excepcion
	 */
	public Collection<Object[]> transObtenerDatosParaGenerarArchivoEntregaPlanificada(Long codigoEntrega) throws SICException;
	
	/**
	 * Metodo para buscar articulos con diferencias en el proceso logistico de validacion 
	 * para saber la cantidad y peso que se recibio y mostrar en la entrega B2B en facturas ya recibidas
	 * como parametro el datalle de la factura.
	 * @param detalleFacturaEstadoDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleFacturaEstadoDTO> transMostrarCantidadArticulosRecibidosPorFactura(Collection<DetalleFacturaEstadoDTO> detalleFacturaEstadoDTOs)throws SICException;
	
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
