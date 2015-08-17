package ec.com.smx.sic.cliente.servicio.convenio;

import ec.com.smx.sic.cliente.mdl.dto.AfectacionCobroDTO;

/**
 * @author srodriguez
 * 2014-09-10
*/
@Deprecated
public interface IAfectacionCobroServicio {
	
	/**
	 * 
	 * @param AfectacionCobroDTO
	 * @return
	 * @throws SICException
	 */
	void transPersistirAfectacionCobro(AfectacionCobroDTO afectacionCobroDTO);

}
