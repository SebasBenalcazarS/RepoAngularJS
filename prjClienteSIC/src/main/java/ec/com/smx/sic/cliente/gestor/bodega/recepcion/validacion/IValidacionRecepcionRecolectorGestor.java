package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;

public interface IValidacionRecepcionRecolectorGestor {

	/**
	 * Validacion de los campos obligatorios para obtener valores de datos de una tarea(palet)
	 * @param codigoBarrasPalet
	 * @throws SICException
	 */
	void obtenerTareasDeRecolector(String codigoBarrasPalet) throws SICException;
	
	/**
	 * Validacion de los campos obligatorios para obtener la asignacion de la unidad de manejo de un articulo
	 * @param listOrdenCompraDetalleEstadoDTOs
	 * @throws SICException
	 */
	void obtenerAsignacionUnidadManejo(Collection<OrdenCompraDetalleEstadoDTO> listOrdenCompraDetalleEstadoDTOs) throws SICException;
	
	/**
	 * Validacion de los campos obligatorios para asignar las tareas al recolector
	 * @param listaDatosTareaRecolector
	 * @param funcionarioSublugarTrabajoRelacionadoDTO
	 * @throws SICException
	 */
	void asignarTareaRecolector(Collection<DatosTareaDTO> listaDatosTareaRecolector , FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) throws SICException;
	
	/**
	 * Validacion de los campos obligatorios cambiar el estado de una tarea
	 * @param datosTareaDTO
	 * @param catalogoEstadoTarea
	 * @throws SICException
	 */
	void cambiarEstadoTarea(DatosTareaDTO datosTareaDTO, CatalogoValorDTO catalogoEstadoTarea) throws SICException;
	
	
}