package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.common.recargacupon.IPushUtil;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.servicio.recargacupon.IClienteCuponServicio;
import ec.com.smx.sic.cliente.servicio.recargacupon.IContenidoServicio;
import ec.com.smx.sic.cliente.servicio.recargacupon.IConvenioCuponServicio;
import ec.com.smx.sic.cliente.servicio.recargacupon.ICuponServicio;
import ec.com.smx.sic.cliente.servicio.recargacupon.IEnvioCuponServicio;
import ec.com.smx.sic.cliente.servicio.recargacupon.IListaServicio;
import ec.com.smx.sic.cliente.servicio.recargacupon.IRegistroCorporativoServicio;
import ec.com.smx.sic.cliente.servicio.recargacupon.ITareaProgramadaServicio;

public final class RecargaCuponFactory extends SICSpringContextFactory {

	public IClienteCuponServicio getClienteCuponService() throws SICException {
		return (IClienteCuponServicio) getBean(SICFactoryConstantes.CLIENTE_CUPON_SERVICE);
	}

	public IEnvioCuponServicio getEnvioCuponService() throws SICException {
		return (IEnvioCuponServicio) getBean(SICFactoryConstantes.ENVIOCUPON_SERVICE);
	}

	public ICuponServicio getCuponServicio() throws SICException{
		return (ICuponServicio) getBean(SICFactoryConstantes.CUPON_SERVICE);
	}
	
	public ITareaProgramadaServicio getTareaProgramadaService() throws SICException{
		return (ITareaProgramadaServicio) getBean(SICFactoryConstantes.TAREAPROGRAMADA_RECARGA_CUPON_SERVICE);
	}
	
	public IRegistroCorporativoServicio getRegitroCorporativoService() throws SICException{
		return (IRegistroCorporativoServicio) getBean(SICFactoryConstantes.REGISTROCORPORATIVO_SERVICE);
	}
	
	public IListaServicio getListaService() throws SICException{
		return (IListaServicio) getBean(SICFactoryConstantes.LISTA_SERVICE);
	}
	
	public IPushUtil getPushUtil() throws SICException{
		return getBean(SICFactoryConstantes.PUSH_TASK,IPushUtil.class);
	}
	
	public IConvenioCuponServicio getConvenioCuponServicie() throws SICException{
		return (IConvenioCuponServicio) getBean(SICFactoryConstantes.CONVENIO_CUPON_SERVICE);
	}
	
	public IContenidoServicio getContenidoService() throws SICException{
		return (IContenidoServicio) getBean(SICFactoryConstantes.CONTENIDO_SERVICE);
	}
	
}
