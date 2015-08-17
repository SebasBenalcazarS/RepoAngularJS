package ec.com.smx.sic.cliente.gestor.pedidoAsistido.almacenamiento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoInformacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.MonitoreoPedidoVO;
import ec.com.smx.sic.cliente.mdl.vo.PedidoAsistidoVO;

/**
 * @author finga
 * 
 */
public interface IAlmacenamientoPedidoAsistidoGestor extends Serializable {

	/**
	 * Creaci&oacute;n detalle del pedido asistido
	 * 
	 * @param pedidoAreaTrabajoDetalleDTOs
	 * @param pedidoAsistidoVO
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
	 * Elimina un pedido asistido (informacion, estado y detalles)
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void eliminarPedidoAsistido(PedidoAsistidoVO pedidoAsistidoVO, MonitoreoPedidoVO monitoreoPedidoVO, boolean adminLocal) throws SICException;

	/**
	 * Actualiza los totales en el pedido
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void actualizarPedidoAreaTrabajoPadreHijo(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * Activa una clasificaci&oacute;n desactivada
	 * 
	 * @throws SICException
	 */
	public void activarClasificacion(PedidoAreaTrabajoClasificacionDTO pedidoAreaTrabajoClasificacionDTO) throws SICException;
	
	/**
	 * Actualizar estructura de clasificaciones por pedido
	 * 
	 * @param pedidoAsistidoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoClasificacionDTO> actualizarEstructuraPedidoClasificacion(PedidoAsistidoVO pedidoAsistidoVO) throws SICException;
	
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
	 * Utilizar autorizaci&oaute;n validada
	 * 
	 * @param pedidoAsistidoVO
	 * @throws SICException
	 */
	public void utilizarAutorizacion(ec.com.smx.autorizaciones.dto.AutorizacionDTO autorizacionDTO, PedidoAsistidoVO pedidoAsistidoVO) throws SICException;

	/**
	 * 
	 * @param pedidoAreaTrabajoDTOConsolidado
	 * @param pedidoAreaTrabajoInformacionDTO
	 * @param codigoBodegaSubbodega
	 * @param codigoBodega
	 * @throws SICException
	 */
	public void crearDetallesDesdePedidoPlantilla(PedidoAreaTrabajoDTO pedidoAreaTrabajoDTOConsolidado, PedidoAreaTrabajoInformacionDTO pedidoAreaTrabajoInformacionDTO, 
			String codigoBodegaSubbodega, Integer codigoBodega) throws SICException;
	
}
