package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.servicio.recibidonocontabilizado.IRecibidoNoContabilizadoServicio;
import ec.com.smx.sic.cliente.servicio.recibidonocontabilizado.IReporteRecibidoNoCotejadoServicio;
import ec.com.smx.sic.cliente.servicio.recibidonocontabilizado.IRetencionesServicio;

public class RecibidoNoContabilizadoFactory extends SICSpringContextFactory {
	public IRecibidoNoContabilizadoServicio getRecibidoNoFacturadoServicio() throws SICException{
		return (IRecibidoNoContabilizadoServicio) getBean(SICFactoryConstantes.RECIBIDO_NO_CONTABILIZADO_SERVICIOS);
	}
	
	public IRetencionesServicio getRetencionesServicio() throws SICException{
		return (IRetencionesServicio) getBean(SICFactoryConstantes.RETENCIONES_SERVICIOS);
	}
	
	public IReporteRecibidoNoCotejadoServicio getReporteRecibidoNoCotejadoServicio() throws SICException{
		return (IReporteRecibidoNoCotejadoServicio) getBean(SICFactoryConstantes.RECIBIDO_NO_COTEJADO_REPORTE_SERVICIOS);
	}
}
