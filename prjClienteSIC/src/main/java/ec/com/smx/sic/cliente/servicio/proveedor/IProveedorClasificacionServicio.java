/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.proveedor;

import java.util.Collection;
import java.util.List;

import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAsignacionDescuento;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosOrdenCompra;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionTipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author Victor Jaramillo
 *
 */
public interface IProveedorClasificacionServicio {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 */
	Collection<ProveedorClasificacionDTO> obtenerProveedorClasificacionPorProveedor(Integer codigoCompania, String codigoProveedor, String codigoFuncionarioSession) throws SICException;
	
	/**
	 * Metodo para obtener la clasificacion de un proveedor.
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoClasificacion
	 * @return
	 * @throws SICException
	 */
	ProveedorClasificacionDTO obtenerProveedorClasificacionPorCodigoProveedor(Integer codigoCompania, String codigoProveedor, String codigoClasificacion, String codigoFuncionarioSession) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param tipoAsignacion "PRO" - "ART" segun Catalogo valor
	 * @param codigoClasificacion
	 * @return
	 * @throws SICException
	 */
	Collection<DescuentoProveedorClasificacionDTO> obtenerDescuentoPorProveedorClasificacion(Integer codigoCompania, String codigoProveedor, String codigoClasificacion) throws SICException;

	
	/**
	 * @param codigoCompania
	 * @param tipoAsignacionDescuento
	 * @return
	 * @throws SICException
	 */
	Collection<AsignacionTipoDescuentoDTO> obtenerAsignacionesDescuentos(Integer codigoCompania, EnumTipoAsignacionDescuento tipoAsignacionDescuento) throws SICException;


	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigosClasificacion
	 * @return
	 */
	public Collection<ArticuloProveedorDTO> obtenerArticulosProveedorClasificacion(Integer codigoCompania, String codigoProveedor, List<String> codigosClasificacion);

	
	/**
	 * @param codigoCompania
	 * @param listaProveedorClasificacion
	 * @param listaAsignacionTipoDescuento
	 * @throws SICException
	 */
	void completarDescuentosProveedorClasificacion(Integer codigoCompania,
			Collection<ProveedorClasificacionDTO> listaProveedorClasificacion, Collection<AsignacionTipoDescuentoDTO> listaAsignacionTipoDescuento) throws SICException;

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
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param clasificacionesProveedorInicial
	 * @param clasificacionesProveedorEliminar
	 * @return
	 * @throws SICException
	 */
	public Collection<ProveedorClasificacionDTO> eliminarClasificacionesDescuentos(ProveedorVO proveedorVO, Integer codigoCompania, String codigoProveedor ,String idUser, Collection<ProveedorClasificacionDTO> clasificacionesProveedorInicial, Collection<ProveedorClasificacionDTO> clasificacionesProveedorEliminar) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	public Boolean validarClasificacionesExistentesLineaComercial( Integer codigoCompania, 
			String codigoFuncionario, String codigoProceso) throws SICException;
	
	/**
	 * 
	 * @param proveedorClasificaciones
	 * @throws SICException
	 */
	public void obtenerDescuentosProveedorClasificaciones(Integer codigoCompania, Collection<ProveedorClasificacionDTO> proveedorClasificaciones) throws SICException;
	
	
	/**
	 * Funcion para poder actualizar los descuentos en los articulos de la clasificacion del Proveedor
	 * @param proveedorClasificacionDTOs
	 * @param codigoTipoProcesoIntegracion
	 * @param idUsuarioRegistro
	 * @param sincronizarDescuentoNotaCredito
	 * @param proveedorVO
	 * @throws SICException
	 */
	public abstract void actualizarClasificacionArticuloProveedor(Collection<ProveedorClasificacionDTO> proveedorClasificacionDTOs, Integer codigoTipoProcesoIntegracion, String idUsuarioRegistro, Boolean sincronizarDescuentoNotaCredito, ProveedorVO proveedorVO, Collection<DatosOrdenCompra> ordenesCompra) throws SICException;

	/**
	 * Funcion para poder obtener los descuentos en los articulos de la clasificacion del Proveedor
	 * @param proveedorVO
	 * @param codigoProveedor
	 * @param clasificacionesProveedorInicial
	 * @param clasificacionesProveedorAlmacenar
	 * @return
	 * @throws SICException
	 */
	public Collection<ProveedorClasificacionDTO> obtenerClasificacionesProveedorActualizacionArticulos(ProveedorVO proveedorVO, String codigoProveedor, Collection<ProveedorClasificacionDTO> clasificacionesProveedorInicial, Collection<ProveedorClasificacionDTO> clasificacionesProveedorAlmacenar) throws SICException; 
	
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
