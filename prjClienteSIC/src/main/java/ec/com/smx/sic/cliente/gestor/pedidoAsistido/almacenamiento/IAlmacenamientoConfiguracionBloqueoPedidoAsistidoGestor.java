package ec.com.smx.sic.cliente.gestor.pedidoAsistido.almacenamiento;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ConfiguracionBloqueoPedidoVO;

/**
 * @author bsandoval
 *
 */
public interface IAlmacenamientoConfiguracionBloqueoPedidoAsistidoGestor extends Serializable{
	
	/**
	 * 
	 * @param configuracionBloqueoPedidoAsistidoVO
	 * @throws SICException
	 */
	public void modificarConfiguracionBloqueoPedidoAsistido(ConfiguracionBloqueoPedidoVO configuracionBloqueoPedidoAsistidoVO) throws SICException;

	
}
