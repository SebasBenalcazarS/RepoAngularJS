package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.servicio.cambioprecios.IAdministracionCambioPreciosServicio;
import ec.com.smx.sic.cliente.servicio.cambioprecios.IArchivoPlanoCambioPreciosServicio;
import ec.com.smx.sic.cliente.servicio.cambioprecios.IArticuloCambioPreciosServicio;
import ec.com.smx.sic.cliente.servicio.cambioprecios.IAsistidoCambioPreciosServicio;
import ec.com.smx.sic.cliente.servicio.cambioprecios.IAccionHistorialCambioPreciosServicio;
import ec.com.smx.sic.cliente.servicio.cambioprecios.IAccionMigracionCambioPreciosServicio;
import ec.com.smx.sic.cliente.servicio.cambioprecios.IPlantillaCambioPreciosServicio;

public class CambioPreciosFactory extends SICSpringContextFactory {
	
	/**
	 * 
	 * @return 
	 * @return
	 * @throws SICException
	 */
	public IAdministracionCambioPreciosServicio getAdministracionCambioPreciosServicio() throws SICException{
		return (IAdministracionCambioPreciosServicio) getBean(SICFactoryConstantes.CAMBIO_PRECIOS_ADMINISTRACION_SERVICIO);
	}

	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IAsistidoCambioPreciosServicio getAsistidoCambioPreciosServicio() throws SICException{
		return (IAsistidoCambioPreciosServicio) getBean(SICFactoryConstantes.CAMBIO_PRECIOS_ASISTIDO_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IArchivoPlanoCambioPreciosServicio getArchivoPlanoCambioPreciosServicio() throws SICException{
		return (IArchivoPlanoCambioPreciosServicio) getBean(SICFactoryConstantes.CAMBIO_PRECIOS_ARCHIVO_PLANO_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IPlantillaCambioPreciosServicio getPlantillaCambioPreciosServicio() throws SICException{
		return (IPlantillaCambioPreciosServicio) getBean(SICFactoryConstantes.CAMBIO_PRECIOS_PLANTILLA_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IArticuloCambioPreciosServicio getArticuloCambioPreciosServicio() throws SICException {
		return (IArticuloCambioPreciosServicio) getBean(SICFactoryConstantes.CAMBIO_PRECIOS_ARTICULO_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IAccionMigracionCambioPreciosServicio getAccionMigracionCambioPreciosServicio() throws SICException {
		return (IAccionMigracionCambioPreciosServicio) getBean(SICFactoryConstantes.MIGRACION_CAMBIO_PRECIOS_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IAccionHistorialCambioPreciosServicio getAccionHistorialCambioPreciosServicio() throws SICException {
		return (IAccionHistorialCambioPreciosServicio) getBean(SICFactoryConstantes.HISTORIAL_CAMBIO_PRECIOS_SERVICIO);
	}
}
