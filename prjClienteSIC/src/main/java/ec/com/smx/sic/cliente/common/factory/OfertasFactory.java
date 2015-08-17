package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.servicio.ofertas.IAdministracionOfertasServicio;
import ec.com.smx.sic.cliente.servicio.ofertas.IArticuloOfertasServicio;

/**
 * @author gnolivos
 *
 */
public class OfertasFactory extends SICSpringContextFactory{
	
	/**
	 * 
	 * @return 
	 * @return
	 * @throws SICException
	 */
	public IAdministracionOfertasServicio getAdministracionOfertasServicio() throws SICException{
		return (IAdministracionOfertasServicio) getBean(SICFactoryConstantes.OFERTAS_ADMINISTRACION_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IArticuloOfertasServicio getArticuloOfertasServicio() throws SICException {
		return (IArticuloOfertasServicio) getBean(SICFactoryConstantes.OFERTAS_ARTICULO_SERVICIO);
	}
}
