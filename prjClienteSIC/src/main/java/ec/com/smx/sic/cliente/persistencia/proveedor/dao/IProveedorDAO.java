package ec.com.smx.sic.cliente.persistencia.proveedor.dao;

import java.util.Collection;
import java.util.Date;

import org.hibernate.criterion.Criterion;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;

public interface IProveedorDAO {

	/**
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public abstract SearchResultDTO<IProveedor> obtenerProveedores(
			Integer codigoCompania) throws SICException;
	
	/**
	 * Metodo para obtener  una coleccion de proveedores mediante el codigoProveedor
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	public abstract  Collection<ProveedorDTO> obtenerProveedoresPorCodigoProveedor(
			Integer codigoCompania,Collection<String> codigoProveedorCol) throws SICException;

	/**
	 * 
	 * @param cantidadMaximaUsuarios
	 * @param proveedorID
	 * @param userId
	 * @throws SICException
	 */
	void actualizarProveedorB2B(Integer cantidadMaximaUsuarios, ProveedorID proveedorID, String userId) throws SICException;
	
	/**
	 * Obtener un proveedor dado su numero de RUC
	 * 
	 * @param codigoCompania
	 * @param numeroRUC
	 * @return
	 * @throws SICException
	 */
	ProveedorDTO obtenerProveedorPorRUC(Integer codigoCompania, String numeroRUC) throws SICException;
	
	/**
	 * Actualiza la fecha de Inicio de Operaci\u00F3n
	 * 
	 * @param codigoCompania C\u00F3digo de la compa\u00F1ia del proveedor a actualizar
	 * @param codigoProveedor C\u00F3digo del proveedor q actualizar
	 * @param fechaInicioOperacion Fecha de Inicio de de operaci\u00F3n a asignar al proveedor
	 * @param idUsuarioModificacion Id del usuario que ingreso al sistema
	 * @throws SICException
	 */
	void actualizarFechaInicioOperacion(Integer codigoCompania, String codigoProveedor, Date fechaInicioOperacion, String idUsuarioModificacion) throws SICException;
	
	/**
	 * Verifica si el proveedor tiene fecha de inicio de operaci\u00F3n
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 */
	Boolean tieneFechaDeInicioOperacion(Integer codigoCompania, String codigoProveedor) throws SICException;
	
	/**
	 * Metodo para obtener los proveedores
	 * @param proveedor
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<ProveedorDTO> busquedaProveedores(ProveedorDTO proveedor, Criterion criterion)throws SICException;
	
	/**
	 * Metodo para contar la busqueda de proveedores
	 * @param proveedor
	 * @return
	 * @throws SICException
	 */
	public Long contarBusquedaProveedores(ProveedorDTO proveedor, Criterion criterion)throws SICException;
	
	/**
	 * Verifica si el proveedor tiene la caracteristica:
	 * Factura En Sitio
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 */
	public String obtenerFacturaEnSitioProveedor(Integer codigoCompania, String codigoProveedor);
	
	/**
	 * Metodo para obtener la caracteristica esImportador
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 */
	String obtenerEsImportador(Integer codigoCompania, String codigoProveedor)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoJDE
	 * @return
	 * @throws SICException
	 */
	ProveedorDTO obtenerProveedorPorJDE(final Integer codigoCompania, final String codigoJDE) throws SICException;
	
	/**
	 * Obtiene los plazos del pago que posee el proveedor
	 * @param codigoCompania
	 * @param codigoJDE
	 * @return
	 * @throws SICException
	 */
	Collection<ProveedorClasificacionDTO> obtenerPlazoPagoProveedorClasificacion(Integer codigoCompania, String codigoJDE)throws SICException;
	
	/**
	 * Metodo que obtiene los usuarios  de proveedroes que no ha realizado la actualizacion de precios.
	 * @param  Collection<String>
	 */
	Collection<Object[]> obtenerProveedoresRegistroCompracionPrecios(Collection<String> codigoProveedores)throws SICException;

	/**
	 * Inactivar los perfiles de un funcionario determinado para activar solo los necesarios
	 * 
	 * @author ivasquez
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param userId
	 * @throws SICException
	 */
	void inactivarEstadosPerfilesFuncionario(Integer codigoCompania, String codigoFuncionario, String userId) throws SICException;
}