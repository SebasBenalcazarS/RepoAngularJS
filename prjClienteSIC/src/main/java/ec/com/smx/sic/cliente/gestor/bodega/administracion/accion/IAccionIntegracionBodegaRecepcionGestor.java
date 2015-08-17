/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.administracion.accion;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jdvasquez
 *
 */
public interface IAccionIntegracionBodegaRecepcionGestor {

	void integrarPalletsRecibidos(Integer codigoCompania, String userId, Long codigoDatosTarea) throws SICException;

	void integrarDatosLogisticosBodega(Integer codigoCompania) throws SICException;

}
