/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.usuariosproveedor.calculo;

import java.sql.Timestamp;
import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.vo.FuncionarioVO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.proveedor.bean.ResultadoValidacionClasificacionesCompradores;
import ec.com.smx.sic.cliente.common.proveedor.bean.UsuarioProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author lyacchirema
 * @author Mario Braganza
 *
 */
public interface ICalculoDatosUsuariosProveedorGestor {


	/**
	 * @param codigoCompania
	 * @param codigoJdeProveedor
	 * @param codigoProveedorPersona
	 * @param codigoProveedorLocalizacion
	 * @return
	 * @throws SICException
	 */
	Collection<UsuarioProveedor> obtenerUsuariosProveedor(Integer codigoCompania, String codigoJdeProveedor,
			Long codigoProveedorPersona, Long codigoProveedorLocalizacion) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoJdeProveedor
	 * @param codigoProveedorPersona
	 * @param codigoProveedorLocalizacion
	 * @param cuentaUsuario
	 * @return
	 * @throws SICException
	 */
	public Collection<UsuarioProveedor> obtenerUsuariosProveedorPorCuenta(Integer codigoCompania, String codigoJdeProveedor,
			Long codigoProveedorPersona, Long codigoProveedorLocalizacion,String cuentaUsuario) throws SICException;

	/**
	 * 
	 * @param usuariosProveedor
	 * @return
	 */
	Collection<String> obtenerEmailsModificadosUsuariosProveedor(Collection<UsuarioProveedor> usuariosProveedor) throws SICException;


	/**
	 * 
	 * @param proveedorVO
	 * @return
	 */
	String construirIdUsuario(String codigoProveedor, String rellenoCodigoJDE,
			Integer longitudRellenoJDE);

	/**
	 * 
	 * @param proveedorVO
	 * @return
	 */
	String construirCuentaUsuario(String codigoProveedor);

	/**
	 * 
	 * @param proveedorVO
	 * @return
	 * @throws SICException
	 */
	String construirNombreCompletoUsuario(ProveedorVO proveedorVO) throws SICException;

	/**
	 * 
	 * @return
	 */
	String generarPasswordInicialUsuario();

	/**
	 * 
	 * @param proveedorVO
	 * @return
	 */
	String construirEmailUsuarioProveedor(ProveedorVO proveedorVO, Collection<String> emailsUsuariosModificados, String emailPorDefecto);


	/**
	 * 
	 * 
	 * @param codigoCompania
	 * @return
	 */
	String obtenerIdUsuarioAdministradorDefecto(Integer codigoCompania);

	/**
	 * 
	 * @param proveedorVO
	 * @return
	 * @throws SICException
	 */
	UserDto obtenerUsuarioProveedorPorJDE(String codigoJDE)
			throws SICException;

	/**
	 * 
	 * @param proveedorVO
	 * @param user
	 * @return
	 * @throws SICException
	 */
	FuncionarioVO construirFuncionarioUsuarioProveedor(ProveedorVO proveedorVO, 
			UserDto user,
			FuncionarioDTO funcionario) throws SICException;


	/**
	 * 
	 * @param proveedorVO
	 * @return
	 * @throws SICException
	 */
	UserDto construirUsuarioProveedor(ProveedorVO proveedorVO, Collection<String> emailsUsuariosModificados) throws SICException;


	/**
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	FuncionarioDTO obtenerFuncionarioPorUsuarioAdministradorDefecto(Integer codigoCompania) throws SICException;

	public Timestamp obtenerFechaEnvioMail(String email , String codigoSistema , String codigoEvento , Integer codigoCompania) throws SICException;
	
	/**
	 * @param userID
	 * @return
	 * @throws SICException
	 */
	ResultadoValidacionClasificacionesCompradores validarUsuarioClasificacionComprador(String userID) throws SICException;
}
