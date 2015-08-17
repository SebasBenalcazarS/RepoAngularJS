package ec.com.smx.sic.cliente.gestor.articulo.admin;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * 
 * @author gaortiz
 *
 */
public interface IArticuloRegistroGestor {

	/**
	 * Metodo que permite registrar un articulo
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	ArticuloVO registrarArticulo(ArticuloVO articuloVO) throws SICException;

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
