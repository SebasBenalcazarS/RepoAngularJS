package ec.com.smx.sic.cliente.common.search.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.ISearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 *
 */
public interface ISearchTemplateManager extends Serializable {
	
	/**
	 * @return
	 */
	Map<String, ISearchTemplateBusiness<ISearchDTO>> getSearchTemplatesBusiness();

	/**
	 * @param searchTemplateBusiness
	 */
	void setSearchTemplatesBusiness(Map<String, ISearchTemplateBusiness<ISearchDTO>> searchTemplatesBusiness);

	/**
	 * @param searchTemplateBase
	 * @param searchFiltersTemplates
	 * @throws SICException
	 */
	void buildSearchTemplateManager(ISearchDTO searchTemplateBase, Collection<ISearchTemplate> searchFiltersTemplates) throws SICException;

	/**
	 * @param searchFiltersTemplates
	 * @return
	 * @throws SICException
	 */
	DynamicCriteriaRestriction getDynamicCriteriaRestriction(Collection<ISearchTemplate> searchFiltersTemplates) throws SICException;

}