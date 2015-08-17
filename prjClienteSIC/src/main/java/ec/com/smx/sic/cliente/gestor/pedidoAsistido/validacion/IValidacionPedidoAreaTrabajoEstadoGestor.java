/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.pedidoAsistido.validacion;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import ec.com.smx.autorizaciones.dto.AutorizacionDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.PedidoAsistidoVO;

/**
 * @author jvillacis
 *
 */
public interface IValidacionPedidoAreaTrabajoEstadoGestor extends Serializable {
	
	/**
	 * 
	 * @param pedidoAreaTrabajoEstadoDTOConsolidado
	 * @return
	 * @throws SICException
	 */
	public String validarCrear(PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstadoDTOConsolidado) throws SICException;

	/**
	 * 
	 * @param pedidoAreaTrabajoEstadoDTOConsolidado
	 * @param pedidoAreaTrabajoEstadoDTOUsuario
	 * @return
	 * @throws SICException
	 */
	public String validarModificar(PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstadoDTOConsolidado, PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstadoDTOUsuario) throws SICException;
	
	/**
	 * 
	 * @param pedidoAreaTrabajoEstadoDTOConsolidado
	 * @param pedidoAreaTrabajoEstadoDTOAUsuario
	 * @return
	 * @throws SICException
	 */
	public String validarConfirmarUsuario(PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstadoDTOConsolidado, PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstadoDTOAUsuario) throws SICException;
	
	/**
	 * 
	 * @param pedidoAreaTrabajoEstadoDTOUsuarioCol
	 * @return
	 * @throws SICException
	 */
	public String validarConfirmarUsuarioConsolidado(Collection<PedidoAreaTrabajoEstadoDTO> pedidoAreaTrabajoEstadoDTOUsuarioCol) throws SICException;
	
	/**
	 * 
	 * @param pedidoAreaTrabajoEstadoDTOConsolidado
	 * @param pedidoAreaTrabajoEstadoDTOUsuarioCol
	 * @return
	 * @throws SICException
	 */
	public String validarConfirmarAdministrador(PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstadoDTOConsolidado,Date fecha, Collection<PedidoAreaTrabajoEstadoDTO> pedidoAreaTrabajoEstadoDTOUsuarioCol) throws SICException;
	
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
	 * @return
	 * @throws SICException
	 */
	public Boolean obtenerConfiguracionSeleccionada(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
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
	
	/**
	 * Validar reserva en detalle del pedido
	 * 
	 * @param pedidoAsistidoVO
	 * @return
	 * @throws SICException
	 */
	public Boolean validarReservaDetallePedido(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
}
