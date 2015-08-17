/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.administracion.almacenamiento;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author mbraganza
 *
 */
public interface IAlmacenamientoDatosRolesUsuarioGestor extends Serializable {

	
	void registrarDatosRolesUsuario(ProveedorVO proveedorVO) throws SICException;
}
