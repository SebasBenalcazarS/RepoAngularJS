package ec.com.smx.sic.cliente.gestor.bodega.entrega.calculo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;

/**
 * @author aguato
 *
 */
public interface IObtenerEntregasOrdenCompraGestor {

	/**
	 * Metodo que busca facturas internas de entregas asociadas a la orden de
	 * compra estado
	 * 
	 * @param codigoOrdenCompra
	 * @param codigoCompania
	 * @param valorTipoOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public Collection<FacturaDTO> obtenerEntregaFacturaInternaDto(Long codigoOrdenCompra, Integer codigoCompania, String valorTipoOrdenCompra) throws SICException;

	/**
	 * Metodo que busca los detalles de las ordenes de compra asociadas a la
	 * factura interna
	 * 
	 * @param facturaDTO
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> obtenerDetalleEntregaFacturaInternaDto(FacturaDTO facturaDTO, Integer codigoCompania) throws SICException;

	/**
	 * Metodo que busca facturas internas de entregas asociadas a la orden de
	 * compra estado
	 * 
	 * @param codigoOrdenCompra
	 * @param codigoCompania
	 * @param valorTipoOrdenCompra
	 * @return
	 */
	public Collection<FacturaDTO> obtenerEntregaFacturaInternaDTO(Long codigoOrdenCompra, Integer codigoCompania, String valorTipoOrdenCompra);

}
