package ec.com.smx.sic.cliente.gestor.convenio;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ec.com.smx.sic.cliente.mdl.dto.NegociacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.NegociacionGestionPrecioParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraVO;

/**
 * 
 * @author amunoz
 *
 */
public interface IOrdenCompraNegociacionGestor {
	/**
	 * Devuelve una coleccion de NegociacionesArticuloDTO si es que tiene condiciones de negociacion para esa orden de compra
	 * @param codigoProveedor
	 * @param fechaEntrega
	 * @param condicionesAdicionales
	 * @return
	 */
	Collection<NegociacionArticuloDTO> findNegociacionesArticuloOrdenCompraCol(String codigoProveedor, Date fechaEntrega, Map<String, Object> condicionesAdicionales);
	/**
	 * Agrega el descuento de negociacion al detalle de descuentos a todos los items de la orden compra 
	 * @param itemsOrdenCompraAsisitida
	 * @param ordenCompraCreacionVO
	 */
	void agregarDescuentoNegociacionOrdenCompra(Collection<OrdenCompraDetalleEstadoDTO> itemsOrdenCompraAsisitida, AdminOrdenCompraVO ordenCompraCreacionVO);

	/**
	 * Agrega el descuento de negociacion al detalle de descuentos por articulo
	 * @param ordenCompraDetalleEstadoDTO
	 * @param ordenCompraCreacionVO
	 */
	void agregarDescuentoNegociacionPorArticulo(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO, AdminOrdenCompraVO ordenCompraCreacionVO);

	
	
	/**
	 * Registra en la bitacora de negociacion descuento orden compra
	 * @param ordenCompraDetalleEstado
	 */
	void transCreacionBitacoraNegociacionOrdenCompraDetalle(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstado);
	
	/**
	 * Devuelve una lista con todos los convenios y promociones que se aplicaron para determinado detalle de la orden de compra
	 * @param ordenCompraDetalleEstado
	 * @return
	 */
	Collection<NegociacionGestionPrecioParticipanteDTO> findNegociacionPromocionesDescuentoOrdenCompra(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstado);
	/**
	 * Re calcula los descuentos de negociacion en el caso que existiera una edicion en los datos de consulta de la orden de compra
	 * @param ordenCompraCreacionVO
	 */
	void calcularDescuentosNegociacionesEdicionOrdenCompra(AdminOrdenCompraVO ordenCompraCreacionVO);
}
