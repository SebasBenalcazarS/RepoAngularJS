package ec.com.smx.sic.cliente.gestor.bodega.factura.digital.validacion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.EntregaVO;

public interface IValidacionFacturasProveedorGestor {

	/**
	 * 
	 * @param entregaDTO
	 * @param facturaEstadoDTOs
	 * @throws SICException
	 */
	public abstract void crearFacturaProveedor(EntregaDTO entregaDTO, Collection<FacturaEstadoDTO> facturaEstadoDTOs) throws SICException;

	/**
	 * 
	 * @param entregaVO
	 * @param ordenCompraDetalleEstadoDTOs
	 * @throws SICException
	 */
	public abstract void actualizarEntregaProveedor(EntregaVO entregaVO, Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) throws SICException;
	
	/**
	 * 
	 * @param entregaVO
	 * @param ordenCompraDetalleEstadoDTOCol
	 * @return
	 * @throws SICException
	 */
	public void validarCrearFacturaProveedor(FacturaEstadoDTO facturaEstadoDTO, Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOCol) throws SICException;
	
	/**
	 * 
	 * @param facturaEstadoDTO
	 * @throws SICException
	 */
	public void validarEliminarFacturaDigital(FacturaEstadoDTO facturaEstadoDTO) throws SICException;
	
	
	
}