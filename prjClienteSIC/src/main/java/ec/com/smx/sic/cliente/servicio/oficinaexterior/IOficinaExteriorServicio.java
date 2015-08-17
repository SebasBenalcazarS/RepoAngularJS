/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.oficinaexterior;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.DatosRegistroOficinaExteriorVO;

/**
 * @author Mario Braganza
 *
 */
public interface IOficinaExteriorServicio extends Serializable {
	
	/**
	 * 
	 * @param datosRegistroOficinaExteriorVO
	 * @throws SICException
	 */
	public void registrarOficinaExterior(DatosRegistroOficinaExteriorVO datosRegistroOficinaExteriorVO) throws SICException;

}
