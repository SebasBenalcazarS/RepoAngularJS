/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.oficinaexterior.calculo;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OficinaExteriorDTO;

/**
 * @author Mario Braganza
 *
 */
public interface ICalculoDatosOficinaExteriorGestor extends Serializable {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoPersona
	 * @return
	 * @throws SICException
	 */
	OficinaExteriorDTO obtenerOficinaExteriorPorPersona(Integer codigoCompania, Long codigoPersona) throws SICException;
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoLocalizacion
	 * @return
	 * @throws SICException
	 */
	OficinaExteriorDTO obtenerOficinaExteriorPorLocalizacion(Integer codigoCompania, Long codigoLocalizacion) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosLocalizaciones
	 * @return
	 * @throws SICException
	 */
	public Collection<OficinaExteriorDTO> obtenerOficinasExteriorPorLocalizaciones(Integer codigoCompania, 
			Collection<Long> codigosLocalizaciones) throws SICException;

}
