/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.common.busqueda.bean.bodega.recepcion.IPlantillaBusquedaNovedadRecepcion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.NovedadArticuloDTO;

/**
 * @author jvasquez
 *
 */
public interface INovedadArticuloDAO {
	
	/**
	 * <b>Retorna una coleccion de novedades filtrado por una plantilla de busqueda</b>
	 * @author jvasquez
	 * @since  31/07/2015
	 * @param plantilla
	 * @return
	 * @throws SICException
	 */
	Collection<NovedadArticuloDTO> obtenerNovedadArticuloPaginado(IPlantillaBusquedaNovedadRecepcion plantilla, Integer firstResult, Integer pageSize) throws SICException;
	
	/**
	 * <b>Retorna el total de registros obtenidos en la consulta de novedades filtrados por una plantilla de busqueda</b>
	 * @author jvasquez
	 * @since  31/07/2015
	 * @param plantilla
	 * @return
	 * @throws SICException
	 */
	Long obtenerTotalNovedadArticuloPaginado(IPlantillaBusquedaNovedadRecepcion plantilla) throws SICException;

	

}
