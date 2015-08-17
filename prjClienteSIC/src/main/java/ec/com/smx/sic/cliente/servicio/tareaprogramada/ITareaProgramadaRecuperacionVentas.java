package ec.com.smx.sic.cliente.servicio.tareaprogramada;


/**
 * @author srodriguez
 *
 */
public interface ITareaProgramadaRecuperacionVentas {
	
	/**
	 * Metodo de ITareaProgramadaRecuperacionVentas.java, utilizado para ejecutar la tarea programada de recuperacion de ventas
	 * @author srodriguez
	 * 4/2/2015
	 * @param numeroElementosSeleccion
	 * @param numeroDiasProcesar
	 * @param companyId
	 * @param userId
	 * void
	 */
	void ejecutarTareaProgramadaRecuperacionVentas(Integer numeroElementosSeleccion,Integer numeroDiasProcesar, Integer diasAtrasProcesar,Integer companyId, String userId, Integer recupearVenta);
	
	/**
	 * Metodo de ITareaProgramadaRecuperacionVentas.java, utilizado para reprocesar las ventas a manera de tarea de recuperacion
	 * srodriguez
	 * 7/2/2015
	 * @param numeroElementosSeleccion
	 * @param numeroDiasProcesar
	 * @param companyId
	 * @param userId
	 * void
	 */
	void ejecutarTareaProgramadaRecuperacionVentasReproceso(Integer numeroElementosSeleccion,Integer numeroDiasProcesar,Integer diasAtrasProcesar, Integer companyId, String userId);
	
}
