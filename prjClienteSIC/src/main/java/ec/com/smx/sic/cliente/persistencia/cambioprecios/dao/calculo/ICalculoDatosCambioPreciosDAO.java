package ec.com.smx.sic.cliente.persistencia.cambioprecios.dao.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.ArticuloPrecioInflacion;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.ArticuloProveedorInfo;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.ArticuloProveedorPrecioInflacion;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.ArticuloTipoRelacion;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.CambioPrecioFuncionario;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosArticuloExistente;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosEstablecimientoArticulo;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosLocalCiudadArticulo;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DetalleCambioPrecioFuncionario;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoGestionPrecio;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDinamicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.PrecioDiferenciadoArticuloGestionDTO;


/**
 * @author Luis Yacchirema
 *
 */
public interface ICalculoDatosCambioPreciosDAO extends Serializable {
	
	/**
	 * Consulta las gestiones precio filtradas por proveedor
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	Collection<CambioPrecioFuncionario> obtenerGestionesPorProveedor(Integer codigoCompania, String codigoFuncionario) throws SICException;
	
	/**
	 * Consulta las gestiones precio filtradas por plantilla
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	Collection<CambioPrecioFuncionario> obtenerGestionesPorPlantilla(Integer codigoCompania, String codigoFuncionario) throws SICException;
	
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
	 * @return
	 * @throws SICException
	 */
	List<String> obtenerCodigosArticulosVigentesEnCambioPrecios(Integer codigoCompania) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<DatosArticuloExistente> obtenerCodigosVigentesEnCambioPrecios(Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param codigocompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Set<String> obtenerCodigosArticulosRelacionados(Integer codigocompania, String codigoArticulo, String valorTipoRelacion) throws SICException;
	

	/**
	 * 
	 * @param codigoCompania
	 * @param codigosArticulos
	 * @param dynamicCriteriaGestionPrecio
	 * @return
	 * @throws SICException
	 */
	List<ArticuloTipoRelacion> obtenerCodigosArticulosQueTienenArticulosRelacionados(Integer codigoCompania, DynamicCriteriaRestriction dynamicCriteriaGestionPrecio) throws SICException;
	
	/**
	 * Metodo para obtener las caracteristicas dinamicas de acuerdo al codigo de clasificacion y tipo de las mismas
	 * @return
	 * @throws SICException
	 */
	Collection<CaracteristicaDinamicaDTO> obtenerCaracteristicasDinamicas(Integer codigoCompania, Set<String> codigosClasificacion, Integer codigoTipoCatalogo) throws SICException;
	
	/**
	 * Metodo para obtener los codigos de articulos que tienen precios diferenciados
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Set<String> obtenerCodigosArticulosQueTienenPreciosDiferenciados(Integer codigoCompania) throws SICException;
	
	/**
	 * Metodo para obtener los articulos Precios diferenciados de un o varios articulos
	 * @param codigoCompania
	 * @param codigosArticulos
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloPrecioDiferenciadoDTO> obtenerPreciosDiferenciadosPorCodigosArticulo(Integer codigoCompania, Set<String> codigosArticulos) throws SICException; 
	
	/**
	 * Metodo para obtener los Precios diferenciados en cambio de precios
	 * @param codigoCompania
	 * @param codigosGestionPrecio
	 * @param codigosArticulos
	 * @return
	 * @throws SICException
	 */
	Collection<PrecioDiferenciadoArticuloGestionDTO> obtenerPreciosDiferenciadosCambioPrecios(Integer codigoCompania, HashSet<Long> codigosGestionPrecio, HashSet<String> codigosArticulos) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoGestionPrecio
	 * @return
	 * @throws SICException
	 */
	DatosArticuloExistente obtenerDatosPreciosArticuloCambioPrecio(Integer codigoCompania, String codigoArticulo, Long codigoGestionPrecio) throws SICException;
	
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
	 * Metodo para obtener datos de la bodegas
	 * @param codigoCompania
	 * @param codigosBodega
	 * @return
	 * @throws SICException
	 */
	Collection<BodegaDTO> obtenerBodegasPorCodigo(Integer codigoCompania, Set<String> codigosBodega) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<PrecioDiferenciadoArticuloGestionDTO> obtenerPreciosDiferenciados(Integer codigoCompania, String codigoArticulo) throws SICException;
	
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
	 * Obtener las fechas de inicio y fin asignadas a un precio diferenciado
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoArticuloPrecioDiferenciado
	 * @param codigoLocal
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloLocalGestionPrecioDTO> obtenerPlanificacionesDePreciosDiferenciados(Integer codigoCompania, String codigoArticulo, Long codigoArticuloPrecioDiferenciado, Integer codigoLocal) throws SICException;

	Set<ArticuloPrecioInflacion> calcularInflacionArticulosVenta(Set<String> codigosArticulosConsultar);

	Set<ArticuloProveedorPrecioInflacion> calcularInflacionArticulosCosto(Set<ArticuloProveedorInfo> codigosArticulosProveedorConsultar);

}