package ec.com.smx.sic.cliente.gestor.proveedor.usuariosproveedor.calculo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.common.proveedor.TipoPersonaEntidad;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;

/**
 * @author Luis Yacchirema
 *
 */
public interface ICalculoDatosFuncionarioProveedorGestor {

	/**
	 * @param codigoCompania
	 * @param codigoJdeProveedorSuperUsuario
	 * @param codigoEntidadProveedorSuperUsuario
	 * @param tipoEntidadProveedorSuperUsuario
	 * @return Collection<VistaProveedorDTO>
	 * @throws SICException
	 */
	Collection<VistaProveedorDTO> obtenerProveedoresAsignadosPorProveedorSuperUsuario(Integer codigoCompania, String codigoJdeProveedorSuperUsuario,
			Long codigoEntidadProveedorSuperUsuario, TipoPersonaEntidad tipoEntidadProveedorSuperUsuario) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoJdeProveedor
	 * @return FuncionarioDTO
	 * @throws SICException
	 */
	FuncionarioDTO obtenerFuncionarioProveedorPorCodigoJde(Integer codigoCompania, String codigoJdeProveedor) throws SICException;

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
}