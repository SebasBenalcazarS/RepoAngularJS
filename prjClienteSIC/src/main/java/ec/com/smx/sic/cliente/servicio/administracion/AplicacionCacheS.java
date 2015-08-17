package ec.com.smx.sic.cliente.servicio.administracion;

import ec.com.smx.framework.common.util.CollectionMap;
import ec.com.smx.sic.cliente.exception.SICException;

public interface AplicacionCacheS {

	/**
	 * Busca en el cache la equivalencia de provincias
	 * @return 
	 * @throws SICException
	 */
	CollectionMap buscarCacheEquivalenciaProvincia() throws SICException;
}
