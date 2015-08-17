/**
 * 
 */
package ec.com.smx.sic.cliente.common.search.bean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ec.com.kruger.utilitario.dao.commons.constants.BooleanClauseEnum;
import ec.com.kruger.utilitario.dao.commons.dto.ISearchTemplateDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.smx.framework.common.util.ClasesUtil;
import ec.com.smx.framework.common.util.predicate.IsAPredicate.RelationType;
import ec.com.smx.sic.cliente.common.search.constant.SearchManagerConstants;

/**
 * @author Mario Braganza
 * @author Luis Yacchirema
 *
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseSearchTemplate implements ISearchTemplate {

	private Integer codigoCompania;
	private BooleanClauseEnum booleanClauseEnum;

	public BaseSearchTemplate() { }
	
	public BaseSearchTemplate(Integer codigoCompania){
		this.codigoCompania = codigoCompania;
		this.booleanClauseEnum = BooleanClauseEnum.AND;
	}

	@SuppressWarnings("rawtypes")
	private BooleanClauseEnum validateBooleanClauseEnum(BooleanClauseEnum booleanClauseEnum) {

		Object instance;
		Collection<Field> allFields;
		Collection<Field> fieldsWidthClauseEnum;

		try {

			// Inicializar variables
			instance = null;
			allFields = null;
			fieldsWidthClauseEnum = null; 

			// Obtiener todos los atributos de la clase tipo plantilla
			allFields = ClasesUtil.getAllDeclaredFields(this);

			// Existen atributos definidos en la clase
			if (CollectionUtils.isNotEmpty(allFields)) {

				fieldsWidthClauseEnum = new ArrayList<Field>();

				// Obtener los atributos tipo ISearchTemplateDTO que son utilizados como filtros y contienen el atributo BooleanClauseEnum
				fieldsWidthClauseEnum.addAll(ClasesUtil.getFieldsByTypeRelationship(this, RelationType.CHILD, ISearchTemplateDTO.class));

				// Obtener los atributos tipo BaseCriteriaRestriction que son utilizados como filtros y contienen el atributo BooleanClauseEnum
				fieldsWidthClauseEnum.addAll(ClasesUtil.getFieldsByTypeRelationship(this, RelationType.CHILD, BaseCriteriaRestriction.class));

				// Existen atributos con BooleanClauseEnum
				if (CollectionUtils.isNotEmpty(fieldsWidthClauseEnum)){

					// Verificar que exista al menos un filtro con el valor BooleanClauseEnum.OR
					for (Field currentField : fieldsWidthClauseEnum){

						// Valor del atributo
						instance = ClasesUtil.invocarMetodoGet(this, currentField.getName());

						if (instance != null) {
							// El atributo es de tipo ISearchTemplateDTO
							if (instance instanceof ISearchTemplateDTO
									&& BooleanClauseEnum.OR.equals(((SearchTemplateDTO)instance).getBooleanClauseEnum())){
								return ((SearchTemplateDTO)instance).getBooleanClauseEnum();
							}

							// El atributo es de tipo BaseCriteriaRestriction
							if (instance instanceof BaseCriteriaRestriction
									&& BooleanClauseEnum.OR.equals(((BaseCriteriaRestriction)instance).getBooleanClauseEnum())){
								return ((BaseCriteriaRestriction)instance).getBooleanClauseEnum();
							}							
						}
					}
				}

			}

			return booleanClauseEnum;			

		} finally {			
			instance = null;
			allFields = null;
			fieldsWidthClauseEnum = null;			
		}
	}

	public Collection<Field> obtainFieldsFilterType() {

		Collection<Field> allFields = null;
		Collection<Field> fieldsFilterType = null;

		// Obtiener todos los atributos de la clase tipo plantilla
		allFields = ClasesUtil.getAllDeclaredFields(this);

		// Existen atributos definidos en la clase 
		if (CollectionUtils.isNotEmpty(allFields)) {

			fieldsFilterType = new ArrayList<Field>();

			// Obtener los atributos tipo ISearchTemplateDTO que son utilizados como filtros
			fieldsFilterType.addAll(ClasesUtil.getFieldsByTypeRelationship(this, RelationType.CHILD, ISearchTemplateDTO.class));

			// Obtener los atributos anotados con @ComparatorTypeField que son utilizados como filtros
			fieldsFilterType.addAll(ClasesUtil.getFieldsByAnnotation(this, SearchManagerConstants.getInstance().SEARCH_ANNOTATION));
		}

		return fieldsFilterType;
	}

	public Boolean existsFilters(){

		Collection<Field> filtersFields;

		try {

			// Obtener atributos tipo filtro
			filtersFields = this.obtainFieldsFilterType();

			if (CollectionUtils.isNotEmpty(filtersFields)){
				// Verificar que exista al menos un filtro con un valor 
				for (Field currentField : filtersFields){
					if (ClasesUtil.isNotEmpty(ClasesUtil.invocarMetodoGet(this, currentField.getName()), SearchManagerConstants.getInstance().NOT_EMPTY_PREDICATES)){
						return Boolean.TRUE;
					}
				}

			}

			return Boolean.FALSE;
		} finally {
			filtersFields = null;
		}
	}

	public Integer getCodigoCompania(){
		return this.codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania){
		this.codigoCompania = codigoCompania;
	}

	public String getClassName() {
		return this.getClass().getName();
	}

	public BooleanClauseEnum getBooleanClauseEnum() {	
		return validateBooleanClauseEnum(this.booleanClauseEnum);
	}
}