package ec.com.smx.sic.cliente.persistencia.proveedor.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionTipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;

public interface IProveedorClasificacionDAO {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoSubbodega
	 * @param codigoFuncionario
	 * @param codigoDepartamento
	 * @return
	 */
	public Integer obtenerPlazoPagoPorSubbodega(
			Integer codigoCompania, String codigoProveedor,
			String codigoSubbodega, String codigoFuncionario,
			String codigoDepartamento);
	
	/**
	 * Metodo para actualizar las clasificaciones por proveedor.
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param userId
	 * @param codigosClasificacion
	 * @throws SICException
	 */
	public abstract void actualizarClasificacionesProveedor(
			Integer codigoCompania, String codigoProveedor, String userId,
			List<String> codigosClasificacion) throws SICException;

	/**
	 * Metodo para la actualizacion de los descuentos segun el codigo proveedor y los codigos de clasificacion.
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param userId
	 * @param codigosClasificaciones
	 * @param porcentaje
	 * @param secuencialDescuentoProveedorClasificacion
	 * @throws SICException
	 */
	public abstract void actualizarDescuentosClasificacionProveedor(
			Integer codigoCompania, String codigoProveedor, String userId,
			List<String> codigosClasificaciones, Double porcentaje, Long secuencialDescuentoProveedorClasificacion) throws SICException;

	/**
	 * Funcion para poder actualizar los descuentos en los articulos de la clasificacion del Proveedor 
	 * @param proveedorClasificacionDTOs
	 * @param codigoTipoProcesoIntegracion
	 * @param idUsuarioRegistro
	 * @param parametroSincronizarNotaCredito
	 * @param sincronizarDescuentoNotaCredito
	 */
	public abstract void actualizarClasificacionArticuloProveedor(Collection<ProveedorClasificacionDTO> proveedorClasificacionDTOs, Integer codigoTipoProcesoIntegracion, String idUsuarioRegistro, Boolean parametroSincronizarNotaCredito,Boolean sincronizarDescuentoNotaCredito);
	
	/**
	 * Recupera el parametro con su valor para sincronizar el descuento nota de credito en condiciones comerciales 
	 * @param codigoCompania
	 * @return 
	 */
	public Boolean buscarParametroSincronizarNotaCredito(Integer codigoCompania) throws SICException;
	
	/**
	 * Recupera el parametro con su valor para sincronizar el descuento nota de credito en condiciones comerciales 
	 * @param codigoCompania
	 * @param codigosClasificaciones
	 * @param codigoProveedor
	 * @return 
	 */
	public Collection<DescuentoProveedorClasificacionDTO> buscarDescuentosProveedorClasificacion(Integer codigoCompania, Set<String> codigosClasificaciones, String codigoProveedor) throws SICException;

	/**
	 * Metodo para consultar el proveedor clasificacion y devolver el mismo si existe.
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoClasificacion
	 * @return
	 * @throws SICException
	 */
	ProveedorClasificacionDTO obtenerProveedorClasificacionActual(Integer codigoCompania, String codigoProveedor, String codigoClasificacion) throws SICException;
	
	/**
	 * Metodo para consultar los articulos pertenecientes a las clasificaciones enviadas.
	 * @param codigoCompania
	 * @param codigosClasificacion
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloProveedorDTO> obtenerArticulosPorProveedorClasificaciones(Integer codigoCompania, String codigoProveedor, Set<String> codigosClasificacion) throws SICException;

	/**
	 * Metodo que permite obtener los codigos de las clasificaciones a partir de un proveedor y los codigos de departamentos
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigosDepartamento
	 * @return
	 */
	Collection<String> obtenerClasificacionesPorDepartamento(Integer codigoCompania, String codigoProveedor, String... codigosDepartamento);
	
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