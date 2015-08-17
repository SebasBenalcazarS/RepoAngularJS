/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.pedidoAsistido.almacenamiento;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ConfiguracionPedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.MonitoreoPedidoVO;
import ec.com.smx.sic.cliente.mdl.vo.PedidoAsistidoVO;

/**
 * @author bsandoval
 *
 */
public interface IAlmacenamientoMonitoreoPedidoAsisitidoGestor extends Serializable {
	
	/**
	 * M\u00E9todo que verifica y modifica el estado a corregido
	 * @param pedidosSeleccionadosPadre
	 * @param monitoreoPedidoVO
	 * @param fecha
	 * @throws SICException
	 */
	public void modificarEstadoCorregir(Collection<PedidoAreaTrabajoDTO> pedidosSeleccionadosPadre , MonitoreoPedidoVO monitoreoPedidoVO,
			Date fecha, PedidoAsistidoVO pedidoAsistidoVO)throws SICException;
	
	/**
	 * M\u00E9todo que verifica y modifica el estado a confirmado
	 * @param pedidosSeleccionadosPadre
	 * @param monitoreoPedidoVO
	 * @param fecha
	 * @throws SICException
	 */
	public void modificarEstadoConfirmar(Collection<PedidoAreaTrabajoDTO> pedidosSeleccionadosPadre ,MonitoreoPedidoVO monitoreoPedidoVO,
			Date fecha, PedidoAsistidoVO pedidoAsistidoVO)throws SICException;
	
	/**
	 * 
	 * @param pedidoSeleccionado
	 * @param pedidoAsistidoVO
	 * @param monitoreoPedidoVO
	 */
	public void modificarHoraTransmision(PedidoAreaTrabajoDTO pedidoSeleccionado, PedidoAsistidoVO pedidoAsistidoVO, MonitoreoPedidoVO monitoreoPedidoVO);
	
	/**
	 * 
	 * @param pedidosSeleccionadosPadre
	 * @param monitoreoPedidoVO
	 * @param pedidoAsistidoVO
	 * @param configuracionPedidoAsistido
	 * @throws SICException
	 */
	public void modificarFechaPedido(
			Collection<PedidoAreaTrabajoDTO> pedidosSeleccionadosPadre,
			MonitoreoPedidoVO monitoreoPedidoVO, PedidoAsistidoVO pedidoAsistidoVO, ConfiguracionPedidoAsistidoVO configuracionPedidoAsistido)
					throws SICException;
	/**
	 * 
	 * @param pedidosSeleccionadosPadre
	 * @param monitoreoPedidoVO
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void eliminarPedido(PedidoAreaTrabajoDTO pedidosSeleccionadosPadre,	MonitoreoPedidoVO monitoreoPedidoVO, PedidoAsistidoVO pedidoAsistidoVO)
			throws SICException;
	
	/**
	 * 
	 * @param pedidosSeleccionadosPadre
	 * @param monitoreoPedidoVO
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void modificarEstadoNoPedir(
			Collection<PedidoAreaTrabajoDTO> pedidosSeleccionadosPadre,
			MonitoreoPedidoVO monitoreoPedidoVO, PedidoAsistidoVO pedidoAsistidoVO)
					throws SICException ;
	
	/**
	 * 
	 * @param pedidosSeleccionadosPadre
	 * @param monitoreoPedidoVO
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void modificarEstadoPedir(
			Collection<PedidoAreaTrabajoDTO> pedidosSeleccionadosPadre,
			MonitoreoPedidoVO monitoreoPedidoVO, PedidoAsistidoVO pedidoAsistidoVO)
					throws SICException;
	
	/**
	 * 
	 * @param pedidoEstado
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void modificarConfirmarIngreso(PedidoAreaTrabajoDTO pedidoEstado, PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

}
