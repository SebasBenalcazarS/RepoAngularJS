package ec.com.smx.sic.cliente.gestor.pedidoAsistido.almacenamiento;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ConfiguracionPedidoAsistidoVO;

/**
 * @author aguato
 *
 */
public interface IAlmacenamientoConfiguracionPedidoAsistidoGestor extends Serializable{

	/**
	 * 
	 * @param configuracionPedidoAsistidoVO
	 * @throws SICException
	 */
	public void crearConfiguracionPedidoAsistido(ConfiguracionPedidoAsistidoVO configuracionPedidoAsistidoVO) throws SICException;
	
	/**
	 * 
	 * @param configuracionPedidoAsistidoVO
	 * @throws SICException
	 */
	public void modificarConfiguracionPedidoAsistido(ConfiguracionPedidoAsistidoVO configuracionPedidoAsistidoVO) throws SICException;
}
