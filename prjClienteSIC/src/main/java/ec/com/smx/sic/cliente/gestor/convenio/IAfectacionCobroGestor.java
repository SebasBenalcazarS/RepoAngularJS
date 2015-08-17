package ec.com.smx.sic.cliente.gestor.convenio;

import ec.com.smx.sic.cliente.mdl.dto.AfectacionCobroDTO;


/**
 * @author srodriguez
 * 2014-09-10
*/

@Deprecated
public interface IAfectacionCobroGestor {
		
	/**
	 *  Metodo que persiste una afectacion de cobor
	 * @author srodriguez
	 * 9/1/2015
	 * @param AfectacionCobroDTO
	 */
	void persistirAfectacionCobro(AfectacionCobroDTO afectacionCobroDTO);
}
