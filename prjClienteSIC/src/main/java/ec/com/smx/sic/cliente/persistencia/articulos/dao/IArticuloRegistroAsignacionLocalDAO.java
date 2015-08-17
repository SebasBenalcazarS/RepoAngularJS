package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPedidoDTO;

public interface IArticuloRegistroAsignacionLocalDAO {

	public void registrarArticuloLocalPedido(Collection<ArticuloLocalPedidoDTO> articuloLocalPedidoCol) throws SICException;
	
}
