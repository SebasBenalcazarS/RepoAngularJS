/**
 * 
 */
package ec.com.smx.sic.cliente.common.search.bean;

import java.io.Serializable;

import ec.com.kruger.utilitario.dao.commons.dto.ISearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Mario Braganza
 * 
 * @author Luis Yacchirema
 * 
 */
public interface ISearchTemplateBusiness<TEMPLATE extends ISearchDTO> extends Serializable {

	/**
	 * @param searchTemplate
	 * @param searchFilterTemplate
	 * @param dynamicCriteriaRestriction
	 * @throws SICException
	 */
	void buildSearchTemplate(TEMPLATE searchTemplate, ISearchTemplate searchFilterTemplate, DynamicCriteriaRestriction dynamicCriteriaRestriction) throws SICException;

}
