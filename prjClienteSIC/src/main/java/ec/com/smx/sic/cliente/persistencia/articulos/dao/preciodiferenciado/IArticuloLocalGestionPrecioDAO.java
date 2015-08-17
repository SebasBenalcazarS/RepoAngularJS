package ec.com.smx.sic.cliente.persistencia.articulos.dao.preciodiferenciado;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalGestionPrecioDTO;



public interface IArticuloLocalGestionPrecioDAO {
	
	/**
	 * Guarda un precio diferenciado con locales
	 * @param articuloLocalGestionPrecioDTO
	 * @throws SICException
	 */
	void guardarArticuloLocalGestionPrecio(ArticuloLocalGestionPrecioDTO articuloLocalGestionPrecioDTO) throws SICException;
	
	/**
	 * Busca los articulos local precio del precio diferenciado
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param secuenciaPreDif
	 * @param estado
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloLocalGestionPrecioDTO> obtenerArticulosLocalPrecio(Integer codigoCompania, String codigoArticulo, Long secuenciaPreDif, String estado) throws SICException;
	
	/**
	 * Actuliza los valores de acticulo local gestion precio
	 * @param articuloLocalGestionPrecioDTO
	 * @throws SICException
	 */
	void actualizarArticuloLocalGestionPrecio(ArticuloLocalGestionPrecioDTO articuloLocalGestionPrecioDTO) throws SICException;
	
	/**
	 * Devuelve los precios planificados 
	 * @param codigoCompania
	 * @param fechaCierre
	 * @throws SICException
	 */
	public Collection<ArticuloLocalGestionPrecioDTO> obtenerArticulosLocalesPreciosPlanificados(Integer codigoCompania, Date fechaCierre) throws SICException;
	
	/**
	 * Actualiza el estado de ejecucion de la planificacion del acticulo local gestion precio
	 * @param articuloLocalGestionPrecioDTO
	 * @param userId
	 * @throws SICException
	 */
	void actualizarEstadoEjecucionArticuloLocalGestionPrecio(ArticuloLocalGestionPrecioDTO articuloLocalGestionPrecioDTO, String userId) throws SICException;
	
	/**
	 * Elimina el precio articulo local
	 * @param articuloLocalGestionPrecio
	 * @param userId
	 * @throws SICException
	 */
	void eliminarPreciosArticulosLocalFinalizados(ArticuloLocalGestionPrecioDTO articuloLocalGestionPrecio, String userId) throws SICException;
}
