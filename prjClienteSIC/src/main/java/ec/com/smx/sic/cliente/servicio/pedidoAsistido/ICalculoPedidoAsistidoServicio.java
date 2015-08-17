/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.pedidoAsistido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.corpv2.dto.LocalDTO;
import ec.com.smx.corpv2.dto.ProcesoConfiguracionDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.pedidoAsistido.DiasConfiguracionPedidoAsistido;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.InterfacePedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.DatosBusquedaAreaTrabajoEST;
import ec.com.smx.sic.cliente.mdl.nopersistente.DatosBusquedaPedidoAsistidoWS;
import ec.com.smx.sic.cliente.mdl.vo.AuditoriaPorArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.ConfiguracionBloqueoPedidoVO;
import ec.com.smx.sic.cliente.mdl.vo.ConfiguracionPedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.ConsultaAnomaliaPedidoVO;
import ec.com.smx.sic.cliente.mdl.vo.EstructuraConfiguracionPedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.MonitoreoPedidoVO;
import ec.com.smx.sic.cliente.mdl.vo.PedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.PedidoFijoVO;

/**
 * @author jvillacis
 *
 */
public interface ICalculoPedidoAsistidoServicio extends Serializable {

	/**
	 * Obtiene los datos iniciales de las listas de subbodegas y centros de
	 * distribuci&oacute;n
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoUsuario
	 * @param codigoPerfil
	 * @param datosBusquedaAreaTrabajoEST
	 * @throws SICException
	 */
	public void obtenerDatosInicialesPedidoAsistido(Integer codigoCompania,
			String codigoFuncionario, String codigoUsuario, String codigoPerfil,
			DatosBusquedaAreaTrabajoEST datosBusquedaAreaTrabajoEST) throws SICException;

	/**
	 * 
	 * @param pedidoAsitidoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> obtenerItemsDetallePorClasificacion(PedidoAsistidoVO pedidoAsitidoVO) throws SICException;

	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @throws SICException
	 */
	public void obtenerDetalleArticulo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
	/**
	 * Obtener informaci&oacute;n adicional del art&iacute;culo
	 * 
	 * @param numeroCaso
	 * @param articuloUnidadManejoDTO
	 * @throws SICException
	 */
	public void obtenerInformacionAdicionalArticulo(Integer numeroCaso, ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;

	/**
	 * 
	 * @param pedidoAsitidoVO
	 * @param pedidoDetalleCol
	 * @throws SICException
	 */
	public void copiarValorSugeridoPedidoAsistido(PedidoAsistidoVO pedidoAsitidoVO, Collection<PedidoAreaTrabajoDetalleDTO> pedidoDetalleCol) throws SICException;

	/**
	 * 
	 * @param pedidoAsitidoVO
	 * @param pedidoDetalleCol
	 * @throws SICException
	 */
	public void limpiarValorSugeridoPedidoAsistido(PedidoAsistidoVO pedidoAsitidoVO, Collection<PedidoAreaTrabajoDetalleDTO> pedidoDetalleCol) throws SICException;

	/**
	 * 
	 * @param pedidoAsitidoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> buscarItemsFiltrosPedidoAsistido(PedidoAsistidoVO pedidoAsitidoVO) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoUsuario
	 * @param codigoPerfil
	 * @param datosBusquedaAreaTrabajoEST
	 * @throws SICException
	 */
	public void inicializarDatosBusquedaAreaTrabajo(Integer codigoCompania, String codigoFuncionario, String codigoUsuario, String codigoPerfil, DatosBusquedaAreaTrabajoEST datosBusquedaAreaTrabajoEST) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoPerfil
	 * @param cabecerasTablaConfiguracion
	 * @param diasConfiguracion
	 * @param tiposBloqueo
	 * @throws SICException
	 */
	public void inicializarConfiguracionPedidoAsistido(Integer codigoCompania, String codigoFuncionario, String codigoPerfil, 
			List<String> cabecerasTablaConfiguracion, Collection<DiasConfiguracionPedidoAsistido> diasConfiguracion,
			Collection<CatalogoValorDTO> tiposBloqueo) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoCalendario
	 * @param codigoAreaTrabajoConfiguracion
	 * @param codigoAreaTrabajoCalendarioPadre
	 * @param soloAreTraCalPro
	 * @return
	 * @throws SICException
	 */
	public AreaTrabajoCalendarioProcesoDTO buscarAreaTrabajoCalendarioProceso (Integer codigoCompania, Integer codigoAreaTrabajoCalendario, 
			Collection<Integer> codigosAreaTrabajoConfiguracion, Integer codigoAreaTrabajoCalendarioPadre, boolean soloAreTraCalPro, 
			boolean codigoProceso, Integer diaSemana, Collection<Long> codigosPedidoAreaTrabajoHijos) throws SICException;
	
	/**
	 * 
	 * @param configuracionPedidoAsistidoVO
	 * @throws SICException
	 */
	public void buscarConfiguracionAreaTrabajo(ConfiguracionPedidoAsistidoVO configuracionPedidoAsistidoVO) throws SICException;
	
	/**
	 * 
	 * @param configuracionPedidoAsistidoVO
	 * @param codigoDia
	 * @return
	 * @throws SICException
	 */
	public EstructuraConfiguracionPedidoAsistidoVO buscarConfiguracionDiaAreaTrabajo(ConfiguracionPedidoAsistidoVO configuracionPedidoAsistidoVO, Integer codigoDia) throws SICException;

	/**
	 * 
	 * @param codigoCentroDistribucion
	 * @param codigoAreaTrabajoSubbodega
	 * @param codigosAreaTrabajoSubbodega
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> obtenerAreaSubLugarTrabajo(Integer codigoCentroDistribucion, Integer codigoAreaTrabajoSubbodega, HashSet<Integer> codigosAreaTrabajoSubbodega, Integer codigoCompania) throws SICException;

	/**
	 * 
	 * @param monitoreoPedidoVO
	 * @throws SICException
	 */
	public void obtenerDatos(MonitoreoPedidoVO monitoreoPedidoVO) throws SICException;

	/**
	 * 
	 * @param monitoreoPedidoVO
	 * @param centroDistribucion
	 * @param fechaPedido
	 * @param subbodegas
	 * @param codigoEstadoCatalogoValor
	 * @param codigoEstadoCatalogoTipo
	 * @param local
	 * @throws SICException
	 */
	public void obtenerPedidosConBodega(MonitoreoPedidoVO monitoreoPedidoVO) throws SICException;
	
	/**
	 * 
	 * @param configuracionPedidoAsistidoVO
	 * @return
	 * @throws SICException
	 */
	public void buscarConfiguracionLocales(ConfiguracionPedidoAsistidoVO  configuracionPedidoAsistidoVO) throws SICException;


	public Collection<PedidoAreaTrabajoDTO> obtenerHijosPedidosSeleccionado(MonitoreoPedidoVO monitoreoPedidoVO)throws SICException ;

	/**
	 * Obtiene los pedidos area trabajo existentes.
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDTO> obtenerPedidoAreaTrabajoCreados(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * Obtener detalles pedido asistido
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void obtenerDetallesPedidoAsistido(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * Actualiza la informaci&oacute;n de detalles revisados en cada
	 * clasificaci&oacute;n
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void obtenerDetallesPedidoAsistidoCount(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * 
	 * @param monitoreoPedidoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> obtenerItemsDetallePorSubbodega(MonitoreoPedidoVO monitoreoPedidoVO) throws SICException;

	/**
	 * Obtener detalles pedido asistido de un detalle seleccionado
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void obtenerDetallesPedidoAsistidoRelacionados(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
	/**
	 * Obtener las relaciones entre un art&iacute;culo seleccionado y los relacionados
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void obtenerRelacionesArticuloRelacionado(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * B&uacute;squeda de art&iacute;culos desde el filtro de pedidos por art&iacute;culo
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void obtenerArticulosPedidoPorArticulo(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * Busca todos los deatalles activos de un pedido - pedido por art&iacute;culos
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	//public void busquedaDetallesPedidoPorArticulo(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * 
	 * @param pedidoAsistidoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoClasificacionDTO> obtenerClasificacionesPorUsuario(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
	/**
	 * 
	 * @param pedidosSeleccionados
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDTO> obtenerPedidoAreaTrabajoActualizado(Collection<PedidoAreaTrabajoDTO> pedidosSeleccionados, Long codigoPedidoAreaTrabajoHijo,  Boolean buscarHijos) throws SICException;
	
	/**
	 * 
	 * @param pedidoAreaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public PedidoAreaTrabajoDTO obtenerPedidoExistente(PedidoAreaTrabajoDTO pedidoAreaTrabajoDTO) throws SICException;
	
	/**
	 * 
	 * @param consultaAnomaliasPedidoVO
	 * @param codigoCompania
	 * @return
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> buscarAnomaliasPedido(ConsultaAnomaliaPedidoVO consultaAnomaliasPedidoVO, Integer codigoCompania);

	/**
	 * 
	 * @param consultaAnomaliasPedidoVO
	 * @return
	 */
	public List<PedidoAreaTrabajoDetalleDTO> buscarAnomaliasPedido(ConsultaAnomaliaPedidoVO consultaAnomaliasPedidoVO);

	/**
	 * 
	 * @param configuracion
	 * @return
	 */
	public Integer buscarCantidadAnomaliasPedido(ConsultaAnomaliaPedidoVO configuracion);
	
	/**
	 * 
	 * @param pedidoFijoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoPlantillaAreaTrabajoDTO> obtenerPedidosFijo(PedidoFijoVO pedidoFijoVO)throws SICException;
	
	/**
	 * 
	 * @param pedidoFijoVO
	 * @throws SICException
	 */
	public void obtenerArticulos(PedidoFijoVO pedidoFijoVO) throws SICException;
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public Collection<EstablecimientoDTO> obtenerFormatos( ) throws SICException;
	
	/**
	 * @param pUserId
	 * @return
	 * @throws SICException
	 */
	public UserDto obtenerInformacionUsuarioRegistro(String pUserId) throws SICException;
	
	/**
	 * 
	 * @param pedidoFijoVO
	 */
	public void obtenerLocales( PedidoFijoVO pedidoFijoVO);
	
	/**
	 * 
	 * @param configuracion
	 * @return
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> buscarAuditoriaPorArticulo (AuditoriaPorArticuloVO configuracion);

	/**
	 * 
	 * @param auditoriaPorArticuloVO
	 * @return
	 */
	public Integer buscarCantidadAuditoriaPorArticulo(AuditoriaPorArticuloVO auditoriaPorArticuloVO);
	
	/**
	 * 
	 * @param codigoCompania
	 * @param datosBusquedaAreaTrabajoEST
	 * @param estructuraConfiguracionPedidoAsistidoVOs
	 * @return
	 * @throws SICException
	 */
	public boolean obtenerConfiguracionSubbodega(Integer codigoCompania, DatosBusquedaAreaTrabajoEST datosBusquedaAreaTrabajoEST, 
			List<EstructuraConfiguracionPedidoAsistidoVO> estructuraConfiguracionPedidoAsistidoVOs) throws SICException;
	
	/**
	 * 
	 * @return
	 */
	public Collection<CatalogoValorDTO> buscarCatalogoValorDTO();
	
	/**
	 * Obtiene el estado operativo de un local enviado como par&aacute;rametro
	 * 
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public LocalDTO obtenerEstadoOperativoLocal(AreaTrabajoDTO areaTrabajoDTO) throws SICException;
	
	/**
	 * 
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<Integer> obtenerCDConfiguracionLocal(AreaTrabajoDTO areaTrabajoDTO) throws SICException;
	
	/**
	 * 
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerCDPorDefecto(AreaTrabajoDTO areaTrabajoDTO) throws SICException;
	
	/**
	 * 
	 * @param pedidoSeleccionado
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoEstadoDTO> obtenerEstadosPedidoSeleccionado(PedidoAreaTrabajoDTO pedidoSeleccionado)throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoSubbodega
	 * @return
	 * @throws SICException
	 */
	public String obtenerSubbodegaDeBodegaDTO(Integer codigoCompania, Integer codigoAreaTrabajoSubbodega) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param servidorDestino
	 * @return
	 * @throws SICException
	 */
	public ProcesoConfiguracionDTO obtenerProcesoConfiguracionInterface(Integer codigoCompania, boolean servidorDestino) throws SICException;
	
	/**
	 * 
	 * @param codigoLocal
	 * @param codigoPedidoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public String obtenerCantidadMaximaPorArticuloLocal(Integer codigoLocal,Long codigoPedidoAreaTrabajo) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoInterfacePedidoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public InterfacePedidoAreaTrabajoDTO obtenerInterfacePedidoAreaTrabajo(Integer codigoCompania, Long codigoInterfacePedidoAreaTrabajo) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<Long> obtenerInterfacesPedidoSinGenerarArchivo(Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoCD
	 * @param codigoAreaTrabajoSubbodega
	 * @param codigoAreaTrabajoPedido
	 * @param fechaPedido
	 * @param verificaOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public Collection<Long> obtenerInterfacesPedidoNormalDelDia(Integer codigoCompania, Integer codigoAreaTrabajoCD, Integer codigoAreaTrabajoSubbodega, 
			Integer codigoAreaTrabajoPedido, Date fechaPedido, boolean verificaOrdenCompra) throws SICException;

	/**
	 * Obtener c&oacute;digo de los proveedores activos del art&iacute;culo enviado como par&aacute;metro
	 * 
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloProveedorDTO> obtenerProveedorArticulo(String codigoArticulo) throws SICException;
	
	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @param resultDTO
	 * @throws SICException
	 */
	public void obtenerArticulosUnidadManejoCount(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, SearchResultDTO<ArticuloUnidadManejoDTO> resultDTO) throws SICException;
	
	public Double obtenerVolumenTotalPedido(Date fechaPedido, String codigoTipoPedido, Integer codigoLocal);
	
	public void buscarUsuariosConfiguracionNoPedidos(ArrayList<PedidoAreaTrabajoDTO> padres, 
			MonitoreoPedidoVO monitoreoPedidoVO, ArrayList<Integer> codigosSubbodegasEncontradas, 
			HashSet<AreaTrabajoDTO> subbodegaEncontradas, Integer casoDatos);
	
	public void buscarConfiguracionBloqueo(ConfiguracionBloqueoPedidoVO configuracionBloqueo) throws SICException;

	/**
	 * 
	 * @param frecuenciaRotacion
	 * @param codigoAreaTrabajoSB
	 * @param detallePedidoCol
	 * @throws SICException
	 */
	public void obtenerValoresRotacion(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
	/**
	 * 
	 * @param pedidoAsistidoVO
	 * @param codigoClasificacion
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> obtenerUnidadesDeManejoDetallePedido(PedidoAsistidoVO pedidoAsistidoVO, String codigoClasificacion, String codigoArticulo, Long codigoUnidadManejo) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoUsuario
	 * @param codigoPerfil
	 * @param datosBusquedaPedidoAsistidoWS
	 * @param areaTrabajoDTO
	 * @throws SICException
	 */
	public void inicializarDatosBusquedaAreaTrabajoWS(Integer codigoCompania, String codigoFuncionario, String codigoUsuario, String codigoPerfil, 
			DatosBusquedaPedidoAsistidoWS datosBusquedaPedidoAsistidoWS,AreaTrabajoDTO areaTrabajoDTO) throws SICException;
	
	/**
	 * 
	 * @param pedidoAsistidoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDTO> obtenerPedidoAreaTrabajoCreadosCriteria(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	public Collection<Map<String,Object>> obtenerCantidadMaximaPorArticuloLocalWS(Integer codigoLocal,Long codigoPedidoAreaTrabajo) throws SICException;
}
