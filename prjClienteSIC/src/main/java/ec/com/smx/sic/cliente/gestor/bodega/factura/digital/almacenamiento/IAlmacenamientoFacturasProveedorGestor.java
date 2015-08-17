package ec.com.smx.sic.cliente.gestor.bodega.factura.digital.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;


/**
 * 
 * @author acaiza
 * 
 */
public interface IAlmacenamientoFacturasProveedorGestor {

	/**
	 * 
	 * @param entregaDTO
	 * @param facturaEstadoDTOs
	 * @return
	 */
	public EntregaDTO crearFacturaFisicaProveedor(EntregaDTO entregaDTO, Collection<FacturaEstadoDTO> facturaEstadoDTOs) throws SICException;
	
	/**
	 * Crea la factura digital del proveedor en base a las ordenes de compra de los pedidos
	 * @param entregaVO
	 * @param ordenCompraDetalleEstadoDTOCol
	 * @return
	 * @throws SICException
	 */
	public FacturaDTO crearFacturaDigitalProveedor(FacturaEstadoDTO facturaEstadoDTO, Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOCol) throws SICException;
	
	/**
	 * Elimina una factura de la entrega
	 * 
	 * @param facturaEstadoDTO
	 * @throws SICException
	 */
	public void eliminarFacturaDigital(FacturaEstadoDTO facturaEstadoDTO) throws SICException;
	
	/**
	 * Actualiza los datos de una factura, actualizando las entidades FacturaEstadoDTO, FacturaDTO, DetalleFacturaEstadoDTOCol
	 * 
	 * FacturaEstadoDTO.detalleFacturaEstadoDTOCol tiene los detalles de los articulos facturados. Si no llega un articulo antes facturado se elimina de la factura 
	 * 
	 * @param facturaEstadoDTO Un FacturaEstadoDTO a actualizar
	 * @return Un FacturaEstadoDTO actualizado
	 */
	public FacturaEstadoDTO actualizarFacturaDigitalProveedor(FacturaEstadoDTO facturaEstadoDTO);

	/**
	 * Remueve una factura de un proveedor
	 *
	 * @param facturaEstadoDTO
	 * @return 
	 */
	public void removerFactura(FacturaEstadoDTO facturaEstadoDTO) throws SICException;
	
}
