package ec.com.smx.sic.cliente.servicio.ofertas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.ofertas.constantes.TipoBusquedaOfertas;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

public interface IArticuloOfertasServicio extends Serializable {

	/**
	 * Obtener datos de articulos de una oferta dado filtros de busqueda con plantillas
	 * 
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @param tipoBusquedaOfertas
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloDTO> obtenerDatosArticuloOferta(Integer codigoCompania, ArrayList<ISearchTemplate> plantillasBusqueda, TipoBusquedaOfertas tipoBusquedaOfertas) throws SICException;
	
}
