/**
 * 
 */
package ec.com.smx.sic.cliente.common.busqueda.bean;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;

/**
 * @author Victor Jaramillo
 *
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaBodega extends BaseSearchTemplate {

	@ComparatorTypeField
	private BaseCriteriaRestriction codigoBodega;
	@ComparatorTypeField
	private BaseCriteriaRestriction descripcionBodega;
	
	public PlantillaBusquedaBodega () {}
	
	/**
	 * 
	 * @param codigoCompania
	 */
	public PlantillaBusquedaBodega(Integer codigoCompania) {
		super(codigoCompania);
	}

	/**
	 * @return the codigoBodega
	 */
	public BaseCriteriaRestriction getCodigoBodega() {
		return codigoBodega;
	}

	/**
	 * @param codigoBodega the codigoBodega to set
	 */
	public void setCodigoBodega(BaseCriteriaRestriction codigoBodega) {
		this.codigoBodega = codigoBodega;
	}

	/**
	 * @return the descripcionBodega
	 */
	public BaseCriteriaRestriction getDescripcionBodega() {
		return descripcionBodega;
	}

	/**
	 * @param descripcionBodega the descripcionBodega to set
	 */
	public void setDescripcionBodega(BaseCriteriaRestriction descripcionBodega) {
		this.descripcionBodega = descripcionBodega;
	}
	
}
