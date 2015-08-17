/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TipoTareaFuncionarioLogisticoDTO;

/**
 * @author wcaiza
 *
 */
public interface ITipoTareaFuncionarioLogisticoDAO extends Logeable {
	
	/**
	 * 
	 * @param tipoTareaFuncionarioLogisticoDTO
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	Boolean actualizarTipoTareaFuncionarioLogistico (TipoTareaFuncionarioLogisticoDTO tipoTareaFuncionarioLogisticoDTO, String codigoFuncionario) throws SICException;
	
	/**
	 * 
	 * @param tipoTareaFuncionarioLogisticoDTO
	 * @param colCodigoFuncionario
	 * @throws SICException
	 */
	void inactivarEstadoFuncionarioLogistico (TipoTareaFuncionarioLogisticoDTO tipoTareaFuncionarioLogisticoDTO, String ... colCodigoFuncionario) throws SICException;
	
}
