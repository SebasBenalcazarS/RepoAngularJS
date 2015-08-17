/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.dao;

import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoImpuestoDTO;

/**
 * @author jvillacis
 *
 */
public interface IOrdenCompraEstadoImpuestoDAO {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraEstado
	 * @param userId
	 * @throws SICException
	 */
	public void inactivarImpuestosOrdenCompraEstado(Integer codigoCompania, Long codigoOrdenCompraEstado, String userId) throws SICException;
	
	/**
	 * <b> Obtiene todos los impuestos que tiene el estado de una orden de compra; estos impuestos deben ser filtrados por un estado.</b>
	 * <p>
	 * [Author: mchiliquinga, Date: 27/1/2015]
	 * </p>
	 *
	 * @param codigoOrdenCompraEstado
	 *            es el codgio del estado de la orden de compra para obtener los impuestos
	 * @param codigoCompania
	 *            compania del usuario logeado
	 * @param estado
	 *            filtra la consulta por el estado ACT/INA
	 * @return lista con todos los decuentos de la orden de compra
	 */ 
	List<OrdenCompraEstadoImpuestoDTO> obtenerImpuestosPorEstado(Long codigoOrdenCompraEstado, Integer codigoCompania, String estado);

	
}
