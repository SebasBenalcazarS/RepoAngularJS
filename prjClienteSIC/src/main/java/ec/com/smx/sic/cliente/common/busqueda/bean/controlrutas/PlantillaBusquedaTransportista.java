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
public class PlantillaBusquedaTransportista extends BaseSearchTemplate {

	// Filtros de busqueda de transportistas personas
	private SearchTemplateDTO<Long> codigoTransportista;
	private SearchTemplateDTO<String> documentoTransportista;
	private SearchTemplateDTO<String> nombreTransportista;
	private SearchTemplateDTO<Integer> codigoJDETransportista;
	@ComparatorTypeField
	private BaseCriteriaRestriction estadoTransportista;
	
	// Filtros de busqueda de transportistas empresas
	private SearchTemplateDTO<String> rucTransportista;
	private SearchTemplateDTO<Long> codEmpresaTransportista;
	private SearchTemplateDTO<Integer> codJDETransportista;
	private SearchTemplateDTO<String> razonSocialTransportista;
		
	public PlantillaBusquedaTransportista(Integer codigoCompania) {
		super(codigoCompania);
	}

	

	/**
	 * @return the rucTransportista
	 */
	public SearchTemplateDTO<String> getRucTransportista() {
		return rucTransportista;
	}

	/**
	 * @param rucTransportista the rucTransportista to set
	 */
	public void setRucTransportista(SearchTemplateDTO<String> rucTransportista) {
		this.rucTransportista = rucTransportista;
	}

	/**
	 * @return the codEmpresaTransportista
	 */
	public SearchTemplateDTO<Long> getCodEmpresaTransportista() {
		return codEmpresaTransportista;
	}

	/**
	 * @param codEmpresaTransportista the codEmpresaTransportista to set
	 */
	public void setCodEmpresaTransportista(SearchTemplateDTO<Long> codEmpresaTransportista) {
		this.codEmpresaTransportista = codEmpresaTransportista;
	}

	/**
	 * @return the codJDETransportista
	 */
	public SearchTemplateDTO<Integer> getCodJDETransportista() {
		return codJDETransportista;
	}

	/**
	 * @param codJDETransportista the codJDETransportista to set
	 */
	public void setCodJDETransportista(SearchTemplateDTO<Integer> codJDETransportista) {
		this.codJDETransportista = codJDETransportista;
	}

	/**
	 * @return the razonSocialTransportista
	 */
	public SearchTemplateDTO<String> getRazonSocialTransportista() {
		return razonSocialTransportista;
	}

	/**
	 * @param razonSocialTransportista the razonSocialTransportista to set
	 */
	public void setRazonSocialTransportista(SearchTemplateDTO<String> razonSocialTransportista) {
		this.razonSocialTransportista = razonSocialTransportista;
	}

	/**
	 * @return the codigoTransportista
	 */
	public SearchTemplateDTO<Long> getCodigoTransportista() {
		return codigoTransportista;
	}

	/**
	 * @param codigoTransportista the codigoTransportista to set
	 */
	public void setCodigoTransportista(SearchTemplateDTO<Long> codigoTransportista) {
		this.codigoTransportista = codigoTransportista;
	}

	/**
	 * @return the documentoTransportista
	 */
	public SearchTemplateDTO<String> getDocumentoTransportista() {
		return documentoTransportista;
	}

	/**
	 * @param documentoTransportista the documentoTransportista to set
	 */
	public void setDocumentoTransportista(SearchTemplateDTO<String> documentoTransportista) {
		this.documentoTransportista = documentoTransportista;
	}

	/**
	 * @return the nombreTransportista
	 */
	public SearchTemplateDTO<String> getNombreTransportista() {
		return nombreTransportista;
	}

	/**
	 * @param nombreTransportista the nombreTransportista to set
	 */
	public void setNombreTransportista(SearchTemplateDTO<String> nombreTransportista) {
		this.nombreTransportista = nombreTransportista;
	}

	/**
	 * @return the codigoJDETransportista
	 */
	public SearchTemplateDTO<Integer> getCodigoJDETransportista() {
		return codigoJDETransportista;
	}

	/**
	 * @param codigoJDETransportista the codigoJDETransportista to set
	 */
	public void setCodigoJDETransportista(SearchTemplateDTO<Integer> codigoJDETransportista) {
		this.codigoJDETransportista = codigoJDETransportista;
	}

	/**
	 * @return the estadoTransportista
	 */
	public BaseCriteriaRestriction getEstadoTransportista() {
		return estadoTransportista;
	}

	/**
	 * @param estadoTransportista the estadoTransportista to set
	 */
	public void setEstadoTransportista(BaseCriteriaRestriction estadoTransportista) {
		this.estadoTransportista = estadoTransportista;
	}

}
