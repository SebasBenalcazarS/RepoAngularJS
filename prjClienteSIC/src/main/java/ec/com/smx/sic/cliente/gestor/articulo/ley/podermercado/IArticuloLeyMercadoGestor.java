package ec.com.smx.sic.cliente.gestor.articulo.ley.podermercado;

import java.util.List;
import java.util.Map;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado.ArticuloBitacoraLeyMercadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado.ArticuloLeyMercadoDTO;

/**
 * Interfaz que define el comportamiento para el registro y obtencion de informacion de los estados del articulo segun la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
 * de Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado a nivel de art\u00EDculo
 * @author mgranda
 *
 */
public interface IArticuloLeyMercadoGestor {

	/**
	 * M\u00E9todo que permite registrar un art\u00EDculo con estado CODIFICADO seg\u00FAn la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param userId
	 * @throws SICException
	 */
	void codificarArticuloLeyMercado(Integer codigoCompania, String codigoArticulo, String userId) throws SICException;
	
	/**
	 * M\u00E9todo que permite registrar un art\u00EDculo con estado DESCODIFICADO seg\u00FAn la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param userId
	 * @param codigoCausal
	 * @param valorCausal
	 * @throws SICException
	 */
	void descodificarArticuloLeyMercado(Integer codigoCompania, String codigoArticulo, String userId, Integer codigoCausal, String valorCausal) throws SICException;

	/**
	 * M\u00E9todo que permite registrar un art\u00EDculo con estado REACTIVADO seg\u00FAn la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param userId
	 * @throws SICException
	 */
	void reactivarArticuloLeyMercado(Integer codigoCompania, String codigoArticulo, String userId) throws SICException;
	
	/**
	 * M\u00E9todo que permite registrar un art\u00EDculo con estado CODIFICADO seg\u00FAn la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
	 * @author mgranda
	 * @param articuloLeyMercadoDTO entidad que representa la informacion de Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado del articulo
	 * @throws SICException
	 */
	void codificarArticuloLeyMercado(ArticuloLeyMercadoDTO articuloLeyMercadoDTO) throws SICException;	

	/**
	 * M\u00E9todo que permite registrar un art\u00EDculo con estado DESCODIFICADO seg\u00FAn la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
	 * @author mgranda
	 * @param articuloLeyMercadoDTO entidad que representa la informacion de Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado del articulo
	 * @throws SICException
	 */
	void descodificarArticuloLeyMercado(ArticuloLeyMercadoDTO articuloLeyMercadoDTO) throws SICException;
	
	/**
	 * Metodo que permite obtener la informacion actual de Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado del articulo
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	ArticuloLeyMercadoDTO obtenerArticuloLeyMercado(Integer codigoCompania, String codigoArticulo) throws SICException;

	/**
	 * Metodo que permite obtener la informacion historica de estados del articulo segun la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
	 * @author mgranda
	 * @param first
	 * @param pageSize
	 * @param sortField
	 * @param filters
	 * @return
	 * @throws SICException
	 */
	List<ArticuloBitacoraLeyMercadoDTO> obtenerHistoricoLeyMercado(int first, int pageSize, String sortField, Map<String, String> filters) throws SICException;
	
	/**
	 * Metodo que permite obtener el total de la informacion historica de estados del articulo segun la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Long obtenerTotalHistoricoLeyMercado(Integer codigoCompania, String codigoArticulo) throws SICException;
}
