/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.procesamientoventas.ventas;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.procesamientoventas.MigrarDatosProcesoVentaDTO;

/**
 * @author vjaramillo
 *
 */
public interface IAlmacenamientoProcesamientoVentasGestor extends Serializable {


	/**
	 * Metodo para procesar todos los articulos recibido del archivo FTP
	 * @param codigoCompania
	 * @param namefile
	 * @param fechaEjecucion
	 * @param listaDatosArchivoFTP
	 * @throws SICException
	 * @throws ParseException
	 */
	void registrarArticulosMigracion(Integer codigoCompania, String namefile, Date fechaEjecucion, List<? extends MigrarDatosProcesoVentaDTO> listaDatosArchivoFTP) throws SICException, ParseException;
}
