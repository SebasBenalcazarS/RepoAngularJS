/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.cambioprecios.busquedas;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;

/**
 * @author gnolivos
 *
 */
public interface IBusquedaArticuloPlantillaCambioPreciosGestor extends Serializable{
	
	/**
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param plantillasBusquedasArticuloPrecios
	 * @return
	 * @throws SICException
	 */
	Collection<GestionPrecioDTO> obtenerCambioPreciosPorPlantillas(Integer codigoCompania, String userId, String codigoFuncionario, 
			Collection<ISearchTemplate> plantillasBusquedasPlantillas, String codigoPlantilla) throws SICException;

}
