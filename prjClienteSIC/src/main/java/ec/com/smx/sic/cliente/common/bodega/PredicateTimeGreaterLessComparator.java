package ec.com.smx.sic.cliente.common.bodega;

import java.sql.Time;

import org.apache.commons.collections.Predicate;

import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;

public class PredicateTimeGreaterLessComparator implements Predicate {

	private Time timeSelected;
	
	ComparatorTypeEnum comparatorTypeEnum;
	
	public PredicateTimeGreaterLessComparator(ComparatorTypeEnum comparatorTypeEnum) {
		this.comparatorTypeEnum = comparatorTypeEnum;
	}
	
	@Override
	public boolean evaluate(Object paramObject) {
		
		Time time = (Time)  paramObject;
		
		if (timeSelected == null) {
			timeSelected = time;
		}
		
		if (comparatorTypeEnum.equals(ComparatorTypeEnum.GREATER_THAN_COMPARATOR)) {
			if (time.after(timeSelected)) {
				timeSelected = time;
			}
		} else if (comparatorTypeEnum.equals(ComparatorTypeEnum.LESS_THAN_COMPARATOR)) {
			if (time.before(timeSelected)) {
				timeSelected = time;
			}
		}
		return true;
	}

	/**
	 * @return the timeSelected
	 */
	public Time getTimeSelected() {
		return timeSelected;
	}

	/**
	 * @param timeSelected the timeSelected to set
	 */
	public void setTimeSelected(Time timeSelected) {
		this.timeSelected = timeSelected;
	}

}
