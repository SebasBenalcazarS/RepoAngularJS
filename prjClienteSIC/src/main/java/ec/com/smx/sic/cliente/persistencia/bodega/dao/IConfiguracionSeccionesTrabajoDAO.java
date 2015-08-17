/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioPerfilDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FuncionarioPerfilDetalleSeccionDTO;

/**
 * @author jdvasquez
 *
 */
public interface IConfiguracionSeccionesTrabajoDAO {
	/**
	 * Obtiene los funcionarios filtrados por perfil
	 * @param funcionarioPerfilDTO
	 * @param codigosUsuariosExclusion
	 * @return
	 * @throws SICException
	 */
	public Collection<FuncionarioPerfilDTO> obtenerFuncionariosPerfil(FuncionarioPerfilDTO funcionarioPerfilDTO, Collection<String> codigosPerfilesExclusion) throws SICException;
	/**
	 * 
	 * @param funcionarioPerfilDetalleSeccionDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<FuncionarioPerfilDetalleSeccionDTO> obtenerRelacionFuncionariosSeccion(FuncionarioPerfilDetalleSeccionDTO funcionarioPerfilDetalleSeccionDTO) throws SICException;

}
