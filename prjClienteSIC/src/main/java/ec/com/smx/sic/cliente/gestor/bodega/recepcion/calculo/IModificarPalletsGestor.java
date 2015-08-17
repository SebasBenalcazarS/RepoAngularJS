/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.autorizaciones.dto.AutorizacionDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaPalletsRecepcionPesoDTO;

/**
 * @author jdvasquez
 *
 */
public interface IModificarPalletsGestor {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoDatosTarea
	 * @param codigoEstadoTarea
	 * @param estadosTarea
	 * @param codigoTipoControlCosto
	 * @param valorTipoControlCosto
	 * @return
	 * @throws SICException
	 */
	public TareaDTO obtenerTareaAsignadaORegistradaPalletPeso(Integer codigoCompania, Long codigoDatosTarea, Integer codigoEstadoTarea, String[] estadosTarea, Integer codigoTipoControlCosto, String valorTipoControlCosto) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param pallet
	 * @param tarea
	 * @param datosTareaAutorizacionDTO
	 * @throws SICException
	 */
	public void encerarPalletRecepcion(Integer codigoCompania, String userId, Collection<VistaPalletsRecepcionPesoDTO> palletsCol, Map<Long,TareaDTO> mapTareasPallet, AutorizacionDTO autorizacion, Long codigoRecepcionProveedor) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param pallet
	 * @param datosTareaAutorizacionDTO
	 * @param codigoRecepcionProveedor
	 * @throws SICException
	 */
	public 	void cancelarPalletsRecepcion(Integer codigoCompania, String userId, Collection<VistaPalletsRecepcionPesoDTO> palletsCol, AutorizacionDTO autorizacion, Long codigoRecepcionProveedor) throws SICException;

	

	

}
