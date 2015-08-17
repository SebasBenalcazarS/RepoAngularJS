package ec.com.smx.sic.articulo.gestor.batch.writer;

import java.util.Collection;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import ec.com.kruger.encriptacion.util.CodificacionUtil;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.IArticuloAlcanceGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * Permite obtener los articulos afectados alcance, transformarlos a objetos de integracion y comunicar al SIC 
 * @author fcollaguazo
 *
 * @param <T>
 */
public class ComunicarArticuloAlcanceItemWriter<T extends SearchDTO> implements ItemWriter<SearchDTO> {
	
	private Integer count = 0;
	private IArticuloAlcanceGestor articuloAlcanceGestor;
	private String articuloVOString;
	
	@Override
	@SuppressWarnings("unchecked")
	public void write(List<? extends SearchDTO> objetoCol) throws SICException {
		Logeable.LOG_SICV2.info("****************************---------------********************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando ComunicarArticuloAlcanceItemWriter<T extends SearchDTO>");
		Logeable.LOG_SICV2.info("****************************---------------********************************");
		try{
			
			ArticuloVO articuloVO = CodificacionUtil.getInstancia().decodificarStringAObjeto(articuloVOString, ArticuloVO.class);
			
			count += objetoCol.size();
			Logeable.LOG_SICV2.info("Total de articulos-local {}, plantilla {}",count);
			
			if(objetoCol.iterator().next() instanceof ArticuloLocalDTO){
				Collection<ArticuloLocalDTO> articuloLocalDTOs=(Collection<ArticuloLocalDTO>)objetoCol;
				articuloAlcanceGestor.comunicarArticuloLocalSIC(articuloLocalDTOs, articuloVO);
				
			}
			
			//Consumir el servicio de integracion con el SIC
			
		}catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al ComunicarArticuloAlcanceItemWriter {}", e);
			throw new SICException("Error al ComunicarArticuloAlcanceItemWriter {}", e);
		}
	}

	/**
	 * @param articuloAlcanceGestor the articuloAlcanceGestor to set
	 */
	public void setArticuloAlcanceGestor(IArticuloAlcanceGestor articuloAlcanceGestor) {
		this.articuloAlcanceGestor = articuloAlcanceGestor;
	}

	/**
	 * @param articuloVOString the articuloVOString to set
	 */
	public void setArticuloVOString(String articuloVOString) {
		this.articuloVOString = articuloVOString;
	}

	
}
