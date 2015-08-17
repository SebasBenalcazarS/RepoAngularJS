package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloAsignacionLocalVO;

public interface IBusquedaArticuloLocalPedidoDAO {
	
	public Collection<ArticuloAsignacionLocalVO> obtenerArticuloLocal(ArticuloID articuloId , Integer tipoAreaTrabajoTic , String tipoAreaTrabajoValor)throws SICException;
	
	public Collection<ArticuloLocalPedidoDTO> obtenerArticuloLocalPedido(ArticuloID articuloId)throws SICException;
}
