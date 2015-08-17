package ec.com.smx.sic.cliente.gestor.recargacupon;

import ec.com.smx.frameworkv2.security.dto.BitacoraErrorSystemDeviceDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.AsistenteCompraVO;

/**
 * Interfaz que expone lo metodos para web service.
 * 
 * @author fvallejo
 *
 */
public interface IRegistroCorporativoGestor {

	/**
	 * Valida si el numero de tarjeta corresponde al numero de documento del cliente, si es valido registra el dispositivo del cliente. 
	 * @param asistenteCompraVO
	 * @exception SICException
	 */
	public void registrarDispositivo(AsistenteCompraVO asistenteCompraVO) throws SICException;
	
		/**
	 * Actualiza el estado de la aplicacion movil.
	 * @param asistenteCompraVO
	 * @exception SICException
	 */
	public void cambiarEstadoAplicacionMovil(AsistenteCompraVO asistenteCompraVO) throws SICException;
	
	/**
	 * Metodo para registrar en la bitacora los errores al consumir webservices
	 * @param bitacoraErrorSystemDeviceDTO
	 * @param descripcionWS
	 * @param deviceUniqueIdentifier
	 * @param numeroDocumento
	 * @throws SICException
	 */
	public void registrarBitacoraError(BitacoraErrorSystemDeviceDTO bitacoraErrorSystemDeviceDTO, String descripcionWS, String deviceUniqueIdentifier, String numeroDocumento)throws SICException;
}