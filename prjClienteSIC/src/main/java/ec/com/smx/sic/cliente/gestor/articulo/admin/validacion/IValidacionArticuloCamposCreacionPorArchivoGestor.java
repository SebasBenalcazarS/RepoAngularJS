/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.admin.validacion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.poi.ss.usermodel.Cell;

import ec.com.smx.sic.cliente.common.articulo.EnumCaracteristicaDinamica;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author eharo
 *
 */
public interface IValidacionArticuloCamposCreacionPorArchivoGestor {

	
	public String validacionesProveedor(Cell celdaExcel, List<String> observaciones, List<HashMap<String, LinkedList<String>>> listaProveedores, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, String[] condicionesProveedor, boolean esFilaValida [], String codigoCabecera) throws SICException;
	
//	public String validacionesClasificacion(Cell celdaExcel, List<String> observaciones, Set<String> listaClasificaciones, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, boolean esFilaValida [], String codigoFuncionario, String codigoCabecera, String [] condicionesClasificacion) throws SICException;
	
	public String validacionesClasificacion(Cell celdaExcel, List<String> observaciones, List<HashMap<String, LinkedList<String>>> listaClasificaciones, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, boolean esFilaValida [], String codigoFuncionario, String codigoCabecera, String [] condicionesClasificacion) throws SICException;
	
//	public String validacionesSubClasificacion(Cell celdaExcel, List<String> observaciones, String clasificacion, Integer numeroFila, Integer numeroColumna, Set<String> listaSubClasificaciones, Integer codigoCompania, boolean esFilaValida []) throws SICException;
	
	public String validacionesSubClasificacion(Cell celdaExcel, List<String> observaciones, String clasificacion, Integer numeroFila, Integer numeroColumna, List<MultiKeyMap> listaSubClasificaciones, Integer codigoCompania, boolean esFilaValida [], String codigoCabecera) throws SICException;
	
	public String validacionesCodigoBarras(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, Set<String> listaCodigosBarras, boolean esFilaValida []) throws SICException;
	
	public String validacionesDescripcion(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida []) throws SICException;
	
	public String validacionesClase(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, Set<String> listaClaseArticulos, Integer codigoCompania, boolean esFilaValida [], String codigoCabecera, Boolean esCreacion) throws SICException;
	
	public String validacionesFechaInicioFinTemporada(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFechaInicio, boolean esFilaValida [], Map<String, String> codigosCabeceras) throws SICException;
	
	public String validacionesUnidadManejo(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String empaque, String codigoCabecera) throws SICException;
	
	public String validacionesEAN14(Cell celdaExcel, List<String> observaciones, String codigoBarras, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, Set<String> listaCodigosEAN14, boolean esFilaValida []) throws SICException;
	
	public String validacionesCostoMonedaOrigen(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, String origenProveedor, String proveedorImportador, boolean esFilaValida [], LinkedList<String> codigosCabeceras) throws SICException;
	
	public String validacionesTamanio(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera) throws SICException;
	
	public String validacionesMarca(Cell celdaExcel, List<MultiKeyMap> listaMarcas, List<String> observaciones, Integer codigoCompania, Integer numeroFila, Integer numeroColumna, String codigoProveedor, boolean esFilaValida [], LinkedList<String> codigosCabeceras) throws SICException;
	
	public String validacionesMarcaParticipacion(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida []) throws SICException;
	
	public String validacionesGarantia(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera) throws SICException;
	
	public String validacionesReferencia(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida []) throws SICException;
	
	public String validacionesReferenciaInterna(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida []) throws SICException;
	
	public String validacionesAlcancePrototipo(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaAlcancePrototipo, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, boolean esFilaValida [], String codigoCabecera , boolean validacionesAlcancePrototipo) throws SICException;
	
	public String validacionesAgrupador(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaAgrupadores, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera) throws SICException;
	
	public String validacionesCostoBruto(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales) throws SICException;
	
	public String validacionesDescuentos(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales) throws SICException;
	
	public String validacionesPrecios(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales) throws SICException;
	
	public String validacionesMedidas(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales, String codigoCabecera) throws SICException;
	
	public String validacionesEmpaque(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaEmpaques, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera) throws SICException;
	
	public String validacionesImportancia(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaImportancias, Integer codigoCompania, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera) throws SICException;
	
	public String validacionesPlazoPago(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaPlazosPagos, Integer codigoCompania, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera) throws SICException;
	
	public String validacionesUnidadMedida(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaUnidadMedida, Integer numeroFila, Integer numeroColumna, String nombreCampo, String [] condicionesUnidadMedida, boolean esFilaValida []) throws SICException;
	
	public String validacionesVentaPrecioAfiliado(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, String parametroIngresoDatos, boolean esFilaValida []) throws SICException;
	
	public String validacionesControlPrecios(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaControlPrecios, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String tipoSecuencia, String codigoCabecera) throws SICException;
	
	public String validacionesDuracionConservacion(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales) throws SICException;
	
	/**
	 * Valida si el lugar de compra ingresado en una celda de excel, es correcto
	 * @author bcueva
	 * @param celdaExcel Instancia de una celda en Excel
	 * @param observaciones Lista con las observaciones de los errores en el documento de excel
	 * @param listaLugaresCompra 
	 * @param codigoCompania C\u00F3digo de la compan\u00EDa
	 * @param numeroFila N\u00FAmero de la fila que se esta valida
	 * @param numeroColumna N\u00FAmero de la columna
	 * @param esFilaValida Bandera para validar si el valor de la celda es v\u00E1lido
	 * @param codigoCabecera C\u00F3digo de la cabecera
	 * @param codigoDivGeoPol C\u00F3digo de la divicion politica
	 * @return
	 * @throws SICException
	 */
	String validacionesLugarCompra(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaLugaresCompra, Integer codigoCompania, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera, String codigoDivGeoPol) throws SICException;
	
	public String validacionesPaisOrigen(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaPaisOrigen, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera) throws SICException;
	
	public String validacionesPesoAproximado(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales, String controlPrecio, String codigoCabecera) throws SICException;
	
	public String validacionesPresentacion(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales) throws SICException;
	
	public String validacionesTransgenico(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaTransgenicos, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera) throws SICException;
	
	public String validacionesUsos(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaUsos, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida []) throws SICException;
	
	public String validacionesRegistroSanitario(String celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida []) throws SICException;
	
	public String validacionesTipoSecuncia(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaTipoSecuencias, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera) throws SICException;
	
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
	
	public String indiceAlfabeticoColumna(int indiceColumna) throws SICException;
	
	public void agregarEsFilaValida(boolean esFilaValida[], boolean esValido) throws SICException;
	
	public Boolean validarCaracteristicaDinamica(String campo, Integer numeroFila, Integer numeroColumna, String cabecera, EnumCaracteristicaDinamica caracteristicaDinamica, List<String> observaciones, boolean esFilaValida []) throws SICException;
}