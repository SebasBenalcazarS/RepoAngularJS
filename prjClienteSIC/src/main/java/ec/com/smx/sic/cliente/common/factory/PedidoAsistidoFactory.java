package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.servicio.pedidoAsistido.IAccionPedidoAsistidoServicio;
import ec.com.smx.sic.cliente.servicio.pedidoAsistido.IAlmacenamientoPedidoAsistidoServicio;
import ec.com.smx.sic.cliente.servicio.pedidoAsistido.ICalculoPedidoAsistidoServicio;
import ec.com.smx.sic.cliente.servicio.pedidoAsistido.IMigracionPedidoAsistidoServicio;
import ec.com.smx.sic.cliente.servicio.pedidoAsistido.IValidacionPedidoAsistidoServicio;

/**
 * 
 * @author amunoz
 *
 */
public class PedidoAsistidoFactory extends SICSpringContextFactory{
	
	/**
	 * 
	 * @return
	 */
	public IAccionPedidoAsistidoServicio getPedidoAsistidoAccionServicio(){
		return (IAccionPedidoAsistidoServicio) getBean(SICFactoryConstantes.PEDIDO_ASISTIDO_ACCION_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 */
	public IAlmacenamientoPedidoAsistidoServicio getPedidoAsistidoAlmacenamientoServicio(){
		return (IAlmacenamientoPedidoAsistidoServicio) getBean(SICFactoryConstantes.PEDIDO_ASISTIDO_ALMACENAMIENTO_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 */
	public ICalculoPedidoAsistidoServicio getPedidoAsistidoCalculoServicio(){
		return (ICalculoPedidoAsistidoServicio) getBean(SICFactoryConstantes.PEDIDO_ASISTIDO_CALCULO_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 */
	public IValidacionPedidoAsistidoServicio getPedidoAsistidoValidacionServicio(){
		return (IValidacionPedidoAsistidoServicio) getBean(SICFactoryConstantes.PEDIDO_ASISTIDO_VALIDACION_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 */
	public IMigracionPedidoAsistidoServicio getMigracionPedidoAsistidoServicio(){
		return(IMigracionPedidoAsistidoServicio) getBean(SICFactoryConstantes.PEDIDO_ASISTIDO_MIGRACION_SERVICIO);
	}
}
