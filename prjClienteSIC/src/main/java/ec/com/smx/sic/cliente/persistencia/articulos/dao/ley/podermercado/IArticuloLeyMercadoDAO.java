package ec.com.smx.sic.cliente.persistencia.articulos.dao.ley.podermercado;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import ec.com.smx.sic.cliente.common.articulo.EnumEstadoLeyMercado;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado.ArticuloBitacoraLeyMercadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado.ArticuloLeyMercadoDTO;

/**
 * Interfaz que define el comportamiento de registro y obtencion de informacion actual de los estados del articulo segun la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
 * @author mgranda
 *
 */
public interface IArticuloLeyMercadoDAO {

	/**
	 * Metodo que permite obtener la informacion de los estados de un conjunto de articulos a traves de sus secuenciales unicos
	 * @author mgranda
	 * @param secuencialArtLeyMer
	 * @return
	 */
	Collection<ArticuloLeyMercadoDTO> obtenerArticuloLeyMercado(Long... secuencialArtLeyMer);

	/**
	 * Metodo que permite obtener la informacion del estado de un articulo a traves de su secuencial unico
	 * @author mgranda
	 * @param secuencialArtLeyMer
	 * @return
	 */
	ArticuloLeyMercadoDTO obtenerUnicoArticuloLeyMercado(Long secuencialArtLeyMer);

	/**
	 * Metodo que crea un registro de informacion de estado de un articulo
	 * @author mgranda
	 * @param articuloLeyMercadoDTO
	 * @throws SICException
	 */
	void crearArticuloLeyMercado(ArticuloLeyMercadoDTO articuloLeyMercadoDTO) throws SICException;

	/**
	 * Metodo que permite obtener la informacion del estado de un articulo a traves del codigo de compania y codigo de articulo
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	ArticuloLeyMercadoDTO obtenerArticuloLeyMercado(Integer codigoCompania, String codigoArticulo) throws SICException;

	/**
	 * Metodo que cuenta el numero de registros en los estados de los articulos segun el estado especificado
	 * @author oviana
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param enumEstadoLeyMercado
	 * @return
	 * @throws SICException
	 */
	Long contarArticuloLeyMercado(Integer codigoCompania, String codigoArticulo, EnumEstadoLeyMercado enumEstadoLeyMercado) throws SICException;
	
	/**
	 * Metodo que obtiene informacion del estado del articulo de forma personalizada
	 * @author oviana	
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	ArticuloLeyMercadoDTO obtenerArticuloLeydeMercado(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	/**
	 * Metodo que permite obtener la informacion historica paginada de estados de un articulo 
	 * @author oviana
	 * @param first
	 * @param pageSize
	 * @param sortField
	 * @param filters
	 * @return
	 * @throws SICException
	 */
	List<ArticuloBitacoraLeyMercadoDTO> obtenerHistoricoLeyMercado(int first, int pageSize, String sortField, Map<String, String> filters) throws SICException;
	
	/**
	 * Metodo que permite obtener el total de registros historicos de estados de un articulo
	 * @author oviana
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Long obtenerTotalHistoricoLeyMercado(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	/**
	 * Metodo que permite actualizar la informacion de estados de un articulo
	 * @author mgranda
	 * @param articuloLeyMercadoDTO
	 * @throws SICException
	 */
	void actualizarArticuloLeyMercado(ArticuloLeyMercadoDTO articuloLeyMercadoDTO) throws SICException;

}
