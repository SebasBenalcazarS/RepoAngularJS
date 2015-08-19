package ec.com.smx.sic.cliente.gestor.fruver.busqueda;

import java.io.Serializable;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloOfertaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroRangoFechaDTO;

/**
 * 
 * @author jcayo<josecayo4@gmail.com>
 *
 */
public interface IBusquedaOfertaProveedorGestor extends Serializable {


	/**
	 * Busca si la oferta ya ha sido enviada
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 */
	Boolean esOfertaEnviada(Integer codigoCompania, String codigoProveedor) throws SICException;

	/**
	 * Busca articulos que puede ofertar un proveedor 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param filtros
	 * @param parametroRangoFechaDTO
	 * @param numeroTotalRegistros
	 * @return SearchResultDTO<ArticuloOfertaProveedorDTO>
	 * @throws SICException
	 */
	SearchResultDTO<ArticuloOfertaProveedorDTO> buscarArticulosOfertaProveedor(Integer codigoCompania, String codigoProveedor, Map<String, Object> filtros, ParametroRangoFechaDTO parametroRangoFechaDTO, Boolean numeroTotalRegistros) throws SICException;


}
