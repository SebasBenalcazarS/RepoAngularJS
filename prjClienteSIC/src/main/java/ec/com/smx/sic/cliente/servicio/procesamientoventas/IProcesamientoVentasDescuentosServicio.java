package ec.com.smx.sic.cliente.servicio.procesamientoventas;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 *
 */
public interface IProcesamientoVentasDescuentosServicio extends Serializable {
	
	void ejecutarDescuentosProcesamientoVentas(Integer codigoCompania, Set<Date> fechasProcesamiento) throws SICException;
	
}
