package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;

/**
 * 
 * @author lguaman
 */

public interface IValidacionFinalizarRecepcionProveedorGestor {

	/**
	 * Validar la informacion para terminar la recepcion del recibidor
	 * @param tareaRecibidor
	 * @param procesoLogRecepcion
	 * @param userId
	 * @throws SICException
	 */
	void terminarRecepcionRecibidor(TareaDTO tareaRecibidor, ProcesoLogisticoDTO procesoLogRecepcion, String userId) throws SICException;

	/**
	 * Validar la informacion para terminar la recepcion en oficina
	 * @param procesoLogRecepcion
	 * @param userId
	 * @throws SICException
	 */
	void terminarRecepcionOficina(ProcesoLogisticoDTO procesoLogRecepcion, String userId) throws SICException;

}