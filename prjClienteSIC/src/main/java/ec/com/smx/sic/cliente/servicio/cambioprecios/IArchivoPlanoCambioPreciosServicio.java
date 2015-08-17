package ec.com.smx.sic.cliente.servicio.cambioprecios;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosArchivoPrecioArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;

/**
 * @author Luis Yacchirema
 * @author cjara
 * 
 */
public interface IArchivoPlanoCambioPreciosServicio extends Serializable {

	/**
	 * Obtiene los articulos del max que coincidan con los datos del archivo.
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
	 * Validar el archivo ingresado para ingresar cambios de precios
	 * 
	 * @param inputStreamArchCambioPrecio
	 * @return
	 * @throws SICException
	 */
	Map<String, Object> validacionArchivoCambioPrecio(InputStream inputStreamArchCambioPrecio) throws SICException;

	/**
	 * Generar la plantilla excel que se desea descargar
	 * 
	 * @return
	 * @throws SICException
	 */
	XSSFWorkbook generarPlantillaExcel() throws SICException;
}
