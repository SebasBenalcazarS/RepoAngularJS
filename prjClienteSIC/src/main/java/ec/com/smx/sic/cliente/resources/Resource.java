/**
 * 
 */
package ec.com.smx.sic.cliente.resources;

import java.util.Locale;
import java.util.ResourceBundle;

import ec.com.smx.framework.common.util.EnvironmentUtil;
import ec.com.smx.sic.cliente.common.OSValidator;

/**
 * @author Mario Braganza
 *
 */
public class Resource {
	
	private ResourceBundle resourceBundle;
	private Locale locale;
	private String resourceBundleName;
	
	/**
	 * 
	 * @param resourceBundleName
	 */
	public Resource(String resourceBundleName){
		this.resourceBundleName = resourceBundleName;
		this.locale = this.getEnvironment();
		this.resourceBundle = ResourceBundle.getBundle(this.resourceBundleName, this.locale);
	}
	
	/**
	 * @return the resourceBundle
	 */
	public final ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	/**
	 * 
	 * @return
	 */
	private Locale getEnvironment(){
		Locale locale = null;
		String env = EnvironmentUtil.getCurrentEnvironment();
		
		if (env.equals(EnvironmentUtil.CONSOLA)) {
			locale = new Locale("con");
		} else if (env.equals(EnvironmentUtil.DESARROLLO)) {
			locale = new Locale("des");
		} else if (env.equals(EnvironmentUtil.PRUEBAS)) {
			if(OSValidator.isWindows()){
				locale = new Locale("pru","win");
			}
			else if(OSValidator.isUnix()){
				locale = new Locale("pru","uni");
			}
		} else if (env.equals(EnvironmentUtil.PRODUCCION)) {
			if(OSValidator.isWindows()){
				locale = new Locale("pro","win");
			}
			else if(OSValidator.isUnix()){
				locale = new Locale("pro","uni");
			}
			
		}
		return locale;
	}
}
