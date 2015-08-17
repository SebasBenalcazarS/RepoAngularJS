package ec.com.smx.sic.cliente.gestor.bodega.administracion.calculo;

import ec.com.smx.sic.cliente.exception.SICException;

public interface IBodegaUtilGestor {
	/**
	 * Obtiene la cantidad de furgones en base a la cantidad de andenes
	 * @param codigoCompania
	 * @param cantidadAndenes
	 * @return
	 * @throws SICException
	 */
	public int obtenerNumeroFurgones(Integer codigoCompania, Integer  cantidadAndenes)throws SICException;
}
