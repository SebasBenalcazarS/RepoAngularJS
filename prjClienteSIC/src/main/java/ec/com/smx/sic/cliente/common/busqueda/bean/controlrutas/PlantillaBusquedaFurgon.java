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
public class PlantillaBusquedaFurgon extends BaseSearchTemplate {

	private SearchTemplateDTO<String> codigoFurgon;	
	@ComparatorTypeField
	private BaseCriteriaRestriction codigoTipoFurgon;
	@ComparatorTypeField
	private BaseCriteriaRestriction codigoTipoFurgonValor;
	@ComparatorTypeField
	private BaseCriteriaRestriction codigoPrefijoFurgonValor;
	private SearchTemplateDTO<Integer> codigoAreaTrabajoLoc;
	@ComparatorTypeField
	private BaseCriteriaRestriction codigoUsoValor;
	@ComparatorTypeField
	private BaseCriteriaRestriction codigoEstatusValor;
	@ComparatorTypeField
	private BaseCriteriaRestriction codigoEstadoRegistroValor;
	private SearchTemplateDTO<Long> codigoDetalleSeccion;

	
	public PlantillaBusquedaFurgon(Integer codigoCompania) {
		super(codigoCompania);
	}


	/**
	 * @return the codigoFurgon
	 */
	public SearchTemplateDTO<String> getCodigoFurgon() {
		return codigoFurgon;
	}


	/**
	 * @param codigoFurgon the codigoFurgon to set
	 */
	public void setCodigoFurgon(SearchTemplateDTO<String> codigoFurgon) {
		this.codigoFurgon = codigoFurgon;
	}





	public BaseCriteriaRestriction getCodigoTipoFurgonValor() {
		return codigoTipoFurgonValor;
	}


	public void setCodigoTipoFurgonValor(BaseCriteriaRestriction codigoTipoFurgonValor) {
		this.codigoTipoFurgonValor = codigoTipoFurgonValor;
	}


	public SearchTemplateDTO<Integer> getCodigoAreaTrabajoLoc() {
		return codigoAreaTrabajoLoc;
	}


	public void setCodigoAreaTrabajoLoc(SearchTemplateDTO<Integer> codigoAreaTrabajoLoc) {
		this.codigoAreaTrabajoLoc = codigoAreaTrabajoLoc;
	}


	/**
	 * @return the codigoUsoValor
	 */
	public BaseCriteriaRestriction getCodigoUsoValor() {
		return codigoUsoValor;
	}


	/**
	 * @param codigoUsoValor the codigoUsoValor to set
	 */
	public void setCodigoUsoValor(BaseCriteriaRestriction codigoUsoValor) {
		this.codigoUsoValor = codigoUsoValor;
	}


	/**
	 * @return the codigoEstatusValor
	 */
	public BaseCriteriaRestriction getCodigoEstatusValor() {
		return codigoEstatusValor;
	}


	/**
	 * @param codigoEstatusValor the codigoEstatusValor to set
	 */
	public void setCodigoEstatusValor(BaseCriteriaRestriction codigoEstatusValor) {
		this.codigoEstatusValor = codigoEstatusValor;
	}


	/**
	 * @return the codigoDetalleSeccion
	 */
	public SearchTemplateDTO<Long> getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}


	/**
	 * @param codigoDetalleSeccion the codigoDetalleSeccion to set
	 */
	public void setCodigoDetalleSeccion(SearchTemplateDTO<Long> codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}


	/**
	 * @return the codigoEstadoRegistroValor
	 */
	public BaseCriteriaRestriction getCodigoEstadoRegistroValor() {
		return codigoEstadoRegistroValor;
	}


	/**
	 * @param codigoEstadoRegistroValor the codigoEstadoRegistroValor to set
	 */
	public void setCodigoEstadoRegistroValor(BaseCriteriaRestriction codigoEstadoRegistroValor) {
		this.codigoEstadoRegistroValor = codigoEstadoRegistroValor;
	}


	/**
	 * @return the codigoPrefijoFurgonValor
	 */
	public BaseCriteriaRestriction getCodigoPrefijoFurgonValor() {
		return codigoPrefijoFurgonValor;
	}


	/**
	 * @param codigoPrefijoFurgonValor the codigoPrefijoFurgonValor to set
	 */
	public void setCodigoPrefijoFurgonValor(BaseCriteriaRestriction codigoPrefijoFurgonValor) {
		this.codigoPrefijoFurgonValor = codigoPrefijoFurgonValor;
	}


	/**
	 * @return the codigoTipoFurgon
	 */
	public BaseCriteriaRestriction getCodigoTipoFurgon() {
		return codigoTipoFurgon;
	}


	/**
	 * @param codigoTipoFurgon the codigoTipoFurgon to set
	 */
	public void setCodigoTipoFurgon(BaseCriteriaRestriction codigoTipoFurgon) {
		this.codigoTipoFurgon = codigoTipoFurgon;
	}
}
