/**
 * 
 */
package ec.com.smx.sic.cliente.common.search.bean;

import java.io.Serializable;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public class ListFilter<T> implements Serializable {
	
	@ComparatorTypeField
	private T value;
	private Boolean showLinkToList;
	private Boolean allowCleaning;
	
	
	public ListFilter(T value, Boolean showLinkToList, Boolean allowCleaning) {
		this.value = value;
		this.showLinkToList = showLinkToList;
		this.allowCleaning = allowCleaning;
	}
	
	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}
	/**
	 * @return the showLinkToList
	 */
	public Boolean getShowLinkToList() {
		return showLinkToList;
	}
	/**
	 * @param showLinkToList the showLinkToList to set
	 */
	public void setShowLinkToList(Boolean showLinkToList) {
		this.showLinkToList = showLinkToList;
	}
	/**
	 * @return the allowCleaning
	 */
	public Boolean getAllowCleaning() {
		return allowCleaning;
	}
	/**
	 * @param allowCleaning the allowCleaning to set
	 */
	public void setAllowCleaning(Boolean allowCleaning) {
		this.allowCleaning = allowCleaning;
	}

}
