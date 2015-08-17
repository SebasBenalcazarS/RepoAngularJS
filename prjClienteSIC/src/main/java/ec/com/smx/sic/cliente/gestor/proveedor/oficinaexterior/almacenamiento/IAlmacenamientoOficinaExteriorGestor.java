/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.oficinaexterior.almacenamiento;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.OficinaExteriorVO;

/**
 * @author Mario Braganza
 *
 */
public interface IAlmacenamientoOficinaExteriorGestor extends Serializable {

	/**
	 * 
	 * @param oficinaExteriorVO
	 * @throws SICException
	 */
	public void registrarOficinaExterior(OficinaExteriorVO oficinaExteriorVO) throws SICException;
	
}
