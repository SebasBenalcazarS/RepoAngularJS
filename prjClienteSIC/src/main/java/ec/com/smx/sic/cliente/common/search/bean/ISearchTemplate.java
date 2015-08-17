/**
 * 
 */
package ec.com.smx.sic.cliente.common.search.bean;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.constants.BooleanClauseEnum;

/**
 * @author Mario Braganza
 *
 */
public interface ISearchTemplate extends Serializable {
	
	String getClassName();

	Integer getCodigoCompania();

	void setCodigoCompania(Integer codigoCompania);
	
	Collection<Field> obtainFieldsFilterType();
	
	Boolean existsFilters();
	
	BooleanClauseEnum getBooleanClauseEnum();
}
