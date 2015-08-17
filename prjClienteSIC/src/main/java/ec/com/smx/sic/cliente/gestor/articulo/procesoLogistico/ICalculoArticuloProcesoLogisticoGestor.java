/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.procesoLogistico;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;

/**
 * @author jdvasquez
 *
 */
public interface ICalculoArticuloProcesoLogisticoGestor {
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public ArticuloProcesoLogisticoDTO obtenerInformacionDespachoArticulo(Integer codigoCompania, String codigoArticulo) throws SICException;

}
