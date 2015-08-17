package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;

import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorMarcaDTO;

public interface IMarcaDAO {

	public abstract int cambiarEstadoMarcaProveedor(Collection<ProveedorMarcaDTO> proveedorMarcaCol, String estado, UserDto userDto);

}