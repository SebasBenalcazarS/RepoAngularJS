package ec.com.smx.sic.cliente.common.busqueda.bean;

import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;

/**
 * @author ines vasquez
 * 
 */

@SuppressWarnings("serial")
public class PlantillaBusquedaLineaComercial extends BaseSearchTemplate {

	private SearchTemplateDTO<String> codigoClasificacionLineaComercial;
	private SearchTemplateDTO<String> nombreClasificacionLineaComercial;
	private String codigoFuncionario;

	public PlantillaBusquedaLineaComercial(Integer codigoCompania) {
		super(codigoCompania);
	}

	/**
	 * @return the codigoClasificacionLineaComercial
	 */
	public SearchTemplateDTO<String> getCodigoClasificacionLineaComercial() {
		return codigoClasificacionLineaComercial;
	}
	/**
	 * @param codigoClasificacionLineaComercial the codigoClasificacionLineaComercial to set
	 */
	public void setCodigoClasificacionLineaComercial(SearchTemplateDTO<String> codigoClasificacionLineaComercial) {
		this.codigoClasificacionLineaComercial = codigoClasificacionLineaComercial;
	}
	/**
	 * @return the nombreClasificacionLineaComercial
	 */
	public SearchTemplateDTO<String> getNombreClasificacionLineaComercial() {
		return nombreClasificacionLineaComercial;
	}
	/**
	 * @param nombreClasificacionLineaComercial the nombreClasificacionLineaComercial to set
	 */
	public void setNombreClasificacionLineaComercial(SearchTemplateDTO<String> nombreClasificacionLineaComercial) {
		this.nombreClasificacionLineaComercial = nombreClasificacionLineaComercial;
	}

	/**
	 * @return the codigoFuncionario
	 */
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	/**
	 * @param codigoFuncionario the codigoFuncionario to set
	 */
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

}
