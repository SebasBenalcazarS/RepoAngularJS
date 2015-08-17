package ec.com.smx.sic.articulo.gestor.batch.writer;

import java.util.Collection;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

public class ArticuloArchivoAlcanceItemWriter<T extends SearchDTO> implements ItemWriter<ArticuloDTO>{

	/**
	 * Plantilla de busqueda y parametros
	 */
	private Collection<ArticuloDTO> articuloDTOCol;
	
	@Override
	public void write(List<? extends ArticuloDTO> articuloCol) throws SICException {
		try {
			articuloDTOCol.addAll(articuloCol);
			
		} catch (SICException e) {
			throw new SICException("error ArticuloArchivoAlcanceItemWriter",e);
		}
		
	}


	/**
	 * @param articuloDTOCol the articuloDTOCol to set
	 */
	public void setArticuloDTOCol(Collection<ArticuloDTO> articuloDTOCol) {
		this.articuloDTOCol = articuloDTOCol;
	}


}
