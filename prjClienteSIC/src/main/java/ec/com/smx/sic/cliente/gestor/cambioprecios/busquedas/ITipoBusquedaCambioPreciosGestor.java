/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.cambioprecios.busquedas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author gnolivos
 *
 */
public interface ITipoBusquedaCambioPreciosGestor extends Serializable{
	
	/**
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @param datosPaginados
	 * @param firstResult
	 * @param maxResults
	 * @param tipoReporte
	 * @return
	 * @throws SICException
	 */
	 <T extends SearchDTO> Duplex<Collection<T>, Long> obtenerDatosBusquedaCambioPrecios(Integer codigoCompania, String codigoFuncionario, 
			 ArrayList<ISearchTemplate> plantillasBusqueda, Integer firstResult, Integer maxResult, Boolean countAgain, Boolean esPaginado, 
			 Boolean mostrarProcesados) throws SICException;

}
