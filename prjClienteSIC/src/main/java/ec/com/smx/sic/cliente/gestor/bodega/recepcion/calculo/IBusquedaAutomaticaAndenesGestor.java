package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.vo.RecepcionProveedorVO;

public interface IBusquedaAutomaticaAndenesGestor {

	/**
	 * 
	 * @param recepcionProveedorVO
	 * @param andenesNoDisponibles
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO obtenerAndenesRecepcion(RecepcionProveedorVO recepcionProveedorVO, Collection<DetalleSeccionDTO> andenesNoDisponibles) throws SICException;
	
}