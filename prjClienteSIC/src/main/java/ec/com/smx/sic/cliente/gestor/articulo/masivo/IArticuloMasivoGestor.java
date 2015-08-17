/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.masivo;

import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import ec.com.smx.sic.cliente.common.articulo.EnumCaracteristicaDinamica;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author eharo
 *
 */
public interface IArticuloMasivoGestor {

	/**
	 * METODO QUE CREA UN MAPA CON LA CLASIFICACION Y LAS CARACTERISTICAS DINAMICAS DE ESTA
	 * @param codigoCompania
	 * @param listaClasificaciones
	 * @param codigosCaracteristicasDinamicas
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public Map<String, Set<EnumCaracteristicaDinamica>> obtenerMapaClasificacionCarDin(Integer codigoCompania, Set<String> listaClasificaciones, Collection<Integer> codigosCaracteristicasDinamicas) throws SICException;
	
	/**
	 * METODO QUE OBTIENE EL NUMERO DE FILAS INGRESADO EN UN ARCHIVO EXCEL
	 * @param inputStreamArchivo
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public Integer obtenerTamanioFilasArchivoExcel(final InputStream inputStreamArchivo) throws SICException;
}
