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
 * @author Gabriel Nolivos
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaProveedor extends BaseSearchTemplate {

	private SearchTemplateDTO<String> codigoProveedor;
	private SearchTemplateDTO<String> numeroDocumento;
	@ComparatorTypeField
	private BaseCriteriaRestriction nombreProveedor;
	@ComparatorTypeField
	private BaseCriteriaRestriction origenProveedor;
	@ComparatorTypeField
	private BaseCriteriaRestriction interproveedor;
	private SearchTemplateDTO<String> estadoArticuloProveedor;
	private SearchTemplateDTO<String> estadoProveedor;

	public PlantillaBusquedaProveedor() { }
	
	public PlantillaBusquedaProveedor(Integer codigoCompania) {
		super(codigoCompania);
	}


	/**
	 * @return the codigoProveedor
	 */
	public SearchTemplateDTO<String> getCodigoProveedor() {
		return codigoProveedor;
	}


	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(SearchTemplateDTO<String> codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}


	/**
	 * @return the numeroDocumento
	 */
	public SearchTemplateDTO<String> getNumeroDocumento() {
		return numeroDocumento;
	}


	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(SearchTemplateDTO<String> numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	/**
	 * @return the nombreProveedor
	 */
	public BaseCriteriaRestriction getNombreProveedor() {
		return nombreProveedor;
	}


	/**
	 * @param nombreProveedor the nombreProveedor to set
	 */
	public void setNombreProveedor(BaseCriteriaRestriction nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}


	/**
	 * @return the origenProveedor
	 */
	public BaseCriteriaRestriction getOrigenProveedor() {
		return origenProveedor;
	}


	/**
	 * @param origenProveedor the origenProveedor to set
	 */
	public void setOrigenProveedor(BaseCriteriaRestriction origenProveedor) {
		this.origenProveedor = origenProveedor;
	}


	/**
	 * @return the interproveedor
	 */
	public BaseCriteriaRestriction getInterproveedor() {
		return interproveedor;
	}


	/**
	 * @param interproveedor the interproveedor to set
	 */
	public void setInterproveedor(BaseCriteriaRestriction interproveedor) {
		this.interproveedor = interproveedor;
	}


	/**
	 * @return the estadoArticuloProveedor
	 */
	public SearchTemplateDTO<String> getEstadoArticuloProveedor() {
		return estadoArticuloProveedor;
	}


	/**
	 * @param estadoArticuloProveedor the estadoArticuloProveedor to set
	 */
	public void setEstadoArticuloProveedor(SearchTemplateDTO<String> estadoArticuloProveedor) {
		this.estadoArticuloProveedor = estadoArticuloProveedor;
	}


	/**
	 * @return the estadoProveedor
	 */
	public SearchTemplateDTO<String> getEstadoProveedor() {
		return estadoProveedor;
	}


	/**
	 * @param estadoProveedor the estadoProveedor to set
	 */
	public void setEstadoProveedor(SearchTemplateDTO<String> estadoProveedor) {
		this.estadoProveedor = estadoProveedor;
	}

}
