package ec.com.smx.sic.cliente.gestor.bodega.tareas.calculo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaTareaDatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaTareaPalletDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaUbicacionPalletMontacarguistaDTO;
import ec.com.smx.sic.cliente.mdl.vo.cd.recepcion.TareasRecolectorVO;

public interface IBusquedaTareasGestor {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosTarea
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleTareaDTO> consultarDetallesTarea(Integer codigoCompania, Collection<Long> codigosTarea) throws SICException;
	
	/**
	 * Obtiene las tareas del recollector que aun estan pendientes o asignadas a un usuario
	 * 
	 * @param funcionarioSublugarTrabajoRelacionadoDTO
	 * @return 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<TareaDTO> buscarTareasRecolector(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO,Collection<DetalleSeccionDTO> andenesAsignados) throws SICException;
	

	/**
	 * Obtiene el total de tareas del recolector
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	Integer obtenerTotalTareasRecolector(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO,Collection<DetalleSeccionDTO> andenesAsignados) throws SICException;
	
	/**
	 * Retorna una coleccion de pallets que aun no han sido ubicados.
	 * @param funcionarioAreaTrabajoDTO
	 * @param codigoBarrasPallet
	 * @return 
	 * @throws SICException
	 */
	Collection<VistaUbicacionPalletMontacarguistaDTO> buscarPaletsMontacarguista(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, String codigoBarrasPallet) throws SICException;


	/**
	 * Retorna una coleccion de las tareas que aun no han sido asignadas a los recibidores
	 * @param funcionarioSublugarTrabajoRelacionadoDTO
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	Collection<TareaDTO> obtenerTareasRecibidorSinAsignar(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, Long codigoProceso) throws SICException;


	/**
	 * Obtiene las todos los tipos de tarea de un proceso logistico de una recepcion
	 * 
	 * @param vistaProcesoLogisticoDTO Un VistaProcesoLogisticoDTO
	 * @return Un Collection de VistaTareaPalletDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<VistaTareaPalletDTO> obtenerTareasProcesosLogistico(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO) throws SICException;
	
	/**
	 * 
	 * @param funSubTraRel
	 * @return
	 * @throws SICException
	 */
	TareasRecolectorVO obtenerTareaDatosTareaRecolector (FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) throws SICException;
	
	/**
	 * Obtener los pallets asignados a un recolector, por valorEstadoDatosTarea y codigoReferenciaTipoTarea
	 * @param funSubTraRel
	 * @param valorEstadoDatosTarea
	 * @param codigoReferenciaTipoTarea
	 * @return
	 * @throws SICException
	 */
	Collection<VistaTareaDatosTareaDTO> obtenerPalletsAsignadosRecolector (FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, String valorEstadoDatosTarea, String codigoReferenciaTipoTarea) throws SICException;

	/**
	 * Obtener la &uacute;ltima tarea activa de un proceso log&iacute;stico
	 * @param codigoProcesoLogistico
	 * @param codigoCompania
	 * @param codigoReferenciaTipoTarea
	 * @return
	 * @throws SICException<>
	 */
	TareaDTO obtenerTareaPerfil(Long codigoProcesoLogistico, Integer codigoCompania, String codigoReferenciaTipoTarea) throws SICException;

	
}

