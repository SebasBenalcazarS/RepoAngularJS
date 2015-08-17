/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.controlRutas.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DestinoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RutaDTO;
import ec.com.smx.sic.cliente.mdl.dto.RutaDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.RutaParticipanteRegistroNovedadDTO;


/**
 * @author egudino
 *
 */
public interface IMonitorRutasDAO {

	/**
	 * Obtiene la ruta por codigo
	 * @param codigoCompania
	 * @param secuenciaRuta
	 * @return
	 * @throws SICException
	 */
	public RutaDTO obtenerDatosRutaCodigo(Integer codigoCompania, Long secuenciaRuta) throws SICException;
	
	/**
	 * Guardar destinos
	 * @param destinosNuevos
	 * @param destinoEliminados
	 * @param codigoRuta
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	public void guardarDestinos(Collection<DestinoDTO> destinosNuevos,Collection<DestinoDTO> destinoEliminados, Long codigoRuta, Integer codigoCompania, String userId)throws SICException;
	
	/**
	 * Lista de novedades bitacora
	 * @param codigoCompania
	 * @param secuenciaDetalle
	 * @return
	 * @throws SICException
	 */
	public Collection<RutaParticipanteRegistroNovedadDTO> obtenerListaNovedadesRuta(Integer codigoCompania, Long secuenciaDetalle) throws SICException;
	
	/**
	 * Metodo para registrar llegada a punto en la ruta
	 * @param rutaBitacoraDTO
	 * @param rutaBitacoraCols
	 * @param userId
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void registrarLlegada(String documentoChofer, RutaDetalleDTO rutaBitacoraDTO, Collection<RutaParticipanteRegistroNovedadDTO> rutaBitacoraCols, String userId,Integer codigoCompania) throws SICException;
	
	/**
	 * Lista de bitacoras del la ruta por ruta
	 * @param codigoCompania
	 * @param codigoRuta
	 * @return
	 * @throws SICException
	 */
	public Collection<RutaDetalleDTO> obtenerListaBitacoraRuta(Integer codigoCompania, Long codigoRuta) throws SICException;
	
	/**
	 * Metodo para registrar salida a punto en la ruta
	 * @param rutaBitacoraDTO
	 * @param rutaBitacoraCols
	 * @param userId
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void registrarSalida(String documentoChofer, RutaDetalleDTO rutaBitacoraDTO, Collection<RutaParticipanteRegistroNovedadDTO> rutaBitacoraCols, String userId,Integer codigoCompania, String tipoDestino) throws SICException;
	
	
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
	public void guardarMovimientoGarita(Integer codigoCompania, String userId, RutaDetalleDTO rutaBitacoraDTO, Collection<RutaParticipanteRegistroNovedadDTO> listaNovedades, String placaCabezal)throws SICException;
}
