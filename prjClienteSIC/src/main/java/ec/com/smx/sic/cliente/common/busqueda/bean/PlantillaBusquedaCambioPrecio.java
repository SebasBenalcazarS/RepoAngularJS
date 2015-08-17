package ec.com.smx.sic.cliente.common.busqueda.bean;

import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;


@SuppressWarnings("serial")
public class PlantillaBusquedaCambioPrecio extends BaseSearchTemplate {

	SearchTemplateDTO<String> nombreCambioPrecio;
	SearchTemplateDTO<String> estadoCambioPrecio;
	SearchTemplateDTO<Date> fechaVigenciaPrecio;
	SearchTemplateDTO<Date> fechaVigenciaCosto;
	
	public PlantillaBusquedaCambioPrecio () {}
	
	public PlantillaBusquedaCambioPrecio(Integer codigoCompania) {
		super(codigoCompania);
	}
	
	/**
	 * @return the nombreCambioPrecio
	 */
	public SearchTemplateDTO<String> getNombreCambioPrecio() {
		return nombreCambioPrecio;
	}

	/**
	 * @param nombreCambioPrecio the nombreCambioPrecio to set
	 */
	public void setNombreCambioPrecio(SearchTemplateDTO<String> nombreCambioPrecio) {
		this.nombreCambioPrecio = nombreCambioPrecio;
	}

	/**
	 * @return the estadoCambiPrecio
	 */
	public SearchTemplateDTO<String> getEstadoCambioPrecio() {
		return estadoCambioPrecio;
	}

	/**
	 * @param estadoCambiPrecio the estadoCambiPrecio to set
	 */
	public void setEstadoCambioPrecio(SearchTemplateDTO<String> estadoCambioPrecio) {
		this.estadoCambioPrecio = estadoCambioPrecio;
	}

	/**
	 * @return the fechaVigenciaPrecio
	 */
	public SearchTemplateDTO<Date> getFechaVigenciaPrecio() {
		return fechaVigenciaPrecio;
	}

	/**
	 * @param fechaVigenciaPrecio the fechaVigenciaPrecio to set
	 */
	public void setFechaVigenciaPrecio(SearchTemplateDTO<Date> fechaVigenciaPrecio) {
		this.fechaVigenciaPrecio = fechaVigenciaPrecio;
	}

	/**
	 * @return the fechaVigenciaCosto
	 */
	public SearchTemplateDTO<Date> getFechaVigenciaCosto() {
		return fechaVigenciaCosto;
	}

	/**
	 * @param fechaVigenciaCosto the fechaVigenciaCosto to set
	 */
	public void setFechaVigenciaCosto(SearchTemplateDTO<Date> fechaVigenciaCosto) {
		this.fechaVigenciaCosto = fechaVigenciaCosto;
	}
}
