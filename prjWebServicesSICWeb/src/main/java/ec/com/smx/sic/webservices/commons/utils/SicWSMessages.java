package ec.com.smx.sic.webservices.commons.utils;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.framework.common.util.EnvironmentUtil;
import ec.com.smx.sic.cliente.common.Logeable;

/**
 * @author aecaiza
 * 
 */
public class SicWSMessages {
	private static final String BUNDLE_NAME = "ec.com.smx.sic.webservices.commons.resources.sicws";
	private static ResourceBundle resourceBundle;

	static {
		String environment = EnvironmentUtil.getCurrentEnvironment();
		String bundleName = "";
		
		try {
			StringUtils.equals(environment,EnvironmentUtil.CONSOLA);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Método: static SicWSMessages", e);
		}
		
		if (StringUtils.equals(environment,EnvironmentUtil.CONSOLA)) {
			bundleName = "con";
		} else if (environment.equals(EnvironmentUtil.DESARROLLO)) {
			bundleName = "des";
		} else if (environment.equals(EnvironmentUtil.PRUEBAS)) {
			bundleName = "pru";
		} else if (environment.equals(EnvironmentUtil.PRODUCCION)) {
			bundleName = "pro";
		}

		resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, new Locale(bundleName));
	}
	
	/**
	 * Permite obtener un valor string (key)
	 * 
	 * @param key
	 * @throws MissingResourceException
	 */
	public static String getString(String key) throws MissingResourceException {
		return resourceBundle.getString(key);
	}

	/**
	 * Permite obtener un valor Integer (key)
	 * 
	 * @param key
	 * @throws MissingResourceException
	 */
	public static Integer getInteger(String key)
			throws MissingResourceException {
		return Integer.valueOf(resourceBundle.getString(key));
	}
}