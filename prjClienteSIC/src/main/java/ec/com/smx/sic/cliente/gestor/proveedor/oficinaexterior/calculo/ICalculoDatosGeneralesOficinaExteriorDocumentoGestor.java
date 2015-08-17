/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.oficinaexterior.calculo;

import java.io.Serializable;

import ec.com.smx.sic.cliente.common.oficinaexterior.ResultadoValidacionOficinaExterior;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.OficinaExteriorVO;

/**
 * @author Mario Braganza
 *
 */
public interface ICalculoDatosGeneralesOficinaExteriorDocumentoGestor extends
		Serializable {

	
	/**
	 * 
	 * @param codigoCompania
	 * @param resultadoValidacion
	 * @return
	 * @throws SICException
	 */
	OficinaExteriorVO obtenerDatosOficinaExterior(Integer codigoCompania,
			ResultadoValidacionOficinaExterior resultadoValidacion) throws SICException;
	
}
