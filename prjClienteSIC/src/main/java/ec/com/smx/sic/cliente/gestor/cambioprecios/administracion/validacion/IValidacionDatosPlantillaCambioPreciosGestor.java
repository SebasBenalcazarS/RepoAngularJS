/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.validacion;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author gnolivos
 *
 */
public interface IValidacionDatosPlantillaCambioPreciosGestor extends Serializable{
	
	/**
	 * Verifica si el codigo de la plantilla exista en la base de datos
	 * 
	 * @param codigoCompania
	 * @param codigoPlantilla
	 * @return
	 * @throws SICException
	 */
	Boolean validarCodigoPlantilla(Integer codigoCompania, String codigoPlantilla) throws SICException;
}
