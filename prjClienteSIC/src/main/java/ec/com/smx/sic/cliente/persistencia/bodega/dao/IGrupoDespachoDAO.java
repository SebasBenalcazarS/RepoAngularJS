package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaAreaTrabajoBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaGrupoTrabajoPorBodegaDTO;

/**
 * 
 * @author cortiz
 * @author jdvasquez
 *
 */
public interface IGrupoDespachoDAO {

	/**
	 * Obtiene las areas de trabajo de tipo bodega con 
	 * @param areaTrabajoDTOPlantilla
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaAreaTrabajoBodegaDTO> obtenerAreasTrabajoBodegas(AreaTrabajoDTO areaTrabajoBodegaDTO) throws SICException;
	/**
	 * Obtiene una coleccion de los grupos de trabajo relacionados a una bodega especifica
	 * @param areaTrabajoBodegaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaGrupoTrabajoPorBodegaDTO> obtenerGruposTrabajoPorBodega(AreaTrabajoDTO areaTrabajoBodegaDTO) throws SICException;
	/**
	 * Permite insertar la relacion de grupos de trabajo tipo prioridad con las areas de trabajo tipo local
	 * @param codigoGrupoTrabajo
	 * @throws SICException
	 */
	public void asignarRelacionGrupoTrabajoPrioridadLocales(Long codigoGrupoTrabajo, String usuarioRegistro) throws SICException;
	/**
	 * Permite insertar la relacion de grupos de trabajo con areas de trabajo
	 * @param codigoGrupoTrabajo
	 * @param cadenaCodigosAreaTrabajo
	 * @param codigoCompania
	 * @param usuarioRegistro
	 * @param tipoRelacion
	 * @param codigoRelacion
	 * @throws SICException
	 */
	public void insertarRelacionAreaTrabajoGrupoTrabajo(Long codigoGrupoTrabajo, String cadenaCodigosAreaTrabajo, Integer codigoCompania, String usuarioRegistro, String tipoRelacion, String codigoRelacion) throws SICException;
	/**
	 * Permite actualizar la relacion inactiva de grupos de trabajo con areas de trabajo
	 * @param codigoGrupoTrabajo
	 * @param cadenaCodigosAreaTrabajo
	 * @param codigoCompania
	 * @param usuarioRegistro
	 * @param tipoRelacion
	 * @param codigoRelacion
	 * @throws SICException
	 */
	public void actualizarRelacionAreaTrabajoGrupoTrabajo(Long codigoGrupoTrabajo, String cadenaCodigosAreaTrabajo, Integer codigoCompania, String usuarioRegistro, String tipoRelacion, String codigoRelacion) throws SICException;
	/**
	 * 
	 * @param codigoBodega
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerLocalesDisponibles(Integer codigoBodega) throws SICException;
	 /**
	  * 
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
	  * @return Integer
	  * @throws SICException
	  */
	 public Integer asignacionAutomaticaLocalesGruposDespacho(Integer numeroGruposCrear, Integer codigoAreaTrabajo, String userId) throws SICException;
	 /**
	  * 
	  * @param codigoCompania
	  * @param codigoGrupoDespacho
	  * @return
	  * @throws SICException
	  */
	 public Collection<GrupoAreaTrabajoDTO> obtenerLocalesAsignadosGrupoDespacho(Integer codigoCompania, Long codigoGrupoDespacho) throws SICException;
	 
}
