/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.dao;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jvillacis
 *
 */
public interface IPedidoAreaTrabajoClasificacionDAO {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoPedidoAreaTrabajo
	 * @param userId
	 */
	public void inactivarPedidoAreaTrabajoClasificaciones(Integer codigoCompania, Long codigoPedidoAreaTrabajo, String userId) throws SICException;
	
}
