/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jdvasquez
 *
 */
public interface ICalculoConfiguracionesRecepcionGestor {
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoReferencia
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerSubbodegasPorCodigoReferencia(Integer codigoCompania, Integer codigoReferencia) throws SICException;

}
