package ec.com.smx.sic.cliente.servicio.controlRutas;

import java.util.ArrayList;
import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FurgonAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FurgonDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametrizacionDistanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.PrefijoFurgonDTO;
import ec.com.smx.sic.cliente.mdl.dto.VehiculoFurgonDTO;

/**
 * @author egudino
 *
 */

public interface IAdministracionFurgonServicio {

	
	/**
	 * Metodo para exportar datos a excel
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Collection<T> obtenerFurgones(Integer codigoCompania, ArrayList<ISearchTemplate> plantillasBusqueda) throws SICException;
	
	/**
	 * Obtiene furgon por codigo
	 * @param codigoCompania
	 * @param codigoFurgon
	 * @return
	 * @throws SICException
	 */
	public FurgonDTO obtenerFurgonPorCodigo(Integer codigoCompania, Integer codigoFurgon) throws SICException;
	
	/**
	 * M�todo que busca la lista de furgones dependiendo de la plantilla indicada
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @param datosPaginados
	 * @param firstResult
	 * @param maxResults
	 * @param paginadoManual
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	public <T extends SearchDTO> Duplex<T, SearchResultDTO<T>> obtenerFurgonesPorPlantillas(Integer codigoCompania,	Collection<ISearchTemplate> plantillasBusqueda,	Boolean datosPaginados, Integer firstResult, Integer maxResults, Boolean paginadoManual, String codigoFuncionario) throws SICException;

	/**
	 * Metodo que sirve para guardar en base los datos del furgon
	 * @param plantillaFurgonDTO
	 * @throws SICException
	 */
	public void transGuardarFurgon(FurgonDTO plantillaFurgonDTO, VehiculoFurgonDTO plantillaVehiculoFurgonDTO, FurgonAreaTrabajoDTO plantillaFurgonAreaTrabajoDTO, String tipoFurgon) throws SICException;
	
	/**
	 * Metodo que sirve para actializar un furgon
	 * @param plantillaFurgonDTO
	 * @throws SICException
	 */
	public void transActualizarFurgon(FurgonDTO plantillaFurgonDTO, VehiculoFurgonDTO plantillaVehiculoFurgonDTO, FurgonAreaTrabajoDTO plantillaFurgonAreaTrabajoDTO, String tipoFurgon) throws SICException;
	
	/**
	 * Devuelve coleccion de Furgones por area de trabajo
	 * @param codigoAreaTrabajo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<FurgonAreaTrabajoDTO> obtenerListaFurgonPorAreaTrabajo(Integer codigoAreaTrabajo, Integer codigoCompania) throws SICException;
	
	/**
	 * Guardar lista de distancias entre areas de trabajo y/o localizaciones
	 * @param listaDistancias
	 * @throws SICException
	 */
	public void transGuardarParametrizacionDistancias(Integer codigoOrigen, Collection<ParametrizacionDistanciaDTO> listaDistancias, Collection<ParametrizacionDistanciaDTO> listaEliminar, String userId) throws SICException;
	
	/**
	 * Lista de parametrizacion de distancias
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @param datosPaginados
	 * @param firstResult
	 * @param maxResults
	 * @param paginadoManual
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	public <T extends SearchDTO> Duplex<T, SearchResultDTO<T>> obtenerParametrizacionPorPlantillas(Integer codigoCompania,	Collection<ISearchTemplate> plantillasBusqueda,	Boolean datosPaginados, Integer firstResult, Integer maxResults, Boolean paginadoManual, String codigoFuncionario) throws SICException;
	
	
	/**
	 * Metodo para exportar datos a excel
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Collection<ParametrizacionDistanciaDTO> obtenerParametrizacion(Integer codigoCompania, ArrayList<ISearchTemplate> plantillasBusqueda) throws SICException;
	
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
}
