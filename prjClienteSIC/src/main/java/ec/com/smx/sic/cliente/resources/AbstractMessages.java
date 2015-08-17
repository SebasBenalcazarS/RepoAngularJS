/**
 * 
 */
package ec.com.smx.sic.cliente.resources;

import java.text.MessageFormat;
import java.util.MissingResourceException;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;



/**
 * @author mbraganza
 *
 */
public abstract class AbstractMessages {
	
	private Resource resource;
	
	/**
	 * 
	 * @param resource
	 */
	protected void setResource(Resource resource){
		this.resource = resource;
	}
	
	/**
	 * Recupera una valor del archivo de propiedades dado la clave
	 * @param key
	 * @return	String
	 */
	public String getString(String key) {
		try {
			return this.resource.getResourceBundle().getString(key);
		} catch (MissingResourceException e) {
			throw new SICException("propiedad: " + key + " no existente en " + this.getClass().getName());
		}
	}
	
	
	/**
	 * Permite la obtenci�n del valor de la clave del archivo de propiedades general con la asignaci�n de los par�metros
	 * @param  key							- Clave del archivo de propiedades que se desea obtener
	 * @param  parameters					- Par�metros del mensaje
	 * @return								- Valor de la clave ingresada
	 * @throws MissingResourceException
	 */
	public  String getString(String key, Object[] parameters){
		try {
			return MessageFormat.format(this.resource.getResourceBundle().getString(key), parameters);
		} catch (MissingResourceException e) {
			throw new SICException("propiedad: " + key + " no existente en " + this.getClass().getName());
		}
	}
	

	/**
	 * Recupera una valor entero del archivo de propiedades dado la clave
	 * @param key
	 * @return Integer
	 */
	public Integer getInteger(String key) {
		return Integer.valueOf(getString(key));
	}
	
	/**
	 * Recupera una valor lonf del archivo de propiedades dado la clave
	 * @param key
	 * @return Long
	 */
	public Long getLong(Long key) {
		return Long.valueOf(getLong(key));
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public Boolean getBoolean(String key){
		String value;
		
		value = getString(key);
		
		if (BooleanUtils.isTrue(SICConstantes.getInstancia().esActivo(value))){
			return Boolean.TRUE;
		}
		return Boolean.valueOf(value);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public Character getCharacter(String key){
		String valor = getString(key);
		
		if (StringUtils.isNotEmpty(valor)){
			return valor.charAt(0);
		}
		
		return Character.MIN_VALUE;
	}
}
