/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.JustificacionDTO;

/**
 * @author jvasquez
 *
 */
public interface IJustificacionDAO {
	/**
	 * Obtiene una coleccion de justificaciones filtradas por tipo
	 * @param codigoCompania
	 * @param valorTipoNovedad
	 * @param codigoTipoNovedad
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerJustificacionTipo(Integer codigoCompania, String valorTipoNovedad, Integer codigoTipoNovedad) throws SICException;

	/**
	 * Obtiene una coleccion se justificaciones filtradas por area de trabajo y perfil
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoPerfil
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerJustificacionAreaTrabajoPerfil(Integer codigoCompania, Integer codigoAreaTrabajo, String codigoPerfil) throws SICException;

}
