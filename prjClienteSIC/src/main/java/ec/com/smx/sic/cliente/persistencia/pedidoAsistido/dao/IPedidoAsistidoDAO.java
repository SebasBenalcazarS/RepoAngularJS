package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.dao;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

import ec.com.smx.autorizaciones.dto.AutorizacionDTO;
import ec.com.smx.corpv2.dto.LocalDTO;
import ec.com.smx.corpv2.dto.ProcesoCatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGarantiaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMaterialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloGarantiaID;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAnomaliaTrasient;
import ec.com.smx.sic.cliente.mdl.nopersistente.ClasificacionArticuloCountTrasient;

public interface IPedidoAsistidoDAO {
	/**
	 * 
	 * @param parametrosConsulta
	 * @return
	 */
	public Collection<ClasificacionArticuloCountTrasient> obtenerNumeroDeArticulosPorClasificacion(LinkedHashMap<String, Object> parametrosConsulta);
	
	/**
	 * Obtener autorizaci&oacute;nes para validar valores 
	 * 
	 * @param parametrosConsulta
	 * @return
	 * @throws SICException
	 */
	public Collection<AutorizacionDTO> obtenerAutorizacionPedidoAsistido(HashMap<String, Object> parametrosConsulta) throws SICException;
	
	/**
	 * Obtiene los detalles del &uacute;ltimo pedido realizado para validar anomal&iacute;as en los detalles
	 *  
	 * @param parametrosConsulta
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloAnomaliaTrasient> obtenerPedidoAnterior(HashMap<String, Object> parametrosConsulta) throws SICException;
	
	/**
	 * Obtiene local de una area de trabajo 
	 * 
	 * @param parametrosConsulta
	 * @return
	 * @throws SICException
	 */
	public LocalDTO obtenerEstadoOperativoLocal(HashMap<String, Object> parametrosConsulta) throws SICException;
	
	/**
	 * Obtiene lista con c&oacute;digos de &aacute;rea de trabajo de CD disponibles y activos para la configuraci&oacute;n de un local
	 * 
	 * @param parametrosConsulta
	 * @return
	 * @throws SICException
	 */
	public Collection<Integer> obtenerCDConfiguracionLocal(HashMap<String, Object> parametrosConsulta) throws SICException;
	
	/**
	 * Obtiene el CD por defecto de un local
	 * 
	 * @param parametrosConsulta
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerCDPorDefecto(HashMap<String, Object> parametrosConsulta) throws SICException;
	
	/**
	 * 
	 * 
	 * @param articuloDefinicionArchivoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDefinicionArchivoDTO> obtenerArticuloArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO) throws SICException;
	
	/**
	 * 
	 * 
	 * @param articuloMaterialDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloMaterialDTO> obtenerArticuloMaterial(ArticuloMaterialDTO articuloMaterialDTO) throws SICException;
	
	/**
	 * 
	 * 
	 * @param articuloProveedorDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloProveedorDTO> obtenerArticuloProveedor(ArticuloProveedorDTO articuloProveedorDTO) throws SICException;
	
	/**
	 * 
	 * 
	 * @param clasificacionDTO
	 * @return
	 * @throws SICException
	 */
	public ClasificacionDTO obtenerArticuloClasificacion (ClasificacionDTO clasificacionDTO) throws SICException;
	
	/**
	 * Obtener la informaci&oacute;n de la subclasificaci&oacute;n de un art&iacute;culo
	 * 
	 * @param codigoClasificacion
	 * @param codigoSubclasificacion
	 * @return
	 * @throws SICException
	 */
	public SubClasificacionDTO obtenerSubclasificacionArticulo(String codigoClasificacion, String codigoSubclasificacion)throws SICException;
	
	/**
	 * Obtener art&iacuteculos relacionados
	 * 
	 * @param codigoArticuloCol
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloRelacionDTO> obtenerArticulosRelacionados(Collection<String> codigoArticuloCol, Integer codigoCompania,Collection<String> valorTipoRelacionCol) throws SICException;
	
	/**
	 * Obtener tipo de relaci&oacute;n en los art&iacute;culos relacionados
	 * 
	 * @return
	 * @throws SICException
	 */
	public Collection<ProcesoCatalogoValorDTO> obtenerTipoRelacionArticuloRelacionado() throws SICException;
	
	
	/**
	 * Obtener art&iacute;culo garantia
	 * 
	 * @param articuloGarantiaID
	 * @return
	 * @throws SICException
	 */
	public ArticuloGarantiaDTO obtenerArticuloGarantia(ArticuloGarantiaID articuloGarantiaID) throws SICException;

	/**
	 * Obtener pedido con sus detalles en standBy
	 * 
	 * @param codigoPedidoAreaTrabajo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public PedidoAreaTrabajoDTO obtenerArticulosStandBy(Long codigoPedidoAreaTrabajo,Integer codigoCompania) throws SICException;
	
	/**
	 * Obtener caracter&iacute;sticas del un art&iacute;culo
	 * 
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public Collection<CaracteristicaDTO> obtenerArticuloCaracteristica(String codigoArticulo) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoPedidoAreaTrabajo
	 * @param codigosArticulo
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> obtenerDetallesPedidoConsolidadoPorArticulo(Integer codigoCompania, Long codigoPedidoAreaTrabajo, 
			Collection<String> codigosArticulo) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param fechaPedido
	 * @param codigoCD
	 * @param codigoSubbodega
	 * @param codigosLocales
	 * @return
	 * @throws SICException
	 */
	public Collection<Integer> obtenerLocalesConPedidoDelDia(Integer codigoCompania, Date fechaPedido, Integer codigoCD, Integer codigoSubbodega, 
			Collection<Integer> codigosLocales) throws SICException;
	
	/**
	 * Obtener cantidad m&aacute;xima de art&iacute;culo por local
	 * 
	 * @param codigoLocal
	 * @return lista de <code>ArticuloLocalPedidoDTO</code> con los art&iacute;culos encontrados
	 * @throws SICException
	 */
	public Collection<ArticuloLocalPedidoDTO> obtenerCantidadMaximaPorArticuloLocal(Integer codigoLocal) throws SICException;
	
	/**
	 * Obtener detalles del pedido para verificar cantidad m&aacute;xima por local
	 * 
	 * @param codigoPedidoAreaTrabajo
	 * @param codigoArticuloCol
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> obtenerDetallesPedidoCantidadMaxima(Long codigoPedidoAreaTrabajo, 
			Collection<String> codigoArticuloCol) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param codigosPedidoAreaTrabajoEstado
	 * @param codigosPedidoAreaTrabajo
	 * @throws SICException
	 */
	public void finalizarPedidosAreaTrabajoEstado(Integer codigoCompania, String userId, Collection<Long> codigosPedidoAreaTrabajoEstado, 
			Collection<Long> codigosPedidoAreaTrabajo) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigosPedidoConsolidado
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoEstadoDTO> obtenerPedidosUsuariosPorPedidosConsolidados(Integer codigoCompania, Collection<Long> codigosPedidoConsolidado) throws SICException;
	
	/**
	 * Obtener arreglo de c&oacute;digo de proveedores del art&iacute;culo enviado como par&aacut;metro
	 * 
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloProveedorDTO> obtenerProveedorArticulo(String codigoArticulo) throws SICException;
	
	/**
	 * Obtener detalles del pedido padre
	 * 
	 * @param pCodigoPedidoAreaTrabajo
	 * @param codigoUnidadManejoCol
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> obtenerDetallesPedidoPadre(Long pCodigoPedidoAreaTrabajo, Collection<Long> codigoUnidadManejoCol) throws SICException;
	
	/**
	 * Obtener art&iacute;culos unidad de manejo por c&oacute;digo de art&iacute;culo ingresado como par&aacute;metro 
	 * 
	 * @param codigoArticuloCol
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoDTO> obtenerUnidadesDeManejoArticulo(Collection<String> codigoArticuloCol, Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoCD
	 * @param codigoSubbodega
	 * @param fechaPedido
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDTO> obtenerPedidoDia(Integer codigoCompania, Integer codigoCD ,
			Integer codigoSubbodega, Integer local, Date fechaPedido) throws SICException;
}
