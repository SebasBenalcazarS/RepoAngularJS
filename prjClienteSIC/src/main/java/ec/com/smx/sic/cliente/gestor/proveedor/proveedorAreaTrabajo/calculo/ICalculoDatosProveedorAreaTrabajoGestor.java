package ec.com.smx.sic.cliente.gestor.proveedor.proveedorAreaTrabajo.calculo;

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

public interface ICalculoDatosProveedorAreaTrabajoGestor extends Serializable {

	/**
	 * Obtener todas las areas de trabajo que tiene un proveedor
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<ProveedorAreaTrabajoDTO> obtenerTotalProveedorAreaTrabajo(Integer codigoCompania, String codigoProveedor) throws SICException;

	/**
	 * Obtener todas las areas de trabajo que pertenecen a oficina
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
	 * Obtener el area de trabajo existente de un proveedor
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	ProveedorAreaTrabajoDTO obtenerProveedorAreaTrabajoExistente(Integer codigoCompania, String codigoProveedor, Integer codigoAreaTrabajo) throws SICException;
}
