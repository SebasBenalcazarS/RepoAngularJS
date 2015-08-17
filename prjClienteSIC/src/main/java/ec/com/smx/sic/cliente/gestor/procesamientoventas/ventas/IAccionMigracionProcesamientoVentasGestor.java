/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.procesamientoventas.ventas;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author vjaramillo
 *
 */
public interface IAccionMigracionProcesamientoVentasGestor {

	/**
	 * Metodo para migrar los datos de las ventas que son enviados por el SIC 
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	void ejecutarVentasDevolucionesProcesamientoVentas(Integer codigoCompania) throws SICException;
}
