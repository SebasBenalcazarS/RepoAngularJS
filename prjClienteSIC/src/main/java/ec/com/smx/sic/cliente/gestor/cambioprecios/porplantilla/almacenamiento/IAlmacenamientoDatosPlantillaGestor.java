/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.cambioprecios.porplantilla.almacenamiento;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;

/**
 * @author gnolivos
 *
 */
public interface IAlmacenamientoDatosPlantillaGestor extends Serializable{
	
	/**
	 * @param gestionPrecioRegistro
	 * @throws SICException
	 */
	void registrarDatosPlantilla(GestionPrecioDTO gestionPrecioRegistro) throws SICException;

}
