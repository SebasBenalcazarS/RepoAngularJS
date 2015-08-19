package ec.com.smx.sic.cliente.persistencia.fruver.dao;

import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloOfertaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;

/**
 * @author  jcayo<josecayo4@gmail.com>
 *
 */
public interface IArticuloOfertaProveedorDAO {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param restricciones
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloOfertaProveedorDTO> getArticulosOfertaProveedor(Integer codigoCompania, String codigoProveedor, Map<String, Object> restricciones) throws SICException;

	/**
	 * Permite cambiar el estado de las ofertas a enviadas
	 * @param codigoCompania Codigo de la compania
	 * @param codigoOferta Codigo de la oferta que se esta enviando
	 * @param codigoProveedor Codigo del proveedor que esta realizando la oferta
	 * @throws SICException
	 */
	void enviarOfertasProveedor(Integer codigoCompania, Integer codigoOferta, String codigoProveedor) throws SICException;

	/**
	 * Consultar articulos unidad de manejo por proveedor
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param filtros
	 * @param numeroTotalRegistros
	 * @return
	 * @throws SICException
	 */
	SearchResultDTO<ArticuloUnidadManejoProveedorDTO> getArticulosUnidadManejoProveedor(Integer codigoCompania, String codigoProveedor, Map<String, Object> filtros, Boolean numeroTotalRegistros) throws SICException;

}
