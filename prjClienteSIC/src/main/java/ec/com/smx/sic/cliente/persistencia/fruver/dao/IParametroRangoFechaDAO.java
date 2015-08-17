package ec.com.smx.sic.cliente.persistencia.fruver.dao;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ParametroRangoFechaDTO;

/**
 * @author  jcayo<josecayo4@gmail.com>
 *
 */
public interface IParametroRangoFechaDAO {

	/**
	 * Permite obtener el parametro de un determinado rango de fechas
	 * @param codigoCompania Codigo de la compania
	 * @param codigoParametroRangoFecha Codigo del rango de fecha a obtener
	 * @return ParametroRangoFechaDTO
	 * @throws SICException
	 */
	public ParametroRangoFechaDTO obtenerParametroRangoFecha(Integer codigoCompania, Integer codigoParametroRangoFecha) throws SICException;
}
