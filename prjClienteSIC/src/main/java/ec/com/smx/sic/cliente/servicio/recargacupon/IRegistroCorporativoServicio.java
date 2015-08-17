package ec.com.smx.sic.cliente.servicio.recargacupon;

import ec.com.smx.frameworkv2.security.dto.BitacoraErrorSystemDeviceDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.AsistenteCompraVO;

/**
 * Interfaz que expone los servicios para dispositivos
 * @author fvallejo
 *
 */
public interface IRegistroCorporativoServicio {

	/**
	 * Valida si el numero de tarjeta corresponde al numero de documento del cliente, si es valido registra el dispositivo del cliente. 
	 * @param asistenteCompraVO
	 */
	public void transRegistrarDispositivo(AsistenteCompraVO asistenteCompraVO) throws SICException;
	
	/**
	 * Metodo para registrar en la bitacora los errores al consumir webservices
	 * @param bitacoraErrorSystemDeviceDTO
	 * @param descripcionWS
	 * @param deviceUniqueIdentifier
	 * @param numeroDocumento
	 * @throws SICException
	 */
	public void transRegistrarBitacoraError(BitacoraErrorSystemDeviceDTO bitacoraErrorSystemDeviceDTO, String descripcionWS, String deviceUniqueIdentifier, String numeroDocumento)throws SICException;
}