/**
 * 
 */
package ec.com.smx.sic.cliente.common.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Mario Braganza
 *
 */
public class SICSpringContextFactory implements ApplicationContextAware{
	
	protected ApplicationContext applicationContext;
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

	/**
	 * 
	 * @param bean
	 * @return
	 * @throws SICException
	 */
	protected Object getBean(String bean) throws SICException{
		return applicationContext.getBean(bean);
	}
	
	protected<T> T getBean(String bean, Class<T> beanClass) throws SICException{
		return applicationContext.getBean(bean, beanClass);
	}
	
}
