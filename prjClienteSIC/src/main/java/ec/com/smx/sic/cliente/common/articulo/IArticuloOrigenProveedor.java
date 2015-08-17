/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author gaortiz
 *
 */
public interface IArticuloOrigenProveedor {
	
	/**
	 * Metodo que permite obtener el origen del proveedor
	 * @return
	 * @throws SICException
	 */
	String getOrigenArticulo()throws SICException;

}
