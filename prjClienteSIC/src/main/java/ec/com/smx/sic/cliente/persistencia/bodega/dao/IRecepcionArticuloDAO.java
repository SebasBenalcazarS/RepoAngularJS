package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleDatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoTareaPerfilDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloTipoControlCostosDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoInformacionRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAsignacionArticuloUnidadManejoUbicacionDTO;


public interface IRecepcionArticuloDAO {

	/**
	 * 
	 * @param codigosUnidadManejo
	 * @param articuloUniManPro
	 * @return
	 * @throws SICException
	 */
	Collection<VistaArticuloUnidadManejoInformacionRecepcionDTO> obtenerInformacionArticulo(Collection<Long> codigosUnidadManejo, ArticuloUnidadManejoProveedorDTO articuloUniManPro)  throws SICException;
	
	/**
	 * 
	 * @param tareaRecepcion
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraDetalleEstadoDTO> obtenerDatosArticuloRecepcion(TareaDTO tareaRecepcion)  throws SICException;
	
	/**
	 * @param codigoAreaTrabajo
	 * @param verificarCantidadUbicada
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	 Collection<VistaAsignacionArticuloUnidadManejoUbicacionDTO> obtenerUbicacionesPorArticulo(Integer codigoAreaTrabajo, Boolean verificarCantidadUbicada, String codigoArticulo,
			Long codigoUnidadManejo, Integer codigoCompania) throws SICException;
	
	 /**
	 * Obtener el tipo de control de costos para los articulos
	 *
	 * @param codigosOrdenCompraDetalleEstados
	 * @param codigoCompania
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<VistaArticuloTipoControlCostosDTO> obtenerTipoControlCostosArticulo(Collection<Long> codigosOrdenCompraDetalleEstados, Integer codigoCompania) throws SICException;
	

	/**
	 * Obtener las clasificaciones de los articulos en la recepcion
	 * 
	 * @param listaDetalleOrdenCompra
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<ClasificacionDTO> buscarClasificacionesArticulosRecepcion(Collection<OrdenCompraDetalleEstadoDTO> listaDetalleOrdenCompra) throws SICException;


	/**
	 * Obtener el detalle de los articulos que se visualizan en la recepcion
	 * 
	 * @param listaDetalleOrdenCompra
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<VistaArticuloUnidadManejoDTO> obtenerDatosDetalleArticuloRecepcion(Collection<OrdenCompraDetalleEstadoDTO> listaDetalleOrdenCompra) throws SICException;

	/**
	 * Obtiene la cantidad y el peso que el proveedor ha planificado en la entrega desde el B2B
	 * @param tareaRecepcion
	 * @param articuloUnidadManejoDTOs
	 */
	@Deprecated
	OrdenCompraDetalleEstadoDTO obtenerCantidadPesoPlanificadaRecepcionPorArticulo(TareaDTO tareaRecepcion, Collection<ArticuloUnidadManejoDTO> articuloUnidadManejoDTOs) throws SICException;

	/**
	 * Obtiene la cantidad que se ha recibido del articulo en los pallets
	 * @param recepcion
	 * @param codigosOrdenCompraDetalleEstados
	 * @param tareaPerfilDTO
	 */
	Collection<DetalleDatosTareaDTO> obtenerCatidadRecibidaArticuloRecepcion(RecepcionProveedorDTO recepcion, Collection<Long> codigosOrdenCompraDetalleEstados, TipoTareaPerfilDTO tareaPerfilDTO) throws SICException;
	
	/**
	 * @param codigoBarrasUnidadManejo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloUnidadManejoDTO> verificarAsignacionUnidadManejoArticulo(String codigoBarrasUnidadManejo, Integer codigoCompania) throws SICException;
	

	/**
	 * Consulta la cantidad maxima que se almacena en un pallet
	 * 
	 * @param listaDetalleOrdenCompra
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<ArticuloUnidadManejoDTO> obtenerCantidaMaximaPalletPorArticulo(Collection<OrdenCompraDetalleEstadoDTO> listaDetalleOrdenCompra) throws SICException;

	/**
	 * obtiene el articulo que es de tipo pallet para la recepcion
	 * @param codigoBarrasArticuloPallet
	 * @param codigoCompania
	 */
	ArticuloDTO buscarArticuloPalletRecepcion(String codigoBarrasArticuloPallet, Integer codigoCompania) throws SICException;

	/**
	 * Obtiene la ubicacion para despacho de un articulo en la recepcion
	 * @param articuloDTO
	 */
	ArticuloProcesoLogisticoDTO obtenerUbicacionArticuloDespacho(ArticuloDTO articuloDTO) throws SICException;
	
	/**
	 * <b> Obtiene el porcentaje de recepcion adicional para una articulo<b>
	 * <p>
	 * [Author: lguaman, Date: 05/11/2014]
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoProveeedor
	 * @return
	 */
	Double obtenerValorPorcentajeAdicional(Integer codigoCompania, String codigoArticulo, String codigoProveeedor) throws SICException;
	
	/**
	 * Obtiene una coleccion de articulo unidad de manejo de una caja o un articulo
	 * @param codigoBarras
	 * @param codigoProveedor
	 * @param esCaja
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloUnidadManejoDTO> encuentraArticuloUnidadManejoPorCodigoCajaOArticulo(String codigoBarras, String codigoProveedor, Boolean esCaja, Integer codigoCompania) throws SICException;
	
	/**
	 * Obtiene el registro sanitario del articulo
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloRegistroSanitarioDTO> obtenerRegistroSanitario(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	/**
	 * <b>Obtener la cantida maxima por articulo de un pallet</b>
	 * *<p>
	 * [Author: aecaiza, Date: 15/07/2015]
	 * </p>
	 * @param recepcionProveedorArticuloDTO
	 * @return
	 */
	Integer obtenerCantidadMaximaPallet(RecepcionProveedorArticuloDTO recepcionProveedorArticuloDTO) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<String> obtenerArticulosSinFechaPrimeraEntrega(Integer codigoCompania, Collection<String> codigosArticulo) throws SICException;
	
	/**
	 * 
	 * @param codigoArticulo
	 * @param usuario
	 * @throws SICException
	 */
	void actualizarArticulosSinFechaPrimeraEntrega(String codigoArticulo, String usuario) throws SICException;
}