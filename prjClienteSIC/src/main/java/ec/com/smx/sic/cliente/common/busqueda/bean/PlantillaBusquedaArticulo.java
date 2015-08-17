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
public class PlantillaBusquedaArticulo extends BaseSearchTemplate {

	private SearchTemplateDTO<String> codigoDeBarras;
	private SearchTemplateDTO<String> descripcionArticulo;
	private SearchTemplateDTO<String> codigoReferenciaInterna;
	private SearchTemplateDTO<String> codigoReferenciaExterna;
	private SearchTemplateDTO<String> estadoArticulo;
	private SearchTemplateDTO<Double> medidaArticulo;
	
	@ComparatorTypeField
	private BaseCriteriaRestriction codigoClaseArticulo;

	private String codigoFuncionario;
	
	public PlantillaBusquedaArticulo () {}
	
	public PlantillaBusquedaArticulo(Integer codigoCompania) {
		super(codigoCompania);
	}


	/**
	 * @return the codigoDeBarras
	 */
	public SearchTemplateDTO<String> getCodigoDeBarras() {
		return codigoDeBarras;
	}
	/**
	 * @param codigoDeBarras the codigoDeBarras to set
	 */
	public void setCodigoDeBarras(SearchTemplateDTO<String> codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	/**
	 * @return the descripcionArticulo
	 */
	public SearchTemplateDTO<String> getDescripcionArticulo() {
		return descripcionArticulo;
	}
	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(SearchTemplateDTO<String> descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}	

	/**
	 * @return the codigoReferenciaInterna
	 */
	public SearchTemplateDTO<String> getCodigoReferenciaInterna() {
		return codigoReferenciaInterna;
	}


	/**
	 * @param codigoReferenciaInterna the codigoReferenciaInterna to set
	 */
	public void setCodigoReferenciaInterna(
			SearchTemplateDTO<String> codigoReferenciaInterna) {
		this.codigoReferenciaInterna = codigoReferenciaInterna;
	}


	/**
	 * @return the codigoReferenciaExterna
	 */
	public SearchTemplateDTO<String> getCodigoReferenciaExterna() {
		return codigoReferenciaExterna;
	}


	/**
	 * @param codigoReferenciaExterna the codigoReferenciaExterna to set
	 */
	public void setCodigoReferenciaExterna(
			SearchTemplateDTO<String> codigoReferenciaExterna) {
		this.codigoReferenciaExterna = codigoReferenciaExterna;
	}


	/**
	 * @return the codigoClaseArticulo
	 */
	public BaseCriteriaRestriction getCodigoClaseArticulo() {
		return codigoClaseArticulo;
	}


	/**
	 * @param codigoClaseArticulo the codigoClaseArticulo to set
	 */
	public void setCodigoClaseArticulo(BaseCriteriaRestriction codigoClaseArticulo) {
		this.codigoClaseArticulo = codigoClaseArticulo;
	}


	/**
	 * @return the estadoArticulo
	 */
	public SearchTemplateDTO<String> getEstadoArticulo() {
		return estadoArticulo;
	}


	/**
	 * @param estadoArticulo the estadoArticulo to set
	 */
	public void setEstadoArticulo(SearchTemplateDTO<String> estadoArticulo) {
		this.estadoArticulo = estadoArticulo;
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

	/**
	 * @return the medidaArticulo
	 */
	public SearchTemplateDTO<Double> getMedidaArticulo() {
		return medidaArticulo;
	}

	/**
	 * @param medidaArticulo the medidaArticulo to set
	 */
	public void setMedidaArticulo(SearchTemplateDTO<Double> medidaArticulo) {
		this.medidaArticulo = medidaArticulo;
	}

}
