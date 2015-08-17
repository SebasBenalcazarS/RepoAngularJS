/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.administracion.almacenamiento;

import java.io.Serializable;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author mbraganza
 *
 */
public interface IAlmacenamientoDatosPerfilesUsuarioProveedorGestor extends Serializable {

	Set<String> asignarPerfilesUsuarioProveedor(ProveedorVO proveedorVO) throws SICException;
}
