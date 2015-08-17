/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.admin.edicion;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.poi.ss.usermodel.Cell;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author eharo
 *
 */
public interface IValidacionArticuloCamposEdicionArchivoGestor {

	
	/**
	 * @param celdaExcel
	 * @param observaciones
	 * @param numeroFila
	 * @param numeroColumna
	 * @param codigoCompania
	 * @param listaCodigosBarras
	 * @param esFilaValida
	 * @param codigosCabeceras
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public String validacionesCodigoBarras(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, String codigoFuncionario, Set<String> listaCodigosBarras, boolean esFilaValida [], Map<String, String> codigosCabeceras, String claseArticulo) throws SICException;
	
	/**
	 * @param celdaExcel
	 * @param observaciones
	 * @param numeroFila
	 * @param numeroColumna
	 * @param codigoCompania
	 * @param listaClases
	 * @param esFilaValida
	 * @param codigosCabeceras
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public String validacionesClase(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, Set<String> listaClases, boolean esFilaValida [], Map<String, String> codigosCabeceras) throws SICException;
	
	/**
	 * @param celdaExcel
	 * @param observaciones
	 * @param numeroFila
	 * @param numeroColumna
	 * @param esFechaInicio
	 * @param esFilaValida
	 * @param codigosCabeceras
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public String validacionesFechaInicioFinTemporada(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFechaInicio, boolean esFilaValida [], Map<String, String> codigosCabeceras) throws SICException;
	
	/**
	 * Metodo que retorna un string con el valor de la celda de acuerdo al formato
	 * @param celda
	 * @return
	 * @author eharo
	 */
	public String obtenerValorCeldaString(Cell celda) throws SICException;
	
	/**
	 * Metodo que permite quitar los 0 decimales de las celdas
	 * @param cellValue
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public String parsearValor(String cellValue) throws SICException;
	
	
	/**
	 * @param esFilaValida
	 * @param esValido
	 * @throws SICException
	 * @author eharo
	 */
	public void agregarEsFilaValida(boolean esFilaValida[], boolean esValido) throws SICException;
	
	
	/**
	 * Metodo que permite validar la clase O, la clase I y la clase E
	 * @param celdaExcel
	 * @param observaciones
	 * @param numeroFila
	 * @param numeroColumna
	 * @param esFilaValida
	 * @param codigosCabeceras
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public String validacionesCausal(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, String clase, boolean esFilaValida [], List<MultiKeyMap> listaCausales, Map<String, String> codigosCabeceras) throws SICException;
}
