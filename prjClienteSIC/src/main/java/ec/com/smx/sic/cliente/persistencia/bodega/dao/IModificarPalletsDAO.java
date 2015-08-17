/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.math.BigDecimal;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;

/**
 * @author jdvasquez
 *
 */
public interface IModificarPalletsDAO {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoDatosTarea
	 * @param codigoEstadoTarea
	 * @param estadosTarea
	 * @return
	 * @throws SICException
	 */
	public TareaDTO obtenerTareaAsignadaORegistradaPalletPeso(Integer codigoCompania, Long codigoDatosTarea, Integer codigoEstadoTarea, String[] estadosTarea, Integer codigoTipoControlCosto, String valorTipoControlCosto) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param datosTareaDTO
	 * @throws SICException
	 */
	public void actualizarPesoEstadoPallet(DatosTareaDTO datosTareaDTO) throws SICException;

	/**
	 * 
	 * @param tarea
	 * @throws SICException
	 */
	public void eliminarTareaAsignadaRegistradaPalletPeso(TareaDTO tarea) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param codigoDatosTarea
	 * @throws SICException
	 */
	public void eliminarDetallePallet(Integer codigoCompania, String userId, Long codigoDatosTarea) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param codigoDatosTareaRelacionado
	 * @throws SICException
	 */
	public void eliminarRelacionPallets(Integer codigoCompania, String userId, Long codigoDatosTareaRelacionado) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoDatosTarea
	 * @return
	 * @throws SICException
	 */
	public Collection<TareaDTO> obtenerTareaAsignadaPallet(Integer codigoCompania, Long codigoDatosTarea) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param codigoTarea
	 * @throws SICException
	 */
	public void inactivarTarea(Integer codigoCompania, String userId, Long codigoTarea) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param codigoTarea
	 * @param codigoDatosTarea
	 * @throws SICException
	 */
	public void inactivarRelacionTareaPallet(Integer codigoCompania, String userId, Long codigoTarea, Long codigoDatosTarea) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param codigoRecepcionProveedor
	 * @param codigoProcesoLogistico
	 * @param peso
	 * @throws SICException
	 */
	public void reversarPesoRecepcionProveedor(Integer codigoCompania, String userId, Long codigoRecepcionProveedor, Long codigoProcesoLogistico, BigDecimal peso) throws SICException;

	

	
	
}
