/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.procesamientoventas.recuperaciones.batch;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 *
 */
public interface IAccionMigracionRecuperacionesProcesamientoVentasGestor extends Serializable {
	
	void ejecutarRecuperacionesProcesamientoVentas(Integer codigoCompania, Set<Date> fechasProcesamiento) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param fechasProcesamiento
	 * @throws SICException
	 */
	void ejecutarRecuperacionesDiariasProcesamientoVentas(Integer codigoCompania, Set<Date> fechasProcesamiento) throws SICException;

}
