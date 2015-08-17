package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.sql.Timestamp;
import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;

/**
 * 
 * Fecha 07-02-2013
 * 
 * @author acaiza
 * 
 */
public interface ICalculoRecepcionProveedorGestorScanner {

	
	/**
	 * Obtiene una lista de registros sanitarios
	 * @param articulo
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloRegistroSanitarioDTO> obtenerRelacionArticuloRegistroSanitario(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	/**
	 * Obtiene una coleccion de articulo unidad de manejo de una caja o un articulo
	 * 
	 * @param codigoBarras Codigo de barras del articulo
	 * @param codigoProveedor Codigo del proveedor
	 * @param esCaja Bandera para realizar la busqueda por codigo de barras unidad de manejo
	 * @param codigoCompania
	 * 
	 * @return Un Collection ArticuloUnidadManejoDTO
	 * 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<ArticuloUnidadManejoDTO> encuentraArticuloUnidadManejoPorCodigoCajaOArticulo(String codigoBarras, String codigoProveedor, Boolean esCaja, Integer codigoCompania) throws SICException;
	
	/**
	 * Obtiene las tareas pendientes del recibidor
	 * @param funcionarioSublugarTrabajoRelacionadoDTO
	 * @param funcionarioPerfilDTO
	 * @param fechaTarea
	 * @return
	 * @throws SICException
	 */
	Collection<TareaDTO> obtenerTareasPendienteRecibidor(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, Timestamp fechaTarea) throws SICException;

	
	/**
	 * Retorna TRUE si es un palet de recepcion
	 * @param palet Sin el identificador: A
	 * @param codigoBodega
	 * @return
	 * @throws SICException
	 */
	Boolean validarPalletRecepcion(String palet, Integer codigoBodega)throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoTipoControlCostos
	 * @return
	 * @throws SICException
	 */
	CatalogoValorRelacionadoDTO obtenerCatalogoValoRelacionado(Integer codigoCompania, String codigoTipoControlCostos)throws SICException;
	
	/**
	 * Consulta todos los datos de la tarea 
	 * @param codigoCompania
	 * @param codigoTarea
	 */
	TareaDTO consultarTarea(Integer codigoCompania, Long codigoTarea) throws SICException;
	/**
	 * Metodo para obtener los andenes asignados a la recepcion
	 * fallo de validacion
	 * @param codigoCompania
	 * @param codigoBodega
	 * @param valorTipoSeccion
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerListaCodigoDetalleSeccionIdentificador(Integer codigoCompania,Long codigoProcesoLogistico) throws SICException;
	
	/**
	 * Metodo para verificar si el anden existe en la bodega
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param Identificador
	 * @return
	 */
	DetalleSeccionDTO obtenerAndenPorBodega(Integer codigoCompania, Integer codigoAreaTrabajo, String identificador) throws SICException;
	
	/**
	 * <b>Obtener los datos resumidos de la orden de compra de la tabla(RecepionProveedorArticuloDTO)</b>
	 * <p>
	 * [Author: aecaiza, Date: 15/07/2015]
	 * </p>
	 * @param tareaRecepcion
	 * @return
	 */
	Collection<RecepcionProveedorArticuloDTO> obtenerDatosRecepionProveedorArticulo(Collection<ArticuloUnidadManejoDTO> listaArtUniMan,
			TareaDTO tareaRecepcion) throws SICException;

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
	 * <b>Obtener la informaci\u00F3n de los articulos de las ordenes de conpra
	 * de la recepci\u00F3n
	 * </b>
	 * <p>
	 * [Author: aecaiza, Date: 16/07/2015]
	 * </p>
	 * @param cantidaArticulosPedidos
	 * @param tareaSeleccionada
	 * @param listaRecepcionProveedorArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorArticuloDTO> obtenerDatosArticulos(TareaDTO tareaSeleccionada,
			Collection<RecepcionProveedorArticuloDTO> listaRecepcionProveedorArticulo) throws SICException;
	
}
