package ec.com.smx.sic.cliente.servicio.controlRutas;

import java.util.ArrayList;
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

public interface IAdministracionTransportistaServicio {

	/**
	 * Metodo para obtener la lista de transportes
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
	 * Metodo para obtener la lista de choferes
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
	 * Actualiza transportista tipo persona
	 * @param plantillaTransportista
	 * @throws SICException
	 */
	public void transActualizarTransportistaPersona(TransportistaDTO plantillaTransportista)throws SICException;
	
	/**
	 * Consultar datos base JDE
	 * @param plantillaBusqueda
	 * @return
	 */
	public Collection<TransportistaVO> obtenerDatosTranspotistaBaseJDEdward(IIdentificadorTransportistaVO plantillaBusqueda) throws SICException;
	
	
	/**
	 * Metodo para exportar datos a excel
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Collection<VistaControlRutasTransportistaDTO> obtenerTransportistas(Integer codigoCompania, ArrayList<ISearchTemplate> plantillasBusqueda, String tipoReporte) throws SICException;
	
	
	/**
	 * Metodo para exportar datos a excel
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Collection<ChoferDTO> obtenerChoferesExcel(Integer codigoCompania, ArrayList<ISearchTemplate> plantillasBusqueda) throws SICException;
	
	/**
	 * Metodo para guardar un nuevo transpotista
	 * @param plantillaTransportista
	 * @throws SICException
	 */
	public void transGuardarTransportista(TransportistaVO plantillaTransportista)throws SICException;
	
	/**
	 * Metodo para guardar un nuevo transpotista
	 * @param plantillaTransportista
	 * @throws SICException
	 */
	public void transCrearTransportista(TransportistaVO plantillaTransportista)throws SICException;
	
	/**
	 * Metodo para guardar un nuevo chofer
	 * @param plantillaTransportista
	 * @throws SICException
	 */
	public void transCrearChofer(ChoferVO plantillaChofer)throws SICException;
	
	/**
	 * Metodo para actualizar un nuevo chofer
	 * @param plantillaTransportista
	 * @throws SICException
	 */
	public void transActualizarChofer(ChoferVO plantillaChofer)throws SICException;
}
