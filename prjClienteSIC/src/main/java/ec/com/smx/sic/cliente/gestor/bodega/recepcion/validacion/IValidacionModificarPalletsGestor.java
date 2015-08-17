/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import ec.com.smx.autorizaciones.dto.AutorizacionDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaPalletsRecepcionPesoDTO;

/**
 * @author jdvasquez
 *
 */
public interface IValidacionModificarPalletsGestor {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoDatosTarea
	 * @param codigoEstadoTarea
	 * @param estadosTarea
	 * @param codigoTipoControlCosto
	 * @param valorTipoControlCosto
	 * @throws SICException
	 */
	public void obtenerTareaAsignadaORegistradaPalletPeso(Integer codigoCompania, Long codigoDatosTarea, Integer codigoEstadoTarea, String[] estadosTarea, Integer codigoTipoControlCosto, String valorTipoControlCosto) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param pallet
	 * @param tarea
	 * @param datosTareaAutorizacionDTO
	 * @param codigoRecepcionProveedor
	 * @param palletPesado
	 * @throws SICException
	 */
	public void encerarPalletRecepcion(Integer codigoCompania, String userId, VistaPalletsRecepcionPesoDTO pallet, TareaDTO tarea, AutorizacionDTO autorizacion, Long codigoRecepcionProveedor) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param pallet
	 * @param autorizacion
	 * @param codigoRecepcionProveedor
	 * @throws SICException
	 */
	public void cancelarPalletsRecepcion(Integer codigoCompania, String userId, VistaPalletsRecepcionPesoDTO pallet, AutorizacionDTO autorizacion, Long codigoRecepcionProveedor) throws SICException;

}
