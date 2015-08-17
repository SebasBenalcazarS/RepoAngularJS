/**
 * 
 */
package ec.com.smx.sic.cliente.common;

import org.slf4j.Logger;

import ec.com.kruger.utilitario.loggin.KLogFactory;
import ec.com.kruger.utilitario.loggin.resources.LogUtilMessages;

/**
 * @author fmunoz
 *
 */
public interface Logeable {
	public Logger LOG_SICV2 = KLogFactory.getLog(LogUtilMessages.getInstancia().getString("log.sistema.MAX"));
	public Logger LOG_SAC = KLogFactory.getLog(LogUtilMessages.getInstancia().getString("log.sistema.SAC"));

}
