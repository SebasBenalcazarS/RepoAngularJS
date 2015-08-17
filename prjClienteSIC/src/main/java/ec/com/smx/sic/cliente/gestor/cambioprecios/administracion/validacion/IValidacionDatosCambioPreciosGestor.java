package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.validacion;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import com.google.gson.JsonObject;

import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosCalculoCambioPrecio;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosHistorialCambioPrecio;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosOrdenCompra;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.ProveedorReporteCambioPrecio;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.HistorialPrecioDiferenciadoArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.PrecioDiferenciadoArticuloGestionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;

/**
 * @author Luis Yacchirema
 *
 */
public interface IValidacionDatosCambioPreciosGestor extends Serializable {


	/**
	 * 
	 * Respalda el valor de las propiedades que el usuario puede modificar, para validar si se debe o no
	 * ejecutar actualizaciones de cambio de precios (solo se actualizaran los datos que se hayan modificado)
	 * 
	 * @param articulosCambioPrecios
	 * @throws SICException
	 */
	void respaldarDatosParaComprobarCambioPreciosOriginal(Collection<ArticuloGestionPrecioDTO> articulosCambioPrecios) throws SICException;

	/**
	 * Obtiene una gestion de precios tipo cambio de precios que tiene inicializado
	 * todas las relaciones necesarias para registrar un cambio de precios
	 * 
	 * @param codigoCompania
	 * @param tipoPlantilla
	 * @return
	 * @throws SICException
	 */
	GestionPrecioDTO generarGestionPrecioRegistro(Integer codigoCompania) throws SICException;

	/**
	 * Obtiene una plantilla validada para obtener los datos de los articulos para calcular
	 * los nuevos precios
	 * 
	 * @param codigoCompania
	 * @param esCreacionCambioPrecio
	 * @return
	 * @throws SICException
	 */
	ArticuloDTO generarPlantillaValidadaArticuloPrecio(Integer codigoCompania, Boolean esCreacionCambioPrecio) throws SICException;

	/**
	 * Verificar que el objeto ArticuloDTO que se recibe como parámetro tenga cargado todos los
	 * datos necesarios para calcular los nuevos precios, como: Articulo proveedor, tipos de precios,
	 * codigo de barras, entre otros 
	 * 
	 * @param articulo
	 * @return
	 * @throws SICException
	 */
	Boolean existenDatosRequeridosParaCalculoPreciosActuales(ArticuloDTO articulo) throws SICException;

	/**
	 * Obtiene una plantilla validada para obtener los datos de los articulos para calcular
	 * el costo nedto
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	ArticuloProveedorDTO generarPlantillaValidadaArticuloProveedorPrecio(Integer codigoCompania) throws SICException;


	/**
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	Boolean existenCambiosPreciosResolverPorFuncionario(Integer codigoCompania, String codigoFuncionario) throws SICException;


	/**
	 * @param articuloProveedorRelacionPrecio
	 * @return
	 * @throws SICException
	 */
	Boolean existenConflictosCambioPrecios(Collection<ArticuloGestionPrecioDTO> articuloGestionPrecio) throws SICException;


	/**
	 * Valida la fecha de vigencia para realizar un cambio de precio
	 * @param codigoCompania
	 * @param fechaSeleccionadaUnificada
	 * @param fechaSeleccionadaCosto
	 * @param fechaSeleccionadaPrecio
	 * @return
	 * @throws SICException
	 */
	Duplex<Boolean, Integer> validarFechaVigenciaCambioPrecios(Integer codigoCompania, Date fechaSeleccionadaUnificada, Date fechaSeleccionadaCosto, Date fechaSeleccionadaPrecio, Collection<ParametroDTO> listaParametros, Boolean esVenta) throws SICException;

	/**
	 * Valida la fecha de vigencia para realizar un cambio de precio
	 * @param codigoCompania
	 * @param fechaSeleccionadaUnificada
	 * @param fechaSeleccionadaCosto
	 * @param fechaSeleccionadaPrecio
	 * @param fechaRetornoPrecio
	 * @return
	 * @throws SICException
	 */
	Duplex<Boolean, Integer> validarFechaVigenciaRetornoPrecios(Integer codigoCompania, Date fechaSeleccionada, Date fechaRetornoPrecio, Boolean retornaCosto,  Collection<ParametroDTO> listaParametros) throws SICException;

	/**
	 * @param articulosGestionPrecios
	 * @param codigoTipoRelacion
	 * @return
	 * @throws SICException
	 */
	Set<String> ordenarGestionesPrecioPorTipoRelacion(Collection<ArticuloGestionPrecioDTO> articulosGestionPrecios, String codigoTipoRelacion) throws SICException;

	/**
	 * Recupera las ordenes de compra en conflicto relacionadas a los articulos enviados.
	 * @param articulosGestionPrecio
	 * @param datosCalculoCambioPrecio
	 * @throws SICException
	 */
	Collection<DatosOrdenCompra> obtenerConflictosConOrdenCompraCambioPrecio(Collection<ArticuloGestionPrecioDTO> articulosGestionPrecio, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException;

	/**
	 * Recupera las ordenes de compra en conflicto de los articulos pertenecientes a las clasificaciones enviadas.
	 * @param clasificaciones
	 * @param datosCalculoCambioPrecio
	 * @throws SICException
	 */
	Collection<DatosOrdenCompra> obtenerConflictosConOrdenCompraCondicionesComerciales(Collection<ProveedorClasificacionDTO> clasificaciones, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException;
	
	/**
	 * @param preciosDiferenciados
	 * @return
	 * @throws SICException
	 */
	Boolean existenConflictosPreciosDiferenciados(Collection<PrecioDiferenciadoArticuloGestionDTO> preciosDiferenciados) throws SICException;

	/**
	 * Validar si el parametro de integracion esta activo o no
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Boolean validarActivacionParametroIntegracionCambioPrecios(Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	public Collection<DatosOrdenCompra> obtenerConflictosConOrdenCompraArticuloProveedor(Integer codigoCompania , String codigoArticulo , String codigoProveedor) throws SICException;

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