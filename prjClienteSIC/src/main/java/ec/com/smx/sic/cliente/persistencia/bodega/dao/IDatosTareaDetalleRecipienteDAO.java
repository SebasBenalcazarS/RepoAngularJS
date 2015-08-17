/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDetalleRecipienteDTO;

/**
 * @author jdvasquez
 *
 */
public interface IDatosTareaDetalleRecipienteDAO {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoDatosTarea
	 * @param codigoControlRecipienteTaraDetalle
	 * @return
	 * @throws SICException
	 */
	public Collection<DatosTareaDetalleRecipienteDTO> obtenerRelacionDatosTareaRecipienteCol(Integer codigoCompania, Long codigoDatosTarea, Long codigoControlRecipienteTaraDetalle, String estado) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param codigoControlRecipienteDetalleTara
	 * @param codigoDatosTarea
	 * @throws SICException
	 */
	public void insertarRelacionDatosTareaDetalleRecipiente(Integer codigoCompania, String userId, Long codigoControlRecipienteDetalleTara, Long codigoDatosTarea) throws SICException;

}
