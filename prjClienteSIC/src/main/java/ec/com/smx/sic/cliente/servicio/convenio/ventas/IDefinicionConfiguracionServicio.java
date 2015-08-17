package ec.com.smx.sic.cliente.servicio.convenio.ventas;

import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.DefinicionConfiguracionDTO;

/**
 * @author srodriguez
 *
 */
public interface IDefinicionConfiguracionServicio {
	
	/**
	 * @author srodriguez
	 * @param definicionConfiguracionDTO
	 * @param companyId
	 * @param userId
	 */
	void transRegistarDefinicionConfiguracion(DefinicionConfiguracionDTO definicionConfiguracionDTO, Integer companyId, String userId);
	
	/**
	 * @author srodriguez
	 * @param codigoConfiguracion
	 * @param lote
	 * @return
	 */
	DefinicionConfiguracionDTO findDefinicionConfiguracionByConfiguracionLote(Long codigoConfiguracion, Integer lote);
	
	/**
	 * @author srodriguez
	 * @param codigoConfiguracion
	 * @return
	 */
	Collection<DefinicionConfiguracionDTO> findDefinicionConfiguracionByConfiguracion(Long codigoConfiguracion);
	
}
