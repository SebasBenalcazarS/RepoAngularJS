package ec.com.smx.sic.cliente.servicio.bodega;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.MultiKeyMap;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.frameworkv2.multicompany.dto.UserCompanySystemDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.CalendarioBodegaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaCalendarioBodegaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDetalleCalendarioProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaDiferenciaFacturasRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaEntregaFacturaDigitalDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.FacturaDigitalEST;
import ec.com.smx.sic.cliente.mdl.vo.BodegaVO;
import ec.com.smx.sic.cliente.mdl.vo.EntregaVO;
import ec.com.smx.sic.cliente.mdl.vo.FacturaDigitalVO;
import ec.com.smx.sic.cliente.mdl.vo.VistaProcesoLogisticoVO;

/**
 * 
 * @author acaiza
 * 
 */
public interface IFacturaDigitalServicio {

	/**
	 * 
	 * @param proveedorDTO
	 * @param fechaEntrega
	 * @return
	 * @throws SICException
	 */
	public Collection<CalendarioBodegaProveedorDTO> transObtenerCalendarioPorProveedor(ProveedorDTO proveedorDTO, BodegaDTO bodegaDTO, Date fechaEntrega) throws SICException;

	/**
	 * 
	 * @param proveedorDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<BodegaVO> transAgruparOrdenCompraDetalleEstadoPorBodegaYTipo(Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraEstadoDTOs) throws SICException;

	/**
	 * 
	 * @param proveedorDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<FacturaDigitalVO> transAgruparDetallesOrdenesCompraPorClasificacion(Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraEstadoDTOs) throws SICException;

	/**
	 * 
	 * @param detalleOrdenCompraEstadoDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<FacturaDigitalVO> transAgruparDetallesOrdenesCompraPorClasificacionSubClasificacion(Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraEstadoDTOs) throws SICException;

	/**
	 * 
	 * @param detalleOrdenCompraEstadoDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<FacturaDigitalVO> transAgruparDetallesOrdenCompraEstadoPorOrdenCompraEstado(Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraEstadoDTOs) throws SICException;

	/**
	 * 
	 * @param detalleOrdenCompraEstadoDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<FacturaDigitalVO> transAgruparDetallesOrdenesCompraPorFechaCaducidad(Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraEstadoDTOs) throws SICException;
	
	/**
	 * @param detalleOrdenCompraEstadoDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<FacturaDigitalVO> transAgruparDetallesOrdenesCompraPorMarca(Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraEstadoDTOs) throws SICException;

	/**
	 * 
	 * @param proveedorDTO
	 * @param bodegaDTO
	 * @param fechaEntrega
	 * @return
	 * @throws SICException
	 */
	public Collection<EntregaCalendarioBodegaProveedorDTO> transObtenerCalendarioEntregasProveedor(ProveedorDTO proveedorDTO, BodegaDTO bodegaDTO, Date fechaEntrega) throws SICException;

	/**
	 * 
	 * @param proveedorDTO
	 * @param estadoEntrega
	 * @param fechaEntrega
	 * @return
	 * @throws SICException
	 */
	public Collection<EntregaVO> transObtenerEntregas(EntregaDTO entregaDTO) throws SICException;
	
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
	public VistaEntregaFacturaDigitalDTO transObtenerDatosEntregaFacturaDigital(VistaEntregaFacturaDigitalDTO vistaEntregaFacturaDigitalDTO) throws SICException;
	
	/**
	 * Obtiene los datos de una factura estado
	 * @param codigoFactura Codigo de una factura
	 * @return Un FacturaEstadoDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public FacturaEstadoDTO transObtenerDatosFacturaEstadoFacturaDigital(Long codigoFactura) throws SICException;
	
	/**
	 * 
	 * @param bodegaVO
	 * @param userCompanySystemDto
	 * @return
	 */
	public EntregaVO transCrearEntregaAutorizacion(BodegaVO bodegaVO, UserCompanySystemDto userCompanySystemDto,String codigoProveedor) throws SICException;

	
	/**
	 * Obtener articulos recibidos en la entrega por parte del proveedor 
	 * @param entregaVO
	 * @return Collection<ArticuloDTO>
	 * @throws SICException
	 * @author osaransig
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> transObtenerArticulosRecibidosEntrega(EntregaVO entregaVO) throws SICException;
	
	/**
	 * 
	 * @param entregaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<EntregaDetalleCalendarioProveedorDTO> transObtenerCalendarioAprobadoEntrega(EntregaDTO entregaDTO, Collection<String> estadosEntregaAutorizacion, Collection<String> estadosAutorizacion, boolean condicion) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraDetalleEstadoDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<FacturaDigitalEST> transConsolidarOrdenesCompraDetalleEstadoEnFacturaDigitalEST(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) throws SICException;

	/**
	 * Calcula los diferentes totales de un factura digital
	 * 
	 * @param facturaEstadoDTO Un FacturaEstadoDTO
	 * @return Un FacturaEstadoDTO
	 * 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public FacturaEstadoDTO transCalcularTotalesFactura(FacturaEstadoDTO facturaEstadoDTO) throws SICException;
	
	
	/**
	 * Consultar proveedores por entrega
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<EntregaVO> transObtenerProveedorePorEntrega(EntregaVO entregaVO) throws SICException;
	
	
	/**
	 * Consultar articulos por orden de compra y factura
	 * @param numeroFacturaList
	 * @param numeroOrdenCompraList
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<OrdenCompraDetalleEstadoDTO> transObtenerArticulosPorOrdenCompraFactura(
			List<String> numeroFacturaList, List<String> numeroOrdenCompraList) throws SICException;
	
	
	/**
	 * Obtener articulos por entrega
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<OrdenCompraDetalleEstadoDTO> transObtenerArticulosPorEntrega(EntregaVO entregaVO) throws SICException;
	
	
	/**
	 * Obtener coleccion de diferencias entre articulos facturados y recibidos
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	List<Collection<OrdenCompraDetalleEstadoDTO>> transObtenerDiferenciasArtFacRec(EntregaVO entregaVO) throws SICException;
	
	
	/**
	 * Obtener facturas por numero de factura
	 * @param numeroFacturas	colleccion de numeros de facturas
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<FacturaEstadoDTO> transObtenerFacturasPorNumFac(Collection<String> numeroFacturas) throws SICException;
	
	
	/**
	 * Obtener facturas por entrega
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<FacturaEstadoDTO> transObtenerFacturasPorEntrega(EntregaVO entregaVO) throws SICException;

	
	/**
	 * Validar articulos facturados contra los recibidos
	 * @param mapaProcesos		mapa con los procesos: Obtener cabecera factura proveedor recibida y obtener detalle factura
	 * proveedore recibida
	 * @throws SICException
	 * @author osaransig
	 */
	void transValidarDiferenciaArtFacturadosContraRecibidosDesdeIntegracion(Map<String, Collection<Object>> mapaProcesos) throws SICException;
	
	/**
	 * Consultar ordenes de compra por datos de la plantilla 
	 * @param ordenCompraEstadoDTO
	 * @param multiKeyMapOrdenEntrega
	 * @return
	 * @throws SICException
	 */
	List<OrdenCompraEstadoDTO> transConsultarOrdenCompraEstadoPorCodOrdComCodEnt(OrdenCompraEstadoDTO ordenCompraEstadoDTO, MultiKeyMap multiKeyMapOrdenEntrega) throws SICException;
	
	
	/**
	 * Consultar proveedores por detalle factura estado de la tabla de justificaciones
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<EntregaVO> transConsultarProveedoresPorDetalleFacturaEstado(EntregaVO entregaVO) throws SICException;
	
	/**
	 * Consultar proveedores por orden de compra detalle estado de la tabla de justificaciones
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<EntregaVO> transConsultarProveedoresPorOrdenCompraDetalleEstado(EntregaVO entregaVO) throws SICException;
	
//	void transActualizarJustificaciones(Collection<>) throws SICException;
	
	/**
	 * 
	 * @param mapaProcesos
	 * @throws SICException
	 */
	void transAlmacenarCabecerasRecepcionProveedorArticulos(Map<String, Collection<Object>> mapaProcesos)throws SICException;
	
	public void transValidarDiferenciaArtFacturadosContraRecibidosDesdeIntegracionSIC(Map<String, Collection<Object>> mapaProcesos) throws SICException ;
	
	/**
	 * Metodo que obtiene los articulos con diferencias en cantidad y peso que se registraron durante la recepcion.
	 * @param recepcionProveedorDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaDiferenciaFacturasRecepcionDTO> transObtenerDiferenciasRecepcion(RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
	 * Metodo que obtiene procesoLogistico creado desde la recepcion de entrega B2B - SIC
	 * @param vistaProcesoLogisticoVO
	 * @param esFechaEspecifica para un dia en especifico
	 * @return
	 * @throws SICException
	 */
	VistaProcesoLogisticoVO obtenerProcesoLogisticoRecepcion(VistaProcesoLogisticoVO vistaProcesoLogisticoVO, Boolean esFechaEspecifica) throws SICException;
	
	/**
	 * 
	 * @param usuarioId
	 * @param tipoAreaTrabajoMayorNivel
	 * @param tipoAreaTrabajoMenorNivel
	 * @param codigoProcesoCaracteristicaAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> transObtenerAreasTrabajoPorUsuario(String usuarioId, String tipoAreaTrabajoMayorNivel, String tipoAreaTrabajoMenorNivel) throws SICException;

}
