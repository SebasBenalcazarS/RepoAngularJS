/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.despacho.almacenamiento;

import ec.com.smx.corpv2.dto.ParametrosSubbodegaDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jdvasquez
 *
 */
public interface IAlmacenamientoParametrosDespachoGestor {
	/**
	 * Crea o actualiza un parametro de de cubicaje por subbodega
	 * @param parametroSubbodegaDTO
	 * @throws SICException
	 */
	public void actualizarParametroSubbodega(ParametrosSubbodegaDTO parametroSubbodegaDTO) throws SICException;

}
