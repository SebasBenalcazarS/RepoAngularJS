package ec.com.smx.sic.cliente.persistencia.administracion.dao;

import java.io.Serializable;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.LogProcesosMigracionDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminLogsProcesosMigracionVO;

/**
 * 
 * @author jlcayo
 *
 */
public interface ILogProcesosMigracionDAO extends Logeable, Serializable {
	/**
	 * 
	 * @param logsProcesosMigracionVO
	 * @param componentesMap
	 * @return
	 */
	public SearchResultDTO<LogProcesosMigracionDTO> buscarLogProcesosMigracion(AdminLogsProcesosMigracionVO logsProcesosMigracionVO, Map<String, Object> componentesMap) throws SICException;
	/**
	 * 
	 * @param logsProcesosMigracionVO
	 * @param restrictions
	 * @return
	 */
	public Long contarLogs(AdminLogsProcesosMigracionVO logsProcesosMigracionVO, Map<String, Object> restrictions);
	
}
