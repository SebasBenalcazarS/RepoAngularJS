package ec.com.smx.sic.cliente.persistencia.articulos.restricciones;

import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;

@SuppressWarnings("serial")
public class ArticuloRegistroSanitarioPlantillaRestriction extends BaseSearchTemplate{
	
	private SearchTemplateDTO<String> compRegistroSanitario;
	private SearchTemplateDTO<Boolean> compPermiteImpEti;
	
	public ArticuloRegistroSanitarioPlantillaRestriction(Integer codigoCompania) {
		super(codigoCompania);
	}

	public SearchTemplateDTO<String> getCompRegistroSanitario() {
		return compRegistroSanitario;
	}

	public void setCompRegistroSanitario(SearchTemplateDTO<String> compRegistroSanitario) {
		this.compRegistroSanitario = compRegistroSanitario;
	}

	public SearchTemplateDTO<Boolean> getCompPermiteImpEti() {
		return compPermiteImpEti;
	}

	public void setCompPermiteImpEti(SearchTemplateDTO<Boolean> compPermiteImpEti) {
		this.compPermiteImpEti = compPermiteImpEti;
	}
}
