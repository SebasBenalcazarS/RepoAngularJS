package ec.com.smx.sic.cliente.gestor.ordenCompra.calculo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.quartz.Scheduler;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.dto.RangeValue;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArchivoContenidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.GrupoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraHistoricoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoArchivoInformacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraEstadoID;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.EmbarqueEstadoImpDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraRecepcionVO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraVO;
import ec.com.smx.sic.cliente.mdl.vo.PlanContingenciaOrdenCompraVO;
import ec.com.smx.stp.dto.TareaProgramadaDTO;

/**
 * 
 * @author amunoz
 *
 */
public interface IBusquedaOrdenCompraGestor extends Serializable {
	/**
	 * 
	 * @param ordenCompraPlantilla
	 * @param componentesMap
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<OrdenCompraEstadoDTO> buscarOrdenesCompra(AdminOrdenCompraVO ordenCompraPlantilla, Map<String, Object> componentesMap) throws SICException;

	/**
	 * 
	 * @param ordenCompraEstadoInit
	 * @throws SICException
	 */
	public void inicializarOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoInit) throws SICException;

	/**
	 * 
	 * @param componentesBusqueda
	 * @param ordenCompraPlantilla
	 * @throws SICException
	 */
	public void agregarRestriccionesBusqueda(Map<String, Object> componentesBusqueda, AdminOrdenCompraVO ordenCompraVO) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param ordenCompraVO
	 * @throws SICException
	 */
	public void buscarColeccionesFiltrosOrdenCompra(Integer codigoCompania, AdminOrdenCompraVO ordenCompraVO) throws SICException;

	/**
	 * Permite obtener las ordenes de compra que se van a exportar, se usa unicamente en BusquedaOrdenCompra
	 * @param ordenCompraPlantilla
	 * @throws SICException
	 */
	public Collection<OrdenCompraEstadoDTO> buscarTodoOrdenesCompra(AdminOrdenCompraVO ordenCompraPlantilla, HashMap<String, Object> componentesMap) throws SICException;

	/**
	 * 
	 * @param ordenCompraEstadoDTO
	 * @return
	 * @throws SICException
	 */

	public Collection<OrdenCompraDetalleEstadoDTO> obtenerDetallesOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoDTO) throws SICException;

	/**
	 * @param ordenCompraDetalleEstadoCol
	 */
	public void completarDescuentosOrdenCompra(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstado, Collection<TipoDescuentoDTO> tipoDescuentoDetCol) throws SICException;

	/**
	 * 
	 * @param ordenCompraDetalleEstadoDTO
	 * @param grupoImpuestoDTOCol
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void completarImpuestosOrdenCompra(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO, Collection<GrupoImpuestoDTO> grupoImpuestoDTOCol, OrdenCompraEstadoDTO ordenCompraEstadoDTO) throws SICException;

	/**
	 * 
	 * @param articuloProveedorDTO
	 * @param articuloBitacoraCodigoBarrasDTO
	 * @param ordenCompraDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> obtenerOrdenCompraDetallesEstadoSinEntregar(ArticuloProveedorDTO articuloProveedorDTO, ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO, OrdenCompraDTO ordenCompraDTO, boolean comparaCantidadEntrega, Boolean validarPorFechaEntrega) throws SICException;

	/**
	 * 
	 * @param vistaProveedorDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraEstadoDTO> obtenerOrdenCompraDisponibleEntregaPorProveedor(VistaProveedorDTO vistaProveedorDTO) throws SICException;

	/**
	 * Metodo para obtener proveedores que tiene pedidos pendientes
	 * 
	 * @param vistaProveedorDTO
	 *            Plantilla de busqueda de proveedores
	 * @param codigosATBodega
	 *            Codigos del area de trabajo destino de los pedidos
	 * @param codigosProveedorExcluir
	 *            Codigos para excluir los pedidos de ciertos proveedores
	 * @return Un Collection de VistaProveedorDTO
	 * @throws SICException
	 *             Execepcion en caso de producirse un error
	 */
	public Collection<VistaProveedorDTO> obtenerProveedorOrdenCompraDisponibleEntrega(VistaProveedorDTO vistaProveedorDTO, Collection<Integer> codigosATBodega, Collection<String> codigosProveedorExcluir) throws SICException;

	/**
	 * 
	 * @param codigoOrdenCompra
	 * @param codigoCompania
	 * @param valorTipoOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public Collection<FacturaDTO> obtenerEntregasFacturaInterna(Long codigoOrdenCompra, Integer codigoCompania, String valorTipoOrdenCompra) throws SICException;

	/**
	 * 
	 * @param facturaDTO
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> obtenerDetalleEntregaFacturaInterna(FacturaDTO facturaDTO, Integer codigoCompania) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompra
	 * @return
	 */
	public OrdenCompraHistoricoEstadoDTO obtenerOrdenCompraHistoricoEstadoEntregada(Integer codigoCompania, Long codigoOrdenCompra) throws SICException;

	/**
	 * 
	 * @param pedidoDTO
	 * @param pedidoEstadoDTO
	 * @param ordenCompraDTO
	 * @param ordenCompraEstadoDTO
	 * @param rangoFechas
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoDTO> obtenerPedidoOrdenesCompra(PedidoDTO pedidoDTO, PedidoEstadoDTO pedidoEstadoDTO, OrdenCompraDTO ordenCompraDTO, OrdenCompraEstadoDTO ordenCompraEstadoDTO, RangeValue<Date> rangoFechas, HashSet<String> codigosClasificaciones) throws SICException;

	/**
	 * 
	 * @param pedidoArchivoInformacionDTO
	 * @param url
	 * @return
	 * @throws SICException
	 */
	public ArchivoContenidoDTO cargarArchivoContenido(PedidoArchivoInformacionDTO pedidoArchivoInformacionDTO, String url) throws SICException;

	/**
	 * @param pedidoPlantilla
	 * @param componentesMap
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<PedidoDTO> obtenerPedidoOrdenesCompraPaginado(PlanContingenciaOrdenCompraVO planContingenciaOrdenCompraVO, Map<String, Object> componentesMap) throws SICException;

	/**
	 * @param pedidoEstadoInit
	 * @throws SICException
	 */
	public void inicializarPedido(PedidoDTO pedidoEstadoInit, Boolean b2b) throws SICException;

	/**
	 * @param componentesBusqueda
	 * @param ordenCompraVO
	 * @throws SICException
	 */
	public void agregarRestriccionesBusquedaPedido(Map<String, Object> componentesBusqueda, PlanContingenciaOrdenCompraVO planContingenciaOrdenCompraVO, Boolean b2b, PedidoEstadoDTO pedidoEstadoDTO, OrdenCompraDTO ordenCompraDTO, OrdenCompraEstadoDTO ordenCompraEstadoDTO) throws SICException;

	/**
	 * @param pedidoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraEstadoDTO> obtenerOrdenCompraPorPedido(PedidoDTO pedidoDTO, boolean detallesOrdenesCompra) throws SICException;

	/**
	 * @param pedidos
	 * @return
	 * @throws SICException
	 */
	public HashMap<String, List<String>> obtenerEmailArchivosPedido(Collection<PedidoDTO> pedidos, PlanContingenciaOrdenCompraVO planContingenciaOrdenCompraVO, TareaProgramadaDTO tareaProgramadaDTO, Scheduler scheduler) throws SICException;

	/**
	 * @param pedido
	 * @param url
	 * @param mapEmailArchivos
	 * @throws SICException
	 */
	public void obtenerEmailArchivosPedidoTransaccional(PedidoDTO pedido, PlanContingenciaOrdenCompraVO planContingenciaOrdenCompraVO, HashMap<String, List<String>> mapEmailArchivos) throws SICException;

	/**
	 * @param adminOrdenCompraRecepcionVO
	 * @param componentesMap
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<EmbarqueEstadoImpDTO> obtenerEmbarquesPaginado(AdminOrdenCompraRecepcionVO adminOrdenCompraRecepcionVO, Map<String, Object> componentesMap) throws SICException;

	/**
	 * @param embarqueEstadoInit
	 * @throws SICException
	 */
	public void inicializarEmbarqueEstado(EmbarqueEstadoImpDTO embarqueEstadoInit) throws SICException;

	/**
	 * @param componentesBusqueda
	 * @param adminOrdenCompraRecepcionVO
	 * @throws SICException
	 */
	public void agregarRestriccionesBusquedaEmbarque(Map<String, Object> componentesBusqueda, AdminOrdenCompraRecepcionVO adminOrdenCompraRecepcionVO) throws SICException;

	/**
	 * 
	 * @param ordenCompraDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraEstadoDTO> consultarEstadosOrdenCompra(OrdenCompraDTO ordenCompraDTO) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param planContingenciaOrdenCompraVO
	 * @throws SICException
	 */
	public void buscarColeccionesFiltrosPlanContingencia(Integer codigoCompania, PlanContingenciaOrdenCompraVO planContingenciaOrdenCompraVO) throws SICException;

	/**
	 * @param embarque
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraEstadoDTO> obtenerOrdenCompraPorEmbarque(EmbarqueEstadoImpDTO embarque) throws SICException;
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void obtenerCompradoresBodegasCreacionOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;

	/**
	 * Metodo que consulta datos especificos en base a una coleccion que
	 * contiene codigos orden compra estado para validar las entregas en factura
	 * Digital.
	 * 
	 * @param Collection
	 *            <Long> codigoOrdenCompraEstadoCol
	 * @return
	 * @throws SICException
	 * */
	public Collection<Object[]> consultarOrdenCompraEstado(Collection<Long> codigoOrdenCompraDetalleEstadoCol) throws SICException;

	/**
	 * Metodo que busca descuentos
	 * 
	 * @param ordenCompraDetalleEstadoDescuentoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDetalleEstadoDescuentoDTO> buscarOrdenCompraDetalleEstadoDescuento(OrdenCompraDetalleEstadoDescuentoDTO ordenCompraDetalleEstadoDescuentoDTO) throws SICException;

	/**
	 * Permite obtener los pedidos que tienen pendiente el envio de email al
	 * usuario del proveedor
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoDTO> obtenerPedidosPendientesEnvioEmail(Integer codigoCompania) throws SICException;

	public Collection<FacturaDTO> obtenerEntregasFacturaInternas(Long codigoOrdenCompra, Integer codigoCompania, String valorTipoOrdenCompra) throws SICException;

	public Collection<BodegaDTO> obtenerSubbodegasPorFuncionarioComprador(String codigoFuncionario) throws SICException;

	/**
	 * Busca los detalle estado del estado que se pase. Filtrando por unidad de manejo y proveedor. Los detalles que se retorna son los enviados.
	 * @param codigosUnidadManejo
	 * @param codigosProveedor
	 * @param codigoOrdenCompraEstado
	 * @param codigoCompania
	 * @return Lista de detalles.
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> consultarDetalleEstadoOriginal(Collection<Long> codigosUnidadManejo, Collection<String> codigosProveedor, Long codigoOrdenCompraEstado, Integer codigoCompania);
	
	/**
	 * Busca ordenes de compra por Id's para la impresion
	 * @param listadoIdsOrdenesCompra
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraEstadoDTO> buscarOrdenesCompraParaImpresion(Collection<OrdenCompraEstadoID> listadoIdsOrdenesCompra) throws SICException;
	
	/**
	 * Busca ordenes de compra por Id's 
	 * @param listadoIdsOrdenesCompra
	 * @return
	 */
	public Collection<OrdenCompraEstadoDTO> buscarOrdenesCompraPorIds(Collection<OrdenCompraEstadoID> listadoIdsOrdenesCompra);
	
	/**
	 * 
	 * @param ordenesCompraIds
	 * @param ordenCompraVO
	 * @param tareaProgramadaDTO
	 * @param scheduler
	 * @return
	 * @throws SICException
	 */
	public HashMap<String, List<String>> obtenerEmailArchivosOrdenCompra(Collection<OrdenCompraEstadoID> ordenesCompraIds, AdminOrdenCompraVO ordenCompraVO, TareaProgramadaDTO tareaProgramadaDTO, Scheduler scheduler) throws SICException;

	/**
	 * 
	 * @param ordenesCompraIds
	 * @param ordenCompraVO
	 * @param mapEmailArchivos
	 * @throws SICException
	 */
	public void obtenerEmailArchivosOrdenCompraTransaccional(ArrayList<OrdenCompraEstadoID> ordenesCompraIds, AdminOrdenCompraVO ordenCompraVO, HashMap<String, List<String>> mapEmailArchivos) throws SICException;

	/**
	 * 
	 * @param codigoProveedor
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Boolean validarOrdenesCompraPendientes(String codigoProveedor, Integer codigoCompania, CatalogoValorDTO tipoPedido, String numeroOrdenCompra) throws SICException;
	
}
