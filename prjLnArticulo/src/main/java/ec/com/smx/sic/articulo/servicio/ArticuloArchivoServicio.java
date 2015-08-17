package ec.com.smx.sic.articulo.servicio;

import java.util.Collection;

import org.springframework.scheduling.annotation.Async;

import ec.com.smx.sic.articulo.gestor.archivo.ArticuloArchivoGestor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.archivo.IArticuloArchivoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloArchivoServicio;


public class ArticuloArchivoServicio implements IArticuloArchivoServicio {

private IArticuloArchivoGestor articuloArchivoGestor;



	public void registrarArticuloArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO)	throws SICException {
		this.articuloArchivoGestor.registrarArticuloArchivo(articuloDefinicionArchivoDTO);
		
	}



	public void setArticuloArchivoGestor(ArticuloArchivoGestor articuloArchivoGestor) {
		this.articuloArchivoGestor = articuloArchivoGestor;
	}



	@Override
	public Collection<ArticuloDefinicionArchivoDTO> obtenerArticuloDefinicionArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO) throws SICException {
		return articuloArchivoGestor.obtenerArticuloDefinicionArchivo(articuloDefinicionArchivoDTO);
	}


	@Override
	@Async
	public void procesoRedimensionarImagenFTP(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO) throws SICException {
		articuloArchivoGestor.procesoRedimensionarImagenFTP(articuloDefinicionArchivoDTO);
		
	}

	
}
