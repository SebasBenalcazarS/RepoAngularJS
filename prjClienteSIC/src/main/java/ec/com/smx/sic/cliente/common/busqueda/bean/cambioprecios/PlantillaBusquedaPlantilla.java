package ec.com.smx.sic.cliente.common.busqueda.bean.cambioprecios;

import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;

/**
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaPlantilla extends BaseSearchTemplate{
	
	private SearchTemplateDTO<String> codigoPlantilla;
	private SearchTemplateDTO<String> nombrePlantilla;
	
	public PlantillaBusquedaPlantilla(Integer codigoCompania) {
		super(codigoCompania);
	}

	/**
	 * @return the codigoPlantilla
	 */
	public SearchTemplateDTO<String> getCodigoPlantilla() {
		return codigoPlantilla;
	}

	/**
	 * @param codigoPlantilla the codigoPlantilla to set
	 */
	public void setCodigoPlantilla(SearchTemplateDTO<String> codigoPlantilla) {
		this.codigoPlantilla = codigoPlantilla;
	}

	/**
	 * @return the nombrePlantilla
	 */
	public SearchTemplateDTO<String> getNombrePlantilla() {
		return nombrePlantilla;
	}

	/**
	 * @param nombrePlantilla the nombrePlantilla to set
	 */
	public void setNombrePlantilla(SearchTemplateDTO<String> nombrePlantilla) {
		this.nombrePlantilla = nombrePlantilla;
	}

}
