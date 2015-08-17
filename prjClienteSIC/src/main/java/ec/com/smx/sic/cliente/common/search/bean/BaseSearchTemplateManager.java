/**
 * 
 */
package ec.com.smx.sic.cliente.common.search.bean;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import ec.com.kruger.utilitario.dao.commons.dto.ISearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 *
 */
@SuppressWarnings("serial")
public abstract class BaseSearchTemplateManager implements ISearchTemplateManager {

	private Map<String, ISearchTemplateBusiness<ISearchDTO>> searchTemplatesBusiness;
	protected DynamicCriteriaRestriction dynamicCriteriaRestriction;

	@Override
	public Map<String, ISearchTemplateBusiness<ISearchDTO>> getSearchTemplatesBusiness() {
		return this.searchTemplatesBusiness;
	}

	@Override
	public void setSearchTemplatesBusiness(Map<String, ISearchTemplateBusiness<ISearchDTO>> searchTemplatesBusiness) {
		this.searchTemplatesBusiness = searchTemplatesBusiness;
	}

	private void executeDynamicCriteriaRestriction(ISearchDTO searchTemplateBase, Collection<ISearchTemplate> searchFiltersTemplates) throws SICException {

		// Inicializar variables
		this.dynamicCriteriaRestriction = new DynamicCriteriaRestriction();

		// Construir plantilla de busqueda por filtros
		for (ISearchTemplate currentSearchFilterTemplate : searchFiltersTemplates){
			this.searchTemplatesBusiness.get(currentSearchFilterTemplate.getClassName()).buildSearchTemplate(searchTemplateBase, currentSearchFilterTemplate, this.dynamicCriteriaRestriction);
		}

		// Existen restricciones
		if (this.dynamicCriteriaRestriction.isNotEmptyCriteriaRestriction()) {
			// Si en base a las plantillas se generaron Criterias Restrictions, entonces se unifican
			// mediante la clase DynamicCriteriaRestriction y se fijan en la plantilla principal
			if (searchTemplateBase != null) {
				searchTemplateBase.getCriteriaRestrictions().add(dynamicCriteriaRestriction);
			}
		} else {
			this.dynamicCriteriaRestriction = null;
		}

	}

	@Override
	public void buildSearchTemplateManager(ISearchDTO searchTemplateBase, Collection<ISearchTemplate> searchFiltersTemplates) throws SICException {

		// Datos no validos
		if (searchTemplateBase == null
				|| CollectionUtils.isEmpty(searchFiltersTemplates)) {
			throw new SICException("No se puede construir una plantilla de búsqueda, xq la plantilla inicial es nula o la lista de filtros de búsqueda está vacía...");
		}

		// Construir restricciones
		this.executeDynamicCriteriaRestriction(searchTemplateBase, searchFiltersTemplates);


	}

	@Override
	public DynamicCriteriaRestriction getDynamicCriteriaRestriction(Collection<ISearchTemplate> searchFiltersTemplates) throws SICException {

		// Datos no validos
		if (CollectionUtils.isEmpty(searchFiltersTemplates)) {
			throw new SICException("No se puede construir restricciones xq la lista de filtros de búsqueda está vacía...");
		}

		// Construir restricciones
		this.executeDynamicCriteriaRestriction(null, searchFiltersTemplates);

		// Retornar restricciones
		return this.dynamicCriteriaRestriction;
	}

}
