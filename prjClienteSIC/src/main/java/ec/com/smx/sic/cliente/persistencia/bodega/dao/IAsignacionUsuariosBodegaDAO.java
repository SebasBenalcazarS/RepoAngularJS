package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.ConfiguracionProcesoDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.FuncionarioLogisticoDTO;
import ec.com.smx.corpv2.dto.ProcesoDTO;
import ec.com.smx.corpv2.dto.ProcesoPerfilTipoSeccionDTO;
import ec.com.smx.sic.cliente.exception.SICException;

public interface IAsignacionUsuariosBodegaDAO {

	/**
	 * Metodo que consulta los procesos asociados al perfil logistico
	 * @param codigoCompania
	 * @param subbodegasUsuario
	 * @return
	 * @throws SICException
	 */
	Collection<ProcesoDTO> obtenerProcesosLogisticos(Integer codigoCompania, Collection<AreaTrabajoDTO> subbodegasUsuario) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoPerfil
	 * @return
	 * @throws SICException
	 */	
	Collection<ConfiguracionProcesoDTO> obtenerConfiguraciones (Integer codigoCompania, Collection<String> codigoPerfil) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoProceso
	 * @param codigoPerfil
	 * @return
	 * @throws SICException
	 */
	Collection<ProcesoPerfilTipoSeccionDTO> obtenerProcesoPerfilSeccion (Integer codigoCompania, Long codigoProceso, String codigoPerfil ) throws SICException;

	/**
	 * 
	 * @param cuentaUsuario
	 * @param nombreUsuario
	 * @return
	 * @throws SICException
	 */
	Collection<FuncionarioDTO> obtenerFuncionariosPerfilLogistico(String cuentaUsuario, String nombreUsuario) throws SICException;
	
	/**
	 * 
	 * @param funcionarioLogisticoDTO
	 * @return
	 * @throws SICException
	 */
	FuncionarioLogisticoDTO verificarExistenciaFuncionarioLogistico(FuncionarioLogisticoDTO funcionarioLogisticoDTO) throws SICException;
}
