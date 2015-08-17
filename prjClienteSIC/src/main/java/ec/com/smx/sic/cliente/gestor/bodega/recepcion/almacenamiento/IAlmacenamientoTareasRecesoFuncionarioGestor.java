/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Date;

import ec.com.smx.corpv2.dto.FuncionarioLogisticoDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoTareaFuncionarioLogisticoDTO;

/**
 * @author wcaiza
 *
 */
public interface IAlmacenamientoTareasRecesoFuncionarioGestor extends Logeable {
	
	/**
	 * 
	 * @param tareaPlantilla
	 * @param codigoReferenciaTipoTarea tipo de tarea de descanso: RECESO, ALMUERZO
	 * @throws SICException
	 */
	void registrarTareaReceso (TareaDTO tareaPlantilla, String referenceCode, String codigoReferenciaTipoTarea) throws SICException;
	
	/**
	 * Finaliza la tarea de receso en caso que haya una abierta
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param fechaBusqueda
	 * @param userId
	 * @param codigoPerfil
	 * @throws SICException
	 */
	void finalizarTareaReceso (Integer codigoCompania, String codigoFuncionario, Date fechaBusqueda, String userId, String codigoPerfil) throws SICException;
	
	/**
	 * Registrar si no existe {@link FuncionarioLogisticoDTO} en estado LIBRE, en caso de existir se actualiza el estado de OCUPADO a LIBRE
	 * @param codigoCompania
	 * @param userId
	 * @param colCodigoFuncionario
	 * @throws SICException
	 */
	void registrarFuncionarioLogisticoEstadoLibre (Integer codigoCompania, String userId, String ... colCodigoFuncionario) throws SICException;
	
	/**
	 * Actualizar el estado del Funcionario en {@link FuncionarioLogisticoDTO} y {@link TipoTareaFuncionarioLogisticoDTO} al momento de asignar una tarea.
	 * <ul>
		 * <li>1. Se obtiene si el funcionario tiene tareas tiene tareas en proceso</li>
		 * <li>2. Si hay tareas en proceso no se actualiza el estado</li>
		 * <li>3. No hay tareas en proceso se actualiza el funcionarioLogistico al estado del usuario que califica el tipo tarea de la tarea encontrada</li>
	 * </ul>
	 * @param tareaDTO
	 * @param fechaBusqueda 
	 * @param codigoPerfil
	 * @throws SICException
	 */
	void actualizarEstadoFuncionarioAsignarTarea (TareaDTO tareaDTO, Date fechaBusqueda, String codigoPerfil) throws SICException;
	
	/**
	 * M&eacute;todo que se debe ejecutar cuando se finaliza la tarea de un funcionario (recibidor, recolector, montacarguista, etc.)
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param fechaBusqueda
	 * @param userId
	 * @param codigoPerfil
	 * @throws SICException
	 */
	void actualizarEstadoFuncionarioFinalizarTarea (Integer codigoCompania, String codigoFuncionario, Date fechaBusqueda, String userId, String codigoPerfil) throws SICException;
	
	/**
	 * Actualizar el estado del Funcionario en {@link FuncionarioLogisticoDTO} y {@link TipoTareaFuncionarioLogisticoDTO} al momento 
	 * que se le reasigna una tarea desde el monitor de abastos para que pueda modificar la cantidad en la recepci&oacute;n.
	 * <ul>
		 * <li>1. Se obtiene si el funcionario tiene tareas tiene tareas suspendidas</li>
		 * <li>2. Si hay tareas suspendidas se actualiza el funcionarioLogistico al estado del usuario que califica el tipo tarea de la tarea encontrada</li>
	 * </ul>
	 * @param tareaDTO
	 * @param fechaBusqueda 
	 * @param codigoPerfil
	 * @throws SICException
	 */
	void actualizarEstadoFuncionarioModificarCantidad (TareaDTO tareaDTO, Date fechaBusqueda, String codigoPerfil) throws SICException;
	
}
