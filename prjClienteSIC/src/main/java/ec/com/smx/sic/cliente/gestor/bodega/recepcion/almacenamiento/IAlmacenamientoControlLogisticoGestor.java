package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ControlLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;

public interface IAlmacenamientoControlLogisticoGestor {
	/**
	 * Permite almacenar los problemas encontrados para el control log&iacute;stico
	 * @param recepcionProveedorDTO
	 * @param controlLogisticoCol
	 * @throws SICException
	 */
	public void guardarDatosControlLogistico(RecepcionProveedorDTO recepcionProveedorDTO, Collection<ControlLogisticoDTO> controlLogisticoCol) throws SICException;
}
