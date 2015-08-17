package ec.com.smx.sic.cliente.gestor.bodega.factura.digital.validacion;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.HoraCalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.FacturaDigitalEST;
import ec.com.smx.sic.cliente.mdl.vo.EntregaVO;

public interface IValidacionEntregasProveedorGestor {		
	
	/**
	 * @param entregaVO
	 * @throws SICException
	 */
	public abstract void crearEntregaPlanificacionRecepcionProveedor(EntregaVO entregaVO) throws SICException;
	
	/**
 	 * 
 	 * @param areaTrabajoDTOs
 	 * @param horaCalendarioDTO
 	 * @param ordenCompraEstadoDTOs
 	 * @param recepcionProveedorDTO
 	 * @return
 	 * @throws SICException
 	 */
	public abstract void crearEntregasOrdenCompraPlanificacion(Collection<AreaTrabajoDTO> listaAreaTrabajo, HoraCalendarioDTO horaCalendarioDTO, Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs, RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
	 * 
	 * @param entregaVO
	 * @throws SICException
	 */
	public abstract void crearEntregaProveedor(EntregaVO entregaVO) throws SICException;
	
	/**
	 * Valida los datos necesarios para poder eliminar una entrega
	 * 
	 * 
	 * @param entregaDTO Un EntregaDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public abstract void validarEliminarEntregaProveedor(EntregaDTO entregaDTO) throws SICException;

	/**
	 * Valida los datos necesarios para poder actualizar una entrega
	 * 
	 * @param entregaDTO
	 * @param ordenCompraDetalleEstadoDTOs
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public abstract void validarActualizarEntregaProveedor(EntregaDTO entregaDTO, Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) throws SICException;
	
	/**
	 * Cambia el estado de la entrega con la maquina de estados configurada en el catalogo valor relacionado
	 * 
	 * @param entregaDTO Una entrega
	 * @param estadoEntregaCatVal Accion de la entrega
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public abstract void validarCambiarEstadoEntregaProveedor(EntregaDTO entregaDTO, CatalogoValorDTO estadoEntregaCatVal) throws SICException;
	
	/**
	 * Valida los datos necesarios para poder rechazar un articulo de un entrega
	 * 
	 * @param entregaDTO Un EntregaDTO
	 * @param facturaDigitalESTs Un Collection de FacturaDigitalEST
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public abstract void validarRecharzarArticulosEntrega(EntregaDTO entregaDTO, Collection<FacturaDigitalEST> facturaDigitalESTs) throws SICException;
	
}