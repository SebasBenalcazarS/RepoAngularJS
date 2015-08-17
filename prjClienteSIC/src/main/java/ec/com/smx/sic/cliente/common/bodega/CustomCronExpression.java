package ec.com.smx.sic.cliente.common.bodega;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import org.quartz.CronExpression;
public class CustomCronExpression {
private ConcurrentHashMap<String, CronExpression> cronExpressions;
	
	/**
	 * 
	 */
	public CustomCronExpression(){
		this.cronExpressions = new ConcurrentHashMap<String, CronExpression>();
	}
	
	/**
	 * 
	 * @param cronExpression
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public boolean isSatisfiedBy(String expression, Date date) throws ParseException{
		CronExpression cronExpression;
		
		try {
			cronExpression = this.cronExpressions.get(expression);
			if (cronExpression == null){
				cronExpression = new CronExpression(expression);
				this.cronExpressions.putIfAbsent(expression, cronExpression);
			}
				
			return cronExpression.isSatisfiedBy(date);
		} finally {
			cronExpression = null;
		}
	}
	
	/**
	 * 
	 * @param expression
	 * @return
	 */
	public CronExpression getCronExpression(String expression){
		return this.cronExpressions.get(expression);
	}
	
	
	/**
	 * 
	 */
	public void clear(){
		if (this.cronExpressions != null){
			this.cronExpressions.clear();
		}
		this.cronExpressions = null;
	}

}
