/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.recipientes.validacion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

/**
 * @author jdvasquez
 *
 */
public interface IValidacionConsultaJabasTipoControlCostoGestor {

	/**
	 * Valida los parametros previa la obtencion de las jabas por tipo de control de costo
	 * @param articulo
	 * @param codigoTipoControlCostoList
	 * @throws SICException
	 */
	void obtenerJabasTipoControlCosto(ArticuloDTO articulo, String codigoTipoControlCostoList) throws SICException;
	
	/**
	 * Valida los parametros previa la obtencion de las jabas de rechazo por articulo
	 * @param articulo
	 * @param codigoProcesoRechazo
	 * @throws SICException
	 */
	void obtenerJabasRechazoArticulo(ArticuloDTO articulo, Long codigoProcesoRechazo) throws SICException;

	/**
	 * Valida los campos requeridos el resumen de jabas
	 * @param codigoCompania
	 * @param codigoProceso
	 * @param codigosProcesoLogistico
	 * @throws SICException
	 */
	void obtenerResumenRecepcion(Integer codigoCompania, Long codigoProceso, Collection<Long> codigosProcesoLogistico) throws SICException;

}
