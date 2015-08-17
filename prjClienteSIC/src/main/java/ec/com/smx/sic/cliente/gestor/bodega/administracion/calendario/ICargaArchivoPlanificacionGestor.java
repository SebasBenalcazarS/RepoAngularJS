/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.administracion.calendario;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author 
 *
 */
public interface ICargaArchivoPlanificacionGestor {
	
	/**
	 * Procesar el archivo con la planificaci&oacute;n para la rececpci&oacute;n de bodegas
	 * @param codigoCompania
	 * @throws SICException
	 */
	void procesarArchivoPlanificacionBodega (Integer codigoCompania) throws SICException;

}
