package ec.com.smx.sic.cliente.gestor.ordenCompra.almacenamiento;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.EmbarqueEstadoImpDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraRecepcionVO;

/**
 * @author aguato
 *
 */
public interface IEmbarqueImportacionesGestor extends Serializable {

	/**
	 * @param adminOrdenCompraRecepcionVO
	 * @param embCollection
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoDTO> crearOrdenCompraDesdeEmbarque(AdminOrdenCompraRecepcionVO adminOrdenCompraRecepcionVO, Collection<EmbarqueEstadoImpDTO> embCollection) throws SICException;
	
	/**
	 * @param adminOrdenCompraRecepcionVO
	 * @param embarqueSeleccionado
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoDTO> crearOrdenCompraEmbarqueFacturas(AdminOrdenCompraRecepcionVO adminOrdenCompraRecepcionVO, EmbarqueEstadoImpDTO embarqueSeleccionado) throws SICException;

	/**
	 * @param pedidosAlmacenados
	 * @throws SICException
	 */
	public void crearOrdenCompraFacturas(Collection<PedidoDTO> pedidosAlmacenados) throws SICException;
	
	/**
	 * @param codigoPedido
	 * @throws SICException
	 */
	public void cerrarEmbarqueImportaciones(Long codigoEmbarque) throws SICException;

}
