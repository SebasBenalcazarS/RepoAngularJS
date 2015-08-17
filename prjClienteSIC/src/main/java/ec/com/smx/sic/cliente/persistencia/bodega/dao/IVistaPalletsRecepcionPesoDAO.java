/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaPalletsRecepcionPesoDTO;

/**
 * @author wcaiza
 *
 */
public interface IVistaPalletsRecepcionPesoDAO {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @param codigoProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	Collection<VistaPalletsRecepcionPesoDTO> obtenerPalletsRecepcionArticulo(Integer codigoCompania, String codigoArticulo, Long codigoUnidadManejo, Long codigoProcesoLogistico, Long codigoTipoTareaPerfil, Boolean obtenerTipoTareaPeso) throws SICException;

}
