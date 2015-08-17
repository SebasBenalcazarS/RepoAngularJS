/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.dao;

import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoImpuestoDTO;

/**
 * @author jvillacis
 *
 */
public interface IOrdenCompraDetalleEstadoImpuestoDAO {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraDetalleEstado
	 * @param userId
	 * @throws SICException
	 */
	public void inactivarImpuestosDetalleOrdenCompra(Integer codigoCompania, Long codigoOrdenCompraDetalleEstado, String userId) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraEstado
	 * @param userId
	 * @throws SICException
	 */
	public void inactivarImpuestosOrdenCompra(Integer codigoCompania, Long codigoOrdenCompraEstado, String userId) throws SICException;
	
	/**
	 * <b> Cambia el estado de los impuestos de para un detalle especifico de la
	 * orden de compra o tambien puede cambiar el estado de un impuesto
	 * especifico en base a su id. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 18/08/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraDetalleEstado
	 *            detalle al cual se le cambiara el estado
	 * @param userId
	 *            usuario que esta realizando la actualizacion
	 * @param estado
	 *            nuevo estado del detalle activo/inactivo
	 * @param codigoOrdenCompraDetalleEstadoImpuesto
	 *            clave primaria de la tabla
	 * 
	 */ 
	void actualizarEstadoImpuestosDetalleOrdenCompra(Integer codigoCompania, Long codigoOrdenCompraDetalleEstado, String userId,
			String estado, Long codigoOrdenCompraDetalleEstadoImpuesto);
	
	/**
	 * <b> Obtiene todos los impuestos de un detalle, ademas estos impuestos pueden ser filtrados por un estado. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 19/08/2014]
	 * </p>
	 * 
	 * @param codigoOrdenCompraDetalleEstado
	 * @param codigoCompania
	 * @return
	 */ 
	List<OrdenCompraDetalleEstadoImpuestoDTO> obtenerImpuestosPorDetalle(Long codigoOrdenCompraDetalleEstado, Integer codigoCompania,
			String estado);
	
}
