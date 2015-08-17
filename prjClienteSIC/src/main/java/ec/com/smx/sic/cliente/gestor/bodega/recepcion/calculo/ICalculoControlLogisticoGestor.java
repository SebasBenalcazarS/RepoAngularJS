package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ControlLogisticoDTO;

public interface ICalculoControlLogisticoGestor {
	/**
	 * Permite obtener los controles log&iacute;sticos para el monitor de recepci&oacute;n de abastos
	 * @param codigoCompania
	 * @param codigoAreaTrabajo: La subbodega
	 * @param codigoRecepcionProveedor
	 * @return
	 * @throws SICException
	 */
	public Collection<ControlLogisticoDTO> obtenerControlesLogisticos(Integer codigoCompania, Integer codigoAreaTrabajo, Long codigoRecepcionProveedor) throws SICException;
	
}
