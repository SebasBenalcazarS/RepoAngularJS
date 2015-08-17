/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.admin.validacion;

import java.util.HashSet;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jvillacis
 *
 */
public interface IValidacionArticuloJugueteGestor {
	
	/**
	 * Verifica si la sigla del cliente se encuentra en el parametro de clientes que generan orden de compra para la recepcion de juguetes
	 * @param parametroCodigosClientes
	 * @param siglaCliente
	 * @return
	 * @throws SICException
	 */
	public boolean esArticuloJuguete(String parametroCodigosClientes, String siglaCliente) throws SICException;
	
	/**
	 * Valida si se crea una orden de compra
	 * manual para juguetes en base a las
	 * lineas comerciales del usuario logueado
	 * 
	 * @param codigosReferenciaLineaComercialUsuario
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public boolean validarEsOrdenCompraJuguetes(Integer codigoCompania, HashSet<String> codigosReferenciaLineaComercialUsuario) throws SICException;
	
	/**
	 * Verifica si una determinada area de trabajo
	 * genera una orden de compra para JUGUETES
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoSubbodega
	 * @return
	 * @throws SICException
	 */
	public boolean esAreaTrabajoCaracteristicaJuguetes(Integer codigoCompania, Integer codigoAreaTrabajoSubbodega) throws SICException;
	
}
