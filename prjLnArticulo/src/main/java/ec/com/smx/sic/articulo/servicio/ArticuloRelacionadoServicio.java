/**
 * 
 */
package ec.com.smx.sic.articulo.servicio;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.articulorelacionado.IArticuloRelacionadoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloRelacionadoServicio;

/**
 * @author gaortiz
 *
 */
public class ArticuloRelacionadoServicio implements IArticuloRelacionadoServicio{
	
	private IArticuloRelacionadoGestor articuloRelacionadoGestor;

	/**
	 * @param articuloRelacionadoGestor the articuloRelacionadoGestor to set
	 */
	public final void setArticuloRelacionadoGestor(IArticuloRelacionadoGestor articuloRelacionadoGestor) {
		this.articuloRelacionadoGestor = articuloRelacionadoGestor;
	}

	@Override
	public void registrarArticulosRelacionados(Collection<ArticuloRelacionDTO> articulosRelacionados) throws SICException {
		this.articuloRelacionadoGestor.registrarArticulosRelacionados(articulosRelacionados);
	}

	@Override
	public void registrarArticuloRelacionado(ArticuloRelacionDTO articuloRelacionDTO) throws SICException {
		this.articuloRelacionadoGestor.registrarArticuloRelacionado(articuloRelacionDTO);
	}

}
