package ec.com.smx.sic.cliente.gestor.proveedor.administracion.accion;

import java.util.Collection;
import java.util.Set;

import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorMarcaDTO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

public interface IAccionIntegracionRegistroProveedorGestor {

	/**
	 * Integrar con el SIC todos los datos generales de los proveedores
	 * 
	 * @param proveedor
	 * @param resultadoValidacionProveedor
	 * @throws Exception
	 */
	void integrarProveedorSIC(ProveedorVO proveedor , ResultadoValidacionProveedor resultadoValidacionProveedor) throws Exception;

	/**
	 * Integrar con el SIC el registro de las clasificaciones de los proveedores
	 * 
	 * @param proveedorVO
	 * @param coleccionProveedorClasificacion
	 * @throws SICException
	 */
	void integrarProveedorClasificacionSIC(ProveedorVO proveedorVO, Collection<ProveedorClasificacionDTO> coleccionProveedorClasificacion) throws SICException;

	/**
	 * Metodo que integra la clasificacionProveedor desde cualquier otro sistema.
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoJDEProveedor
	 * @param idUsuarioActual
	 * @param codigosClasificacion
	 * @throws SICException
	 */
	void integrarProveedorClasificacionSIC(Integer codigoCompania,String codigoProveedor, String codigoJDEProveedor, String idUsuarioActual,Set<String> codigosClasificacion) throws SICException;

	/**
	 * Integrar con el SIC el registro de las marcas de los proveedores
	 * 
	 * @param proveedorVO
	 * @param coleccionDatosProveedorMarcaModificados
	 * @throws Exception
	 */
	void integrarProveedorMarcaSIC(ProveedorVO proveedorVO, Collection<ProveedorMarcaDTO> coleccionDatosProveedorMarcaModificados) throws Exception;
}