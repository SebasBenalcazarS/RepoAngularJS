/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.admin.validacion;

import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author eharo
 *
 */
public interface IValidacionArticuloCreacionPorArchivoGestor {

	
	/**
	 * METODO QUE PERMITE PROCESAR EL ARCHIVO CON LOS DATOS PARA LA CREACION DE LOS ARTICULOS A TRAVES DE UN
	 * ARCHIVO EXCEL
	 * @param articuloVOPlantillaValores
	 * @param inputStreamArchivo
	 * @param tipoCabecera
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> procesarArchivoArticulo(ArticuloVO articuloVOPlantillaValores, InputStream inputStreamArchivo, Integer tipoCabecera) throws SICException;
	/**
	 * METODO QUE PERMITE OBTENER LAS CABECERAS DEL ARCHVIO DE ACUERDO AL DEPARTAMENTO ESCOGIDO
	 * @param wb
	 * @param sheet
	 * @throws SICException
	 * @author eharo
	 * @autor aecaiza
	 */
	public  void obtenerCabeceraArchivo(XSSFWorkbook wb, XSSFSheet sheet, Integer tipoCabecera) throws SICException;
	
	/**
	 * METODO PARA GENERAR EL EXCEL CON LOS ERRORES
	 * @param articuloVO
	 * @param observaciones
	 * @param rowIteratorArchivo
	 * @param numeroColumnas
	 * @param lstCatalogoValor
	 * @throws SICException
	 * @author eharo
	 */
	public void generarExcelConErrores(ArticuloVO articuloVO, List<String> observaciones,
			Iterator<Row> rowIteratorArchivo, int numeroColumnas, Collection<CatalogoValorDTO> lstCatalogoValor) throws SICException;
	
	
	/**
	 * @param fechaInicio
	 * @param fechaFinal
	 * @param cabecerasMapa
	 * @param nombreCatalogoValor
	 * @param numeroFila
	 * @param numeroColumna
	 * @param observaciones
	 * @param esFilaValida
	 * @return
	 */
	public String validacionesFechaInicioFinTemporada(String fechaInicio, String fechaFinal, Map<String, String> cabecerasMapa, String nombreCatalogoValor, Integer numeroFila, Integer numeroColumna, List<String> observaciones, boolean esFilaValida []) throws SICException;
	
	
	/**
	 * METODO QUE PERMITE AGRUPAR LOS DATOS VALIDOS EN UN MAPA PARA LA CREACION
	 * @param datosValidados
	 * @param numeroFila
	 * @param esFilaValida
	 * @param lstCabecerasCatalogoValorDTO
	 * @return
	 * @throws SICException
	 */
	public MultiKeyMap agruparDatosMapaValidados(MultiKeyMap datosValidados, Integer numeroFila, boolean esFilaValida, Collection<CatalogoValorDTO> lstCabecerasCatalogoValorDTO) throws SICException;
	
}
