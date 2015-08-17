/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jdvasquez
 *
 */
public interface IAlmacenamientoConfiguracionesRecepcionGestor {
	/**
	 * Guarda un registro de caracteristica valor de peso por subbodega
	 * @param caracteristicaProcesoAreaTrabajoDTO
	 * @throws SICException
	 */
	public void guardarCaracteristicaConfiguracionPesoRecepcion(CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTO) throws SICException;

}
