package ec.com.smx.sic.cliente.servicio.tareaprogramada;

import java.util.Date;


/**
 * @author egudino
 *
 */
public interface ITareaProgramadaProcesamientoVentas {
	
	/**
	 * Ejecuta la tarea programada para procesamiento de ventas
	 * @param companyId
	 * @param userId
	 * @param numeroDiasProcesar
	 */
	void ejecutarTareaProgramadaProcesamientoVentas(Integer companyId, String userId, Integer diasAtrasProcesar);
	
	
	void ejecutarTareaProgramadaCobrosDiariosProyectados(Integer companyId, String userId, Date fecha);
}
