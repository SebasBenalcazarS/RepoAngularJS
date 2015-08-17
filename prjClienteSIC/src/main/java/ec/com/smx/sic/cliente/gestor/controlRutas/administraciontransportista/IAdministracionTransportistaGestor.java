package ec.com.smx.sic.cliente.gestor.controlRutas.administraciontransportista;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.TransportistaDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ChoferDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaControlRutasTransportistaDTO;
import ec.com.smx.sic.cliente.mdl.vo.ChoferVO;
import ec.com.smx.sic.cliente.mdl.vo.IIdentificadorTransportistaVO;
import ec.com.smx.sic.cliente.mdl.vo.TransportistaVO;

/**
 * @author egudino
 *
 */

public interface IAdministracionTransportistaGestor {
	

	/**
	 * Interface del gestor para obtener la lista de transportes
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
	public <T extends SearchDTO> Duplex<T, SearchResultDTO<T>> obtenerTransportistaPorPlantillas(Integer codigoCompania,	Collection<ISearchTemplate> plantillasBusqueda,	Boolean datosPaginados, Integer firstResult, Integer maxResults, Boolean paginadoManual, String codigoFuncionario, String tipoReporte) throws SICException;

	
	/**
	 * Interface del gestor para obtener la lista de choferes
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
	public <T extends SearchDTO> Duplex<T, SearchResultDTO<T>> obtenerChoferPorPlantillas(Integer codigoCompania,	Collection<ISearchTemplate> plantillasBusqueda,	Boolean datosPaginados, Integer firstResult, Integer maxResults, Boolean paginadoManual, String codigoFuncionario, String tipoReporte) throws SICException;
	
	/**
	 * Metodo para exportar datos a excel
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Collection<VistaControlRutasTransportistaDTO> obtenerTransportistas(Integer codigoCompania, Collection<ISearchTemplate> plantillasBusqueda, String tipoReporte) throws SICException;
	
	
	/**
	 * Metodo para exportar datos a excel
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Collection<ChoferDTO> obtenerChoferesExcel(Integer codigoCompania, Collection<ISearchTemplate> plantillasBusqueda) throws SICException;
	
	/**
	 * Actualiza transportista tipo persona
	 * @param plantillaTransportista
	 * @throws SICException
	 */
	public void actualizarTransportistaPersona(TransportistaDTO plantillaTransportista)throws SICException;
	
	/**
	 * Consultar datos base JDE
	 * @param plantillaBusqueda
	 * @return
	 */
	public Collection<TransportistaVO> obtenerDatosTranspotistaBaseJDEdward(IIdentificadorTransportistaVO plantillaBusqueda) throws SICException;
	
	/**
	 * Metodo para guardar un nuevo transpotista
	 * @param plantillaTransportista
	 * @throws SICException
	 */
	public void guardarTransportista(TransportistaVO plantillaTransportista)throws SICException;
	
	/**
	 * Metodo para crear un nuevo transpotista
	 * @param plantillaTransportista
	 * @throws SICException
	 */
	public void crearTransportista(TransportistaVO plantillaTransportista)throws SICException;
	
	/**
	 * Metodo para guardar un nuevo chofer
	 * @param plantillaTransportista
	 * @throws SICException
	 */
	public void crearChofer(ChoferVO plantillaChofer)throws SICException;
	
	/**
	 * Metodo para actualizar un nuevo chofer
	 * @param plantillaTransportista
	 * @throws SICException
	 */
	public void actualizarChofer(ChoferVO plantillaChofer)throws SICException;
}
