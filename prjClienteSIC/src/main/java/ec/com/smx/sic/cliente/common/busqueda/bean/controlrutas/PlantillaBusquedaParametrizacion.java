/**
 * 
 */
package ec.com.smx.sic.cliente.common.busqueda.bean.controlrutas;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;

/**
 * @author Esteban Gudino
 * 
 * 
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaParametrizacion extends BaseSearchTemplate {

	private SearchTemplateDTO<String> nombreOrigen;
	private SearchTemplateDTO<Double> distancia;
	@ComparatorTypeField
	private BaseCriteriaRestriction codigoEstadoParametrizacion;	
	private SearchTemplateDTO<Integer> codigoOrigen;
	@ComparatorTypeField
	private BaseCriteriaRestriction ciudadOrigenParametrizacion;	
	@ComparatorTypeField
	private BaseCriteriaRestriction codigoDestino;	
	@ComparatorTypeField
	private BaseCriteriaRestriction nombreDestino;

	
	public PlantillaBusquedaParametrizacion(Integer codigoCompania) {
		super(codigoCompania);
	}

	/**
	 * @return the distancia
	 */
	public SearchTemplateDTO<Double> getDistancia() {
		return distancia;
	}

	/**
	 * @param distancia the distancia to set
	 */
	public void setDistancia(SearchTemplateDTO<Double> distancia) {
		this.distancia = distancia;
	}

	
	/**
	 * @return the nombreOrigen
	 */
	public SearchTemplateDTO<String> getNombreOrigen() {
		return nombreOrigen;
	}

	/**
	 * @param nombreOrigen the nombreOrigen to set
	 */
	public void setNombreOrigen(SearchTemplateDTO<String> nombreOrigen) {
		this.nombreOrigen = nombreOrigen;
	}

	/**
	 * @return the codigoEstadoParametrizacion
	 */
	public BaseCriteriaRestriction getCodigoEstadoParametrizacion() {
		return codigoEstadoParametrizacion;
	}

	/**
	 * @param codigoEstadoParametrizacion the codigoEstadoParametrizacion to set
	 */
	public void setCodigoEstadoParametrizacion(BaseCriteriaRestriction codigoEstadoParametrizacion) {
		this.codigoEstadoParametrizacion = codigoEstadoParametrizacion;
	}


	/**
	 * @return the codigoOrigen
	 */
	public SearchTemplateDTO<Integer> getCodigoOrigen() {
		return codigoOrigen;
	}

	/**
	 * @param codigoOrigen the codigoOrigen to set
	 */
	public void setCodigoOrigen(SearchTemplateDTO<Integer> codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}

	/**
	 * @return the ciudadOrigenParametrizacion
	 */
	public BaseCriteriaRestriction getCiudadOrigenParametrizacion() {
		return ciudadOrigenParametrizacion;
	}

	/**
	 * @param ciudadOrigenParametrizacion the ciudadOrigenParametrizacion to set
	 */
	public void setCiudadOrigenParametrizacion(BaseCriteriaRestriction ciudadOrigenParametrizacion) {
		this.ciudadOrigenParametrizacion = ciudadOrigenParametrizacion;
	}

	/**
	 * @return the codigoDestino
	 */
	public BaseCriteriaRestriction getCodigoDestino() {
		return codigoDestino;
	}

	/**
	 * @param codigoDestino the codigoDestino to set
	 */
	public void setCodigoDestino(BaseCriteriaRestriction codigoDestino) {
		this.codigoDestino = codigoDestino;
	}

	/**
	 * @return the nombreDestino
	 */
	public BaseCriteriaRestriction getNombreDestino() {
		return nombreDestino;
	}

	/**
	 * @param nombreDestino the nombreDestino to set
	 */
	public void setNombreDestino(BaseCriteriaRestriction nombreDestino) {
		this.nombreDestino = nombreDestino;
	}
	
}
