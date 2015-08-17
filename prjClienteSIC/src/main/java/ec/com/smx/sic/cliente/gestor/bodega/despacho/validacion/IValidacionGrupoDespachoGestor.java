package ec.com.smx.sic.cliente.gestor.bodega.despacho.validacion;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * 
 * @author cortiz
 * @author jdvasquez
 *
 */
public interface IValidacionGrupoDespachoGestor {
	/**
	 * Valida los campos necesarios para la consulta de grupos de despacho
	 * @param areaTrabajoBodegaDTO
	 * @throws SICException
	 */
	public abstract void obtenerGruposDespacho(AreaTrabajoDTO areaTrabajoBodegaDTO) throws SICException;
	/**
	 * 
	 * @param areaTrabajoDTO
	 * @param codAreasTrabajoDelGrupo
	 * @throws SICException
	 */
	public abstract void obtenerAreasTrabajo(AreaTrabajoDTO areaTrabajoDTO, Collection<Integer> codAreasTrabajoDelGrupo) throws SICException;
	/**
	 * Valida los campos necesarios para la consulta de locales por bodega
	 * @param areaTrabajoBodegaDTO
	 * @throws SICException
	 */
	public void obtenerLocalesPorBodega(AreaTrabajoDTO areaTrabajoBodegaDTO) throws SICException;
	/**
	 * alida los campos necesarios para el registro de la relacion de grupos de trabajo con areas de trabajo
	 * @param codigoGrupoTrabajo
	 * @param areaTrabajoCol
	 * @param codigoCompania
	 * @param usuarioRegistro
	 * @param tipoRelacion
	 * @param codigoRelacion
	 * @throws SICException
	 */
	public void registrarRelacionAreaTrabajoGrupoTrabajo(Long codigoGrupoTrabajo, Collection<AreaTrabajoDTO> areaTrabajoCol, Integer codigoCompania, String usuarioRegistro, String tipoRelacion, String codigoRelacion) throws SICException;
}
