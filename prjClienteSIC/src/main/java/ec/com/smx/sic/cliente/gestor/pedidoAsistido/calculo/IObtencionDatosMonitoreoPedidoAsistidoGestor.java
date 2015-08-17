package ec.com.smx.sic.cliente.gestor.pedidoAsistido.calculo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.MonitoreoPedidoVO;

public interface IObtencionDatosMonitoreoPedidoAsistidoGestor {

	/**
	 * M�todo que obtiene los datos iniciales para la pantalla monitoreo
	 * @param monitoreoPedidoVO
	 * @throws SICException
	 */
	public void obtenerDatos(MonitoreoPedidoVO monitoreoPedidoVO) throws SICException;

	/**
	 * M�todo que obtiene los pedidos enviando la bodega
	 * @param monitoreoPedidoVO
	 * @param centroDistribucion
	 * @param fechaPedido
	 * @param subbodegas
	 * @param codigoEstadoCatalogoValor
	 * @param codigoEstadoCatalogoTipo
	 * @param local
	 * @throws SICException
	 */
	public void obtenerPedidosConBodega(MonitoreoPedidoVO monitoreoPedidoVO) throws SICException;


	public Collection<PedidoAreaTrabajoDTO> obtenerHijosPedidosSeleccionado(MonitoreoPedidoVO monitoreoPedidoVO)throws SICException;


	/**
	 * Obtiene el detalle de los Items por subbodega para la visualizacion
	 * @param monitoreoPedidoVO
	 * @return
	 */
	public Collection<PedidoAreaTrabajoDetalleDTO> obtenerItemsDetallePorSubbodega(MonitoreoPedidoVO monitoreoPedidoVO) throws SICException;


	public Collection<PedidoAreaTrabajoDTO> obtenerPedidoAreaTrabajoActualizado(Collection<PedidoAreaTrabajoDTO> pedidosSeleccionados, Long codigoPedidoAreaTrabajoHijo, Boolean buscarHijos ) throws SICException;

	public PedidoAreaTrabajoDTO obtenerPedidoExistente(PedidoAreaTrabajoDTO pedidoAreaTrabajoDTO) throws SICException;
	
	public Collection<PedidoAreaTrabajoEstadoDTO> obtenerEstadosPedidoSeleccionado(PedidoAreaTrabajoDTO pedidoSeleccionado)throws SICException;
	
	public Double obtenerVolumenTotalPedido(Date fechaPedido, String codigoTipoPedido, Integer codigoLocal);
	
	public void buscarUsuariosConfiguracionNoPedidos(ArrayList<PedidoAreaTrabajoDTO> padres, 
			MonitoreoPedidoVO monitoreoPedidoVO, ArrayList<Integer> codigosSubbodegasEncontradas, 
			HashSet<AreaTrabajoDTO> subbodegaEncontradas, Integer casoDatos);

}
