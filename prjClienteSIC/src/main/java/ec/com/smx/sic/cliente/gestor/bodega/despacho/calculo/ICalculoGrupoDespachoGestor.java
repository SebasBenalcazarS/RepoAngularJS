package ec.com.smx.sic.cliente.gestor.bodega.despacho.calculo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaAreaTrabajoBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaGrupoTrabajoPorBodegaDTO;

/**
 * 
 * @author cortiz
 *
 */
public interface ICalculoGrupoDespachoGestor {

	/**
	* Obtiene los grupos de despacho por el area de trabajo bodega
	 * @param areaTrabajoDTO
	 * @return Collection<GrupoTrabajoDTO>
	 * @throws SICException
	 */
	Collection<VistaGrupoTrabajoPorBodegaDTO> obtenerGruposDespacho(AreaTrabajoDTO areaTrabajoBodegaDTO) throws SICException;
	
	/**
	 * Obtiene las todas las areas de trabajo menos los locales que se encuentran en la colección
	 * @param areaTrabajoDTO
	 * @return Collection<AreaTrabajoDTO>
	 * @throws SICException
	 */
	Collection<AreaTrabajoDTO> obtenerAreasTrabajo(AreaTrabajoDTO areaTrabajoDTO, Collection<Integer> codAreasTrabajoDelGrupo)throws SICException;
	
	/**
	 * Obtiene los locales de un grupo de trabajo
	 * @param areaTrabajoDTO
	 * @return Collection<AreaTrabajoDTO>
	 * @throws SICException
	 */
	Collection<AreaTrabajoDTO> obtenerAreasTrabajoGrupoTrabajo(GrupoTrabajoDTO grupoTrabajoDTO)throws SICException;
	
	/**
	 * Obtiene los locales bodega de una plantilla dada
	 * @param areaTrabajoDTO
	 * @return Collection<AreaTrabajoDTO>
	 * @throws SICException
	 */
	Collection<VistaAreaTrabajoBodegaDTO> obtenerAreasTrabajoBodegas(AreaTrabajoDTO areaTrabajoBodegaDTO)throws SICException;
	
	/**
	 * Lista de areas de trabajo de tipo bodega activas
	 * @return Collection<AreaTrabajoDTO>
	 * @throws SICException
	 */
	Collection<AreaTrabajoDTO> obtenerAreasTrabajoBodegasNombre()throws SICException;
	/**
	 * Obtiene los locales relacionados a una bodega en especifico
	 * @param areaTrabajoBodegaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<GrupoAreaTrabajoDTO> obtenerLocalesPorBodega(AreaTrabajoDTO areaTrabajoBodegaDTO) throws SICException;
	/**
	 * 
	 * @param codigoBodega
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerLocalesDisponibles(Integer codigoBodega) throws SICException;
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoGrupoDespacho
	 * @return
	 * @throws SICException
	 */
	public Collection<GrupoAreaTrabajoDTO> obtenerLocalesAsignadosGrupoDespacho(Integer codigoCompania, Long codigoGrupoDespacho) throws SICException;

	
	
}
