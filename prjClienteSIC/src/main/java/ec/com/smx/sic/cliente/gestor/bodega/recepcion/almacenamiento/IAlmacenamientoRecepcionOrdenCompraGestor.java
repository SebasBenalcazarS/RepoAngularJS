package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaOrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.HoraCalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;


/**
 * @author acaiza
 *
 */
public interface IAlmacenamientoRecepcionOrdenCompraGestor {	
	
	/**
	 * 
	 * @param listaEntregas
	 * @return
	 * @throws SICException
	 */
	public void crearEntregaOrdenCompraEstado(Collection<EntregaDTO> listaEntregas) throws SICException;
	
	/**
	 * Crea varias entidades EntregaOrdenCompraEstadoDTO en base a los datos de una EntregaDTO y los OrdenCompraEstadoDTO's de las entregaOrdenCompraEstadoCol de la entrega
	 * 
	 * @param entregaDTO
	 * @param ordenCompraEstadoDTOs
	 * @return
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<EntregaOrdenCompraEstadoDTO> crearEntregaOrdenCompraEstadoDTO(Collection<EntregaDTO> entregaDTOs) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraDTO
	 * @param listaEntregas
	 * @throws SICException
	 */
 	public void removerOrdenCompraRecepcionDia(OrdenCompraDTO ordenCompraDTO,Collection<EntregaDTO> listaEntregas) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraDTO
	 * @param recepcionProveedorDTO
	 * @throws SICException
	 */
 	public void removerOrdenCompraRecepcion(OrdenCompraDTO ordenCompraDTO,RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
	 * 
	 * @param entregaDTOs
	 * @param ordenCompraEstadoDTOs
	 * @param horaCalendarioDTO
	 * @param recepcionProveedorDTO
	 * @throws SICException
	 */
 	public void modificarOrdenesCompraEntregas(Collection<EntregaDTO> listaEntregas,Collection<OrdenCompraEstadoDTO> listaOrdenCEGuardar, HoraCalendarioDTO horaCalendarioPLA, RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
 	 * 
 	 * @param Collection<OrdenCompraEstadoDTO>
 	 * @param EntregaDTO
 	 * @throws SICException
 	 */
 	public void crearOdenCompraParaEntrega(Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs, EntregaDTO entregaDTO) throws SICException;
 	
	/**
	 * Crea la orden de compra estado para recepcion en base a los datos de una orden de compra
	 * @param ordenCompraEstadoDTO Orden de compra estado
	 * @return Una orden de compra estado
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public OrdenCompraEstadoDTO crearOrdenCompraEstadoParaRecepcion(OrdenCompraEstadoDTO ordenCompraEstadoDTO) throws SICException;
	
	/**
	 * Modifica la orden de compra estado para recepcion en base a los datos de un detalle de orden de compra estado
	 * 
	 * @param ordenCompraDetalleEstado Un detalle de orden de compra en estado PEN
	 * @param datosTareaDTO
	 * @param cantidadRecibida Cantidad de cajas recibidas
	 * @return Un OrdenCompraEstadoDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public OrdenCompraEstadoDTO modificarOrdenCompraEstadoParaRecepcion(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstado, DatosTareaDTO datosTareaDTO, Integer cantidadRecibida) throws SICException;
	
}
