/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.proveedor;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import ec.com.smx.corpv2.common.enums.ContactEntityType;
import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.common.proveedor.TipoPersonaEntidad;
import ec.com.smx.sic.cliente.common.proveedor.bean.ResultadoValidacionClasificacionesCompradores;
import ec.com.smx.sic.cliente.common.proveedor.bean.UsuarioProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author lyacchirema
 * 
 */
public interface ICalculoDatosUsuariosProveedorServicio {

	/**
	 * @param codigoCompania
	 * @param codigoJdeProveedorSuperUsuario
	 * @param codigoEntidadProveedorSuperUsuario
	 * @param tipoEntidadProveedorSuperUsuario
	 * @return Collection<VistaProveedorDTO>
	 * @throws SICException
	 */
	Collection<VistaProveedorDTO> obtenerProveedoresAsignadosPorProveedorSuperUsuario(Integer codigoCompania,
			String codigoJdeProveedorSuperUsuario, Long codigoEntidadProveedorSuperUsuario,
			TipoPersonaEntidad tipoEntidadProveedorSuperUsuario) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigoJdeProveedor
	 * @return FuncionarioDTO
	 * @throws SICException
	 */
	FuncionarioDTO obtenerFuncionarioProveedorPorCodigoJde(Integer codigoCompania, String codigoJdeProveedor) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigoProveedorPersona
	 * @param codigoProveedorLocalizacion
	 * @param idsRolesParaIdentificarUsuarios
	 * @return Collection<UsuarioProveedor>
	 * @throws SICException
	 */
	Collection<UsuarioProveedor> obtenerUsuariosProveedor(Integer codigoCompania, String codigoJdeProveedor,
			Long codigoProveedorPersona, Long codigoProveedorLocalizacion) throws SICException;

	/**
	 * @param email
	 * @param codigoSistema
	 * @param codigoEvento
	 * @param codigoCompania
	 * @return Timestamp
	 * @throws SICException
	 */
	Timestamp obtenerFechaEnvioMail(String email , String codigoSistema , String codigoEvento , Integer codigoCompania) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigosJDEProveedor
	 * @return Collection<FuncionarioDTO>
	 * @throws SICException
	 */
	Collection<FuncionarioDTO> obtenerFuncionariosProveedorPorCodigosJde(Integer codigoCompania, Set<String> codigosJDEProveedor) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param proveedorAsignadoList
	 * @return
	 * @throws SICException
	 */
	void validarExistenciaUsuarioFuncionarioPorProveedor(Integer codigoCompania, List<VistaProveedorDTO> proveedorAsignadoList) throws SICException;
	
	/**
	 * 
	 * @param proveedorVO
	 * @param usuariosProveedor
	 * @param contactosRelacionados
	 * @param contactosRelacionadosInicial
	 * @throws SICException
	 */
	void guardarDatosUsuariosB2B(ProveedorVO proveedorVO, Collection<UsuarioProveedor> usuariosProveedor,  DatoContactoPersonaLocalizacionDTO contactoPersonal, Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados,  Long codigoEntidad, ContactEntityType tipoEntidad, Integer cantidadMaximaUsuarios, Integer codigoCompania, String idUser) throws SICException;
	
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
	void guardarDatosProveedoresSuperUsuario(Integer codigoCompania, String codigoJDEProveedor, String codigoFuncionario, 
			String userId, Boolean esSuperUsuario, Collection<VistaProveedorDTO> proveedoresAsignadosTotal, 
			Collection<VistaProveedorDTO> proveedorAsignadoRegistrar) throws SICException;
	
	/**
	 * @param userID
	 * @return
	 * @throws SICException
	 */
	ResultadoValidacionClasificacionesCompradores validarUsuarioClasificacionComprador(String userID) throws SICException;
}
