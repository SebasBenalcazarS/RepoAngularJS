/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.vo.AreaTrabajoVO;

/**
 * @author jdvasquez
 *
 */
public interface IAreaTrabajoDAO {
	/**
	 * Retorna una coleccion de areas de trabajo encontradas en base a los parametros de la plantilla dada
	 * @param areaTrabajoVO
	 * @return
	 */
	public abstract Collection<AreaTrabajoDTO> obtenerAreasTrabajo(AreaTrabajoVO areaTrabajoVO);
}
