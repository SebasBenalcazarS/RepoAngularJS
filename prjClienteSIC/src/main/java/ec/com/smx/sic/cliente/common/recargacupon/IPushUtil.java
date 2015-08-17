package ec.com.smx.sic.cliente.common.recargacupon;

import java.util.Map;

import ec.com.smx.frameworkv2.security.dto.NotificationDeviceDTO;

public interface IPushUtil {


	public void enviarMensajesPush(Map<String, String> mapNumeroDocumento, String sysId,String systemVersion,
			String mensaje,String idDispositivoExcluir,Boolean enviarTipoExtra,Map<String, String> mensajeTipoExtra);
	public void enviarMensajesPushPaginado(String sysId, String systemVersion,
			Boolean enviarTipoExtra, Map<String, String> mensajeTipoExtra,
			String mensaje, Integer maxResults);
	
	public void procesoRedimensionarImagenNotificacionFTP(
			NotificationDeviceDTO notificationDeviceDTO);
	
}
