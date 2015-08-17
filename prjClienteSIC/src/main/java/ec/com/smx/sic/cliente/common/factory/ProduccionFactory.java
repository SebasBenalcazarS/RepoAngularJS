package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.servicio.produccion.ILineasEmpaqueServicio;

public class ProduccionFactory extends SICSpringContextFactory{
	
	/**
	 * Obtiene una referencia del servicio IProduccionServicio
	 * @return Un IProduccionServicio
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public ILineasEmpaqueServicio getLineasEmpaqueServicio() throws SICException{
		return (ILineasEmpaqueServicio) getBean(SICFactoryConstantes.PRODUCCION_ADMINISTRACION_LINEAS_EMPAQUE_SERVICIOS);
	}
	
}
