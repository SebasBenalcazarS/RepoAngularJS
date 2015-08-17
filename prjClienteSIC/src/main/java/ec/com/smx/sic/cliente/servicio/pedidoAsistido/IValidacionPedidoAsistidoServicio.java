/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.pedidoAsistido;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import ec.com.smx.autorizaciones.dto.AutorizacionDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.MonitoreoPedidoVO;
import ec.com.smx.sic.cliente.mdl.vo.PedidoAsistidoVO;

/**
 * @author jvillacis
 *
 */
public interface IValidacionPedidoAsistidoServicio extends Serializable {
	/**
	 * Validaci�n para eliminar el pedido enviado
	 * 
	 * @param pedidosSeleccionados
	 * @param monitoreoPedidoVO
	 * @param adminLocal
	 * @param userId
	 * @throws SICException
	 */
	public void validacionEliminarPedido(PedidoAreaTrabajoDTO pedidosSeleccionados, MonitoreoPedidoVO monitoreoPedidoVO, boolean adminLocal, String userId) throws SICException;

	/**
	 * Validaci�n para corregir los pedidos enviados
	 * 
	 * @param pedidosSeleccionados
	 * @param monitoreoPedidoVO
	 * @throws SICException
	 */
	public void validacionCorregirPedido(Collection<PedidoAreaTrabajoDTO> pedidosSeleccionados, MonitoreoPedidoVO monitoreoPedidoVO) throws SICException;

	/**
	 * Validaci�n para confirmar los pedidos enviados
	 * 
	 * @param pedidosSeleccionadosPadre
	 * @param monitoreoPedidoVO
	 * @throws SICException
	 */
	public void validacionConfirmarPedido(Collection<PedidoAreaTrabajoDTO> pedidosSeleccionadosPadre, MonitoreoPedidoVO monitoreoPedidoVO) throws SICException;
	
	/**
	 * 
	 * @param pedidoAreaTrabajoEstadoDTOConsolidado
	 * @param pedidoAreaTrabajoEstadoDTOUsuarioCol
	 * @return
	 * @throws SICException
	 */
	public String validarConfirmarAdministrador(PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstadoDTOConsolidado,Date fecha , Collection<PedidoAreaTrabajoEstadoDTO> pedidoAreaTrabajoEstadoDTOUsuarioCol) throws SICException;
	
	/**
	 * 
	 * @param pedidoAreaTrabajoEstadoDTOConsolidado
	 * @param pedidoAreaTrabajoEstadoDTOUsuarioCol
	 * @return
	 * @throws SICException
	 */
	public String validarCorregir(PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstadoDTOConsolidado, Collection<PedidoAreaTrabajoEstadoDTO> pedidoAreaTrabajoEstadoDTOUsuarioCol) throws SICException;
	
	/**
	 * 
	 * @param pedidoAreaTrabajoEstadoDTOConsolidado
	 * @param pedidoAreaTrabajoEstadoDTOUsuario
	 * @param idUsuarioActual
	 * @param profileId
	 * @return
	 * @throws SICException
	 */
	public String validarEliminar(PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstadoDTOConsolidado, PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstadoDTOUsuario, String idUsuarioActual, String profileId) throws SICException;
	
	/**
	 * 
	 * @param pedidoAreaTrabajoEstadoDTOConsolidado
	 * @return
	 * @throws SICException
	 */
	public String validarNoPedir(PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstadoDTOConsolidado) throws SICException;
	
	/**
	 * 
	 * @param pedidoAreaTrabajoEstadoDTOConsolidado
	 * @return
	 * @throws SICException
	 */
	public String validarPedir(PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstadoDTOConsolidado) throws SICException;
	
	/**
	 * Validar configuraci&oacute;n seleccionada, controlar el estado no pedido.
	 * 
	 * @param pedidoAsistidoVO
	 * @return
	 * @throws SICException
	 */
	public Boolean validarConfiguracionSeleccionada(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
	/**
	 * Valida par&aacute;metros de la autorizaci&oacute;n ingresada en el componente de autorizaciones
	 * 
	 * @param parametrosConsulta
	 * @return
	 * @throws SICException
	 */
	public AutorizacionDTO validarAutorizacionPedidoAsistido(HashMap<String, Object> parametrosConsulta) throws SICException;
	
	/**
	 * Valida la cantidad m&aacute;xima que un detalle puede pedir por unidad
	 * 
	 * @param pedidoAreaTrabajoDetalleDTOs
	 * @return
	 * @throws SICException
	 */
	//public Boolean validarCantidadIngresadaDetallePedido(Collection<PedidoAreaTrabajoDetalleDTO> pedidoAreaTrabajoDetalleDTOs) throws SICException;
	
	public String validarCambiarFecha(Collection<PedidoAreaTrabajoDTO> pedidosSeleccionados) throws SICException;
	
}
