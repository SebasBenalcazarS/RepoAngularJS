/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.condicionescomerciales.calculo;

import java.util.Collection;
import java.util.List;

import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAsignacionDescuento;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionTipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;

/**
 * @author Victor Jaramillo
 *
 */
public interface ICalculoProveedorClasificacionGestor {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 */
	public Collection<ProveedorClasificacionDTO> obtenerProveedorClasificacionesPorCodigoProveedor(Integer codigoCompania, String codigoProveedor, String codigoFuncionarioSession) throws SICException;

	/**
	 * Metodo para obtener la clasificacion de un proveedor.
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoClasificacion
	 * @return
	 * @throws SICException
	 */
	public ProveedorClasificacionDTO obtenerProveedorClasificacionPorCodigoProveedor(Integer codigoCompania, String codigoProveedor, String codigoClasificacion, String codigoFuncionarioSession) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param tipoAsignacion "PRO" - "ART" segun Catalogo valor
	 * @param codigoClasificacion
	 * @return
	 * @throws SICException
	 */
	public Collection<DescuentoProveedorClasificacionDTO> obtenerDescuentosPorProveedorClasificacion(Integer codigoCompania, String codigoProveedor, String codigoClasificacion) throws SICException;

	
	/**
	 * @param codigoCompania
	 * @param tipoAsignacionDescuento
	 * @return
	 * @throws SICException
	 */
	public Collection<AsignacionTipoDescuentoDTO> obtenerAsignacionesDescuentos(Integer codigoCompania, EnumTipoAsignacionDescuento tipoAsignacionDescuento) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigosClasificacion
	 * @return
	 */
	public Collection<ArticuloProveedorDTO> obtenerArticulosProveedorClasificacion(Integer codigoCompania, String codigoProveedor, List<String> codigosClasificacion);

	/**
	 * 
	 * @param proveedorClasificaciones
	 * @throws SICException
	 */
	public void obtenerDescuentosProveedorClasificaciones(Integer codigoCompania, Collection<ProveedorClasificacionDTO> proveedorClasificaciones) throws SICException;
	
	/**
	 * Metodo que permite obtener las asignaciones tipo descuento
	 * @author mhidalgo
	 * @param codigoCompania
	 * @param valorTipoAsignacion
	 * @param secuencialAsignacionTipoDescuento
	 * @return
	 */
	Collection<AsignacionTipoDescuentoDTO> obtenerSecuencialesAsignacionTipoDescuento(Integer codigoCompania) throws SICException;
}
