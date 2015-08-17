/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;

/**
 * @author jdvasquez
 *
 */
public interface IValidacionRecepcionDatosTareaGestor {

	/**
	 * 
	 * @param controlRecipienteTaraDetallesCol
	 * @param usuarioRegistro
	 * @param codigoDatosTarea
	 * @throws SICException
	 */
	public void crearRelacionDatosTareaDetalleRecipiente(Collection<ControlRecipienteTaraDetalleDTO> controlRecipienteTaraDetallesCol, String usuarioRegistro, Long codigoDatosTarea) throws SICException;

	/**
	 * 
	 * @param controlRecipienteTaraDetallesCol
	 * @param usuarioRegistro
	 * @throws SICException
	 */
	public void crearControlDetalleRecipienteTara(Collection<ControlRecipienteTaraDetalleDTO> controlRecipienteTaraDetallesCol, String usuarioRegistro) throws SICException;

}
