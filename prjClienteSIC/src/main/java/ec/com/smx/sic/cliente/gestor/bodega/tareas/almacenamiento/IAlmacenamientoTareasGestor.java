/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.tareas.almacenamiento;

import ec.com.smx.corpv2.dto.id.CatalogoValorID;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;

/**
 * @author wcaiza
 *
 */
public interface IAlmacenamientoTareasGestor extends Logeable {
	
	/**
	 * Asignar la tarea a un funcionario, y cambiar el estado de la tarea a asignada
	 * @param tareaPlantilla
	 * @param catalogoIdAccionEstadoTarea
	 * @return
	 * @throws SICException
	 */
	TareaDTO asignarTareaFuncionario (TareaDTO tareaPlantilla, CatalogoValorID catalogoIdAccionEstadoTarea, Boolean actualizarEstadoTarea) throws SICException;
	
	/**
	 * Cambiar de estado a una tarea
	 * @param tareaDTO {@link TareaDTO} a cambiar de estado
	 * @param catalogoIdAccionEstadoTarea {@link CatalogoValorID} con la el tipo y la acci&oacute;n del estado nuevo
	 * @return
	 * @throws SICException
	 */
	TareaDTO cambiarEstadoTarea(TareaDTO tareaDTO, CatalogoValorID catalogoIdAccionEstadoTarea, Boolean actualizarEstadoTarea) throws SICException;

}
