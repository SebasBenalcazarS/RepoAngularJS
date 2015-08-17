package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;

/**
 * 
 * @author acaiza
 *
 */
public interface IAlmacenamientoAndenesRecepcionGestor {

	
	/**
	 * Modifica los andenes de la recepcion de la bodega a la que se le esta realizado la recepcion de la entrega
	 * 
	 * @param entregaDTO
	 * @param detalleSeccionDTOs
	 * @param detalleSeccionDTO
	 * @param detalleSeccionDTO
	 * @throws SICException
	 */
	public void modificarAndenesRecepcionEntrega(Collection<EntregaDTO> entregasDTO, Collection<DetalleSeccionDTO> andenes, DetalleSeccionDTO andenNuevoValor, DetalleSeccionDTO andenModificar) throws SICException;
	
	/**
	 * Modifica un andenes de la recepcion de la bodega a la que se le esta realizado la recepcion de la entrega
	 * 
	 * @param entregaDTO
	 * @param detalleSeccionDTOs
	 * @return DetalleTareaDTO
	 * @throws SICException
	 */
	public DetalleTareaDTO modificarAndenRecepcionEntrega(Collection<EntregaDTO> entregasDTO, DetalleSeccionDTO andenActual, DetalleSeccionDTO andenAnterior) throws SICException;

	/**
	 * Almacena los andenes que se han registrado en la edicion de la recepcion
	 * 
	 * @param listaAndenesRegistrados
	 * @param listaAndenesTemporales
	 * 
	 */
	public void registrarAndenesEditados(RecepcionProveedorDTO recepcionActual, Collection<DetalleTareaDTO> listaAndenesRegistrados, Collection<DetalleSeccionDTO> listaAndenesTemporales) throws SICException;
	
}
