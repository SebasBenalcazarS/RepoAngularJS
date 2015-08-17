/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.bodega;

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
public interface IModificarPalletsRecepcionServicio {
	
	/**
	 * Obtiene una tarea asignada o registrada a un pallet pesado
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
	 * Permite encerar el peso del pallet de recepcion
	 * @param codigoCompania
	 * @param userId
	 * @param palletsCol
	 * @param tarea
	 * @param autorizacion
	 * @param codigoRecepcionProvedor
	 * @throws SICException
	 */
	public void encerarPalletRecepcion(Integer codigoCompania, String userId, Collection<VistaPalletsRecepcionPesoDTO> palletsCol, Map<Long,TareaDTO> mapTareasPallet, AutorizacionDTO autorizacion, Long codigoRecepcionProvedor) throws SICException;

	/**
	 * Permite cancelar un pallet de recepcion
	 * @param codigoCompania
	 * @param userId
	 * @param pallet
	 * @param datosTareaAutorizacionDTO
	 * @param codigoRecepcionProveedor
	 * @throws SICException
	 */
	public void cancelarPalletsRecepcion(Integer codigoCompania, String userId, Collection<VistaPalletsRecepcionPesoDTO> palletsCol, AutorizacionDTO autorizacion, Long codigoRecepcionProveedor) throws SICException;

	

}
