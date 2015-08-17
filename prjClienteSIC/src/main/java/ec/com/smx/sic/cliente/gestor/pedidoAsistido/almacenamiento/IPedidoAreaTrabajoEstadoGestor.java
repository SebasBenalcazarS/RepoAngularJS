/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.pedidoAsistido.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.PedidoAsistidoVO;

/**
 * @author jvillacis
 *
 */
public interface IPedidoAreaTrabajoEstadoGestor {

	/**
	 * 
	 * @param pedidoAsistidoVO
	 * @param accion
	 * @throws SICException
	 */
	public void generarNuevoEstadoPedidoAsistido(PedidoAsistidoVO pedidoAsistidoVO, String accion) throws SICException;
	
	/**
	 * 
	 * @param pedidoAsistidoVO
	 * @return
	 * @throws SICException
	 */
	public PedidoAreaTrabajoDTO crearPedidoConsolidado(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param pedidoAreaTrabajoEstadoDTOCol
	 * @throws SICException
	 */
	public void confirmarOperadorInterface(Integer codigoCompania, String userId, Collection<PedidoAreaTrabajoEstadoDTO> pedidoAreaTrabajoEstadoDTOCol) throws SICException;
}
