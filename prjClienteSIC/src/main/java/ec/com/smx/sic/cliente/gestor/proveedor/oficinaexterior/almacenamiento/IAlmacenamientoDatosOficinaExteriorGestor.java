/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.oficinaexterior.almacenamiento;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.DatosRegistroOficinaExteriorVO;

/**
 * @author Mario Braganza
 *
 */
public interface IAlmacenamientoDatosOficinaExteriorGestor extends Serializable {
	
	
	/**
	 * 
	 * @param datosRegistroOficinaExteriorVO
	 * @throws SICException
	 */
	void registrarOficinaExterior(
			DatosRegistroOficinaExteriorVO datosRegistroOficinaExteriorVO)
			throws SICException;
}
