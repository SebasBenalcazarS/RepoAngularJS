/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.garantia;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.ArticuloRangoExtensionGarantiaDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.GarantiaArticuloDTO;

/**
 * @author eharo
 *
 */
public interface IArticuloGarantiaGestor {

	public Collection<ArticuloRangoExtensionGarantiaDTO> obtenerRangosGE(ArticuloRangoExtensionGarantiaDTO rangoExtensionGarantiaDTO, Double precioBaseImp) throws SICException;
	
	public Collection<GarantiaArticuloDTO> buscarPrecioExtension(Collection<ArticuloRangoExtensionGarantiaDTO> rangosGE, Double precioBaseImp) throws SICException;
}
