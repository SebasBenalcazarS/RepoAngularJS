package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;

import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

public interface IArticuloRotuladoDAO {

	public abstract int cambiarEstadoArticulo(Collection<ArticuloDTO> articuloDTOCol, String estado, UserDto userDto);

}