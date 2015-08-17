package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.dao;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;

public interface IBusquedaAnomaliasDAO {

	public Collection<PedidoAreaTrabajoDetalleDTO> buscarDetallesSinSubBodega(PedidoAreaTrabajoDetalleDTO detalle,
			Collection<Integer> codigosSubbodegas, Date fechaInicio, Date fechaFin, String tipoAnomaliaConsulta) throws SICException;

	public Collection<PedidoAreaTrabajoDetalleDTO> buscarDetallesConSubBodega(PedidoAreaTrabajoDetalleDTO detalle, Date fechaInicio, Date fechaFin, String tipoAnomaliaConsulta);

	public Integer buscarCantidadDetallesSinSubBodega(PedidoAreaTrabajoDetalleDTO detalle, Collection<Integer> codigosSubbodegas, Date fechaInicio, Date fechaFin, String tipoAnomaliaConsulta);

	public Integer buscarCantidadDetallesConSubBodega(PedidoAreaTrabajoDetalleDTO detalle, Date fechaInicio, Date fechaFin, String tipoAnomaliaConsulta);
}
