/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.administracion.almacenamiento;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jvillacis
 *
 */
public interface IMigracionOrdenCompraGestor extends Serializable {

	/**
	 * 
	 * @param codigoCompania
	 * @param rangoInicial
	 * @param rangoFinal
	 * @throws SICException
	 */
	public void migrarOrdenesCompraB2B(Integer codigoCompania, String rangoInicial, String rangoFinal) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param rangoInicial
	 * @param rangoFinal
	 * @throws SICException
	 */
	public void migrarOrdenesCompraRelacionadasB2B(Integer codigoCompania, String rangoInicial, String rangoFinal) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void migrarEntregas(Integer codigoCompania, String rangoInicial, String rangoFinal) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void migrarEntregasFacturaInterna(Integer codigoCompania, String rangoInicial, String rangoFinal) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void migrarEntregasOrdenCompra(Integer codigoCompania, String rangoInicial, String rangoFinal) throws SICException;
	
	/**
	 * Migra las ordenes de compra
	 * creadas/actualizadas/anuladas
	 * en el MAX al SIC
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void migrarOrdenesCompraMAX(Integer codigoCompania) throws SICException;
	
	/**
	 * Permite enviar emails de los pedidos que tienen ENVIAREMAIL como no enviado;
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void enviarEmailPedidosPendientes(Integer codigoCompania) throws SICException;
}
