/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.bodega;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jdvasquez
 *
 */
public interface IConfiguracionesRecepcionServicio {
	/**
	 * Obtiene una coleccion de subbodegas filtradas por codigo de referencia
	 * @param codigoCompania
	 * @param codigoReferencia
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerSubbodegasPorCodigoReferencia(Integer codigoCompania, Integer codigoReferencia) throws SICException;
	/**
	 * Crea o actualiza un registro de configuracion de peso de recepcion por subbodega
	 * @param caracteristicaProcesoAreaTrabajoDTO
	 * @throws SICException
	 */
	public void guardarCaracteristicaConfiguracionPesoRecepcion(CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTO) throws SICException;

}
