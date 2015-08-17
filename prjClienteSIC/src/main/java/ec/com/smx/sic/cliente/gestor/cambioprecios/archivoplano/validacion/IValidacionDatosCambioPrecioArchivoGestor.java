/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.cambioprecios.archivoplano.validacion;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ec.com.smx.sic.cliente.exception.SICException;


/**
 * @author cjara
 *
 */
public interface IValidacionDatosCambioPrecioArchivoGestor extends Serializable {
	
	/**
	 * Llama al procesar la cabecera, procesa las filas del archivo y genera archivo con errores encontrados
	 * 
	 * @param inputStreamArchCambioPrecio
	 * @return
	 * @throws SICException
	 */
	Map<String, Object> validacionArchivoCambioPrecio(InputStream inputStreamArchCambioPrecio) throws SICException;
	
	/**
	 * Generar la plantilla excel que se desea descargar
	 * 
	 * @param errorContenido
	 * @param listaDatosArchivoPrecioArticulo
	 * @return
	 * @throws SICException
	 */
	XSSFWorkbook generarPlantillaExcel() throws SICException;
}
