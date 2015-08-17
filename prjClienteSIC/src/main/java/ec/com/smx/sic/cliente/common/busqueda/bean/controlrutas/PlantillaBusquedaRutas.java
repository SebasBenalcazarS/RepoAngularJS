/**
 * 
 */
package ec.com.smx.sic.cliente.common.busqueda.bean.controlrutas;

import java.util.Date;

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
public class PlantillaBusquedaRutas extends BaseSearchTemplate {

	private SearchTemplateDTO<Long> codigoRuta;
	private SearchTemplateDTO<String> origenRuta;
	private SearchTemplateDTO<String> destinoRuta;
	private SearchTemplateDTO<Date> fechaSalida;
	private SearchTemplateDTO<String> furgonRuta;
	private SearchTemplateDTO<String> vehiculoRuta;
	private SearchTemplateDTO<Integer> codigoOrigen;
	@ComparatorTypeField
	private BaseCriteriaRestriction estadoRuta;
	@ComparatorTypeField
	private BaseCriteriaRestriction estadorRegistro;
	
	
	public PlantillaBusquedaRutas(Integer codigoCompania) {
		super(codigoCompania);
	}

	/**
	 * @return the codigoRuta
	 */
	public SearchTemplateDTO<Long> getCodigoRuta() {
		return codigoRuta;
	}

	/**
	 * @param codigoRuta the codigoRuta to set
	 */
	public void setCodigoRuta(SearchTemplateDTO<Long> codigoRuta) {
		this.codigoRuta = codigoRuta;
	}

	/**
	 * @return the estadoRuta
	 */
	public BaseCriteriaRestriction getEstadoRuta() {
		return estadoRuta;
	}

	/**
	 * @param estadoRuta the estadoRuta to set
	 */
	public void setEstadoRuta(BaseCriteriaRestriction estadoRuta) {
		this.estadoRuta = estadoRuta;
	}

	/**
	 * @return the estadorRegistro
	 */
	public BaseCriteriaRestriction getEstadorRegistro() {
		return estadorRegistro;
	}

	/**
	 * @param estadorRegistro the estadorRegistro to set
	 */
	public void setEstadorRegistro(BaseCriteriaRestriction estadorRegistro) {
		this.estadorRegistro = estadorRegistro;
	}

	/**
	 * @return the origenRuta
	 */
	public SearchTemplateDTO<String> getOrigenRuta() {
		return origenRuta;
	}

	/**
	 * @param origenRuta the origenRuta to set
	 */
	public void setOrigenRuta(SearchTemplateDTO<String> origenRuta) {
		this.origenRuta = origenRuta;
	}

	/**
	 * @return the destinoRuta
	 */
	public SearchTemplateDTO<String> getDestinoRuta() {
		return destinoRuta;
	}

	/**
	 * @param destinoRuta the destinoRuta to set
	 */
	public void setDestinoRuta(SearchTemplateDTO<String> destinoRuta) {
		this.destinoRuta = destinoRuta;
	}

	/**
	 * @return the fechaSalida
	 */
	public SearchTemplateDTO<Date> getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * @param fechaSalida the fechaSalida to set
	 */
	public void setFechaSalida(SearchTemplateDTO<Date> fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * @return the furgonRuta
	 */
	public SearchTemplateDTO<String> getFurgonRuta() {
		return furgonRuta;
	}

	/**
	 * @param furgonRuta the furgonRuta to set
	 */
	public void setFurgonRuta(SearchTemplateDTO<String> furgonRuta) {
		this.furgonRuta = furgonRuta;
	}

	/**
	 * @return the vehiculoRuta
	 */
	public SearchTemplateDTO<String> getVehiculoRuta() {
		return vehiculoRuta;
	}

	/**
	 * @param vehiculoRuta the vehiculoRuta to set
	 */
	public void setVehiculoRuta(SearchTemplateDTO<String> vehiculoRuta) {
		this.vehiculoRuta = vehiculoRuta;
	}

	/**
	 * @return the codigoOrigen
	 */
	public SearchTemplateDTO<Integer> getCodigoOrigen() {
		return codigoOrigen;
	}

	/**
	 * @param codigoOrigen the codigoOrigen to set
	 */
	public void setCodigoOrigen(SearchTemplateDTO<Integer> codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}
	
}
