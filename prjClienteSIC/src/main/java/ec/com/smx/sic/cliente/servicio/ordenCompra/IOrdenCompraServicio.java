package ec.com.smx.sic.cliente.servicio.ordenCompra;

import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.quartz.Scheduler;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.ProcesoRelacionAreaTrabajoDTO;
import ec.com.smx.framework.common.util.dto.RangeValue;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArchivoContenidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.InterfacePedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraGestionDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraHistoricoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoArchivoInformacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraEstadoID;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.EmbarqueEstadoImpDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.FacturaEstadoImpDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.integracion.IConsultarDatosArticuloIDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraRecepcionVO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloImportadoVO;
import ec.com.smx.sic.cliente.mdl.vo.OrdenCompraContingenciaPedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.PlanContingenciaOrdenCompraVO;
import ec.com.smx.sic.cliente.mdl.vo.PlantillaOrdenCompraVO;
import ec.com.smx.sic.cliente.mdl.vo.SumatoriaUnidadManejoOrdenCompraVO;
import ec.com.smx.sic.cliente.mdl.vo.ValidacionOrdenCompraEmbarqueVO;
import ec.com.smx.stp.dto.TareaProgramadaDTO;

/**
 * 
 * @author amunoz
 *
 */

public interface IOrdenCompraServicio extends Serializable {

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
	 * 
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
	 * 
	 * @param ordenCompraCreacionVO
	 * @throws SICException
	 */
	public void obtenerDatosGeneralesCreacionOrdenCompra(AdminOrdenCompraVO ordenCompraCreacionVO) throws SICException;

	/**
	 * 
	 * @param ordenCompraCreacionVO
	 * @throws SICException
	 */
	public void obtenerPlazoPagoPorSubbodega(AdminOrdenCompraVO ordenCompraCreacionVO) throws SICException;

	/**
	 * 
	 * @param ordenCompraCreacionVO
	 * @throws SICException
	 */
	public void obtenerClasificacionPorCodigo(AdminOrdenCompraVO ordenCompraCreacionVO) throws SICException;

	/**
	 * 
	 * @param vistaProveedorDTO
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<VistaProveedorDTO> obtenerProveedorFuncionario(VistaProveedorDTO vistaProveedorDTO, String codigoFuncionario) throws SICException;

	/**
	 * 
	 * @param ordenCompraCreacionVO
	 * @param artUniManProDTO
	 * @param consultarPrecios
	 * @param consultarPrecodificados
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> obtenerItemsOrdenCompraCreacion(AdminOrdenCompraVO ordenCompraCreacionVO, ArticuloUnidadManejoProveedorDTO artUniManProDTO, boolean consultarPrecios, boolean consultarPrecodificados, boolean suprimirRestriccionesOrdenCompra) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoProveedorDTO> obtenerArticulosUnidadManejo(AdminOrdenCompraVO adminOrdenCompraVO, boolean consultarPrecodificados, boolean suprimirRestriccionesOrdenCompra) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void asignarPropiedadesDinamicas(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;

	/**
	 * 
	 * @param articuloProveedorDTO
	 * @param articuloBitacoraCodigoBarrasDTO
	 * @param ordenCompraDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> obtenerOrdenCompraDetallesEstadoSinEntregar(ArticuloProveedorDTO articuloProveedorDTO, ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO, OrdenCompraDTO ordenCompraDTO, boolean comparaCantidadEntrega , Boolean validarPorFechaEntrega) throws SICException;

	/**
	 * 
	 * @param vistaProveedorDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraEstadoDTO> obtenerOrdenCompraDisponibleEntregaPorProveedor(VistaProveedorDTO vistaProveedorDTO) throws SICException;

	/**
	 * 
	 * @param vistaProveedorDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaProveedorDTO> obtenerProveedorOrdenCompraDisponibleEntrega(VistaProveedorDTO vistaProveedorDTO, Collection<Integer> codigoAreaTrajoDestino, Collection<String> codigosProveedorExcluir) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDTO> crearOrdenCompraTransaccional(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDTO> crearOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;

	/**
	 * 
	 * @param ordenCompraEstadoDTONueva
	 * @param ordenCompraEstadoDTOAnterior
	 * @param finalizarEstado
	 * @return
	 * @throws SICException
	 */
	/*
	 * public OrdenCompraEstadoDTO crearOrdenCompraEstado(OrdenCompraEstadoDTO
	 * ordenCompraEstadoDTONueva, OrdenCompraEstadoDTO
	 * ordenCompraEstadoDTOAnterior, boolean finalizarEstado) throws
	 * SICException;
	 */

	/**
	 * 
	 * @param ordenCompraEstadoDTOModificacion
	 * @return
	 * @throws SICException
	 */
	public OrdenCompraEstadoDTO modificarOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoDTOModificacion) throws SICException;

	/**
	 * 
	 * @param ordenCompraEstadoDTOModificacion
	 * @param ordenCompraEstadoDTOAnterior
	 * @param recepcionArticulo
	 * @param finalizarEstado
	 * @return
	 * @throws SICException
	 */
	// public OrdenCompraEstadoDTO
	// modificarOrdenCompraEstado(OrdenCompraEstadoDTO
	// ordenCompraEstadoDTOModificacion, boolean recepcionArticulo, boolean
	// finalizarEstado) throws SICException;

	/**
	 * 
	 * @param ordenCompraEstadoDTOInicio
	 * @param accion
	 * @return
	 * @throws SICException
	 */
	public OrdenCompraEstadoDTO generarNuevoEstadoOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoDTOInicial, String accion) throws SICException;

	/**
	 * @param ordenCompraEstadoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<FacturaDTO> obtenerEntregasFacturasInternas(Long codigoOrdenCompra, Integer codigoCompania, String valorTipoOrdenCompra) throws SICException;

	/**
	 * 
	 * @param facturaDTO
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> obtenerDetallesEntregasFacturasInternas(FacturaDTO facturaDTO, Integer codigoCompania) throws SICException;

	/**
	 * 
	 * @param ordenCompraEstadoDTO
	 * @return
	 */
	public OrdenCompraEstadoDTO inactivarOrdenCompraEstado(OrdenCompraEstadoDTO ordenCompraEstadoDTO) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompra
	 * @return
	 */
	public OrdenCompraHistoricoEstadoDTO obtenerOrdenCompraHistoricoEstadoEntregada(Integer codigoCompania, Long codigoOrdenCompra) throws SICException;

	/**
	 * @param adminOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public IConsultarDatosArticuloIDTO consultarDatosArticulosOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, Collection<OrdenCompraDetalleEstadoDTO> detalles) throws SICException;

	/**
	 * 
	 * @param ordenCompraEstadoDTO
	 * @param codigoAccion
	 * @param mensajesErroOmitirOrdenCompra: Mensajes a omitir de los errores que devuelve el SIC
	 * @throws SICException
	 */
	public void registrarOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoDTO, Integer codigoAccion, Integer ultimaOrdenCompra, String mensajesErroOmitirOrdenCompra) throws SICException;

	/**
	 * @param pedidoDTO
	 * @param codigoLocal
	 * @throws SICException
	 */
	public void guardarArchivosGeneradosOrdenCompra(PedidoDTO pedidoDTO) throws SICException;

	
	/**
	 * @param pedidoDTO
	 * @param url
	 * @param mensajeReporteSubbodega
	 * @param planContingenicaB2B
	 * @param archivoPlano            : flag que devuelve los bytes en formato txt
	 * @return
	 * @throws SICException
	 */
	public byte[] generarDatosReporteOrdenCompra(PedidoDTO pedidoDTO, String url, String mensajeReporteSubbodega, Boolean planContingenicaB2B, Boolean archivoPlano) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public byte[] generarDatosDatosReporteNotaPedido(PedidoDTO pedidoDTO, String url) throws SICException;

	/**
	 * 
	 * @param pedidoDTO
	 * @return
	 * @throws SICException
	 */
	public String generarArchivoTxtOrdenCompra(PedidoDTO pedidoDTO) throws SICException;

	/**
	 * 
	 * @param pedidoDTO
	 * @return
	 * @throws SICException
	 */
	public String generarArchivoExcelOrdenCompra(PedidoDTO pedidoDTO) throws SICException;

	/**
	 * Generar archivo orden compra en batch
	 * 
	 * @author finga
	 * @param pedidoDTO
	 * @param mensajeReporteSubbodega
	 * @return
	 * @throws SICException
	 */
	public String generarArchivoTxtOrdenCompraBatch(PedidoDTO pedidoDTO, String mensajeReporteSubbodega) throws SICException;
	
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<ArticuloUnidadManejoProveedorDTO> obtenerArticulosUnidadManejoPaginado(AdminOrdenCompraVO adminOrdenCompraVO, ArticuloUnidadManejoProveedorDTO artUniManProDTO) throws SICException;

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
	 * 
	 * @param ordenCompraEstadoDTO
	 * @param codigoAccion
	 * @return
	 * @throws SICException
	 */
	// public OrdenCompraEstadoDTO anularOrdenCompra(OrdenCompraEstadoDTO
	// ordenCompraEstadoDTO) throws SICException;

	/**
	 * @param ordenCompraCreacionVO
	 * @return LinkedHashMap<String, List>
	 * @throws SICException
	 */
	public LinkedHashMap<String, List> procesarArchivoCreacionOrdenCompra(AdminOrdenCompraVO ordenCompraCreacionVO, InputStream inputStreamArchOrdenCompra) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param ordenComptraDetalleEstadoList
	 * @param valorIngresado Corresponde a la clave identificadora en el mapa de propiedades dinamicas
	 * @throws SICException
	 */
	public void copiarValorSugeridoOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, List<OrdenCompraDetalleEstadoDTO> ordenComptraDetalleEstadoList, String valorIngresado) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param ordenComptraDetalleEstadoList
	 * @param valorIngresado Corresponde a la clave identificadora en el mapa de propiedades dinamicas
	 * @throws SICException
	 */
	public void limpiarValorSugeridoOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, List<OrdenCompraDetalleEstadoDTO> ordenComptraDetalleEstadoList, String valorIngresado) throws SICException;


	/**
	 * 
	 * @param pedidoArchivoInformacionDTO
	 * @throws SICException
	 */
	public void actualizarPedidoArchivoComoUtilizado(PedidoArchivoInformacionDTO pedidoArchivoInformacionDTO) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void copiarValoresNuevaConsultaOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void inicializacionValoresTotalesOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void obtenerDatosProveedorSubbodegaOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void asignarDatosIntegracionOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, Collection<OrdenCompraDetalleEstadoDTO> obtenerItemsOrdenCompraCreacionAsistida) throws SICException;

	/**
	 * @param plantillaOrdenCompraVO
	 * @throws SICException
	 */
	public void obtenerDatosGeneralesCreacionPlantilla(PlantillaOrdenCompraVO plantillaOrdenCompraVO) throws SICException;

	/**
	 * Obtiene listado de dias habiles con codigos
	 * 
	 * @param plantillaOrdenCompraVO
	 * @throws SICException
	 */
	public void obtenerDias(PlantillaOrdenCompraVO plantillaOrdenCompraVO) throws SICException;

	/**
	 * @param plantillaOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoPlantillaDetalleDTO> obtenerItemsPlantillaCreacion(PlantillaOrdenCompraVO plantillaOrdenCompraVO, ArticuloUnidadManejoProveedorDTO artUniManProDTO) throws SICException;

	/**
	 * @param plantillaOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public String crearPlantillaOrdenCompra(PlantillaOrdenCompraVO plantillaOrdenCompraVO) throws SICException;

	/**
	 * @param plantillaOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public String modificarPlantillaOrdenCompra(PlantillaOrdenCompraVO plantillaOrdenCompraVO) throws SICException;

	/**
	 * @param codigoCompania
	 * @param plantillaOrdenCompraVO
	 * @throws SICException
	 */
	public void buscarColeccionesFiltrosPlantilla(Integer codigoCompania, PlantillaOrdenCompraVO plantillaOrdenCompraVO) throws SICException;

	/**
	 * @param plantillaOrdenCompraVO
	 * @param componentesMap
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<PedidoPlantillaDTO> buscarPlantilla(PlantillaOrdenCompraVO plantillaOrdenCompraVO, Map<String, Object> componentesMap, boolean ordenCompra, boolean filtroDia) throws SICException;

	/**
	 * @param pedidoPlantillaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoPlantillaDetalleDTO> obtenerDetallesPlantilla(PedidoPlantillaDTO pedidoPlantillaDTO) throws SICException;

	/**
	 * 
	 * @param plantillaOrdenCompraVO
	 * @param vistaProveedorDTO
	 * @return
	 * @throws SICException
	 */
	public AdminOrdenCompraVO obtenerAdminOrdenCompraVO(PlantillaOrdenCompraVO plantillaOrdenCompraVO, VistaProveedorDTO vistaProveedorDTO) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param datosValidados
	 * @return
	 * @throws SICException
	 */
	public AdminOrdenCompraVO obtenerAdminOrdenCompraVO(AdminOrdenCompraVO adminOrdenCompraVO, List datosValidados) throws SICException;

	/**
	 * 
	 * @param plantillaOrdenCompraVO
	 * @return
	 */
	public Collection<PedidoDTO> crearOrdenCompraDesdePlantilla(PlantillaOrdenCompraVO plantillaOrdenCompraVO) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param datosArchivoValidado
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoDTO> crearOrdenCompraDesdeArchivo(AdminOrdenCompraVO adminOrdenCompraVO, LinkedHashMap<String, List> datosArchivoValidado) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param datosArchivoValidado
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloImportadoVO> consultarNovedadesArticulosNuevosPorArchivo(AdminOrdenCompraVO adminOrdenCompraVO, LinkedHashMap<String, List> datosArchivoValidado) throws SICException;

	/**
	 * 
	 * @param ordenCompraDetalleEstadoDTO
	 * @param ordenCompraEstadoDTO
	 * @param cantidadAnterior
	 * @param pesoAnterior
	 * @param validarCantidades
	 * @throws SICException
	 */
	public void calculoValorTotalDetalle(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO, OrdenCompraEstadoDTO ordenCompraEstadoDTO, Integer cantidadAnterior, BigDecimal pesoAnterior, boolean validarCantidades) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void calcularTotalesNoAlmacenadosOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;

	/**
	 * 
	 * @param codigoCla
	 * @return
	 * @throws SICException
	 */
	public String validacionTipoClasificacion(StringBuffer codigoCla) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void crearNuevoDetalleArticuloOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;

	/**
	 * @param adminOrdenCompraVO
	 * @param componentesMap
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<PedidoDTO> buscarPedidos(PlanContingenciaOrdenCompraVO planContingenciaOrdenCompraVO, Map<String, Object> componentesMap) throws SICException;

	/**
	 * @param pedidoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraEstadoDTO> buscarOrdenesPedido(PedidoDTO pedidoDTO, boolean detallesOrdenesCompra) throws SICException;

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
	public SearchResultDTO<EmbarqueEstadoImpDTO> buscarEmbarques(AdminOrdenCompraRecepcionVO adminOrdenCompraRecepcionVO, Map<String, Object> componentesMap) throws SICException;

	/**
	 * @param embarqueSeleccionado
	 * @param validarEmbarque
	 * @param codigoBarrasValidados
	 * @param almacenarEmbarque
	 * @param codigosLineaComercialUsuario
	 * @return
	 * @throws SICException
	 */
	public Collection<FacturaEstadoImpDTO> buscarFacturasEmbarque(EmbarqueEstadoImpDTO embarqueSeleccionado, Boolean validarEmbarque, String[] codigoBarrasValidados, Boolean almacenarEmbarque, HashSet<String> codigosLineaComercialUsuario) throws SICException;

	/**
	 * @param adminOrdenCompraRecepcionVO
	 * @param embarquesSeleccionados
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoDTO> crearOrdenCompraDesdeEmbarque(AdminOrdenCompraRecepcionVO adminOrdenCompraRecepcionVO, Collection<EmbarqueEstadoImpDTO> embarquesSeleccionados) throws SICException;

	/**
	 * @param adminOrdenCompraRecepcionVO
	 * @param embarqueSeleccionado
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoDTO> crearOrdenCompraEmbarqueFacturas(AdminOrdenCompraRecepcionVO adminOrdenCompraRecepcionVO, EmbarqueEstadoImpDTO embarqueSeleccionado) throws SICException;

	/**
	 * @param pedidosCollection
	 * @throws SICException
	 */
	public void guardarArchivosGeneradosOrdenCompraEmbarque(Collection<PedidoDTO> pedidosCollection) throws SICException;

	/**
	 * @param ordenCompraCreacionVO
	 * @param embarquesSeleccionados
	 * @return
	 * @throws SICException
	 */
	public Collection<ValidacionOrdenCompraEmbarqueVO> procesarEmbarqueCreacionOrdenCompra(AdminOrdenCompraRecepcionVO ordenCompraRecepcionVO, Collection<EmbarqueEstadoImpDTO> embarquesSeleccionados) throws SICException;

	/**
	 * @param vistaProveedorDTO
	 * @param subBodegaDTO
	 * @param areaTrabajoDTO
	 * @param facturaEstadoImpDTO
	 * @param subbodegaCaracteristicaJuguetes
	 * @return
	 * @throws SICException
	 */
	public AdminOrdenCompraVO obtenerAdminOrdenCompraVO(AdminOrdenCompraRecepcionVO adminOrdenCompraRecepcionVO, VistaProveedorDTO vistaProveedorDTO, BodegaDTO subBodegaDTO, Integer codigoAreaTrabajo, boolean subbodegaCaracteristicaJuguetes) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public Boolean validarEsNotaPedido(AdminOrdenCompraVO adminOrdenCompraVO, boolean creacionPorArchivo) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public Collection<ArticuloImportadoVO> consultarNovedadesArticulosNuevos(Collection<ArticuloImportadoVO> artImpVoNueCol, boolean clasificacionValida) throws SICException;

	/**
	 * 
	 * @param ordenCompraDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraEstadoDTO> consultarEstadosOrdenCompra(OrdenCompraDTO ordenCompraDTO) throws SICException;

	/**
	 * @param codigoCompania
	 * @param planContingenciaOrdenCompraVO
	 * @throws SICException
	 */
	public void buscarColeccionesFiltrosPlanContingencia(Integer codigoCompania, PlanContingenciaOrdenCompraVO planContingenciaOrdenCompraVO) throws SICException;

	/**
	 * @param adminOrdenCompraVO
	 * @param ordenCompraEstadoDTOInicial
	 * @param accion
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDTO> modificarOrdenCompraNacional(AdminOrdenCompraVO adminOrdenCompraVO, OrdenCompraEstadoDTO ordenCompraEstadoDTOInicial) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param artImpVoNueCol
	 * @throws SICException
	 */

	public void crearDetallesArticulosNuevosOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, Collection<ArticuloDTO> articuloImportadoCreadosCol) throws SICException;

	/**
	 * 
	 * @param ordenCompraCreacionVO
	 * @throws SICException
	 */
	public void obtenerPlazoPago(AdminOrdenCompraVO ordenCompraCreacionVO) throws SICException;

	/**
	 * @param embarque
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraEstadoDTO> obtenerOrdenCompraPorEmbarque(EmbarqueEstadoImpDTO embarque) throws SICException;

	/**
	 * 
	 * @param ordenCompraVO
	 * @throws SICException
	 */
	public void buscarCostosEdicion(AdminOrdenCompraVO ordenCompraVO) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param anularAnterior
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDTO> crearOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, Boolean anularAnterior) throws SICException;

	/**
	 * 
	 * @param itemsOrdenCompraAsistida
	 * @throws SICException
	 */
	public void obtenerPrecios(AdminOrdenCompraVO ordenCompraCreacionVO, Collection<OrdenCompraDetalleEstadoDTO> itemsOrdenCompraAsistida) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param ordenCompraDetalleEstadoCol
	 * @throws SICException
	 */
	public void buscarInformacionEdicionArticulos(AdminOrdenCompraVO adminOrdenCompraVO, Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoCol) throws SICException;

	/**
	 * @param hojaInicial
	 * @throws SICException
	 */
	public void obtenerCabeceraArchivoOrdenCompra(HSSFWorkbook wb, HSSFSheet sheet, boolean notaPedido, boolean observacion) throws SICException;

	/**
	 * 
	 * @param areaTrabajoPedido
	 * @param subbodegaDTO
	 * @return
	 * @throws SICException
	 */
	public ProcesoRelacionAreaTrabajoDTO obtenerAreaTrabajoDestinoLocal(AreaTrabajoDTO areaTrabajoPedido, BodegaDTO subbodegaDTO) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param artUniManUsoCol
	 * @param casoDatos
	 * @param itemsOrdenCompra
	 * @param codArtCol
	 * @param codUniManOrdComDetEstCol
	 * @throws SICException
	 */
	public void obtenerInformacionAdicionalOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, ArrayList<ArticuloUnidadManejoProveedorDTO> artUniManProCol, Integer casoDatos, ArrayList<OrdenCompraDetalleEstadoDTO> itemsOrdenCompra, ArrayList<String> codArtCol, ArrayList<Long> codUniManOrdComDetEstCol) throws SICException;

	/**
	 * Crea un art�culo importado
	 * 
	 * @param articuloImportadoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> registrarArticuloImportado(Collection<ArticuloImportadoVO> articuloImportadoCol, VistaProveedorDTO vistaProveedorDTO) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void cambioMonedaOrigenPedido(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;

	/**
	 * @param pedidosAlmacenados
	 * @throws SICException
	 */
	public void crearOrdenCompraFacturas(Collection<PedidoDTO> pedidosAlmacenados) throws SICException;

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void obtenerCompradoresBodegasCreacionOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;

	/**
	 * Valida si se crea una orden de compra manual para juguetes en base a las
	 * lineas comerciales del usuario logueado
	 * 
	 * @param codigosReferenciaLineaComercialUsuario
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public boolean validarEsOrdenCompraJuguetes(Integer codigoCompania, HashSet<String> codigosReferenciaLineaComercialUsuario) throws SICException;

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
	 * Cierra un embarque de importaciones si ya se generaron ordenes de compra
	 * para todas sus facturas
	 * 
	 * @throws SICException
	 */
	public void cerrarEmbarqueImportaciones(Long codigoEmbarque) throws SICException;

	/**
	 * Metodo que busca descuentos
	 * 
	 * @param ordenCompraDetalleEstadoDescuentoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDetalleEstadoDescuentoDTO> buscarOrdenCompraDetalleEstadoDescuento(OrdenCompraDetalleEstadoDescuentoDTO ordenCompraDetalleEstadoDescuentoDTO) throws SICException;

	/**
	 * @param ordenCompraEstadoDTO
	 * @return
	 * @throws SICException
	 */
	public Boolean validarEstadoActualOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoDTO) throws SICException;

	/**
	 * Metodo para obtener las ordendes de compra en conflicto con las gestiones
	 * precios.
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	Collection<OrdenCompraGestionDTO> obtenerOrdenesCompraConflictos(Integer codigoCompania) throws SICException;

	/**
	 * Metodo para obtener los codigos de funcionario por los id's de usuario.
	 * 
	 * @param codigoCompania
	 * @param userIds
	 * @return
	 * @throws SICException
	 */
	Map<String, FuncionarioDTO> obtenerCodigosFuncionario(Integer codigoCompania, Set<String> userIds) throws SICException;

	/**
	 * Metodo para obtener las ordenes de compra por sus codigos de Orden compra
	 * 
	 * @param codigoCompania
	 * @param codigosOrdenCompra
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraEstadoDTO> obtenerOrdenesCompraPorCodigos(Integer codigoCompania, Set<String> codigosOrdenCompra) throws SICException;

	/**
	 * Metodo para obtener el adminOrdenCompraVO a partir de una
	 * ordenCompraEstadoDTO.
	 * 
	 * @param ordenCompraEstado
	 * @param codigoCompania
	 * @param userId
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	AdminOrdenCompraVO obtenerAdminOrdenCompraVO(OrdenCompraEstadoDTO ordenCompraEstado, Integer codigoCompania, String userId, FuncionarioDTO codigoFuncionario) throws SICException;

	/**
	 * Metodo que procesara la orden de compra segun la configuracion de cambio
	 * de precios.
	 * 
	 * @param ordenCompraGestionActual
	 * @param ordenCompraEstado
	 * @param codigoCompania
	 * @param funcionario
	 * @param userId
	 * @throws SICException
	 */
	void procesarOrdenCompraCambioPrecios(OrdenCompraGestionDTO ordenCompraGestionActual, OrdenCompraEstadoDTO ordenCompraEstado, Integer codigoCompania, FuncionarioDTO funcionario, String userId, Boolean parametroIntegracion) throws SICException;

	public Collection<SumatoriaUnidadManejoOrdenCompraVO> obtenerSumatoriaParaOrdenCompra(Collection<InterfacePedidoAreaTrabajoDTO> arrayList);

	public Collection<OrdenCompraDTO> crearOrdenCompraDesdePedidoAsistido(Collection<InterfacePedidoAreaTrabajoDTO> arrayList);

	public BodegaDTO buscarBodegaParaOrdenCompra(Integer codigoCompania, String codigoBodega);

	public AreaTrabajoDTO buscarAreaTrabajoParaOrdenCompra(Integer codigoCompania, String codigoAreaTrabajo);

	public FuncionarioDTO buscarFuncionarioParaOrdenCompra(Integer codigoCompania, String userId);

	/**
	 * Metodo que calcula el valor total bruto de los detalle de la orden de
	 * compra
	 * 
	 * @param ordenCompraDetalleEstadoDTOs
	 * @throws SICException
	 */
	public void calculoValorTotalBrutoDetalle(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) throws SICException;

	/**
	 * Obtiene todas las subbodegas que tenga el centro de distribucion
	 * determinado.
	 * 
	 * @param codigoCompania
	 * @param centroDistribucion
	 * @return Lista con las subbodegas que contenga el centro de distribuccion
	 */
	public Collection<AreaTrabajoDTO> obtenerAreaSublugarTrabajo(Integer codigoCompania, Integer centroDistribucion);

	/**
	 * Busca los centros de distribuciones que tenga permitido el funcionario,
	 * si el tipoBusqueda es true busca todos los centros de distribucion, de
	 * caso contrario busca el centro de distribucion 100
	 * 
	 * @param codigoCompania
	 *            Codigo de la compania
	 * @param codigoFuncionario
	 *            Codigo del funcionario.
	 * @param tipoBusqueda
	 *            <b>TRUE:</b> busca en todos los centro. <b>FALSE:</b> busca el
	 *            centro numero 100
	 * @return Coleccion con los centros de distribucion
	 */
	public Collection<AreaTrabajoDTO> buscarAreaTrabajoCentroDistribucion(int i, String codigoFuncionario, boolean tipoBusqueda);

	/**
	 * Busca la lista de proveedores dado los datos. Si <b>firstResult</b> y
	 * <b>maxResult</b> son nulos el metodo retorna una lista con todos los
	 * proveedores que cumplan con los otros parametros.
	 * 
	 * @param parametrosBusqueda Parametros de busqueda
	 * @param firstResult
	 *            Registro desde el cual se realizara la busqueda.
	 * @param maxResult
	 *            Cantidad de registros a buscar.
	 * @return Collecion de proveedores.
	 */
	public Collection<VistaProveedorDTO> buscarProveedorPorSubbodega(OrdenCompraContingenciaPedidoAsistidoVO parametrosBusqueda, Integer firstResult, Integer maxResult);

	public Collection<SumatoriaUnidadManejoOrdenCompraVO> buscarSumatoriasParaOrdenCompra(OrdenCompraContingenciaPedidoAsistidoVO parametros);

	public Collection<OrdenCompraDTO> crearOrdenCompraContingenciaPedidoAsistido(OrdenCompraContingenciaPedidoAsistidoVO parametros) throws SICException;

	public Collection<FacturaDTO> obtenerEntregasFacturaInternas(Long codigoOrdenCompra, Integer codigoCompania, String valorTipoOrdenCompra) throws SICException;

	public Collection<LineaComercialClienteImportacionDTO> obtenerLineaComercialCliente(Collection<Long> codigoLineaComercial);

	public Collection<BodegaDTO> obtenerSubbodegasPorFuncionarioComprador(String codigoFuncionario) throws SICException;

	public Collection<OrdenCompraDetalleEstadoDTO> consultarDetalleEstadoOriginal(Collection<Long> codigosUnidadManejo, Collection<String> codigosProveedor, Long codigoOrdenCompra, Integer codigoCompania);
	
	/**
	 * Obtiene un parametro del MAX
	 * @param codigoCompania
	 * @param codigoParametro
	 * @return
	 * @throws SICException
	 */
	public ParametroDTO obtenerParametroOrdenCompra(Integer codigoCompania, String codigoParametro) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraEstadoID
	 * @param url
	 * @return
	 * @throws SICException
	 */
	public byte[] generarDatosReporteOrdenesCompra(Collection<OrdenCompraEstadoID> ordenCompraEstadoID, String url,	Boolean planContingenicaB2B) throws SICException;

	/**
	 * Busca los códigos de barras de cada artículo en una orden de compra
	 * @param codigoCompania
	 * @param numeroOrdenCompra
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	public Collection<String> obtenerCodigoBarrasEtiquetado(Integer codigoCompania, String numeroOrdenCompra, String codigoFuncionario) throws SICException;
	/**
	 * 
	 * @param listadoIdsOrdenesCompra
	 * @param ordenCompraVO
	 * @param mapEmailArchivos
	 * @throws SICException
	 */
	public void obtenerEmailArchivosOrdenCompraTransaccional(ArrayList<OrdenCompraEstadoID> listadoIdsOrdenesCompra, AdminOrdenCompraVO ordenCompraVO, HashMap<String, List<String>> mapEmailArchivos) throws SICException;

	/**
	 * 
	 * @param listadoIdsOrdenesCompra
	 * @param ordenCompraVO
	 * @param tareaProgramadaDTO
	 * @param scheduler
	 * @return
	 * @throws SICException
	 */
	public HashMap<String, List<String>> obtenerEmailArchivosOrdenCompra(Collection<OrdenCompraEstadoID> listadoIdsOrdenesCompra, AdminOrdenCompraVO ordenCompraVO, TareaProgramadaDTO tareaProgramadaDTO, Scheduler scheduler) throws SICException;

	/**
	 * Edita de forma masiva un listado de ordenes de compra identificadas por su ID
	 * @param listadoIdsOrdenesCompra
	 * @param ordenCompraVO
	 */
	public Map<String, String> edicionMasivaOrdenesCompra(Collection<OrdenCompraEstadoID> listadoIdsOrdenesCompra, AdminOrdenCompraVO ordenCompraVO);
	
	/**
	 * Edita la cabecera de la orden de compra 
	 * @param listadoIdsOrdenesCompra
	 * @param ordenCompraVO
	 * @return OrdenCompraEstadoDTO
	 */
	public OrdenCompraEstadoDTO edicionCabeceraOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoDTO);
	
	/**
	 * Anula de forma masiva un listado de ordenes de compra identificadas por su ID
	 * @param listadoIdsOrdenesCompra
	 * @param userId
	 */
	public Map<String, String> anulacionMasivaOrdenesCompra(Collection<OrdenCompraEstadoID> listadoIdsOrdenesCompra, String userId);
	/**
	 * Busca ordens de compra por Id's
	 * @param listadoIdsOrdenesCompra
	 * @return
	 */
	public Collection<OrdenCompraEstadoDTO> buscarOrdenesCompraPorIds(Collection<OrdenCompraEstadoID> listadoIdsOrdenesCompra);
	
	/**
	 * Validar existencia de ordenes de compra pendientes validas
	 * @param codigoProveedor
	 * @param codigoCompania
	 * @param tipoPedido
	 * @param numeroOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public Boolean validarOrdenesCompraPendientes(String codigoProveedor, Integer codigoCompania, CatalogoValorDTO tipoPedido, String numeroOrdenCompra) throws SICException;

}