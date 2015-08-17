/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.administracion.accion;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jtoapanta
 *
 */
public interface IAccionProveedorGestor {
	
	/**
	 *  Metodo que envia mail a usuarios que tenga pendientes la actualizacion de precios en COMPARACION PRECIOS 
	 * @param codigoCompania
	 */
	public void emailsComparacionPreciosPendientes (Integer codigoCompania)throws SICException;

}
