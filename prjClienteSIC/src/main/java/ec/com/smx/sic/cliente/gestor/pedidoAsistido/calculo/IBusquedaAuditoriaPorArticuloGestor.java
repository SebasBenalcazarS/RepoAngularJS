package ec.com.smx.sic.cliente.gestor.pedidoAsistido.calculo;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;
import ec.com.smx.sic.cliente.mdl.vo.AuditoriaPorArticuloVO;

public interface IBusquedaAuditoriaPorArticuloGestor extends Serializable{

	public Collection<PedidoAreaTrabajoDetalleDTO> buscarAuditoriaPorArticulo(AuditoriaPorArticuloVO configuracion) throws SICException;

	public Integer buscarCantidadAuditoriaPorArticulo(AuditoriaPorArticuloVO auditoriaPorArticuloVO);
	
	/*PRUEBA*/
	public Collection<PedidoAreaTrabajoDetalleDTO> prueba (PedidoAreaTrabajoDetalleDTO detalle);

}
