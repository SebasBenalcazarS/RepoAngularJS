/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.bodega;

import java.util.Collection;

import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaBusquedaEdicionMasivaArticulos;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaDatosLogisticosVO;

/**
 * @author jdvasquez
 *
 */
public interface IEdicionDatosExtraServicio {

	/**
	 * Obtiene la cantidad de articulos resultantes de la busqueda luego de aplicar los filtros ingresados en la vista
	 * @param plantillaBusquedaArticulos
	 * @return
	 * @throws SICException
	 */
	public Long obtenerCantidadArticulosBuscar(IPlantillaBusquedaEdicionMasivaArticulos plantillaBusquedaArticulos) throws SICException;

	/**
	 * Obtiene una lista de articulos resultantes de la busqueda luego de aplicar los filtros ingresados en la vista
	 * @param plantillaFiltrosBusquedaMAX
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloEdicionMasivaDatosLogisticosVO> buscarArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException;

	/**
	 * Registra los datos logisticos de los articulos en forma masiva, y retorna una coleccion de codigos de los articulos que no se registraron correctamente
	 * @param articulosCol
	 * @return
	 * @throws SICException
	 */
	public Collection<String> registrarDatosLogisticosArticuloMasivo(Collection<ArticuloEdicionMasivaDatosLogisticosVO> articulosCol) throws SICException;

	/**
	 * Registra los datos logisticos del articulo y retorna el articulo registrado o modificado
	 * @param articulo
	 * @param articuloRegistrado
	 * @return
	 * @throws SICException
	 */
	public ArticuloEdicionMasivaDatosLogisticosVO registrarDatosLogisticosArticulo(ArticuloEdicionMasivaDatosLogisticosVO articulo, Boolean articuloRegistrado) throws SICException;

	/**
	 * Obtiene una lista de articulos filtrados por proceso
	 * @param codigoCompania
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerArticulosPorProceso(Integer codigoCompania, Long codigoProceso) throws SICException;

	/**
	 * Registra los articulos pendientes de integracion
	 * @param articulo
	 * @throws SICException
	 */
	public void registrarArticuloIntegracionDatosExtra(ArticuloEdicionMasivaDatosLogisticosVO articulo) throws SICException;

	

}
