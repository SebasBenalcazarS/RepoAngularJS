/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.dao;

import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author aguato
 *
 */
public interface IPedidoOrdenCompraDAO {

	/**
	 * Obtiene el mayor plazo de pago
	 * de todos los pedidos asociados
	 * a la Recepcion
	 * 
	 * @param codigoCompania
	 * @param codigoRecepcion
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerPlazoPagoPedidosRecepcion(Integer codigoCompania, Long codigoRecepcion) throws SICException;
	
	/**
	 * Obtiene archivo plano de las estructuras del B2B 
	 * 
	 * @param codigoCompania
	 * @param numeroPedido
	 * @param codigoProveedor
	 * @param fechaEntrega
	 * @return
	 * @throws SICException
	 */
	public byte[] obtenerArchivoPedidoB2B(Integer codigoCompania, Long numeroPedido, String codigoProveedor, Date fechaEntrega) throws SICException;

	/**
	 * Consulta si una bodega tiene asignada la caracteristica fecha entrega caducidad por codigoBodega
	 * @param codigoBodega
	 * @return Boolean
	 * @throws SICException
	 */
	public Boolean caracteristicaFechaEntregaCaducidad(String codigoBodega) throws SICException;
}
