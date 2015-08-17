package ec.com.smx.sic.cliente.gestor.ordenCompra.validacion;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;

public interface IValidacionAlmacenamientoOrdenCompraGestor extends Serializable{

	/**
	 * Valida si el codigo ingresado es un departamento o una clasificacion
	 * @param codigoClasificacion
	 * @return
	 */
	public  String validacionTipoClasificacion(StringBuffer codigoCla)  throws SICException;

	/**
	 * 
	 * @param ordenCompraEstadoDTO
	 */
	public abstract void validacionCrearOrdenCompra(
			OrdenCompraEstadoDTO ordenCompraEstadoDTO) throws SICException;

	/**
	 * 
	 * @param ordenCompraDetalleEstadoDTO
	 * @return
	 */
	public abstract String validacionCantidadesPorTipoControlCosto(
			OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO);
	
	/**
	 * 
	 * @param pedidoDTO
	 * @throws SICException
	 */
	public void quitarRelacionesPedidoDTO(PedidoDTO pedidoDTO) throws SICException;
	
	/**
	 * 
	 * @param pedidoDTO
	 * @param pedidoDTOOriginal
	 * @throws SICException
	 */
	public void copiarRelacionesPedidoDTO(PedidoDTO pedidoDTO, PedidoDTO pedidoDTOOriginal) throws SICException;
	
	/**
	 * Valida si un pedido tiene ordenes de compra con estado Enviada
	 * @param codigoCompania Codigo de la compania
	 * @param codigoPedido Codigo del pedido que se esta procesando
	 * @return True si tiene ordenes de compra con estado enviada, False en caso contrario
	 * @throws SICException
	 */
	public Boolean validarOrdenCompraEstadoEnviada(Integer codigoCompania, Long codigoPedido) throws SICException;

}