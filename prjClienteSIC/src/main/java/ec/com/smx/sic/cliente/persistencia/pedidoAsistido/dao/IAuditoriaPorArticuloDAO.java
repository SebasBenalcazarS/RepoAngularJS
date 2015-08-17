package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.dao;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;

public interface IAuditoriaPorArticuloDAO {

	public Collection<PedidoAreaTrabajoDetalleDTO> buscarAuditoriaPorArticulo(PedidoAreaTrabajoDetalleDTO detalle, Date fechaInicio, Date fechaFin, String estado);

	public Integer buscarCantidadAuditoriaPorArticulo(PedidoAreaTrabajoDetalleDTO detalle, Date fechaInicio, Date fechaFin, String estado);

	public Collection<PedidoAreaTrabajoDetalleDTO> prueba(PedidoAreaTrabajoDetalleDTO detalle);

}
