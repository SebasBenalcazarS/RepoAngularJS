/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.recipientes.busqueda;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;

/**
 * @author jdvasquez
 *
 */
public interface IConsultarJabasTipoControlCostoGestor {

	/**
	 * Obtiene las jabas por tipo de control de costo del articulo
	 * @param articulo
	 * @param codigoTipoControlCostoList
	 * @return
	 * @throws SICException
	 */
	public Collection<ControlRecipienteTaraDetalleDTO> obtenerJabasTipoControlCosto(ArticuloDTO articulo, String codigoTipoControlCostoList) throws SICException;

	/**
	 * Obtiene una coleccion de jabas de rechazo por articulo
	 * @param articulo
	 * @param codigoProcesoRechazo
	 * @return
	 * @throws SICException
	 */
	
	public Collection<ControlRecipienteTaraDetalleDTO> obtenerJabasRechazoArticulo(ArticuloDTO articulo, Long codigoProcesoRechazo) throws SICException;

	/**
	 * Obtiene el resumen de jabas de la recepcion
	 * @param codigoCompania
	 * @param codigoProceso
	 * @param codigosProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	Collection<ControlRecipienteTaraDetalleDTO> obtenerResumenJabasRecepcion(Integer codigoCompania, Long codigoProceso, Collection<Long> codigosProcesoLogistico) throws SICException;

}
