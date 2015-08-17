/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.cambioprecios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import com.google.gson.JsonObject;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.CambioPrecioFuncionario;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosArticuloOrdenCompra;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosCalculoCambioPrecio;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosEstablecimientoArticulo;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosHistorialCambioPrecio;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosLocalCiudadArticulo;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosOrdenCompra;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DetalleCambioPrecioFuncionario;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.ProveedorReporteCambioPrecio;
import ec.com.smx.sic.cliente.common.cambioprecios.constantes.TipoBusquedaCambioPrecios;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoGestionPrecio;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoAfectacionCalculoPrecio;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoConflictoArticulo;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.GrupoAfectacionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.HistorialPrecioDiferenciadoArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.PrecioDiferenciadoArticuloGestionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoAfectacionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ValorAfectacionPrecioDTO;
/**
 * @author Luis Yacchirema
 * 
 */
public interface IAdministracionCambioPreciosServicio extends Serializable {

	/**
	 * @param codigoCompania
	 * @param codigoTipoAfectacion
	 * @return
	 * @throws SICException
	 */
	TipoAfectacionPrecioDTO obtenerTipoAfectacionPrecio(Integer codigoCompania, Integer codigoTipoAfectacion) throws SICException;


	/**
	 * @param codigoCompania
	 * @param tiposAfectacionNoVisualizar
	 * @return
	 * @throws SICException
	 */
	Collection<TipoAfectacionPrecioDTO> obtenerTiposAfectacionPrecios(Integer codigoCompania, Set<TipoAfectacionCalculoPrecio> tiposAfectacionNoVisualizar) throws SICException;


	/**
	 * @param grupoAfectacionPrecio
	 * @return
	 */
	GrupoAfectacionPrecioDTO obtenerValoresGrupoAfectacionPrecio(Long codigoGrupoAfectacionPrecio, Integer codigoCompania);


	/**
	 * @param codigoCompania
	 * @param plantillasBusquedasArticuloPrecios
	 * @return
	 * @throws SICException
	 */
	GestionPrecioDTO obtenerDatosArticulosGestionPrecio(Integer codigoCompania, String codigoFuncionario, Collection<ISearchTemplate> plantillasBusquedasArticuloPrecios) throws SICException;


	/**
	 * @param codigoTipoAfectacionPrecio
	 * @param articulosPrecios
	 * @param valoresAfectacionPrecios
	 * @throws SICException
	 */
	void calcularPreciosArticulosPorTipoAfectacion(Integer codigoTipoAfectacionPrecio, Collection<ArticuloGestionPrecioDTO> articulosPrecios, Collection<ValorAfectacionPrecioDTO> valoresAfectacionPrecios, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException;


	/**
	 * @param gestionPrecioRegistro
	 * @param ordenesAGestionar
	 * @throws SICException
	 */
	void registrarDatosGestionCambioPrecio(GestionPrecioDTO gestionPrecioRegistro, Collection<DatosOrdenCompra> ordenesAGestionar) throws SICException;
	
	
	/**
	 * @param articuloGestionPrecio
	 * @param columnaModificada
	 * @param columnaNula
	 * @throws SICException
	 */
	void calcularPreciosArticuloPorNuevaCondicion(ArticuloGestionPrecioDTO articuloGestionPrecio, String columnaModificada, String columnaNula) throws SICException;


	/**
	 * Consulta las gestiones de precios creados por proveedor o por plantillas
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param tipoBusquedaCambioPrecios
	 * @return
	 * @throws SICException
	 */
	Collection<CambioPrecioFuncionario> obtenerGestionesPorFuncionario(Integer codigoCompania, String codigoFuncionario, TipoBusquedaCambioPrecios tipoBusquedaCambioPrecios) throws SICException;


	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoProveedor
	 * @param codigoCambioPrecio
	 * @param estadoGestion
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleCambioPrecioFuncionario> obtenerGestionesPorUsuario(Integer codigoCompania, String codigoFuncionario, String codigoProveedor, 
			Long codigoCambioPrecio, String estadoGestion) throws SICException;


	/**
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public GestionPrecioDTO generarGestionPrecioRegistro(Integer codigoCompania) throws SICException;


	/**
	 * 
	 * @param codigoCompania
	 * @param codigosArticulos
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloProveedorDTO> obtenerProveedoresRelacionadosPorCodigosArticulos(Integer codigoCompania, Set<String> codigosArticulos) throws SICException;


	/**
	 * @param precioDiferenciadoArticulo
	 * @param articuloGestionPrecio
	 * @param columnaModificada
	 * @throws SICException
	 */
	void calcularPreciosPorPrecioDiferenciadoArticulo(PrecioDiferenciadoArticuloGestionDTO precioDiferenciadoArticulo, ArticuloGestionPrecioDTO articuloGestionPrecio, String columnaModificada) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoProveedor
	 * @param estadoCambioPrecio
	 * @param fechaVigenciaPrecios
	 * @param fechaVigenciaCostos
	 * @param fechaRetornoPrecio
	 * @param fechaRetornoCosto
	 * @param codigoGestionPrecioPlantilla
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloGestionPrecioDTO> obtenerDatosArticulosGestionPreciosPorFuncionario(Integer codigoCompania, String codigoFuncionario, String codigoProveedor, EstadoGestionPrecio estadoCambioPrecio, Date fechaVigenciaPrecios,Date fechaVigenciaCostos, Date fechaRetornoPrecio, Date fechaRetornoCosto, Long codigoGestionPrecioPlantilla, String userId) throws SICException;


	/**
	 * Consulta los cambios de precio y/o historial
	 * @param codigoCompania	
	 * @param codigoFuncionario
	 * @return Collection<ISearchTemplate> plantilla de filtros de bsuqueda
	 * @throws SICException
	 */
	<T extends SearchDTO> Duplex<Collection<T>, Long> obtenerBusquedaCambioPreciosPaginado(Integer codigoCompania, String codigoFuncionario, ArrayList<ISearchTemplate> filtrosBusqueda,Integer firstResult,Integer maxResult, Boolean countAgain, Boolean esPaginado, Boolean mostrarProcesados, TipoBusquedaCambioPrecios tipoCambioPrecios) throws SICException;


	/**
	 * Consulta los cambios de precio y/o historial para exportar a excel
	 * @param codigoCompania	
	 * @param codigoFuncionario
	 * @return Collection<ISearchTemplate> plantilla de filtros de bsuqueda
	 * @throws SICException
	 */
	<T extends SearchDTO> Collection<T> obtenerBusquedaCambioPrecios(Integer codigoCompania, String codigoFuncionario, Boolean incluirPreciosDif, ArrayList<ISearchTemplate> filtrosBusqueda, TipoBusquedaCambioPrecios tipoCambioPrecios) throws SICException;


	/**
	 * 
	 * @param articuloGestionPrecio
	 * @param costoBruto
	 * @param codigoProveedorRelacionado
	 * @param unificarCostosProveedores
	 * @throws SICException
	 */
	void calcularPreciosPorProveedorRelacionado(ArticuloGestionPrecioDTO articuloGestionPrecio, Double costoBruto, String codigoProveedorRelacionado, Boolean unificarCostosProveedores) throws SICException;


	/**
	 * Metodo que busca y agrupa las gestiones segun los articulos que tengan relacion.
	 * @param articulosGestionPrecios
	 * @param codigocompania
	 * @param codigoArticulo
	 * @param valorTipoRelacion
	 * @return
	 * @throws SICException
	 */
	Duplex<Set<String>, Collection<ArticuloGestionPrecioDTO>> agruparArticulosRelacionadosPorArticuloPadre(Collection<ArticuloGestionPrecioDTO> articulosGestionPrecios, Integer codigocompania, String codigoArticulo, String valorTipoRelacion) throws SICException;	


	/**
	 * 
	 * @param articuloGestionPrecio
	 * @param datosCalculoCambioPrecio
	 * @return
	 * @throws SICException
	 */
	Collection<TipoConflictoArticulo> generarTiposConflictosArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException;


	/**
	 * @param articuloGestionPrecio
	 * @param tipoConflictoArticulo
	 * @throws SICException
	 */
	void calcularConflictosArticuloPorTipo(ArticuloGestionPrecioDTO articuloGestionPrecio, TipoConflictoArticulo tipoConflictoArticulo, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException;


	/**
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	Boolean existenCambiosPreciosResolverPorFuncionario(Integer codigoCompania, String codigoFuncionario)throws SICException;


	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param costoNeto para elcalculo de margen 
	 * @return
	 * @throws SICException
	 */
	Collection<PrecioDiferenciadoArticuloGestionDTO> obtenerPreciosDiferenciados(Integer codigoCompania, String codigoArticulo) throws SICException;

	/**
	 * @param articuloProveedorRelacionPrecio
	 * @return
	 * @throws SICException
	 */
	Boolean existenConflictosCambioPrecios(Collection<ArticuloGestionPrecioDTO> articuloGestionPrecio) throws SICException;


	/**
	 * Valida la fecha de vigencia para realizar un cambio de precio
	 * @param codigoCompania
	 * @param value
	 * @return
	 * @throws SICException
	 */
	Duplex<Boolean, Integer> validarFechaVigenciaCambioPrecios(Integer codigoCompania, Date fechaSeleccionadaUnificada, Date fechaSeleccionadaCosto, Date fechaSeleccionadaPrecio, Collection<ParametroDTO> listaParametros, Boolean esVenta) throws SICException;

	/**
	 * Valida la fecha de vigencia para realizar un cambio de precio
	 * @param codigoCompania
	 * @param value
	 * @return
	 * @throws SICException
	 */
	Duplex<Boolean, Integer> validarFechaVigenciaRetornoPrecios(Integer codigoCompania, Date fechaSeleccionada, Date fechaRetornoPrecio, Boolean retornaCosto, Collection<ParametroDTO> listaParametros) throws SICException;


	/**
	 * Metodo que consulta los tipos de relaciones que poseen los articulos.
	 * @return
	 * @throws SICException
	 */
	Collection<CatalogoValorDTO> obtenerTiposRelacionesArticulo() throws SICException;

	/**
	 * Metodo que obtiene los parametros de los rangos de las fechas de vigencia
	 * @return
	 * @throws SICException
	 */
	Collection<ParametroDTO> obtenerParametrosFechasVigencia(Integer codigoCompania) throws SICException;


	/**
	 * Ordena la lista de gestiones recibida y devuelve los codigos de articulos de las gestiones que
	 * fueron ordenadas por su relacion.
	 * @param articulosGestionPrecios
	 * @param codigoTipoRelacion
	 * @return
	 * @throws SICException
	 */
	Set<String> ordenarGestionesPrecioPorTipoRelacion(Collection<ArticuloGestionPrecioDTO> articulosGestionPrecios, String codigoTipoRelacion) throws SICException;

	/**
	 * Funcion que calcula los precios en los articulos relacionados recibidos.
	 * @param gestionesPreciosRelacioandas
	 * @param nuevoPrecio
	 * @param columnaModificada
	 * @throws SICException
	 */
	void calcularGestionesPreciosRelacionados(Collection<ArticuloGestionPrecioDTO> gestionesPreciosRelacioandas, Double nuevoPrecio, String columnaModificada) throws SICException;


	/**
	 * @param codigoCompania
	 * @param articulosPrecios
	 * @param esCreacionCambioPrecio
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloGestionPrecioDTO> generarDatosArticulosPreciosActuales(Integer codigoCompania, Collection<ArticuloDTO> articulosPrecios, Boolean esCreacionCambioPrecio) throws SICException;


	/**
	 * @param articulosGestionPrecioActuales
	 * @param estadoCambioPrecioNuevo
	 * @param userId
	 * @param fechaVigenciaCosto
	 * @param fechaRetornoCosto
	 * @param fechaVigenciaVenta
	 * @param fechaRetornoVenta
	 * @param codigoCompania
	 * @param ordenesAGestionar
	 * @throws SICException
	 */
	void actualizarArticulosCambioPrecios(Collection<ArticuloGestionPrecioDTO> articulosGestionPrecioActuales,
			EstadoGestionPrecio estadoCambioPrecioNuevo, String userId,
			Date fechaVigenciaCosto, Date fechaRetornoCosto, Date fechaVigenciaVenta, Date fechaRetornoVenta,
			Integer codigoCompania, Collection<DatosOrdenCompra> ordenesAGestionar) throws SICException;


	/**
	 * @param articuloGestionPrecio
	 * @param tipoConflictoArticulo
	 * @return
	 * @throws SICException
	 */
	void validarConflictoArticuloPorTipo(ArticuloGestionPrecioDTO articuloGestionPrecio, TipoConflictoArticulo tipoConflictoArticulo) throws SICException;


	/**
	 * Funcion que busca y calcula los precios de los proveedores relacionados de un articuloGestionPrecio.
	 * @param articuloGestionPrecio
	 * @throws SICException
	 */
	void calcularPreciosProveedoresRelacionadosPorArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio) throws SICException;

	/**
	 * Funcion que busca los articulos pertenecientes a la orden de compra enviada.
	 * @param codigosOrdenCompra
	 * @param compania
	 * @param tipoConflicto
	 * @throws SICException
	 */
	Collection<DatosArticuloOrdenCompra> obtenerArticulosPorOrdenCompra(Set<Long> codigosOrdenCompra, Integer compania, TipoConflictoArticulo tipoConflicto) throws SICException;

	/**
	 * Recupera las ordenes de compra en conflicto relacionadas a los articulos enviados.
	 * @param articulosGestionPrecio
	 * @param datosCalculoCambioPrecio
	 * @throws SICException
	 */
	Collection<DatosOrdenCompra> obtenerConflictosConOrdenCompraCambioPrecio(Collection<ArticuloGestionPrecioDTO> articulosGestionPrecio, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoGestionPrecio
	 * @param porcentajeNoAfiliado
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	ArticuloGestionPrecioDTO obtenerDatosPreciosArticuloCambioPrecio(Integer codigoCompania, String codigoArticulo, Long codigoGestionPrecio, Double porcentajeNoAfiliado, String userId) throws SICException;
	
	/**
	 * @param precioBase
	 * @param articuloComercial
	 * @return
	 */
	Double calcularPrecioBaseNoAfiliado(Double precioBase, ArticuloComercialDTO articuloComercial);
	
	/**
	 * 
	 * @param articuloGestionPrecio
	 * @param preciosDiferenciados
	 * @param preciosDiferenciadosActuales
	 * @throws SICException
	 */
	void generarPreciosDiferenciadosPorSincronizar(ArticuloGestionPrecioDTO articuloGestionPrecio, Collection<ArticuloPrecioDiferenciadoDTO> preciosDiferenciados, Collection<PrecioDiferenciadoArticuloGestionDTO> preciosDiferenciadosActuales) throws SICException;
	
	/**
	 * @param preciosDiferenciados
	 * @return
	 * @throws SICException
	 */
	Boolean existenConflictosPreciosDiferenciados(Collection<PrecioDiferenciadoArticuloGestionDTO> preciosDiferenciados) throws SICException;
	
	/**
	 * Metodo para obtener datos de la bodegas
	 * @param codigoCompania
	 * @param codigosBodega
	 * @return
	 * @throws SICException
	 */
	Collection<BodegaDTO> obtenerBodegasPorCodigo(Integer codigoCompania, Set<String> codigosBodega) throws SICException;
	
	/**
	 * Obtener los establecimientos de un articulo especifico
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoArticuloPrecioDiferenciado
	 * @return
	 * @throws SICException
	 */
	Collection<DatosEstablecimientoArticulo> obtenerEstablecimientosArticulos(Integer codigoCompania, String codigoArticulo, Long codigoArticuloPrecioDiferenciado) throws SICException;

	/**
	 * Obtener los locales con sus ciudades de un establecimiento y un articulo especifico
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoArticuloPrecioDiferenciado
	 * @param codigoEstablecimiento
	 * @return
	 * @throws SICException
	 */
	Collection<DatosLocalCiudadArticulo> obtenerLocalesCiudadesArticulos(Integer codigoCompania, String codigoArticulo, Long codigoArticuloPrecioDiferenciado, Integer codigoEstablecimiento) throws SICException;
	
	/**
	 * Obtener las fechas de inicio y fin de los locales asignados a un precio diferenciado
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoArticuloPrecioDiferenciado
	 * @param codigoLocal
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloLocalGestionPrecioDTO> obtenerPlanificacionesDePreciosDiferenciados(Integer codigoCompania, String codigoArticulo, Long codigoArticuloPrecioDiferenciado, Integer codigoLocal) throws SICException;
	
	/**
	 * Recupera las ordenes de compra en conflicto de los articulos pertenecientes a las clasificaciones enviadas.
	 * @param clasificaciones
	 * @param datosCalculoCambioPrecio
	 * @throws SICException
	 */
	Collection<DatosOrdenCompra> obtenerConflictosConOrdenCompraCondicionesComerciales(Collection<ProveedorClasificacionDTO> clasificaciones, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException;
	
	/**
	 * obtiene las ordenes de compra pertenecientes a un articulo proveedor
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	public Collection<DatosOrdenCompra> obtenerConflictosConOrdenCompraArticuloProveedor(Integer codigoCompania , String codigoArticulo , String codigoProveedor) throws SICException;

	/**
	 * 
	 * @param datosCompletos
	 */
	void calcularInflacionArticulos(Collection<DatosHistorialCambioPrecio> datosCompletos);

	/**
	 * 
	 * @param hashMap
	 * @return
	 */
	JsonObject convertirJson(TreeMap<ProveedorReporteCambioPrecio, TreeMap<DatosHistorialCambioPrecio, List<HistorialPrecioDiferenciadoArticuloDTO>>> treeMap);

	/**
	 * 
	 * @param datos
	 * @return
	 */
	TreeMap<ProveedorReporteCambioPrecio, TreeMap<DatosHistorialCambioPrecio, List<HistorialPrecioDiferenciadoArticuloDTO>>> convertirEnTreeMap(Collection<DatosHistorialCambioPrecio> datos);

	/**
	 * 
	 * @param data
	 * @return
	 */
	Collection<DatosHistorialCambioPrecio> convertirFormato(Collection<ArticuloProveedorGestionPrecioDTO> data);
}
