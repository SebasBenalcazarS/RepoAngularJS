/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.controlRutas.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FurgonAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FurgonDTO;
import ec.com.smx.sic.cliente.mdl.dto.PrefijoFurgonDTO;

/**
 * @author eharo
 *
 */
public interface IAdministracionFurgonDAO {

	
	/**
	 * METODO QUE PERMITE OBTENER LOS PREFIJOS DE LOS FURGONES
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public Collection<PrefijoFurgonDTO> obtenerPrefijoFurgones(final Integer codigoCompania) throws SICException;
	
	/**
	 * METODO QUE PERMITE OBTENER UNA LISTA DE LOS FURGONES DISPONIBLES
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public Collection<FurgonDTO> obtenerFurgonesDisponibles(final Integer codigoCompania) throws SICException;
	
	/**
	 * Lista de furgones por el area de trabajo
	 * @param plantillaFurgonAreaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<FurgonAreaTrabajoDTO> obtenerListaFurgonPorAreaTrabajo(FurgonAreaTrabajoDTO plantillaFurgonAreaTrabajoDTO ) throws SICException;
	
}
