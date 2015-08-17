/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.cambioprecios.busquedas;

import java.io.Serializable;
import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

/**
 * @author Luis Yacchirema
 *
 */
public interface IBusquedaCambioPreciosGestor extends Serializable{


	/**
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Duplex<T,SearchResultDTO<T>> obtenerDatosArticulosCambioPreciosPorPlantillas(Integer codigoCompania,String codigoFuncionario, Collection<ISearchTemplate> plantillasBusqueda) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param plantillasBusqueda
	 * @param esCreacionCambioPrecio
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloDTO> obtenerDatosArticulosPorPlantillas(Integer codigoCompania, String codigoFuncionario, 
			Collection<ISearchTemplate> plantillasBusqueda, Boolean esCreacionCambioPrecio) throws SICException;
}
