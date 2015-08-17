/**
 * 
 */
package ec.com.smx.sic.cliente.common;

import java.util.Map;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author mbraganza
 *
 */
public abstract class ConfiguracionesBeansBase implements IConfiguracionesBeans {

	private Map<String, IConfiguracionBean> configuracion;

	
	
	/**
	 * @param configuracion the configuracion to set
	 */
	public void setConfiguracion(Map<String, IConfiguracionBean> configuracion) {
		this.configuracion = configuracion;
	}



	public IConfiguracionBean getConfiguracionBean(String claveConfiguracion) throws SICException{
		return this.configuracion.get(claveConfiguracion);
	}

}
