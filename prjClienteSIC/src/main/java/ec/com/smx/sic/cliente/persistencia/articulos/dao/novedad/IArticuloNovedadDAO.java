package ec.com.smx.sic.cliente.persistencia.articulos.dao.novedad;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloNovedadCuponDTO;

public interface IArticuloNovedadDAO {
	
	/**
	 * Permite ejecutar el procedimiento almacenado encargado de resolver las inconsistencias de los Articulos relacionados a un Cupon
	 * y que estos no tengan una Estructura Comercial Cliente relacionada
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @param numeroIteraccion N\u00FAmero de Iteracci\u00F3n
	 * @throws SICException
	 */
	void ejecutarResolverInconsistenciasArticuloRelacionadoCupon(Integer codigoCompania, Integer numeroIteraccion) throws SICException;
	
	/**
	 * Permite obtener los registros procesados
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloNovedadCuponDTO> obtenerRegistrosProcesados(Integer codigoCompania) throws SICException;
}
