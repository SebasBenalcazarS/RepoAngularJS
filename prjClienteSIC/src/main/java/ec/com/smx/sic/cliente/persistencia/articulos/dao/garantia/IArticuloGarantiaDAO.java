/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.dao.garantia;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.ArticuloRangoExtensionGarantiaDTO;

/**
 * @author eharo
 *
 */
public interface IArticuloGarantiaDAO {

	
	public Collection<ArticuloRangoExtensionGarantiaDTO> obtenerRangosGE(ArticuloRangoExtensionGarantiaDTO rangoExtensionGarantiaDTO, Double precioBaseImp) throws SICException;
}
