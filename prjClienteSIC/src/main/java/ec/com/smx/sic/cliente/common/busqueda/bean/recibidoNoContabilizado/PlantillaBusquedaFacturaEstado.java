/**
 * 
 */
package ec.com.smx.sic.cliente.common.busqueda.bean.recibidoNoContabilizado;

import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;

/**
 * @author vjaramillo
 *
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaFacturaEstado extends BaseSearchTemplate {

	private SearchTemplateDTO<String> numeroFactura;

	public PlantillaBusquedaFacturaEstado(Integer codigoCompania) {
		super(codigoCompania);
	}
	
	/**
	 * @return the numeroFactura
	 */
	public SearchTemplateDTO<String> getNumeroFactura() {
		return numeroFactura;
	}

	/**
	 * @param numeroFactura the numeroFactura to set
	 */
	public void setNumeroFactura(SearchTemplateDTO<String> numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

}
