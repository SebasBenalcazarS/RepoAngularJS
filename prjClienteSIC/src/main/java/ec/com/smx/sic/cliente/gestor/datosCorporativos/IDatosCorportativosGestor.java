/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.datosCorporativos;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDinamicaDTO;

/**
 * @author fvillacres
 *
 */
public interface IDatosCorportativosGestor {
	Collection<CaracteristicaDinamicaDTO> registrarCaracteristicasDinamicas(Collection<CaracteristicaDinamicaDTO> caracteristicaDinamicaCol) throws SICException;
}
