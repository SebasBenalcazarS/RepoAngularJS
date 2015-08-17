/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.condicionescomerciales.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosOrdenCompra;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author Victor Jaramillo
 *
 */
public interface IAlmacenamientoProveedorClasificacionGestor {

	/**
	 * 
	 * @param proveedorVO
	 * @param codigoProveedor
	 * @param clasificacionesProveedorInicial
	 * @param clasificacionesProveedorAlmacenar
	 * @param sincronizarDescuentoNotaCredito
	 * @throws SICException
	 */
	public Collection<ProveedorClasificacionDTO> guardarClasificacionesProveedor(ProveedorVO proveedorVO,String codigoProveedor , Collection<ProveedorClasificacionDTO> clasificacionesProveedorInicial, Collection<ProveedorClasificacionDTO> clasificacionesProveedorAlmacenar,Boolean sincronizarDescuentoNotaCredito) throws SICException;
	
	/**
	 * 
	 * @param proveedorClasificacion
	 * @throws SICException
	 */
	public void almacenarClasificacionProveedor(ProveedorClasificacionDTO proveedorClasificacion) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param clasificacionesProveedorInicial
	 * @param clasificacionesProveedorEliminar
	 * @return
	 * @throws SICException
	 */
	public Collection<ProveedorClasificacionDTO> eliminarClasificacionesDescuentos(ProveedorVO proveedorVO,Integer codigoCompania, String codigoProveedor , String idUser, Collection<ProveedorClasificacionDTO> clasificacionesProveedorInicial, Collection<ProveedorClasificacionDTO> clasificacionesProveedorEliminar) throws SICException;
	
	
	/**
	 * Funcion para poder actualizar los descuentos en los articulos de la clasificacion del Proveedor
	 * @param proveedorClasificacionDTOs
	 * @param codigoTipoProcesoIntegracion
	 * @param idUsuarioRegistro
	 * @param sincronizarDescuentoNotaCredito
	 * @param proveedorVO
	 * @param ordenesCompra
	 * @throws SICException
	 */
	public void actualizarClasificacionArticuloProveedor(Collection<ProveedorClasificacionDTO> proveedorClasificacionDTOs, Integer codigoTipoProcesoIntegracion, String idUsuarioRegistro,Boolean sincronizarDescuentoNotaCredito, ProveedorVO proveedorVO, Collection<DatosOrdenCompra> ordenesCompra) throws SICException;
	
	
	/**
	 * Funcion para poder obtener los descuentos en los articulos de la clasificacion del Proveedor
	 * @param proveedorVO
	 * @param codigoProveedor
	 * @param clasificacionesProveedorInicial
	 * @param clasificacionesProveedorAlmacenar
	 * @return
	 * @throws SICException
	 */
	public Collection<ProveedorClasificacionDTO> obtenerClasificacionesProveedorActualizacionArticulos(
			ProveedorVO proveedorVO,
			String codigoProveedor,
			Collection<ProveedorClasificacionDTO> clasificacionesProveedorInicial,
			Collection<ProveedorClasificacionDTO> clasificacionesProveedorAlmacenar)
			throws SICException;
	
}
