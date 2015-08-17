package ec.com.smx.sic.cliente.gestor.articulo.archivo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;

public interface IArticuloArchivoGestor {

	public void registrarArticuloArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO)throws SICException;
	
	Collection<ArticuloDefinicionArchivoDTO> obtenerArticuloDefinicionArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO)throws SICException;

	public void procesoRedimensionarImagenFTP(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO)throws SICException;
}
