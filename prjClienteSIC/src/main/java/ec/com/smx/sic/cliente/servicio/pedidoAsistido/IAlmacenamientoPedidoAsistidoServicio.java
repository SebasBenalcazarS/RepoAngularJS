/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.pedidoAsistido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;
import ec.com.smx.sic.cliente.mdl.vo.ConfiguracionBloqueoPedidoVO;
import ec.com.smx.sic.cliente.mdl.vo.ConfiguracionPedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.InterfacePedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.MonitoreoPedidoVO;
import ec.com.smx.sic.cliente.mdl.vo.PedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.PedidoFijoVO;

/**
 * @author jvillacis
 *
 */
public interface IAlmacenamientoPedidoAsistidoServicio extends Serializable{
	
	/**
	 * 
	 * @param configuracionPedidoAsistidoVO
	 * @throws SICException
	 */
	public void crearConfiguracionPedidoAsistido(ConfiguracionPedidoAsistidoVO configuracionPedidoAsistidoVO) throws SICException;

	/**
	 * Modifica configuracion de pedido asistido
	 * 
	 * @param configuracionPedidoAsistidoVO
	 * @throws SICException
	 */
	public void modificarConfiguracionPedidoAsistido(ConfiguracionPedidoAsistidoVO configuracionPedidoAsistidoVO) throws SICException;

	/**
	 * 
	 * @param pedidosSeleccionadosPadre
	 * @param monitoreoPedidoVO
	 * @param fecha
	 * @throws SICException
	 */
	public void modificarEstadoConfirmar(Collection<PedidoAreaTrabajoDTO> pedidosSeleccionadosPadre, MonitoreoPedidoVO monitoreoPedidoVO, Date fecha, PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * Creaci&oacute;n del pedido asistido detalle
	 * 
	 * @param pedidoAsistidoVO
	 * @param mostrarDetallesAlmacenados
	 * @throws SICException
	 */
	public void crearPedidoAsistidoDetalle(PedidoAsistidoVO pedidoAsistidoVO, boolean mostrarDetallesAlmacenados) throws SICException;

	/**
	 * 
	 * @param pedAreTraDetDTOColAlmacenar
	 * @param pedidoUsuario
	 * @param pedidoConsolidado
	 * @param pedAreTraDetClaDTOColAlmacenar
	 * @throws SICException
	 */
	public void almacenarDetallesTotalesClasificacionesPedido(ArrayList<PedidoAreaTrabajoDetalleDTO> pedAreTraDetDTOColAlmacenar, 
			PedidoAreaTrabajoDTO pedidoUsuario, PedidoAreaTrabajoDTO pedidoConsolidado, 
			ArrayList<PedidoAreaTrabajoClasificacionDTO> pedAreTraDetClaDTOColAlmacenar) throws SICException;
	
	/**
	 * 
	 * @param pedidosSeleccionadosPadre
	 * @param monitoreoPedidoVO
	 * @param fecha
	 * @throws SICException
	 */
	public void modificarEstadoCorregir(Collection<PedidoAreaTrabajoDTO> pedidosSeleccionadosPadre, MonitoreoPedidoVO monitoreoPedidoVO, Date fecha, PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * Elimina un pedido asistido (informacion, estado y detalles)
	 * 
	 * @param pedidoAsistidoVO
	 * @param monitoreoPedidoVO
	 * @param adminLocal
	 * @throws SICException
	 */
	public void eliminarPedidoAsistido(PedidoAsistidoVO pedidoAsistidoVO, MonitoreoPedidoVO monitoreoPedidoVO, boolean adminLocal) throws SICException;

	/**
	 * Actualizar totales en el pedido
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void actualizarPedidoAreaTrabajoPadreHijo(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
	/**
	 * 
	 * @param pedidoSeleccionado
	 * @param horaMaximaPedido
	 * @param monitoreoPedidoVO
	 * @throws SICException
	 */
	public void modificarHoraTransmision(
			PedidoAreaTrabajoDTO pedidoSeleccionado,
			PedidoAsistidoVO pedidoAsistidoVO, MonitoreoPedidoVO monitoreoPedidoVO) throws SICException;

	/**
	 * 
	 * @param pedidosSeleccionadosPadre
	 * @param monitoreoPedidoVO
	 * @param fecha
	 * @param configuracionPedidoAsistido
	 * @throws SICException
	 */
	public void modificarFechaPedido(
			Collection<PedidoAreaTrabajoDTO> pedidosSeleccionadosPadre,
			MonitoreoPedidoVO monitoreoPedidoVO, PedidoAsistidoVO pedidoAsistidoVO, ConfiguracionPedidoAsistidoVO configuracionPedidoAsistido)
					throws SICException;
	
	/**
	 * Activa una clasificaci&oacute;n desactivada
	 * 
	 * @param pedidoAreaTrabajoClasificacionDTO
	 * @throws SICException
	 */
	public void activarClasificacion(PedidoAreaTrabajoClasificacionDTO pedidoAreaTrabajoClasificacionDTO) throws SICException;
	
	/**
	 * Obtener clasificaciones por subbodega
	 * 
	 * @param pedidoAsitidoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoClasificacionDTO> actualizarEstructuraPedidoClasificacion(PedidoAsistidoVO pedidoAsitidoVO) throws SICException;
	
	/**
	 * 
	 * @param clasificacionesNuevas
	 * @throws SICException
	 */
	public void crearPedidoAreaTrabajoClasificacion(ArrayList<PedidoAreaTrabajoClasificacionDTO> clasificacionesNuevas) throws SICException;
	
	/**
	 * 
	 * @param clasificacionesExistentes
	 * @throws SICException
	 */
	public void actualizarPedidoAreaTrabajoClasificacion(ArrayList<PedidoAreaTrabajoClasificacionDTO> clasificacionesExistentes) throws SICException;
	
	/**
	 * 
	 * @param pedidoAsistidoVO
	 * @param accion
	 * @throws SICException
	 */
	public void generarNuevoEstadoPedidoAsistido(PedidoAsistidoVO pedidoAsistidoVO, String accion) throws SICException;
	
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
					throws SICException;
	
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
	 * Utiliza una autorizacion aprobada por el autorizador
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void utilizarAutorizacion(ec.com.smx.autorizaciones.dto.AutorizacionDTO autorizacionDTO, PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * 
	 * @param pedidoFijo
	 * @throws SICException
	 */
	public void crearPedidoFijo(PedidoFijoVO pedidoFijo) throws SICException;
	
	/**
	 * 
	 * @param pedidoFijoVO
	 * @throws SICException
	 */
	public void inactivarPedidoFijo(PedidoFijoVO pedidoFijoVO)throws SICException;
	
	/**
	 * 
	 * @param interfacePedidoAsistidoVO
	 * @throws SICException
	 */
	public void procesarInterfacePedidos(InterfacePedidoAsistidoVO interfacePedidoAsistidoVO) throws SICException;
	
	/**
	 * 
	 * @param pedidoEstado
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void modificarConfirmarIngreso(PedidoAreaTrabajoDTO pedidoEstado, PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoIntefacePedidoAreaTrabajo
	 * @param codigoProcesado
	 * @param userId
	 * @throws SICException
	 */
	public void actualizarEstadoInterfacePedidoAreaTrabajo(Integer codigoCompania, Long codigoIntefacePedidoAreaTrabajo, Character codigoProcesado, String userId) throws SICException;
	
	/**
	 * 
	 * @param configuracionBloqueoPedidoAsistidoVO
	 * @throws SICException
	 */
	public void modificarConfiguracionBloqueoPedidoAsistido(ConfiguracionBloqueoPedidoVO configuracionBloqueoPedidoAsistidoVO) throws SICException;
}
