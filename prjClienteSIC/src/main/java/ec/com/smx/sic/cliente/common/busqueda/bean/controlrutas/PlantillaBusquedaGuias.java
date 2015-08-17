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
public class PlantillaBusquedaGuias extends BaseSearchTemplate {

	private SearchTemplateDTO<String> codigoGuia;
	private SearchTemplateDTO<Date> fechaEmision;
	private SearchTemplateDTO<Integer> codigoOrigen;
	@ComparatorTypeField
	private BaseCriteriaRestriction tipoDestino;
	@ComparatorTypeField
	private BaseCriteriaRestriction motivoTraslado;
	private SearchTemplateDTO<String> codigoFurgon;
	private SearchTemplateDTO<String> placaVehiculo;
	@ComparatorTypeField
	private BaseCriteriaRestriction estadoRegistro;
	@ComparatorTypeField
	private BaseCriteriaRestriction estadoGeneracionGuia;

	
	public PlantillaBusquedaGuias(Integer codigoCompania) {
		super(codigoCompania);
	}

	/**
	 * @return the codigoGuia
	 */
	public SearchTemplateDTO<String> getCodigoGuia() {
		return codigoGuia;
	}



	/**
	 * @param codigoGuia the codigoGuia to set
	 */
	public void setCodigoGuia(SearchTemplateDTO<String> codigoGuia) {
		this.codigoGuia = codigoGuia;
	}

	/**
	 * @return the fechaEmision
	 */
	public SearchTemplateDTO<Date> getFechaEmision() {
		return fechaEmision;
	}

	/**
	 * @param fechaEmision the fechaEmision to set
	 */
	public void setFechaEmision(SearchTemplateDTO<Date> fechaEmision) {
		this.fechaEmision = fechaEmision;
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

	/**
	 * @return the tipoDestino
	 */
	public BaseCriteriaRestriction getTipoDestino() {
		return tipoDestino;
	}

	/**
	 * @param tipoDestino the tipoDestino to set
	 */
	public void setTipoDestino(BaseCriteriaRestriction tipoDestino) {
		this.tipoDestino = tipoDestino;
	}

	/**
	 * @return the motivoTraslado
	 */
	public BaseCriteriaRestriction getMotivoTraslado() {
		return motivoTraslado;
	}

	/**
	 * @param motivoTraslado the motivoTraslado to set
	 */
	public void setMotivoTraslado(BaseCriteriaRestriction motivoTraslado) {
		this.motivoTraslado = motivoTraslado;
	}

	/**
	 * @return the codigoFurgon
	 */
	public SearchTemplateDTO<String> getCodigoFurgon() {
		return codigoFurgon;
	}

	/**
	 * @param codigoFurgon the codigoFurgon to set
	 */
	public void setCodigoFurgon(SearchTemplateDTO<String> codigoFurgon) {
		this.codigoFurgon = codigoFurgon;
	}

	/**
	 * @return the placaVehiculo
	 */
	public SearchTemplateDTO<String> getPlacaVehiculo() {
		return placaVehiculo;
	}

	/**
	 * @param placaVehiculo the placaVehiculo to set
	 */
	public void setPlacaVehiculo(SearchTemplateDTO<String> placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
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
	 * @return the estadoGeneracionGuia
	 */
	public BaseCriteriaRestriction getEstadoGeneracionGuia() {
		return estadoGeneracionGuia;
	}

	/**
	 * @param estadoGeneracionGuia the estadoGeneracionGuia to set
	 */
	public void setEstadoGeneracionGuia(BaseCriteriaRestriction estadoGeneracionGuia) {
		this.estadoGeneracionGuia = estadoGeneracionGuia;
	}
}
