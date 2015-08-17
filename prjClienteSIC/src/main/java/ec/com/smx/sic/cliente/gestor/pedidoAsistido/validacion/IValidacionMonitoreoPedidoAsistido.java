/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.pedidoAsistido.validacion;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.vo.MonitoreoPedidoVO;

/**
 * @author bsandoval
 *
 */
public interface IValidacionMonitoreoPedidoAsistido extends Serializable{
	
	public void validarEliminarPedido(PedidoAreaTrabajoDTO pedidosSeleccionados,
			MonitoreoPedidoVO monitoreoPedidoVO, boolean adminLocal, String userId) throws SICException;
	
	public void validarCorregirPedido(
			Collection<PedidoAreaTrabajoDTO> pedidosSeleccionados,
			MonitoreoPedidoVO monitoreoPedidoVO) throws SICException;
	
	public void validarConfirmarPedido(
			Collection<PedidoAreaTrabajoDTO> pedidosSeleccionadosPadre,
			MonitoreoPedidoVO monitoreoPedidoVO) throws SICException;
	
	public void validarCambiarFecha(Collection<PedidoAreaTrabajoDTO> pedidosSeleccionados,
			MonitoreoPedidoVO monitoreoPedidoVO) throws SICException;
}
