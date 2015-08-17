package ec.com.smx.sic.cliente.servicio.articulo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.BusquedaSimpleArticuloVO;

/**
 * Servicio de busqueda MarcaArticulo
 * @author dbravo
 *
 */
public interface IMarcaArticuloServicio {
	
	/**
	 * Obtiene colleccion MarcaArticuloDTO paginado
	 * @param first
	 * @param pageSize
	 * @param codigoCompania
	 * @param busquedaSimpleArticuloVO
	 * @return
	 * @throws SICException
	 */
	public Collection<MarcaArticuloDTO> findMarcaArticuloFiltro(Integer first, Integer pageSize, Integer codigoCompania, BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException;
	
	
	public Integer totalMarcaArticuloFiltro(Integer codigoCompania, BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException;
}
