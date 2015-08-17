package ec.com.smx.sic.cliente.common.factory;

import ec.com.kruger.utilitario.dao.commons.service.DataService;
import ec.com.smx.framework.ad.factory.ServicioDatosFactoryConstantes;
import ec.com.smx.framework.ad.services.ServicioDatosS;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.servicio.administracion.ILogProcesosMigracionServicio;
import ec.com.smx.sic.cliente.servicio.administracion.IParametroServicio;
import ec.com.smx.sic.cliente.servicio.datosCorporativos.IDatosCorporativosServicio;
import ec.com.smx.sic.cliente.servicio.datosCorporativos.IProcesoServicio;
import ec.com.smx.sic.cliente.servicio.envioMail.IEnvioMailServicio;
import ec.com.smx.sic.cliente.servicio.tareaprogramada.ITareaProgramadaServicio;

public class AdministracionFactory extends SICSpringContextFactory {

	public DataService getDataService() throws SICException {
		return (DataService) getBean(SICFactoryConstantes.SERVICE_DATA);
	}
	
	public IParametroServicio getParametroService() throws SICException {
		return (IParametroServicio) getBean(SICFactoryConstantes.ADMIN_PARAMETROSERVICIO);
	}
	
	public ServicioDatosS getExtendedDataService() throws SICException{
		return (ServicioDatosS) getBean(ServicioDatosFactoryConstantes.SERVICIO_ACCESO_DATOS);
	}
	
	public ITareaProgramadaServicio getTareaProgramadaService() throws SICException{
		return (ITareaProgramadaServicio) getBean(SICFactoryConstantes.ADMIN_TAREAPROGRAMADASERVICIO);
	}
	
	public IDatosCorporativosServicio getDatosCorporativosService() throws SICException{
		return (IDatosCorporativosServicio) getBean(SICFactoryConstantes.ADMIN_DATOSCORPORATIVOS_SERVICIO);
	}
	
	public IProcesoServicio getProcesoService() throws SICException{
		return (IProcesoServicio) getBean(SICFactoryConstantes.ADMIN_PROCESO_SERVICIO);
	}
	
	public IEnvioMailServicio getEnvioMailServicio() throws SICException{
		return (IEnvioMailServicio) getBean(SICFactoryConstantes.ADMIN_ENVIOMAIL);
	}
	public ILogProcesosMigracionServicio getLogProcesosMigracionServicio(){
		return (ILogProcesosMigracionServicio) getBean(SICFactoryConstantes.LOG_PROCESOS_MIGRACION_SERVICIO);
	}
}
