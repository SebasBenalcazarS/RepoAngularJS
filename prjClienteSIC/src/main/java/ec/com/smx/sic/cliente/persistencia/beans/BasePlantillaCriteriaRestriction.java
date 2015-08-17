/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.beans;

import org.apache.commons.lang3.BooleanUtils;
import org.hibernate.criterion.Criterion;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 * 
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public abstract class BasePlantillaCriteriaRestriction<PLANTILLA extends ISearchTemplate> extends BaseCriteriaRestriction {


	private PLANTILLA plantillaBusqueda;


	public BasePlantillaCriteriaRestriction(PLANTILLA plantillaBusqueda) {
		this.plantillaBusqueda = plantillaBusqueda;
	}

	/**
	 * @return the plantillaBusqueda
	 */
	protected PLANTILLA getPlantillaBusqueda() {
		return plantillaBusqueda;
	}

	/**
	 * @param plantillaBusqueda the plantillaBusqueda to set
	 */
	protected void setPlantillaBusqueda(PLANTILLA plantillaBusqueda) {
		this.plantillaBusqueda = plantillaBusqueda;
	}

	/**
	 * 
	 * @return
	 */
	protected Boolean validarExistenciaFiltrosPlantilla(){
		return this.plantillaBusqueda != null && this.plantillaBusqueda.existsFilters();
	}


	protected abstract Criterion construirCriteriaRestriction();


	@Override
	public Criterion getCriteriaRestriction() {

		try {
			if (BooleanUtils.isTrue(this.validarExistenciaFiltrosPlantilla())) {
				super.setBooleanClauseEnum(this.plantillaBusqueda.getBooleanClauseEnum());
				return this.construirCriteriaRestriction();
			}	
			return null;
		} catch (Exception e){
			throw new SICException(e);
		}
	}
}
