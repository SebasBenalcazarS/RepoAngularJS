package ec.com.smx.sic.cliente.persistencia.ordenCompra.dao;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;

/**
 * @author aguato
 *
 */
public interface IOrdenCompraEstadoDAO {

	/**Metodo que valida si la entrega asociada 
	 * a la orden de compra ya fue migrada
	 * 
	 * @param numeroNotaIngreso : Numero nota de ingreso de la factura relacionada a la Recepcion-Entrega
	 * @param codigoOrdenCompra : Orden de compra que se esta procesando
	 * 
	 * @return True si la entrega ya fue migrada
	 *  
	 * @throws SICException
	 */
	public Boolean validarEntregaOrdenCompraMigrada(String numeroNotaIngreso, Long codigoOrdenCompra) throws SICException;
	
	/**Metodo que obtiene la entrega de tipo
	 * recepcion antigua SIC asociada a la 
	 * recepcion de la nota de ingreso
	 *
	 * @param numeroNotaIngreso : Numero nota de ingreso de la factura relacionada a la Recepcion-Entrega
	 * @return codigo de entrega de tipo recepcion antigua SIC
	 * @throws SICException
	 */
	public Long obtenerEntregaRecepcionNotaIngreso(String numeroNotaIngreso) throws SICException;
	
	
	/**metodo que valida la fecha fin de una orden compra estado anterior
	 * recibiendo como parametro la orden compra estado actual.
	 * 
	 * @param ordenCompraEstadoActual
	 * @return
	 * @throws
	 */
	public Boolean validarFechaFinOrdenCompraEstadoAnterior(OrdenCompraEstadoDTO ordenCompraEstadoActual) throws SICException;
}
