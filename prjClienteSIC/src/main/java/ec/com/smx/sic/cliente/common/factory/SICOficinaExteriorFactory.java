/**
 * 
 */
package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.servicio.oficinaexterior.IDatosOficinaExteriorServicio;
import ec.com.smx.sic.cliente.servicio.oficinaexterior.IOficinaExteriorServicio;
import ec.com.smx.sic.cliente.servicio.oficinaexterior.IProveedorOficinaExteriorServicio;
import ec.com.smx.sic.cliente.servicio.oficinaexterior.IValidacionOficinaExteriorServicio;

/**
 * @author Mario Braganza
 *
 */
public class SICOficinaExteriorFactory extends SICSpringContextFactory {

	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IValidacionOficinaExteriorServicio getValidacionOficinaExteriorServicio() throws SICException{
		return (IValidacionOficinaExteriorServicio) getBean(SICFactoryConstantes.OFICINA_EXTERIOR_VALIDACION_SERVICIOS);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IDatosOficinaExteriorServicio getDatosOficinaExteriorServicio() throws SICException{
		return (IDatosOficinaExteriorServicio) getBean(SICFactoryConstantes.OFICINA_EXTERIOR_DATOS_SERVICIOS);
	}
	
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IOficinaExteriorServicio getOficinaExteriorServicio() throws SICException{
		return (IOficinaExteriorServicio) getBean(SICFactoryConstantes.OFICIAN_EXTERIOR_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IProveedorOficinaExteriorServicio getProveedorOficinaExteriorServicio()throws SICException{
		return (IProveedorOficinaExteriorServicio) getBean(SICFactoryConstantes.PROVEEDOR_OFICIAN_EXTERIOR_SERVICIO);
	}
}
