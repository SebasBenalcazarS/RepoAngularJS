package ec.com.smx.sic.cliente.gestor.proveedor.administracion.almacenamiento;

import java.util.Collection;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

public interface IAlmacenamientoDatosRolesUsuarioProveedorGestor {

	
	/**
	 * @param proveedorVO
	 * @param sistemas
	 * @return
	 * @throws SICException
	 */
	Collection<IAlmacenamientoDatosRolesUsuarioGestor> obtenerReglasRegistroDatosRolesUsuarioProveedor(ProveedorVO proveedorVO, Set<String> sistemas) throws SICException;


	/**
	 * @param proveedorVO
	 * @param sistemas
	 * @throws SICException
	 */
	void registarDatosRolesUsuario(ProveedorVO proveedorVO, Set<String> sistemas) throws SICException;

}