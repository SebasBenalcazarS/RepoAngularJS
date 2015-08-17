package ec.com.smx.sic.cliente.common.busqueda.bean;

import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;

/**
 * Plantilla de filtros de busqueda de areas de trabajo
 * @author fcollaguazo
 *
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaAreaTrabajo extends BaseSearchTemplate{

	private SearchTemplateDTO<Integer> codigoAreaTrabajo;
	private SearchTemplateDTO<String> nombreAreaTrabajo;
	private SearchTemplateDTO<String> tipoAsignacion;
	private SearchTemplateDTO<String> estadoAlcance;
	
	public PlantillaBusquedaAreaTrabajo(Integer codigoCompania){
		super(codigoCompania);
	}

	public SearchTemplateDTO<Integer> getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	public void setCodigoAreaTrabajo(SearchTemplateDTO<Integer> codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	public SearchTemplateDTO<String> getNombreAreaTrabajo() {
		return nombreAreaTrabajo;
	}

	public void setNombreAreaTrabajo(SearchTemplateDTO<String> nombreAreaTrabajo) {
		this.nombreAreaTrabajo = nombreAreaTrabajo;
	}

	public SearchTemplateDTO<String> getTipoAsignacion() {
		return tipoAsignacion;
	}

	public void setTipoAsignacion(SearchTemplateDTO<String> tipoAsignacion) {
		this.tipoAsignacion = tipoAsignacion;
	}

	public SearchTemplateDTO<String> getEstadoAlcance() {
		return estadoAlcance;
	}

	public void setEstadoAlcance(SearchTemplateDTO<String> estadoAlcance) {
		this.estadoAlcance = estadoAlcance;
	}
}