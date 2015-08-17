package ec.com.smx.sic.cliente.gestor.pedidoAsistido.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.LocalDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ClasificacionArticuloCountTrasient;
import ec.com.smx.sic.cliente.mdl.nopersistente.DatosBusquedaAreaTrabajoEST;
import ec.com.smx.sic.cliente.mdl.nopersistente.DatosBusquedaPedidoAsistidoWS;
import ec.com.smx.sic.cliente.mdl.vo.PedidoAsistidoVO;

/**
 * 
 * @author amunoz
 *
 */
public interface IObtencionDatosAlmacenamientoPedidoAsistidoGestor extends Serializable {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoUsuario
	 * @param codigoPerfil
	 * @param datosBusquedaAreaTrabajoEST
	 * @throws SICException
	 */
	public void obtenerDatosInicialesPedidoAsistido(Integer codigoCompania,
			String codigoFuncionaio, String codigoUsuario, String codigoPerfil,
			DatosBusquedaAreaTrabajoEST datosBusquedaAreaTrabajoEST) throws SICException;
	
	/**
	 * Obtener detalles del pedido asistido creados a partir de los art&iacute;culos existentes por clasificaci&oacute;n
	 * 
	 * @param pedidoAsitidoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> obtenerItemsDetallePorClasificacion(PedidoAsistidoVO pedidoAsitidoVO) throws SICException;
	/**
	 * @param articuloUnidadManejoDTO
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void obtenerDetalleArticulo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	/**
	 * 
	 * @param pedidoAsitidoVO
	 * @throws SICException
	 */
	public void copiarValorSugeridoPedidoAsistido(PedidoAsistidoVO pedidoAsitidoVO, Collection<PedidoAreaTrabajoDetalleDTO> pedidoDetalleCol) throws SICException;
	/**
	 * 
	 * @param pedidoAsitidoVO
	 * @throws SICException
	 */
	public void limpiarValorSugeridoPedidoAsistido(PedidoAsistidoVO pedidoAsitidoVO, Collection<PedidoAreaTrabajoDetalleDTO> pedidoDetalleCol) throws SICException;
	
	/**
	 * Busca art&iacute;culos (detalles de pedido asistido) aplicando filtros de b&uacute;squeda. 
	 * 
	 * @param pedidoAsitidoVO
	 * @param todasClasificaciones
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> buscarItemsFiltrosPedidoAsistido(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
	/**
	 * Obtener todos los pedidos hijos asistidos existentes
	 * 
	 * @param pedidoAsitidoVO
	 * @throws SICException
	 * @author finga
	 */
	public Collection<PedidoAreaTrabajoDTO> obtenerPedidoAreaTrabajoCreados(PedidoAsistidoVO pedidoAsistidoVO)throws SICException;
	
	/**
	 * Obtener detalles pedido asistido
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void obtenerDetallesPedidoAsistido(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
	
	/**
	 * Actualiza la informaci&oacute;n de detalles revisados en cada clasificaci&oacute;n
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void obtenerDetallesPedidoAsistidoCount(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
	/**
	 *
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void obtenerDetallesPedidoAsistidoRelacionados(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
	/**
	 * Obtener el tipo de relaciones entre el art&iacute;culo seleccionado y los relacionados existentes
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void obtenerRelacionesArticuloRelacionado(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
	
	/**
	 * B&uacute;squeda de art&iacute;culos desde el filtro de pedidos por art&iacute;culo
	 * 
	 * @param parmetrosBusqueda
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
	 * Obtener clasificaciones por usuario
	 * 
	 * @param pedidoAsistidoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoClasificacionDTO> obtenerClasificacionesPorUsuario(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * Obtener valores de las rotaciones por art&iacute;culo
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void obtenerValoresRotacion(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;	

	/**
	 * Obtener clasificaciones por subbodega
	 * 
	 * @param pedidoAsistidoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<ClasificacionArticuloCountTrasient> obtenerClasificacionesPorSubbodega(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * Obtener las clasificaciones por pedido y usuario
	 * 
	 * @param pedidoAsistidoVO
	 * @return
	 */
	public Collection<PedidoAreaTrabajoClasificacionDTO> obtenerClasificacionesPedidoUsuario(PedidoAsistidoVO pedidoAsistidoVO);
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoClasificacion
	 * @param codigoAreaTrabajoPedido
	 * @param tipoAreaTrabajoValor
	 * @param codigoBodega
	 * @param codigoAreaTrabajoSubbodega
	 * @param codigoBodegaSubbodega
	 * @param articuloUnidadManejoDTO
	 * @throws SICException
	 */
	public void crearPlantillaBusquedaArticuloCreacion(Integer codigoCompania, String codigoClasificacion, Integer codigoAreaTrabajoPedido, String tipoAreaTrabajoValor,
			Integer codigoBodega, Integer codigoAreaTrabajoSubbodega, String codigoBodegaSubbodega, ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;
	
	/**
	 * Obtiener informaci&oacute;n adicional del art&iacute;culo 
	 * 
	 * @param numeroCaso
	 * @param articuloUnidadManejoDTO
	 * @throws SICException
	 */
	public void obtenerInformacionAdicionalArticulo(Integer numeroCaso, ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;
	
	/**
	 * Obtiene el estado operativo de un local enviado como par&aacute;rametro
	 * 
	 * @param parametrosConsulta
	 * @return
	 * @throws SICException
	 */
	public LocalDTO obtenerEstadoOperativoLocal(AreaTrabajoDTO areaTrabajoDTO) throws SICException;
	
	/**
	 * Obtiene lista con c&oacute;digos de &aacute;rea de trabajo de CD disponibles y activos para la configuraci&oacute;n de un local
	 * 
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<Integer> obtenerCDConfiguracionLocal(AreaTrabajoDTO areaTrabajoDTO) throws SICException;
	
	/**
	 * Obtiene el codigo de un CD por omisi&oacute;n
	 * 
	 * @param parametrosConsulta
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerCDPorDefecto(AreaTrabajoDTO areaTrabajoDTO) throws SICException;

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
	 * @param codigoAreaTrabajoPedido
	 * @param tipoAreaTrabajoValor
	 * @param codigoAreaTrabajoBodega
	 * @param codigoAreaTrabajoSubbodega
	 * @param codigoBodegaSubbodega
	 * @param codigosUnidadManejo
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> obtenerItemsDetalleParaPedidoFijo(Integer codigoCompania, Integer codigoAreaTrabajoPedido, String tipoAreaTrabajoValor, 
			Integer codigoAreaTrabajoBodega, Integer codigoAreaTrabajoSubbodega, String codigoBodegaSubbodega, Collection<Long> codigosUnidadManejo) throws SICException;
	
	/**
	 * @param codigoLocal
	 * @param codigoPedidoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public String obtenerCantidadMaximaPorArticuloLocal(Integer codigoLocal,Long codigoPedidoAreaTrabajo) throws SICException;
	
	/**
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

