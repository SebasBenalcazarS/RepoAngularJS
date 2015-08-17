/**
 * 
 */
package ec.com.smx.sic.cliente.common.busqueda.bean;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;

/**
 * @author Luis Yacchirema
 *
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaMarca extends BaseSearchTemplate {

	private SearchTemplateDTO<Long> codigoMarca;
	private SearchTemplateDTO<String> nombreMarca;
	@ComparatorTypeField
	private BaseCriteriaRestriction valorTipoMarca;

	public PlantillaBusquedaMarca(Integer codigoCompania) {
		super(codigoCompania);
	}

	/**
	 * @return the codigoMarca
	 */
	public SearchTemplateDTO<Long> getCodigoMarca() {
		return codigoMarca;
	}

	/**
	 * @param codigoMarca the codigoMarca to set
	 */
	public void setCodigoMarca(SearchTemplateDTO<Long> codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	/**
	 * @return the nombreMarca
	 */
	public SearchTemplateDTO<String> getNombreMarca() {
		return nombreMarca;
	}

	/**
	 * @param nombreMarca the nombreMarca to set
	 */
	public void setNombreMarca(SearchTemplateDTO<String> nombreMarca) {
		this.nombreMarca = nombreMarca;
	}

	/**
	 * @return the valorTipoMarca
	 */
	public BaseCriteriaRestriction getValorTipoMarca() {
		return valorTipoMarca;
	}

	/**
	 * @param valorTipoMarca the valorTipoMarca to set
	 */
	public void setValorTipoMarca(BaseCriteriaRestriction valorTipoMarca) {
		this.valorTipoMarca = valorTipoMarca;
	}

}
