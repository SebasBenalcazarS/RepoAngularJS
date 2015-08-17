/**
 * 
 */
package ec.com.smx.sic.cliente.common;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author mbraganza
 *
 */
public interface IConfiguracionesBeans {

	IConfiguracionBean getConfiguracionBean(IValorConfiguracionBean... valorConfiguracion) throws SICException;
}
