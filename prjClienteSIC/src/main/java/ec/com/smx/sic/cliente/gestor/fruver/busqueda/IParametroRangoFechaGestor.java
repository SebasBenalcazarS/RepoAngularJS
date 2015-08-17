package ec.com.smx.sic.cliente.gestor.fruver.busqueda;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ParametroRangoFechaDTO;

/**
 * @author KRUGER\oviana
 */
public interface IParametroRangoFechaGestor {

	/**
	 * Permite obtener el parametro de un determinado rango de fechas
	 * @param codigoCompania Codigo de la compania
	 * @param codigoParametroRangoFecha Codigo del rango de fecha a obtener
	 * @return ParametroRangoFechaDTO
	 * @throws SICException
	 */
	public ParametroRangoFechaDTO obtenerParametroRangoFecha(Integer codigoCompania, Integer codigoParametroRangoFecha) throws SICException;
	
}
