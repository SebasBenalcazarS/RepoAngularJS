/*
 * Creado el 2013-03-14
 */
package ec.com.smx.sic.cliente.servicio.recargacupon;

import java.util.Date;
import java.util.Map;

import ec.com.smx.corpv2.dto.ProcesoBitacoraDTO;
import ec.com.smx.corpv2.dto.ProcesoConfiguracionDTO;
import ec.com.smx.frameworkv2.security.dto.NotificationDeviceDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.AsistenteCompraVO;


/** 
 * Interfaz que expone los servicios de env�o de cupones
 * @author mrivera
 */
public interface IEnvioCuponServicio{


	/**
	 * Genera los archivos por local con la informaci�n requerida de los cupones para el POS y devuelve true si se encontraron cupones
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param fechaProceso
	 * @param directorioBase
	 * @param nombreArchivo
	 * @throws SICException
	 */
	boolean generarArchivosCuponesByLocal(Integer codigoCompania, Integer codigoLocal, String fechaProceso, String directorioBase, String nombreArchivo) throws SICException;

	/**
	 * Proceso que reenv�a los archivos que est�n con error a los locales
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	public void reenvioArchivoCuponesALocales(Integer codigoCompania, String usuarioProceso, String fechaProceso) throws SICException;


	/**
	 * M�todo que reenv�a los archivos que tuvieron error y coloca en estado inactivo los que ya se procesaron
	 * @param procesoBitacora
	 * @param procesoConfiguracion
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @param pathLocal
	 * @param nameFileLocal
	 * @throws SICException
	 */
	public void transEnviarArchivoAndActualizarBitacora(ProcesoBitacoraDTO procesoBitacora, ProcesoConfiguracionDTO procesoConfiguracion, String usuarioProceso, Date fechaProceso, String pathLocal, String nameFileLocal) throws SICException;

	/**
	 * Procesa la trama de env�o de mensajes PUSH.
	 * 
	 */
	public void transProcesarEnvioMensajePush(AsistenteCompraVO asistenteCompraVO)throws SICException;

	/**
	 * Envia un mail con cupones sin imagen.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param numeroDias numeroDias = null, envia cupones vigents sin imagen, caso contrario cupones sin imagen proximos a actualizarse.
	 * @throws SICException
	 */
	public void enviarMailCuponesSinImagen(Integer codigoCompania, String usuarioProceso, Integer numeroDias)throws SICException;

	/**
	 * Metodo Asincrono Batch que envia mensajes push a varios dispositivos de un usuario
	 * @param mapNumeroDocumento
	 * @param sysId
	 * @param mensaje
	 * @param idDispositivoExcluir  id del dispositivo que no se le eviara el mensaje push
	 * @param enviarTipoExtra		true para enviar mensaje push tipo extra 
	 * 								false mensaje tipo Alert por defecto
	 * @param mensajeTipoExtra		map (codigo - valor) requerido, si enviarTipoExtra = true
	 * @throws SICException
	 */
	public void enviarMensajesPush(Map<String,String> mapNumeroDocumento , String sysId,String systemVersion, String mensaje,String idDispositivoExcluir,Boolean enviarTipoExtra,Map<String, String> mensajeTipoExtra)throws SICException;

	/**
	 * Metodo Asincrono que envia notificaciones a todos los dispositivos moviles activos
	 * @param sysId
	 * @param systemVersion		version
	 * @param enviarTipoExtra	true para enviar mensaje push tipo extra / false mensaje tipo Alert por defecto
	 * @param mensajeTipoExtra	map (codigo - valor) requerido, si enviarTipoExtra = true
	 * @param mensaje
	 * @throws SICException
	 */
	public void enviarMensajesPushPaginado(String sysId,String systemVersion, Boolean enviarTipoExtra, Map<String, String> mensajeTipoExtra,String mensaje,Integer maxResults)throws SICException;

	/**
	 * Envia imagen por FTP
	 * @param notificationDeviceDTO
	 * @throws SICException
	 */
	public void procesoRedimensionarImagenNotificacionFTP(NotificationDeviceDTO notificationDeviceDTO)throws SICException;
	
	
	/**
	 * Realiza el count de los cupones por local
	 */
	public Long findCountCuponesLocal(Integer codigoCompania, Integer codigoLocal, Date fechaProceso);

}
