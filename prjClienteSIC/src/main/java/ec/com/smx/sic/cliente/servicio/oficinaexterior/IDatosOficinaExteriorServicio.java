/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.oficinaexterior;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.oficinaexterior.ResultadoValidacionOficinaExterior;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorOficinaExteriorDTO;
import ec.com.smx.sic.cliente.mdl.vo.IIdentificadorProveedorVO;
import ec.com.smx.sic.cliente.mdl.vo.OficinaExteriorVO;

/**
 * @author Mario Braganza 
 *  
 */
public interface IDatosOficinaExteriorServicio extends Serializable {
	
	/**
	 * 
	 * @param identificadorProveedor
	 * @return
	 * @throws SICException
	 */
	Duplex<ResultadoValidacionOficinaExterior, OficinaExteriorVO> obtenerDatosInicialesOficinaExterior(IIdentificadorProveedorVO identificadorProveedor) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return Collection<ProveedorOficinaExteriorDTO>
	 * @throws SICException
	 */
	Collection<ProveedorOficinaExteriorDTO> obtenerProveedorOficinasExterior(Integer codigoCompania, String codigoProveedor) throws SICException;

}
