/*
 * Creado el 2013-03-14
 */
package ec.com.smx.sic.cliente.servicio.recargacupon;

import java.util.Collection;
import java.util.Map;

import org.w3c.dom.Document;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.frameworkv2.security.dto.ImageNotificationDTO;
import ec.com.smx.frameworkv2.security.dto.NotificationDeviceDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClienteArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.CuponDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaClienteCuponDispositivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.integracion.ActualizacionCuponesDTOIn;
import ec.com.smx.sic.cliente.mdl.dto.integracion.ConsultaCuponesDTOIn;
import ec.com.smx.sic.cliente.mdl.dto.sispe.ClienteDTO;
import ec.com.smx.sic.cliente.mdl.vo.AsistenteCompraVO;


/** 
 * Interfaz que expone los servicios de cupones
 * @author mrivera
 */
public interface IClienteCuponServicio{
	/**
	 * Obtiene el cliente dado el n�mero de tarjeta de afiliacion, si no existe lo registra
	 * @param clienteDTO
	 * @throws SICException
	 */
	ClienteDTO transObtenerClienteByTarjetaAfiliacion(String tarjetaAfiliacion, Integer codigoCompania, String userID) throws SICException;

	/**
	 * Obtiene los cupones validos del cliente.
	 * 
	 * @param clienteArticuloDTO
	 * @param establecimientosCol
	 * @return the SearchResultDTO<CuponDTO>
	 * @throws SICException
	 */
	public SearchResultDTO<CuponDTO> findCuponesClientePaged(ClienteArticuloDTO clienteArticuloDTO, Collection<EstablecimientoDTO> establecimientosCol) throws SICException;
	/**
	 * Registra los cupones seleccionados por el cliente
	 * 
	 * @param clienteDTO
	 * @param articuloCol  Coleccion para crear
	 * @param clienteCuponesActualizar  Coleccion para actualizar
	 * @param lstEstablecimiento  Coleccion de establecimientos
	 * @throws SICException
	 */
	public void transRegistrarCuponesCliente(ClienteDTO clienteDTO, Collection<CuponDTO> articuloCol, Collection<CuponDTO> clienteCuponesActualizar, Collection<EstablecimientoDTO> lstEstablecimiento) throws SICException;

	/**
	 * Recibe y procesa tramas de consulta de cupones desde DATAMAX.
	 * @param consultaCuponesDTOIn
	 * @throws SICException
	 */
	public void findProcesarTramaConsulta(ConsultaCuponesDTOIn consultaCuponesDTOIn) throws SICException;

	/**
	 * Recibe y procesa tramas de actualizacion de cupones desde DATAMAX.
	 * @param actualizacionCuponesDTOIn
	 * @throws SICException
	 */
	public void transProcesarTramaActualizacion(ActualizacionCuponesDTOIn actualizacionCuponesDTOIn) throws SICException;

	/**
	 * Metodo utilizado por los web service para registrar los cupones del cliente.
	 * @param idCliente
	 * @param cuponesAInsertar
	 * @param cuponesABorrar
	 * @throws SICException
	 */
	public void transRegistrarCuponesWS(String idCliente, Collection<String> cuponesAInsertar, Collection<String> cuponesABorrar) throws SICException;

	/**
	 * Metodo utilizado por los web service para validar si el cliente posee tarjeta (consumo de web service).
	 * @param asistenteCompraVO
	 * @return 
	 * @throws SICException
	 */
	public AsistenteCompraVO findValidarClientePoseeTarjeta(AsistenteCompraVO asistenteCompraVO) throws SICException;

	/**
	 * 
	 * Metodo utilizado por los web service para validar si el cliente posee tarjeta (consumo de web service).
	 * @param jsonEntrada
	 * @return
	 * @throws SICException
	 */
	public AsistenteCompraVO transRegistrarTarjeta(AsistenteCompraVO asistenteCompraVO) throws SICException;

	/**
	 * 
	 * Metodo utilizado por los web service para solicitar tarjeta (consumo de web service).
	 * @param jsonEntrada
	 * @return
	 * @throws SICException
	 */
	public AsistenteCompraVO transSolicitarTarjeta(AsistenteCompraVO asistenteCompraVO) throws SICException;

	/**
	 * 
	 * Metodo utilizado por los web service para validar el estado de una tarjeta (consumo de web service).
	 * @param jsonEntrada
	 * @return
	 * @throws SICException
	 */
	public AsistenteCompraVO transValidarEstadoTarjeta(AsistenteCompraVO asistenteCompraVO) throws SICException;

	/**
	 * Consulta de la vistaClienteCuponDispositivo dado un numero de documento
	 * @param numeroDocumento
	 */
	public VistaClienteCuponDispositivoDTO findVistaClienteCuponDispositivo(String numeroDocumento)throws SICException;

	/**
	 * Procesa la trama de consulta de cliente cupon device
	 * @param mensaje
	 * @param id
	 * @throws SICException
	 */
	public void findClienteCuponDevice(Document mensaje, byte[] id)throws SICException;
	/**
	 * 
	 * Metodo utilizado por los web service para validar el estado de una tarjeta (consumo de web service).
	 * @param asistenteCompraVO 														  AsistenteCompraVO
	 * @return
	 * @throws SICException
	 */
	public void transEliminarTarjeta(AsistenteCompraVO asistenteCompraVO) throws SICException;

	/**
	 * Permite registrar el email de la persona es usado en el webservice registrarEmailUsuario y registrarTarjeta.
	 * @param asistenteCompraVO
	 * @throws SICException
	 */
	public void transRegistrarEmailUsuario(AsistenteCompraVO asistenteCompraVO) throws SICException;

	/**
	 * Obtiene el email registrado en asistente de compras
	 * @param codigoPersona
	 * @return email
	 */
	public String findObtenerDatoContactoAsistenteCompras(Long codigoPersona) throws SICException;

	/**
	 * Obtiene notificaciones por la ultima fecha de actualizacion
	 * @param fechaUltimaActualizacion
	 * @param validoDesde
	 * @param validoHasta
	 * @return
	 * @throws SICException
	 */
	public Collection<NotificationDeviceDTO> obtenerNotificaciones(Long fechaUltimaActualizacion)throws SICException;


	/**
	 * Obtiene notificaciones
	 * @param notificationDeviceDTO
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<NotificationDeviceDTO> obtenerNotificaciones(NotificationDeviceDTO notificationDeviceDTO,Map<String, ComparatorTypeEnum> comparatorType)throws SICException;

	/**
	 * Metodo que regsitra notificaciones con imagenen, las redimenciona y envia por FTP
	 * @param notificationDeviceDTO
	 * @throws SICException
	 */
	public void transRegistrarNotificacion(NotificationDeviceDTO notificationDeviceDTO)throws SICException;
	
	
	/**
	 * Obtiene la imagen de la notificacion por el codigoNotificacion
	 * @param codigoNotificacion
	 * @return
	 * @throws SICException
	 */
	public ImageNotificationDTO obtenerImagenNotificacion(Long codigoNotificacion)throws SICException;
	
	
	/**
	 * devuelve el numero de tarjeta del cliente cuando se le ha olvidado
	 * @param asistenteCompraVO
	 * @return
	 * @throws SICException
	 */
	public AsistenteCompraVO transObtenerTarjetasCliente(AsistenteCompraVO asistenteCompraVO)throws SICException;
	
	/**
	 * Obtiene el cliente dado el n&uacute;mero de documento
	 * 
	 * @throws SICException
	 */
	public ClienteDTO findClienteByNumeroDocumento(String numeroDocumento, Integer codigoCompania) throws SICException;
		
}
