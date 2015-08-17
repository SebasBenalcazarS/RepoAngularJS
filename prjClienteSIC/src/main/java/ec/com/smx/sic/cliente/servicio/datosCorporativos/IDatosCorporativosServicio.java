/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.datosCorporativos;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDinamicaDTO;

/**
 * @author fvillacres
 *
 */
public interface IDatosCorporativosServicio {
	
	/**
	 * Guarda registros de caracteristicas din&aacute;mamicas
	 * @param caracteristicaDinamicaCol lista de caracter&iacute;sticas din&aacute;mamicas
	 */
	Collection<CaracteristicaDinamicaDTO> registrarCaracteristicasDinamicas (Collection<CaracteristicaDinamicaDTO> caracteristicaDinamicaCol) throws SICException;
	
}
