package ec.com.smx.sic.cliente.servicio.proveedorAreaTrabajo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorAreaTrabajoDTO;

/**
 * 
 * @author ivasquez
 *
 */

public interface IProveedorAreaTrabajoServicio extends Serializable {

	/**
	 * Obtener todas las areas de trabajo que posee un proveedor
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<ProveedorAreaTrabajoDTO> obtenerTotalProveedorAreaTrabajo(Integer codigoCompania, String codigoProveedor) throws SICException;

	/**
	 * Obtener todas las areas de trabajo que pertenezcan unicamente a oficina
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param nombreAreaTrabajo
	 * @param codigoCentroCosto
	 * @param codigosAreasTrabajoAsigandas
	 * @return
	 * @throws SICException
	 */
	Collection<AreaTrabajoDTO> obtenerAreaTrabajoTipoOficinaConFiltros(Integer codigoCompania, Integer codigoAreaTrabajo, String nombreAreaTrabajo, String codigoCentroCosto, List<Integer> codigosAreasTrabajoAsigandas) throws SICException;

	/**
	 * Obtener los datos del proveedor area trabajo que se va a registrar como nuevo
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param areaTrabajoNuevas
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	ProveedorAreaTrabajoDTO establecerDatosProveedorAreaTrabajoNueva(Integer codigoCompania, String codigoProveedor, AreaTrabajoDTO areaTrabajoNuevas, String userId) throws SICException;

	/**
	 * Guardar las areas de trabajo de los proveedores de servicio
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
	 * Actualizar los campos predeterminados de las areas de trabajo del proveedor
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
