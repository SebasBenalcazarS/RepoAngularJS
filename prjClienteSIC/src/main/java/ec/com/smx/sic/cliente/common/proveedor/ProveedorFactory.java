/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import ec.com.smx.ppago.jde.dto.VistaProveedorJdeDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author mbraganza
 *
 */
public class ProveedorFactory {

	private static final ProveedorFactory INSTANCIA = new ProveedorFactory();
	
	/**
	 * 
	 * @return
	 */
	public static ProveedorFactory getInstancia(){
		return INSTANCIA;
	}
	
	/**
	 * 
	 * @param datosProveedor
	 * @return
	 */
	public DatosProveedor getProveedor(Object datosProveedor){
		
		if (datosProveedor == null){
			throw new SICException("datosProveedor no puede ser nulo");
		}
		
		if (datosProveedor instanceof VistaProveedorJdeDTO){
			return new ProveedorFinanciero<VistaProveedorJdeDTO>((VistaProveedorJdeDTO) datosProveedor);
		}
		
		return null;
	}
}
