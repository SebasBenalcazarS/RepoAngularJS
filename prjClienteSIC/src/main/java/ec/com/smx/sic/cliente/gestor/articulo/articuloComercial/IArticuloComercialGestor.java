/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.articuloComercial;

import ec.com.smx.sic.cliente.common.articulo.IArticuloOrigenProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author gaortiz
 *
 */
public interface IArticuloComercialGestor {
	
	/**
	 * 
	 * @param articuloComercialDTO
	 * @param esCreacion
	 * @throws SICException
	 */
	void registrarArticuloComercial(ArticuloComercialDTO articuloComercialDTO, Boolean esCreacion, IArticuloOrigenProveedor articuloOrigenProveedor)throws SICException;
	
	/**
	 * 
	 * @param articuloComercialDTO
	 * @param esCreacion
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param userId
	 * @throws SICException
	 */
	void registrarArticuloComercial(ArticuloComercialDTO articuloComercialDTO, Boolean esCreacion, Integer codigoCompania, String codigoArticulo, String userId, IArticuloOrigenProveedor articuloOrigenProveedor ) throws SICException;
	
	
	/**
	 * 
	 * @param articuloVO
	 * @param esCreacion
	 * @throws SICException
	 */
	void registrarArticuloComercial(ArticuloVO articuloVO,Boolean esCreacion)throws SICException;
	
	public Integer actualizarMarcaComercial(Integer codigoCompania, String codigoArticulo, String userId, Long codigoMarca) throws SICException;

}
