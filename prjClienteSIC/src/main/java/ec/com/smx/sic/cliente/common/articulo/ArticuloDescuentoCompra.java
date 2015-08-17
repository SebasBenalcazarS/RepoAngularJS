/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

/**
 * @author gaortiz
 * 
 */
@SuppressWarnings("serial")
public abstract class ArticuloDescuentoCompra implements Serializable{

	private Map<String, Object> dynamicProperties;

	/**
	 * 
	 * @return
	 */
	public abstract String getNombreDescuento();

	/**
	 * 
	 * @return
	 */
	public abstract Object getValorDescuento();	

	/**
	 * 
	 * @param valorDescuento
	 */
	public abstract void setValorDescuento(Object valorDescuento);
	
	/**
	 * 
	 * @return
	 */
	public abstract Integer getCodigoDescuento();
	
	/**
	 * 
	 */
	public abstract void setCodigoDescuento(Integer codigoDescuento);

	/**
	 * 
	 * @return
	 */
	public abstract Double getCostoNetoParcial();

	/**
	 * 
	 * @return
	 */
	public abstract SearchDTO getDescuentoDTO();
	
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public <T> void addDynamicProperty(String name, T value) {
		if (this.dynamicProperties == null) {
			this.dynamicProperties = new HashMap<String, Object>();
		}
		this.dynamicProperties.put(name, value);
	}
	
	/**
	 * 
	 * @param name
	 * @param classValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final <T> T getDynamicProperty(String name, Class<T> classValue) {
		if (this.dynamicProperties == null) {
			return null;
		}
		return (T) this.dynamicProperties.get(name);
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public final Object getDynamicProperty(String name){
		if (this.dynamicProperties == null) {
			return null;
		}
		return this.dynamicProperties.get(name);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public final Boolean hasDynamicProperty(String name) {
		if (this.dynamicProperties == null) {
			return Boolean.FALSE;
		}
		return Boolean.valueOf(this.dynamicProperties.containsKey(name));
	}

	/**
	 * 
	 * @param name
	 */
	public final void removeDynamicProperty(String name) {
		if (this.dynamicProperties != null)
			this.dynamicProperties.remove(name);
	}

	/**
	 * 
	 * @return
	 */
	public final Map<String, Object> getDynamicProperties() {
		return this.dynamicProperties;
	}

	/**
	 * 
	 * @param dynamicProperties
	 */
	public final void setDynamicProperties(Map<String, Object> dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}

}
