package ec.com.smx.sic.cliente.common.busqueda.bean;

import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;

@SuppressWarnings("serial")
public class PlantillaBusquedaFuncionario extends BaseSearchTemplate {

	SearchTemplateDTO<String> codigoFuncionario;
	SearchTemplateDTO<String> nombreFuncionario;
	
	public PlantillaBusquedaFuncionario () {}
	
	public PlantillaBusquedaFuncionario(Integer codigoCompania) {
		super(codigoCompania);
	}
	

	public SearchTemplateDTO<String> getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(SearchTemplateDTO<String> codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public SearchTemplateDTO<String> getNombreFuncionario() {
		return nombreFuncionario;
	}

	public void setNombreFuncionario(SearchTemplateDTO<String> nombreFuncionario) {
		this.nombreFuncionario = nombreFuncionario;
	}
}
