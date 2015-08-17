package ec.com.smx.sic.articulo.gestor.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.articulo.gestor.alcance.ArticuloAlcanceGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

/**
 * Permite obtener la estructura de alcances para el reporte de alcances en excel
 * @author fcollaguazo
 *
 * @param <T>
 */
public class ReporteAlcanceItemWriter<T extends SearchDTO> implements ItemWriter<ArticuloDTO> {

	private ArticuloAlcanceGestor articuloAlcanceGestor;
	
	@Override
	public void write(List<? extends ArticuloDTO> items) throws SICException {
		try{
			articuloAlcanceGestor.agregarResultados(items);
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al transformar ReporteAlcanceItemWriter {}",e);
			throw new SICException("Error al transformar ReporteAlcanceItemWriter " , e);
		}
	}

	/**
	 * @param articuloAlcanceGestor the articuloAlcanceGestor to set
	 */
	public void setArticuloAlcanceGestor(ArticuloAlcanceGestor articuloAlcanceGestor) {
		this.articuloAlcanceGestor = articuloAlcanceGestor;
	}
}
