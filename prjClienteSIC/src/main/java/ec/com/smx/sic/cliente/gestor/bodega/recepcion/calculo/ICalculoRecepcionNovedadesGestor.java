package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;

import ec.com.smx.sic.cliente.common.busqueda.bean.bodega.recepcion.IPlantillaBusquedaNovedadRecepcion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.JustificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaNovedadArticuloRecepcionDTO;

/**
 * @author aecaiza
 *
 */
public interface ICalculoRecepcionNovedadesGestor {
	/**
	 * Busca los datos correspondientes a las justificaciones para la recepcion
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoPerfil
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerJustificacionesRecepcion(Integer codigoCompania, Integer codigoAreaTrabajo, String codigoPerfil) throws SICException;
	
	/**
	 *<b> Obtiene las justificaciones con cantidad por articulo y unidad de manejo<b>
	 * <p>
	 * [Author: aecaiza, Date: 04/03/2015]
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @param codigoAreaTrabajo
	 * @param codigoProcesoLogistico
	 * @param codigoPerfil
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerCantidadJustificaciones(Integer codigoCompania, String codigoArticulo, Long codigoUnidadManejo, Integer codigoAreaTrabajo,
			Long codigoProcesoLogistico, String codigoPerfil) throws SICException;

	/**
	 * <b> Obtiene las justificaciones filtradas por tipo de novedad<b>
	 * <p> 
	 * [Author: jvasquez, Date: 28/07/2015]
	 * @param codigoCompania
	 * @param valorTipoNovedad
	 * @param codigoTipoNovedad
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerJustificacionTipo(Integer codigoCompania, String valorTipoNovedad, Integer codigoTipoNovedad) throws SICException;

	/**
	 * <b> Obtiene las justificaciones filtradas por area de trabajo y perfil<b>
	 * <p> 
	 * [Author: jvasquez, Date: 28/07/2015]
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoPerfil
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerJustificacionAreaTrabajoPerfil(Integer codigoCompania, Integer codigoAreaTrabajo, String codigoPerfil) throws SICException;
	
	/**
	  * <b> Obtiene las novedades de articulo filtradas por una plantilla de busqueda<b>
	 * <p> 
	 * [Author: jvasquez, Date: 31/07/2015]
	 * @param plantilla
	 * @return
	 * @throws SICException
	 */
	Collection<VistaNovedadArticuloRecepcionDTO> obtenerNovedadArticuloPaginado(IPlantillaBusquedaNovedadRecepcion plantilla) throws SICException;
}
