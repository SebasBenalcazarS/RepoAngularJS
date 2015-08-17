/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.dao;

import java.util.Collection;
import java.util.HashSet;

import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jvillacis
 *
 */
public interface IAreaTrabajoCDBodegaSubbodegaDAO {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerAreaTrabajoCD(Integer codigoCompania, Collection<Integer> codigosAreaTrabajo) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoUsuario
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> obtenerAreaSublugarTrabajoSubbodega(Integer codigoCompania, String codigoFuncionario, String codigoUsuario) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosBodegas
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> obtenerAreaSublugarTrabajoBodega(Integer codigoCompania, Collection<Integer> codigosBodegas) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoSubbodega
	 * @return
	 * @throws SICException
	 */
	public String obtenerSubbodegaDeBodegaDTO(Integer codigoCompania, Integer codigoAreaTrabajoSubbodega) throws SICException;
	
	/**
	 * 
	 * @param plantillaAreaSublugarTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> obtenerLocales(Integer codigoCentroDistribucion, Integer codigoAreaTrabajoSubbodega, HashSet<Integer> codigosAreaTrabajoSubbodega, Integer codigoCompania ) throws SICException;
	
}
