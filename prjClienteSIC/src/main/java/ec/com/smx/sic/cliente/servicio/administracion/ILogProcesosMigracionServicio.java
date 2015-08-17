/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.administracion;

import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.LogProcesosMigracionDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminLogsProcesosMigracionVO;


/**
 * @author jlcayo
 *
 */
public interface ILogProcesosMigracionServicio {

	/**
	 * 
	 * @param logsProcesosMigracionVO
	 * @param restrictions
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<LogProcesosMigracionDTO> buscarLogProcesosMigracion(AdminLogsProcesosMigracionVO logsProcesosMigracionVO, Map<String, Object> restrictions) throws SICException;

	/**
	 * 
	 * @param logsProcesoMigracionDTO
	 * @throws SICException
	 */
	public void crearLogProcesoMigracionTransaccional(LogProcesosMigracionDTO logsProcesoMigracionDTO) throws SICException;
	
	
}
