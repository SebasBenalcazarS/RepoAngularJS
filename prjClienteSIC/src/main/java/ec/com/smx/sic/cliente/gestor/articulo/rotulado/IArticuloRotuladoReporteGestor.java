package ec.com.smx.sic.cliente.gestor.articulo.rotulado;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloValorConfiguracionPlantillaDTO;

/**
 * 
 * @author acaiza
 *
 */

public interface IArticuloRotuladoReporteGestor {
	
	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloValorConfiguracionPlantillaDTO> obtenerReporteControlRotulado(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, Set<Integer> codigosPreguntas, Timestamp fechaInicio, Timestamp fechaFin) throws SICException;
	
}
