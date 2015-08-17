/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.dao;

import java.util.Collection;

import org.quartz.Scheduler;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;
import ec.com.smx.sic.cliente.mdl.vo.MonitoreoPedidoVO;

/**
 * @author jvillacis
 *
 */
public interface IPedidoAreaTrabajoDetalleDAO {

	/**
	 * Obtiene una colecci&oacute;n de <code>ArticuloUnidadManejoDTO</code>, resultado de la b&uacute;squeda paginada 
	 * @param articuloUnidadManejoDTO
	 * @param scheduler
	 * @param countResults
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<ArticuloUnidadManejoDTO> obtenerArticulosUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, Scheduler scheduler, 
			Long countResults) throws SICException;
	
	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @param resultDTO
	 * @throws SICException
	 */
	public void obtenerArticulosUnidadManejoCount(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, SearchResultDTO<ArticuloUnidadManejoDTO> resultDTO) throws SICException;
	
	/**
	 * 
	 * @param pedidoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> obtenerItemsDetallePorSubbodegaHijos(PedidoAreaTrabajoDetalleDTO pedidoDTO) throws SICException;
	
	/**
	 * 
	 * @param pedidoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> obtenerItemsDetPorSubbPadDisc(PedidoAreaTrabajoDetalleDTO pedidoDTO, MonitoreoPedidoVO monitoreoPedido) throws SICException;
	
	/**
	 * 
	 * @param pedidoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> obtenerCantidadesHijos(PedidoAreaTrabajoDetalleDTO pedidoDTO, MonitoreoPedidoVO monitoreoPedidoVO)throws SICException ;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosPedidoAreaTrabajo
	 * @param userId
	 * @throws SICException
	 */
	public void inactivarPedidoAreaTrabajoDetalle(Integer codigoCompania, Long codigosPedidoAreaTrabajo, String userId) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param valorMarca
	 * @param codigosPedidoAreaTrabajoDetalle
	 * @throws SICException
	 */
	public void actualizarDetallesMarcados(Integer codigoCompania, String userId, String valorMarca, Collection<Long> codigosPedidoAreaTrabajoDetalle) throws SICException;
	
	/**
	 * Obtener detalles de pedido
	 * 
	 * @param pedidoAreaTrabajoDetalle
	 * @return
	 * @throws SICException
	 */
	//public SearchResultDTO<PedidoAreaTrabajoDetalleDTO> obtenerDetallesPedidoAsistido (PedidoAreaTrabajoDetalleDTO pedidoAreaTrabajoDetalle) throws SICException;
}
