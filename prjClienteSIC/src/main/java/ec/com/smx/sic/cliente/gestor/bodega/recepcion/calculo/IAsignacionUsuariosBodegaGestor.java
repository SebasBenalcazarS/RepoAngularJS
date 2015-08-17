package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.DetalleConfiguracionProcesoPerfilDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.FuncionarioLogisticoDTO;
import ec.com.smx.corpv2.dto.ProcesoDTO;
import ec.com.smx.corpv2.dto.ProcesoPerfilTipoSeccionDTO;
import ec.com.smx.corpv2.exception.CorporativoException;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAsignacionUsuariosBodegaDTO;
import ec.com.smx.sic.cliente.mdl.vo.MantenimientoUsuariosBodegaVO;
import ec.com.smx.sic.cliente.mdl.vo.VistaAsignacionUsuariosVO;

/**
 * @author cpescobar
 *
 */
public interface IAsignacionUsuariosBodegaGestor {
	
	/**
	 * @param asignacionUsuariosVO
	 * @return
	 * @throws SICException
	 */
	VistaAsignacionUsuariosVO obtenerVistaAsignacionUsuariosPaginado(VistaAsignacionUsuariosVO asignacionUsuariosVO) throws SICException;
	
	/**
	 * Consulta el catalogo valor 
	 * @param codigoCatalogoTipo
	 * @return
	 * @throws SICException
	 */
	Collection<CatalogoValorDTO> obtenerCatalogo (Integer codigoCatalogoTipo) throws SICException;
	
	/**
	 * Consulta los procesos asociados al perfil Logistico
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<ProcesoDTO> obtenerProcesosLogisticos(Integer codigoCompania, Collection<AreaTrabajoDTO> subbodegasUsuario) throws SICException;
	
	/**
	 * @param cuentaUsuario
	 * @return
	 * @throws SICException
	 */
	Collection<FuncionarioDTO> obtenerFuncionariosPerfilLogistico(String cuentaUsuario, String nombreUsuario) throws SICException;
	
	/**
	 * @param funcionarioLogistico
	 * @param userId
	 * @param fechaModificacion
	 * @param catalogoValorEstadoUsuario
	 * @param colSecuencialFuncionarioLogistico
	 * @throws CorporativoException
	 */
	void actualizarEstadoFuncionarioLogistico(FuncionarioLogisticoDTO funcionarioLogistico, String codigoPerfil,
			String userId, Timestamp fechaModificacion, String catalogoValorEstadoUsuario, Collection<Long> colSecuencialFuncionarioLogistico) throws CorporativoException;
	
	/**
	 * @param funcionarioLogistico
	 * @param codigoPerfil
	 * @param userId
	 * @param fechaModificacion
	 * @param catalogoValorEstadoUsuario
	 * @param colSecuencialFuncionarioLogistico
	 * @throws CorporativoException
	 */
	void actualizarDisponibilidadFuncionarioLogistico(FuncionarioLogisticoDTO funcionarioLogistico, String codigoPerfil,
			String userId, Timestamp fechaModificacion, String catalogoValorEstadoUsuario, Collection<Long> colSecuencialFuncionarioLogistico) throws CorporativoException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoPerfil
	 * @return
	 * @throws SICException
	 */
	public HashMap<Integer, Collection<DetalleConfiguracionProcesoPerfilDTO>> obtenerConfiguraciones (Integer codigoCompania, Collection<String> codigoPerfil) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoProceso
	 * @param codigoPerfil
	 * @return
	 * @throws SICException
	 */
	Collection<ProcesoPerfilTipoSeccionDTO> obtenerProcesoPerfilSeccion (Integer codigoCompania, Long codigoProceso, String codigoPerfil) throws SICException;


	
	/**
	 * @param codigoReferencia
	 * @param codigoCompania
	 * @param tipoAreaTrabajoValor
	 * @return
	 * @throws SICException
	 */
	Collection<AreaTrabajoDTO> obtenerAreaTrabajo(Integer codigoReferencia ,Integer codigoCompania, String tipoAreaTrabajoValor) throws SICException;
	
	/**
	 * Metodo para registrar o actualizar el funcionario proceso perfil
	 * @param mantenimientoUsuariosBodegaVO
	 * @return
	 * @throws SICException
	 */
	public void transAsignacionFuncionarioProcesoPerfil(Integer codigoCompania, String userId, String codigoFuncionario, DetalleConfiguracionProcesoPerfilDTO detalleConfiguracionProcesoPerfilDTO) throws SICException;
	
	/**
	 * Metodo para registrar o actualizar el funcionario proceso perfil areatrabajo
	 * @param mantenimientoUsuariosBodegaVO
	 * @throws SICException
	 */
	void transAsignacionFuncionarioProcesoPerfilAreaTrabajo(MantenimientoUsuariosBodegaVO mantenimientoUsuariosBodegaVO, AreaTrabajoDTO areaTrabajoSeleccionada) throws SICException;
	
	/**
	 * @param mantenimientoUsuariosBodegaVO
	 * @return
	 * @throws SICException
	 */
	VistaAsignacionUsuariosBodegaDTO registrarAsignacionUsuariosPerfil(MantenimientoUsuariosBodegaVO mantenimientoUsuariosBodegaVO) throws SICException;
	
	/**
	 * 
	 * @param mantenimientoUsuariosBodegaVO
	 * @param rangoInicio
	 * @param rangoFin
	 * @param andenEspecifico
	 * @throws SICException
	 */
	void transRegistrarAndenes(Integer codigoCompania, String codigoFuncionario, Integer areaTrabajo, Integer sublugarTrabajo, String userId, DetalleConfiguracionProcesoPerfilDTO detalleConfiguracionProcesoPerfilDTO, Long rangoInicio, Long rangoFin, Long andenEspecifico) throws SICException;
	
	/**
	 * 
	 * @param andenesRemover
	 * @param mantenimientoUsuariosBodegaVO
	 * @param detalleConfiguracionProcesoPerfilDTO
	 * @throws SICException
	 */
	void removerAndenes(Collection<DetalleSeccionDTO> andenesRemover, MantenimientoUsuariosBodegaVO mantenimientoUsuariosBodegaVO, DetalleConfiguracionProcesoPerfilDTO detalleConfiguracionProcesoPerfilDTO) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	Duplex<Collection<AreaTrabajoDTO>, Collection<DetalleConfiguracionProcesoPerfilDTO>>  obtenerProcesosPerfilesAreasTrabajoDetalleSeccionFuncionario(Integer codigoCompania, String codigoFuncionario) throws SICException;
	
	/**
	 * 
	 * @param funcionario
	 * @return
	 * @throws SICException
	 */
	Collection<FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionDTO> obtenerDetallesFuncionarioPorAT(FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionDTO funcionario) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param fechaBusqueda
	 * @param codigoPerfil
	 * @param catalogoTipoEstadoTarea
	 * @param colCatalogoValorEstadoTarea
	 * @return
	 * @throws SICException
	 */
	Collection<TareaDTO> obtenerRecepcionesPorFuncionario(Integer codigoCompania, String codigoFuncionario, Date fechaBusqueda, String codigoPerfil) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param usuariosPerfilEditarCol
	 * @throws SICException
	 */
	void asignarUsuarioProcesoPerfilMasivo(Integer codigoCompania, String userId, Collection<VistaAsignacionUsuariosBodegaDTO> usuariosPerfilEditarCol) throws SICException;
	
	/**
	 * 
	 * @param rangoAndenesRemover
	 * @param mantenimientoUsuariosBodegaVO
	 * @param detalleConfiguracionProcesoPerfilDTO
	 */
	void removerRangoAndenes(Collection<RelacionSeccionDTO> rangoAndenesRemover,MantenimientoUsuariosBodegaVO mantenimientoUsuariosBodegaVO, DetalleConfiguracionProcesoPerfilDTO detalleConfiguracionProcesoPerfilDTO);
}
