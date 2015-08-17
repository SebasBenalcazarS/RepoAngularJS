package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;


/**
 * 
 * @author lguaman
 *
 */
public interface IFinalizarRecepcionProveedorGestor {

	/**
	 * Termina la recepcion dependiendo del tipo de control de costos que se recibio, esto desde el recibidor
	 *
	 * @param tareaRecibidor
	 * @param procesoLogRecepcion
	 * @param userId
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void terminarRecepcionRecibidor(TareaDTO tareaRecibidor, ProcesoLogisticoDTO procesoLogRecepcion, String userId);

	/**
	 * Finalizar la recepcion desde la oficina
	 *
	 * @param procesoLogRecepcion
	 * @param userId
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void terminarRecepcionOficina(ProcesoLogisticoDTO procesoLogRecepcion, String userId) throws SICException;

}
