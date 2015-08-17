/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.recibidonocontabilizado;

import java.util.Map;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ComprobanteVO;

/**
 * @author vjaramillo
 *
 */
public interface IValidacionRecibidoNoContabilizadoGestor {

	/**
	 * Metodo para validar si existieron cambios y devolver las estructuras auditables y si existieron cambios en los datos 
	 * generales o valores del documento recibido
	 * @param codigoCompania
	 * @param systemId
	 * @param accesItemId
	 * @param comprobanteVOInicial
	 * @param comprobanteVOFinal
	 * @return
	 * @throws SICException
	 */
	Map<String, Object> obtenerValidarComprobanteAuditable(Integer codigoCompania, String systemId, String accesItemId, ComprobanteVO comprobanteVOInicial, ComprobanteVO comprobanteVOFinal) throws SICException;
	
	/**
	 * Metodo para validar las facturas electronicas que se encuentran relacionadas con las notas de ingreso FCD y FSD que no esten autorizadas por el
	 * SRI, validando de tal manera si estan activas.
	 * @param userId
	 * @param tareaProgramada
	 * @throws SICException
	 */
	void validarFacturasElectronicasNoAutorizadas(String userId, Boolean tareaProgramada) throws SICException;
}
