package ec.com.smx.sic.cliente.gestor.bodega.despacho.almacenamiento;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaAreaTrabajoBodegaDTO;

/**
 * 
 * @author cortiz
 *
 */
public interface IAlmacenamientoGrupoDespachoGestor {
	/**
	 * Guarda un nuevo grupo de trabajo con sus areas de trabajo
	 * @param grupoTrabajoDTO
	 * @throws SICException
	 */
	public void guardarNuevoGrupoTrabajo(GrupoTrabajoDTO grupoTrabajoDTO, VistaAreaTrabajoBodegaDTO areaTrabajoBodegaDTO) throws SICException;
	
	/**
	 * Actualiza un grupo de trabajo con sus areas de trabajo
	 * @param grupoTrabajoDTO
	 * @param areaTrabajoDTO
	 * @throws SICException
	 */
	public void actualizarGrupoTrabajo(GrupoTrabajoDTO grupoTrabajoDTO, Collection<AreaTrabajoDTO> areaTrabajoDTOCol,Collection<Integer> codigosAreasTrabajoElim) throws SICException;
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
	 * Permite actualizar el tipo de desapacho y tipo de asignacion de tareas
	 * @param subbBodegaCol
	 * @param userId
	 * @throws SICException
	 */
	public void actualizarTipoDespachoAsignacionSubbodega(Collection<AreaTrabajoDTO> subbBodegaCol, String userId)throws SICException;
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
	 * 
	 * @param numeroGruposCrear
	 * @param codigoAreaTrabajo
	 * @param userId
	 * @return 
	 * @throws SICException
	 */
	public Integer asignacionAutomaticaLocalesGruposDespacho(Integer numeroGruposCrear, Integer codigoAreaTrabajo, String userId) throws SICException;
	/**
	 * 
	 * @param grupoAreaTrabajoDTO
	 * @throws SICException
	 */
	public void actualizarGrupoAreaTrabajo(GrupoAreaTrabajoDTO grupoAreaTrabajoDTO) throws SICException;
}
