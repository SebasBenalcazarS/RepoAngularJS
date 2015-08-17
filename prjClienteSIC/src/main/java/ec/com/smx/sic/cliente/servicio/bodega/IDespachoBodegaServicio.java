package ec.com.smx.sic.cliente.servicio.bodega;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioPerfilDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.corpv2.dto.ParametrosSubbodegaDTO;
import ec.com.smx.corpv2.dto.PerfilDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FuncionarioPerfilDetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAreaTrabajoBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaGrupoTrabajoPorBodegaDTO;

/**
 * 
 * @author fcollaguazo
 * @author jdvasquez
 *
 */
public interface IDespachoBodegaServicio {

	/**
	 * Obtiene los grupos de despacho por el area de trabajo bodega
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaGrupoTrabajoPorBodegaDTO> obtenerGruposDespacho(AreaTrabajoDTO areaTrabajoBodegaDTO)throws SICException;
	
	/**
	 * Obtiene las todas las areas de trabajo menos los locales que se encuentran en la colección
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerAreasTrabajo(AreaTrabajoDTO areaTrabajoDTO, Collection<Integer> codAreasTrabajoDelGrupo)throws SICException;
	
	/**
	 * Obtiene los locales de un grupo de trabajo
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerAreasTrabajoGrupoTrabajo(GrupoTrabajoDTO grupoTrabajoDTO)throws SICException;
	
	/**
	 * Obtiene los locales bodega de una plantilla dada
	 * @param areaTrabajoDTO
	 * @return Collection<AreaTrabajoDTO>
	 * @throws SICException
	 */
	public Collection<VistaAreaTrabajoBodegaDTO> obtenerAreasTrabajoBodegas(AreaTrabajoDTO areaTrabajoBodegaDTO)throws SICException;
	
	/**
	 * Lista de areas de trabajo de tipo bodega activas 
	 * @return Collection<AreaTrabajoDTO>
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerAreasTrabajoBodegasNombre()throws SICException;
	
	/**
	 * Guarda un nuevo grupo de trabajo con sus areas de trabajo
	 * @param grupoTrabajoDTO
	 * @param grupoAreaTrabajoDTOCol
	 * @throws SICException
	 */
	public void guardarNuevoGrupoTrabajo(GrupoTrabajoDTO grupoTrabajoDTO, VistaAreaTrabajoBodegaDTO areaTrabajoBodegaDTO) throws SICException;
	
	/**
	 * Actualiza un grupo de trabajo con sus areas de trabajo
	 * @param grupoTrabajoDTO
	 * @param areaTrabajoDTO
	 * @throws SICException
	 */
	public void actualizarGrupoTrabajo(GrupoTrabajoDTO grupoTrabajoDTO, Collection<AreaTrabajoDTO> areaTrabajoDTOCol, Collection<Integer> codigosAreasTrabajoElim )throws SICException;
	/**
	 * Obtiene los locales relacionados a una bodega en especifica
	 * @param areaTrabajoBodegaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<GrupoAreaTrabajoDTO> transObtenerLocalesPorBodega(AreaTrabajoDTO areaTrabajoBodegaDTO) throws SICException;
	/**
	 * Actualiza una coleccion de objetos de relacion de GrupoAreaTrabajoDTO enviada como parametro
	 * @param grupoAreaTrabajoCol
	 * @throws SICException
	 */
	public void actualizarGrupoAreaTrabajoCol(Collection<GrupoAreaTrabajoDTO> grupoAreaTrabajoCol) throws SICException;
	/**
	 * Registra la relacion de grupos de trabajo con areas de trabajo
	 * @param codigoGrupoTrabajo
	 * @param areaTrabajoCol
	 * @param codigoCompania
	 * @param usuarioRegistro
	 * @param tipoRelacion
	 * @param codigoRelacion
	 * @throws SICException
	 */
	public void registrarRelacionAreaTrabajoGrupoTrabajo(Long codigoGrupoTrabajo, Collection<AreaTrabajoDTO> areaTrabajoCol, Integer codigoCompania, String usuarioRegistro, String tipoRelacion, String codigoRelacion) throws SICException;
	/**
	 * Crea o actualiza un nuevo parametro de cubicaje de subbodega
	 * @param parametroSubbodegaDTO
	 * @throws SICException
	 */
	public void actualizarParametroSubbodega(ParametrosSubbodegaDTO parametroSubbodegaDTO) throws SICException;
	/**
	 * Retorna una coleccion de perfiles de tipo estructura logistica
	 * @param referenceCode
	 * @return
	 * @throws SICException
	 */
	public Collection<PerfilDTO> obtenerPerfilesEstructuraLogistica(String referenceCode) throws SICException;
	/**
	 * Retorna una coleccion de funcionarios filtrados por perfil
	 * @param funcionarioPerfilDTO
	 * @param codigosUsuariosExclusion
	 * @return
	 * @throws SICException
	 */
	public Collection<FuncionarioPerfilDTO> obtenerFuncionariosPerfil(FuncionarioPerfilDTO funcionarioPerfilDTO, Collection<String> codigosPerfilesExclusion) throws SICException;
	/**
	 * Guarda la relacion de funcionarios con secciones
	 * @param codigoCompania
	 * @param userId
	 * @param codigoDetalleSeccion
	 * @param listaFuncionarioPerfilDTO
	 * @throws SICException
	 */
	public void guardarRelacionFuncionarioSeccion(Integer codigoCompania, String userId, Long codigoDetalleSeccion, Collection<FuncionarioPerfilDTO> listaFuncionarioPerfilDTO) throws SICException;
	/**
	 * Retorna una coleccion objetos de relacion de funcionarios con secciones
	 * @param funcionarioPerfilDetalleSeccionDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<FuncionarioPerfilDetalleSeccionDTO> obtenerRelacionFuncionariosSeccion(FuncionarioPerfilDetalleSeccionDTO funcionarioPerfilDetalleSeccionDTO) throws SICException;
	/**
	 * Desactivar la relacion de funcionarios con secciones
	 * @param listaFuncionarioSeccionDTO
	 * @throws SICException
	 */
	public void desactivarRelacionFuncionarioSeccion(Integer codigoCompania, Collection<FuncionarioPerfilDetalleSeccionDTO> listaFuncionarioSeccionDTO) throws SICException;
	/**
	 * Guarda la relacion de funcionarios con secciones
	 * @param codigoCompania
	 * @param userId
	 * @param codigoAreaTrabajo
	 * @param listaFuncionarioPerfilDTO
	 * @throws SICException
	 */
	public void guardarRelacionFuncionarioAreaTrabajo(Integer codigoCompania, String userId, Integer codigoAreaTrabajo, Collection<FuncionarioPerfilDTO> listaFuncionarioPerfilDTO) throws SICException;
	/**
	 * Desactivar la relacion de funcionarios con area trabajo
	 * @param codigoCompania
	 * @param userId
	 * @param codigoAreaTrabajo
	 * @param codigoFuncionario
	 * @throws SICException
	 */
	public void desactivarRelacionFuncionarioAreaTrabajo(Integer codigoCompania, String userId, Integer codigoAreaTrabajo, String codigoFuncionario) throws SICException;

	/**
	 * Permite actualizar el tipo de desapacho y tipo de asignacion de tareas
	 * @param subbBodegaCol
	 * @param userId
	 * @throws SICException
	 */
	public void actualizarTipoDespachoAsignacionSubbodega(Collection<AreaTrabajoDTO> subbBodegaCol, String userId)throws SICException;
	/**
	 * Obtiene una lista de locales disponibles para la asignacion a los grupos de despacho
	 * @param codigoBodega
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerLocalesDisponibles(Integer codigoBodega) throws SICException;
	/**
	 * Permite desactivar la relacion de grupos de trabajo con areas de trabajo
	 * @param userId
	 * @param codigoGrupoTrabajo
	 * @param listaAreasTrabajoEliminar
	 * @throws SICException
	 */
	public void desactivarRelacionGrupoTrabajoAreaTrabajo(String userId, Long codigoGrupoTrabajo, Collection<GrupoAreaTrabajoDTO> listaAreasTrabajoEliminar) throws SICException;
	/**
	 * Permite desactivar la relacion de grupos de trabajo con areas de trabajo
	 * @param codigoAreaTrabajo
	 * @param codigoGrupoTrabajo
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	public void desactivarRelacionAreaTrabajoGrupoTrabajo(Integer codigoAreaTrabajo, Long codigoGrupoTrabajo, Integer codigoCompania, String userId) throws SICException;
	/**
	 * Permite realizar la asignacion automatica de locales a grupos de despachos
	 * @param numeroGruposCrear
	 * @param codigoAreaTrabajo
	 * @param userId
	 * @return 
	 * @throws SICException
	 */
	public Integer asignacionAutomaticaLocalesGruposDespacho(Integer numeroGruposCrear, Integer codigoAreaTrabajo, String userId) throws SICException;
	/**
	 * Actualiza la relacion grupo trabajo areatrabajo
	 * @param grupoAreaTrabajoDTO
	 * @throws SICException
	 */
	public void actualizarGrupoAreaTrabajo(GrupoAreaTrabajoDTO grupoAreaTrabajoDTO) throws SICException;
	/**
	 * Obtiene una lista de locales asignados a un grupo de despacho especifico
	 * @param codigoCompania
	 * @param codigoGrupoDespacho
	 * @return
	 * @throws SICException
	 */
	public Collection<GrupoAreaTrabajoDTO> obtenerLocalesAsignadosGrupoDespacho(Integer codigoCompania, Long codigoGrupoDespacho) throws SICException;

	

}
