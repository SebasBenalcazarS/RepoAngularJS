package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;

public interface ISeleccionAutomaticaAndenesGestor {

	/**
	 * Realiza la busqueda automatica de andenes para la recepcion de entregas de los proveedores. Busca la configuracion de andenes vs perchas, perchas vs andenes, perchas vs articulos para obtener
	 * los andenes mas cercanos con respecto a los articulos de la entrega
	 * 
	 * @param entregaDTO Un EntregaDTO
	 * @return Un Collection de DetalleSeccionDTO 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<DetalleSeccionDTO> obtenerAndenesRecepcion(EntregaDTO entregaDTO, Collection<DetalleSeccionDTO> andenesNoDisponibles) throws SICException;
	
}