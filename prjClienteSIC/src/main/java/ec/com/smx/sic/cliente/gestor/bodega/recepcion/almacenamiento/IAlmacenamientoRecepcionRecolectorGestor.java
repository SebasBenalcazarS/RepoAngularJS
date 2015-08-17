package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaTareaDatosTareaDTO;

public interface IAlmacenamientoRecepcionRecolectorGestor {

	/**
	 * Actualiza el estado de la tarea asignanando el usuario de la tarea
	 * 
	 * @param listaDatosTareaRecolector Datos de la tarea del recolector
	 * @param funcionarioSublugarTrabajoRelacionadoDTO funcionario al q se le asigna la tarea
	 * @param codigoPerfil
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void asignarTareaRecolector(Collection<DatosTareaDTO> listaDatosTareaRecolector , FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) throws SICException;
	
	/**
	 * Cambia el estado de la tarea del recolector
	 * 
	 * @param datosTareaDTO tarea del recolector
	 * @param catalogoEstadoTarea estado de la tarea a actualizar
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	TareaDTO cambiarEstadoTarea(DatosTareaDTO datosTareaDTO, CatalogoValorDTO  catalogoEstadoTarea) throws SICException;
	
	/**
	 * Cambiar el estado de la tarea si el estado de la misma es igual a asignada
	 * @param vistaDatosTareaDTO
	 * @param datosTarea
	 * @param catalogoEstadoTarea
	 * @return
	 * @throws SICException
	 */
	DatosTareaDTO cambiarEstadoTareaAsignada(VistaTareaDatosTareaDTO vistaDatosTareaDTO, DatosTareaDTO datosTarea, CatalogoValorDTO  catalogoEstadoTarea) throws SICException; 
	
	/**
	 * Finaliza la tarea del recolector, manda a crear la tarea del montacarguista, actualiza la cantidad en asignaci&oacute;n art&iacute;culo unidad manejo
	 * y cambia de estado al pallet
	 * @param datosTareaDTO Pallet actual
	 * @param actualizarAsignacionArtUniMan TRUE: D&eacute;je en ubicaci&oacute;n FALSE: D&eacute;je en pasillo 
	 * @param funcionarioSubTraRel
	 */
	void finalizarTareaRecolector(DatosTareaDTO datosTareaDTO, Boolean actualizarAsignacionArtUniMan, FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO)throws SICException;

	/**
	 * Cambiar en estado del pallet de En proceso a balanza
	 * @param pallet
	 */
	void cambiarEstadoPalletEnBalanza(DatosTareaDTO pallet) throws SICException;
	
	/**
	 * Cambiar estado del pallet que este en AND o PES
	 * @param listaPallets
	 * @param userId
	 * @throws SICException
	 */
	void cambiarEstadoPalletEnProceso(Collection<DatosTareaDTO> listaPallets, String userId) throws SICException;
	
	/**
	 * Liberar un anden.
	 * @author Yuniesky Armentero Moreno
	 * @param funcionario
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	int liberarAnden(FuncionarioProcesoPerfilAreaTrabajoDTO funcionario, String anden) throws SICException;
	
	/**
	 * Liberar un anden.
	 * @author Yuniesky Armentero Moreno
	 * @param recepcionProveedor
	 * @return
	 * @throws SICException
	 */
	int liberarAnden(RecepcionProveedorDTO recepcionProveedor) throws SICException;
	
	/**
	 * Liberar un anden.
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param vistasProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	int liberarAnden(Integer codigoCompania, Collection<VistaProcesoLogisticoDTO> vistasProcesoLogistico) throws SICException;
}