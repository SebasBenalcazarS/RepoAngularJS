package ec.com.smx.sic.cliente.common.articulo.novedad;

import ec.com.smx.sic.cliente.exception.SICException;

public interface IArticuloNovedadGestor {
	
	/**
	 * Permite resolver las inconsistencias de Articulos relacionados a un cupon que no tienen registrado una Estructura Comercial de Cliente
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @param numeroEjecucion N\u00FAmero de la ejecuci\u00F3n a realizar
	 * @throws SICException
	 */
	void resolverInconsistenciasArticuloRelacionadoCupon(Integer codigoCompania, Integer numeroEjecucion) throws SICException;
}
