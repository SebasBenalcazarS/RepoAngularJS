/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo.decorator;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author gaortiz
 *
 */
public interface IArticuloRecepcionGestorDecorator {
	
	/**
	 * Metodo que permite registrar varios articulos
	 * @param articuloVOs
	 * @throws SICException
	 */
	void registrarArticulos( Collection<ArticuloVO> articuloVOs)throws SICException;

	
	/**
	 * Metodo que inactiva las unidades de manejo por una prioridad especifica y puede omitir una unidad de manejo especifica.
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param prioridad
	 * @param codigoUnidadManejo codigo de unidad de manejo que se omite puede anularse este parametro
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	Integer inactivarUnidadManejoPorPrioridad(Integer codigoCompania, String codigoArticulo, Integer prioridad, String userId, Long... codigoUnidadManejo) throws SICException;
}
