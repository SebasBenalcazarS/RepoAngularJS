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
public class PlantillaBusquedaChofer extends BaseSearchTemplate {

	// Filtros de busqueda choferes	
	private SearchTemplateDTO<Long> codigoChofer;
	private SearchTemplateDTO<String> cedulaChofer;
	private SearchTemplateDTO<String> primerApellidoChofer;
	private SearchTemplateDTO<String> segundoApellidoChofer;
	private SearchTemplateDTO<String> primerNombreChofer;
	private SearchTemplateDTO<String> segundoNombreChofer;
	@ComparatorTypeField
	private BaseCriteriaRestriction documentoTransportista;
	@ComparatorTypeField
	private BaseCriteriaRestriction nombreTransportista;
	
		
	public PlantillaBusquedaChofer(Integer codigoCompania) {
		super(codigoCompania);
	}


	/**
	 * @return the cedulaChofer
	 */
	public SearchTemplateDTO<String> getCedulaChofer() {
		return cedulaChofer;
	}


	/**
	 * @param cedulaChofer the cedulaChofer to set
	 */
	public void setCedulaChofer(SearchTemplateDTO<String> cedulaChofer) {
		this.cedulaChofer = cedulaChofer;
	}


	/**
	 * @return the codigoChofer
	 */
	public SearchTemplateDTO<Long> getCodigoChofer() {
		return codigoChofer;
	}


	/**
	 * @param codigoChofer the codigoChofer to set
	 */
	public void setCodigoChofer(SearchTemplateDTO<Long> codigoChofer) {
		this.codigoChofer = codigoChofer;
	}


	/**
	 * @return the primerApellidoChofer
	 */
	public SearchTemplateDTO<String> getPrimerApellidoChofer() {
		return primerApellidoChofer;
	}


	/**
	 * @param primerApellidoChofer the primerApellidoChofer to set
	 */
	public void setPrimerApellidoChofer(SearchTemplateDTO<String> primerApellidoChofer) {
		this.primerApellidoChofer = primerApellidoChofer;
	}


	/**
	 * @return the segundoApellidoChofer
	 */
	public SearchTemplateDTO<String> getSegundoApellidoChofer() {
		return segundoApellidoChofer;
	}


	/**
	 * @param segundoApellidoChofer the segundoApellidoChofer to set
	 */
	public void setSegundoApellidoChofer(SearchTemplateDTO<String> segundoApellidoChofer) {
		this.segundoApellidoChofer = segundoApellidoChofer;
	}


	/**
	 * @return the primerNombreChofer
	 */
	public SearchTemplateDTO<String> getPrimerNombreChofer() {
		return primerNombreChofer;
	}


	/**
	 * @param primerNombreChofer the primerNombreChofer to set
	 */
	public void setPrimerNombreChofer(SearchTemplateDTO<String> primerNombreChofer) {
		this.primerNombreChofer = primerNombreChofer;
	}


	/**
	 * @return the segundoNombreChofer
	 */
	public SearchTemplateDTO<String> getSegundoNombreChofer() {
		return segundoNombreChofer;
	}


	/**
	 * @param segundoNombreChofer the segundoNombreChofer to set
	 */
	public void setSegundoNombreChofer(SearchTemplateDTO<String> segundoNombreChofer) {
		this.segundoNombreChofer = segundoNombreChofer;
	}


	/**
	 * @return the documentoTransportista
	 */
	public BaseCriteriaRestriction getDocumentoTransportista() {
		return documentoTransportista;
	}


	/**
	 * @param documentoTransportista the documentoTransportista to set
	 */
	public void setDocumentoTransportista(BaseCriteriaRestriction documentoTransportista) {
		this.documentoTransportista = documentoTransportista;
	}


	/**
	 * @return the nombreTransportista
	 */
	public BaseCriteriaRestriction getNombreTransportista() {
		return nombreTransportista;
	}


	/**
	 * @param nombreTransportista the nombreTransportista to set
	 */
	public void setNombreTransportista(BaseCriteriaRestriction nombreTransportista) {
		this.nombreTransportista = nombreTransportista;
	}
	
	
}
