/**
 * @author Luis Yacchirema
 */
package ec.com.smx.sic.cliente.gestor.procesamientoventas.administracion.accion.batch;

import java.io.Serializable;
import java.util.Map;

import org.springframework.batch.core.Job;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 *
 */
public interface IAccionConfigBatchProcesamientoGestor extends Serializable {
	
	/**
	 * @param procesamientoJob
	 * @param parametros
	 * @throws SICException
	 */
	public void ejecutarProcesamientoJob(Job procesamientoJob, Map<String, Object> parametros) throws SICException;

}
