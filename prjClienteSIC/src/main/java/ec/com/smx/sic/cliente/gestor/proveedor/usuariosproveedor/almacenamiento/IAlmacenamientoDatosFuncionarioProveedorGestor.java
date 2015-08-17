package ec.com.smx.sic.cliente.gestor.proveedor.usuariosproveedor.almacenamiento;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

public interface IAlmacenamientoDatosFuncionarioProveedorGestor extends Serializable {

	/**
	 * Crea el usuario localizacion persona
	 * @param baseVO
	 * @throws SICException
	 */
	
	void registrarFuncionarioPersonaLocalizacion(ProveedorVO baseVO) throws SICException;
	
	
	/**
	 * @param proveedorVO
	 * @throws SICException
	 */
	
	void registrarFuncionarioRelacionadoPorDefecto(ProveedorVO proveedorVO) throws SICException;
	
	
	/**
	 * @param funcionarioID
	 * @param idUsuarioRegistro
	 * @throws SICException
	 */
	
	void asignarEstablecimientosPorDefectoAFuncionario(FuncionarioDTO funcionarioDTO, String idUsuarioRegistro) throws SICException;
	
	
	/**
	 * Registra los super usuarios a los funcionarios de la corporacion
	 * @param ProveedorVO
	 * @throws SICException
	 */
	
	void registrarProveedorFuncionarioRelacionado(ProveedorVO proveedorVO) throws SICException;

	
	/**
	 * Registra los proveedores asignados a un super usuario
	 * @param codigoCompania
	 * @param codigoJDEProveedor
	 * @param codigoFuncionario
	 * @param userId
	 * @param esSuperUsuario
	 * @param proveedoresAsignadosTotal
	 * @param proveedorAsignadoRegistrar
	 * @throws SICException
	 */
	
	void guardarDatosProveedoresSuperUsuario (Integer codigoCompania, String codigoJDEProveedor, String codigoFuncionario, 
			String userId, Boolean esSuperUsuario, Collection<VistaProveedorDTO> proveedoresAsignadosTotal, 
			Collection<VistaProveedorDTO> proveedorAsignadoRegistrar) throws SICException;
	
	
	/**
	 * Inactiva a un proveedor super usuario
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param usuarioId
	 * @throws SICException
	 */
	
	public void inactivarProveedorSuperUsuario (Integer codigoCompania, String codigoFuncionario, String usuarioId) throws SICException;
	
	
	/**
	 * Actualiza los estados de los proveedores asignados 
	 * @param codigoCompania
	 * @param usuarioFuncionario
	 * @param estado
	 * @param usuarioId
	 * @throws SICException
	 */
	
	public void actualizarEstadoFuncionarioProveedorAsignado (Integer codigoCompania, String usuarioFuncionario, String estado, String usuarioId) throws SICException;
	
	
	/**
	 * Registrar un usuario nuevo en los proveedores asignados
	 * @param codigoCompania
	 * @param usuarioFuncionario
	 * @param usuarioId
	 * @throws SICException
	 */
	
	public void registrarFuncionarioProveedorAsignado (Integer codigoCompania, String usuarioFuncionario, String usuarioId) throws SICException;
}