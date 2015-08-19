package ec.com.smx.sic.cliente.servicio.fruver;

import java.io.Serializable;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloOfertaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.OfertaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroRangoFechaDTO;

/**
 * 
 * @author jcayo<josecayo4@gmail.com>
 *
 */

public interface IFruverServicio extends Serializable {

	/* BUSQUEDA*/
	
	/**
	 * Permite obtener el parametro de un determinado rango de fechas
	 * @param codigoCompania Codigo de la compania
	 * @param codigoParametroRangoFecha Codigo del rango de fecha a obtener
	 * @return ParametroRangoFechaDTO
	 * @throws SICException
	 */
	ParametroRangoFechaDTO obtenerParametroRangoFecha(Integer codigoCompania, Integer codigoParametroRangoFecha) throws SICException;
	
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

	/* ALMACENAMIENTO */
	/**
	 * Permite guardar las cantidades que oferta el proveedor
	 * @param ofertaProveedorDTO OfertaProveedorDTO a guardar
	 * @param esCreacion True si es creacion, False en caso contrario
	 * @throws SICException
	 */
	void guardarOfertasProveedor(OfertaProveedorDTO ofertaProveedorDTO, Boolean esCreacion) throws SICException;

	/**
	 * Permite cambiar el estado de las ofertas a enviadas
	 * @param codigoCompania Codigo de la compania
	 * @param codigoOferta Codigo de la oferta que se esta enviando
	 * @param codigoProveedor Codigo del proveedor que esta realizando la oferta
	 * @throws SICException
	 */
	void enviarOfertasProveedor(Integer codigoCompania, Integer codigoOferta, String codigoProveedor) throws SICException;

	/**
	 * Busca si la oferta ya ha sido enviada
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 */
	Boolean esOfertaEnviada(Integer codigoCompania, String codigoProveedor) throws SICException;

}