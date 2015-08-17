package ec.com.smx.sic.cliente.gestor.pedidoAsistido.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;
import ec.com.smx.sic.cliente.mdl.vo.ConsultaAnomaliaPedidoVO;

public interface IBusquedaAnomaliasGestor extends Serializable {

	public Collection<PedidoAreaTrabajoDetalleDTO> busquedaAnomalias(ConsultaAnomaliaPedidoVO consultaAnomaliasPedidoVO, Integer codigoCompania);

	public List<PedidoAreaTrabajoDetalleDTO> busquedaAnomaliasGestor(ConsultaAnomaliaPedidoVO consultaAnomaliasPedidoVO);

	public Integer buscarCantidadAnomaliasPedido(ConsultaAnomaliaPedidoVO configuracion);

}
