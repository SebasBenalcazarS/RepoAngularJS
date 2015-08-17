package ec.com.smx.sic.cliente.gestor.proveedor.busquedaproveedor;

import java.io.Serializable;
import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;

public interface ITipoBusquedaProveedorGestor extends Serializable {
	

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
	<T extends SearchDTO> Duplex<T,SearchResultDTO<T>> obtenerProveedoresPorPlantillas(Integer codigoCompania,
			Collection<ISearchTemplate> plantillasBusqueda, Boolean datosPaginados, Integer firstResult, Integer maxResults, Boolean paginadoManual, String codigoFuncionario, Long codigoLineaComercial) throws SICException;

}
