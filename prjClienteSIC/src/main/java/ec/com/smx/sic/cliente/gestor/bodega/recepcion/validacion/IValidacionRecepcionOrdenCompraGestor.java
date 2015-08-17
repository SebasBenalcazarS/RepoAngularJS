package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.HoraCalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;

public interface IValidacionRecepcionOrdenCompraGestor {
	
	/**
	 * 
	 * @param entregasDTO
	 * @throws SICException
	 */
	public abstract void obtenerOrdenesCompraRecepcion(Collection<EntregaDTO> entregasDTO) throws SICException;
	
	/**
	 * 
	 * @param entregaDTOs
	 * @param ordenCompraEstadoDTOs
	 * @param horaCalendarioDTO
	 * @param recepcionProveedorDTO
	 * @throws SICException
	 */
	public abstract void modificarOrdenesCompraEntregas(Collection<EntregaDTO> listaEntregas,Collection<OrdenCompraEstadoDTO> listaOrdenCEGuardar, HoraCalendarioDTO horaCalendarioPLA, RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
	 * 
	 * @param Collection<OrdenCompraEstadoDTO>
	 * @param EntregaDTO
	 * @throws SICException
	 */
	public abstract void crearOdenCompraParaEntrega(Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs, EntregaDTO entregaDTO) throws SICException;
	
	/**
	 * Valida los campos necesarios para modificar la orden de compra estado desde la recepcion
	 * 
	 * @param ordenCompraDetalleEstado
	 * @param cantidadRecibida
	 * @throws SICException
	 */
	public void modificarOrdenCompraEstadoParaRecepcion(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstado, DatosTareaDTO datosTareaDTO, Integer cantidadRecibida) throws SICException;
	
}
