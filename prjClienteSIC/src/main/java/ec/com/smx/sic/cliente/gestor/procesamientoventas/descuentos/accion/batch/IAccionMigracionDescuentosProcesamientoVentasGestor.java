/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.procesamientoventas.descuentos.accion.batch;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 *
 */
public interface IAccionMigracionDescuentosProcesamientoVentasGestor extends Serializable {
	
	void ejecutarDescuentosProcesamientoVentas(Integer codigoCompania, Set<Date> fechasProcesamiento) throws SICException;

}
