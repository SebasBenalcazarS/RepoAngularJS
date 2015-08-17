package ec.com.smx.sic.cliente.gestor.ofertas.busquedas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

public interface ITipoBusquedaOfertasGestor extends Serializable {

	/**
	 * Obtiene los datos de los articulos de una oferta dados criterios de busqueda
	 * 
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloDTO> obtenerDatosBusquedaOfertas(Integer codigoCompania, ArrayList<ISearchTemplate> plantillasBusqueda) throws SICException;
}
