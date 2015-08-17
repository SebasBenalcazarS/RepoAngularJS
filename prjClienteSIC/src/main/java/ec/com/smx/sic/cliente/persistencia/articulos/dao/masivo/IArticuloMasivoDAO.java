/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.dao.masivo;

import java.util.Collection;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDinamicaDTO;

/**
 * @author eharo
 *
 */
public interface IArticuloMasivoDAO {

	
	/**
	 * METODO QUE CONSULTA LA LISTA DE CARACTERISTICAS DINAMICAS DE LA COLECCION Y EL TIPODECARACTERISTICA REQUERIDA
	 * @param codigoCompania
	 * @param codigoClasificacion
	 * @param codigosCaracteristicasDinamicas
	 * @return
	 * @throws SICException
	 */
	public Collection<CaracteristicaDinamicaDTO> obtenerCaracteristiacasDinamicas(Integer codigoCompania, Set<String> codigosClasificaciones, Collection<Integer> codigosCaracteristicasDinamicas) throws SICException;
}
