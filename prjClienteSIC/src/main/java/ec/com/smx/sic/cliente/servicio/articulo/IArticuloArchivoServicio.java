package ec.com.smx.sic.cliente.servicio.articulo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;

public interface IArticuloArchivoServicio {

	public void registrarArticuloArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO)	throws SICException;
		
	Collection<ArticuloDefinicionArchivoDTO> obtenerArticuloDefinicionArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO)throws SICException;
	/**
	 * Redimenciona imagenes y las envia por FTP	
	 * @param articuloDefinicionArchivoDTO
	 * @throws SICException
	 */
	public void procesoRedimensionarImagenFTP(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO)throws SICException;
}
