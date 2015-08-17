
package ec.com.smx.sic.cliente.servicio.controlRutas;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DestinoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RutaDTO;
import ec.com.smx.sic.cliente.mdl.dto.RutaDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.RutaParticipanteRegistroNovedadDTO;



/**
 * @author egudino
 *
 */

public interface IMonitoreoRutaServicio {

	/**
	 * Lista destinos generales
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
//	public Collection<DestinoDTO> listaDestinos(Integer codigoCompania) throws SICException;
	
	/**
	 * Obtiene la ruta por codigo
	 * @param codigoCompania
	 * @param secuenciaRuta
	 * @return
	 * @throws SICException
	 */
	public RutaDTO obtenerDatosRutaCodigo(Integer codigoCompania, Long secuenciaRuta) throws SICException;
	
	/**
	 * Lista de novedades bitacora
	 * @param codigoCompania
	 * @param secuenciaDetalle
	 * @return
	 * @throws SICException
	 */
	public Collection<RutaParticipanteRegistroNovedadDTO> obtenerListaNovedadesRuta(Integer codigoCompania, Long secuenciaDetalle) throws SICException;
	
	
	/**
	 * Obtiene la ultima bitacora de la ruta indicada
	 * @param codigoCompania
	 * @param codigoRuta
	 * @return
	 * @throws SICException
	 */
//	public RutaBitacoraDTO obtenerUltimaBitacoraRuta(Integer codigoCompania, Long codigoRuta) throws SICException;
	
	/**
	 * Lista de destinos por Ruta
	 * @param codigoCompania
	 * @param codigoRuta
	 * @return
	 * @throws SICException
	 */	
//	public Collection<RutaDestinoDTO> obtenerListaDestinosRuta(Integer codigoCompania, Long codigoRuta) throws SICException;
	
	
	/**
	 * Lista de bitacoras del la ruta por ruta
	 * @param codigoCompania
	 * @param codigoRuta
	 * @return
	 * @throws SICException
	 */
	public Collection<RutaDetalleDTO> obtenerListaBitacoraRuta(Integer codigoCompania, Long codigoRuta) throws SICException;
	
	/**
	 * Metodo para registrar llegada a punto en la ruta
	 * @param rutaBitacoraDTO
	 * @param rutaBitacoraCols
	 * @param userId
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void transRegistrarLlegada(String documentoChofer, RutaDetalleDTO rutaBitacoraDTO, Collection<RutaParticipanteRegistroNovedadDTO> rutaBitacoraCols, String userId,Integer codigoCompania) throws SICException;
	
	/**
	 * Metodo para registrar salida a punto en la ruta
	 * @param rutaBitacoraDTO
	 * @param rutaBitacoraCols
	 * @param userId
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void transRegistrarSalida(String documentoChofer, RutaDetalleDTO rutaBitacoraDTO, Collection<RutaParticipanteRegistroNovedadDTO> rutaBitacoraCols, String userId,Integer codigoCompania, String tipoDestino) throws SICException;
	
	/**
	 * M�todo que busca la lista de guias dependiendo de la plantilla indicada
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
	public <T extends SearchDTO> Duplex<T, SearchResultDTO<T>> obtenerRutasPorPlantillas(Integer codigoCompania, Integer codigoAreaTrabajo,	Collection<ISearchTemplate> plantillasBusqueda,	Boolean datosPaginados, Integer firstResult, Integer maxResults, Boolean paginadoManual, String codigoFuncionario) throws SICException;
	
	/**
	 * Guardar destinos
	 * @param destinosNuevos
	 * @param destinoEliminados
	 * @param codigoRuta
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	public void transGuardarDestinos(Collection<DestinoDTO> destinosNuevos,Collection<DestinoDTO> destinoEliminados, Long codigoRuta, Integer codigoCompania, String userId)throws SICException;
	
	/**
	 * Guardar novedades
	 * @param novedadesCols
	 * @param secuenciaDetalle
	 * @param userId
	 * @param codigoCompania
	 * @throws SICException
	 */
//	public void transGuardarNovedadesBitacora(Collection<RutaBitacoraNovedadDTO> novedadesCols, String userId, Integer codigoCompania)throws SICException;
	
	/**
	 *  Metodo para obtner el movimiento de la bodega a la garita para mostrar en scaner
	 * @param codigoCompania
	 * @param codigoScaneado
	 * @return
	 * @throws SICException
	 */
	public RutaDetalleDTO obtenerMovimientoBodegaGaritaFurgon(Integer codigoCompania, String codigoScaneado)throws SICException;
	
	/**
	 * Metodo para registrar movimiento Garita
	 * @param codigoCompania
	 * @param userId
	 * @param rutaBitacoraDTO
	 */
	public void transGuardarMovimientoGarita(Integer codigoCompania, String userId, RutaDetalleDTO rutaBitacoraDTO, Collection<RutaParticipanteRegistroNovedadDTO> listaNovedades, String placaCabezal)throws SICException;
	
}
