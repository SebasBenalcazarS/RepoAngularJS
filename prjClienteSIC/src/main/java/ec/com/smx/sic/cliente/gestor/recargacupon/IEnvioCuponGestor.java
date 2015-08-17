/*
 * Creado el 2013-03-14
 */
package ec.com.smx.sic.cliente.gestor.recargacupon;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import ec.com.smx.corpv2.dto.ProcesoBitacoraDTO;
import ec.com.smx.corpv2.dto.ProcesoConfiguracionDTO;
import ec.com.smx.frameworkv2.security.dto.NotificationDeviceDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.AsistenteCompraVO;

/**
 * Interfaz que expone lo metodos de gestion de envio de cupones 
 * @author mrivera
 */
public interface IEnvioCuponGestor{	


	/**
	 * Genera los archivos por local con la informacion requerida de los cupones para el POS y devuelve true si se encontraron cupones
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param fechaProceso
	 * @param directorioBase
	 * @param nombreArchivo
	 * @throws SICException
	 */
	boolean generarArchivosCuponesByLocal(Integer codigoCompania, Integer codigoLocal, String fechaProceso, String directorioBase, String nombreArchivo) throws SICException;

	/**
	 * Proceso que actualiza los cupones y genera el archivo para enviarlo a los locales
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @param horaFinDia
	 * @param diasInactivarCuponesCliente
	 * @throws SICException
	 */
	public void actualizarCuponesYGenerarArchivosTotal(Integer codigoCompania,String usuarioProceso, String fechaProceso, String horaFinDia, Integer diasInactivarCuponesCliente) throws SICException;

	/**
	 * Proceso que envia los archivos de cupones generados al local correspondiente.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @param virtual
	 * @throws SICException
	 */
	public void generarArchivosCuponesAndEnviarALocales(Integer codigoCompania, String usuarioProceso, String fechaProceso) throws SICException;


	/**
	 * Proceso que reenvia los archivos que estan con error a los locales
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @param virtual
	 * @throws SICException
	 */
	public void reenvioArchivoCuponesALocales(Integer codigoCompania, String usuarioProceso, String fechaProceso) throws SICException;


	/**
	 * Metodo que reenvia los archivos que tuvieron error y coloca en estado inactivo los que ya se procesaron
	 * @param procesoBitacora
	 * @param procesoConfiguracion
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @param pathLocal
	 * @param nameFileLocal
	 * @throws SICException
	 */
	public void enviarArchivoAndActualizarBitacora(ProcesoBitacoraDTO procesoBitacora, ProcesoConfiguracionDTO procesoConfiguracion, String usuarioProceso, Date fechaProceso, String pathLocal, String nameFileLocal) throws SICException;

	/**
	 * Metodo para probar el listener.
	 * @param numeroHilos
	 * @param numeroTransacciones
	 * @param tipoProceso
	 */
	public void procesarTramas(Integer numeroHilos, Integer numeroTransacciones, Integer tipoProceso)throws SICException;

	/**
	 * Procesa la trama de envio de mensajes PUSH.
	 * 
	 */
	public void procesarEnvioMensajePush(AsistenteCompraVO asistenteCompraVO)throws SICException;

	/**
	 * Proceso global para redimensionar las imagenes de los cupones
	 * @param fechaProceso
	 * @throws IOException
	 */
	public void procesoRedimensionarImagenesAndEnvioFTP(String fechaProceso, Integer tipoTamanoImagenProducto) throws IOException;

	/**
	 * Envia un mail con cupones sin imagen.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param numeroDias numeroDias = null, envia cupones vigents sin imagen, caso contrario cupones sin imagen proximos a actualizarse.
	 * @throws SICException
	 */
	public void enviarMailCuponesSinImagen(Integer codigoCompania, String usuarioProceso, Integer numeroDias)throws SICException;


	/**
	 * Metodo para enviar el archivo de cupones a un local especifico
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @param codigoLocal
	 */
	public void enviarArchivoALocal(Integer codigoCompania,String usuarioProceso,String fechaProceso,Integer codigoLocal);


	/**
	 * Enviar Mensaje push a usuarios activos
	 * @param asistenteCompraVO
	 * @throws SICException
	 */
	public void mensajePushAUsuariosActivos(String mensajePush)throws SICException;


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
	 * */
	public void enviarMensajesPush(Map<String, String> userIds, String sysId, String systemVersion,String mensaje,String idDispositivoExcluir,Boolean enviarTipoExtra,Map<String, String> mensajeTipoExtra)throws SICException;

	/**
	 * Metodo que envia notificaciones push a partir de un archivo excel con
	 * lo numeros de documento
	 * @param pathArchivo
	 * @throws SICException
	 */
	public void enviarMensajesPushExcel(String pathArchivo, String mensaje, String sysId,Boolean broadcast, String tipoTecnologia, String systemVersion, Integer validarVersionSistema)throws SICException;

	/**
	 * Genera archivos con cupones para kioskos.
	 */
	public void generarArchivosKioskos();
	
	public void generarArchivosKioskosAndEnviarPorFTP();
	
	/**
	 * Metodo que envia notificaciones a todos los dispositivos moviles activos
	 * @param sysId
	 * @param systemVersion
	 * @param enviarTipoExtra
	 * @param mensajeTipoExtra
	 * @param mensaje
	 * @throws SICException
	 */
	public void enviarMensajesPushPaginado(String sysId, String systemVersion,Boolean enviarTipoExtra, Map<String, String> mensajeTipoExtra,String mensaje,Integer maxResults) throws SICException;
	
	public void procesoRedimensionarImagenNotificacion(NotificationDeviceDTO notificationDeviceDTO)throws SICException;
	
	/**
	 * Proceso genera archivos de cupones para locales.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	public void generarArchivosCupones(Integer codigoCompania, String usuarioProceso, String fechaProceso) throws SICException;
	
	/**
	 * Proceso que envia los archivos de cupones generados al local correspondiente.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	public void enviarArchivosALocales(Integer codigoCompania, String usuarioProceso, String fechaProceso) throws SICException; 
	
	/**
	 * Realiza el count de los cupones por local
	 */
	public Long countCuponesLocal(Integer codigoCompania, Integer codigoLocal, Date fechaProceso);

}
