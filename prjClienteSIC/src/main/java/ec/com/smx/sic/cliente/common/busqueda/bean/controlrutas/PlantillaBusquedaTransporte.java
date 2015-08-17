/**
 * 
 */
package ec.com.smx.sic.cliente.common.busqueda.bean.controlrutas;

import java.io.Serializable;

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
public class PlantillaBusquedaTransporte extends BaseSearchTemplate implements Serializable, IPlantillaBusquedaTransporte {

	private SearchTemplateDTO<String> placaTransporte;
	private SearchTemplateDTO<Long> codigoTransporte;
	private SearchTemplateDTO<String> tipoTransporte;
	private SearchTemplateDTO<String> marcaTransporte;
	private SearchTemplateDTO<String> colorTransporte;
	@ComparatorTypeField
	private BaseCriteriaRestriction estadoRegistro;
	@ComparatorTypeField
	private BaseCriteriaRestriction documentoTransportista;
	@ComparatorTypeField
	private BaseCriteriaRestriction nombreTransportista;
		
	public PlantillaBusquedaTransporte(Integer codigoCompania) {
		super(codigoCompania);
	}

	/**
	 * @return the placaTransporte
	 */
	public SearchTemplateDTO<String> getPlacaTransporte() {
		return placaTransporte;
	}

	/**
	 * @param placaTransporte the placaTransporte to set
	 */
	public void setPlacaTransporte(SearchTemplateDTO<String> placaTransporte) {
		this.placaTransporte = placaTransporte;
	}

	/**
	 * @return the codigoTransporte
	 */
	public SearchTemplateDTO<Long> getCodigoTransporte() {
		return codigoTransporte;
	}

	/**
	 * @param codigoTransporte the codigoTransporte to set
	 */
	public void setCodigoTransporte(SearchTemplateDTO<Long> codigoTransporte) {
		this.codigoTransporte = codigoTransporte;
	}

	/**
	 * @return the tipoTransporte
	 */
	public SearchTemplateDTO<String> getTipoTransporte() {
		return tipoTransporte;
	}

	/**
	 * @param tipoTransporte the tipoTransporte to set
	 */
	public void setTipoTransporte(SearchTemplateDTO<String> tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	/**
	 * @return the marcaTransporte
	 */
	public SearchTemplateDTO<String> getMarcaTransporte() {
		return marcaTransporte;
	}

	/**
	 * @param marcaTransporte the marcaTransporte to set
	 */
	public void setMarcaTransporte(SearchTemplateDTO<String> marcaTransporte) {
		this.marcaTransporte = marcaTransporte;
	}

	/**
	 * @return the colorTransporte
	 */
	public SearchTemplateDTO<String> getColorTransporte() {
		return colorTransporte;
	}

	/**
	 * @param colorTransporte the colorTransporte to set
	 */
	public void setColorTransporte(SearchTemplateDTO<String> colorTransporte) {
		this.colorTransporte = colorTransporte;
	}

	/**
	 * @return the estadoRegistro
	 */
	public BaseCriteriaRestriction getEstadoRegistro() {
		return estadoRegistro;
	}

	/**
	 * @param estadoRegistro the estadoRegistro to set
	 */
	public void setEstadoRegistro(BaseCriteriaRestriction estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
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
