package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ControlLogisticoDTO;

public interface IControlLogisticoDAO {
	/**
	 * Permite obtener los controles log&iacute;sticos para el monitor de recepci&oacute;n de abastos
	 * @param codigoCompania
	 * @param codigoAreaTrabajo: La subbodega
	 * @return
	 * @throws SICException
	 */
	public Collection<ControlLogisticoDTO> obtenerControlesLogisticos(Integer codigoCompania, Integer codigoAreaTrabajo) throws SICException;
}
