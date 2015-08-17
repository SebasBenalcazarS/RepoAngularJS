/**
 * 
 */
package ec.com.smx.sic.cliente.common.factory;

import ec.com.kruger.utilitario.dao.commons.service.DataService;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.servicio.controlRutas.IAdministracionFurgonServicio;
import ec.com.smx.sic.cliente.servicio.controlRutas.IAdministracionGuiasServicio;
import ec.com.smx.sic.cliente.servicio.controlRutas.IAdministracionTransporteServicio;
import ec.com.smx.sic.cliente.servicio.controlRutas.IAdministracionTransportistaServicio;
import ec.com.smx.sic.cliente.servicio.controlRutas.IMonitoreoRutaServicio;

/**
 * @author egudino
 *
 */
public class ControlRutasFactory extends SICSpringContextFactory {

	/**
	 * Este metodo devuelve los servicios del utilitarioDao
	 * @return
	 * @throws SICException
	 */
	public DataService getControlRutasDaoServicio () throws SICException{
		try {
			return (DataService)getBean(SICFactoryConstantes.SERVICE_DATA);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error(e.toString());
			throw new SICException(e);
		}
	}
	
	/**
	 * Este metodo devuelve los servicios de control de rutas
	 * @return
	 * @throws SICException
	 */
	public IAdministracionTransporteServicio getAdministracionTransporteServicio () throws SICException{
		try {
			return (IAdministracionTransporteServicio)getBean(SICFactoryConstantes.ADMIN_TRANSPORTE_SERVICIO);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error(e.toString());
			throw new SICException(e);
		}
	}	
	
	/**
	 * Este metodo devuelve los servicios de administracion de furgones
	 * @return
	 * @throws SICException
	 */
	public IAdministracionFurgonServicio getAdministracionFurgonServicio () throws SICException{
		try {
			return (IAdministracionFurgonServicio)getBean(SICFactoryConstantes.ADMIN_FURGON_SERVICIO);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error(e.toString());
			throw new SICException(e);
		}
	}	
	
	/**
	 * Este metodo devuelve los servicios de administracion de transportistas
	 * @return
	 * @throws SICException
	 */
	public IAdministracionTransportistaServicio getAdministracionTransportistaServicio () throws SICException{
		try {
			return (IAdministracionTransportistaServicio)getBean(SICFactoryConstantes.ADMIN_TRANSPORTISTA_SERVICIO);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error(e.toString());
			throw new SICException(e);
		}
	}
	
	/**
	 * Este metodo devuelve los servicios de administracion de guias
	 * @return
	 * @throws SICException
	 */
	public IAdministracionGuiasServicio getAdministracionGuiasServicio () throws SICException{
		try {
			return (IAdministracionGuiasServicio)getBean(SICFactoryConstantes.ADMIN_GUIAS_SERVICIO);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error(e.toString());
			throw new SICException(e);
		}
	}
	
	/**
	 * Este metodo devuelve los servicios de monitoreo de rutas
	 * @return
	 * @throws SICException
	 */
	public IMonitoreoRutaServicio getMonitoreoRutaServicio () throws SICException{
		try {
			return (IMonitoreoRutaServicio)getBean(SICFactoryConstantes.MONITORE_RUTA_SERVICIO);
		} catch (Exception e) {
			Logeable.LOG_SICV2.error(e.toString());
			throw new SICException(e);
		}
	}
}
