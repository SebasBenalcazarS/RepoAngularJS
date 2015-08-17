/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.calculo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.CambioPrecioFuncionario;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosArticuloOrdenCompra;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosCalculoCambioPrecio;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosEstablecimientoArticulo;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosHistorialCambioPrecio;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosLocalCiudadArticulo;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DetalleCambioPrecioFuncionario;
import ec.com.smx.sic.cliente.common.cambioprecios.constantes.TipoBusquedaCambioPrecios;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoGestionPrecio;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoConflictoArticulo;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.PrecioDiferenciadoArticuloGestionDTO;

/**
 * @author Luis Yacchirema
 *
 */
public interface ICalculoDatosCambioPreciosGestor extends Serializable {

	/**
	 * @param codigoCompania
	 * @param plantillasBusquedasArticuloPrecios
	 * @return
	 * @throws SICException
	 */
	GestionPrecioDTO obtenerDatosArticulosGestionPrecio(Integer codigoCompania, String codigoFuncionario, Collection<ISearchTemplate> plantillasBusquedasArticuloPrecios) throws SICException;


	/**
	 * @param codigoCompania
	 * @param articulosPrecios
	 * @param esCreacionCambioPrecio
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloGestionPrecioDTO> generarDatosArticulosPreciosActuales(Integer codigoCompania, Collection<ArticuloDTO> articulosPrecios, Boolean esCreacionCambioPrecio) throws SICException;


	/**
	 * @param articuloGestionPrecio
	 * @throws SICException
	 */
	void establecerPreciosActualesArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio) throws SICException;

	/**
	 * Consulta las gestiones precio filtradas por proveedor o por plantilla
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
	Collection<ArticuloGestionPrecioDTO> obtenerDatosArticulosGestionPreciosPorFuncionario(Integer codigoCompania, String codigoFuncionario, String codigoProveedor, EstadoGestionPrecio estadoCambioPrecio, Date fechaVigenciaPrecios,Date fechaVigenciaCostos,Date fechaRetornoPrecio, Date fechaRetornoCosto, Long codigoGestionPrecioPlantilla, String userId) throws SICException;


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
	 * @param tipoConflictoArticulo
	 * @param datosCalculoCambioPrecio
	 * @throws SICException
	 */
	void calcularConflictosArticuloPorTipo(ArticuloGestionPrecioDTO articuloGestionPrecio, TipoConflictoArticulo tipoConflictoArticulo, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException;


	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<PrecioDiferenciadoArticuloGestionDTO> obtenerPreciosDiferenciados(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	/**
	 * Metodo que consulta los tipos de relaciones que poseen los articulos.
	 * @return
	 * @throws SICException
	 */
	Collection<CatalogoValorDTO> obtenerTiposRelacionesArticulo() throws SICException;


	/**
	 * Se obtiene los parametros de los rangos de fecha para sus espectivas validaciones
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<ParametroDTO> obtenerParametrosFechasVigencia(Integer codigoCompania) throws SICException;
	
	/**
	 * Funcion que busca los articulos pertenecientes a la orden de compra enviada.
	 * @param codigosOrdenCompra
	 * @param compania
	 * @param tipoConflicto
	 * @throws SICException
	 */
	Collection<DatosArticuloOrdenCompra> obtenerArticulosPorOrdenCompra(Set<Long> codigosOrdenCompra, Integer compania, TipoConflictoArticulo tipoConflicto) throws SICException;
	
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
	 * 
	 * @param articuloGestionPrecio
	 * @param preciosDiferenciados
	 * @param preciosDiferenciadosActuales
	 * @throws SICException
	 */
	void generarPreciosDiferenciadosPorSincronizar(ArticuloGestionPrecioDTO articuloGestionPrecio, Collection<ArticuloPrecioDiferenciadoDTO> preciosDiferenciados, Collection<PrecioDiferenciadoArticuloGestionDTO> preciosDiferenciadosActuales) throws SICException;

	/**
	 * Metodo para obtener datos de la bodegas
	 * @param codigoCompania
	 * @param codigosBodega
	 * @return
	 * @throws SICException
	 */
	Collection<BodegaDTO> obtenerBodegasPorCodigo(Integer codigoCompania, Set<String> codigosBodega) throws SICException;
	
	/**
	 * Obtener los establecimientos de un un articulo especifico
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
	 * Realiza el cálculo de la inflación de los artículos con la fecha interna
	 * 
	 * @param datosHistorial
	 */
	void calcularInflacionArticulos(Collection<DatosHistorialCambioPrecio> datosHistorial);
	
}
