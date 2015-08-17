/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.pedidoAsistido.calculo;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ConfiguracionBloqueoPedidoVO;

/**
 * @author bsandoval
 *
 */
public interface IObtencionDatosConfiguracionBloqueoPedidoGestor {
	
	/**
	 * 
	 * @param configuracionBloqueo
	 * @throws SICException
	 */
	public void buscarConfiguracionBloqueo(ConfiguracionBloqueoPedidoVO configuracionBloqueo) throws SICException;
	

}
