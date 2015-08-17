package ec.com.smx.sic.cliente.persistencia.proveedor.dao;

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

public interface IProveedorAreaTrabajoDAO {

	/**
	 * Obtener todas las areas de trabajo que tiene un proveedor
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<ProveedorAreaTrabajoDTO> obtenerTotalProveedorAreaTrabajo(Integer codigoCompania, String codigoProveedor) throws SICException;

	/**
	 * Obtener las areas de trabajo tipo oficina
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param nombreAreaTrabajo
	 * @param codigoCentroCosto
	 * @param codigosAreasTrabajoAsigandas
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<AreaTrabajoDTO> obtenerAreaTrabajoTipoOficinaConFiltros(Integer codigoCompania, Integer codigoAreaTrabajo, String nombreAreaTrabajo, String codigoCentroCosto, List<Integer> codigosAreasTrabajoAsigandas) throws SICException;

	/**
	 * Actuaizar las areas de trabajo de un proveedor
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param estado
	 * @param userId
	 * @param codigosAreaTrabajo
	 * @throws SICException
	 */
	public abstract void actualizarProveedorAreaTrabajo(Integer codigoCompania, String codigoProveedor, String estado, String userId, List<Integer> codigosAreaTrabajo) throws SICException;

	/**
	 * Obtener el area de trabajo de un proveedor si ya existe
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public abstract ProveedorAreaTrabajoDTO obtenerProveedorAreaTrabajoExistente(Integer codigoCompania, String codigoProveedor, Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 * Actualizar los campos predeterminados de las areas de trabajo de un proveedor
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
	public abstract void actualizarPredeterminadoAreaTrabajoProveedor(Integer codigoCompania, String userId, Integer codigoAreaTrabajo, String codigoProveedor, List<Integer> areasPredeterminadas, String predeterminado) throws Exception;
}
