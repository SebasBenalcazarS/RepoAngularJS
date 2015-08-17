package ec.com.smx.sic.articulo.gestor.catalogo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.catalogo.ICatalogoArticuloGestor;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorMarcaDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IMarcaDAO;


public class CatalogoArticuloGestor implements ICatalogoArticuloGestor {

	private DataGestor dataGestor;
	private IMarcaDAO marcaDAO;
	
	
	public void crearClaseArticulo(ClaseArticuloDTO claseArticuloDTO) throws SICException {
		ClaseArticuloDTO filtro = null;
		try{
			//primero se verifica que la existencia de la clase
			filtro = new ClaseArticuloDTO();
			filtro.setId(claseArticuloDTO.getId());
			Collection<ClaseArticuloDTO> col = dataGestor.findObjects(filtro);
			if(col.isEmpty()){
				dataGestor.create(claseArticuloDTO);
			}else{
				ClaseArticuloDTO clase = col.iterator().next();
				if(clase.getStatus().equals(SICConstantes.ESTADO_INACTIVO_LITERAL)){
					clase.setStatus(SICConstantes.ESTADO_ACTIVO_LITERAL);
					dataGestor.update(clase);
				}else
					throw new SICException("El codigo de la clase que desea registrar ya existe");
			}
		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(e);
		}finally{
			filtro = null;
		}
	}

	

	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
	

	public void setMarcaDAO(IMarcaDAO marcaDAO) {
		this.marcaDAO = marcaDAO;
	}

	public int cambiarEstadoMarcaProveedor(Collection<ProveedorMarcaDTO> proveedorMarcaCol,String estado,UserDto userDto){
		return marcaDAO.cambiarEstadoMarcaProveedor(proveedorMarcaCol, estado, userDto);
	}

	
}
