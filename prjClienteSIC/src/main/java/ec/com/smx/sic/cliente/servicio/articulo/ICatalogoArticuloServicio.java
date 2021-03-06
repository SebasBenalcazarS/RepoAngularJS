/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.articulo;

import java.util.Collection;

import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorMarcaDTO;

/**
 * @author fmunoz
 *
 */
public interface ICatalogoArticuloServicio {

	/**
	 * 
	 * @param claseArticuloDTO
	 * @throws SICException
	 */
	public void crearClaseArticulo(ClaseArticuloDTO claseArticuloDTO)throws SICException;

	
	public int cambiarEstadoMarcaProveedor(Collection<ProveedorMarcaDTO> proveedorMarcaCol,String estado,UserDto userDto) throws SICException;


}
