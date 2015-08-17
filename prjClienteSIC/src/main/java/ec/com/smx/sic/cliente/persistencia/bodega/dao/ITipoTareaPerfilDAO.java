/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TipoTareaPerfilDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaPerfilMonitorRecolectorDTO;

/**
 * @author wcaiza
 *
 */
public interface ITipoTareaPerfilDAO {

	/**
	 * 
	 * @param tipoTareaPerfilPlantilla
	 * @param referenceCode
	 *            Del perfil del usuario
	 * @param codigoReferencia
	 *            Tipo de tarea del usuario (recibir proveedor, ingresar pallet
	 *            anden, receso, etc...)
	 * @return
	 * @throws SICException
	 */
	TipoTareaPerfilDTO obtenerTipoTareaPerfilPorTipoTarea(TipoTareaPerfilDTO tipoTareaPerfilPlantilla, String referenceCode, String codigoReferencia) throws SICException;


	/**
	 * 
	 * @param codigoCompania
	 * @param codigoReferenciaTipoTarea
	 * @return
	 * @throws SICException
	 */
	Collection<VistaPerfilMonitorRecolectorDTO> obtenerTipoProcesoPorCodigoRef(Integer codigoCompania, Collection<String> codigoReferenciaTipoTarea) throws SICException;

}
