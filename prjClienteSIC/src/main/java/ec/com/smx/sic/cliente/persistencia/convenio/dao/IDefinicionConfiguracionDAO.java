package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.DefinicionConfiguracionDTO;

/**
 * @author srodriguez 
 * 2014-11-29
 */
public interface IDefinicionConfiguracionDAO {
	
	/**
	 * @author srodriguez
	 * @param definicionConfiguracionDTO
	 * @param companyId
	 * @param userId
	 */
	void registarDefinicionConfiguracion(DefinicionConfiguracionDTO definicionConfiguracionDTO, Integer companyId, String userId);
	
	/**
	 * @author srodriguez
	 * @param codigoConfiguracion
	 * @param lote
	 * @return DefinicionConfiguracionDTO
	 */
	DefinicionConfiguracionDTO findDefinicionConfiguracionByConfiguracionLote(Long codigoConfiguracion, Integer lote);
	
	/**
	 * @author srodriguez
	 * @param codigoConfiguracion
	 * @return Collection<DefinicionConfiguracionDTO>
	 */
	Collection<DefinicionConfiguracionDTO> findDefinicionConfiguracionByConfiguracion(Long codigoConfiguracion);
}
