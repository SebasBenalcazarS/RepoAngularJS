package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloTipoControlCostosDTO;

/**
 * 
 * @author lguaman
 *
 */
public interface IValidarCreacionRecepcionProveedorGestor {

	/**
	 * Validar disponibilidad de articulos pendientes por recibir en la orden de compra.
	 *
	 * @param ordenCompraEstadoENV
	 * @param listaTipoControlCosto
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Boolean comprobarOrdenCompraEntregada(OrdenCompraEstadoDTO ordenCompraEstadoENV, Collection<VistaArticuloTipoControlCostosDTO> listaTipoControlCosto) throws SICException;
	
	/**
	 * Obtener el tipo de control de costos para los articulos en recepcion.
	 *
	 * @param listaCodigosOrdenCompraDetalleEstado
	 * @param codigoCompania
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<VistaArticuloTipoControlCostosDTO> obtenerTipoControlCostosArticulos(Collection<Long> listaCodigosOrdenCompraDetalleEstado, Integer codigoCompania) throws SICException;
	
	/**
	 * Validar si el proveedor tiene recepciones creadar antes de poder registrar una nueva
	 * si no hay recepciones registradas se puede crear una nueva,
	 * en caso de existir recepciones se valida que este en estado <b>FACTURADO</b> para poder crear una nueva recepcion
	 * caso contrario no se crea la nueva recepcion
	 * @param recepcionProveedor
	 * @param fecha
	 * @return
	 * @throws SICException
	 */
	Boolean tieneProveedorRecepcionesAbiertas (RecepcionProveedorDTO recepcionProveedor, Date fecha) throws SICException;
	
}
