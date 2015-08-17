/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.dao;

import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDescuentoDTO;

/**
 * @author jvillacis
 *
 */
public interface IOrdenCompraDetalleEstadoDescuentoDAO {
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraDetalleEstado
	 * @param userId
	 * @throws SICException
	 */
	public void inactivarDescuentosDetalleOrdenCompra(Integer codigoCompania, Long codigoOrdenCompraDetalleEstado, String userId) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraEstado
	 * @param userId
	 * @throws SICException
	 */
	public void inactivarDescuentosOrdenCompra(Integer codigoCompania, Long codigoOrdenCompraEstado, String userId) throws SICException;
	
	/**
	 * <b> Actualiza el estado (activo/inactivo) de todos los descuentos de un detalle o de un descuento especifico. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 28/08/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param estado
	 * @param codigoOrdenCompraDetalleEstado
	 * @param codigoOrdenCompraDetalleEstadoDescuento
	 */ 
	void actualizarEstadoDescuentosDetalleOrdenCompra(Integer codigoCompania, String userId, String estado,
			Long codigoOrdenCompraDetalleEstado, Long codigoOrdenCompraDetalleEstadoDescuento);
	
	/**
	 * <b> Obtiene todos los descuentos para un detalle; estos descuentos se pueden obtener por un determiando estado; si el parametro
	 * del estado es null consulta todos los descuentos. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 28/08/2014]
	 * </p>
	 * 
	 * @param codigoOrdenCompraDetalleEstado
	 * @param codigoCompania
	 * @param estado
	 * @return
	 */ 
	List<OrdenCompraDetalleEstadoDescuentoDTO> obtenerDescuentosDetalleOrdenCompra(Long codigoOrdenCompraDetalleEstado,
			Integer codigoCompania, String estado);
}
