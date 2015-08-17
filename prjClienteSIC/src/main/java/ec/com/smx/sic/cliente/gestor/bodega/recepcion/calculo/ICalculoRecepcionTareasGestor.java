/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TipoTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoTareaPerfilDTO;

/**
 * @author wcaiza
 *
 */
public interface ICalculoRecepcionTareasGestor {
	
	/**
	 * Buscar {@link TipoTareaPerfilDTO}
	 * @param codigoCompania
	 * @param codigoTipoEstadoTarea
	 * @param referenceCode
	 * @param codigoReferenciaTipoTarea
	 * @return
	 * @throws SICException
	 */
	TipoTareaPerfilDTO buscarTipoTareaPerfil (Integer codigoCompania, Integer codigoTipoEstadoTarea, String referenceCode, String codigoReferenciaTipoTarea) throws SICException;
	
	/**
	 * Busca el codigo Tipo Tarea para la tarea
	 * @param referenciaTipoTarea
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	TipoTareaDTO obtenerTipoTarea(String referenciaTipoTarea, Integer codigoCompania) throws SICException;

}
