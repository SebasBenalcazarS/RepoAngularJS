package ec.com.smx.sic.cliente.persistencia.proveedor.dao;

import java.util.Map;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;

public interface IProveedorFuncionarioRelacionadoDAO {

	/**
	 * Metodo que agrega los super usuarios a los funcionarios de la corporacion
	 * @param codigoCompania
	 * @param codigoFuncionarioCorporacion
	 * @param codigoFuncionarioRelacionado
	 * @param codigoLocalizacionCorporacion
	 * @param userId
	 */

	public abstract void registrarProveedorFuncionarioRelacionado(
			Integer codigoCompania, String codigoFuncionarioCorporacion,
			String codigoFuncionarioRelacionado,
			Long codigoLocalizacionCorporacion, String userId)
			throws SICException;

	/**
	 * Metodo que agrega un proveedor nuevo a un proveedor super usuario
	 * @param codigoCompania
	 * @param codigoFuncionarioSuperusuario
	 * @param userId
	 * @param proveedoresAsignados
	 */

	public abstract void registrarProveedorSuperusuario(Integer codigoCompania,
			String codigoFuncionarioSuperusuario, String userId,
			Map<String, Set<Long>> proveedoresAsignados) throws SICException;

	/**
	 * Metodo que actualiza los proveedores de un usuario super usuario
	 * @param codigoCompania
	 * @param codigoFuncionarioSuperusuario
	 * @param userId
	 * @param proveedoresAsignados
	 * @param estado
	 */

	public abstract void actualizarProveedorSuperusuario(
			Integer codigoCompania, String codigoFuncionarioSuperusuario,
			String userId, Map<String, Set<Long>> proveedoresAsignados,
			String estado) throws SICException;

	/**
	 * Metodo que inactiva a un proveedor super usuario
	 * @param codigoCompania
	 * @param codigoFuncionarioSuperusuario
	 * @param userId
	 */

	public abstract void inactivarProveedorSuperUsuario(Integer codigoCompania,
			String codigoFuncionarioSuperusuario, String userId)
			throws SICException;

	/**
	 * Metodo que actualiza los estados de los usuarios asignados a un proveedor, modificados en el B2B
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param estado
	 * @param userId
	 */

	public abstract void actualizarEstadoFuncionarioProveedorAsignado(
			Integer codigoCompania, String codigoFuncionario, String estado,
			String userId) throws SICException;

	/**
	 * Metodo que agrega usuarios asignados a un proveedor, agregados en el B2B
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoFuncionarioRelacionado
	 * @param userId
	 */

	public abstract void registrarFuncionarioProveedorAsignado(
			Integer codigoCompania, String codigoFuncionario,
			String codigoFuncionarioRelacionado, String userId)
			throws SICException;

}