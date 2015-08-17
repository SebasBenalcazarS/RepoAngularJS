/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.dao;

import java.util.Collection;
import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoDTO;

/**
 * @author jvillacis
 *
 */
public interface IConfiguracionCalendarioBodegaLocalDAO {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoCalendarioProcesoConfiguracion
	 * @param codigoAreaTrabajoCalendarioProceso
	 * @param userId
	 * @throws SICException
	 */
	public void inactivarDetallesCalendarioConfiguracion(Integer codigoCompania, Long codigoAreaTrabajoCalendarioProcesoConfiguracion, Long codigoAreaTrabajoCalendarioProceso, String userId) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoCalendarioProcesoConfiguracion
	 * @param userId
	 * @throws SICException
	 */
	public void inactivarDetallesConfiguracion(Integer codigoCompania, Long codigoAreaTrabajoCalendarioProcesoConfiguracion, String userId) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoCalendarioProcesoConfiguracion
	 * @param userId
	 * @throws SICException
	 */
	public void inactivarConfiguracion(Integer codigoCompania, Long codigoAreaTrabajoCalendarioProcesoConfiguracion, String userId) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoCalendarioProcesoConfiguracion
	 * @param codigoAreaTrabajoCalendarioProceso
	 * @return
	 * @throws SICException
	 */
	public List<Object[]> obtenerConfiguracionesHijas(Integer codigoCompania, Long codigoAreaTrabajoCalendarioProcesoConfiguracion, Long codigoAreaTrabajoCalendarioProceso) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoDia
	 * @param codigoCD
	 * @param codigoSubbodega
	 * @return
	 * @throws SICException
	 */
	public Collection<Integer> obtenerLocalesPedidoBodegaPerecibles(Integer codigoCompania, Integer codigoDia, Integer codigoCD, Integer codigoSubbodega, Integer codigoLocal) throws SICException;
	
	/**
	 * 
	 * @param codigosLocales
	 * @param userID
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoCalendarioProcesoDTO> obtenerConfiguracionLocales(Collection<Integer> codigosLocales, String userID, Integer diaSemana, Integer codigoSubbodega ) throws SICException;
	
}
