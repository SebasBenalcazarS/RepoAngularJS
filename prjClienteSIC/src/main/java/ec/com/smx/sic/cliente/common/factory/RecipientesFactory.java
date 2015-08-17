package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.servicio.recipientes.ICanjeRecipientesServicio;
import ec.com.smx.sic.cliente.servicio.recipientes.IEntregaRecipientesServicio;
import ec.com.smx.sic.cliente.servicio.recipientes.IImpresionRecipientesServicio;
import ec.com.smx.sic.cliente.servicio.recipientes.IRecipientesServicio;

/**
 * 
 * @author cherrera
 *
 */
public class RecipientesFactory extends SICSpringContextFactory{
	
	//Servicio para transferencias
	public IRecipientesServicio getRecipientesServicio(){
		return (IRecipientesServicio) getBean(SICFactoryConstantes.RECIPIENTES_SERVICIO);
	}
	//Servicio para canje de recipientes a proveedor en la bodega
	public ICanjeRecipientesServicio getCanjeRecipientesServicio(){
			return (ICanjeRecipientesServicio) getBean(SICFactoryConstantes.CANJE_RECIPIENTES_SERVICIO);
	}
	//Servicio para la entrega de recipientes a proveedor en la bodega
		public IEntregaRecipientesServicio getEntregaRecipientesServicio(){
				return (IEntregaRecipientesServicio) getBean(SICFactoryConstantes.ENTREGA_RECIPIENTES_SERVICIO);
		}
	//Servicio para la impresion
	public IImpresionRecipientesServicio getImpresionRecipientesServicio(){
			return (IImpresionRecipientesServicio) getBean(SICFactoryConstantes.IMPRESION_RECIPIENTES_SERVICIO);
	}	
}
