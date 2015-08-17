package ec.com.smx.sic.articulo.servicio;

import java.util.Collection;

import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.articulo.gestor.catalogo.CatalogoArticuloGestor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.catalogo.ICatalogoArticuloGestor;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorMarcaDTO;
import ec.com.smx.sic.cliente.servicio.articulo.ICatalogoArticuloServicio;

public class CatalogoArticuloServicio implements ICatalogoArticuloServicio{

	private ICatalogoArticuloGestor catalogoArticuloGestor;
	
	public void crearClaseArticulo(ClaseArticuloDTO claseArticuloDTO) throws SICException {
		this.catalogoArticuloGestor.crearClaseArticulo(claseArticuloDTO);
	}


	public void setCatalogoArticuloGestor(
			CatalogoArticuloGestor catalogoArticuloGestor) {
		this.catalogoArticuloGestor = catalogoArticuloGestor;
	}
	
	public int cambiarEstadoMarcaProveedor(Collection<ProveedorMarcaDTO> proveedorMarcaCol,String estado,UserDto userDto) throws SICException{
		return this.catalogoArticuloGestor.cambiarEstadoMarcaProveedor(proveedorMarcaCol, estado, userDto);
	}

		
}
