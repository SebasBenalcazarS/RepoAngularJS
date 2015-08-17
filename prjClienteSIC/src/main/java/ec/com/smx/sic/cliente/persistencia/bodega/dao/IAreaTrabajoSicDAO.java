package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.vo.AreaTrabajoVO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;

/**
 * 
 * @author cortiz
 *
 */

public interface IAreaTrabajoSicDAO {

	/**
	 * Permite almacenar el area de trabajo editada
	 * @param areaTrabajoDTO
	 * @throws SICException
	 */
	public void almacenarEdicionAreaTrabajo(AreaTrabajoDTO areaTrabajoDTO) throws SICException;
	
	/**
	 * Metodo para la busqueda de areas de trabajo
	 * @param areaTrabajoVO
	 * @return
	 * @throws SICException
	 */
	public  Collection<AreaTrabajoDTO> obtenerAreasTrabajo(AreaTrabajoVO areaTrabajoVO)throws SICException;
	
	/**
	 * Permite la busqueda de areas de trabajo en base para no ingresar dos con el mismo codigo refgerencia
	 * @param codigoReferencia
	 * @param tipoAreaTrabajoValor
	 * @return
	 * @throws SICException
	 */
	public AreaTrabajoDTO validarExisteAreaTrabajo(Integer codigoReferencia,String tipoAreaTrabajoValor) throws SICException;
	
	/**
	 * Permite buscar las codigos subBodegas de una bodega
	 * @param bodega
	 * @return
	 * @throws SICException
	 */
	public Collection<BodegaDTO> buscarSubBodegas(AreaTrabajoDTO bodega)throws SICException;
	
	/**
	 * Metodo para contar la busqueda de locales
	 * @param codigoLocal
	 * @return
	 * @throws SICException
	 */
	public Long contarBusquedaLocal(Integer codigoLocal, Integer codigoCompania, String descripcion)throws SICException;
	
	/**
	 * Metodo para busqueda de locales
	 * @param codigoLocal
	 * @param codigoCompania
	 * @param firstResult
	 * @param maxResult
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<AreaTrabajoDTO> busquedaLocales(Integer codigoLocal, Integer codigoCompania, String descripcion, Integer firstResult, Integer maxResult)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param tipoAreaTrabajo
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<BodegaDTO> buscarBodegasDisponibles(Integer codigoCompania,String tipoAreaTrabajo,AreaTrabajoDTO areaTrabajoDTO)throws SICException;

	/**
	 * 
	 * @param areaTrabajoDTOHija
	 * @param tipoAreaTrabajoValorPadre
	 * @return
	 * @throws SICException
	 */
	public AreaTrabajoDTO consultarAreaTrabajoPadre(AreaTrabajoDTO areaTrabajoDTOHija,String tipoAreaTrabajoValorPadre)throws SICException;
	
	/**
	 *  Permite validar en las tablas relacionadas si existen registros activos de la areaTrabajo a inactivar
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public boolean validarAreaTrabajoInactivar(AreaTrabajoDTO areaTrabajoDTO,boolean isRelacion)throws SICException;
	
	/**
	 * Permite obtener las areas de trabajo relacionadas de la areaTrabajo a inactivar
	 * @param areaTrabajoDTO
	 * @param isRelacion
	 * @return
	 * @throws SICException
	 */
	public Collection<String> obtenerDescAreaTrabajoRelacinoadas(AreaTrabajoDTO areaTrabajoDTO,boolean isRelacion)throws SICException;
	
	/**
	 * Permite actualizar el area de trabajo
	 * @param areaTrabajoDTO
	 * @throws SICException
	 */
	public void actualizarAreaTrabajo(AreaTrabajoDTO areaTrabajoDTO)throws SICException;
	
	/**
	 * devuelve un area de trabajo con su codigo establecimiento a partir del id del area de trabajo
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public AreaTrabajoDTO obtenerCodigoEstablecimiento(AreaTrabajoDTO areaTrabajoDTO)throws SICException;
	
	/**
	 * Metodo que obtiene un area de trabajo por medio del codigo de referencia y el tipo de area
	 *
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public AreaTrabajoDTO obtenerAreaTrabajo(AreaTrabajoDTO areaTrabajoDTO)throws SICException;
}
