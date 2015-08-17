package ec.com.smx.sic.cliente.persistencia.administracion.dao;

import java.io.Serializable;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ResultadoProcesoDTO;

/**
 * 
 * @author jlcayo
 *
 */
public interface IResultadoProcesoDAO extends Logeable, Serializable {
	/**
	 * 
	 * @param logsProcesosMigracionVO
	 * @param componentesMap
	 * @return
	 */
	public ResultadoProcesoDTO buscarResultadoProceso(Integer codigoCompania, String codigoResultadoProceso) throws SICException;
	
}
