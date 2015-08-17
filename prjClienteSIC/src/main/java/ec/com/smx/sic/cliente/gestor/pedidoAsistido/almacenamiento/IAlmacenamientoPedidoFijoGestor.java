/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.pedidoAsistido.almacenamiento;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.PedidoFijoVO;

/**
 * @author bsandoval
 *
 */
public interface IAlmacenamientoPedidoFijoGestor extends Serializable {
	
	public void crearPedidoFijo(PedidoFijoVO pedidoFijo) throws SICException;
	
	public void inactivarPedidoFijo(PedidoFijoVO pedidoFijoVO)throws SICException;

}
