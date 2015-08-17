/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.cambioprecios.archivoplano.calculo;

import java.io.Serializable;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosArchivoPrecioArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;

/**
 * @author cjara
 *
 */
public interface ICalculoDatosCambioPrecioArchivoGestor extends Serializable {

	/**
	 * Consulta los articulos existentes en el archivo por grupos
	 * 
	 * @param datosArchivoPrecioArticulo
	 * @param codigoProveedor
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloGestionPrecioDTO> obtenerArticulosPorDatosArchivo(Collection<DatosArchivoPrecioArticulo> datosArchivoPrecioArticulo, 
			String codigoProveedor, Integer codigoCompania, String codigoFuncionario) throws SICException;
	
	/**
	 * Genera la plantilla del archivo excel que se desea descargar, ya sea archivo con datos o sin datos
	 * 
	 * @param errorContenido
	 * @param listaDatosArchivoPrecioArticulo
	 * @return
	 * @throws SICException
	 */
	XSSFWorkbook generarPlantillaExcel(String[][] errorContenido, Collection<DatosArchivoPrecioArticulo> listaDatosArchivoPrecioArticulo) throws SICException;
}
