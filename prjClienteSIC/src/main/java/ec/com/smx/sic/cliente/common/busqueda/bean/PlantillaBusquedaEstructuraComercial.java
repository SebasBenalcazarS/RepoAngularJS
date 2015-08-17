/**
 * 
 */
package ec.com.smx.sic.cliente.common.busqueda.bean;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;


/**
 * @author Luis Yacchirema
 *
 * @author Gabriel Nolivos
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaEstructuraComercial extends BaseSearchTemplate {

	@ComparatorTypeField
	private BaseCriteriaRestriction codigoClasificacion;
	@ComparatorTypeField
	private BaseCriteriaRestriction descripcionClasificacion;

	public PlantillaBusquedaEstructuraComercial () {}
	
	public PlantillaBusquedaEstructuraComercial(Integer codigoCompania) {
		super(codigoCompania);
	}

	/**
	 * @return the codigoClasificacion
	 */
	public BaseCriteriaRestriction getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/**
	 * @param codigoClasificacion the codigoClasificacion to set
	 */
	public void setCodigoClasificacion(BaseCriteriaRestriction codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	/**
	 * @return the descripcionClasificacion
	 */
	public BaseCriteriaRestriction getDescripcionClasificacion() {
		return descripcionClasificacion;
	}

	/**
	 * @param descripcionClasificacion the descripcionClasificacion to set
	 */
	public void setDescripcionClasificacion(
			BaseCriteriaRestriction descripcionClasificacion) {
		this.descripcionClasificacion = descripcionClasificacion;
	}

}
