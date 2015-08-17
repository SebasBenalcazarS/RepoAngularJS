package ec.com.smx.sic.cliente.gestor.proveedor.proveedorAreaTrabajo.almacenamiento;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import ec.com.smx.sic.cliente.mdl.dto.ProveedorAreaTrabajoDTO;

/**
 * 
 * @author ivasquez
 *
 */

public interface IAlmacenamientoDatosProveedorAreaTrabajoGestor extends Serializable {

	/**
	 * Guardar las areas de trabajo del proveedor de servicios
	 * 
	 * @param proveedorAreaTrabajoRegistrar
	 * @param proveedorAreaTrabajoOriginal
	 * @param codigoCompania
	 * @param userId
	 * @param codigoProveedor
	 * @throws Exception
	 */
	void guardarDatosProveedorAreaTrabajo(Collection<ProveedorAreaTrabajoDTO> proveedorAreaTrabajoRegistrar, Collection<ProveedorAreaTrabajoDTO> proveedorAreaTrabajoOriginal, Integer codigoCompania, String userId, String codigoProveedor) throws Exception;

	/**
	 * Actualizar el compo predeterminado del area de trabajo para el proveedor
	 * 
	 * @author jjuma
	 * @param codigoCompania
	 * @param userId
	 * @param codigoAreaTrabajo
	 * @param codigoProveedor
	 * @param areasPredeterminadas
	 * @param predeterminado
	 * @throws Exception
	 */
	void actualizarPredeterminadoAreaTrabajoProveedor(Integer codigoCompania, String userId, Integer codigoAreaTrabajo, String codigoProveedor, List<Integer> areasPredeterminadas, String predeterminado) throws Exception;
}
