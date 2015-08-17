package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;


/**
 * 
 * @author lguaman
 *
 */
public interface IAlmacenamientoMaquinaEstadosRecepcionGestor { 

	/**
	 * Cambia el estado de la tarea finalizando el estado anterior
	 * @param tareaDTO Un TareaDTO
	 * @param accionTarea Un CatalogValorDTO de la accion para cambiar al siguiente estado
	 * @param actualizarEstadoTarea Un Boolean para actualizar el estado actual en el TareaDTO
	 * @return Un TareaDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public TareaDTO cambiarEstadoTarea(TareaDTO tareaDTO, CatalogoValorDTO accionTarea, Boolean actualizarEstadoTarea) throws SICException;
	
	/**
	 * Cambia el estado del proceso logistico finalizando el estado anterior
	 * 
	 * @param procesoLogisticoDTO
	 * @param accionProcesoLogistico
	 * @return Un ProcesoLogisticoDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public ProcesoLogisticoDTO cambiarEstadoProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO, CatalogoValorDTO accionProcesoLogistico) throws SICException;

	/**
	 * Cambia el estado de datos tarea finalizando el estado anterior
	 * 
	 * @param accionDatosTarea
	 * @param datosTareaDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<DatosTareaDTO> cambiarEstadoDatosTarea(CatalogoValorDTO accionDatosTarea, Collection<DatosTareaDTO> listaDatosTareaDTO) throws SICException;

	/**
	 * Crear el estado inicial del pallet en anden
	 * 
	 * @param datosTareaDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public DatosTareaDTO crearEstadoInicialDatosTarea(DatosTareaDTO datosTareaDTO);

	/**
	 * Consulta el estado actual del proceso logistico
	 * @param procesoLogisticoDTO
	 * @return
	 * @throws SICException
	 */
	public ProcesoLogisticoEstadoDTO consultarEstadoActualProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;	
}
