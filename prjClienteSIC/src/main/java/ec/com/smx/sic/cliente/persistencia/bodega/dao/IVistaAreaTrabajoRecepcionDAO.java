/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaAreaTrabajoRecepcionDTO;

/**
 * @author wcaiza
 *
 */
public interface IVistaAreaTrabajoRecepcionDAO {
	
	/**
	 * Obtener las areas de trabajo donde hay recepciones configuradas
	 * @param codigoCompania
	 * @param fechaRecepcion
	 * @param colEstadoProcesoLogisticoExcluir
	 * @return
	 * @throws SICException
	 */
	Collection<VistaAreaTrabajoRecepcionDTO> obtenerVistaAreaTrabajoRecepcion(Integer codigoCompania, Date fechaRecepcion, Collection<String> colEstadoProcesoLogisticoExcluir) throws SICException;

}
